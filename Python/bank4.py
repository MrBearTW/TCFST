# 類別啟始
class Account:
    #建構子設計
    def __init__(self, name, number, balance):
        self.__name = name
        self.__number = number
        self.__balance = balance
    def deposit(self, amount):
        self.__balance += amount
    
    def withdraw(self, amount):
        self.__balance -= amount
        
    def __str__(self):
        #return 'Account類別的__str__'
        return "name:{0},number:{1},balance:{2}".format(self.__name,self.__number,self.__balance)
    @property #設計可以當Getter，無法當Setter
    def name(self):
        return self.__name
    @property
    def number(self):
        return self.__number
    @property
    def balance(self):
        return self.__balance
# 類別結束
    
# 模組啟始

# 模組結束