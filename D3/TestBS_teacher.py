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
    
    
soup = get_Nobel_soup()

#print(soup.find('table',{'class':'wikitable sortable'}))
#print(soup.select('table.wikitable.sortable'))
#print(soup.select_one('table.wikitable.sortable').select('th'))
print(get_column_titles(soup))