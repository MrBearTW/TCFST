from pymongo import MongoClient

DB_NOBEL_PRIZE = 'nobel_prize'
COLL_WINNERS = 'winners'

client = MongoClient()
db = client.nobel_prize
coll = db.winners

nobel_winners = [
{'category': 'Physics',
'name': 'Albert Einstein',
'nationality': 'Swiss',
'sex': 'male',
'year': 1921},
{'category': 'Physics',
'name': 'Paul Dirac',
'nationality': 'British',
'sex': 'male',
'year': 1933},
{'category': 'Chemistry',
'name': 'Marie Curie',
'nationality': 'Polish',
'sex': 'female',
'year': 1911}
]

#coll.insert(nobel_winners)    # 輸入資料

print(list(coll.find()))    # 查資料