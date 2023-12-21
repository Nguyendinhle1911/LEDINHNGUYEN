USE BaiThiSQL
GO

-- Nhập dữ liệu vào bảng Department
INSERT INTO Department (DepartmentCode, DepartmentName)
VALUES ('IT', 'Room IT'),
	   ('HR', 'Room HR'),
	   ('SALE', 'Room SALE');
GO

-- Nhập dữ liệu vào bảng Employee
INSERT INTO Employee (EmployeeCode, EmployeeName, DepartmentCode, BasicSalary, Note)
VALUES ('A1', 'Nguyễn Văn A', 'IT', 1.000, NULL),
       ('A2', 'Lê Thị Bình', 'IT', 1.200, NULL),
       ('B1', 'Nguyễn Lan', 'HR', 600, NULL),
       ('D1', 'Mai Tuấn Anh', 'HR', 500, NULL),
	   ('C1', 'Hà Thị Lan', 'HR', 500, NULL),
	   ('C2', 'Lê Tú Chinh', 'SALE', 1.200, NULL),
	   ('D2', 'Trần Văn Toàn', 'HR', 500, NULL),
	   ('A3', 'Trần Văn Nam', 'IT', 1.200, NULL),
	   ('B2', 'Huỳnh Anh', 'SALE', 1.200, NULL);
GO

-- Nhập dữ liệu vào bảng WorkingDays
INSERT INTO WorkingDays (EmployeeCode, NumberOfWorkingDays, NumberOfDaysOffWithPay, NumberOfDaysOffWithoutPay)
VALUES ('A1', 22, 0, 0),
       ('A2', 21, 0, 0),
       ('B1', 21, 0, 1),
       ('D1', 20, 0, 1),
	   ('C1', 22, 0, 0),
	   ('C2', 22, 0, 0),
	   ('D2', 22, 0, 0),
	   ('A3', 22, 0, 0),
	   ('B2', 21, 1, 0);
GO

-- Nhập dữ liệu vào bảng Salary
INSERT INTO Salary (EmployeeCode, GrossSalary, NetSalary)
VALUES ('A1', 22.000, 20.000),
       ('A2', 26.400, 23.000),
       ('B1', 13.200, 12.000),
       ('D1', 11.000, 10.000),
	   ('C1', 11.000, 10.000),
	   ('C2', 26.400, 23.000),
	   ('D2', 11.000, 10.000),
	   ('A3', 26.400, 23.000),
	   ('B2', 26.400, 23.000);
GO