DROP TABLE trades IF EXISTS;

CREATE TABLE trades
(
    trade_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    symbol   VARCHAR(20),
    amount   int,
    price    double,
    value    double
);