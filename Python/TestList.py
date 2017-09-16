
## list 清單  =  就是陣列
lists = [9,4,8,7,9,4,8,9]
print(lists)
print(lists[0])
print(lists[1])

lists.append(7)
print(lists)
print(lists[7])

## lists.remove(9)   ## 砍數值9，從前面開始找，不太精確的用法
del lists[2]      ## 砍位置
print(lists)

'''
del lists[9]
print(lists)
print(lists[0])
'''


## sets 集合
sets={9,4,8,7,5,6}
print(sets)
sets.add(1)
print(sets)
sets.remove(9)  #砍元素
print(sets)


## dict 字典
dicts = {'A':5566,'B':9487}
print(dicts)
dicts['C']=1000
print(dicts)
del dicts['B']
print(dicts)

## Tuple
tuples=(55,66,94,87,89)
print(tuples)
a,b,c,d,e=tuples
print('a'=,a)
print('e'=,e)

x=55
y=66
x,y=y,x
print('x',=x)
'''
JAVA 需要多一個變數才能做交換
x=55
y=66
x=z   此時x=55 y=66 z=55
x=y   此時x=66 y=66 z=55
y=z   此時x=66 y=55 z=55
'''


a,*b=[55,66,9,4]
print('a',=a)
print('b',=b)
# print(c)

d,*e,f=[55,66,9,4,8,7,9,4,1,1000]
print('d=',d)
print('e',=e)
print('f',=f)
