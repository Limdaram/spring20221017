USE mydb1;

-- 테이블 만들기
CREATE TABLE myTable01(
  -- 컬럼명 자료형 나열
  col1 VARCHAR(255),
  col2 VARCHAR(255),
  col3 VARCHAR(255)
);

SELECT * FROM myTable01;

-- 테이블 구조 보기
DESCRIBE myTable01;
DESC myTable01;

-- 새 테이블 만들기 (myTable02)
CREATE TABLE myTable02 (
  name VARCHAR(255),
  age INTEGER,
  address VARCHAR(255)
);

DESCRIBE myTable02;

-- 테이블 삭제
DROP TABLE myTable02;
DROP TABLE myTable01;

-- 이미 가지고 있는 테이블 복사하기
CREATE TABLE myCustomers AS SELECT * FROM w3schools.Customers;
DESC myCustomers;
SELECT * FROM myCustomers;

CREATE TABLE myEmployees AS SELECT * FROM w3schools.Employees;
DESC myEmployees;
SELECT * FROM myEmployees;

-- Products
CREATE TABLE myProducts AS SELECT ProductID id,
    ProductName name, Price price
    FROM w3schools.Products;
DESC myProducts;
seLECT * FROM myProducts;