

--每格有幾種
-- MS SQL
SELECT COUNT(DISTINCT["fecha_dato"]),COUNT(DISTINCT["ncodpers"]),COUNT(DISTINCT["ind_empleado"]),COUNT(DISTINCT["pais_residencia"]),COUNT(DISTINCT["sexo"]),COUNT(DISTINCT["age"]),COUNT(DISTINCT["fecha_alta"]),COUNT(DISTINCT["ind_nuevo"]),COUNT(DISTINCT["antiguedad"]),COUNT(DISTINCT["indrel"]),COUNT(DISTINCT["ult_fec_cli_1t"]),COUNT(DISTINCT["indrel_1mes"]),COUNT(DISTINCT["tiprel_1mes"]),COUNT(DISTINCT["indresi"]),COUNT(DISTINCT["indext"]),COUNT(DISTINCT["conyuemp"]),COUNT(DISTINCT["canal_entrada"]),COUNT(DISTINCT["indfall"]),COUNT(DISTINCT["tipodom"]),COUNT(DISTINCT["cod_prov"]),COUNT(DISTINCT["nomprov"]),COUNT(DISTINCT["ind_actividad_cliente"]),COUNT(DISTINCT["renta"]),COUNT(DISTINCT["segmento"]),COUNT(DISTINCT["ind_ahor_fin_ult1"]),COUNT(DISTINCT["ind_aval_fin_ult1"]),COUNT(DISTINCT["ind_cco_fin_ult1"]),COUNT(DISTINCT["ind_cder_fin_ult1"]),COUNT(DISTINCT["ind_cno_fin_ult1"]),COUNT(DISTINCT["ind_ctju_fin_ult1"]),COUNT(DISTINCT["ind_ctma_fin_ult1"]),COUNT(DISTINCT["ind_ctop_fin_ult1"]),COUNT(DISTINCT["ind_ctpp_fin_ult1"]),COUNT(DISTINCT["ind_deco_fin_ult1"]),COUNT(DISTINCT["ind_deme_fin_ult1"]),COUNT(DISTINCT["ind_dela_fin_ult1"]),COUNT(DISTINCT["ind_ecue_fin_ult1"]),COUNT(DISTINCT["ind_fond_fin_ult1"]),COUNT(DISTINCT["ind_hip_fin_ult1"]),COUNT(DISTINCT["ind_plan_fin_ult1"]),COUNT(DISTINCT["ind_pres_fin_ult1"]),COUNT(DISTINCT["ind_reca_fin_ult1"]),COUNT(DISTINCT["ind_tjcr_fin_ult1"]),COUNT(DISTINCT["ind_valo_fin_ult1"]),COUNT(DISTINCT["ind_viv_fin_ult1"]),COUNT(DISTINCT["ind_nomina_ult1"]),COUNT(DISTINCT["ind_nom_pens_ult1"]),COUNT(DISTINCT["ind_recibo_ult1"])
FROM [master].[dbo].[train_ver22]

-- MSQL
SELECT COUNT(DISTINCT fecha_dato),COUNT(DISTINCT ncodpers),COUNT(DISTINCT ind_empleado),COUNT(DISTINCT pais_residencia),COUNT(DISTINCT sexo),COUNT(DISTINCT age),COUNT(DISTINCT fecha_alta),COUNT(DISTINCT ind_nuevo),COUNT(DISTINCT antiguedad),COUNT(DISTINCT indrel),COUNT(DISTINCT ult_fec_cli_1t),COUNT(DISTINCT indrel_1mes),COUNT(DISTINCT tiprel_1mes),COUNT(DISTINCT indresi),COUNT(DISTINCT indext),COUNT(DISTINCT conyuemp),COUNT(DISTINCT canal_entrada),COUNT(DISTINCT indfall),COUNT(DISTINCT tipodom),COUNT(DISTINCT cod_prov),COUNT(DISTINCT nomprov),COUNT(DISTINCT ind_actividad_cliente),COUNT(DISTINCT renta),COUNT(DISTINCT segmento),COUNT(DISTINCT ind_ahor_fin_ult1),COUNT(DISTINCT ind_aval_fin_ult1),COUNT(DISTINCT ind_cco_fin_ult1),COUNT(DISTINCT ind_cder_fin_ult1),COUNT(DISTINCT ind_cno_fin_ult1),COUNT(DISTINCT ind_ctju_fin_ult1),COUNT(DISTINCT ind_ctma_fin_ult1),COUNT(DISTINCT ind_ctop_fin_ult1),COUNT(DISTINCT ind_ctpp_fin_ult1),COUNT(DISTINCT ind_deco_fin_ult1),COUNT(DISTINCT ind_deme_fin_ult1),COUNT(DISTINCT ind_dela_fin_ult1),COUNT(DISTINCT ind_ecue_fin_ult1),COUNT(DISTINCT ind_fond_fin_ult1),COUNT(DISTINCT ind_hip_fin_ult1),COUNT(DISTINCT ind_plan_fin_ult1),COUNT(DISTINCT ind_pres_fin_ult1),COUNT(DISTINCT ind_reca_fin_ult1),COUNT(DISTINCT ind_tjcr_fin_ult1),COUNT(DISTINCT ind_valo_fin_ult1),COUNT(DISTINCT ind_viv_fin_ult1),COUNT(DISTINCT ind_nomina_ult1),COUNT(DISTINCT ind_nom_pens_ult1),COUNT(DISTINCT ind_recibo_ult1)
FROM santander.train_ver2;

