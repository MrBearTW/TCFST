import pandas as pd
df = pd.read_json('nobel_winners.json')

df = df.groupby('category')
print(df.groups.keys())    # 看category有哪幾種

phy_group = df.get_group('Literature')
# print(phy_group.head())
print(phy_group.columns)

# print(phy_group.iloc[1])    #取筆數編號1
# print(phy_group.iloc[1:4])    #取筆數編號1~3

# print(phy_group.iloc[1,2])    #取筆數編號1  欄位編號2(就是country)
# print(phy_group.iloc[0:2,1:4])    #取筆數編號0~2  欄位編號1~3(就是 category country date_of_birth)
print(phy_group.iloc[:, 1:4])    #取全部的  欄位編號1~3
