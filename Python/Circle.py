import decimal

r = decimal.Decimal(10)
PI = decimal.Decimal(3.1415926)
print('圓半徑:',r)
print('圓周長:',2*PI*r)    # 平方寫法 = 5 ** 2 =5的平方
print('圓面積:',PI*r*r)


x =1.0
y=x
print('x的ID=',id(x),'y的ID=',id(y))  #Java跑出來是一個#code
y=3.1415
print('x的ID=',id(x),'y的ID=',id(y))
x=x+8.7
print('x的ID=',id(x),'y的ID=',id(y))

z=[9,4,8,7]
print('z的ID=',id(z))
zz=z
print('z的ID=',id(z),'zz的ID=',id(zz))
zz[0]=5
print('z的ID=',id(z),'zz的ID=',id(zz))
print('z=',z,'zz=',zz)

m=[5,5,6,6]
n=[5,5,6,6]
print(m==n)
print(m is n) # Java中比較的是變數裡面的資料,Python每一個資料都是一個物件

o=[5,5,6,6]
p=o
print(o==p)
print(o is p) 