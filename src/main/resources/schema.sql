DRop TABLE if exists Cpus;
CREATE TABLE if not exists Cpus
(
    id                 BIGINT PRIMARY KEY  NOT NULL,
    name               VARCHAR(255) UNIQUE NOT NULL,
    description        VARCHAR(255),
    price              DECIMAL(19, 2)      NOT NULL,
    producer           VARCHAR(255)        NOT NULL,
    amount_in_magazine INT                 NOT NULL,
    core               INT                 NOT NULL,
    base_frequency     FLOAT               NOT NULL
);