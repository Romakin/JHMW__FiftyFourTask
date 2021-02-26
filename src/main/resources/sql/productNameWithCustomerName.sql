SELECT O.product_name AS PRODUCT FROM ORDERC O JOIN CUSTOMER C
ON O.customer_id = C.id
WHERE upper(C.name) LIKE upper( :name )