-- MySQL 
-- task-1

create table emp_test (
    name varchar(100)
);

insert into emp_test values
('   ahmed   '),
('   mohamed***'),
('###ali###'),
('   sara   ');

select trim(name) from emp_test;

select ltrim(name) from emp_test;

select rtrim(name) from emp_test;

select trim('*' from name) from emp_test;


-- task-2

select replace('database','a','@');

select replace('this is old version','old','new');

create table product (
    product_name varchar(50)
);

insert into product values
('laptop'),
('mouse'),
('keyboard');

select lpad(product_name,15,'*') from product;

select rpad(product_name,15,'#') from product;

-- task-3

select date_format(curdate(), '%d-%b-%Y');

select date_format(curdate(), '%M %Y');

select format(12345.67, 2);

select concat('$', format(5500, 2));

-- task-4

create table students (
    name varchar(50),
    marks int
);

insert into students values
('ahmed', 95),
('mohamed', 88),
('ali', 76),
('sara', 82),
('omar', 60);

select name,
       marks,
       case
           when marks >= 90 then 'a'
           when marks between 80 and 89 then 'b'
           when marks between 70 and 79 then 'c'
           else 'f'
       end as grade
from students;

-- task-5 & task-6

select name,
       marks,
       case
           when marks >= 90 then 'a'
           when marks between 80 and 89 then 'b'
           when marks between 70 and 79 then 'c'
           else 'f'
       end as grade
from students;

create table orders (
    status char(1)
);

insert into orders values
('p'),
('s'),
('d');

select status,
       case status
           when 'p' then 'pending'
           when 's' then 'shipped'
           when 'd' then 'delivered'
       end as status_full
from orders;
