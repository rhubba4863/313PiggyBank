CREATE USER 'legolas'@'localhost' IDENTIFIED BY 'arrows';

GRANT SELECT, UPDATE, INSERT, DELETE ON savingsAccount.* TO 'legolas'@'localhost';

FLUSH PRIVILEGES;

CREATE DATABASE savingsAccount;

USE savingsAccount; 

CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(30),
	password VARCHAR(30),
	budget DECIMAL(7,2)
	);

CREATE TABLE item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	walmartId VARCHAR(30)
	priority INT,
	userId INT,
	FOREIGN KEY (userId) REFERENCES user(id)
	);

INSERT INTO user(username, password, budget)
VALUES ('robert', 'baseball', 132.56),
	   ('braden', 'nerdface', 513.64),
	   ('peter', 'parker', 346.62);

INSERT INTO item(walmartId, priority, userId)
VALUES ('45057905', 2, 1),
	   ('38069371', 5, 3);