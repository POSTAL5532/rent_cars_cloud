CREATE TABLE cars
(
    id            uuid         NOT NULL UNIQUE,
    brand         VARCHAR(255) NOT NULL,
    model         VARCHAR(255) NOT NULL,
    year          SMALLINT NOT NULL,
    creation_date TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO cars (id, brand, model, year, creation_date)
VALUES ('550e8401-e29b-41d4-a716-446655440001', 'Audi', 'A5', 2020, '2023-06-10 14:20:45'),
       ('550e8401-e29b-41d4-a716-446655440002', 'Mercedes-Benz', 'E-Class', 2021, '2023-04-25 16:30:55'),
       ('550e8401-e29b-41d4-a716-446655440003', 'Reno', 'Talisman', 2019, '2023-02-15 11:55:35'),
       ('550e8401-e29b-41d4-a716-446655440004', 'Toyota', 'Camry', 2018, '2023-05-30 12:25:10'),
       ('550e8401-e29b-41d4-a716-446655440005', 'Mazda', '6', 2024, '2023-03-18 17:35:20'),
       ('550e8401-e29b-41d4-a716-446655440006', 'Volvo', 'XC90', 2010, '2023-07-08 09:45:15'),
       ('550e8401-e29b-41d4-a716-446655440007', 'BMW', 'M8', 2025, '2023-08-05 14:15:25'),
       ('550e8401-e29b-41d4-a716-446655440008', 'Volkswagen', 'Passat B1', 1998, '2023-04-20 16:45:30'),
       ('550e8401-e29b-41d4-a716-446655440009', 'Mitsubishi', 'Lancer EVO', 2014, '2023-09-15 19:25:55');