USE BaiThiSQL
GO

CREATE VIEW TotalSalaries AS 
SELECT 
    D.DepartmentCode AS DepartmentCode,
    D.DepartmentName AS DepartmentName,
    SUM(S.GrossSalary) AS TotalGrossSalary,
    SUM(S.NetSalary) AS TotalNetSalary
FROM 
    Department D
JOIN Employee E ON D.DepartmentCode = E.DepartmentCode
JOIN Salary S ON E.EmployeeCode = S.EmployeeCode
GROUP BY 
    D.DepartmentCode, D.DepartmentName;

SELECT * FROM TotalSalaries
ORDER BY DepartmentCode ASC;