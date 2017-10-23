import requests
#reponse = requests.get('https://en.wikipedia.org/wiki/List_of_Nobel_laureates')    # http https 都可以
#reponse = requests.get('http://127.0.0.1:8080')   # 確認有alert的網頁可不可以傳會200

# 印出status_code
#print(reponse.status_code)

# 印出dir有哪一些
#print(dir(reponse))

#print(reponse.text)

#print(reponse.headers)


############## 抓PM2.5 ##############


reponse = requests.get('http://opendata2.epa.gov.tw/AQX.json')


print(reponse.status_code)
data = reponse.json()
print(type(data))

#print(data[0].keys())    # [0]是因為傳回來的是個List  有加
#print(reponse.text)


#for d in data:
#    if(d['County'] in ['高雄市','澎湖縣']):
#        print('縣市：','\t',d['County'],'\t','地點：','\t',d['SiteName'],'\t','PM2.5；','\t',d['PM2.5'],'\t','品質：','\t',d['Status'])