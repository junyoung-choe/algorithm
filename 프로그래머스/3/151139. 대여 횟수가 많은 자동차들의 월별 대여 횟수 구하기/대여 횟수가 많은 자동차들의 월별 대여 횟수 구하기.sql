select month(start_date)as MONTH,car_id as CAR_ID,count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date) between 8 and 10  and
car_id in 
(
select car_id
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where month(start_date) between 8 and 10  
group by car_id
having count(*) >4
)
group by car_id,month
order by month asc ,car_id desc