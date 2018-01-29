x = 5566    #模組變數

def fun():
    #global x    #強迫成為模組變數
    x = 9487    #函式變數
    print(x)

fun()
print(x)

# fun內的函式變數x和模組變數x存在的範圍不同