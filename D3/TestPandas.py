import pandas
df = pandas.read_json('nobel_winners.json')    # df = dataframe

#print(df.columns)
#print(df.index)
#print(df.head())    # 印出前五筆

df =df.set_index('name')
#print(df.loc['Albert Einstein'])

# iloc ix兩種基本上是差不多
# print(df.iloc[0])
print(df.ix[0])