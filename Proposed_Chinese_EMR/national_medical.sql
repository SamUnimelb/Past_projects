-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: national_medical
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
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `cityID` int(11) NOT NULL,
  `provID` int(11) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cityID`),
  KEY `provID_idx` (`provID`),
  CONSTRAINT `provID` FOREIGN KEY (`provID`) REFERENCES `province` (`provID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,1,'西城区'),(2,1,'东城区'),(3,2,'嘉定区'),(4,2,'闵行区'),(5,3,'宁波市'),(6,3,'杭州市'),(7,3,'温州市');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citizen`
--

DROP TABLE IF EXISTS `citizen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citizen` (
  `ID` varchar(18) NOT NULL,
  `name` varchar(55) NOT NULL,
  `password` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `blood_type` varchar(45) NOT NULL,
  `agree_share` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citizen`
--

LOCK TABLES `citizen` WRITE;
/*!40000 ALTER TABLE `citizen` DISABLE KEYS */;
INSERT INTO `citizen` VALUES ('3302011979012322xx','张弛','7c4a8d09ca3762af61e59520943dc26494f8941b',37,2,'Unknown',2),('330201199301242211','郑爽','7c4a8d09ca3762af61e59520943dc26494f8941b',23,2,'RH阴性',1),('330201199305010103','郑赞','7c4a8d09ca3762af61e59520943dc26494f8941b',24,1,'B',2),('330201199410213030','严江越','7c4a8d09ca3762af61e59520943dc26494f8941b',20,1,'B',1),('330201199501232200','马天宇','7c4a8d09ca3762af61e59520943dc26494f8941b',21,1,'AB',1),('330201199909211211','王俊凯','7c4a8d09ca3762af61e59520943dc26494f8941b',17,1,'B',1),('330205199302122011','叶孤城','7c4a8d09ca3762af61e59520943dc26494f8941b',19,2,'AB',2),('330205199501212011','西门吹牛','7c4a8d09ca3762af61e59520943dc26494f8941b',21,1,'O',2);
/*!40000 ALTER TABLE `citizen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagonse`
--

DROP TABLE IF EXISTS `diagonse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagonse` (
  `recordID` int(11) NOT NULL,
  `citizenID` varchar(18) NOT NULL,
  `doctor_user` varchar(45) NOT NULL,
  `illness` varchar(100) NOT NULL,
  `discription` text NOT NULL,
  `dig_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`recordID`),
  KEY `citizenID_idx` (`citizenID`),
  KEY `doctor_user_idx` (`doctor_user`),
  CONSTRAINT `citizenID` FOREIGN KEY (`citizenID`) REFERENCES `citizen` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `doctor_user` FOREIGN KEY (`doctor_user`) REFERENCES `doctor` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagonse`
--

LOCK TABLES `diagonse` WRITE;
/*!40000 ALTER TABLE `diagonse` DISABLE KEYS */;
INSERT INTO `diagonse` VALUES (1,'330201199410213030','dr_jiang','中度抽风','该病患送院时四肢癫痫，胡言乱语，但尚有意识。服用阿司匹林以及吗啡200ml每次，一天3次。','2016-05-15 15:04:00'),(2,'330201199305010103','Jay_chou','药物中毒','该病患在外装逼被人下药，疑似含笑半步颠中毒，情况紧急，经洗胃后略有好转，但自主意识仍然微弱，给予强心针10ml，每3小时一次。','2016-05-15 15:12:17'),(3,'3302011979012322xx','maclorine','急性心肌梗塞','该病患送至医院时满头大汗，捂住胸口喊痛。心电检测发现明显早搏，主动脉听音微弱不清晰，疑似急性心肌梗塞，现已吸氧、溶栓紧急治疗，下病危通知书，情况略有好转。','2016-05-15 15:16:10'),(4,'330201199410213030','zhang_w','中度抽风','经过用药镇定后病人语言功能恢复正常，但是出现药物过敏情况。给予多巴胺镇静。','2016-05-15 15:23:55'),(5,'3302011979012322xx','chen_m','急性心塞','该患者之前有急性心肌梗塞历史，今日不适送医，经验系失恋导致急性心塞，给予速效救心丸抢救。','2016-05-18 07:54:38'),(6,'3302011979012322xx','he_yin','瘟病','该患者主诉从温州归来后染上瘟病。已开板蓝根。','2016-05-18 10:02:34'),(7,'330201199410213030','he_yin','Cold','This patient got cold. Aspline is given.','2016-05-18 10:29:37');
/*!40000 ALTER TABLE `diagonse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctor` (
  `username` varchar(45) NOT NULL,
  `ID` varchar(18) NOT NULL,
  `hospitalID` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  `real_name` varchar(100) NOT NULL,
  `register_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`),
  KEY `hospitalID_idx` (`hospitalID`),
  CONSTRAINT `hospitalID` FOREIGN KEY (`hospitalID`) REFERENCES `hospitals` (`hospitalID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('chen_m','330400197103040018',47,'7c4a8d09ca3762af61e59520943dc26494f8941b','陈小明','2016-05-11 21:54:48'),('dr_jiang','330400197203050002',47,'7c4a8d09ca3762af61e59520943dc26494f8941b','江松福','2016-05-11 21:54:48'),('he_yin','330205199302122011',42,'7c4a8d09ca3762af61e59520943dc26494f8941b','何秋香','2016-05-18 09:26:25'),('Jay_chou','300104197901211234',19,'7c4a8d09ca3762af61e59520943dc26494f8941b','周杰伦','2016-05-11 21:48:38'),('Lingh','300104111601211015',19,'7c4a8d09ca3762af61e59520943dc26494f8941b','令狐冲','2016-05-11 21:49:33'),('maclorine','33040019940210x01x',47,'7c4a8d09ca3762af61e59520943dc26494f8941b','毛医生','2016-05-11 21:54:48'),('zhang_w','33040019900710x018',47,'7c4a8d09ca3762af61e59520943dc26494f8941b','张学姐','2016-05-11 21:54:48'),('ZWu','300104134312151011',19,'7c4a8d09ca3762af61e59520943dc26494f8941b','张无忌','2016-05-11 21:50:39'),('大福','300104196510212012',19,'7c4a8d09ca3762af61e59520943dc26494f8941b','周大福','2016-05-11 21:47:05');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospitals`
--

DROP TABLE IF EXISTS `hospitals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospitals` (
  `hospitalID` int(11) NOT NULL,
  `cityID` int(11) NOT NULL,
  `name` varchar(105) DEFAULT NULL,
  PRIMARY KEY (`hospitalID`),
  KEY `cityID_idx` (`cityID`),
  CONSTRAINT `cityID` FOREIGN KEY (`cityID`) REFERENCES `cities` (`cityID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospitals`
--

LOCK TABLES `hospitals` WRITE;
/*!40000 ALTER TABLE `hospitals` DISABLE KEYS */;
INSERT INTO `hospitals` VALUES (19,1,'北京市301医院'),(20,2,'北京市武警第二医院'),(21,1,'北京协和医院'),(31,3,'上海市复旦大学附属医院'),(32,4,'上海市宝山医院'),(41,5,'宁波市第二医院'),(42,5,'宁波市第一医院'),(43,5,'宁波市李惠利医院'),(44,6,'浙江省人民医院'),(45,6,'浙江省第二医院'),(46,6,'浙江省中医院'),(47,7,'温州医科大学附属第一医院'),(48,7,'温州医科大学附属第二医院'),(49,7,'温州市中医院');
/*!40000 ALTER TABLE `hospitals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `provID` int(11) NOT NULL,
  `province` varchar(45) NOT NULL,
  PRIMARY KEY (`provID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,'北京市'),(2,'上海市'),(3,'浙江省'),(4,'江苏省'),(5,'福建省'),(6,'广东省'),(7,'黑龙江省'),(8,'新疆维吾尔自治区'),(9,'天津市'),(10,'重庆市');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-18 17:34:59
