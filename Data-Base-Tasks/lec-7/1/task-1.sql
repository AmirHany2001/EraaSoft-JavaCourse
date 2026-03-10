-- 1. Employees with their department names
SELECT employee_name, department_name
FROM employees
NATURAL JOIN departments;

-- 2. Orders with their customer names
SELECT order_id, customer_name
FROM orders
NATURAL JOIN customers;

-- 3. Student names and courses they are enrolled in
SELECT student_name, course_name
FROM students
NATURAL JOIN enrollments
NATURAL JOIN courses;

-- 4. Project names and employees working on them
SELECT project_name, employee_name
FROM projects
NATURAL JOIN project_employee
NATURAL JOIN employees;

-- 5. Invoice details with product names
SELECT invoice_id, product_name, quantity, price
FROM invoices
NATURAL JOIN products;

-- 6. Books with their author names
SELECT book_title, author_name
FROM books
NATURAL JOIN authors;

-- 7. Class schedules with instructors’ names
SELECT class_time, instructor_name
FROM schedules
NATURAL JOIN instructors;

-- 8. Supplier names and the products they supply
SELECT supplier_name, product_name
FROM suppliers
NATURAL JOIN products;

-- 9. Customer orders with shipping details
SELECT order_id, shipping_address, shipping_date
FROM orders
NATURAL JOIN shipping;

-- 10. Employees with their job titles
SELECT employee_name, job_title
FROM employees
NATURAL JOIN jobs;