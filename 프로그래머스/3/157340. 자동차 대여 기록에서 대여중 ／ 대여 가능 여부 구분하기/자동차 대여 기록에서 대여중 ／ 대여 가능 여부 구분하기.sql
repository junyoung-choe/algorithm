-- 코드를 입력하세요
SELECT CAR_ID, MAX
(
    IF(DATE_FORMAT(START_DATE, "%Y%m%d") <= 20221016 AND DATE_FORMAT(END_DATE, "%Y%m%d") >= 20221016, 
       "대여중", "대여 가능")
) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC

-- 리스트로 뽑았을때 값을 보면 CAR_ID 가 여러개로 나오는 것을 확인할수 있다
-- 하나라도 대여중이 있다면 대여중으로 표시하기 위해서 MAX 를 사용할수 있다