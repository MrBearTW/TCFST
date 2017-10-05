create database Santander;

-- 先用小檔案建立表單schema，再truncate資料表內容，再匯入真正全部的資料

USE Santander;
LOAD DATA LOCAL INFILE 'C:/Users/tcfst/Desktop/SantanderProductRecommendation/train_ver2.csv'  -- 要反斜線
INTO TABLE train_ver2

FIELDS TERMINATED BY ',' 
ENCLOSED BY '"' 

LINES TERMINATED BY '\n'
IGNORE 1 LINES;