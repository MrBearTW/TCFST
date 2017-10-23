from bs4 import BeautifulSoup
import requests

BASE_URL = 'https://en.wikipedia.org'
HEADERS = {'User-Agent':'Mozilla/5.0'}

response = requests.get(BASE_URL+'/wiki/List_of_Nobel_laureates',headers=HEADERS)
soup = BeautifulSoup(response.content,'lxml')

print(soup.find('table',{'class':'wikitable sortable'}))