#類別開始
class Account:
    pass
#類別結束

#模組開始
def account(name,number,balance):
    acct=Account()
    acct.name=name
    acct.number=number
    acct.balance=balance
    return acct
    #return {'name':name,'number':number,'balance':balance}

def deposit(acct,amount):
    acct.balance += amount

def withrow(acct,amount):
    acct.balance -= amount

def desc(acct):
    return {'name':acct.name,'number':acct.number,'balance':acct.balance}
#模組結束