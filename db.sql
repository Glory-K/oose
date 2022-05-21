DROP
    DATABASE if EXISTS oose;
CREATE
    DATABASE oose DEFAULT CHARACTER SET UTF8;
USE
    oose;
CREATE TABLE OrdinaryMember
(
    `id`              varchar(20) NOT NULL,
    `pw`              varchar(20) NOT NULL,
    `name`            varchar(20) NOT NULL,
    `address`         varchar(20) NOT NULL,
    `phoneNum`        varchar(15) NOT NULL,
    `info_agree_date` varchar(15) NOT NULL,
    `regular`         boolean     NOT NULL,
    PRIMARY KEY (`id`)
);
INSERT INTO OrdinaryMember(id, pw, name, address, phoneNum, info_agree_date, regular)
VALUES ('아이디1', '비밀번호1', '이름1', '주소1', '전화번호1', '날짜1', true);
INSERT INTO OrdinaryMember(id, pw, name, address, phoneNum, info_agree_date, regular)
VALUES ('아이디2', '비밀번호2', '이름2', '주소2', '전화번호2', '날짜2', false);
INSERT INTO OrdinaryMember(id, pw, name, address, phoneNum, info_agree_date, regular)
VALUES ('아이디3', '비밀번호3', '이름3', '주소3', '전화번호3', '날짜3', true);
INSERT INTO OrdinaryMember(id, pw, name, address, phoneNum, info_agree_date, regular)
VALUES ('아이디4', '비밀번호4', '이름4', '주소4', '전화번호4', '날짜4', true);
