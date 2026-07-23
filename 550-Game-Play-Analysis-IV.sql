# Write your MySQL query statement below
-- select ROUND(count( player_id) / (select count(distinct player_id) from activity) , 2) as fraction
-- from activity
-- where (player_id ,DATE_SUB(event_date , INTERVAL 1 DAY))
-- IN(
--     select player_id , min(event_date) as login_date
--     from activity
--     group by player_id
-- ) 

-- SELECT ROUND(
--     COUNT(player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity),
--     2
-- ) AS fraction
-- FROM Activity
-- WHERE (player_id, event_date) IN (
--     SELECT player_id,
--            DATE_ADD(MIN(event_date), INTERVAL 1 DAY) -- date_add subquery mein aya but date_sub where mein aya tha
--     FROM Activity
--     GROUP BY player_id
-- );

SELECT ROUND(
    COUNT(DISTINCT a.player_id) /
    (SELECT COUNT(DISTINCT player_id) FROM Activity),
    2
) AS fraction
FROM Activity a
JOIN (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) f
ON a.player_id = f.player_id
WHERE DATEDIFF(a.event_date, f.first_login) = 1;
