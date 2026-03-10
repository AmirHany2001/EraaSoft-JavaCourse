-- 1. All customers and all orders
SELECT c.customer_name, o.order_id
FROM customers c
FULL OUTER JOIN orders o
ON c.customer_id = o.customer_id;

-- 2. All employees and all projects
SELECT e.employee_name, p.project_name
FROM employees e
FULL OUTER JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
FULL OUTER JOIN projects p
ON pa.project_id = p.project_id;

-- 3. All products and all suppliers
SELECT p.product_name, s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s
ON p.supplier_id = s.supplier_id;

-- 4. All students and all courses
SELECT s.student_name, c.course_name
FROM students s
FULL OUTER JOIN enrollments e
ON s.student_id = e.student_id
FULL OUTER JOIN courses c
ON e.course_id = c.course_id;

-- 5. All authors and all books
SELECT a.author_name, b.book_title
FROM authors a
FULL OUTER JOIN books b
ON a.author_id = b.author_id;

-- 6. All employees and all departments
SELECT e.employee_name, d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;

-- 7. All transactions and all payment methods
SELECT t.transaction_id, pm.method_name
FROM transactions t
FULL OUTER JOIN payment_methods pm
ON t.method_id = pm.method_id;

-- 8. Combine two customer lists from two regions
SELECT r1.customer_name AS region1_customer,
       r2.customer_name AS region2_customer
FROM customers_region1 r1
FULL OUTER JOIN customers_region2 r2
ON r1.customer_id = r2.customer_id;