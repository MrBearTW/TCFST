name ='JohnCena'

## 若end沒寫，自動視為換行/n   sep=預設是空白
print('hello',end=' ')
print(name)
print('Hello',name,'9487',sep=',')

## 各種帶入
print('{}除以{}是{}'.format(87,9,87/9))
print('{0}除以{1}是{2}'.format(87,9,87/9))
print('{n1}除以{n2}是{AAA}'.format(n1=87,n2=9,AAA=87/9))
print('帶入示範結束')

## 版面調整   
## %5d至少五位給整數缺的補零   %.2f<-兩位小數 
## {}佔位符號
print('{0:d}除以{1:d}是{2:f}'.format(87,9,87/9))
print('{0:3d}除以{1:3d}是{2:10.3f}'.format(87,9,87/9))
print('{0:<5d}除以{1:<5d}是{2:.2f}'.format(87,9,87/9))
print('{0:>5d}除以{1:>5d}是{2:.2f}'.format(87,9,87/9))
print('{0:-^5d}除以{1:-^5d}是{2:.2f}'.format(87,9,87/9))


names=['John','Peter','Jack']
print('所有名字:{n[0]},{n[1]},{n[2]}'.format(n=names))
passwords ={'AAA':123456,'BBB':9487}
print('AAA的密碼{p[AAA]}'.format(p=passwords))

'''
text='科'
len(text)
text.encode('UTF-8')
text.encode('Big5')

big5_imp1=text.encode('Big5')
type(big5_imp1)
big5_imp1.decode('Big5')
'''

text='安安你好'
print(text[0],text[2])