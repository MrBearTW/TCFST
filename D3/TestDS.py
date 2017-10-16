import dataset
db = dataset.connect('sqlite:///nobel_prize.db')

wtable = db['winners']
winners = wtable.find()
winners = list(winners)

print(winners)