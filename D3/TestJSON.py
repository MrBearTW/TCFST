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
import json

with open('nobel_winner3.json','w')as f:
    json.dump(nobel_winners,f)    # 寫入
print(nobel_winners)

print("1間隔間隔間隔間隔間隔間隔")

with open('nobel_winner3.json')as f:
    nobel_winners=json.load(f)    # 從JSON讀入
print(nobel_winners)

#python 讀入是用dict方式讀入  要看JSON格式還是要直接開檔案看