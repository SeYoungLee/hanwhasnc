create table guestbook(
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(200) NOT NULL, 
content VARCHAR(4000) NOT NULL,
regdate TIMESTAMP);
