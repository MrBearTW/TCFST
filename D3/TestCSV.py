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

cols = list (nobel_winners[0].keys())  #3.0以上要寫List才能用sort功能
                                       #keys取出所有資料共同的欄位名稱-->cols就是標題欄
cols.sort()

with open('nobel_winner.csv','w')as f:    # as file
    f.write(','.join(cols)+"\n")  #欄位
    for o in nobel_winners:       #做每個欄位 o是一組大跨號{}中的內容
        row = [str(o[col]) for col in cols]
        f.write(','.join(row)+'\n')
        f.write(o[col]+','+'\n')
        #print(o)
        #print(o['category'],o['name'],o['nationality'])

with open('nobel_winner.csv')as f:
    for line in f.readlines():
        line = line.strip()    # 消除沒有使用CSV套件直接讀去所多產生的空格
        print(line)
f.close