'''
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
'''

--- My sql
SELECT COUNT(ncodpers) 
FROM santander.train_ver2;

SELECT COUNT(DISTINCT fecha_dato),COUNT(DISTINCT ncodpers),COUNT(DISTINCT ind_empleado),COUNT(DISTINCT pais_residencia),COUNT(DISTINCT sexo),COUNT(DISTINCT age),COUNT(DISTINCT fecha_alta),COUNT(DISTINCT ind_nuevo),COUNT(DISTINCT antiguedad),COUNT(DISTINCT indrel),COUNT(DISTINCT ult_fec_cli_1t),COUNT(DISTINCT indrel_1mes),COUNT(DISTINCT tiprel_1mes),COUNT(DISTINCT indresi),COUNT(DISTINCT indext),COUNT(DISTINCT conyuemp),COUNT(DISTINCT canal_entrada),COUNT(DISTINCT indfall),COUNT(DISTINCT tipodom),COUNT(DISTINCT cod_prov),COUNT(DISTINCT nomprov),COUNT(DISTINCT ind_actividad_cliente),COUNT(DISTINCT renta),COUNT(DISTINCT segmento),COUNT(DISTINCT ind_ahor_fin_ult1),COUNT(DISTINCT ind_aval_fin_ult1),COUNT(DISTINCT ind_cco_fin_ult1),COUNT(DISTINCT ind_cder_fin_ult1),COUNT(DISTINCT ind_cno_fin_ult1),COUNT(DISTINCT ind_ctju_fin_ult1),COUNT(DISTINCT ind_ctma_fin_ult1),COUNT(DISTINCT ind_ctop_fin_ult1),COUNT(DISTINCT ind_ctpp_fin_ult1),COUNT(DISTINCT ind_deco_fin_ult1),COUNT(DISTINCT ind_deme_fin_ult1),COUNT(DISTINCT ind_dela_fin_ult1),COUNT(DISTINCT ind_ecue_fin_ult1),COUNT(DISTINCT ind_fond_fin_ult1),COUNT(DISTINCT ind_hip_fin_ult1),COUNT(DISTINCT ind_plan_fin_ult1),COUNT(DISTINCT ind_pres_fin_ult1),COUNT(DISTINCT ind_reca_fin_ult1),COUNT(DISTINCT ind_tjcr_fin_ult1),COUNT(DISTINCT ind_valo_fin_ult1),COUNT(DISTINCT ind_viv_fin_ult1),COUNT(DISTINCT ind_nomina_ult1),COUNT(DISTINCT ind_nom_pens_ult1),COUNT(DISTINCT ind_recibo_ult1)
FROM santander.train_ver2;

SELECT avg(renta),max(renta),min(renta),std(renta),stddev(renta)
FROM santander.train_ver2;
-- 106764.87614173251	28894395.51	0	212674.5912153228	212674.5912153228

SELECT avg(age),max(age),min(age),std(age),stddev(age)
FROM santander.train_ver2;
-- 40.0998	164	0	17.26271831291885	17.26271831291885

SELECT *
FROM santander.train_ver2
where age > 120
order by age;

---NA處理
--mysql
select *
FROM santander.train_ver2
where ncodpers = 1050741 ;
--sqlserver
select *
FROM [Santander].[dbo].[train_ver22]
where ["ncodpers"] = 1050741 ;