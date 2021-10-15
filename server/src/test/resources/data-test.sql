DROP TABLE IF EXISTS clients, cards, clients_cards;

CREATE TABLE clients
(
    id            bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(250) NOT NULL,
    accountNumber VARCHAR(250) NOT NULL
);

CREATE TABLE cards
(
    id            bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    accountNumber VARCHAR(250) NOT NULL,
    cardNumber    VARCHAR(250) NOT NULL,
    balance       DOUBLE
);

CREATE TABLE clients_cards
(
    personId    INT NOT NULL ,
    cardId      INT NOT NULL
);

INSERT INTO clients (name, accountNumber)
VALUES ('Alex Smith', '11111111'),
       ('John Black', '22222222'),
       ('Mark Tween', '00000000');

INSERT INTO cards (accountNumber, cardNumber, balance)
VALUES ('11111111', '1212', 100.0),
       ('22222222', '1313', 500.0),
       ('22222222', '1414', 1000.0),
       ('00000000', '3131', 1500.0),
       ('00000000', '3232', 10000.0);