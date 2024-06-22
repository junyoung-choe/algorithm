-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS
WHERE NAME IN ("Milk" , "Yogurt")
GROUP BY CART_ID 
HAVING COUNT(DISTINCT NAME) = 2
ORDER BY CART_ID

-- 1 select 에 안쓰고 그냥 where 이나 having 에 있다고 생각하고 쓸수 있다 ! 

-- 2 having에 distinct 가 필요한 이유는 요거트가 두개일수도 있기 때문