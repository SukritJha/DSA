# Write your MySQL query statement below
-- select customer_id
-- from customer
-- group by customer_id
-- having count(distinct product_key) = (
--     select count(product_key)
--     from product
-- )

-- select c.customer_id
-- from Customer as c
-- join Product as p 
-- group by customer_id
-- having count( distinct c.product_key)=count( distinct p.product_key)

SELECT customer_id
FROM Customer c , Product p
GROUP BY customer_id
HAVING  COUNT(DISTINCT c.product_key) = COUNT(DISTINCT p.product_key)