IF EXISTS (SELECT * FROM sys.databases WHERE Name='LAB10')
     DROP DATABASE lab10
	 GO
	 CREATE DATABASE lab10
	 GO
	 USE lab10	
	 GO
	CREATE TABLE (
	MaLopHoc INT PRIMARY KEY IDENTITY,
	TenLopHoc VARCHAR (10)
	)
	GO
	CREATE TABLE SinhVien(
	MaSV int PRIMARY KEY,
	TenSV VARCHAR (40),
	MaLopHoc int,
	CONSTRAINT FK FOREIGN KEY (MaLopHoc) REFERENCES lopHoc(MaLopHoc)
	)
	GO
	CREATE TABLE SanPham (
	MaSP int NOT  NULL,
	TenSP VARCHAR (40) NULL
	)
