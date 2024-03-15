INSERT INTO filter (filter_name, created_at, archived_at)
VALUES ('Filter 5', '2024-03-02', NULL);

INSERT INTO number_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    ((SELECT MAX(id) FROM filter), 1, 5, '2024-03-02', NULL, 50);

INSERT INTO text_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    ((SELECT MAX(id) FROM filter), 2, 10, '2024-03-02', NULL, 'Text 5');

INSERT INTO date_criteria (filter_id, type_id, comparison_operator_id, created_at, archived_at, value)
VALUES
    ((SELECT MAX(id) FROM filter), 3, 15, '2024-03-02', NULL, '2024-03-06 12:00:00');
