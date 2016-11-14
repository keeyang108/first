/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - ad
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ad` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ad`;

/*Table structure for table `t_agency` */

DROP TABLE IF EXISTS `t_agency`;

CREATE TABLE `t_agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) DEFAULT NULL,
  `agency_name` varchar(200) DEFAULT NULL,
  `agency_address` varchar(200) DEFAULT NULL,
  `connect_phone` varchar(45) DEFAULT NULL COMMENT '联系电话',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `INDEX_CITY_ID` (`city_id`),
  CONSTRAINT `FOREIGN_CITY_ID` FOREIGN KEY (`city_id`) REFERENCES `t_city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_brand` */

DROP TABLE IF EXISTS `t_brand`;

CREATE TABLE `t_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `decription` varchar(200) DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_car` */

DROP TABLE IF EXISTS `t_car`;

CREATE TABLE `t_car` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  `brand_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_brand_id` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_channel` */

DROP TABLE IF EXISTS `t_channel`;

CREATE TABLE `t_channel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT '0',
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `t_city` */

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_id` int(11) DEFAULT NULL,
  `city_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `foreign_key_province_id_idx` (`province_id`),
  CONSTRAINT `FOREIGN_PROVINCE_ID` FOREIGN KEY (`province_id`) REFERENCES `t_province` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_sex` int(4) DEFAULT NULL,
  `agency_id` int(20) NOT NULL COMMENT '经销商id',
  `city_id` int(10) NOT NULL,
  `province_id` int(4) NOT NULL,
  `car_type_id` int(10) NOT NULL,
  `channel_id` int(4) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `INDEX_AGENCY_ID` (`agency_id`),
  KEY `index_city_id` (`city_id`),
  KEY `index_channel_id` (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `t_province` */

DROP TABLE IF EXISTS `t_province`;

CREATE TABLE `t_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `t_supervisor` */

DROP TABLE IF EXISTS `t_supervisor`;

CREATE TABLE `t_supervisor` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `supervisor_name` varchar(20) NOT NULL,
  `supervisor_phone` varchar(20) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `sex` int(4) DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `qq` int(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `head_image_path` varchar(100) DEFAULT NULL,
  `status` int(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_supervisor_phone` (`supervisor_phone`),
  KEY `index_supervisor_name` (`supervisor_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_supervisor_event` */

DROP TABLE IF EXISTS `t_supervisor_event`;

CREATE TABLE `t_supervisor_event` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `supervisor_id` int(20) NOT NULL,
  `event_name` varchar(50) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_supervisor_id` (`supervisor_id`),
  KEY `index_ip` (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `t_users` */

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `user_name` varchar(50) DEFAULT NULL,
  `phone` varchar(11) NOT NULL COMMENT 'user phone ',
  `sex` int(4) DEFAULT '0',
  `soft_del` int(4) DEFAULT '0',
  `create_time` datetime DEFAULT NULL COMMENT 'createtime',
  PRIMARY KEY (`id`),
  KEY `INDEX_PHONE` (`phone`),
  KEY `INDEX_ID_PHONE` (`id`,`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
