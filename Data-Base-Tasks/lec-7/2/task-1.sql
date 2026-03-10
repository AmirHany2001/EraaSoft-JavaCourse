-- 1. All employees with their department names (including employees without department)
SELECT e.employee_name, d.department_name
FROM employees e
LEFT JOIN departments d
ON e.department_id = d.department_id;

-- 2. All products with their categories (including products without category)
SELECT p.product_name, c.category_name
FROM products p
LEFT JOIN categories c
ON p.category_id = c.category_id;

-- 3. All students and the courses they are enrolled in (including students without courses)
SELECT s.student_name, c.course_name
FROM students s
LEFT JOIN enrollments e
ON s.student_id = e.student_id
LEFT JOIN courses c
ON e.course_id = c.course_id;

-- 4. All orders with customer names (including orders without customer)
SELECT o.order_id, c.customer_name
FROM orders o
LEFT JOIN customers c
ON o.customer_id = c.customer_id;

-- 5. All departments and their managers (including departments without manager)
SELECT d.department_name, m.manager_name
FROM departments d
LEFT JOIN managers m
ON d.manager_id = m.manager_id;

-- 6. All books and their authors (including books without author)
SELECT b.book_title, a.author_name
FROM books b
LEFT JOIN authors a
ON b.author_id = a.author_id;

-- 7. All invoices with their payment status (including unpaid invoices)
SELECT i.invoice_id, p.payment_status
FROM invoices i
LEFT JOIN payments p
ON i.invoice_id = p.invoice_id;

-- 8. All employees and their projects (including employees without project)
SELECT e.employee_name, p.project_name
FROM employees e
LEFT JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
LEFT JOIN projects p
ON pa.project_id = p.project_id;