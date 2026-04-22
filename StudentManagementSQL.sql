CREATE DATABASE StudentDB;
GO

USE StudentDB;

CREATE TABLE Students (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    Name NVARCHAR(100),
    Email NVARCHAR(100),
    Age INT,
    IsDeleted BIT DEFAULT 0
);

INSERT INTO Students (Name, Email, Age, IsDeleted) VALUES
(N'Nguyễn Văn An', 'an.nguyen@gmail.com', 20, 0),
(N'Trần Thị Bình', 'binh.tran@gmail.com', 21, 0),
(N'Lê Hoàng Cường', 'cuong.le@gmail.com', 22, 0),
(N'Phạm Minh Đức', 'duc.pham@gmail.com', 23, 0),
(N'Hoàng Thị Hà', 'ha.hoang@gmail.com', 19, 0),
(N'Võ Quốc Huy', 'huy.vo@gmail.com', 24, 0),
(N'Đặng Thu Lan', 'lan.dang@gmail.com', 20, 0),
(N'Bùi Văn Long', 'long.bui@gmail.com', 22, 0),
(N'Ngô Thị Mai', 'mai.ngo@gmail.com', 21, 0),
(N'Đỗ Anh Tuấn', 'tuan.do@gmail.com', 23, 0);