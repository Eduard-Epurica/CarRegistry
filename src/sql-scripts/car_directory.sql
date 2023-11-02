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
  `type` varchar(45) DEFAULT NULL,
  `model_year` int NOT NULL,
  `price` float NOT NULL,
  `color` varchar(45) DEFAULT NULL,
  `image_link` varchar(256) DEFAULT NULL,
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
    (3,'Nissan','Asia'),
    (4,'Kia','Asia'),
    (5,'Hyundai','Asia'),
    (6,'Mazda','Asia'),
    (7,'BMW','Europe'),
    (8,'Volkswagen','Europe'),
    (9,'Mercedes-Benz','Europe'),
    (10,'Skoda','Europe'),
    (11,'Lamborghini','Europe'),
    (12,'Fiat','Europe'),
    (13,'Seat','Europe'),
    (14,'Volvo','Europe'),
    (15,'Dacia','Europe'),
    (16,'Ford','North America'),
    (17,'Chevrolet','North America'),
    (18,'Tesla','North America'),
    (19,'Dodge','North America'),
    (20,'Cadillac','North America'),
    (21,'Suzuki','Asia'),
    (22,'Peugeot','Europe'),
    (23,'Renault','Europe');

INSERT INTO `car_detail` VALUES 
	(1,'Convertible',2019,19000,'Red','https://purepng.com/public/uploads/large/purepng.com-red-porsche-911-gt3-rs-4-carcarvehicletransportporsche-961524661235vbivb.png'),
	(2,'Coupe',1999,80000,'Blue','https://www.toyota.co.nz/globalassets/car-images/supra-dbza-nm1-d06-20.png'),
	(3,'Coupe',2020,34500,'White','https://www.nissan-global.com/EN/HERITAGE/img/modelDetail/402/high.jpg'),
	(4,'Hatchback',2022,21000,'Black','https://t1-cms.images.toyota-europe.com/toyotaone/gben/1.6-pure-white_tcm-3060-2080305.png'),
	(5,'Sedan',2019,10502,'Pink','https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_default/v1/editorial/vhs/porsche-taycan.png');

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

