use BAITHI
go
iNSERT INTO Department VALUES
(1, 'IT'),
(2, 'HR'),
(3, 'SALE');

INSERT INTO WorkRole VALUES
(1, 'DMS'),
(2, 'Data Entry'),
(3, 'Analyst'),
(4, 'Salesperson');

INSERT INTO Employee VALUES
(1, 'Trần', 'Văn Toàn', '1980-01-01', 'M', 1),
(2, 'Trần', 'Văn Nam', '1982-01-01', 'M', 1),
(3, 'Huỳnh', 'Anh', '1979-01-01', 'M', 1),
(4, 'Lê', 'Thị Bình', '1985-01-01', 'F', 2),
(5, 'Nguyễn', 'Văn A', '1987-01-01', 'M', 3),
(6, 'Lê', 'Thị B', '1986-01-01', 'F', 3),
(7, 'Nguyễn', 'Lan Mai', '1983-01-01', 'F', 3),
(8, 'Tuấn', 'Anh Hà', '1984-01-01', 'M', 3),
(9, 'Hà', 'Thị Lan Lê', '1981-01-01', 'F', 2),
(10, 'Lê', 'Tú Chinh', '1978-01-01', 'F', 1);

INSERT INTO WorkSchedule VALUES
(1, 1, '2020-10-01', '2020-10-31', '1', 22000),
(2, 1, '2020-10-01', '2020-10-31', '2', 26400);