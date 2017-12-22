2017/12/22

PostgreSQL台灣使用者社群官方網站 https://postgresql.tw/  
  
postgres的小島故事 http://island.postgresql.tw/  
  
BigSQL https://www.openscg.com/products/postgres-by-bigsql/  
  

中文操作手冊 https://docs.postgresql.tw/tw.10/  



`psql`進入PostgreSQL  
`\d`查詢表格  
  
安裝Multicorn
要在abc@ubuntu這個帳號下  



serve是source code在哪裡

http://multicorn.org/foreign-data-wrappers/  看RSS Foreign Data Wrapper這一段  
```
CREATE SERVER rss_srv foreign data wrapper multicorn options (
    wrapper 'multicorn.rssfdw.RssFdw'
);
```
原本的範例網址已經失效，改成下面那個網址
```
CREATE FOREIGN TABLE radicalerss (
    "pubDate" timestamp,
    description character varying,
    title character varying,
    link character varying
) server rss_srv options (
    url     'https://planet.postgresql.org/rss20.xml'
);
```
```
select "pubDate", title, link from radicalerss limit 10;
```



# DOCKER


$ 加sudo變成 #
