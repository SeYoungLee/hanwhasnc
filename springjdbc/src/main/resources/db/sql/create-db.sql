create table member(id bigint auto_increment, email varchar(200) not null, name varchar(200));
CREATE TABLE ROLE(
   role_id      INTEGER NOT NULL,
   description  VARCHAR(100)
);
ALTER TABLE ROLE
   ADD CONSTRAINT role_pk
   PRIMARY KEY (role_id);

insert into member(email, name) values ('urstory@gmail.com', 'kim');
insert into member(email, name) values ('carami@nate.com', 'kang');
insert into member(email, name) values ('urstory@sunnyvale.co.kr', 'choi');


INSERT INTO ROLE VALUES (100, 'Developer');
INSERT INTO ROLE VALUES (101, 'Researcher');
INSERT INTO ROLE VALUES (102, 'Project manager');
INSERT INTO ROLE VALUES (500, 'CTO');