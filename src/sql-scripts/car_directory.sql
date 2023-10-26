CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;


DROP SCHEMA IF EXISTS `car_directory`;

CREATE SCHEMA `car_directory`;

use `car_directory`;

--
-- Table structure for car directory
--

CREATE TABLE `car_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `current_location` varchar(128) DEFAULT NULL,
  `model_year` int NOT NULL,
  `price` float NOT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `make` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    `continent` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(45) DEFAULT NULL,
  `postalcode` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `owner` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  
   PRIMARY KEY (`id`),
  
  KEY `FK_OWNER_LOCATION_idx` (`location_id`),
  CONSTRAINT `FK_OWNER_LOCATION` 
  FOREIGN KEY (`location_id`) 
  REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `car` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(45) DEFAULT NULL,
  `make_id` int DEFAULT NULL,
  `car_detail_id` int DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  `owner_id` int DEFAULT NULL,
  `vin` varchar(45) DEFAULT NULL,
 
  PRIMARY KEY (`id`),
  
  KEY `FK_DETAIL_idx` (`car_detail_id`),
  CONSTRAINT `FK_DETAIL` 
  FOREIGN KEY (`car_detail_id`) 
  REFERENCES `car_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  KEY `FK_LOCATION_idx` (`location_id`),
  CONSTRAINT `FK_LOCATION` 
  FOREIGN KEY (`location_id`) 
  REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  KEY `FK_OWNER_idx` (`owner_id`),
  CONSTRAINT `FK_OWNER` 
  FOREIGN KEY (`owner_id`) 
  REFERENCES `owner` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  KEY `FK_MAKE_ID_idx` (`make_id`),
  CONSTRAINT `FK_MAKE` 
  FOREIGN KEY (`make_id`) 
  REFERENCES `make` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `make` VALUES 
	(1,'Porsche','Europe'),
    (2,'Toyota','Asia'),
    (3,'Nissan','Asia');

INSERT INTO `car_detail` VALUES 
	(1,'Bucharest',2019,19000,'Red'),
	(2,'Craiova',1999,80000,'Blue'),
	(3,'New York',2020,34500,'White'),
	(4,'Barcelona',2022,21000,'Black'),
	(5,'Tokyo',2019,10502,'Pink');

INSERT INTO `location` VALUES 
	(1,'London',3025),
	(2,'Bucharest',2048),	
    (3,'Craiova',200769),
    (4,'Ryga',2052);
    
INSERT INTO `owner` VALUES
	(1,'Eduard','Epurica',4),
    (2,'John','Lopez',2),
    (3,'Ana','Safta',3),
    (4,'Claudiu','Epurica',4),
    (5,'Vlad','Manole',1);
    

INSERT INTO `car` VALUES 
	(1,'911',1,1,2,1,'WP0ZZZ99Z5S7323'),
	(2,'Supra',2,2,1,2,'WP0ZZZ99Z5S7423'),
	(3,'300z',3,3,1,3,'WP0ZZZ99Z5S7533'),
	(4,'Yaris',2,4,2,4,'WP0ZZZ99Z5S763'),
	(5,'Taycan',1,5,1,5,'WP0ZZZ99Z5S7313');

