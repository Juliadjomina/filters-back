INSERT INTO filter (filter_name, created_at, archived_at)
VALUES
    ('Filter 1', '2024-03-02', NULL),
    ('Filter 2', '2024-03-02', NULL),
    ('Filter 3', '2024-03-02', NULL),
    ('Filter 4', '2024-03-02', NULL),
    ('Filter 5', '2024-03-02', NULL);


-- Inserting into NumberCriteria table
INSERT INTO number_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    (1, 1, 1, '2024-03-02', NULL, 10),
    (2, 1, 2, '2024-03-02', NULL, 20),
    (3, 1, 3, '2024-03-02', NULL, 30),
    (4, 1, 4, '2024-03-02', NULL, 40),
    (5, 1, 5, '2024-03-02', NULL, 50);

-- Inserting into TextCriteria table
INSERT INTO text_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    (1, 2, 7, '2024-03-02', NULL, 'Text 1'),
    (2, 2, 7, '2024-03-02', NULL, 'Text 2'),
    (3, 2, 8, '2024-03-02', NULL, 'Text 3'),
    (4, 2, 9, '2024-03-02', NULL, 'Text 4'),
    (5, 2, 10, '2024-03-02', NULL, 'Text 5');

-- Inserting into DateCriteria table
INSERT INTO date_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    (1, 3, 11, '2024-03-02', NULL, '2024-03-02 12:00:00'),
    (2, 3, 12, '2024-03-02', NULL, '2024-03-03 12:00:00'),
    (3, 3, 13, '2024-03-02', NULL, '2024-03-04 12:00:00'),
    (4, 3, 14, '2024-03-02', NULL, '2024-03-05 12:00:00'),
    (5, 3, 15, '2024-03-02', NULL, '2024-03-06 12:00:00');
