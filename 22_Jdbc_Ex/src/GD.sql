DROP SEQUENCE CONTACT_SEQ;
CREATE SEQUENCE CONTACT_SEQ ORDER;

DROP TABLE CONTACT_T;
CREATE TABLE CONTACT_T (
	 CONTACT_NO NUMBER             NOT NULL
	,NAME       VARCHAR2(100 BYTE) NOT NULL
	,TEL        VARCHAR2(100 BYTE) NULL
	,EMAIL      VARCHAR2(100 BYTE) NULL
	,ADDRESS    VARCHAR2(100 BYTE) NULL
	,CREATED_AT VARCHAR2(100 BYTE) NOT NULL
	,CONSTRAINT PK_CONTACT PRIMARY KEY(CONTACT_NO)
);

SELECT * FROM CONTACT_T;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS')
  FROM DUAL;