-- 코드를 입력하세요
SELECT P.PRODUCT_CODE, SUM(PRICE * SALES_AMOUNT) as SALES
FROM PRODUCT as P JOIN OFFLINE_SALE as S ON P.PRODUCT_ID = S.PRODUCT_ID
GROUP BY P.PRODUCT_CODE
ORDER BY SALES DESC , P.PRODUCT_CODE