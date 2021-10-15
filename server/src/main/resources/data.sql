DROP TABLE IF EXISTS clients, cards, clients_cards;

CREATE TABLE clients
(
    id            bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(250) NOT NULL,
    accountNumber VARCHAR(250) NOT NULL
);

CREATE TABLE cards
(
    id            bigint(20)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
    accountNumber VARCHAR(250) NOT NULL,
    cardNumber    VARCHAR(250) NOT NULL,
    balance       DOUBLE
);

CREATE TABLE clients_cards
(
    personId INT NOT NULL,
    cardId   INT NOT NULL
);

INSERT INTO clients (name, accountNumber)
VALUES ('Alex Smith', '1111222233334444'),
       ('Mark Tween', '1122223333444455'),
       ('John Cook', '1234567890123456'),
       ('Tom Green', '1234123412341234'),
       ('Pieter Pan', '1234234534564567');

INSERT INTO cards (accountNumber, cardNumber, balance)
VALUES ('1111222233334444', '11112222', 1000.0),
       ('1111222233334444', '13131313', 500.0),
       ('1122223333444455', '14141414', 1000.0),
       ('1234567890123456', '31311313', 1500.0),
       ('1234234534564567', '32323232', 10000.0),
       ('1234234534564567', '10101010', 22000.0),
       ('1234234534564567', '55559999', 0.0),
       ('1234234534564567', '98765432', 1190000.0);
