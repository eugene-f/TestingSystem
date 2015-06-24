CREATE TABLE DEPARTMENTS
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  FACULTY_ID BIGINT NOT NULL,
  NAME VARCHAR(256) NOT NULL,
  DELETED BOOLEAN NOT NULL
);
ALTER TABLE DEPARTMENTS ADD CONSTRAINT DEPARTMENTS_unique_ID UNIQUE (ID);
ALTER TABLE DEPARTMENTS ADD CONSTRAINT DEPARTMENTS_unique_NAME UNIQUE (NAME);