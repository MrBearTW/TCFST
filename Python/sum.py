'''
# 1.做家法
def sum(n1,n2):
    total= n1 + n2
    return total

def sum(n1,n2,n3):
    total=n1+n2+n3
    return total

# print(sum(10,20))
print(sum(10,20,30))

# 不允許多載，重複名稱後面會蓋掉前面
'''

'''
# 計算有幾個數字??
def sum(*n):
    total=0
    for i in n:
        total+=1
    return total

print(sum(10,20))
print(sum(10,20,30))
print(sum(10,20,30,40))
'''

# 一次印出兩個參數
def account(AID,PWD):
    return{'AID_show':AID,'PWD_show':PWD}

params = {'AID':'Mary','PWD':'P@ssW0rd'}

print(account(**params))
