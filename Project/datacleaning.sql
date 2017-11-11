--利用Java或Python換掉第一行欄位名稱
--Date,Customer_Code,Employee_Index,Residence,Sex,age,Open_Date,New_Cust,Seniority,Primary,Primary_Date,Type_beg,Customer_Relation,Residence_Index,Foreigner_Index,Spouse,Channel,Death_Index,Address_Type,Province_Code,Province_Name,Active_Index,Income,Segmentation,Saving_Acct,Guarantees,Current_Acct,Derivative_Acct,Payroll1_Acct,Particular_Account,Mas_particular_Account,Particular_Acct,Particular_Plus_Acct,Short_Deposits,Medium_Deposits,Long_Deposits,E_account,Funds,Mortgage,Pensions1,Loans,Taxes,Credit_Card,Securities,Home Account,Payroll2_Acct,Pensions2,Direct_Debit

--每格有幾種
-- MS SQL
SELECT COUNT(DISTINCT["fecha_dato"]),COUNT(DISTINCT["ncodpers"]),COUNT(DISTINCT["ind_empleado"]),COUNT(DISTINCT["pais_residencia"]),COUNT(DISTINCT["sexo"]),COUNT(DISTINCT["age"]),COUNT(DISTINCT["fecha_alta"]),COUNT(DISTINCT["ind_nuevo"]),COUNT(DISTINCT["antiguedad"]),COUNT(DISTINCT["indrel"]),COUNT(DISTINCT["ult_fec_cli_1t"]),COUNT(DISTINCT["indrel_1mes"]),COUNT(DISTINCT["tiprel_1mes"]),COUNT(DISTINCT["indresi"]),COUNT(DISTINCT["indext"]),COUNT(DISTINCT["conyuemp"]),COUNT(DISTINCT["canal_entrada"]),COUNT(DISTINCT["indfall"]),COUNT(DISTINCT["tipodom"]),COUNT(DISTINCT["cod_prov"]),COUNT(DISTINCT["nomprov"]),COUNT(DISTINCT["ind_actividad_cliente"]),COUNT(DISTINCT["renta"]),COUNT(DISTINCT["segmento"]),COUNT(DISTINCT["ind_ahor_fin_ult1"]),COUNT(DISTINCT["ind_aval_fin_ult1"]),COUNT(DISTINCT["ind_cco_fin_ult1"]),COUNT(DISTINCT["ind_cder_fin_ult1"]),COUNT(DISTINCT["ind_cno_fin_ult1"]),COUNT(DISTINCT["ind_ctju_fin_ult1"]),COUNT(DISTINCT["ind_ctma_fin_ult1"]),COUNT(DISTINCT["ind_ctop_fin_ult1"]),COUNT(DISTINCT["ind_ctpp_fin_ult1"]),COUNT(DISTINCT["ind_deco_fin_ult1"]),COUNT(DISTINCT["ind_deme_fin_ult1"]),COUNT(DISTINCT["ind_dela_fin_ult1"]),COUNT(DISTINCT["ind_ecue_fin_ult1"]),COUNT(DISTINCT["ind_fond_fin_ult1"]),COUNT(DISTINCT["ind_hip_fin_ult1"]),COUNT(DISTINCT["ind_plan_fin_ult1"]),COUNT(DISTINCT["ind_pres_fin_ult1"]),COUNT(DISTINCT["ind_reca_fin_ult1"]),COUNT(DISTINCT["ind_tjcr_fin_ult1"]),COUNT(DISTINCT["ind_valo_fin_ult1"]),COUNT(DISTINCT["ind_viv_fin_ult1"]),COUNT(DISTINCT["ind_nomina_ult1"]),COUNT(DISTINCT["ind_nom_pens_ult1"]),COUNT(DISTINCT["ind_recibo_ult1"])
FROM [master].[dbo].[train_ver22]

