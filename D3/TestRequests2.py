import requests
reponse = requests.get('http://stats.oecd.org/sdmx-json/data/QNA/AUS+AUT.GDP+B1_GE.CUR+VOBARSA.Q/all?startTime=2009-Q2&endTime=2016-Q4')

#print(reponse.status_code)
#print(dir(reponse))
#print(reponse.text)

if reponse.status_code == 200 :
    data = reponse.json()
    print(data.keys())
    print(type(data))