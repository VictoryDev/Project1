CREATE TABLE Reimbursement(
reimb_id_pk NUMBER PRIMARY KEY,
reimb_id NUMBER,
amount NUMBER,
dates DATE,
reimb_submit TIMESTAMP,
reimb_resolve TIMESTAMP,
reimb_author NUMBER,
reimb_resolver NUMBER,
CONSTRAINT reimb_status_fk FOREIGN KEY (reimb_id_pk) REFERENCES Reimbursement_Status(reimb_status_id),
CONSTRAINT reimb_type_fk FOREIGN KEY (reimb_id_pk) REFERENCES Reimbursement_Type (reimb_type_id)
);

SELECT* FROM reimbursement;
INSERT INTO Reimbursements VALUES (reimb_id=1, amount=1, dates =getdate());


CREATE TABLE Employee(
employee_id_pk NUMBER PRIMARY KEY,
firstname VARCHAR2(50),
lastname VARCHAR2(50),
email VARCHAR2(50),
username VARCHAR2(50),
passwords VARCHAR2(50),
employee_role VARCHAR2(50),
CONSTRAINT reimb_id_fk FOREIGN KEY (employee_id_pk) REFERENCES Reimbursement (reimb_id_pk)
);

SELECT * FROM Employee;

CREATE TABLE Reimbursement_Status(
reimb_status_id NUMBER PRIMARY KEY,
reimb_status VARCHAR2(50)
);

SELECT* FROM reimbursement_status;

CREATE TABLE Reimbursement_Type(
reimb_type_id NUMBER PRIMARY KEY,
reimb_type VARCHAR2(50)
);

SELECT* FROM reimbursement_type;

CREATE TABLE Employee_Role(
employee_role_id_pk NUMBER PRIMARY KEY,
employee_role VARCHAR2(50),
CONSTRAINT employee_id_fk FOREIGN KEY (employee_role_id_pk) REFERENCES Employee (employee_id_pk)
);

SELECT * FROM Employee_Role;
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
    SELECT reimb_seq.nextval INTO :new.reimb_id_pk, :new.reimb_status_id, :new.reimb_type_id FROM dual;
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

DROP TABLE Employee;
DROP TABLE Reimbursement;
DROP TABLE Employee_Role;
DROP TABLE Reimbursement_Type;
DROP TABLE Reimbursement_Status;

