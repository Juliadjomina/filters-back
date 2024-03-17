CREATE TABLE comparison_operator
(
    id            BIGSERIAL PRIMARY KEY,
    operator_name VARCHAR(255),
    operator_type  VARCHAR
);

INSERT INTO comparison_operator (operator_name, operator_type)
VALUES ('Equal to', 'AMOUNT'),
       ('Not equal to', 'AMOUNT'),
       ('Greater than', 'AMOUNT'),
       ('Greater than or equal to', 'AMOUNT'),
       ('Less than', 'AMOUNT'),
       ('Less than or equal to', 'AMOUNT'),

       ('Contains', 'TITLE'),
       ('Does not contain', 'TITLE'),
       ('Starts with', 'TITLE'),
       ('Ends with', 'TITLE'),

       ('Equal to', 'DATE'),
       ('Not equal to', 'DATE'),
       ('Before', 'DATE'),
       ('After', 'DATE'),
       ('On or before', 'DATE'),
       ('On or after', 'DATE');

CREATE TABLE criteria_type
(
    id   BIGSERIAL PRIMARY KEY,
    type TEXT
);

INSERT INTO criteria_type (type)
VALUES ('AMOUNT'),
       ('TITLE'),
       ('DATE');


CREATE TABLE selection
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

INSERT INTO selection (name)
VALUES ('Select 1'),
       ('Select 2'),
       ('Select 3');
