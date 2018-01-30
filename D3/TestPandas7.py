import pandas as pd

df = pd.read_csv('data.csv',names=['name','age'],skipinitialspace=True)

s= pd.Series([2017,2016,2015,2014],name='Year')
df=pd.concat([df,s],axis=1)    # 附加在每一橫列的後面

print(df)
