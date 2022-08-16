USE smsdb;

DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS student;
--
-- Table structure for table `student`
--
CREATE TABLE student (
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	class VARCHAR(45) NOT NULL
);

--
-- Table structure for table `address`
--
CREATE TABLE address (
	id int NOT NULL AUTO_INCREMENT,
	flatno VARCHAR(45) NOT NULL,
	street VARCHAR(45) NOT NULL,
	district VARCHAR(45),
    state VARCHAR(45),
    pin VARCHAR(45),
    contact VARCHAR(45) NOT NULL,
	student_id int,
	PRIMARY KEY(id),
    FOREIGN KEY (student_id)
	REFERENCES student(id)
);
