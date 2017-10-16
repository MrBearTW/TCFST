import dataset
db = dataset.connect('sqlite:///nobel_prize.db')

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

with db as tx:
    for w in nobel_winners:
        tx['winners'].insert(w)

wtable = db['winners']
winners = wtable.find()
winners = list(winners)

print(winners)