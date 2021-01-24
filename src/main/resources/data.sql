DROP TABLE IF EXISTS request_statistic;

CREATE TABLE request_statistic
(
    login NVARCHAR(250) NOT NULL PRIMARY KEY,
    request_count INT NOT NULL
);