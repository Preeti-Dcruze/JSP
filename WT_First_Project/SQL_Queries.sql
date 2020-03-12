use wt2020;

create table Users(
userid integer auto_increment,
username varchar(40) not null,
pssword varchar(40) not null,
fullname varchar(100) ,
emailid varchar(100),
primary key (userid));

insert into users(username,pssword,fullname,emailid) values('Preeti-Dcruze','1234','Preeti Dcruze','glenorine2000@gmail.com');

select * from users;