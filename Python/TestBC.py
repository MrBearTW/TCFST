for i in range(0,10,1):
    if i==7:
        break
        #continue
    print(i)

score = int(input('請輸入成績：'))
if score >= 60:
    print('執行if後面這一行')
else:
    pass
print('執行Pass後面這一行')