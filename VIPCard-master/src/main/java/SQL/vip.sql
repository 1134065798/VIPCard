/*
SQLyog Ultimate v12.4.0 (64 bit)
MySQL - 5.7.19-0ubuntu0.16.04.1 : Database - vip
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`vip` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `vip`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `activeCode` varchar(50) NOT NULL,
  `cardId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`activeCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `card` */

insert  into `card`(`activeCode`,`cardId`) values 
('123456','00000009'),
('123460','00000010'),
('123464','00000011');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `openId` varchar(50) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `userName` varchar(150) DEFAULT NULL,
  `userSex` varchar(10) DEFAULT NULL,
  `userSchool` varchar(100) DEFAULT NULL,
  `userMajor` varchar(100) DEFAULT NULL,
  `userPhoto` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`openId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`openId`,`phone`,`userName`,`userSex`,`userSchool`,`userMajor`,`userPhoto`) values 
('00000100000200000300000400000501','10011110001','赵一','男','西科大','采矿','test1'),
('00000100000200000300000400000502','10011110002','钱二','女','工程大','纺织','test2'),
('00000100000200000300000400000503','10011110003','孙三','男','西电','电信','test3'),
('00000100000200000300000400000504','10011110004','李四','女','西邮','物联','test4'),
('00000100000200000300000400000505','10011110005','周五','女','西医','医学','test5'),
('00000100000200000300000400000506','10011110006','吴六','女','陕铁','铁道','test6'),
('00000100000200000300000400000507','10011110007','郑七','男','师大','教育','test7'),
('00000100000200000300000400000508','10011110008','王八','男','新卓越','Java','test8');

/*Table structure for table `vipCard` */

DROP TABLE IF EXISTS `vipCard`;

CREATE TABLE `vipCard` (
  `cardId` varchar(50) NOT NULL,
  `openId` varchar(50) DEFAULT NULL,
  `qrCode` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`cardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vipCard` */

insert  into `vipCard`(`cardId`,`openId`,`qrCode`) values 
('00000001','00000100000200000300000400000501','qrtest1'),
('00000002','00000100000200000300000400000502','qrtest2'),
('00000003','00000100000200000300000400000503','qrtest3'),
('00000004','00000100000200000300000400000504','qrtest4'),
('00000005','00000100000200000300000400000505','qrtest5'),
('00000006','00000100000200000300000400000506','qrtest6'),
('00000007','00000100000200000300000400000507','qrtest7'),
('00000008','00000100000200000300000400000508','qrtest8');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
