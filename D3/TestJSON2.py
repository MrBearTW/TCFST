import json
from datetime import date,datetime

def json_serial(obj):
    if isinstance(obj,(datetime,date)):
        return obj.isoformat()
    raise TypeError('Type is not seriqlize'% type(obj))
print(json.dumps(datetime.now(),default=json_serial))


# 懶惰寫法(不推薦)
# print(json.dumps(datetime.now().isoformat()))
# 可能會每遇到一次都執行，降低效能