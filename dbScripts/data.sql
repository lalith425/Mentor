-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: mentor
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (100);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor`
--

DROP TABLE IF EXISTS `mentor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentor` (
  `me_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `me_confirm_password` varchar(255) DEFAULT NULL,
  `me_contact_no` varchar(255) DEFAULT NULL,
  `me_email` varchar(255) NOT NULL,
  `me_firstname` varchar(255) DEFAULT NULL,
  `me_lastname` varchar(255) DEFAULT NULL,
  `me_linkedin_url` varchar(255) DEFAULT NULL,
  `me_password` varchar(255) NOT NULL,
  `me_userid` varchar(255) DEFAULT NULL,
  `me_years_of_experience` bigint(20) DEFAULT NULL,
  `me_active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`me_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor`
--

LOCK TABLES `mentor` WRITE;
/*!40000 ALTER TABLE `mentor` DISABLE KEYS */;
INSERT INTO `mentor` VALUES (6,'pwd','9999999999','lio@gmail.com','lio','lio','lio','$2a$10$P/cf/YnMgtLZ0QwoOLh0YeveHynSW6OksoRqvI8s7aZJ/FV8hzzla','lio',3,NULL),(5,'pwd','9988776655','lalith@gmail.com','lalith','lalith','lalith.com','$2a$10$HE3auFZaiudGFqzOIKCDB.3FfI.eYuMO9.FUgONdlO63so7munXba','lalith',8,NULL);
/*!40000 ALTER TABLE `mentor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_calendar`
--

DROP TABLE IF EXISTS `mentor_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentor_calendar` (
  `mc_id` bigint(20) NOT NULL,
  `mc_end_date` date DEFAULT NULL,
  `mc_end_time` time DEFAULT NULL,
  `mc_start_date` date DEFAULT NULL,
  `mc_start_time` time DEFAULT NULL,
  `mc_me_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`mc_id`),
  KEY `FKg0vtymuejgf1nynfyxj70y4jt` (`mc_me_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_calendar`
--

LOCK TABLES `mentor_calendar` WRITE;
/*!40000 ALTER TABLE `mentor_calendar` DISABLE KEYS */;
INSERT INTO `mentor_calendar` VALUES (1,'2019-12-06','12:00:00','2019-12-06','09:00:00',19),(2,'2019-12-07','06:00:00','2019-12-07','02:00:00',23),(3,'2019-12-08','06:00:00','2019-12-08','02:00:00',19),(4,'2019-12-09','12:00:00','2019-12-09','09:00:00',23);
/*!40000 ALTER TABLE `mentor_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mentor_skill`
--

DROP TABLE IF EXISTS `mentor_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentor_skill` (
  `ms_me_id` bigint(20) NOT NULL,
  `ms_sk_id` bigint(20) NOT NULL,
  `ms_id` int(11) NOT NULL AUTO_INCREMENT,
  `ms_exp` bigint(20) DEFAULT NULL,
  `ms_facilities` varchar(255) DEFAULT NULL,
  `ms_self_rating` bigint(20) DEFAULT NULL,
  `ms_trainings_delivered` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ms_id`),
  KEY `FK49a3ygnib52wsm2kmp7a0937c` (`ms_me_id`),
  KEY `FKh0rsohgbqgtm4tbqhk3asmlpc` (`ms_sk_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentor_skill`
--

LOCK TABLES `mentor_skill` WRITE;
/*!40000 ALTER TABLE `mentor_skill` DISABLE KEYS */;
INSERT INTO `mentor_skill` VALUES (6,5,6,1,'software',122,'cloud'),(6,2,5,12,'lab',12,'angular'),(5,1,3,12,'labs for hands on',12,'framework'),(5,4,4,12,'software',8,'sql'),(6,3,7,32,'sada',3,'dasc');
/*!40000 ALTER TABLE `mentor_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL AUTO_INCREMENT,
  `ro_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ro_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'MENTOR'),(2,'TRAINEE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills` (
  `sk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sk_prereq` varchar(255) DEFAULT NULL,
  `sk_name` varchar(255) DEFAULT NULL,
  `sk_toc` varchar(255) DEFAULT NULL,
  `sk_duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sk_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Java','Spring Framework','Introduction, DI,IoC, Rest API','3 Months'),(2,'Html,TypeScript','Angular','Introduction,JS,TS,Bootstrap','5 Months'),(3,'C, C++','Java','Basics of Java,OOPS,Thread','2 Months'),(4,'Basics of Database','MySQL','DDL,DML,TCL,Joins','1 Month'),(5,'Basics of Python','Big Data','Cloud,Data Mining,Hadoop','3 Months');
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainee`
--

DROP TABLE IF EXISTS `trainee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainee` (
  `tr_id` bigint(20) NOT NULL,
  `tr_confirm_password` varchar(255) DEFAULT NULL,
  `tr_contact_no` varchar(255) DEFAULT NULL,
  `tr_email` varchar(255) DEFAULT NULL,
  `tr_firstname` varchar(255) DEFAULT NULL,
  `tr_lastname` varchar(255) DEFAULT NULL,
  `tr_password` varchar(255) DEFAULT NULL,
  `tr_userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tr_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainee`
--

LOCK TABLES `trainee` WRITE;
/*!40000 ALTER TABLE `trainee` DISABLE KEYS */;
INSERT INTO `trainee` VALUES (94,'pwd','9840512379','kumar@gmail.com','kumar','kumar','$2a$10$7ZBrmD0vzTyRyIVyYGZLX.wx0pCRzlyAF1wixA/kXBf5NlAyXcUtq','kumar');
/*!40000 ALTER TABLE `trainee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training` (
  `tg_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tg_status` varchar(255) DEFAULT NULL,
  `tg_me_id` bigint(20) DEFAULT NULL,
  `tg_te_id` bigint(20) DEFAULT NULL,
  `tg_tr_id` bigint(20) DEFAULT NULL,
  `tg_progress` varchar(255) DEFAULT NULL,
  `tg_topicscovered` varchar(255) DEFAULT NULL,
  `tg_review` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tg_id`),
  KEY `FKgasjjefouws5l6x434nrlt6dk` (`tg_me_id`),
  KEY `FKmnjtdasc8bxnglj90ecg8kgl9` (`tg_te_id`),
  KEY `FK1n0bwq78qcj0a4e5qcnbkdkvl` (`tg_tr_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'COMPLETED',5,4,94,'Finished','All The TOC Are Covered','super'),(3,'PENDING',6,2,94,NULL,NULL,NULL),(4,'PENDING',6,5,94,NULL,NULL,NULL);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL,
  `us_password` varchar(255) DEFAULT NULL,
  `us_userid` varchar(255) DEFAULT NULL,
  `us_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (95,'$2a$10$7ZBrmD0vzTyRyIVyYGZLX.wx0pCRzlyAF1wixA/kXBf5NlAyXcUtq','kumar',NULL),(99,'$2a$10$P/cf/YnMgtLZ0QwoOLh0YeveHynSW6OksoRqvI8s7aZJ/FV8hzzla','lio',NULL),(98,'$2a$10$HE3auFZaiudGFqzOIKCDB.3FfI.eYuMO9.FUgONdlO63so7munXba','lalith',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_us_id` int(11) NOT NULL,
  `ur_ro_id` int(11) NOT NULL,
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ur_id`),
  KEY `FKjia4161ecu6h4p0egc2oc04lt` (`ur_ro_id`),
  KEY `FK1t65ha4bv531fmav53vlu66fg` (`ur_us_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (92,1,1),(93,1,2),(95,2,3),(96,1,4),(97,1,5),(98,1,6),(99,1,7);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 16:37:11
