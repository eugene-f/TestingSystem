CREATE TABLE USERS
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  passwordHash VARCHAR(50) NOT NULL
);
ALTER TABLE USERS ADD CONSTRAINT unique_id UNIQUE (id);