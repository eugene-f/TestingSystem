CREATE TABLE DISCIPLINES
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  TITLE VARCHAR(256) NOT NULL,
  DELETED BOOLEAN NOT NULL
);
ALTER TABLE DISCIPLINES ADD CONSTRAINT unique_ID UNIQUE (ID);
ALTER TABLE DISCIPLINES ADD CONSTRAINT unique_TITLE UNIQUE (TITLE);