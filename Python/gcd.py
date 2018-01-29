def gcd(m,n):
    if n==0 :
        return m
    else:
        return gcd(n,m%n)

print('輸入兩個數字，求最大公因數：')

m=int(input('M='))
n=int(input('N='))

r=gcd(m,n)
if r ==1 :
    print('互質')
else:
    print('最大公因數:',r)