INSERT INTO CUSTOMER(
    name,
    surname,
    age,
    phone_number
) VALUES
('Varvara', 'Businkova', 26, '89695521122'),
('Maria', 'Bostovich', 29, '88885552233'),
('Alexey', 'Bostovich', 32, '88621752233'),
('Michael', 'Kornov', 35, '85657832545');

INSERT INTO ORDERC(
    product_name,
    customer_id,
    amount,
    date
) VALUES
('pencil', 1, 20,CURRENT_TIMESTAMP()),
('notebook', 2, 10, CURRENT_TIMESTAMP()),
('clock', 3, 5, CURRENT_TIMESTAMP()),
('mouse pointer', 3, 6, CURRENT_TIMESTAMP()),
('keyboards', 3, 6, CURRENT_TIMESTAMP()),
('monitors', 4, 10, CURRENT_TIMESTAMP()),
('laptops', 4, 6, CURRENT_TIMESTAMP())
;