INSERT INTO comparison_operator (operator_name, operator_type)
VALUES ('Equal to', 'NUMBER'),
       ('Not equal to', 'NUMBER'),
       ('Greater than', 'NUMBER'),
       ('Greater than or equal to', 'NUMBER'),
       ('Less than', 'NUMBER'),
       ('Less than or equal to', 'NUMBER'),

       ('Contains', 'TEXT'),
       ('Does not contain', 'TEXT'),
       ('Starts with', 'TEXT'),
       ('Ends with', 'TEXT'),

       ('Equal to', 'DATE'),
       ('Not equal to', 'DATE'),
       ('Before', 'DATE'),
       ('After', 'DATE'),
       ('On or before', 'DATE'),
       ('On or after', 'DATE');

INSERT INTO criteria_type (type)
VALUES ('NUMBER'), ('TEXT'), ('DATE');
