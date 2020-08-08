CREATE DATABASE /*!32312 IF NOT EXISTS*/`projectmgmt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `projectmgmt`;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` bigint(20) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `company` */

insert  into `company`(`company_id`,`company_name`) values 
(1,'MyCompany');

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(7),
(7),
(7);

/*Table structure for table `party` */

DROP TABLE IF EXISTS `party`;

CREATE TABLE `party` (
  `party_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `party_email` varchar(255) DEFAULT NULL,
  `party_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `party` */

insert  into `party`(`party_id`,`party_email`,`party_name`) values 
(1,'party@project.com','Party1');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `company_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FK2rm76aaedrcksbnjk7ofakbsj` (`company_company_id`),
  CONSTRAINT `FK2rm76aaedrcksbnjk7ofakbsj` FOREIGN KEY (`company_company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`company_company_id`) values 
(1,'P1',1);

/*Table structure for table `project_task` */

DROP TABLE IF EXISTS `project_task`;

CREATE TABLE `project_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_project_id` bigint(20) DEFAULT NULL,
  `task_task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FKbpcac3bn1s2nuku6ciy4430o8` (`project_project_id`),
  KEY `FKpnfxl0t8ichdgxw8muitmlcjm` (`task_task_id`),
  CONSTRAINT `FKbpcac3bn1s2nuku6ciy4430o8` FOREIGN KEY (`project_project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `FKpnfxl0t8ichdgxw8muitmlcjm` FOREIGN KEY (`task_task_id`) REFERENCES `task` (`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `project_task` */

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) DEFAULT NULL,
  `party_party_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FK6hjqjfk3dn1xquf3r09x3da0f` (`party_party_id`),
  CONSTRAINT `FK6hjqjfk3dn1xquf3r09x3da0f` FOREIGN KEY (`party_party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `task` */

insert  into `task`(`task_id`,`task_name`,`party_party_id`) values 
(1,'Mytask',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `company_company_id` bigint(20) DEFAULT NULL,
  `party_party_id` bigint(20) DEFAULT NULL,
  `type_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKkc36j0ivsculof5470bjks2xf` (`company_company_id`),
  KEY `FKq1wsgcuhyal3i5w9d3jrcf2ry` (`party_party_id`),
  KEY `FKjklht2gn8c938r2ncogtpef4t` (`type_type_id`),
  CONSTRAINT `FKjklht2gn8c938r2ncogtpef4t` FOREIGN KEY (`type_type_id`) REFERENCES `user_type` (`type_id`),
  CONSTRAINT `FKkc36j0ivsculof5470bjks2xf` FOREIGN KEY (`company_company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `FKq1wsgcuhyal3i5w9d3jrcf2ry` FOREIGN KEY (`party_party_id`) REFERENCES `party` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`company_company_id`,`party_party_id`,`type_type_id`) values 
(4,'KISHORE',1,1,3),
(6,'KISHORE1',1,1,5);

/*Table structure for table `user_type` */

DROP TABLE IF EXISTS `user_type`;

CREATE TABLE `user_type` (
  `type_id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_type` */

insert  into `user_type`(`type_id`,`type`) values 
(2,'company'),
(3,'company'),
(5,'company');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
