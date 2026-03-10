-- 1. Employee names and department names
SELECT employee_name, department_name
FROM employees
JOIN departments USING (department_id);

-- 2. Orders with customer names
SELECT order_id, customer_name
FROM orders
JOIN customers USING (customer_id);

-- 3. Product names and supplier names
SELECT product_name, supplier_name
FROM products
JOIN suppliers USING (supplier_id);

-- 4. Student names and course titles
SELECT student_name, course_title
FROM students
JOIN enrollments USING (student_id)
JOIN courses USING (course_id);

-- 5. Invoice numbers and product names
SELECT invoice_number, product_name
FROM invoices
JOIN products USING (product_id);

-- 6. Project names and employee names
SELECT project_name, employee_name
FROM projects
JOIN project_employee USING (project_id)
JOIN employees USING (employee_id);

-- 7. Author names and book titles
SELECT author_name, book_title
FROM authors
JOIN books USING (author_id);

-- 8. Sales order details with employee names
SELECT order_id, employee_name
FROM sales_orders
JOIN employees USING (employee_id);

-- 9. Course schedules and instructor names
SELECT schedule_time, instructor_name
FROM course_schedules
JOIN instructors USING (instructor_id);

-- 10. Transactions with account holder names
SELECT transaction_id, account_holder_name
FROM transactions
JOIN accounts USING (account_id);