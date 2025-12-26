create table manager (
id int AUTO_INCREMENT primary key ,
name varchar(255) not null ,
age tinyint unsigned ,
birth_date date ,
address varchar(255) 
);

alter table manager drop address ;

alter table manager add (city_address varchar (255) , street varchar(255));

alter table manager rename column name to full_name;

grant select on manager to 'root'@'localhost' ; 

create table Owner (
id int AUTO_INCREMENT primary key , 
name varchar(255) not null ,
birth_date date
);

rename table manager to Master;

drop table if exists owner, Master;
