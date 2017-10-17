# 做查詢

from sqlalchemy import create_engine
from sqlalchemy import Column,Integer,String,Enum
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

engine = create_engine('sqlite:///nobel_prize.db', echo=True)
Base = declarative_base()

Session = sessionmaker(bind=engine)
session = Session()

class Winner(Base):
    __tablename__='winners'
    id  = Column(Integer, primary_key=True)
    name= Column(String)
    category = Column(String)
    year= Column(Integer)
    nationality = Column(String)
    sex = Column(Enum('male','female'))
    
    def __repr__(self):    # 要有寫出來的東西才會是人看
        return '<Winner(name=%s,category=%s,year=%s)>'%(self.name,self.category,self.year)
        
#print(session.query(Winner).count())    #算有幾筆
#print(session.query(Winner).all())    #全部印出來
#print(session.query(Winner).order_by('year').all())    #照年分排序
#print(session.query(Winner).filter_by(nationality='Swiss').all())    #查詢是用整個資料庫查，所以不在回應內容的也可以當作篩選條件，但印出來的還是只有__repr__選到的內容

#要查看ID請研究課本P.70範例3-4
#print(Winner.__repr__)