-- MSQL
SELECT COUNT(DISTINCT fecha_dato),COUNT(DISTINCT ncodpers),COUNT(DISTINCT ind_empleado),COUNT(DISTINCT pais_residencia),COUNT(DISTINCT sexo),COUNT(DISTINCT age),COUNT(DISTINCT fecha_alta),COUNT(DISTINCT ind_nuevo),COUNT(DISTINCT antiguedad),COUNT(DISTINCT indrel),COUNT(DISTINCT ult_fec_cli_1t),COUNT(DISTINCT indrel_1mes),COUNT(DISTINCT tiprel_1mes),COUNT(DISTINCT indresi),COUNT(DISTINCT indext),COUNT(DISTINCT conyuemp),COUNT(DISTINCT canal_entrada),COUNT(DISTINCT indfall),COUNT(DISTINCT tipodom),COUNT(DISTINCT cod_prov),COUNT(DISTINCT nomprov),COUNT(DISTINCT ind_actividad_cliente),COUNT(DISTINCT renta),COUNT(DISTINCT segmento),COUNT(DISTINCT ind_ahor_fin_ult1),COUNT(DISTINCT ind_aval_fin_ult1),COUNT(DISTINCT ind_cco_fin_ult1),COUNT(DISTINCT ind_cder_fin_ult1),COUNT(DISTINCT ind_cno_fin_ult1),COUNT(DISTINCT ind_ctju_fin_ult1),COUNT(DISTINCT ind_ctma_fin_ult1),COUNT(DISTINCT ind_ctop_fin_ult1),COUNT(DISTINCT ind_ctpp_fin_ult1),COUNT(DISTINCT ind_deco_fin_ult1),COUNT(DISTINCT ind_deme_fin_ult1),COUNT(DISTINCT ind_dela_fin_ult1),COUNT(DISTINCT ind_ecue_fin_ult1),COUNT(DISTINCT ind_fond_fin_ult1),COUNT(DISTINCT ind_hip_fin_ult1),COUNT(DISTINCT ind_plan_fin_ult1),COUNT(DISTINCT ind_pres_fin_ult1),COUNT(DISTINCT ind_reca_fin_ult1),COUNT(DISTINCT ind_tjcr_fin_ult1),COUNT(DISTINCT ind_valo_fin_ult1),COUNT(DISTINCT ind_viv_fin_ult1),COUNT(DISTINCT ind_nomina_ult1),COUNT(DISTINCT ind_nom_pens_ult1),COUNT(DISTINCT ind_recibo_ult1)
FROM santander.train_ver2;

/*
|                         17 |                   956645 |
     6 |                             119 |                    3 |
  121 |                       6757 |                         2 |
        258 |                      3 |                            224 |
                  5 |                           6 |                       3 |
                   3 |                        3 |                           163
|                       3 |                       2 |                       53 |
                      53 |                                     2 |
  520995 |                        4 |                                 2 |
                          2 |                                2 |
                 2 |                                2 |
        2 |                                 2 |
2 |                                 2 |                                 2 |
                            2 |                                 2 |
                    2 |                                 2 |
           2 |                                 2 |
   2 |                                 2 |                                 2 |
                               2 |                                2 |
                    2 |                                 2 |
          2 |
*/

--- My sql
SELECT COUNT(ncodpers) 
FROM santander.train_ver2;

