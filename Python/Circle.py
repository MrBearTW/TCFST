import decimal

r = decimal.Decimal(10)
PI = decimal.Decimal(3.1415926)
print('圓半徑:',r)
print('圓周長:',2*PI*r)    # 平方寫法 = 5 ** 2 =5的平方
print('圓面積:',PI*r*r)


x =1.0
y=x
print('x1的ID=',id(x),'y1的ID=',id(y))    # 一樣   #Java跑出來是一個#code
y=3.1415
print('x2的ID=',id(x),'y2的ID=',id(y))
x=x+8.7
print('x3的ID=',id(x),'y3的ID=',id(y))

z=[9,4,8,7]
print('z1的ID=',id(z))
zz=z
zzz=z
print('z2的ID=',id(z),'zz2的ID=',id(zz))    # 一樣
print('z2=',z,'zz2=',zz)
zz[0]=5
print('z3的ID=',id(z),'zz3的ID=',id(zz),'zzz3的ID=',id(zzz))    #元素變了id還是一樣
print('z3=',z,'zz3=',zz,'zzz3=',zzz)    # [0]一起被改變

m=[5,5,6,6]
n=[5,5,6,6]
print(m==n)    #True    # 值一不一樣?
print(m is n)    #False    # 是一樣的物件嗎？   # Java中比較的是變數裡面的資料,Python每一個資料都是一個物件

o=[5,5,6,6]
p=o
print(o==p)    #True
print(o is p)    #True