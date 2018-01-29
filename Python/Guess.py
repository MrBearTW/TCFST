import random
Number = random.randint(1,42)
UserNum = 0
n = int(1)

while UserNum != Number:    
    UserNum = int(input('你猜的數字是：'))
    if(UserNum > Number):
        print('第',n,'次猜，比謎底數字大，請猜小一點，你猜的數字是：',UserNum)
        n = n+1
    elif(UserNum < Number):
        print('第',n,'次猜，比謎底數字小，請猜大一點，你猜的數字是：',UserNum)
        n = n+1
print('第',n,'次猜，恭喜猜對，答案是：',Number)