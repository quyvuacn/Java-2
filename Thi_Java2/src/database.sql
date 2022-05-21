CREATE DATABASE students

CREATE TABLE student(
    ID VARCHAR(10),
    name VARCHAR(50),
    address VARCHAR(50),
    phone VARCHAR(10),
    PRIMARY KEY (ID)
);

INSERT INTO `student`(`ID`, `name`, `address`, `phone`)
VALUES
    ('T2109M016','Vũ Viết Quý','Thái Bình','0326459773'),
    ('T2109M017','Tạ Duy Linh','Thái Nguyên','0123456789'),
    ('T2109M018','Tạ Văn Minh','Hà Nội','0326459774'),
    ('T2109M019','Ngô Huy Hiệu','Hà Nội','0326459775'),
    ('T2109M020','Bùi Văn Dũng','Hà Nội','0326459776'),
    ('T2109M021','Đinh Quang Anh','Hà Nội','0326459777')
