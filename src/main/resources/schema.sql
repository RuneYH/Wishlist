CREATE TABLE WISH(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(MAX),
  price BIGINT NOT NULL,
  link VARCHAR(MAX),
  img VARCHAR(MAX)
);

CREATE TABLE USER(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  usn VARCHAR(64),
  psw VARCHAR(64)
);