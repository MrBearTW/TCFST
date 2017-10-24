from bs4 import BeautifulSoup
import requests

BASE_URL = 'https://en.wikipedia.org'
HEADERS = {'User-Agent':'Mozilla/5.0'}

def get_Nobel_soup():
    response = requests.get(BASE_URL+'/wiki/List_of_Nobel_laureates', headers=HEADERS)
    return BeautifulSoup(response.content, 'lxml')
def get_column_titles(table):
    cols = []
    for th in table.select_one('tr').select('th')[1:]:
        link = th.select_one('a')
        if link:
            cols.append({'name':link.text,'href':link.attrs['href']})
        else:
            cols.append({'name':th.text  ,'href':None})
    return cols
'''表頭
<table class="wikitable sortable">
<tr>
<th>Year</th>
<th width="18%"><a href="/wiki/List_of_Nobel_laureates_in_Physics" title="List of Nobel laureates in Physics">Physics</a></th>
<th width="16%"><a href="/wiki/List_of_Nobel_laureates_in_Chemistry" title="List of Nobel laureates in Chemistry">Chemistry</a></th>
<th width="18%"><a href="/wiki/List_of_Nobel_laureates_in_Physiology_or_Medicine" title="List of Nobel laureates in Physiology or Medicine">Physiology<br />
or Medicine</a></th>
<th width="16%"><a href="/wiki/List_of_Nobel_laureates_in_Literature" title="List of Nobel laureates in Literature">Literature</a></th>
<th width="16%"><a href="/wiki/List_of_Nobel_Peace_Prize_laureates" title="List of Nobel Peace Prize laureates">Peace</a></th>
<th width="15%"><a href="/wiki/List_of_Nobel_laureates_in_Economics" class="mw-redirect" title="List of Nobel laureates in Economics">Economics</a></th>
</tr>
'''
def get_Nobel_winners(table):
    cols = get_column_titles(table)
    winners = []
    for row in table.select('tr')[1:-1]:    # 去頭去尾
        if(row.select_one('td') != None and len(row.select_one('td').text) in [4,8]):    # 8是為了2016
            year = int(row.select_one('td').text[0:4])
            for i,td in enumerate(row.select('td')[1:]):    # enumerate枚舉 成對取出 前面會
                for winner in td.select('a'):
                    href = winner.attrs['href']
                    if not href.startswith('#endnote'):
                        winners.append({
                            'year':year,
                            'category':cols[i]['name'],
                            'name':winner.text,
                            'link':winner.attrs['href']
                        })
    return winners
