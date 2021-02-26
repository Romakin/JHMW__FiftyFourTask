SELECT O.product_name AS PRODUCT FROM OrderC O JOIN Customer C
ON O.customer.id = C.id
WHERE upper(C.name) LIKE upper( :name )