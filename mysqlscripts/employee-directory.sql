CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;


DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES 
	(1,'Manuel','Miguez','manum@mail.com'),
	(2,'Luca','Vinelli','lucav@mail.com'),
	(3,'Iñaki','Mariño','iñakim@mail.com'),
	(4,'Manfiu','Puerto','manfiudp@mail.com'),
	(5,'Juani','Pucheta','juanip@mail.com');

