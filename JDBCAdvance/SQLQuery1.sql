use mydb;

select * from userAccount;

insert into userAccount values(12,'Jalal','Uddin',1233);

update userAccount set balance=balance-1000 where lname = 'Junaeid';

update userAccount set balance=balance+1000 where lname = 'Alim';

delete userAccount where lname = 'Miya';

