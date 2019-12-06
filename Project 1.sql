CREATE TABLE Reimbursement_Type(
reimb_type_id NUMBER PRIMARY KEY,
reimb_type VARCHAR2(50)
);


CREATE TABLE Reimbursement_Status(
reimb_status_id NUMBER PRIMARY KEY,
reimb_status VARCHAR2(50)
);

CREATE TABLE Reimbursement(
reimb_id_pk NUMBER PRIMARY KEY,
amount NUMBER,
dates VARCHAR2(50),
reimb_desc VARCHAR2(250),
reimb_submit VARCHAR2(50),
reimb_resolve VARCHAR2(50),
reimb_author NUMBER,
reimb_resolver NUMBER,
reimb_status_fk NUMBER,
reimb_type_fk NUMBER,
CONSTRAINT reimb_status_fk FOREIGN KEY (reimb_status_fk) REFERENCES Reimbursement_Status(reimb_status_id),
CONSTRAINT reimb_type_fk FOREIGN KEY (reimb_type_fk) REFERENCES Reimbursement_Type (reimb_type_id)
);

CREATE TABLE Employee_Role(
employee_role_id_pk NUMBER PRIMARY KEY,
employee_role VARCHAR2(50)
);

CREATE TABLE Employee(
employee_id_pk NUMBER PRIMARY KEY,
firstname VARCHAR2(50),
lastname VARCHAR2(50),
email VARCHAR2(50),
username VARCHAR2(50),
passwords VARCHAR2(50),
employee_role_fk NUMBER,
CONSTRAINT employee_role_fk FOREIGN KEY (employee_role_fk) REFERENCES Employee_Role (employee_role_id_pk)
);


INSERT INTO employee_role VALUES(1, 'Employee');
INSERT INTO employee_role VALUES(2, 'Financial Manager');

INSERT INTO reimbursement_type VALUES (1, 'Food');
INSERT INTO reimbursement_type VALUES (2, 'Travel');
INSERT INTO reimbursement_type VALUES (3, 'Lodging');
INSERT INTO reimbursement_type VALUES (4, 'Other');

INSERT INTO reimbursement_status VALUES (1, 'pending');
INSERT INTO reimbursement_status VALUES (2, 'approved');
INSERT INTO reimbursement_status VALUES (3, 'denied');

SELECT * FROM Employee_Role;
SELECT * FROM Employee;
SELECT * FROM Reimbursement;
SELECT * FROM Reimbursement_Type;
SELECT * FROM Reimbursement_Status;

DROP TABLE Employee;
DROP TABLE Employee_Role;
DROP TABLE Reimbursement;
DROP TABLE Reimbursement_Type;
DROP TABLE Reimbursement_Status;



--------------------------------------------------------------------------------------------
--Sequence and Trigger
--SEQUENCE
--An object/entity that will maintain a counter for you
CREATE SEQUENCE reimb_seq
    START WITH 1 
    INCREMENT BY 1;
    --this sequence will be used to handle the id field for employees
/
SELECT * FROM Reimbursement;

--TRIGGER
--An object/entity that we can create that waits for actions to occur and performs
--the designated code
CREATE OR REPLACE TRIGGER reimb_seq_trigger
BEFORE INSERT ON Reimbursement --when and what action happens ('after')
FOR EACH ROW
BEGIN
    IF :new.reimb_id_pk IS NULL THEN
    SELECT reimb_seq.nextval INTO :new.reimb_id_pk FROM dual;
    END IF;
END;
/

--SEQUENCE
--An object/entity that will maintain a counter for you
CREATE SEQUENCE emp_seq
    START WITH 1 
    INCREMENT BY 1;
    --this sequence will be used to handle the id field for employees
/
SELECT * FROM Reimbursement;

--TRIGGER
--An object/entity that we can create that waits for actions to occur and performs
--the designated code
CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON Employee --when and what action happens ('after')
FOR EACH ROW
BEGIN
    IF :new.employee_id_pk IS NULL THEN
    SELECT emp_seq.nextval INTO :new.employee_id_pk  FROM dual;
    END IF;
END;
/