SELECT COUNT(DISTINCT fecha_dato),COUNT(DISTINCT ncodpers),COUNT(DISTINCT ind_empleado),COUNT(DISTINCT pais_residencia),COUNT(DISTINCT sexo),COUNT(DISTINCT age),COUNT(DISTINCT fecha_alta),COUNT(DISTINCT ind_nuevo),COUNT(DISTINCT antiguedad),COUNT(DISTINCT indrel),COUNT(DISTINCT ult_fec_cli_1t),COUNT(DISTINCT indrel_1mes),COUNT(DISTINCT tiprel_1mes),COUNT(DISTINCT indresi),COUNT(DISTINCT indext),COUNT(DISTINCT conyuemp),COUNT(DISTINCT canal_entrada),COUNT(DISTINCT indfall),COUNT(DISTINCT tipodom),COUNT(DISTINCT cod_prov),COUNT(DISTINCT nomprov),COUNT(DISTINCT ind_actividad_cliente),COUNT(DISTINCT renta),COUNT(DISTINCT segmento),COUNT(DISTINCT ind_ahor_fin_ult1),COUNT(DISTINCT ind_aval_fin_ult1),COUNT(DISTINCT ind_cco_fin_ult1),COUNT(DISTINCT ind_cder_fin_ult1),COUNT(DISTINCT ind_cno_fin_ult1),COUNT(DISTINCT ind_ctju_fin_ult1),COUNT(DISTINCT ind_ctma_fin_ult1),COUNT(DISTINCT ind_ctop_fin_ult1),COUNT(DISTINCT ind_ctpp_fin_ult1),COUNT(DISTINCT ind_deco_fin_ult1),COUNT(DISTINCT ind_deme_fin_ult1),COUNT(DISTINCT ind_dela_fin_ult1),COUNT(DISTINCT ind_ecue_fin_ult1),COUNT(DISTINCT ind_fond_fin_ult1),COUNT(DISTINCT ind_hip_fin_ult1),COUNT(DISTINCT ind_plan_fin_ult1),COUNT(DISTINCT ind_pres_fin_ult1),COUNT(DISTINCT ind_reca_fin_ult1),COUNT(DISTINCT ind_tjcr_fin_ult1),COUNT(DISTINCT ind_valo_fin_ult1),COUNT(DISTINCT ind_viv_fin_ult1),COUNT(DISTINCT ind_nomina_ult1),COUNT(DISTINCT ind_nom_pens_ult1),COUNT(DISTINCT ind_recibo_ult1)
FROM santander.train_ver2;

SELECT avg(renta),max(renta),min(renta),std(renta),stddev(renta)
FROM santander.train_ver2;
-- 106764.87614173251	28894395.51	0	212674.5912153228	212674.5912153228*

SELECT avg(age),max(age),min(age),std(age),stddev(age)
FROM santander.train_ver2;
-- 40.0998	164	0	17.26271831291885	17.26271831291885
-- 0  91.87

SELECT avg(antiguedad),max(antiguedad),min(antiguedad),std(antiguedad),stddev(antiguedad)
FROM santander.train_ver2;
/*
+-----------------+-----------------+-----------------+-------------------+--------------------+
| avg(antiguedad) | max(antiguedad) | min(antiguedad) | std(antiguedad)   | stddev(antiguedad) |
+-----------------+-----------------+-----------------+-------------------+--------------------+
|         76.4363 |             256 |         -999999 | 1670.110464607706 |  1670.110464607706 |
+-----------------+-----------------+-----------------+-------------------+--------------------+
1 row in set (29.28 sec)
*/



SELECT *
FROM santander.train_ver2
where age > 120
order by age;
/*
164歲 116996  
127歲 851397   
117歲 188824 325471 
116歲 331313 332258 272469 299304  不只還有
*/



-- MS SQL 未改變資料型態時
SELECT *
FROM [master].[dbo].[train_ver22]
where convert(int,rtrim(ltrim(["age"])) )>= 164 and rtrim(ltrim(["age"]))<>'NA'
order by ["age"];


---NA處理  1050741 or 1051017  or 1051387 or 1048660
--mysql
select *  
FROM santander.train_ver2
where ncodpers = 1050741 or ncodpers =1051017 or ncodpers =1049406 or ncodpers =1051387 or ncodpers =1048660  ;

INTO OUTFILE 'C:\AppServ\MySQL\Uploads\mysqlresult.csv'
C:/Users/tcfst/Desktop/SantanderProductRecommendation

select *
FROM santander.train_ver2
where age = '0';
--27734筆

tipodom = '0';
--27735筆

cod_prov = '0';
--93591筆

ind_actividad_cliente = '0';
--7412124筆


--sqlserver
select *
FROM [master].[dbo].[train_ver22]
where ["ncodpers"] = 1050741 or ["ncodpers"] =1051017 or ["ncodpers"] =1049406 or ["ncodpers"] =1051387 or ["ncodpers"] =1048660 ;

