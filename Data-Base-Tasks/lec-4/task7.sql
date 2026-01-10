create table customers (
    full_name varchar(100)
);

insert into customers values
('   ahmed ali   '),
('mohamed hassan   '),
('   sara adel'),
('###mina###'),
('$$john$$');

select trim(full_name) from customers;

select ltrim(full_name) from customers;

select rtrim(full_name) from customers;

select trim('#' from full_name) from customers;


select replace('promotion','o','0');

select replace('this is a basic course','basic','advanced');

create table departments (
    dept_name varchar(50)
);

insert into departments values
('hr'),
('it'),
('sales');

select lpad(dept_name,15,'*') from departments;

select rpad(dept_name,15,'-') from departments;


select date_format(curdate(), '%d-%b-%Y');

select date_format(curdate(), '%W, %M %Y');

select format(12345.67, 2);

select concat('$', format(7500, 2));

select date_format(now(), '%Y/%m/%d %H:%i:%s');


create table students (
    name varchar(50),
    score int
);

insert into students values
('ahmed', 95),
('mona', 85),
('ali', 75),
('sara', 65),
('omar', 50);

select name,
       score,
       case
           when score >= 90 then 'a'
           when score between 80 and 89 then 'b'
           when score between 70 and 79 then 'c'
           else 'f'
       end as grade
from students;

select name,
       score,
       case
           when score >= 60 then 'pass'
           else 'fail'
       end as result
from students;

select name,
       score,
       case
           when score >= 90 then 'excellent'
           when score between 80 and 89 then 'good'
           when score between 70 and 79 then 'average'
           else 'needs improvement'
       end as message
from students;

select concat('today is ', dayname(curdate()));


select score,
       case score
           when 100 then 'a'
           when 90 then 'b'
           when 80 then 'c'
           else 'f'
       end as grade
from students;

create table status_log (
    status_code char(1)
);

insert into status_log values
('n'),
('i'),
('c');

select status_code,
       case status_code
           when 'n' then 'new'
           when 'i' then 'in progress'
           when 'c' then 'completed'
       end as status_text
from status_log;

select
       case
           when 0 = 0 then 'out of stock'
           else 'available'
       end as stock_status;

select dept_name,
       case dept_name
           when 'hr' then 500
           when 'it' then 1000
           when 'sales' then 1500
           else 300
       end as bonus
from departments;
