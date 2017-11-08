-- CSV import to SQL

--trim record
update train_ver2 set ncodpers=rtrim(ltrim(ncodpers))

--allter table santander
alter table train_ver2 alter column fecha_dato nchar(10) null
alter table train_ver2 alter column ncodpers nchar(10) null
alter table train_ver2 alter column ind_empleado nchar(1) null
alter table train_ver2 alter column pais_residencia nchar(2) null
alter table train_ver2 alter column sexo nchar(1) null
alter table train_ver2 alter column age nchar(3) null
alter table train_ver2 alter column fecha_alta nchar(10) null
alter table train_ver2 alter column ind_nuevo nchar(2) null 
alter table train_ver2 alter column antiguedad nchar(10) null
alter table train_ver2 alter column indrel nchar(2) null
alter table train_ver2 alter column ult_fec_cli_1t nchar(10) null
alter table train_ver2 alter column indrel_1mes nchar(1) null
alter table train_ver2 alter column tiprel_1mes nchar(1) null
alter table train_ver2 alter column indresi nchar(1) null
alter table train_ver2 alter column indext nchar(1) null
alter table train_ver2 alter column conyuemp nchar(1) null
alter table train_ver2 alter column canal_entrada nchar(3) null
alter table train_ver2 alter column indfall nchar(1) null
alter table train_ver2 alter column tipodom nchar(2) null
alter table train_ver2 alter column cod_prov nchar(2) null
alter table train_ver2 alter column nomprov nchar(30) null
alter table train_ver2 alter column ind_actividad_cliente nchar(2) null
alter table train_ver2 alter column renta decimal(10,2) null
alter table train_ver2 alter column segmento nchar(30) null
alter table train_ver2 alter column ind_ahor_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_aval_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_cco_fin_ult1  nchar(2) null
alter table train_ver2 alter column ind_cder_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_cno_fin_ult1  nchar(2) null
alter table train_ver2 alter column ind_ctju_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_ctma_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_ctop_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_ctpp_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_deco_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_deme_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_dela_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_ecue_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_fond_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_hip_fin_ult1  nchar(2) null
alter table train_ver2 alter column ind_plan_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_pres_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_reca_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_tjcr_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_valo_fin_ult1 nchar(2) null
alter table train_ver2 alter column ind_viv_fin_ult1  nchar(2) null
alter table train_ver2 alter column ind_nomina_ult1   nchar(2) null
alter table train_ver2 alter column ind_nom_pens_ult1 nchar(2) null
alter table train_ver2 alter column ind_recibo_ult1   nchar(2) null

--Record summary by month
select substring(fecha_dato,1,7) as dataas,* into #temp1 from train_ver2_1
select dataas
      ,sum(ind_ahor_fin_ult1) as ind_ahor_fin_ult1
      ,sum(ind_aval_fin_ult1) as ind_aval_fin_ult1
      ,sum(ind_cco_fin_ult1) as ind_cco_fin_ult1
      ,sum(ind_cder_fin_ult1) as ind_cder_fin_ult1
      ,sum(ind_cno_fin_ult1) as ind_cno_fin_ult1
      ,sum(ind_ctju_fin_ult1) as ind_ctju_fin_ult1
      ,sum(ind_ctma_fin_ult1) as ind_ctma_fin_ult1
      ,sum(ind_ctop_fin_ult1) as ind_ctop_fin_ult1
      ,sum(ind_ctpp_fin_ult1) as ind_ctpp_fin_ult1
      ,sum(ind_deco_fin_ult1) as ind_deco_fin_ult1
      ,sum(ind_deme_fin_ult1) as ind_deme_fin_ult1
      ,sum(ind_dela_fin_ult1) as ind_dela_fin_ult1
      ,sum(ind_ecue_fin_ult1) as ind_ecue_fin_ult1
      ,sum(ind_fond_fin_ult1) as ind_fond_fin_ult1
      ,sum(ind_hip_fin_ult1) as ind_hip_fin_ult1
      ,sum(ind_plan_fin_ult1) as ind_plan_fin_ult1
      ,sum(ind_pres_fin_ult1) as ind_pres_fin_ult1
      ,sum(ind_reca_fin_ult1) as ind_reca_fin_ult1
      ,sum(ind_tjcr_fin_ult1) as ind_tjcr_fin_ult1
      ,sum(ind_valo_fin_ult1) as ind_valo_fin_ult1
      ,sum(ind_viv_fin_ult1) as ind_viv_fin_ult1
      ,sum(ind_nomina_ult1) as ind_nomina_ult1
      ,sum(ind_nom_pens_ult1) as ind_nom_pens_ult1
      ,sum(ind_recibo_ult1) as ind_recibo_ult1
