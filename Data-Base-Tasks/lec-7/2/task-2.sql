-- 1. All departments and employees working in them (include departments with no employees)
SELECT d.department_name, e.employee_name
FROM employees e
RIGHT JOIN departments d
ON e.department_id = d.department_id;

-- 2. All orders and their customers (include customers with no orders)
SELECT o.order_id, c.customer_name
FROM orders o
RIGHT JOIN customers c
ON o.customer_id = c.customer_id;

-- 3. All courses and enrolled students (include courses with no students)
SELECT c.course_name, s.student_name
FROM enrollments e
RIGHT JOIN courses c
ON e.course_id = c.course_id
LEFT JOIN students s
ON e.student_id = s.student_id;

-- 4. All projects and assigned employees (include projects with no employees)
SELECT p.project_name, e.employee_name
FROM employees e
RIGHT JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
RIGHT JOIN projects p
ON pa.project_id = p.project_id;

-- 5. All payment methods and their transactions (include methods with no transactions)
SELECT pm.method_name, t.transaction_id
FROM transactions t
RIGHT JOIN payment_methods pm
ON t.method_id = pm.method_id;

-- 6. All authors and their books (include authors with no books)
SELECT a.author_name, b.book_title
FROM books b
RIGHT JOIN authors a
ON b.author_id = a.author_id;

-- 7. All categories and their products (include categories with no products)
SELECT c.category_name, p.product_name
FROM products p
RIGHT JOIN categories c
ON p.category_id = c.category_id;

-- 8. All students and their dorm rooms (include dorm rooms with no students)
SELECT s.student_name, d.room_number
FROM students s
RIGHT JOIN dorm_rooms d
ON s.room_id = d.room_id;