select *
FROM [master].[dbo].[train_ver22]
where ["age"] = ' NA'    -- NA前面要有空白建
--27734筆

["tipodom"] = 'NA'    -- NA前面 沒有 空白建
--27735筆

["cod_prov"] ='NA'    -- NA前面 沒有 空白建
--93591筆

["ind_actividad_cliente"] ='NA'    -- NA前面 沒有 空白建
--27734筆



--處理27734資料MS_SQL

SELECT COUNT(DISTINCT fecha_dato),COUNT(DISTINCT ncodpers),COUNT(DISTINCT ind_empleado),COUNT(DISTINCT pais_residencia),COUNT(DISTINCT sexo),COUNT(DISTINCT age),COUNT(DISTINCT fecha_alta),COUNT(DISTINCT ind_nuevo),COUNT(DISTINCT antiguedad),COUNT(DISTINCT indrel),COUNT(DISTINCT ult_fec_cli_1t),COUNT(DISTINCT indrel_1mes),COUNT(DISTINCT tiprel_1mes),COUNT(DISTINCT indresi),COUNT(DISTINCT indext),COUNT(DISTINCT conyuemp),COUNT(DISTINCT canal_entrada),COUNT(DISTINCT indfall),COUNT(DISTINCT tipodom),COUNT(DISTINCT cod_prov),COUNT(DISTINCT nomprov),COUNT(DISTINCT ind_actividad_cliente),COUNT(DISTINCT renta),COUNT(DISTINCT segmento),COUNT(DISTINCT ind_ahor_fin_ult1),COUNT(DISTINCT ind_aval_fin_ult1),COUNT(DISTINCT ind_cco_fin_ult1),COUNT(DISTINCT ind_cder_fin_ult1),COUNT(DISTINCT ind_cno_fin_ult1),COUNT(DISTINCT ind_ctju_fin_ult1),COUNT(DISTINCT ind_ctma_fin_ult1),COUNT(DISTINCT ind_ctop_fin_ult1),COUNT(DISTINCT ind_ctpp_fin_ult1),COUNT(DISTINCT ind_deco_fin_ult1),COUNT(DISTINCT ind_deme_fin_ult1),COUNT(DISTINCT ind_dela_fin_ult1),COUNT(DISTINCT ind_ecue_fin_ult1),COUNT(DISTINCT ind_fond_fin_ult1),COUNT(DISTINCT ind_hip_fin_ult1),COUNT(DISTINCT ind_plan_fin_ult1),COUNT(DISTINCT ind_pres_fin_ult1),COUNT(DISTINCT ind_reca_fin_ult1),COUNT(DISTINCT ind_tjcr_fin_ult1),COUNT(DISTINCT ind_valo_fin_ult1),COUNT(DISTINCT ind_viv_fin_ult1),COUNT(DISTINCT ind_nomina_ult1),COUNT(DISTINCT ind_nom_pens_ult1),COUNT(DISTINCT ind_recibo_ult1)
FROM santander.train_ver2;
where ["age"] = ' NA' 
--6種日期  7340個ID



-- 以下是針對只有20150528那個月份的相關MS_SQL指令

-- 計算屬性欄位
SELECT ["indfall"], count(*) as indfall
FROM [master].[dbo].[ver0528]
group by ["indfall"]


-- 計算各個欄位的加總最大最小變異數  請搜尋 compute by sql

SELECT convert(int,["ind_ahor_fin_ult1"]) as ind_ahor_fin_ult1,
        convert(int,["ind_cco_fin_ult1"]) as ind_cco_fin_ult1
FROM [master].[dbo].[ver0528] 
ORDER BY ["ind_ahor_fin_ult1"] 
COMPUTE   SUM(convert(int,["ind_ahor_fin_ult1"]))
        , SUM(convert(int,["ind_cco_fin_ult1"]));


--- 選出canal_entrada怪怪不應該是數字的部分 MS_SQL指令
SELECT *
FROM [master].[dbo].[ver0528]
where ["canal_entrada"] in ('004','007','013','025')

