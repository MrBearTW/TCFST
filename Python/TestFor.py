nums = [9,4,8,7,5,6,1]  #List      append
nums1 = {9,4,8,7}       #Set       add
nums2 = (9,4,8,7)       #Tuple     產生之後就固定

for i in range(len(nums)):
    print(nums[i],end=' ')
    # i  0->5 
print('###')    # 停止end=' '


for i in range(0,2,1):        #第0到第1格  0<= 變數 <2
    print(nums[i])
    #print(nums[i],end=' ')

for i in nums:
    print(i,end=' ')
print('###')    # 停止end=' '

for i in range(len(nums)):
    print('nums[{0}]={1}'.format(i,nums[i]))


passwds = {'AAA':123,'BBB':456}
for ID,Pass in passwds.items():
    print(ID,Pass)