USE Master
GO
IF EXISTS (SELECT * FROM sys.databases WHERE name='BaiThiSQL' )
DROP DATABASE BaiThiSQL
CREATE DATABASE BaiThiSQL
GO
USE BaiThiSQL
GO

CREATE TABLE Department (
    DepartmentCode varchar(10) PRIMARY KEY,
    DepartmentName varchar(255) NOT NULL
);
GO

-- Tạo bảng Employee
CREATE TABLE Employee (
    EmployeeCode varchar(10) PRIMARY KEY,
    EmployeeName varchar(255) NOT NULL,
    DepartmentCode varchar(10) FOREIGN KEY REFERENCES Department(DepartmentCode),
    BasicSalary money NOT NULL,
    Note varchar(255)
);
GO

-- Tạo bảng WorkingDays
CREATE TABLE WorkingDays (
    EmployeeCode varchar(10) FOREIGN KEY REFERENCES Employee(EmployeeCode),
    NumberOfWorkingDays int NOT NULL,
	NumberOfDaysOffWithPay int NOT NULL,
    NumberOfDaysOffWithoutPay int NOT NULL
);
GO

-- Tạo bảng Salary
CREATE TABLE Salary (
    EmployeeCode varchar(10) FOREIGN KEY REFERENCES Employee(EmployeeCode),
    GrossSalary money NOT NULL,
    NetSalary money NOT NULL
);
GO