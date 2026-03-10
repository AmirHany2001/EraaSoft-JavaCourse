-- 1. Employee(s) with the highest salary
SELECT employee_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary) FROM employees);

-- 2. Employees who work in the same department as 'Alice'
SELECT employee_name
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE employee_name = 'Alice'
);

-- 3. Product with the lowest price
SELECT *
FROM products
WHERE price = (SELECT MIN(price) FROM products);

-- 4. Department name of the employee with the highest salary
SELECT department_name
FROM departments
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE salary = (SELECT MAX(salary) FROM employees)
);

-- 5. Manager of the employee hired most recently
SELECT manager_name
FROM employees e1
JOIN employees e2
ON e1.employee_id = e2.manager_id
WHERE e2.hire_date = (SELECT MAX(hire_date) FROM employees);

-- 6. Employee whose salary is equal to the average salary
SELECT employee_name, salary
FROM employees
WHERE salary = (SELECT AVG(salary) FROM employees);

-- 7. Order(s) with the earliest order date
SELECT *
FROM orders
WHERE order_date = (SELECT MIN(order_date) FROM orders);

-- 8. Employee who earns more than employee with ID = 101
SELECT employee_name, salary
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE employee_id = 101);

-- 9. Student who has the same GPA as 'John Doe'
SELECT student_name, gpa
FROM students
WHERE gpa = (SELECT gpa FROM students WHERE student_name = 'John Doe');

-- 10. Books with the same price as the most expensive book in 'Science' category
SELECT book_title, price
FROM books
WHERE price = (
    SELECT MAX(price)
    FROM books
    WHERE category = 'Science'
);