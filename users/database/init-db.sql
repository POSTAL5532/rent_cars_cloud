CREATE TABLE users
(
    id            uuid         NOT NULL UNIQUE,
    email         VARCHAR(255) NOT NULL UNIQUE,
    name          VARCHAR(255) NOT NULL,
    surname       VARCHAR(255),
    creation_date TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users (id, email, name, surname, creation_date)
VALUES ('550e8400-e29b-41d4-a716-446655440001', 'user1@example.com', 'User1', 'One', '2023-06-10 14:20:45'),
       ('550e8400-e29b-41d4-a716-446655440002', 'user2@example.com', 'User2', 'Two', '2023-04-25 16:30:55'),
       ('550e8400-e29b-41d4-a716-446655440003', 'user3@example.com', 'User3', 'Three', '2023-02-15 11:55:35'),
       ('550e8400-e29b-41d4-a716-446655440004', 'user4@example.com', 'User4', 'Four', '2023-05-30 12:25:10'),
       ('550e8400-e29b-41d4-a716-446655440005', 'user5@example.com', 'User5', 'Five', '2023-03-18 17:35:20'),
       ('550e8400-e29b-41d4-a716-446655440006', 'user6@example.com', 'User6', 'Six', '2023-07-08 09:45:15'),
       ('550e8400-e29b-41d4-a716-446655440007', 'user7@example.com', 'User7', 'Seven', '2023-08-05 14:15:25'),
       ('550e8400-e29b-41d4-a716-446655440008', 'user8@example.com', 'User8', 'Eight', '2023-04-20 16:45:30'),
       ('550e8400-e29b-41d4-a716-446655440009', 'user9@example.com', 'User9', 'Nine', '2023-09-15 19:25:55');