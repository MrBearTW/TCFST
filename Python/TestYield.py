def xrange(n):
    x=0
    while x!=n:
        print('**********1')
        yield x                 # 跳到第14行
        print('Yield:',x)
        print('**********2')
        x+=1

print(type(xrange))             # function
print(type(xrange(10)))         # generator 一次一個  不是生一坨直接給  像是List

for n in xrange(3):
    print('For int',n)
