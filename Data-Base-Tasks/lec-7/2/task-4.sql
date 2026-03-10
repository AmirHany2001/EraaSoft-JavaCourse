-- 1. Employees who earn more than the average salary
SELECT employee_name
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- 2. Customers who placed the highest number of orders
SELECT customer_id
FROM orders
GROUP BY customer_id
HAVING COUNT(*) = (
    SELECT MAX(order_count)
    FROM (
        SELECT COUNT(*) AS order_count
        FROM orders
        GROUP BY customer_id
    ) t
);

-- 3. Products whose price is higher than any product in 'Accessories'
SELECT product_name
FROM products
WHERE price > ANY (
    SELECT price
    FROM products
    WHERE category = 'Accessories'
);

-- 4. Employees who work in the same department as 'John Smith'
SELECT employee_name
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE employee_name = 'John Smith'
);

-- 5. Orders placed by customers from 'New York'
SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

-- 6. Departments that have no employees
SELECT department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT *
    FROM employees e
    WHERE e.department_id = d.department_id
);

-- 7. Students not enrolled in any course
SELECT student_name
FROM students
WHERE student_id NOT IN (
    SELECT student_id
    FROM enrollments
);

-- 8. Second highest salary
SELECT MAX(salary)
FROM employees
WHERE salary < (
    SELECT MAX(salary)
    FROM employees
);

-- 9. Products with price greater than the average price
SELECT product_name
FROM products
WHERE price > (
    SELECT AVG(price)
    FROM products
);

-- 10. Customers who ordered all products in category 'A'
SELECT c.customer_id
FROM customers c
WHERE NOT EXISTS (
    SELECT p.product_id
    FROM products p
    WHERE p.category = 'A'
    AND NOT EXISTS (
        SELECT *
        FROM orders o
        WHERE o.customer_id = c.customer_id
        AND o.product_id = p.product_id
    )
);