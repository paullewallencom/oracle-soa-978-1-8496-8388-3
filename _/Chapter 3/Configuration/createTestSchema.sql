DROP TABLE TEST_TABLE CASCADE CONSTRAINTS;

DROP SEQUENCE TEST_SEQUENCE;

CREATE TABLE TEST_TABLE 
(
  ID NUMBER NOT NULL 
, TXID VARCHAR2(30 BYTE) 
, REMARKS VARCHAR2(20 BYTE) 
, INSERTIONDATE DATE 
, CONSTRAINT TEST_TABLE_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE "USERS" 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  BUFFER_POOL DEFAULT 
);

CREATE SEQUENCE TEST_SEQUENCE INCREMENT BY 50 MAXVALUE 9999999999999999999999999999 MINVALUE 1 NOCACHE;