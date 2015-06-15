CREATE TABLE SESSIONS
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  TEST_ID BIGINT NOT NULL,
  STUDENT_ID BIGINT NOT NULL,
  START_DATE TIMESTAMP NOT NULL,
  RESULT TINYINT NOT NULL,
  FINISHED BOOLEAN NOT NULL,
  DELETED BOOLEAN NOT NULL
);
ALTER TABLE SESSIONS ADD CONSTRAINT SESSIONS_unique_ID UNIQUE (ID);