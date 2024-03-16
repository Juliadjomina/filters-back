CREATE TABLE comparison_operator
(
    id            BIGSERIAL PRIMARY KEY,
    operator_name VARCHAR(255),
    operator_type TEXT
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

CREATE TABLE filter
(
    id          BIGSERIAL PRIMARY KEY,
    filter_name VARCHAR(255) NOT NULL,
    created_at  DATE         NOT NULL,
    archived_at DATE
);
