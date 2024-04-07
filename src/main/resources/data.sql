INSERT INTO categories(id ,name)
VALUES
    ( 1, 'CPU' ),
    ( 2, 'GPU'),
    ( 3, 'Hard Disk'),
    ( 4, 'Motherboard'),
    ( 5, 'PSU'),
    ( 6, 'RAM');
INSERT INTO products (id, name, description, category, price, producer, amount_in_magazine)
VALUES
    (1, 'Intel Core i9-9900K', 'Procesor dla wymagających graczy', 'CPU', 1599.99, 'Intel', 10),
    (2, 'AMD Ryzen 9 5900X', 'Potężny procesor dla entuzjastów', 'CPU', 1899.99, 'AMD', 15),
    (3, 'Intel Core i7-10700K', 'Procesor dla graczy z niskim budżetem', 'CPU', 999.99, 'Intel', 20),
    (4, 'AMD Ryzen 7 5800X', 'Wydajny procesor dla gamingu', 'CPU', 1299.99, 'AMD', 12),
    (5, 'Intel Core i5-10600K', 'Solidny procesor dla średniozaawansowanych graczy', 'CPU', 499.99, 'Intel', 30),
    (6, 'AMD Ryzen 5 5600X', 'Dobra wydajność w przystępnej cenie', 'CPU', 349.99, 'AMD', 25),
    (7, 'Intel Core i9-11900K', 'Najnowszy flagowy procesor Intela', 'CPU', 1799.99, 'Intel', 8),
    (8, 'AMD Ryzen 9 5950X', 'Wielordzeniowy potwór dla profesjonalistów', 'CPU', 2399.99, 'AMD', 5),
    (9, 'Intel Core i3-10100', 'Procesor do podstawowych zastosowań', 'CPU', 149.99, 'Intel', 40),
    (10, 'AMD Ryzen 3 3300X', 'Bardzo dobra wydajność w niskiej cenie', 'CPU', 199.99, 'AMD', 35),
    (11, 'Intel Core i9-10900K', 'Wydajny procesor do gier i zadań wielozadaniowych', 'CPU', 1399.99, 'Intel', 18),
    (12, 'AMD Ryzen 9 3900X', 'Potężna moc obliczeniowa dla wymagających użytkowników', 'CPU', 1699.99, 'AMD', 10),
    (13, 'Intel Core i5-11400', 'Procesor dla graczy w przystępnej cenie', 'CPU', 349.99, 'Intel', 25),
    (14, 'AMD Ryzen 5 3600X', 'Doskonała wydajność w grach i aplikacjach', 'CPU', 299.99, 'AMD', 28),
    (15, 'Intel Core i7-11700K', 'Wydajny procesor dla zaawansowanych graczy', 'CPU', 899.99, 'Intel', 15),
    (16, 'AMD Ryzen 7 3700X', 'Potężny procesor dla entuzjastów', 'CPU', 399.99, 'AMD', 20),
    (17, 'Intel Core i3-9100F', 'Podstawowy procesor dla budżetowych konfiguracji', 'CPU', 99.99, 'Intel', 50),
    (18, 'AMD Ryzen 3 3100', 'Wydajność za przystępną cenę', 'CPU', 129.99, 'AMD', 45),
    (19, 'Intel Core i9-10850K', 'Procesor z dużą mocą obliczeniową', 'CPU', 1299.99, 'Intel', 12),
    (20, 'AMD Ryzen 9 3950X', 'Wielordzeniowy potwór dla profesjonalistów', 'CPU', 1999.99, 'AMD', 8),
    (21, 'Intel Core i5-10400', 'Solidny procesor do codziennego użytku', 'CPU', 249.99, 'Intel', 32),
    (22, 'AMD Ryzen 5 2600X', 'Doskonała wydajność w grach i aplikacjach', 'CPU', 199.99, 'AMD', 40),
    (23, 'Intel Core i7-9700K', 'Wydajny procesor dla graczy', 'CPU', 699.99, 'Intel', 22),
    (24, 'AMD Ryzen 7 2700X', 'Wydajność i płynność dla graczy', 'CPU', 299.99, 'AMD', 25),
    (25, 'Intel Core i3-8100', 'Procesor do zastosowań biurowych', 'CPU', 149.99, 'Intel', 60),
    (26, 'AMD Ryzen 3 2200G', 'Wydajność w przystępnej cenie', 'CPU', 99.99, 'AMD', 55),
    (27, 'Intel Core i9-10980XE', 'Potężny procesor dla profesjonalistów', 'CPU', 2999.99, 'Intel', 5),
    (28, 'AMD Ryzen Threadripper 3990X', 'Niezrównana wydajność wielowątkowa', 'CPU', 3999.99, 'AMD', 2),
    (29, 'Intel Core i7-8700K', 'Wydajny procesor do zadań domowych i biurowych', 'CPU', 499.99, 'Intel', 28),
    (30, 'AMD Ryzen 7 1700X', 'Wydajność i elastyczność dla entuzjastów', 'CPU', 199.99, 'AMD', 30),
    (31, 'Intel Core i5-9600K', 'Solidna wydajność w grach i aplikacjach', 'CPU', 299.99, 'Intel', 35),
    (32, 'AMD Ryzen 5 1600', 'Wydajność dla entuzjastów', 'CPU', 149.99, 'AMD', 38),
    (33, 'Intel Core i3-9100', 'Podstawowy procesor dla użytkowników domowych', 'CPU', 129.99, 'Intel', 42),
    (34, 'AMD Ryzen 3 3200G', 'Wydajność i wbudowana karta graficzna', 'CPU', 129.99, 'AMD', 48),
    (35, 'Intel Core i9-11900KF', 'Wydajny procesor dla wymagających użytkowników', 'CPU', 1799.99, 'Intel', 8),
    (36, 'AMD Ryzen 9 5900', 'Potężna moc obliczeniowa dla zaawansowanych użytkowników', 'CPU', 1999.99, 'AMD', 6),
    (37, 'Intel Core i5-11600K', 'Solidny procesor dla graczy w przystępnej cenie', 'CPU', 329.99, 'Intel', 20),
    (38, 'AMD Ryzen 5 5600G', 'Wydajność i wbudowana karta graficzna', 'CPU', 199.99, 'AMD', 15),
    (39, 'Intel Core i7-10700KF', 'Wydajny procesor dla entuzjastów', 'CPU', 799.99, 'Intel', 10),
    (40, 'AMD Ryzen 7 5800', 'Wydajność i elastyczność dla użytkowników domowych', 'CPU', 1699.99, 'AMD', 5),
    (41, 'Intel Core i3-10105F', 'Podstawowy procesor dla budżetowych konfiguracji', 'CPU', 129.99, 'Intel', 55),
    (42, 'AMD Ryzen 3 3300', 'Wydajność w przystępnej cenie', 'CPU', 149.99, 'AMD', 50),
    (43, 'Intel Core i9-10850KF', 'Wydajny procesor dla zaawansowanych użytkowników', 'CPU', 1299.99, 'Intel', 12),
    (44, 'AMD Ryzen 9 3900', 'Potężna moc obliczeniowa dla wymagających użytkowników', 'CPU', 1699.99, 'AMD', 8),
    (45, 'Intel Core i5-11400F', 'Procesor dla graczy w przystępnej cenie', 'CPU', 269.99, 'Intel', 25),
    (46, 'AMD Ryzen 5 3600', 'Doskonała wydajność w grach i aplikacjach', 'CPU', 249.99, 'AMD', 30),
    (47, 'Intel Core i7-11700KF', 'Wydajny procesor dla zaawansowanych graczy', 'CPU', 899.99, 'Intel', 15),
    (48, 'AMD Ryzen 7 3700', 'Potężny procesor dla entuzjastów', 'CPU', 349.99, 'AMD', 18),
    (49, 'Intel Core i3-10320', 'Podstawowy procesor dla użytkowników domowych', 'CPU', 129.99, 'Intel', 40),
    (50, 'AMD Ryzen 3 3100X', 'Wydajność w przystępnej cenie', 'CPU', 159.99, 'AMD', 35);

