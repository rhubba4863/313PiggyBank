CREATE USER 'legolas'@'localhost' IDENTIFIED BY 'arrows';

GRANT SELECT ON savingsAccount.* TO 'legolas'@'localhost';

FLUSH PRIVILEGES;

CREATE DATABASE savingsAccount;

USE savingsAccount; 

CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(30),
	password VARCHAR(30)
	);

CREATE TABLE item (
	id INT AUTO_INCREMENT PRIMARY KEY,
	priority INT,
	userId INT,
	FOREIGN KEY (userId) REFERENCES user(id)
	);