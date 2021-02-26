CREATE TABLE IF NOT EXISTS CUSTOMER (
                                         id int auto_increment,
                                         name varchar(255) DEFAULT '' NOT NULL,
    surname varchar(255) DEFAULT '' NOT NULL,
    age int DEFAULT 18 NOT NULL,
    phone_number varchar(255) DEFAULT NULL,
    PRIMARY KEY(id)
    );

CREATE TABLE IF NOT EXISTS ORDERC (
                                      id int auto_increment,
                                      date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                      product_name varchar(255) DEFAULT '' NOT NULL,
    customer_id int,
    amount int DEFAULT 0,
    PRIMARY KEY(id)
    );

# ALTER TABLE ORDERS ADD CONSTRAINT c_customer FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id);

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
    amount
) VALUES
('pencil', 1, 20),
('notebook', 2, 10),
('clock', 3, 5),
('mouse pointer', 3, 6),
('keyboards', 3, 6),
('monitors', 4, 10),
('laptops', 4, 6)
;