INSERT INTO cpus (id, core, base_frequency)
VALUES
    (1, 8, 3.6),
    (2, 12, 3.7),
    (3, 8, 3.8),
    (4, 16, 4.2),
    (5, 6, 3.4),
    (6, 6, 3.5),
    (7, 10, 3.9),
    (8, 16, 4.0),
    (9, 4, 3.0),
    (10, 4, 3.2),
    (11, 10, 3.7),
    (12, 12, 3.6),
    (13, 6, 3.3),
    (14, 8, 3.9),
    (15, 8, 4.0),
    (16, 12, 4.1),
    (17, 4, 2.8),
    (18, 4, 3.1),
    (19, 10, 3.8),
    (20, 16, 4.3),
    (21, 6, 3.2),
    (22, 8, 3.7),
    (23, 8, 3.9),
    (24, 12, 4.2),
    (25, 4, 2.6),
    (26, 4, 3.0),
    (27, 12, 4.0),
    (28, 16, 4.4),
    (29, 8, 3.8),
    (30, 10, 4.0),
    (31, 6, 3.4),
    (32, 8, 3.6),
    (33, 8, 3.9),
    (34, 12, 4.1),
    (35, 4, 2.9),
    (36, 4, 3.3),
    (37, 10, 3.7),
    (38, 16, 4.2),
    (39, 6, 3.5),
    (40, 8, 3.8),
    (41, 8, 4.0),
    (42, 12, 4.3),
    (43, 4, 2.7),
    (44, 4, 3.1),
    (45, 10, 3.9),
    (46, 16, 4.5),
    (47, 6, 3.3),
    (48, 8, 3.7),
    (49, 8, 3.9),
    (50, 12, 4.2);