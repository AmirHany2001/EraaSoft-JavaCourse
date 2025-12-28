select first_name , employee_id  from employees where employee_id <= 105 ;
select first_name , employee_id  from employees where employee_id in (151 , 152, 153, 154 , 155);
select first_name , employee_id  from employees where first_name like 'p%';
select first_name , employee_id  from employees where first_name like '%A';
select first_name , employee_id  from employees where first_name like 'A%';
select first_name , employee_id  from employees where first_name like '__e%';
select first_name , employee_id , manager_id  from employees where manager_id is null ;
select first_name , employee_id , manager_id  from employees where manager_id is  not null ;
insert into  employees values ( 167 , 'Amir' , 'Hany' , 'AmirHany2001' , '515.231.7685' , '2001-10-20' , 'IT_PROG' , 2000 , 0.5 , null , 60 );
select first_name , employee_id , job_id  from employees where job_id in ('IT_PROG' , 'AD_VP') ;
select last_name  from employees order by last_name ;
select first_name , hire_date from employees order by hire_date desc ;
select * from employees order by department_id , salary desc;
select  last_name , lower(last_name) as last_name_lower from employees;
select  first_name , upper(first_name) as first_name_upper from employees;
select first_name , last_name , concat(upper(substring(first_name, 1, 1)), lower(substring(first_name, 2)),' ', lower(last_name)) 
as full_name from employees;
select first_name, employee_id , last_name from employees where lower(last_name) = 'smith';






