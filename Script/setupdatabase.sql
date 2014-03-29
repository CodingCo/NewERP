ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY';

-- Table drops
DROP TABLE bookings;
DROP TABLE apartment;
DROP TABLE apartment_type;
DROP TABLE customer;

--seq drops
DROP SEQUENCE customer_seq;
DROP SEQUENCE booking_seq;

CREATE SEQUENCE booking_seq
MINVALUE 0
MAXVALUE 99999999
START WITH 0
INCREMENT BY 1;

CREATE SEQUENCE customer_seq
MINVALUE 0
MAXVALUE 99999999
START WITH 0
INCREMENT BY 1;

CREATE TABLE apartment_type(
type VARCHAR2(10) PRIMARY KEY,
price NUMBER(4) NOT NULL,
capacity number(1) NOT NULL
);

CREATE TABLE apartment(
a_num NUMBER PRIMARY KEY,
type VARCHAR2(10)NOT NULL REFERENCES apartment_type(type)
);

CREATE TABLE customer(
cust_id number(8) PRIMARY KEY,
first_name VARCHAR2(32) NOT NULL,
family_name VARCHAR2(32) NOT NULL,
age NUMBER NOT NULL,
email VARCHAR2(32) NOT NULL,
phone VARCHAR2(16) NOT NULL,
country VARCHAR2(32) NOT NULL,
city VARCHAR2(32) NOT NULL,
zipcode NUMBER NOT NULL,
street VARCHAR2(32) NOT NULL,
version_num NUMBER 
);



CREATE TABLE bookings(
b_id number(8) PRIMARY KEY,
cust_id number(8) NOT NULL REFERENCES customer(cust_id),
a_num number NOT NULL REFERENCES apartment(a_num),
date_from DATE NOT NULL,
number_of_nights NUMBER(4) NOT NULL,
travelagency VARCHAR2(16),
rent DECIMAL(10,2) NOT NULL,
version_num NUMBER
);


INSERT INTO apartment_type(type,price,capacity) VALUES('Single', 60, 1);
INSERT INTO apartment_type(type,price,capacity) VALUES('Double', 80, 2);
INSERT INTO apartment_type(type,price,capacity) VALUES('Family', 100, 5);

INSERT INTO customer VALUES(customer_seq.NEXTVAL, 'Kasper','Hald',25,12345678,'bla@bla.dk','Java','csharp',4242,'cplusplus',0);
INSERT INTO customer VALUES(customer_seq.NEXTVAL, 'Simon','Gronborg',20,6666666,'bla2@bla2.dk','Python','PHP',1337,'DOTNET',0);
INSERT INTO customer VALUES(customer_seq.NEXTVAL, 'Thomas','Hedegaard',21,42424242,'bla2@bla3.dk','country','city',1336,'street',0);
INSERT INTO customer VALUES(customer_seq.NEXTVAL, 'Christoffer','mor',22,99999999,'bla2@bla4.dk','country','city',1338,'street',0);

BEGIN
   FOR i IN 1..40 
   LOOP 
      INSERT INTO apartment VALUES(i,'Single');
   END LOOP;
   FOR i IN 41..90 
   LOOP 
      INSERT INTO apartment VALUES(i,'Double');
   END LOOP;
   FOR i IN 91..104 
   LOOP 
      INSERT INTO apartment VALUES(i,'Family');
   END LOOP;
END;  
/

-- HUSK DEN FUCKING BACKSLASH VED PL/SQL

INSERT INTO bookings VALUES(booking_seq.NEXTVAL, 1, 1, '23-10-13', 6, 'CODESNIPPETS', 2000.42,0);
INSERT INTO bookings VALUES(booking_seq.NEXTVAL, 2, 10, '23-10-13', 3, 'ASSEMBLE', 2900.42,0);
INSERT INTO bookings VALUES(booking_seq.NEXTVAL, 3, 42, '23-10-13', 5, 'SATURN REJSER', 100.42,0);
INSERT INTO bookings VALUES(booking_seq.NEXTVAL, 4, 100, '23-10-13', 1, 'CODEBLOCKS', 500.42,0);

--select * from apartment;
--select * from apartment_type;
--select * from bookings;
--select * from customer;

commit;
