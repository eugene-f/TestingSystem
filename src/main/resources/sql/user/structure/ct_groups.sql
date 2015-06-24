CREATE TABLE GROUPS
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  FACULTY_ID BIGINT NOT NULL,
  NAME VARCHAR(256) NOT NULL,
  DELETED BOOLEAN NOT NULL
);
ALTER TABLE GROUPS ADD CONSTRAINT GROUPS_unique_ID UNIQUE (ID);
ALTER TABLE GROUPS ADD CONSTRAINT GROUPS_unique_NAME UNIQUE (NAME);