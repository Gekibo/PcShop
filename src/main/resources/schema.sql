-- Tworzenie nowej tabeli z odpowiednią kolejnością kolumn
CREATE TABLE IF NOT EXISTS New_Cpus
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    core           INT                NOT NULL,
    base_frequency FLOAT              NOT NULL
);

-- Kopiowanie danych z oryginalnej tabeli do nowej tabeli
INSERT INTO New_Cpus (id, core, base_frequency)
SELECT id, core, base_frequency
FROM Cpus;

-- Usunięcie oryginalnej tabeli
DROP TABLE Cpus;

-- Zmiana nazwy nowej tabeli na oryginalną
ALTER TABLE New_Cpus
    RENAME TO Cpus;
-- Tworzenie nowej tabeli z właściwą kolejnością kolumn
CREATE TABLE IF NOT EXISTS New_Products
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT  NOT NULL,
    name               VARCHAR(255) UNIQUE NOT NULL,
    category           VARCHAR(255)        NOT NULL,
    description        VARCHAR(255),
    price              DECIMAL(19, 2)      NOT NULL,
    producer           VARCHAR(255)        NOT NULL,
    amount_in_magazine INT                 NOT NULL
);

-- Kopiowanie danych z oryginalnej tabeli do nowej tabeli
INSERT INTO New_Products (id, name, description, price, producer, amount_in_magazine)
SELECT id, name, description, price, producer, amount_in_magazine
FROM Products;

-- Usunięcie oryginalnej tabeli
--     ALTER TABLE Products rename to New_products1;
DROP TABLE Products;

-- Zmiana nazwy nowej tabeli na oryginalną
ALTER TABLE New_Products
    RENAME TO Products;
