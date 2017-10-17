from pymongo import MongoClient

DB_NOBEL_PRIZE = 'nobel_prize'
COLL_WINNERS = 'winners'

def get_mongo_database(db_name,host='localhost',port=27017,username=None,password=None):
    if username and password:
        mongo_uri = 'mongodb://%s:%s@%s/%s'(username,password,host,db_name)
        conn = MongoClient(mongo_uri)
    else:
        conn = MongoClient(host,port)
    return conn[db_name]

def mongo_coll_to_dicts(dbname='test',collname='test',query={},del_id=True,**kw):    # **kw 大概就是參數同上
    db = get_mongo_database(dbname,**kw)
    
    #db[collname].remove({'name': 'Paul Dirac'})
    # 刪除資料    

    #db[collname].update({'nationality': 'Taiwan'},{'category': 'Chemistry', 'name': 'Marie Curie', 'nationality': 'Polish', 'sex': 'female', 'year': 1911})
    # 改資料{條件,更改成}
    
    #db[collname].insert({'category': 'Physics', 'name': 'Paul Dirac', 'nationality': 'British', 'sex': 'male', 'year': 1933})
    # 新增資料

    res = list(db[collname].find(query))
    if del_id:
        for r in res:
            r.pop('_id')
    return res
    
print(mongo_coll_to_dicts(DB_NOBEL_PRIZE,COLL_WINNERS))