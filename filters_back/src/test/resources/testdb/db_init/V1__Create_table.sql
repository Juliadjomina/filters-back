CREATE TABLE comparison_operator
(
    id            BIGSERIAL PRIMARY KEY,
    operator_name TEXT,
    operator_type TEXT
);

CREATE TABLE filter (
                         id BIGSERIAL PRIMARY KEY,
                         filter_name VARCHAR(255) NOT NULL,
                         created_at DATE NOT NULL,
                         archived_at DATE
);


