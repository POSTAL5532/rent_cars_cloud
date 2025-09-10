CREATE TABLE orders
(
    id            uuid         NOT NULL UNIQUE,
    user_id       uuid         NOT NULL,
    car_id        uuid         NOT NULL,
    creation_date TIMESTAMP    NOT NULL,
    update_date   TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);

-- Insert test data with references to existing users and cars
INSERT INTO orders (id, user_id, car_id, creation_date, update_date)
VALUES ('550e8402-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440001', '550e8401-e29b-41d4-a716-446655440001', '2023-06-15 14:20:45', '2023-06-15 14:20:45'),
       ('550e8402-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440002', '550e8401-e29b-41d4-a716-446655440002', '2023-07-10 16:30:55', '2023-07-10 16:30:55'),
       ('550e8402-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440003', '550e8401-e29b-41d4-a716-446655440003', '2023-08-20 11:55:35', '2023-08-20 11:55:35');
