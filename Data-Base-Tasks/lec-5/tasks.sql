-- MYSQL
-- task1

create table Player (
id int not null unique,
name varchar(60) unique,
age int
);

create table Manager(
id int primary key,
name varchar(60),
salary int,
age int,
unique(id , name)
);

-- task2 & task5

create table Doctor(
id int primary key,
name varchar(60) not null,
age int not null
);

create table patient(
id int primary key,
name varchar(60) not null,
age int not null
);

create table relations(
doctor_id int not null,
patient_id int not null,
constraint doctor_fk foreign key (doctor_id) references Doctor(id),
constraint patient_id foreign key (patient_id) references patient(id),
unique(doctor_id,patient_id)
);

-- task3 & task6

create table Language (
id int primary key,
name varchar(60) not null
);

create table Teacher(
id int primary key,
name varchar(60) not null,
salary int not null,
language_id int not null, 
constraint language_fk foreign key(language_id) references Language(id)
);

-- task4 & task7`

create table Employee(
id int primary key,
name varchar(60) not null,
age int not null
);

create table Phone(
id int primary key,
phone_number varchar(60) not null,
employee_id int not null unique,
constraint employee_id foreign key (employee_id) references Employee(id)
);






