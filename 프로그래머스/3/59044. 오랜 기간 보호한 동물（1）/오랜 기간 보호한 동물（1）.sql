-- 코드를 입력하세요
SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS as I LEFT JOIN 
ANIMAL_OUTS as O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.DATETIME IS NULL
ORDER BY I.DATETIME
LIMIT 3

-- 여기선 inner 가 아닌 left 조인을 반드시 써야하는 이유는 
-- inner join을 한 뷰에서 나간 동물이 아니라면 
-- Outer 부분이 Null 로 들어가 있을것이다 ! 
-- 그러니 Null 에 해당하는 애들을 조건으로 건다 ! 
# A410684	Cat	2014-06-21 12:25:00	Normal	Mitty	Spayed Female	A410684	Cat	2014-06-27 17:50:00	Mitty	Spayed Female
# A412173	Dog	2015-07-28 18:17:00	Normal	Jimminee	Neutered Male	A412173	Dog	2015-08-08 12:22:00	Jimminee	Neutered Male
# A412626	Dog	2016-03-13 11:17:00	Normal	*Sam	Neutered Male	A412626	Dog	2016-03-28 13:15:00	*Sam	Neutered Male
# A412697	Dog	2016-01-03 16:25:00	Normal	Jackie	Neutered Male					
# A413789	Dog	2016-04-19 13:28:00	Normal	Benji	Spayed Female					
# A414198	Dog	2015-01-29 15:01:00	Normal	Shelly	Spayed Female					
# A414513	Dog	2016-06-07 09:17:00	Normal	Rocky	Neutered Male			