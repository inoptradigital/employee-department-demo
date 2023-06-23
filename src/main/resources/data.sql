CREATE TABLE DEPARTMENT(id int, name varchar2);

CREATE TABLE SALARY(id int, baseSalary double);
CREATE TABLE EMPLOYEE(ID INT, NAME VARCHAR2, SALARY INT, DEPARTMENT INT);
CREATE TABLE SALARY_COMPONENT(id int, factor double, name varchar2);

INSERT INTO DEPARTMENT
VALUES (101, 'ECOM'),
       (102, 'TELECOM'),
       (103, 'FINANCE'),
       (104, 'INSURANCE');

INSERT
INTO SALARY
values (1, 10000),
       (2, 20000);

INSERT INTO SALARY_COMPONENT
VALUES (1, 5.0, 's1'),
       (2, 7.0, 's2'),
       (3, 10.0, 's3');

INSERT INTO EMPLOYEE
VALUES (111, 'AAA', 101, 1),
       (222, 'BBB', 102, 2),
       (333, 'CCC', 103, 1),
       (444, 'DDD', 104, 2),
       (555, 'EEE', 101, 1),
       (666, 'FFF', 102, 2),
       (777, 'GGG', 101, 1),
       (888, 'GGG', 103, 2),
       (999, 'HHH', 104, 1),
       (000, 'III', 101, 1);