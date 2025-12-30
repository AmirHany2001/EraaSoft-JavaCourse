-- mysql code not oracle

create table Doctor(
id int AUTO_INCREMENT primary key ,
name varchar(255) not null,
salary DECIMAL(10,2) ,
address varchar(255)
);

insert into Doctor (name, salary, address) values
('Dr. Ahmed Ali', 1000.00, 'Cairo'),
('Dr. Mona Hassan', 2000.00, 'Alexandria'),
('Dr. Omar Farouk', 3000.00, 'Giza'),
('Dr. Sara Khaled', 4200.00, 'Mansoura'),
('Dr. Hassan Tarek', 3000.00, 'Cairo'),
('Dr. Laila Youssef', 2500.00, 'Alexandria'),
('Dr. Khalid Mahmoud', 1100.00, 'Shubra'),
('Dr. Nour Fathy', 5000.00, 'Cairo'),
('Dr. Adham Samir', 6000.00, 'Port Said'),
('Dr. Dina Adel', 9000.00, 'Tanta');

update Doctor set salary=20000 where id=3;

delete from Doctor where id = 9; 


select concat(name , " your salary is " , salary) as data from doctor;

select id, name, salary, address, salary * 2 as double_salary from Doctor;

select id , name , salary from doctor where salary = 1000 or salary= 2000 or salary = 3000 ;

rename table doctor to PRD_DOCTOR ;


 