into #temp2 from #temp1 group by dataas
select * from #temp2 order by dataas


--backup table
  use santander
  select * into train_ver2_1 from train_ver2
 --chg value
  update train_ver2_1 set ind_nomina_ult1=0 where ind_nomina_ult1=9
  update train_ver2_1 set ind_nom_pens_ult1=0 where ind_nom_pens_ult1=9

  --merge column 更特別戶 特別戶 Plus特別戶
  alter table train_ver2_1 add ind_cspec_fin_ult1 tinyint null
  update train_ver2_1 set ind_cspec_fin_ult1=1 where (ind_ctma_fin_ult1=1 or ind_ctop_fin_ult1=1 or ind_ctpp_fin_ult1=1)
 
  --merge column 短期定存戶 中期定存戶 長期定存戶
  alter table train_ver2_1 add ind_dspec_fin_ult1 tinyint null
  update train_ver2_1 set ind_dspec_fin_ult1=1 where (ind_deco_fin_ult1=1 or ind_deme_fin_ult1=1 or ind_dela_fin_ult1=1)
 
  --merge column 抵押貸款 貸款
  alter table train_ver2_1 add ind_pspec_fin_ult1 tinyint null
  update train_ver2_1 set ind_pspec_fin_ult1=1 where (ind_hip_fin_ult1=1 or ind_pres_fin_ult1=1 )
 
  --merge column 退休金 退休金2
  alter table train_ver2_1 add ind_nspec_fin_ult1 tinyint null
  update train_ver2_1 set ind_nspec_fin_ult1=1 where (ind_plan_fin_ult1=1 or ind_nom_pens_ult1=1 )
 
 
 --raw data generation raw_20171108
 select ncodpers
    ,sexo
    ,age
    ,ind_actividad_cliente
    ,antiguedad
    ,renta
    ,log(renta) as renta_log
    ,ind_ahor_fin_ult1
    ,ind_aval_fin_ult1
    ,ind_cco_fin_ult1
    ,ind_cder_fin_ult1
    ,ind_cno_fin_ult1
    ,ind_ctju_fin_ult1
    ,ind_ctma_fin_ult1
    ,ind_ctop_fin_ult1
    ,ind_ctpp_fin_ult1
    ,ind_deco_fin_ult1
    ,ind_deme_fin_ult1
    ,ind_dela_fin_ult1
    ,ind_ecue_fin_ult1
    ,ind_fond_fin_ult1
    ,ind_hip_fin_ult1
    ,ind_plan_fin_ult1
    ,ind_pres_fin_ult1
    ,ind_reca_fin_ult1
    ,ind_tjcr_fin_ult1
    ,ind_valo_fin_ult1
    ,ind_viv_fin_ult1
    ,ind_nomina_ult1
    ,ind_nom_pens_ult1
    ,ind_recibo_ult1
into #temp1
from santander.dbo.train_ver2
where fecha_dato='2016-05-28' and age>=18 and age <=80 and sexo<>'X'and age<>999 and antiguedad<>999 and ind_actividad_cliente<>9 and renta<>99999999.99

select ncodpers into #temp2
from #temp1
where (ind_ahor_fin_ult1=0 and ind_aval_fin_ult1=0 and ind_cco_fin_ult1=0 and 
		ind_cder_fin_ult1=0 and ind_cno_fin_ult1=0 and ind_ctju_fin_ult1=0 and ind_ctma_fin_ult1=0 and
		ind_ctop_fin_ult1=0 and ind_ctpp_fin_ult1=0 and ind_deco_fin_ult1=0 and ind_deme_fin_ult1=0 and
		ind_dela_fin_ult1=0 and ind_ecue_fin_ult1=0 and ind_fond_fin_ult1=0 and ind_hip_fin_ult1=0 and 
		ind_plan_fin_ult1=0 and ind_pres_fin_ult1=0 and ind_reca_fin_ult1=0 and ind_tjcr_fin_ult1=0 and 
		ind_valo_fin_ult1=0 and ind_viv_fin_ult1=0 and ind_nomina_ult1=0 and ind_nom_pens_ult1=0 and ind_recibo_ult1=0)  

select * into #temp3 from #temp1 where ncodpers not in (select ncodpers from #temp2)
select * into test1 from #temp3 
select * from dbo.test1
 
 

--clean log
alter database santander set RECOVERY simple

use santander
go
dbcc shrinkfile('santander_log',2)

alter database santander set recovery full


