CREATE SEQUENCE client_seq AS INTEGER START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE address_seq AS INTEGER START WITH 100 INCREMENT BY 1;
CREATE SEQUENCE order_t_seq AS INTEGER START WITH 100 INCREMENT BY 1;

CREATE TABLE client
(
    id BIGINT DEFAULT NEXT VALUE FOR PUBLIC.client_seq PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age  INT          NOT NULL
);

CREATE TABLE address
(
    id BIGINT DEFAULT NEXT VALUE FOR PUBLIC.address_seq PRIMARY KEY,
    street    VARCHAR(255) NOT NULL,
    city      VARCHAR(255) NOT NULL,
    state     VARCHAR(255) NOT NULL,
    zip       VARCHAR(10)  NOT NULL,
    client_id INT          NOT NULL REFERENCES client (id) ON DELETE CASCADE
);

CREATE TABLE order_t
(
    id BIGINT DEFAULT NEXT VALUE FOR PUBLIC.order_t_seq PRIMARY KEY,
    order_name   VARCHAR(255) NOT NULL,
    order_number INT          NOT NULL,
    client_id    INT          NOT NULL REFERENCES client (id) ON DELETE CASCADE
);
