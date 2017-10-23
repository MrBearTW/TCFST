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
import csv

with open('nobel_winner2.csv','w',newline='\n')as f:
    fs = list(nobel_winners[0].keys())
    fs.sort()
    writer = csv.DictWriter(f,fieldnames=fs)
    writer.writeheader()
    for w in nobel_winners:
        writer.writerow(w)

with open('nobel_winner2.csv')as f:
    reader = csv.reader(f)
    for row in reader:
        print(row)
print('------第一個間隔------')
print(nobel_winners)
print('------第二個間隔------')
with open('nobel_winner2.csv')as f:
    reader = csv.DictReader(f)
    nobel_winners = list(reader)
print(nobel_winners)