import sys,decimal;

d1 = decimal.Decimal('8.0')
d2 = decimal.Decimal('0.7')

print(d1+d2)
print(d1-d2)
print(d1*d2)
print(d1/d2)

## 有些程式語言decimal不能直接運算，要在用decimal內的方法才可以

from decimal import Decimal  # 不用再寫decimal.Decimal,寫Decimal即可

print(0.1)
print(format(0.1,'.17f'))  # 強迫印出小數點第17位
print(0.1+0.1)
print(0.1+0.1+0.1)
print(decimal.Decimal('0.1')==0.1)
print(Decimal('0.1')+Decimal('0.1')+Decimal('0.1'))
print(Decimal('0.1'+'0.1'+'0.1'))