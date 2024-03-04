CREATE TABLE ComparisonOperator
(
    id            SERIAL PRIMARY KEY,
    operator_name VARCHAR(255),
    operator_type VARCHAR(50)
);

INSERT INTO ComparisonOperator (operator_name, operator_type)
VALUES ('Equal to', 'Number'),
       ('Not equal to', 'Number'),
       ('Greater than', 'Number'),
       ('Greater than or equal to', 'Number'),
       ('Less than', 'Number'),
       ('Less than or equal to', 'Number'),

       ('Contains', 'Text'),
       ('Does not contain', 'Text'),
       ('Starts with', 'Text'),
       ('Ends with', 'Text'),

       ('Equal to', 'Date'),
       ('Not equal to', 'Date'),
       ('Before', 'Date'),
       ('After', 'Date'),
       ('On or before', 'Date'),
       ('On or after', 'Date');


CREATE TABLE Filter (
                         id SERIAL PRIMARY KEY,
                         filter_name VARCHAR(255) NOT NULL,
                         created_at DATE,
                         archived_at DATE
);


