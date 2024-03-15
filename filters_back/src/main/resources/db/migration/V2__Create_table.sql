CREATE TABLE criteria_type
(
    id   BIGSERIAL PRIMARY KEY,
    type TEXT
);

INSERT INTO criteria_type (type)
VALUES ('NUMBER'), ('TEXT'), ('DATE');

CREATE TABLE criteria (
                          id BIGSERIAL PRIMARY KEY,
                          filter_id BIGINT NOT NULL,
                          type_id BIGINT NOT NULL,
                          comparison_operator_id BIGINT NOT NULL,
                          created_at DATE NOT NULL,
                          archived_at DATE,
                          FOREIGN KEY (type_id) REFERENCES criteria_type(id),
                          FOREIGN KEY (filter_id) REFERENCES filter(id),
                          FOREIGN KEY (comparison_operator_id) REFERENCES comparison_operator(id)
);


CREATE TABLE number_criteria (
                          value INT NOT NULL
) INHERITS (Criteria);

CREATE TABLE text_criteria (
                                value VARCHAR(255)  NOT NULL
) INHERITS (Criteria);


CREATE TABLE date_criteria (
                              value TIMESTAMP NOT NULL
) INHERITS (Criteria);
