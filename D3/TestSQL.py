from sqlalchemy import create_engine
from sqlalchemy import Column,Integer,String,Enum
from sqlalchemy.ext.declarative import declarative_base

engine = create_engine('sqlite:///nobile_prize.db',echo=True)    # 沒有送出sql指令，只是讓sql做好準備
Base = declarative_base()

class Winner(Base):
    __tablename__='winners'
    id  = Column(Integer, primary_key=True)
    name = Column(String)
    category = Column(String)
    year = Column(Integer)
    nationality = Column(String)
    sex = Column(Enum('male','female'))

    def __repr__(self):
        return '<Winner(name={0$s},category={0$s},year={0$s})>'.format(self.name,self.category,self.year)

Base.metadata.create_all(engine)    # 建立表格Winner

# 要使用到Anaconda3內的python
# 指令要用這個 C:\ProgramData\Anaconda3\python TestSQL.py