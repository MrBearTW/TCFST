import pandas as pd
from pymongo import MongoClient

client = MongoClient()
db = client.nobel_prize
cursor = db.winner.find()

df = pd.DataFrame(list(cursor))
print(df)