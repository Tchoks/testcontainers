DROP TABLE IF EXISTS customers;

CREATE TABLE customers
(
    id         bigint primary key ,
    first_name VARCHAR(100),
    last_name  VARCHAR(100)
);

INSERT INTO customers(id, first_name, last_name)
VALUES (1,'Martin', 'Tchokonthe');
INSERT INTO customers(id, first_name, last_name)
VALUES (2,'Olga', 'Tiwoa');