'''
<tr>
<td align="center">1986</td>
<td><span class="sortkey">Ruska, Ernst</span><span class="vcard"><span class="fn"><a href="/wiki/Ernst_Ruska" title="Ernst Ruska">Ernst Ruska</a></span></span>;<br />
<span class="sortkey">Binnig, Gerd</span><span class="vcard"><span class="fn"><a href="/wiki/Gerd_Binnig" title="Gerd Binnig">Gerd Binnig</a></span></span>;<br />
<span class="sortkey">Rohrer, Heinrich</span><span class="vcard"><span class="fn"><a href="/wiki/Heinrich_Rohrer" title="Heinrich Rohrer">Heinrich Rohrer</a></span></span></td>
<td><span class="sortkey">Herschbach, Dudley R.</span><span class="vcard"><span class="fn"><a href="/wiki/Dudley_R._Herschbach" title="Dudley R. Herschbach">Dudley R. Herschbach</a></span></span>;<br />
<span class="sortkey">Lee, Yuan T.</span><span class="vcard"><span class="fn"><a href="/wiki/Yuan_T._Lee" title="Yuan T. Lee">Yuan T. Lee</a></span></span>;<br />
<span class="sortkey">Polanyi, John</span><span class="vcard"><span class="fn"><a href="/wiki/John_Polanyi" title="John Polanyi">John Polanyi</a></span></span></td>
<td><span class="sortkey">Cohen, Stanley</span><span class="vcard"><span class="fn"><a href="/wiki/Stanley_Cohen_(biochemist)" title="Stanley Cohen (biochemist)">Stanley Cohen</a></span></span>;<br />
<span class="sortkey">Levi-Montalcini, Rita</span><span class="vcard"><span class="fn"><a href="/wiki/Rita_Levi-Montalcini" title="Rita Levi-Montalcini">Rita Levi-Montalcini</a></span></span></td>
<td><span class="sortkey">Soyinka, Wole</span><span class="vcard"><span class="fn"><a href="/wiki/Wole_Soyinka" title="Wole Soyinka">Wole Soyinka</a></span></span></td>
<td><span class="sortkey">Wiesel, Elie</span><span class="vcard"><span class="fn"><a href="/wiki/Elie_Wiesel" title="Elie Wiesel">Elie Wiesel</a></span></span></td>
<td><span class="sortkey">Buchanan, James M.</span><span class="vcard"><span class="fn"><a href="/wiki/James_M._Buchanan" title="James M. Buchanan">James M. Buchanan</a></span></span></td>
</tr>

<tr>
<td align="center">2016<sup id="cite_ref-11" class="reference"><a href="#cite_note-11">[11]</a></sup></td>
<td><span class="sortkey">J. Thouless, David</span><span class="vcard"><span class="fn"><a href="/wiki/David_J._Thouless" title="David J. Thouless">David J. Thouless</a></span></span>;<br />
<span class="sortkey">Haldane, Duncan</span><span class="vcard"><span class="fn"><a href="/wiki/Duncan_Haldane" title="Duncan Haldane">Duncan Haldane</a></span></span>;<br />
<span class="sortkey">Kosterlitz, John M.</span><span class="vcard"><span class="fn"><a href="/wiki/John_M._Kosterlitz" class="mw-redirect" title="John M. Kosterlitz">John M. Kosterlitz</a></span></span></td>
<td><span class="sortkey">Sauvage, Jean-Pierre</span><span class="vcard"><span class="fn"><a href="/wiki/Jean-Pierre_Sauvage" title="Jean-Pierre Sauvage">Jean-Pierre Sauvage</a></span></span>;<br />
<span class="sortkey">Stoddart, Fraser</span><span class="vcard"><span class="fn"><a href="/wiki/Fraser_Stoddart" title="Fraser Stoddart">Fraser Stoddart</a></span></span>;<br />
<span class="sortkey">Feringa, Ben</span><span class="vcard"><span class="fn"><a href="/wiki/Ben_Feringa" title="Ben Feringa">Ben Feringa</a></span></span></td>
<td><span class="sortkey">Ohsumi, Yoshinori</span><span class="vcard"><span class="fn"><a href="/wiki/Yoshinori_Ohsumi" title="Yoshinori Ohsumi">Yoshinori Ohsumi</a></span></span></td>
<td><span class="sortkey">Dylan, Bob</span><span class="vcard"><span class="fn"><a href="/wiki/Bob_Dylan" title="Bob Dylan">Bob Dylan</a></span></span></td>
<td><span class="sortkey">Santos, Juan Manuel</span><span class="vcard"><span class="fn"><a href="/wiki/Juan_Manuel_Santos" title="Juan Manuel Santos">Juan Manuel Santos</a></span></span></td>
<td><span class="sortkey">Hart, Oliver</span><span class="vcard"><span class="fn"><a href="/wiki/Oliver_Hart_(economist)" title="Oliver Hart (economist)">Oliver Hart</a></span></span>;<br />
<span class="sortkey">Holmström, Bengt R.</span><span class="vcard"><span class="fn"><a href="/wiki/Bengt_R._Holmstr%C3%B6m" class="mw-redirect" title="Bengt R. Holmström">Bengt R. Holmström</a></span></span></td>
</tr>
'''

#http://192.168.56.1
#http://192.168.10.249
    
soup = get_Nobel_soup()

#print(soup.find('table',{'class':'wikitable sortable'}))
#print(soup.select('table.wikitable.sortable'))
#print(soup.select_one('table.wikitable.sortable').select('th'))
#print(get_column_titles(soup))
print(get_Nobel_winners(soup))