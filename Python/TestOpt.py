import copy
print(2*3)
print(2**3)
print(2**256)

print(10/3)
print(10//3)
print(10//3.0)
print(10//3.0)

nums1= ['one','two']
nums2=['three','four']
print(nums1+nums2)
print(nums1*2)
print(nums1[0]+nums2[0])  ##要每一個相加的話就要寫迴圈

a=94
b=87
print(a>b)
print(a>=b)
print(a<b)
print(a<=b)
print(a==b)
print(a!=b)

c='ABC'
d='DEF'
print(c>d)
print(c>=d)
print(c<d)
print(c<=d)
print(c==d)
print(c!=d)

print(3&7)
print(3|7)
print(3^7)
print(~3)
print(bin(~3))
print(1<<2)  # 0001 << 2 ==0100
print(8>>3)  # 1000 >> 3 == 0001

admin = {'A','B'}
users = {'A','c','d','e'}
print(admin & users)
print(users - admin)
print(admin ^ users)
print(admin > users)
print(admin < users)


nums = ['A','B','C','D','E','F','G','H']
#       [0] [1] [2] [3] [4] [5] [6] [7]
nums1 = nums    # 真的複製 nums1 = copy.deepcopy(nums)，上面要加 import copy
print(nums[0:3])  #取第0到第2格(不含第3格)
print(nums[:2])
print(nums[2:])
print(nums[:-1])   #不取最後一格
print(nums[0:4])
print(nums[0:5:2])  #每2格取一格
print(nums[::2])
nums[1:4] = ['b','c','d']
print(nums)
print(nums1)