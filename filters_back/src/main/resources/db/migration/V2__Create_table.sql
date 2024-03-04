CREATE TABLE CriteriaType
(
    id   SERIAL PRIMARY KEY,
    type VARCHAR(255)
);

INSERT INTO CriteriaType (type)
VALUES ('NUMBER'), ('TEXT'), ('DATE');


CREATE TABLE Criteria (
                          id SERIAL PRIMARY KEY ,
                          filter_id INT,
                          type_id INT NOT NULL,
                          comparison_operator_id INT NOT NULL,
                          created_at DATE,
                          archived_at DATE,
                          FOREIGN KEY (type_id) REFERENCES CriteriaType(id),
                          FOREIGN KEY (filter_id) REFERENCES Filter(id),
                          FOREIGN KEY (comparison_operator_id) REFERENCES ComparisonOperator(id)
);


CREATE TABLE NumberCriteria (
                          value INT NOT NULL
) INHERITS (Criteria);

CREATE TABLE TextCriteria (
                                value VARCHAR(255)  NOT NULL
) INHERITS (Criteria);


CREATE TABLE DateCriteria (
                              value TIMESTAMP NOT NULL
) INHERITS (Criteria);
