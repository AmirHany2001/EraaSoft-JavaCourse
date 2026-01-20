
create table items (
	id int AUTO_INCREMENT primary key,
    product_name varchar(50) not null,
    product_quantity int,
    price int not null
);

insert into items (product_name, product_quantity, price) values
('laptop' , 10 , 1000),
('mouse' , 15 , 500),
('keyboard' , 20 , 100);

select * from items where id = 1 or id = 2;

select * from items where product_name like'%i%';

select * from items where price between 20 and 5000;

insert into items (product_name, product_quantity, price) values
('iphone' , 100 , 2000);
