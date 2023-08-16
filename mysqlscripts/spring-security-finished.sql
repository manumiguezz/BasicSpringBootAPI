USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;


CREATE TABLE `members` (
  `user` varchar(50) NOT NULL,
  `psw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `members`
VALUES
('ramiro','{bcrypt}$2a$10$S7GTZIc/KfegnP9H4GNaCOxHkvu0M32H7f9wg/lHl/c97VQtIoVvm',1),
('matias','{bcrypt}$2a$10$DWG0SGnfxqDIjx.LrywatevHjod2EbepV0W3t5d1aOoRLjSQuvszS',1),
('alejo','{bcrypt}$2a$10$0tqmRxOQufHIrIuQWNHa6.M4ei4LbE4NhN6gfUEOOnxpkbzLABGc6',1);


CREATE TABLE `roles` (
  `user` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user`) REFERENCES `members` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `roles`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');
