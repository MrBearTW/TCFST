import bank2

acc = bank2.Account('ABC','1222-0001',1000)
print(acc)

acc.deposit(100)
acc.withdraw(10)
print(acc)

print('戶名：', acc.name)
print('帳號：', acc.number)
print('餘額：', acc.balance)
#print(acc.test)

#  http://192.168.3.156:8080