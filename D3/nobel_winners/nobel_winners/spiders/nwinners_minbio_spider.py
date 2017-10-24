import scrapy
import re

BASE_URL = 'http://en.wikipedia.org'


class NWinnerItemBio(scrapy.Item):
    name = scrapy.Field()
    link = scrapy.Field()
    mini_bio = scrapy.Field()
    image_urls = scrapy.Field()
    bio_image = scrapy.Field()
    images = scrapy.Field()


class NWinnerSpiderBio(scrapy.Spider):
    """ This spider uses Wikipedia's  Nobel laureates list to generate requests which scrape the winners' pages for basic biographical data """

    name = 'nwinners_minibio'
    allowed_domains = ['en.wikipedia.org']
    start_urls = [
        "http://en.wikipedia.org/wiki/List_of_Nobel_laureates_by_country"
    ]

    custom_settings = {'ITEM_PIPELINES' : {'nobel_winners.pipelines.NobelImagesPipeline':1}}
    
    def parse(self, response):
        filename = response.url.split('/')[-1]
        h2s = response.xpath('//h2')

        for h2 in h2s:
            country = h2.xpath('span[@class="mw-headline"]/text()').extract()
            if country:
                winners = h2.xpath('following-sibling::ol[1]')
                for w in winners.xpath('li'):
                    wdata = {}
                    wdata['link'] = BASE_URL + w.xpath('a/@href').extract()[0]
                    request = scrapy.Request(wdata['link'], callback=self.get_mini_bio, dont_filter=True)
                    request.meta['item'] = NWinnerItemBio(**wdata)
                    yield request
    def get_mini_bio(self,response):
        BASE_URL_ESCAPED = 'https:\/\/en.wikipedia.org'
        item = response.meta['item']
        item['image_urls'] =[]
        img_src = response.xpath('//table[contains(@class,"infobox")]//img/@src')
        if img_src:
            item['image_urls'] = ['https:'+img_src[0].extract()]
        mini_bio = ''
        ps = response.xpath('//*[@id="mw-content-text"]/p[text() or normalize-space(.)=""]').extract()
        
        for p in ps:
            if p == '<p></p>':
                break
            mini_bio += p
        
        mini_bio = mini_bio.replace('href="/wiki"', 'href="'+BASE_URL+'/wiki')
        mini_bio = mini_bio.replace('href="#"', 'href="'+item['link']+'#')
        item['mini_bio'] = mini_bio
        yield item
                    
                    
                    
    def parse_bio(self, response):
        item = response.meta['item']
        href = response.xpath("//li[@id='t-wikibase']/a/@href").extract()
        if href:
            # Wikipedia have changed the wikibase URL to include the 'https:' leader
            # url = 'https:' + href[0]
            url = href[0]
            request = scrapy.Request(url,\
                          callback=self.parse_wikidata,\
                          dont_filter=True)
            request.meta['item'] = item
            yield request

    def parse_wikidata(self, response):
        item = response.meta['item']
        property_codes = [
            {'name':'date_of_birth', 'code':'P569'},
            {'name':'date_of_death', 'code':'P570'},
            {'name':'place_of_birth', 'code':'P19', 'link':True},
            {'name':'place_of_death', 'code':'P20', 'link':True},
            {'name':'gender', 'code':'P21', 'link':True}
        ]

        p_template = '//*[@id="{code}"]/div[2]/div/div/div[2]' \
                     '/div[1]/div/div[2]/div[2]{link_html}/text()'

        for prop in property_codes:

            link_html = ''
            if prop.get('link'):
                link_html = '/a'
            sel = response.xpath(p_template.format(\
                code=prop['code'], link_html=link_html))
            if sel:
                item[prop['name']] = sel[0].extract()

        yield item



def get_persondata(table, item):
    fields = ['Date of birth', 'Place of birth', 'Date of death', 'Place of death']
    for tr in table.xpath('tr'):
        label = tr.xpath('td[@class="persondata-label"]/text()').extract()
        if label and label[0] in fields:
            text = ' '.join(tr.xpath('td[not(@class)]/descendant-or-self::text()').extract())
            print(text)
            item[label[0].lower().replace(' ', '_')] = text

def guess_gender(text, threshold=0):
    import re

    he = len(list(re.finditer(' he ', text)))
    she = len(list(re.finditer(' she ', text)))
    diff = she - he

    print('she %d, he %d, diff %d'%(she, he, diff))
    if diff > threshold:
        return 'female'
    elif diff < -threshold:
        return 'male'
    else:
        return None

def process_winner_li(w, country=None):
    """
    Process a winner's <li> tag, adding country of birth or nationality,
    as applicable.
    """
    wdata = {}
    # get the href link-adress from the <a> tag
    wdata['link'] = BASE_URL + w.xpath('a/@href').extract()[0]
    text = ' '.join(w.xpath('descendant-or-self::text()').extract())
    # we use the comma-delimited text-elements, stripping whitespace from
    # the ends.
    # split the text at the commas and take the first (name) string
    wdata['name'] = text.split(',')[0].strip()

    year = re.findall('\d{4}', text)
    if year:
        wdata['year'] = int(year[0])
    else:
        wdata['year'] = 0
        print('Oops, no year in ', text)

    category = re.findall(
            'Physics|Chemistry|Physiology or Medicine|Literature|Peace|Economics',
                text)
    if category:
        wdata['category'] = category[0]
    else:
        wdata['category'] = ''
        print('Oops, no category in ', text)

    if country:
        if text.find('*') != -1:
            wdata['country'] = ''
            wdata['born_in'] = country
        else:
            wdata['country'] = country
            wdata['born_in'] = ''

    # store a copy of the link's text-string for any manual corrections
    wdata['text'] = text
    return wdata
