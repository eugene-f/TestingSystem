CREATE TABLE QUESTIONS
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  TEST_ID BIGINT NOT NULL,
  CONTENT VARCHAR(256) NOT NULL,
  TRUE_ID BIGINT NOT NULL,
  DELETED BOOLEAN NOT NULL
);
ALTER TABLE QUESTIONS ADD CONSTRAINT unique_ID UNIQUE (ID);