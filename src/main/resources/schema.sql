CREATE TABLE IF NOT EXISTS PERSON (
    name varchar(255) DEFAULT '' NOT NULL,
    surname varchar(255) DEFAULT '' NOT NULL,
    age int DEFAULT 18 NOT NULL,
    phone_number varchar(255) DEFAULT NULL,
    city_of_living varchar(255) DEFAULT NULL,
    PRIMARY KEY(age, name, surname)
);

INSERT INTO PERSON(
    name,
    surname,
    age,
    phone_number,
    city_of_living
) VALUES
('Varvara', 'Businkova', 26, '89695521122', 'MSC'),
('Maria', 'Bostovich', 29, '88885552233', 'SPB'),
('Alexey', 'Bostovich', 32, '88621752233', 'EKT'),
('Michael', 'Kornov', 35, '85657832545', 'MSC');