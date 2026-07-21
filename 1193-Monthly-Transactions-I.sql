# Write your MySQL query statement below
select DATE_FORMAT(trans_date , '%Y-%m') as month , country , 
COUNT(id) as trans_count , SUM(state = 'approved') as approved_count , SUM(amount) as trans_total_amount ,
SUM(IF(state = 'declined' ,amount = 0 , amount)) as approved_total_amount
from transactions
group by month , country