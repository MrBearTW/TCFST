import pandas as pd
from io import StringIO

df = pd.read_csv('data.csv',names=['name','age'],skipinitialspace=True)
#print(df)

df.to_csv('data_new.csv',encoding='UTF-8')
'''data_new.csv長成下面那樣
,name,age
0,AAA,55
1,BBB,66
2,CCC,94
3,DDD,87
'''

data = "'EEE'|'11' \n 'FFF'|'22'"
df2 = pd.read_csv(StringIO(data),sep='|',names=['name','age'],skipinitialspace=True,quotechar="'")
print(df2)