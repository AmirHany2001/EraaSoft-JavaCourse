-- 1. Employees who earn more than at least one employee in department 10
SELECT employee_name, salary
FROM employees
WHERE salary > ANY (
    SELECT salary
    FROM employees
    WHERE department_id = 10
);

-- 2. Employees who earn less than all employees in department 20
SELECT employee_name, salary
FROM employees
WHERE salary < ALL (
    SELECT salary
    FROM employees
    WHERE department_id = 20
);

-- 3. Products with price equal to any product in 'Electronics'
SELECT product_name, price
FROM products
WHERE price IN (
    SELECT price
    FROM products
    WHERE category = 'Electronics'
);

-- 4. Customers who placed orders for products priced over $1000
SELECT DISTINCT c.customer_name
FROM customers c
WHERE c.customer_id IN (
    SELECT o.customer_id
    FROM orders o
    JOIN products p ON o.product_id = p.product_id
    WHERE p.price > 1000
);

-- 5. Employees who work in the same job titles as at least one other employee
SELECT employee_name, job_title
FROM employees
WHERE job_title IN (
    SELECT job_title
    FROM employees
    GROUP BY job_title
    HAVING COUNT(*) > 1
);

-- 6. Departments that have more than one employee
SELECT department_name
FROM departments
WHERE department_id IN (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 1
);

-- 7. Orders placed by customers from cities where other customers also placed orders
SELECT *
FROM orders o
WHERE o.customer_id IN (
    SELECT o2.customer_id
    FROM orders o2
    WHERE o2.customer_id IN (
        SELECT customer_id
        FROM customers
        GROUP BY city
        HAVING COUNT(*) > 1
    )
);

-- 8. Books written by authors who have published more than one book
SELECT book_title, author_id
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(*) > 1
);

-- 9. Names of students enrolled in courses taught by 'Dr. Smith'
SELECT DISTINCT s.student_name
FROM students s
JOIN enrollments e ON s.student_id = e.student_id
WHERE e.course_id IN (
    SELECT course_id
    FROM courses
    WHERE instructor_name = 'Dr. Smith'
);

-- 10. Employees whose salary matches any salary in department 30
SELECT employee_name, salary
FROM employees
WHERE salary IN (
    SELECT salary
    FROM employees
    WHERE department_id = 30
);