def filter(predicate,names):
    print(type(predicate))
    result =[]
    for elem in names:
        if predicate(elem):
            result.append(elem)
    return result

def gt6(elem):
    return len(elem)>6
def lt5(elem):
    return len(elem)<5

names =['Taron Egerton','Colin Firth','John','Mark Strong']

print('大於6',filter(gt6,names))
print('小於5',filter(lt5,names))

## 再加一個等於六

