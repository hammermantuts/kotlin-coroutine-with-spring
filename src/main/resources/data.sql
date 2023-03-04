INSERT INTO client (id, name, age)
VALUES (1, 'John Smith', 30),
       (2, 'Jane Doe', 25),
       (3, 'Bob Johnson', 40),
       (4, 'Samantha Lee', 32),
       (5, 'David Brown', 28),
       (6, 'Emily Jones', 27),
       (7, 'Robert White', 35),
       (8, 'Julia Martinez', 31),
       (9, 'Michael Kim', 29),
       (10, 'Amanda Davis', 33),
       (11, 'Andrew Wilson', 24),
       (12, 'Jessica Taylor', 26),
       (13, 'Steven Garcia', 39),
       (14, 'Stephanie Rodriguez', 36),
       (15, 'Matthew Hernandez', 37),
       (16, 'Lauren Perez', 34),
       (17, 'Nicholas Gonzalez', 41),
       (18, 'Olivia Martin', 38),
       (19, 'William Anderson', 42),
       (20, 'Elizabeth Thomas', 23);

INSERT INTO address (id, street, city, state, zip, client_id)
VALUES (1, '123 Main St', 'Anytown', 'CA', '12345', 1),
       (2, '456 Elm St', 'Otherville', 'NY', '54321', 2),
       (3, '789 Maple Ave', 'Smalltown', 'OH', '67890', 3),
       (4, '321 Oak Blvd', 'Bigcity', 'IL', '23456', 4),
       (5, '654 Pine Rd', 'Townsville', 'CA', '98765', 5),
       (6, '987 Cedar St', 'Nowhere', 'TX', '45678', 6),
       (7, '210 Juniper Ave', 'Anytown', 'CA', '12345', 7),
       (8, '543 Birch Ln', 'Otherville', 'NY', '54321', 8),
       (9, '876 Poplar St', 'Smalltown', 'OH', '67890', 9),
       (10, '210 Magnolia Dr', 'Bigcity', 'IL', '23456', 10),
       (11, '543 Rose Ct', 'Townsville', 'CA', '98765', 11),
       (12, '876 Daisy Way', 'Nowhere', 'TX', '45678', 12),
       (13, '210 Sunflower Rd', 'Anytown', 'CA', '12345', 13),
       (14, '543 Tulip St', 'Otherville', 'NY', '54321', 14),
       (15, '876 Iris Ave', 'Smalltown', 'OH', '67890', 15),
       (16, '210 Lily Ln', 'Bigcity', 'IL', '23456', 16),
       (17, '543 Orchid Blvd', 'Townsville', 'CA', '98765', 17),
       (18, '876 Rosewood Dr', 'Nowhere', 'TX', '45678', 18),
       (19, '210 Cherry Rd', 'Anytown', 'CA', '12345', 19),
       (20, '543 Walnut Ave', 'Otherville', 'NY', '54321', 20);

INSERT INTO order_t (id, order_name, order_number, client_id)
VALUES (1, 'Order 1', 12345, 1),
       (2, 'Order 2', 54321, 1),
       (3, 'Order 3', 67890, 2),
       (4, 'Order 4', 98765, 2),
       (5, 'Order 5', 24680, 3),
       (6, 'Order 6', 86420, 3),
       (7, 'Order 7', 13579, 4),
       (8, 'Order 8', 97531, 4),
       (9, 'Order 9', 11111, 5),
       (10, 'Order 10', 22222, 5),
       (11, 'Order 11', 33333, 5),
       (12, 'Order 12', 44444, 6),
       (13, 'Order 13', 55555, 6),
       (14, 'Order 14', 66666, 6),
       (15, 'Order 15', 77777, 6),
       (16, 'Order 16', 88888, 7),
       (17, 'Order 17', 99999, 7),
       (18, 'Order 18', 10101, 8),
       (19, 'Order 19', 20202, 8),
       (20, 'Order 20', 30303, 9),
       (21, 'Order 21', 30304, 9),
       (22, 'Order 22', 30305, 9);