create table Employees (
    EmployeeID int AUTO_INCREMENT primary key,
    FirstName varchar(50) not null,
    LastName varchar(50) not null,
    Department varchar(50),
    Salary decimal(10,2)
);


insert into Employees (EmployeeID, FirstName, LastName, Department, Salary) values
(101, 'John1', 'Doe1', 'HR', 20000),
(102, 'John2', 'Doe2', 'IT', 50000),
(103, 'John3', 'Doe3', 'CS', 40000),
(104, 'John4', 'Doe4', 'IT', 10000),
(105, 'John5', 'Doe5', 'ZX', 30000);

update Employees set salary=600000 where EmployeeID=101;

delete from Employees where EmployeeID=101;

select * , concat(FirstName,'  ',LastName) as FullName from Employees; 