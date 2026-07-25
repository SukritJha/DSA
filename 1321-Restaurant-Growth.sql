# Write your MySQL query statement below
select visited_on , 
 (
    select sum(amount) 
    from customer
    where visited_on between date_sub(c.visited_on , interval 6 day) AND c.visited_on
 ) as amount , 

 (
    select ROUND(sum(amount)/7 , 2)
    from customer
    where visited_on between date_sub(c.visited_on , interval 6 day) AND c.visited_on
 ) as average_amount


from customer c
where visited_on >= (
    select DATE_ADD(min(visited_on) , interval 6 day)
    from customer
)
group by visited_on
order by visited_on