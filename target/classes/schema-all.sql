DROP TABLE project IF EXISTS;

CREATE TABLE testproject  (
    id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(60)
);