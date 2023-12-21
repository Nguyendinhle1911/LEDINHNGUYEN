USE master
GO 
IF EXISTS (SELECT * FROM SYS.DATABASES WHERE Name ='BAITHI')
DROP DATABASE BAITHI
GO
CREATE DATABASE BAITHI
GO
USE BAITHI
GO
 CREATE TABLE Employee (
    EmployeeID INT PRIMARY KEY,
    FirstName NVARCHAR(50),
    LastName NVARCHAR(50),
    BirthDate DATE,
    Gender NVARCHAR(1),
    DepartmentID INT
);

CREATE TABLE Department (
    DepartmentID INT PRIMARY KEY,
    DepartmentName NVARCHAR(50)
);

CREATE TABLE WorkRole (
    WorkRoleID INT PRIMARY KEY,
    WorkRoleName NVARCHAR(50)
);

CREATE TABLE WorkSchedule (
    EmployeeID INT,
    WorkRoleID INT,
    StartDate DATE,
    EndDate DATE,
    DaysOff NVARCHAR(MAX),
    Salary FLOAT,
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (WorkRoleID) REFERENCES WorkRole(WorkRoleID)
);