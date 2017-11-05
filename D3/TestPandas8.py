import pandas as pd

df = pd.read_csv('num.csv')

print(df.iloc[1:,0]+df.iloc[1:,1])

s = pd.Series(df.iloc[:, 0] + df.iloc[:, 1], name='SUM')

df2 = pd.concat([df, s], axis=1)

#print(df2)
