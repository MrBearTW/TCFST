import pandas
df = pandas.read_json('nobel_winners.json')    # df = dataframe

#print(df.columns)    # 印出欄位
#print(df.index)    # 印出a.reshape([2,2,2])
#print(df.head())    # 印出前五筆

df =df.set_index('name')
print(df.loc['Albert Einstein'])

# iloc ix兩種基本上是差不多
#print(df.iloc[0])    # 第一筆資料
#print(df.ix[0])