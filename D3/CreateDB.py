import pandas as pd
import numpy as np
from pymongo import MongoClient


def clean_data(df):
    df = df.replace('', np.nan)
    df_born_in = df[df.born_in.notnull()] 
    df = df[df.born_in.isnull()]
    df = df.drop('born_in', axis=1) 
    df.drop(df[df.year == 1809].index, inplace=True) 
    df = df[~(df.name == 'Marie Curie')]
    df.loc[(df.name == u'Marie Sk\u0142odowska-Curie') & (df.year == 1911), 'country'] = 'France'
    df = df[~((df.name == 'Sidney Altman') & (df.year == 1990))]
    df = df.reindex(np.random.permutation(df.index)) 
    df = df.drop_duplicates(['name', 'year'])         
    df = df.sort_index()
    df.ix[df.name == 'Alexis Carrel', 'category'] = 'Physiology or Medicine' 
    df.ix[df.name == 'Ragnar Granit', 'gender'] = 'male'
    df = df[df.gender.notnull()] # remove institutional prizes
    df.ix[df.name == 'Hiroshi Amano', 'date_of_birth'] = '11 September 1960'
    df.date_of_birth = pd.to_datetime(df.date_of_birth) 
    df.date_of_death = pd.to_datetime(df.date_of_death, errors='coerce') 
    df['award_age'] = df.year - pd.DatetimeIndex(df.date_of_birth).year 
    df.date_of_death = [d.strftime('%Y-%m-%d') if not pd.isnull(d) else '' for d in df['date_of_death']]
    return df, df_born_in

def mongo_to_dataframe(db_name,collection,query={},host='localhost',port=27017,username=None,password=None,no_id=True):
    db = get_mongo_database(db_name,host,port,username,password)
    cursor = db[collection].find(query)
    df = pd.DataFrame(list(cursor))  
    if no_id:
        del df['_id']
    return df
    
def dataframe_to_mongo(df,db_name,collection,host='localhost',port=27017,username=None,password=None):
    db = get_mongo_database(db_name,host,port,username,password)
    records = df.to_dict('records')
    db[collection].insert(records)
    
def get_mongo_database(db_name,host='localhost',port=27017,username=None,password=None):
    if username and password:
        mongo_uri='mongodb://%s:%s@%s/%s'%(username,password,host,db_name)
        conn=MongoClient(mongo_uri)
    else:
        conn=MongoClient(host,port)
    return conn[db_name]

    
df = pd.read_json('nobel_winners.json')
df_clean, df_born_in = clean_data(df)
dataframe_to_mongo(df_clean,'nobel_prize','winners')
dataframe_to_mongo(df_born_in,'nobel_prize','winners_born_in')