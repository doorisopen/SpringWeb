/* CREATE TABLE
 * 
 *
 */
# Create User Table 
CREATE TABLE springdb.aop_user(
	userIdx int not null auto_increment,
    userId varchar(25) not null,
    userPw varchar(25) not null,
    userNickName varchar(25) not null,
	userAge varchar(25) not null,
    userPhone int(20) not null,
    userAddress varchar(255) not null,
	registerDate datetime not null default current_timestamp,
    authority varchar(25) not null default 'ROLE_USER',
    enabled int not null default 1,
    PRIMARY KEY(userIdx)
);

# Create Board Table 
CREATE TABLE springdb.aop_board(
	boardIdx int not null auto_increment,
    boardTitle varchar(255) not null,
    boardContent varchar(255) not null,
    boardFlag char(3) not null,
    writer varchar(25) not null,
    writeDate datetime not null default current_timestamp,
    modifier varchar(25),
    modifyDate datetime,
    enabled int not null default 1,
	PRIMARY KEY(boardIdx)
);

# Create Store Table 
CREATE TABLE springdb.aop_store(
	storeIdx int not null auto_increment,
    storeName varchar(25) not null,
    storeAddress varchar(255) not null,
    storeTel varchar(25) not null,
    storeCategory varchar(25) not null,
    orderCount int not null default 0,
    reviewCount int not null default 0,
    goodCount int not null default 0,
    writer varchar(25) not null,
    writeDate datetime not null default current_timestamp,
	PRIMARY KEY(storeIdx)
);

# Create Menu Table
CREATE TABLE springdb.aop_menu(
	menuIdx int not null auto_increment,
    storeName varchar(25) not null,
    menuName varchar(25) not null,
    menuPrice int not null,
    enabled int not null default 1,
	PRIMARY KEY(menuIdx)
);

# Create review Table
CREATE TABLE springdb.aop_review(
	reviewIdx int not null auto_increment,
    storeName varchar(25) not null,
    reviewContent text,
    writer varchar(25) not null,
    writeDate datetime not null default current_timestamp,
	PRIMARY KEY(reviewIdx)
);

/* INSERT DATE
 * 
 */
# INSERT data aop_user table 
INSERT INTO springdb.aop_user (userId, userPw, userNickName, userAge, userPhone, userAddress) VALUES ('user1@kpu.ac.kr', '1111', 'spring', '25', '01011112222', '시흥시');
INSERT INTO springdb.aop_user (userId, userPw, userNickName, userAge, userPhone, userAddress, authority) VALUES ('ceo1@kpu.ac.kr', '1111', 'framework', '35', '01033334444', '시흥시', 'ROLE_CEO');
# INSERT data aop_board table 
INSERT INTO springdb.aop_board (boardTitle, boardContent, boardFlag, writer) VALUES ('첫번째 공지사항','공지사항 테스트 중입니다.','not','admin');
INSERT INTO springdb.aop_board (boardTitle, boardContent, boardFlag, writer) VALUES ('두번째 공지사항','공지사항 테스트 중입니다.','not','admin');
# INSERT data aop_store table 
INSERT INTO springdb.aop_store (storeName, storeAddress, storeTel, storeCategory, writer) VALUES ('전주식당','시흥시','0316667777','han','ceo1@kpu.ac.kr');
INSERT INTO springdb.aop_store (storeName, storeAddress, storeTel, storeCategory, writer) VALUES ('E동식당','시흥시','03134342365','han','ceo1@kpu.ac.kr');
INSERT INTO springdb.aop_store (storeName, storeAddress, storeTel, storeCategory, writer) VALUES ('김밥천국','시흥시','03190907878','bun','ceo1@kpu.ac.kr');
# INSERT data aop_menu table 
INSERT INTO springdb.aop_menu (menuName, storeName, menuPrice) VALUES ('제육볶음','전주식당','3500');
INSERT INTO springdb.aop_menu (menuName, storeName, menuPrice) VALUES ('돈까스','전주식당','4500');
# INSERT data aop_review table
INSERT INTO springdb.aop_review (storeName, reviewContent, writer) VALUES ('전주식당','리뷰 테스트 중입니다.','user1@kpu.ac.kr');
INSERT INTO springdb.aop_review (storeName, reviewContent, writer) VALUES ('전주식당','맛이 좋습니다.','user1@kpu.ac.kr');

/*	DROP TABLE
 *
 */
DROP TABLE springdb.aop_user;
DROP TABLE springdb.aop_store;
DROP TABLE springdb.aop_board;
DROP TABLE springdb.aop_review;
DROP TABLE springdb.aop_menu;