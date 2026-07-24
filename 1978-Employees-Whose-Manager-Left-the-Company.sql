# Write your MySQL query statement below
select employee_id
from employees
where manager_id
 NOT IN(
    select employee_id 
    from employees
)   AND salary < 30000
order by employee_id