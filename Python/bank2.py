# 類別啟始
class Account:
    #建構子設計
    def __init__(self, name, number, balance):
        self.name = name
        self.number = number
        self.balance = balance
    def deposit(self, amount):
        self.balance += amount
    
    def withdraw(self, amount):
        self.balance -= amount
        
    def __str__(self):
        #return 'Account類別的__str__'
        return "name:{0},number:{1},balance:{2}".format(self.name,self.number,self.balance)
# 類別結束
    
# 模組啟始

# 模組結束