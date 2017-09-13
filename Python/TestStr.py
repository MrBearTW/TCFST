name ='JohnCena'

## 若end沒寫，自動是為換行，/n
print('hello',end=' ')
print(name)
print('Hello',name,'9487',sep=',')

## 各種帶入
print('{}除以{}是{}'.format(87,9,87/9))
print('{0}除以{1}是{2}'.format(87,9,87/9))
print('{n1}除以{n2}是{AAA}'.format(n1=87,n2=9,AAA=87/9))

## 版面調整
print('{0:d}除以{1:d}是{2:f}'.format(87,9,87/9))
print('{0:3d}除以{1:3d}是{2:10.3f}'.format(87,9,87/9))
print('{0:<5d}除以{1:<5d}是{2:.2f}'.format(87,9,87/9))
print('{0:>5d}除以{1:>5d}是{2:.2f}'.format(87,9,87/9))
print('{0:-^5d}除以{1:-^5d}是{2:.2f}'.format(87,9,87/9))

names=['John','Peter','Jack']
print('所有名字:{n[0]},{n[1]},{n[2]}'.format(n=names))
passwords ={'AAA':123456,'BBB':9487}
print('AAA的密碼{p[AAA]}'.format(p=passwords))