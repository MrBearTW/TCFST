import dataset
db =dataset.connect('sqlite:///nobel_prize.db')
#print( list(db['winners'].find()) )
print( list(db['winners'].find(year=1911)) )