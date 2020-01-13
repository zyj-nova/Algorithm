/*
Create table If Not Exists Weather (Id int, RecordDate date, Temperature int)
Truncate table Weather
insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10')
insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25')
insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20')
insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30')

查找与 之前（昨天的） 日期相比温度更高的所有日期的 Id。
*/
select a.Id as Id
from Weather a join Weather b
    ON DATEDIFF(a.RecordDate, b.RecordDate) = 1
WHERE a.Temperature > b.Temperature