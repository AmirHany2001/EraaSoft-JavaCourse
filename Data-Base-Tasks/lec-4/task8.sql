
select avg(salary) from employees;

select count(*) from employees;

select max(salary) from employees;

select min(salary) from employees;

select sum(salary) from employees;

select department_id, avg(salary)
from employees
group by department_id;

select job_id, count(*)
from employees
group by job_id;

select department_id, sum(salary)
from employees
group by department_id
having sum(salary) > 50000;

select avg(commission_pct)
from employees
where commission_pct is not null;

select count(*)
from employees
where salary > 10000;

select job_id, max(salary), min(salary)
from employees
group by job_id;

select manager_id, sum(salary)
from employees
group by manager_id;

select department_id, job_id, sum(salary)
from employees
group by department_id, job_id;

select job_id, count(*)
from employees
group by job_id
having count(*) > 5;

select department_id,
       count(*) as total_employees,
       avg(salary) as avg_salary,
       max(salary) as max_salary,
       min(salary) as min_salary
from employees
group by department_id;

select department_id
from employees
group by department_id
having avg(salary) > 8000
   and count(*) < 10;

select department_id
from employees
group by department_id
order by sum(salary) desc
limit 1;

select department_id,
       sum(salary) as total_salary,
       avg(salary) as average_salary
from employees
group by department_id;
