import bank6

acc = bank6.Account('ABC','1222-0001',1000)
print(acc)

acc.deposit(100)
acc.withdraw(10)
print(acc)

#acc.__balance = 0;
#acc.__name = 'DEF'

acc.balance = -10
print('戶名：', acc.name)
print('帳號：', acc.number)
print('餘額：', acc.balance)
#print(acc.test)


acc1 = bank6.Account.default('DEF','1222-0002')
print('戶名：', acc1.name)
print('帳號：', acc1.number)
print('餘額：', acc1.balance)

