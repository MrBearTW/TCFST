import Bank

acc=Bank.account('ABC','5566-9487',2017)
print(Bank.desc(acc))

Bank.deposit(acc, 25)
Bank.withrow(acc, 9)
print(Bank.desc(acc))
