try:
    nums = int(input('請輸入數字:'))
    print(nums+1)
except ValueError as err:
    print('數字You know!!')



'''
try:
    nums = int(input('請輸入數字：'))
    print(10/nums)
#except Exception as ex:
#    print('發生錯誤...')
#except ValueError as err:
    #print(err)
#    print('數值格式錯誤...')
except ArithmeticError as ae:
    print('數值運算錯誤...')
except ZeroDivisionError as ze:
    print('數值不得為零...')  
finally:
    print('一定會執行...')  
'''