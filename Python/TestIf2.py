score1 = int(input('請輸入英文成績:'))
score2 = int(input('請輸入數學成績:'))

if score1 >= 60 :
    if score2 >= 60 :
        print('情境1-英文及格數學及格')
    else:
        print('情境1-英文及格數學不及格')


if score1 >= 60 :
    if score2 >= 60 :
        print('情境2-英文及格數學及格')
else:
    print('情境2-英文不及格')



# 作業：判斷奇偶數