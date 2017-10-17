import dataset
db =dataset.connect('sqlite:///nobel_prize.db')

wtable=db['winners']
wtable.drop()

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

with db as tx:    # 這樣變成:之下進行一組Transaction，確保全部都會執行
    for w in nobel_winners:
        tx['winners'].insert(w)

print( list(db['winners'].find()) )
