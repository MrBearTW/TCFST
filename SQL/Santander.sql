select  *  -- AVG["age"]
from Santander.dbo.train_ver2
where ["ncodpers"]<1364293
  ;


select ["ncodpers"], ["age"]  
from Santander.dbo.train_ver2
  where ["ncodpers"]='1373447'
  ;

select ["ncodpers"], ["age"] ,["renta"] 
from Santander.dbo.train_ver2
where  ["renta"] ='0'
  ;

select * 
from Santander.dbo.train_ver2
where  ["ind_ahor_fin_ult1"] !='0'
  ;