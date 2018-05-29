CREATE TABLE EMPLOYE(
id INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT EMPLOYE_PK PRIMARY KEY,
login varchar(50),
password varchar(50),
prenom varchar(50),
nom varchar(50),
email varchar(50),
role varchar(50)
);

CREATE SEQUENCE customers_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;