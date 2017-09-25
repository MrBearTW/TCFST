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
        return "name:{0},number:{1},balance:{2}".format(self.__name,self.__number,self.__balance)
        #return 'Account類別的__str__'
    #設計當Getter
    @property 
    def name(self):
        return self.__name
    @property
    def number(self):
        return self.__number
    @property
    def balance(self):
        return self.__balance
    #設計當Setter
    @name.setter 
    def name(self,name):
        self.__name = name
    @number.setter
    def number(self,number):
        self.__number = number
    @balance.setter
    def balance(self, balance):
        if balance <= 0:
            print('值不得小於等於0')
        else:
            self.__balance = balance
# 類別結束
    
# 模組啟始

# 模組結束