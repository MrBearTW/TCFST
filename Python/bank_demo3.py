import bank3

acc = bank3.Account('ABC','1222-0001',1000)
print(acc)

acc.deposit(100)
acc.withdraw(10)
print(acc)

#acc.__balance = 0;

#print('戶名：', acc.__name)
#print('帳號：', acc.__number)
#print('餘額：', acc.__balance)
#print(acc.test)