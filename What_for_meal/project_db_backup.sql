CREATE DATABASE  IF NOT EXISTS `what_to_eat` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `what_to_eat`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: what_to_eat
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `idactivity` int NOT NULL,
  `items` varchar(45) NOT NULL,
  `chinese_name` varchar(45) DEFAULT NULL,
  `kcal_per_unit` float NOT NULL,
  PRIMARY KEY (`idactivity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (1,'swimming','æ¸¸æ³³',800),(2,'running','å¿«è·‘',700),(3,'ice burg','å†°çƒ',700),(4,'jogging','æ…¢è·‘',655),(5,'dancing','è·³èˆ',600),(6,'cycling','éª‘è¡Œ',500),(7,'tennis','ç½‘çƒ',500),(8,'rope skipping','è·³ç»³',440),(9,'walking (quick)','å¿«èµ°',555),(10,'walking (general)','æ…¢èµ°/æ­¥è¡Œ',255),(11,'golf','é«˜å°”å¤«çƒ',360);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actual_diet`
--

DROP TABLE IF EXISTS `actual_diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actual_diet` (
  `act_uid` int NOT NULL,
  `act_food_drink_id` int NOT NULL,
  `act_time` datetime NOT NULL,
  `unit_amount` int DEFAULT NULL,
  `actual_measure_id` int DEFAULT NULL,
  PRIMARY KEY (`act_uid`,`act_food_drink_id`),
  KEY `act_food_drink_id_idx` (`act_food_drink_id`),
  KEY `actual_measure_id_idx` (`actual_measure_id`),
  CONSTRAINT `act_food_drink_id` FOREIGN KEY (`act_food_drink_id`) REFERENCES `food_drinks` (`idFood_Drinks`),
  CONSTRAINT `act_uid` FOREIGN KEY (`act_uid`) REFERENCES `registered_user` (`iduser`),
  CONSTRAINT `actual_measure_id` FOREIGN KEY (`actual_measure_id`) REFERENCES `amount_measurement` (`measurementID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actual_diet`
--

LOCK TABLES `actual_diet` WRITE;
/*!40000 ALTER TABLE `actual_diet` DISABLE KEYS */;
INSERT INTO `actual_diet` VALUES (1,1,'2017-03-17 19:42:00',1,1),(2,3,'2017-03-17 19:44:00',2,3);
/*!40000 ALTER TABLE `actual_diet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amount_measurement`
--

DROP TABLE IF EXISTS `amount_measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amount_measurement` (
  `measurementID` int NOT NULL,
  `measurement_name` varchar(45) DEFAULT NULL,
  `meansurement_chinese_name` varchar(45) DEFAULT NULL,
  `measure_amount` double DEFAULT NULL,
  PRIMARY KEY (`measurementID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amount_measurement`
--

LOCK TABLES `amount_measurement` WRITE;
/*!40000 ALTER TABLE `amount_measurement` DISABLE KEYS */;
INSERT INTO `amount_measurement` VALUES (1,'bowl','ç¢—ï¼ˆæ™®é€šï¼‰',100),(2,'small bowl','å°ç¢—',75),(3,'big bowl','å¤§ç¢—',200),(4,'spoon','å‹ºï¼ˆæ™®é€šï¼‰',10),(5,'teaspoon','å°å‹º',5),(6,'big spoon','æ±¤å‹º',20),(7,'huge spoon','ï¼ˆé£Ÿå ‚ç”¨ï¼‰å¤§é•¿æŸ„å‹º',100),(8,'plate','ç›˜',100),(9,'small plate','å°ç›˜',50),(10,'big plate','å¤§ç›˜',150);
/*!40000 ALTER TABLE `amount_measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ask_help`
--

DROP TABLE IF EXISTS `ask_help`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ask_help` (
  `help_u_id` int NOT NULL,
  `help_expert_id` int NOT NULL,
  `remaining_times` int NOT NULL,
  PRIMARY KEY (`help_u_id`,`help_expert_id`),
  KEY `help_expert_id_idx` (`help_expert_id`),
  CONSTRAINT `help_expert_id` FOREIGN KEY (`help_expert_id`) REFERENCES `expert_user` (`expertID`),
  CONSTRAINT `help_u_id` FOREIGN KEY (`help_u_id`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ask_help`
--

LOCK TABLES `ask_help` WRITE;
/*!40000 ALTER TABLE `ask_help` DISABLE KEYS */;
INSERT INTO `ask_help` VALUES (1,1,8),(1,2,7),(3,1,15);
/*!40000 ALTER TABLE `ask_help` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conflicts`
--

DROP TABLE IF EXISTS `conflicts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conflicts` (
  `food_drink_id_1` int NOT NULL,
  `food_drink_id_2` int NOT NULL,
  `note` text,
  `chinese_note` text,
  PRIMARY KEY (`food_drink_id_1`,`food_drink_id_2`),
  CONSTRAINT `food_drink_id_1` FOREIGN KEY (`food_drink_id_1`) REFERENCES `food_drinks` (`idFood_Drinks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conflicts`
--

LOCK TABLES `conflicts` WRITE;
/*!40000 ALTER TABLE `conflicts` DISABLE KEYS */;
/*!40000 ALTER TABLE `conflicts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disease`
--

DROP TABLE IF EXISTS `disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disease` (
  `iddisease` int NOT NULL,
  `disease_name` varchar(45) NOT NULL,
  `disease_chinese_name` varchar(45) DEFAULT NULL,
  `description` text,
  `description_chinese` text,
  PRIMARY KEY (`iddisease`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disease`
--

LOCK TABLES `disease` WRITE;
/*!40000 ALTER TABLE `disease` DISABLE KEYS */;
INSERT INTO `disease` VALUES (1,'diabetes','ç³–å°¿ç—…','Can not tolerate sugar.','è¿™äººä¸èƒ½åƒå¤ªå¤šç³–ã€‚'),(2,'obesity','è‚¥èƒ–','The person is overweight. Can not take too much fat.','è¿™äººè„‚è‚ªæ‘„å…¥è¿‡å¤šï¼Œå¤ªèƒ–ã€‚'),(3,'cancer','ç™Œç—‡','A disease which is difficult to cure.','ä¸€ç§æ²¡è¯æ•‘çš„æ¯›ç—…ã€‚'),(4,'High blood pressure','é«˜è¡€å‹','A disease which makes you feel bad.','ä¸€ç§æ„Ÿè§‰å¾ˆç³Ÿç³•çš„æ¯›ç—…ã€‚');
/*!40000 ALTER TABLE `disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert_user`
--

DROP TABLE IF EXISTS `expert_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expert_user` (
  `expertID` int NOT NULL,
  `expertName` varchar(100) NOT NULL,
  `expert_pass` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`expertID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_user`
--

LOCK TABLES `expert_user` WRITE;
/*!40000 ALTER TABLE `expert_user` DISABLE KEYS */;
INSERT INTO `expert_user` VALUES (1,'Dr_Toby','123456','tobym@wku.edu.cn'),(2,'Dr_Meng','123456','ymeng@johnshopskin.edu'),(3,'Mr_Yan','123456','samy@melbourne.edu');
/*!40000 ALTER TABLE `expert_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor`
--

DROP TABLE IF EXISTS `flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flavor` (
  `idflavor` int NOT NULL,
  `flavor_name` varchar(45) NOT NULL,
  `flavor_chinese_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idflavor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor`
--

LOCK TABLES `flavor` WRITE;
/*!40000 ALTER TABLE `flavor` DISABLE KEYS */;
INSERT INTO `flavor` VALUES (1,'salty','å’¸'),(2,'bitter','è‹¦'),(3,'sour','é…¸'),(4,'sweet','ç”œ'),(5,'spicy','è¾£'),(6,'umami','é²œ'),(7,'nice','é¦™');
/*!40000 ALTER TABLE `flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor_profile`
--

DROP TABLE IF EXISTS `flavor_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flavor_profile` (
  `flavor_uid` int NOT NULL,
  `f_flavor_id` int NOT NULL,
  PRIMARY KEY (`flavor_uid`,`f_flavor_id`),
  KEY `f_flavor_id_idx` (`f_flavor_id`),
  CONSTRAINT `f_flavor_id` FOREIGN KEY (`f_flavor_id`) REFERENCES `flavor` (`idflavor`),
  CONSTRAINT `flavor_uid` FOREIGN KEY (`flavor_uid`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor_profile`
--

LOCK TABLES `flavor_profile` WRITE;
/*!40000 ALTER TABLE `flavor_profile` DISABLE KEYS */;
INSERT INTO `flavor_profile` VALUES (1,1),(2,2),(1,4),(3,4),(2,5),(3,5),(2,6),(1,7);
/*!40000 ALTER TABLE `flavor_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flavor_stimulates`
--

DROP TABLE IF EXISTS `flavor_stimulates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flavor_stimulates` (
  `fs_flavor` int NOT NULL,
  `fs_disease_id` int NOT NULL,
  `reason` text,
  `reason_chinese` text,
  PRIMARY KEY (`fs_flavor`,`fs_disease_id`),
  KEY `fs_disease_id_idx` (`fs_disease_id`),
  CONSTRAINT `fs_disease_id` FOREIGN KEY (`fs_disease_id`) REFERENCES `disease` (`iddisease`),
  CONSTRAINT `fs_flavor` FOREIGN KEY (`fs_flavor`) REFERENCES `flavor` (`idflavor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flavor_stimulates`
--

LOCK TABLES `flavor_stimulates` WRITE;
/*!40000 ALTER TABLE `flavor_stimulates` DISABLE KEYS */;
INSERT INTO `flavor_stimulates` VALUES (4,1,'Sugars make food feel sweet, but adds the risks of ','ç³–åŸå¢åŠ è¡€ç³–ï¼Œæå‡ç³–å°¿ç—…é£é™©ã€‚');
/*!40000 ALTER TABLE `flavor_stimulates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_drinks`
--

DROP TABLE IF EXISTS `food_drinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_drinks` (
  `idFood_Drinks` int NOT NULL,
  `Food_DrinksName` varchar(45) NOT NULL,
  `Food_Drinks_Chinese_Name` varchar(45) DEFAULT NULL,
  `Calorie` float DEFAULT NULL,
  `Carbohydrates` float DEFAULT NULL,
  `Fats` float DEFAULT NULL,
  `Proteins` float DEFAULT NULL,
  `Vitamins` float DEFAULT NULL,
  `Minerals` float DEFAULT NULL,
  `Water` float DEFAULT NULL,
  PRIMARY KEY (`idFood_Drinks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_drinks`
--

LOCK TABLES `food_drinks` WRITE;
/*!40000 ALTER TABLE `food_drinks` DISABLE KEYS */;
INSERT INTO `food_drinks` VALUES (1,'Cooked rice','å¤§ç±³é¥­',351,79,0.5,7.5,0.4,0.112,12.488),(2,'millet','å°ç±³',362,77,1.7,9.7,1.4,0.2657,NULL),(3,'noddles','é¢æ¡',339,70,12,0.8,1.5,0.2096,NULL),(4,'beans','å¤§è±†',413,25,17.4,39.2,5,0.8959,12.5041),(163,'persimmon','æŸ¿å­',48,11,0.1,0.7,2.9,0.0292,NULL),(225,'crab','èƒèŸ¹',139,7.4,5.9,1.4,1.8,0.287,NULL),(226,'Cooked rice','å¤§ç±³é¥­',351,79,0.5,7.5,0.4,0.112,12.488);
/*!40000 ALTER TABLE `food_drinks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_image`
--

DROP TABLE IF EXISTS `food_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_image` (
  `id_food_drink_img` int NOT NULL,
  `image` blob,
  PRIMARY KEY (`id_food_drink_img`),
  CONSTRAINT `id_food_drink_img` FOREIGN KEY (`id_food_drink_img`) REFERENCES `food_drinks` (`idFood_Drinks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_image`
--

LOCK TABLES `food_image` WRITE;
/*!40000 ALTER TABLE `food_image` DISABLE KEYS */;
INSERT INTO `food_image` VALUES (1,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z!.%+&8&+/1555\Z$;@;4?.4514+$,44444444444444444444444444444444444444444444444444ÿÀ\0\0\Ô\0\í\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0=\0\0\0\0!1A\"Qaq2‘B¡\Ñ#R±Á\áğb¢²ñrs‚’CSÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0\'\0\0\0\0\0\0\0\0!1AQ\"a2q#‘¡ÿ\Ú\0\0\0?\0ó¦QI¯Š‰¾+•&{™\Âû	Oº«›\Õx\ÑÅó\ÅtZf¨oª­pšmÆŠ7ò{©·Š­CGÕ—„Yø¢˜\ß%µSøB…D\ÙMû\Å@\İ51lQ\İkHg\Û+n5\ro^\ìK©i/2B?úH\é5HÚ¬\å^\0¢¤»3…¢i~\îk°\ì\ê\\\Ô\Û{ˆÊ»0 Ì»D\Äş™õ©\êû•ª]»Sy(‚À\Øz¡$\äûS\\ª\èŸø®›\ÙÅ‹1fºm\'tõw¨²\Ê@’_À=<ı*vû—¬f+ğ¢n,¡}ç¨­ö~ş(ù_\ì\æEš†+¼n\ãvn½×—Ub>_œÈ“<F+‰aA\ä»)\Æ\á;\ÇÀ¢˜N\ÍBg¬­†N1P\Í94\ÔÈ„†BŠ\ËqMGG‘ªšj™&Š´¢‰r\ÜT)Z \rJ”P\ÚÈ¦…Mª$Ô­‹ŒS\èhˆô¢µƒdT\r­DÛ¢¤$ üV¢¤‰kN\ÎÁTcÀI­hU’D¬)bD’@Ìhk{õ’\Äe\'‰ûEt\Û\îV¥¯§Å¶È‹\âf\ê ffb½etUU\Ô9X‚\à#ƒ\Ç4\ë‹%oD\'òqt¶x[÷wR\n‚òÿ\0,	Ÿ·Z\ê{\İ÷MI]M’!	]\ê™\ä\"½Um\Å	—5Hñ(»9¥\Ï)*)k»=.¡GPP\â>\ŞU\ÚıÑ±u øl¢¨ş£­u&™‡¥;Š—d\ã9G¦dw±Æ–È·;²X·™>1ZN•2¾Uj*–…m·li‘šuˆ¡3\ĞE\ÓÖƒ•\Z¬«Ú¬\Û`–\ÚvƒÁ1^Us¹ú°…ö)T0&½v$\Ğ/:\É\0gÒ’QR\Û-\Ç\Ë(j\'\İR¤«Á‘A®\ï¿}‹q®¥\Ëi¸4\'„gwIŞ¹ıGu5h›\Ú\ËGP °÷Qš>¥È¤“f%5M‚A‚=A\Ñ@j²J*qJ+Y°_¡¨ºõˆ¤S©^˜$*“/Z\Û8¨\ï¨\Ò(\åvX)o \ny­‰—+ºµ;²_UtZ·´$–0\0\×w7¹Vµ:F{\Ê\ê\î\Ş¥Qx\Ø9\ÌW\Ø}\Ş\Ó\ém”\0õs—osı©\×²3ùtš]} ı›_g‹®ˆƒª\Éf“\Åzev-2ì´€q¹X‘Ô“Z\åi:zUc®NNy\ÏM“B>µó¦D¢ó£vH5E\ÔLgµYT Âƒ1t\î*+5zÉ†ˆ¹Š\0™¦{§\íMñ¸4™Å°\Ó$ã¨¨©\ä\Óz\n‚\Ş£\ï<\Å6JÁE{¯8\Úb\ÈÀ­6´³ \nƒ¦\æ¶6†\èƒJ‡9\'#\Ğ~µ=H©|Pö¬\İN¤“J6£\ZM³\Ï;\Ñ\İ\Íu\ïY\ÕØ¶\Å\Ãy÷“\'\ë\\~«N\ÖØ«©FA¯uCŠ»²tú”\Ù~\Ø>N0\ÃØŠL2\è\é\ÈqT\Ñ\áª%\ë¶\ï\'\ì\îõ™}97mù~5Ş¸«¶\n±VX`‚ ƒ\ê)\\k²Ë•\ÉZZ˜š}¢š°ùšh4óSW­`¢e)¶\Z4ÒšL\ëı8°b\Ù8½c¸=\Å>>­‡‚Û‰\Ø9\ÜÀ\ãqò\éUÿ\0g=\ÖW[}fseû„\Û÷ò¯BKş <\ê\ĞU¶psò+\Æ?\ÙePHòö©|:tJ›\Z£9AsRc\ÄTÓƒŠ[0ËŠ˜i¡½\Ø\çüP\Ü\ÏJG4´2‰e˜\ÅIF(V®†\ÇZu&}?:)§°Q7QA\ÈYòšº®s\")1£(\åÑ“£8\Û\İò‚)¬\éXŒ{ŠºLPş\'¯Ò“ôâ¾Æ¶A¼9\äS¼?Ú—Y4\é\ê*ˆ\Ù^\ê±YÀ=O½³d`Gøş”µ&›MÉ…|:IªªÄ°­\rEÀLUo„<«™«zeŠ\Í«¦\r 4ğl\rm_ğ\Äâ¹®ów5Šn\Ù!/ÿ\0\Òñ\ĞùZ\ØfŒ5kAªˆª¦¥¦%¸\î\'\Ïú\İ\Úv·qJº˜*y\rµ\ï=õ\îªk\íˆ\êx[\ãù[õ\é^z\Û+20*\ÊHe<‚0ENQqg_$d¿$bšš–\ÚR—\éd•»\Üş\Ã:½R[iøk\ã¹È¤Hÿ\0\äH_¯¥e\ï\êß²\İM5\ÍA+¯´ø[\Çı\ì\ßaKÇ·\Ñ_\Ô \İ\ì\ì\îYÀ\Û\0G\0\0<¨:{,1š³¤rA\'\ØQ\Õk¢“\Ù\å\Ù5¦t¥P¹r³\ë`\æ*¾¢\ì\ì\Òw4­i÷\rÇ¯J\çr”¾¨¢IvYTÜ°sNÖ„E8¨°«b„³<B4Ÿ¹«ÖœD\Ó-¡\É\ïMy1+ƒ\éK¸ß ·d\Ø\Ğn¶b«şõ\æ>¢£p“\í\çAò&´lF-5+\n\ÌúP•\"s\ëF³{ÓŸÊ’/{–>æ˜™DTn^¹#­_$„¦@İƒA»rh7dñŠ§nù\Î\ì\Ë\éS|»¦:@®°(ÈŠpLO¯Òœ\Ù\êj•\Ëeœ\'O\è<\êv\Ö\Ú\ìn\Ë?º¸œƒıOÒš\ÃN\ÍÔˆ‚}z“MOMm³??*¢ô+z\roJ u\'Ö¢ºQ$®÷\ëF29?JŠŸZ²I	aô×Š0\Íp?µî¯‡[mban\æp¯ı¾\Õ\×\Üv™\è*\ë[ME—°ù…H÷\Ñu$\Ğ`ñ’gÎ S\ÑuV\r·{mó#2Ÿu$\é@\İ\\§¨š.-{u\í„\ì\í0Sw\Õİ˜ÿ\0Zñ\r•\î]\Ü`İ§ÂŠ¼ıé¸–™˜ş«ù4´\åHò<û\æ®i\î\Êık3F@5r\Ûfğn‘\çË²\Æü\â“\Ü\çŠj\çLô‚‰[\n\Ã#\éSP\0\Å6\Øj{·‚Ò†—¦™\È\ë\ÅK`#®\ÛÑ´´ŒP.¹#DDL\Õ\ä¼L\nÒ•%~L‘!k4B³R¶†}?:›\nÑŠ£6 ŒĞ‘|^‚h\×(H“Š-#\".™$sQµx“O¿Åƒ ±\èj›]e¸q\á\'3\í\ÈúÔ¤\Òi¡’³AÒ„\È\Ì©]y\\˜õ\â*¥‹Œ\Æ8Ï§½3’NŒ¯\nd“ôúU\İM“´$Eî”©¦Œ“³&ƒ\él™,z\à/Z±´sB\Ó\İ§}\àUcIö\ÊÚ‡ñb€÷4÷—¬\Ö{=NSq1²\Ù~´[W\nF\rW°f\\Ó¨.¢:ÿ\0cM\r\ìY9ß»q®¼@\Å^=YŸ\Îkœ5\Õş\Ñ\î†\×İ\ì£õ®TŠGû™\ÙÚ‹\áæ½öu©ß¤Km?+G”«ºÀõ*³ñ¯FŠô.\à\ë\ØY•\Ö\îü\\)\'…Iö,:\ÓpSm?(o”¾Ÿ\Ã;‹ $©\æH>gÊ­\Ør¤\Ìgˆ¨k­+…¼œ6~R9’<ªµ§õ“\åKN2Åœ=«6‘qBs–\ï„Dıy¦{°$\Õ]P¨qzj.Í‚3\ç\Ò=j£j³\0`ğM\İøÁ2|½*Y\'\äj¡ïƒ´Áúœòh‹©P\0\ã¤S\\2 U\rE¢\â\"=\éeqw­öµ{Kbø±\ëøG½R\Ò\ê™\İq\Ô¤\æiš\Ûôš\Ò\Ò\é•Oûô¨T\ç;n—¡\î1‰qË–M±·;ç˜ŒF|\êMdLÉ§(\Ë ış\æƒv\é\â»4¶É„8š\Ë\ÔZƒ<˜ôö«\Ì\ÑUo ‘¥Ÿ\Ùl+D46Ja³\ëú\Ğ\ï\Ü]\ä\àt­%ùqœV5\Û¤³NOQSš\Å$º\nv\í“Õ¾\ä\Ú\Û8õ£ö&“\É\'ò¬m[ºCm€Ì«$ÀÉ€H\çò\ëZšG`F	\à=\â’\r9\ÛCITMR˜‰ú\ÕwBh¬ø oŠ\ê“D\Ò¿½Udˆ\Ìû\Ñ\ÙñT\ï]ŒùPm z\Â?jÊ¶ô}]ù\ÅTG®y\É9h¬U\"õ‡‹¥¿\âg %AŠÄ½¬(ûT0\"$’|‡^h=ô\í¦\Ó|\0‰w\ç>S\È\Çô>Tğ•ÿ\0@qÿ\0§šö¾³\ã_¹tş7f\Ó\áü¢©\ÍœÉŠi4\Ô]r$©#I–p+®ıŸ\å\ï #q@\ë?))¸0>›\\\×0ˆV\çtu_WlôiC\ë¸`}X(ú\Ö\ã•I\åÁ£\Ò{´>\Øğm9Ú‚eˆ˜´Ü£9P V¡\ìñm‹¡ÜL\Ès4\ä\î\Û$¯†¶\Ë.mœÀT\Âù\"µ{/µZ\Ë-‹\Çyv \n­\á6’cyñh‘kªpRß“Ë·l\Å@¦\ì6G•¨eŞ‡rşcĞ”%¸“Ó­FJ3/À-N˜@ô8ô ½…VV\ë\"ry©\rXr`ñŠ“\Ûr$\rM¨\Ëi\rµ\Øw•<\èl\Æ@\"*/c{\0IN|ş)Ÿ\áªPüp \Äb|ÿ\0\Íj-³×Š’bi5\Ì\ÅhÁFÿ\0,\r\Ø\èbGAÖ£r¢Ú\ÅQ~T‰õ¢\ä’2AYzV^¹ZA÷«šVõ\Ï Á¦\Õi\äa£ß­Nk8\Ú\Z.\Ã\é\Ü\0#ˆŠ}BŒ·\nœ\â´mßŸ¯Z<ŠJ™š )`\î2dbq&~¿•Xkp¤õâˆ‰ŠIƒ\Å:T€İ‘¶›Wi3PªwnUWvˆ½jriR\Ìb³µ&9<Ö‹\İô‘«½’M$ô†ey\Ït$v\áWtñúb§«½oJ¿PC?\à¶#u3‰ü…O.]\r\'Aú\é\Ó÷›ø\"E”82Dn>¦1\ä2}<»¶»Aµo9\Ä@=\"f=:òkC¶;R\æ¥\Ù\îHE\È\ä`\0v€y\È\äŒ\à\ã¹×¹\"x’L¤J\è\Ò\Ò#»d\Ôô¨&¥¬sVm\İ*Á\×¤0÷S#ó«2µ¯$z\ÒUg¦kµ\Ê\ém­²*ºoişm¥’Oó\r\Õr‡\Ä&§¤\Ğ,©wTÔ”·8ş¦\í¶Ô«xe@oFA\0Cº}±ğØ«x\Â#•OÃ´+»\êV[\éqü«\Ğ5—´\Öl%·¾¶ƒ	¶\ÎWx‘ü­óbˆ†ŠîŒ®)W$1“Dy¹¢+3ğ\ÃC<—`›@\\‚Ïˆ\0b¶mk¬jS®ô2‡$O@c¯Ğš\ä»:ñı\é^4ì·‚øÃ¯\Ç\Â\r\Î†<n˜ıc\á;&\à\n`\à’$ş!–›™Š2JJ™*®‹K\Ùn­*\âµb¹]k\êm°GE\\ª±R’Zü3ò‚À\ë\Ô\ÖŞ·,\Ş\Ü1\á0\Å:²§\Ä ãƒ‘S\\*+\êg&û}ˆ\ÏJ5‘\ÃO>¿\â—À<­\æ\ë\åö§\Zr‚#\í\Å\ÃhM\ÌôªŸIú{TuwOVV³TÀI,|„˜NLXÑšW\ï	À\Éõ£2‰÷­P\ìû\rqC?„p9&c200k\\x((Á7ö}\Ò\Ğ\èƒ\æˆ5WRò}«?W¬r\áP£\æœö\éDb³\äN\ÒFQ­²W\ÔDš‚\ÙP1€Ç¯\Ò\ÒIù¹®?*·¦zÑ‚o#7ª½V»sÖy£ô¬\Ë÷ˆ/û\íFnc^\ÔŠ« ¼¬Iò\Ç\ìÕ>\Ø|Œ=[\Â?:`–¬ñ.(“\Âó\ì\'Ÿ ©(JROÀÍ¤¨–£UA\ïT_³˜’\îû$—\ç\ÖõŠ\Ï\í>ùÚ¶­ğ”Hù2H9’G¥q½¡\Û×µ,¦Z$J´	`w€S–Ÿz¬¸\âÿ\0s³&üWjw¢Ş\n\é†\ãò\ï0Ä“<	“ùS\\Vª\ë\İ-v\ëJ	“%\È2G¾Şª\ÜEñ&\å\ÆÁ9he‹@\r\íC\Ö\Ş.«\'6©\à\0>i\äÇˆg\íC½-!’­°º­Rü%A–!dr\ÓYDA4WP€;ˆ`g¡œC@š\ÉWEbı4ôÂ¤(D\r\×>fm9\é÷­”2>´3ôŠ¯\æMƒ\Ò¶\ê\ê\Ğ\ÊAœ1\Ôt#¨5\Úvn˜jXŞ¶ÈW\ãxÅ’»¢\î>N\ç\r\ÑD\Ìq\á*\ßgkZ\Ë\îX ˆd9WS‚¬:ƒF<­0O\â§vt÷4¢\İ\Ò\×]l½\Æw¶L©RC«B†\çi\å`\×Co·®Ü°öX”¾Wøo!~\'(n0Àn28<\çvGie\Ô#¶¢\Û(\â¢0\n\Ì\Â ²‘d‚0Á\0	\ÛF:F{l—Dº#\İø‹l‹o°Ÿ\n°ğ²\\FİµN-\0\×ld¤6pqt\ÌşÁ\ïŞ¹±Õ·!Ut|’¥‚Œ°\áˆÌ‘˜\ãw¼ú=5¶º–G—t¸Z\ÙeÉ‘$<*¡ \Üÿ\09h„¸ŒğöŸ»®¸duˆ˜$87tW\Ò\ïgJ2–¶Ã¹\nù“rB´\rÛ£b™ö!4\Z”·6O\â\rüCWÁ¼e\"8\êjæŸ½·\à°\ë\0n «*¶\àI’°fq\Å\n\Çe¦™Ğ¥\äWy!e±tˆ˜	¶NFHnkY\r»Áƒ Ü¾VA÷\ê\È4­ \ĞÖ»\Ùe\î,Qœb$\æ@<F3ƒÁ­M\ÚúWc°	”\Ì{\í˜\â¸\î\ßm?\ïV´÷)e¸L€\àÂ¨nGs\åY¶û3Lú\ÚmB!E`ê’¬\ËÔ–2ó4böc\ÓW´,\Ç÷<ò)~õdñu~\â¸\Ë\Ñ–\Ëiİ‚2„Ü—	e(Äˆ\Ü\"2dFqMo±õJ6Ï°+K¬~û¸÷³Q3º¸–˜\Ï\Å_\Ëõ¨2Zÿ\0û/\åú\×¯\Ò\ß[Gø»1Tm\ÃqpIG(¦\Ô\İYk¹(@øjŠ\Ç> \nL ±\è¶oYY›Á½¶ş´\Ï\Û\Zuüdô&~Â¼Û¶-\ŞWWø\ím°Î±¹T,0:M\Z\ßc9`\å\ÉmÅ\ç1,¥Z@\n`œŠ\ßTƒM¦£¼¶9Tf\ÙóN\"™GC\åXš¾ÿ\0(Wkaa`²Û™„¨ğˆüú\Ö\Z÷Mn\'9œ³Lô;~µBş²Õ›\ïm\ÔÂ¨bÁ \áv(s—%\àl}—u\î¿|xğÁƒ\r€ğ\í\"I\ÏI¬¶ø\×\\:]Ù´CcioI$™‘W¶Wu«B\"rU	2\n9r	ß­T¿Ø¥fñ†f`YÂ¥K\Ë\â&IòœñSr~FQEG¶ª¤¦ùhP\áHF%±$™i8\r\Æhwƒ¦\àÚ»X\nv†^IDp Á§·y„6+ny>S´Ÿˆ1\nc\ìû_P7N\Òx‡„	ñ\09&@\çËŸ%o\Ø\È>\î\Ëmq\ä´ $¨ò\åú+%¥™™œI\"z˜:\Äú\Z5\æV`³”•P	%,Dô\é\í\Íg_º\Ê:A3&<§\Ë1>”\Ø\ÖGQtşÿ\0¿\æ‚\rFœ\Ö\ÂN\r\Z•Š\ÆFŒˆ‘R\rUÁ§İ™¨QßVj…6\è3JdÑ \åe½±\í0{d«ô#úÁ†½IªwAmn‹\âv\Æ\Ó–6Ê²½²NJ\î\Û\Î2k\ì\Ë~0[!s]/yA]>ú`ı9	LWG\Ö-œ\"*m*:K\ïû’\ÚK\Û\Ù//\ív\ç\ÄwP›J\íbp7,õ\Æ\ì„Vş-¶d´Å®]KLU\Z6ˆø¹&\0™\r\r©5\ÚpL.’AWS ©_Oz6¢Â¯\ÅøV-å‹¶wü9c º6† ™ ‰WŒ\Ó8%º«m\Ú\İEFQ5A•­H‚Îƒ ÿ\0ª\"1»w_¹\Õ\ì\ŞQ63»lµ}\È>ò$\0Oˆup$r\n–\Ûrüfº¶V\ßÂ¼·«€6\\=¹Im¤«A\0\ÏP4uš[(\ÚvFşŠC38¸Yf\Ü;w œ† yQ±hÇ±Ø®\Ú×‘–´–•_`&X‚­\â\'&\'§rvmXbŠ¥UšQˆ{ \Ş\Ú\È`úI\İwO¼v\ÚË»¢Y\Ú\ä‰\Ëdª\'ts÷ª—¯[İ¤\ï+ğöø	ø~&ÀW,>c#¬V¶j	£\×&‚\âi\0…†gw!KO\ãB$\Ú`\ã\ï¥o·>8g´\ën\Ê|÷\\˜’ª¦\"$I>\Ñ@\ï=”»qP\áK-·F71Ÿ+¬*\È\Ó\êm²\\ #¸`\é´ìº…d8³FFijöA»).‡{7U\İI0 n‰\ÚvV}A\çŠ~Ã°¶\í>¡TneF\è…E™ğ¯‹p\Æ*:C\\F²Åµ?1@\Ûóoõ¬~\Ğ\íK‹h\é\ì*°\íÿ\0\Ì\íi\"KH\É\Í+1Wµ\î5\Ök¨§{\":©$±C\Çó \r£«Aš`5Ô¸.^\"\Ò.\í\Å\á7‚0»1&`\ÌU\Å\Ñ\İ[‚\Òn3™\Çş\0\ì\\u„À\ÍPµ\Ù%¯‹\Î\à<wb@hİ±\á<ùı}\×\íø\'\Ëi\æoú,û\\\Ë\ë\Äu|&X™\Ú\ZFdˆ‘\åZ\Z£imR_`U*\×Ä’\ä•Â¨¦›µ¬{J\Íq\Õüon\ãQ@’de`nû\ZM \ì&‹µT*1Ó†!YY\Ôr@&µYoT…U£ùÀyzO=b±Ÿ@ ¦æ¸›øh£*D‘€s\ê}j¥ı++¶\ç\Â\Û7’+´n$õƒ\"zı*m!•–µ\ì,\Ø3;§~>m»Œy\0\0\ëf¨=ö \àC(şI%ˆ\Ìc\'®*WU·&\æ ¹ó\Éõ9ŠË¿rO8Ò²\Ø\ÍR¶ö¦@Q…\ÉŞ•XTEHSô±\éE*x 5\niR 2.O¶E9\ÇZ’^\Æ\é\íJ<©)¬mt²$óZ:\İXm9B~R#õ¬2\Ç©o;b¨§J‰\Ê6\ì7dv¥\Í5Áq£)ùY|\ëÒ½K³5¶uhş$>DWµA¯¹a\Ã\Ûb¬>\Äy\ÔSFTssqÛµ\Ù\ì\r½=G®j¯Mf\éb\é–]Œy•™ƒ\ÔA\È# \ÕÁï¥«ğ—¢\ÛñŸ‘£tö?t7tª\ÙUø9Z­3’\íN\î+[Ü÷	dP\Ém\É;AÈ–ùT\ËKxyªİ¿¡»´³¢xU¦\æ\Äv–¸Bó!f`c\Ädâº‹ºB8?|\ÕrxŸ¡#ò­”1L\ä\îh\ï¥\Û:‡W{Š£([p\'l\Ü,6øHWõ­\îÎ¹l[{W-«mñ²\"3©/\â;X\Ï\Ä9\ÉU–Ô¸\æ~ \Zk[\Óÿ\0©Í‰ˆú¦F¹qn*ZdTÓ«Ê¨É†!\Ä\Ê\Ãy“#¥\nı\åm=´[ƒQ{+\áuƒ¹·\êò6£$r[O­œ¿Ÿ\ëUŸR&v¤ù\í3Hù\r‹0‘µZÖ¼%Œ©M¾bw‰`A<±ò\çZº¾\Ê`\Â\å»\Ş3÷xC•Ài_”\Æ8\ÅIõŒ\ÂşµYõ|ÿ\0!ı)_#@%\Ãt\ÄXFşuVfúó5@\ÛE.YË—\Ì@faø<\Ğëˆ“£Sù\Ğ[M\çH\å!\ÔQ_\ã*Ÿ\á¦@€\ÌK<„“\ëU\î+6\\ş‚¬j.¢Ÿ§SXš½i|/?zŒ¤3”b…«\ÔO…xóóª€Râ®’J‘Ü±S\ÓSƒXdJ¦§š¢T©©P\r—\0©S}iMHô…Ij \Ó\Ğ…jFšŠBÉ‘™¨0©\Í*b\rX+c²;É¨\ÓÀGÜƒğ?‰cÓªı+-…B)\Ó!8\Ùıı²ğ/+[o?™>\ã#\í[ö5ön‰GGÿ\0\ÒA¯\"\ÆF˜\æ™H“\ãô{K\Ú«\\ÓŠò\Ë³¨O–óıN\áÿ\0T\Õ\Å\ïf¤r\Ê\Ş\ëúELJh\ï_N*»\Ø\Æÿ\0ù~£¨O±ıhoŞ«\çùG\Ğş´­#ƒYZ\àQ\ÌW{·u\rË‘\ì\0ş\ÕF\í÷o™™½\É41G[«\íkKøƒ%\Íbjûm›\n63“ş+\"š(¨ 92L\ä™&O™¨Šx¤)…¡©\éE=\0¤ *@VŸfv_\ÆGm\Ûv	»§sŒ‘ùÖ\î\ìÿ\0÷‰ù~ƒñy\â°Ê‘\ÎO[\İ\âwŸ˜¨9 \Çó{cÖ¦ıÜÿ\0\Åùw\Èr$\æ\Æ¿•a­¦ºİ£ ª%I¸•(ˆ\ã$AXº‹[–gk1\Ì\ã¥\0¦i©\éTOIt‡5\ZT¨ ¾Æ¦¥J˜A\Z*U„}Q¥JŠQjT©‘9tD\ÓR¥D“#J•*\"\nš•* b¥J•`\n•*UŒ9¥J•`„[„pHƒ\"	\ç\ÏŞ‰ñXò\Ç\î}?Aö©V\Z\"GS3şùµEµc#\'Ò•*2\İc\Ë\×$ó\Ğ}…\rÜ“\'$\ä“J•`ÿ\Ù'),(2,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0	\Z\Z\Z\Z\Z\Z\Z( \Z%\Z!1\"\')+...383,7(-.+\n\n\n\r.& %----//--/0--------/-----/--------------/----------ÿÀ\0\0±\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0B\0\0\0\0!1AQ\"aq2‘¡±Á\ÑğBR\á3br‚#4s²ñC’¢\ÂSc\â$ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\04\0\0\0\0\0\0\0!1AQaqğ2‘¡±Á\á\"\ÑBñr²#Cÿ\Ú\0\0\0?\0ølH‘#,¤H‘#,¤X¿b{?ˆ\Å•,‘ª<c\è}…\ì‰¼B½\ê\Årşzk}§·\àvyDg¯ÂœXÂ¸Ÿ³dx˜1„‘†•ş\"ÿ\0¨\\µü*,o\×+Zæ¯¼¢Iñ\Ó\Â:½·‹°¨–g\ä\r% ı\Êsı¢<”Ù…F8\áG\"f\ÙA\á]U0Ÿ‡ˆ\İtpXU\âÉ¶¼„v{/ş(N‚¦6öF\\61ï®¾\Z\ç\Ë\Æ\äB•ø•s%N¿Ú\ÕÎ¬¢\É#Ê­U‚<“,¨\Â$¼§÷eöiY\01›³°\Ö=\ïg\áÓ†•™]\ãöĞ  f¼\'\í;²dH\Â\Z\ÍR€ \Z–ôñ’81ô?Ú†<Î©4ó\"¸xaAÓ–¡KA€L\Â!\Âs\ŞZ«>X¬‘¤\Ë°*I@]‘I‹B!\êDD¡¢¼‘Y+\ZP”C:	i¤h•<\Úe\ÅAYt\Ó1CX\×,(\Ç.LÖŒŒCÀuŠß†”I\î\ì\æ8\Æe†\Ê\í5ja™L¯¦{9Ù²ƒ(G«=¥&Xd×§\Ö>=\ís¼z~\Ã\í•\Æ%7M	]N\Ú\Ä.i%ˆ\äñ\é6f«I•)i‘\Ì\Æû*…—¡DH˜W\Ê\Âu0İ“™.\ÊğKü©\Ò:ı­Ø¨’\êR€J]\É,(\n‰\'D€	\'`c\â¾\Ğ{OˆŸ9K—:l¹c†ZRT\0K\Ì]\Î\Î\Ö\Z(²J!\ÍyH‘#wgöl\Ù\Ê\Ë*Z–”?™°ñ…$\0æŠ¤µV(÷>\Ã{q\r>{¦@°±_ÿ\0ŸŒv=šı¦[M\ÆH¨”-ı\Ç^‘\ìqXªeHd‹hğ»wÕƒ}¾\Îgs–ßµÏ‰‹`‚f!’%\ÊHJE\0&f\ÌJIlÆ§d\İJğ\0Ÿ\Í*IR€&;‡eIY-š`÷i\äñı¬Ÿ\ïb\Ä-\ÎÂ¾4Ü…,(±b¤¼ÿ\0i¬\âg*`Š%iiP<€ñ&€\ìÄ¤…\Z±x\Û.PJ\Èûn$Q~+\è ,=³‹+[h4~*a´m‡.ğ‘€˜²\ÈIQ\ä#\Ò\Â\Æ!\Ê\çŒMså¤’\Ñ\İÁ\É`\0¾±¿²ı•S<Ã\ís\ã‹\Ù\å1\Üı!1>¡K¶_º%ûQÿ\0f»4!>õt\Ïñ´=®VHê¦š$šF…\ä\0\Z\n\Äò°;O6\×ö·\Ù-Uò/j\åÌ˜š!e\è$¹ò\"Á\Å˜a§5»Šø3\Ç\è” l)\é¥\ÛO¨‰­DCˆG^sMş8z¯\Í\è\ìœA¯¸œ\ß\é«\éÖ•\n”**¨Ó¬~—\Ë\ã¬a\Æv|©‰(\\¤)&¬@ Á[#½ƒûúQñÁ¡_e¨\Ş5=#\ì]­\ìr@B=Ê´T°£1-\Ú?³9ˆ#\Ü\Í\\.…úŠG£‡õ<\ê[Ú‘ÁˆQxwH\ã\Ğ/\ÙlZ4…°Ù“Œ˜şÇ›))Z\ĞR•Yş\éğbÁ<\ÂC	˜eŠP‹˜af,‘EBÉ‚\Â\Õei™\Z\åMŒ/™e\Ó3`=übL\Ø`TJº˜\\SGO\rP41Á”;9\ÖÀ/QÙ¿5-\Äc\Ù`}°I\â¹\'A©˜Îš\Ö+µ{[÷)ôŸÿ\0¢cû„³³^j¦Th5S\n„¨@ŠTB¯Ú¯¶%k8ie­ï¿”™2¨–Zù„\'ğ)şwï“´c™0’I$’I$—$›’u1b# ¤Œ½÷²ß³\ÇHŒt¤±L¡BGó:÷2fK’œ’e¥\0h\Ğ8\ìYQ„JD|wi\í8½ ¾!•…—<qSTµ*\æ†\Â¨$ı¼k\ì¼(ZØ¤¨6‘\ê\å¤%€KSkG!j¯\Ùû)Å›®gfv:P¬Ä¹\Z\é»~hTÜ ğ\Ë¸\ÕGÎŸ\Ûyó\ÊR¥dú#Ì­Ë“W©\êa°q?õ˜ˆ©nA‰ónp\Õ{X0Á(z\è*I†\ÊÃ©]\ĞOHH\ë“²û<¡Y‚³Q˜PU¯B\ZüªD“\Ùİ‘P©‚—o¬u\È©\0t‹c]5û\å‰¥şP¸ ‘\ÂM¯O93Nm7V¡Zr‰0òo¤k£ü I5§\İ\ÄJBE\"\Ğ\î\Ôo\Ù\İ–ı`—¶Œ.!Fg0E:_›·¤&#Ba‡-´l\î*\ì\ÎK—LB!¶ü\àAm:\rLQ\×\Å\Û\Ò\0%…üö\Ø49Ÿ\ä=„™\ë;\ÙÍˆ¨S9}\ïH¥Z§­	#Â¼õ\å´s€i][X_Ï…\Ìù’Ü¤wv$$+A4\ï0«†\éS@{A)E‹\ß`[H¤Š\ï»ı\Ò(L1\ÄD/:¼ò\Ğ\ØzKJjn6…b°ò\Ö\0XJ€.;\r)$’:\Ä*OGò…‚3üH¿ˆ“	H{,Î¸¡ì´‚‰\Å2\ÒU0Q÷oHùF?°g\É%+–ª p\İD}\Õ*a_Œ\0÷ƒ¿(ôû\Õ\âÀq÷“4¾cÀ/ÏŠ’EÁ^\àGÛ»Ù™8Œ¡IË—Tİ¶\éKµ¿g‹“0µ—1\æ\Õpb\ï>^*!Eó•J…”GJn¥ÁA#\ÄB\åaJ‹ŠÀ0¸U*\Â=7g{\"µ\':øP.O\Ê7\áğ’\ÑkBŒN\"Á*¹½›\Ù-Ä¯(ÕŠ™b\'hv¨HaÏ’¬D\Î% ¥¬–J*¥¨\è\0)”«£€÷iBñ¸’D™TJu™0÷PniÒ„\Ù*oö\ßkL\ÅNTé†ª°\Ô$wPŸ\å›š’\ä“kı¡ı\êbe\Ê8i ¦JlNóü\êg\änO&K—Y†\0‘\r2¦W\Ú\Â!ò¥\ÄB#¯\Øø\\\Ë`\ÇÁ\Å\çÃƒˆˆB\ëöf\"\n‘]úF¬¥\Ú\â*L “r\Â™úü#–|NO¾W¿\"@—Û“xF¦¾b8SY\Ş:şĞ–)©ı!=™„Ì´ºIF¥\Ã\Î\ê\Ñ\×$\0\r„ıU\0:\Ù\Ø\Ø\'‰\ÙO¸) bU¯¤I	\à\â¥j-İ‡X$\\@	¹\Ï\ä\Ó<\ÉQ-\İ@ªò7ù°¥©ƒ\Ğ\rş^‘SZ¦–½>£»\ÄK‰\Ö_&{OŠul‰+C;\Ğø1úA!\ëmº@ƒ¡j\Ôõ1s&6||¾Xx\'\Ä´¾W$\×6b\Ì!;*Pj—}\îğA \åñh\êú\í\Ñ\ïúÀ+˜ \Û\ä~Q¢„BÅªöõ6µ\04©\n«=k[ù}\Ş@4>;\ìñY”Ä¾§\Î\Ú‚[‚\Ï\Ô\Ü—„y¼Z{\Õ\ÅMŒó –2²;š÷h„=ufiO¬Q*Ñ²±v¥~ö€7¨»¹.\ì9‹C\Æaˆ½Ä©\Î\\\Ä\ä@i\à¤ÔšxB=\âu©>„Q¶£ALœ\ÍJs§\Ë\Ö&f,SAR_M÷¾_p·‰ge„®4gg.ˆ¨–÷hnG]O¤ZR\rTo^»DY¨ J›xF„+ó\"”\Ób÷-\\j¬Lgf®­Q\nO@Nõˆ’I `hlS\ëÀ\Ê\íôûx&#Éòg©È‘}2g¼«||yA©/\Ï\éJC›\ÙŞ»\í”¦7½\Ü|!„dVœ¹—-\'\Ë9»,@^W\ÚOb‘9ErÕ‘lù	úG6oe\ÊÀ\ËJÖœ\ê%\Ğ÷ó\åÒ…\èk¬yOm{*d\Ü>ilrU@½@\ÔsS²vüO¹!üiZhú(\Ç\0cªò½£\í\n\çP–H²E£\í&1„’Ä‹\rcŸ0’c\ê\àÀ.\"I™N–9a)JQ \\“@_´˜À™¹\ÉP)wŸ0\ZM˜›!\'YH6?‰\\V	‰»\'İóIÿ\0\n?†6š x\áO\rÔ¦\âM\Ãt}\"İ ¸Uğ°\\9^÷B/‘\Ò\ÂûGRnRjc&(+\á\n1x“b@!\Z.z<E;\Ö-¡\É^q_x•(›SÙ¸|‰|¹TÍ¹¤gÀ`‚.x”\î\Ö\éæš»\Ğ0ñ1ùù\Äb»¶ş^«¿²öc\0âŠ¥78f\Ô\Ş)I`t\Ö\0À=u\éx©\áô»\Ö\Z\"\á\ËQ¤M\Ãü§œ\Ä\å’\ì\ÛO\ïC—`9\îc±‚’´ğe\ÌH\"\æ\Şq‚f<\àAM=\Ş`MH7!º\ìù·Ú£\Æ)w…ò¾‚S÷İˆnOO¿„H`\Â(3»0\Óh©a\ÅC»D\áw-«\ÙÀ\ÊNıó((	5¦Í¿†‘\njúúS”@9\ì\×\Û\ÎôŒğ¹™¹\Ì\×C;ZŒ\åbY.-·Ÿü\Å(\0	4å¯¬C4\Ù\ÅM\Åÿ\0H™=/ğ\ç\0\Åa‡S\É\É,ù±\Ôj#UşÛ™?{ÀLSŠÓŸ/P—Nn™ŸŸ/”døµCh÷\é19\"W‘ù™Î®Ô”–dJ-\Ñ\ìÿ\0¤\0I-z“BDR^©kVµß¤gs¯\Ë\Î\"c”Ä¥;\È3\r)’*NY!Å¹6õ\'m¼`TK\Ô\ì¡<¼\Ì 2´6£š\èÀ[Z\î ¦KIR@\âc¥\0\ê÷\",\Ñbw‰}\Ùò“9“\ç*š°¢4¶¶\Z\èO\é©w»³Õ\í¥`4¹$Io\n0bZ€}kG{Á#ó»dÜ³%\Ñb/Q\Í\É\æ\ß(R7!…\ØxmtÉ€S!\Z‡`u[Ÿ¤B/Qz\ê“k\×Q\ãn\İÈ³œ\é f\Õ\æˆ¨N‘v\ç«\ëX	ª\nZı5õjÊ€\İ\Î÷…¬\Ô\å£Ó¥İ¡â„Š™´´\rCG™\Ã\n¥°	£ƒQG\çs1ıG>pjI\ÑÀs_ƒk+K¶\ï\ë\0ÀL/\ä\Öğ¹rrAÖ™\ï^ZÀb°©))$ñs‹–k×«¾ ‘Sd\0\êK’tzzô‚\Ü6O\ìy<4\nø\ç´85&a””»À×¼r1“\Æ!tV%a\ä¦\âZOıu\rUù÷\Ø\'7³ö\Ç\Úae•©	TÕ¾Iz(J¿ú¿\æ<#ñüa\\ùŠ™1^òb\Îe(\İ\Ïİ´³\ì±\Äp„q†zk®šKÀLG³–¢U%\É&¤›\Ô\îof%\ÈzÏƒ—14&‘\Ğ†^lñË‹\ä\ë¶³be=\ÃF,~0øGT\'‡x-\í\ÖC\r\Ç\0!ŠòAÙŒXô“0\Éj\Æ9¸D¹¤v\Ğ\nò±{4P‡_£\ÅMk_­§„^k>ö\Ù\â\Ò÷ô¿Xø€&,}“™s¤\í\ê¢P«\Û\Ö.Š9@•PVş÷xW\Ô\Û[k\Ò*\"…Ü¼\ç6Ş“gù’E,\08Gˆ\Ö\ì9Á’A&œ\Ãk\ÏxRG€,\Ão(´¡ªõ?G\Ö\î›ô\Ôük\ã\ÎlF`‰Jv¥¹Q\é\Zk”\Ò\ÑI,ÄŸrÖ´‚[9ü´n»úB\ÄYÅ$\Û)òœÊ´¥\è9\r\Û\çMº?\Â\ßz\ÅVŒş¤nğ%dX;/môôŒxx\\m´ƒ{\Ë)\Úh\æ$\n!Î†ı!U˜Ö«øs1x‹;]\ïWv3SV¹H[\Ö4qC6 eœ²5¬Ù„\Ï\â$°\Z\à.\Í\â\æUIr\ÚR‘Y@R‡©µ,6ˆ”“V~jõ‰M˜W\Èû;Ø¶\Å\Ój¤²³™]İª\î\×\è =)K•³\ÚT\Øuù\Ã\nMŞmµ/J\ë\é÷cº¤Š¨*S»³r\éH¤0\Ä!\r¯R	\ÔLŸei+\\\ì®*µ·f\æ\Õ\è\ï¹ô$G\0PU\Øø_\Ê\ÄÀ…\nf\İ\É,\r´ôµ\0\É\Z5·}>\é(À\ÛÁï¹™«\ÅUƒ]IŠQHH¹;>\ìj>\é\nB¸’U”¨º°\Êh9rĞ´\Î*R‚A\0wœ³8£r±ht\Õc5ªÃˆ‹pø\r4ƒ\Çø\ŞLÜ¾)¹,\È=F\Õ@b\Z\ÖÀ’<\â\Z¸\Ê+\ŞPj\\3ƒZ\ÄT¼\è ²R\Ôd\íc\Ñ\ß\Ê*l\ÃcÜ±Jƒ9¸ vb7Á.;\Ï;\×k\ÓJ4\ÅGdÔ”µš¯Cv¡§\Ó\Î©š€rQ‹ŠyŠŸHˆ	HX	*fJ“u;0C¾\Û\ìb–\è+\â9\Ù&\ÎA`	\æ= \ĞH¼òğfz\ÒfEfŸ]sZ&£C~Z`úÀ$=½ª\íój<\É,ƒ•\0\ßø\Õ\ÏÁ \Âjvg\0^‡Qpkhx¡pğŠÓ«ò°GF„€\Âû±\åXóş\Ü{M+$­EÖªK@,¥p²j3+Aü\ÄFi½¤“gLgr%\Ëó\İÑ¶\ä\Ø¹\0şvöƒ¶gc\'ª|\â\ê4\0wR‘d$hıI$—$˜öş—ô\Èq\İ\Ä‚\Ã6¾\Â{\ì¹ñqHªÕŒÇ¯1S&()J`t	‰J\0 @@#~\0!1\ÄÁ\Ê.Ñ£\ÑöRK£Q¾ºG­\Úb•Up„“ğòIH¯]<õ†¢I«\×\á\Ö5+\n(X’oN_%Kµ‡‘0Æ¬\ËR—	\Ó^P\ÄJjmğƒ÷I\n¡o¼\á¡/¬\Ë6K\î>\Ş\0¦7b¥3\è\í—†p\í\î\0_d·‡\ÛÁ¥D§SW‡œ%\Ô*j9&h`\rV	Ô¸c]Z<	&¨ò¼‡;=*ª›}Yb/Fû®‘EM\É\è| ‰\"‚Ş\Ò$\ìH\'Ö¼Û™ j\é•U¨\Ä\Ğ\0hÚvùCx½\àJ‹’9›Q`†ÒºŠxÃƒ\Âe\æ<:÷b•„»›¶œ¹@g«&\çÅ„Y	$84#v\é¬@‚ö\çVƒ2\á£\ÔL‰\çg “Ş¥aª\É\ÛAMş\ï%)ªB@¥Z—©û\ç9Ğ–ú±S8ƒZX\ÔB‚aıi1•\æ]Ì…Md­]¯\èğs†4`û\nX4\àR€\ÛÖš5(O¬^M®õôß”R xbrHĞ»‰\å3y\\¡ª‡‡Ÿ¶¿X »X† \ÔøB\æN°I\ã!\ÅÙ¤.Vz–f rR¼+F¹\Ş0q3\'µ5:Ojºfºr‚‰&Å€I:S§8J\ç%Sf7\'Áº\ÜÀN˜¤”€	s\Ä[0ø†\êm\åL•\0\Ô\×Fb(<9\ÂEL\ìùó¶~ŒC_¯TF†„’­İºµ…\âZ‚.ÁG]XP7\Ò„,³/˜¤*Y´b\Úó‹H9€Ï»% õ»»†ªb˜|d‚\0™\å9]\ê\æz,@R},—*§\n9zÙƒ\Ñ\à8ğ¥.jI!.§›‘Ö°+ ²A=\åİ¶rŸ—(%bNRª\Ôos\Ë\Ò\ÄNMe}ôòı\"Ò’r˜ˆJ™Ü»$‚h®>\Ş3Œ{e9]BP6+B\Ş\\õƒ”¥©YV\\\ÌY@ğ$\Û07-¡f0\ì\à’š\ì\0*\0U\Ëøø\×H\Ëjòğ\ËW,µ\æ²\âWü)ˆ$3d\â¤1 \é¸õj\Ö ¦\\Ã™@ \n”³® (ü \çJ)˜d©Ê®Ş€\nq;ü\Ì\'÷”M&c1`Ï™\É)Ñˆ\é´T\Â!.×“\å`ò{\n\ÖbK\ni\×?$2ŒÄjÃ‡5@g|\ìüN–.×gj{M\'™³Ö¥¥’Å³-LJ}\ß2ÚŠ\0I¥»O·‰+™:€(€²\0*µ\ëHø_´}¶¼\\\×.—N\ÃRZ…j¹=4\0O\é¿O¢>8\Ç\â-™\ê¹zK†WU\í7o\Î\ÇN3fHH|¨K\Ñ)~®M\É$˜\Ç#\rZ4†à°¢§_\Ã\Ï\íÇœz\Ç\ì\ßx 	 †¹44}.8€h°°MJ\çöfaRY ’Ô«’\â€5L}K°½–F\\\ê%39ÁH\Êtg0\îÀöNPb§RÂ¸H\nX—e6„Vñ\ìH@.Á€ùüT˜ù\İõ¹(e\ïñG]@p\È.*û^B„*\0¦¨-\ë\á\ìW³t¢K*v\"\äŠxGªR\ï?¾·…­É¹z¶–1K\×iÿ\0h:ğs=:‡³=-©0c²3%”\é!ùT?˜¤{‚P\0\"\î+òŒ\ê—Wz5Sù¹¡¬?ùQÓ¦	yY]œü*r@$6 jN\Ğg²IÇ¤T•\İ $³#f;\Â\çJb\ÛŒqbE\Âô²–\ä\0 \'¿ñ	¿©$\Øm\ÂÕ±n_(şo ş£h\âŠ\"!!K\äv©´\İ\î¤+$\ÉsKW\çö!‰˜¢A<¬!Nl\ÇUWXª\Ë[šµ\Ür\Ã!¢&\ÚzÔƒ!¬\Ö`h˜\r\Åõ7A~ \Î_\Ì\äñ2šÔ–:o,>\Ä>ºBC\ÅKÚ¾tç££$Rˆ»µ®\Í%z\åw	\rx´¬Tf«š3B\Â\ÃJnÑ¢ŒBÃ”r,ƒ*™pr$=~1+w¡j–\ç\à`\×0\r]\émö1K›A ¶ƒ\îÑˆó®u³‚|X\Ù²¼\ÅÀ!ßˆ$ß®\Âğ3	\0\n9\ĞXnH\Ş$¢)\Ã\ÂŞ£\ÇXZe~L¨SZ\Æ1ƒ	¼„Î™°\Ú@2l\Ê05$´³k\Ï\Â)s\êBob\Ûò6…­Ò¬\Ä°ÿ\0jv…©j=\Ê;\æ­\ía\Î\ZŸˆ\'\Ç/	\×ô\æx\Õ/sU6QZµt\Ğ\í\n)Zœ(J¿\á/ º½\"\å\Ë‚”¢ö\Ê*\İ4q\Ö-R³°½\êH?˜ZĞ¢.\ï[ßœ÷E\ÙQv(MR2Š•9Ò»B\ç\áT\nrœ¤˜9‘°QªX_V!ª\á©R\ÎeZ=¼<…ºÀ¨\nV€7g¯\İ\Ä?Š0™\æ\Ô$\Ñ\ßNnV\æŠT”°œ\ÎKfw­H\Î\ÅgÌ ”‚H»…9Õ¯MùDB”J\nrØ³ƒn^$mr†‘ù‰ü\ÄXVğ8¤ÁŸ•?ºí“¦f(qkLÓ”±4b\0¤š¤W‰\ír‡\n ‡S8g³95t†b\n™‚ªt\Ô»øRˆf\â9”Á!VpÉ¨x%™¢®\Ù\í\È\Ò\ìY(4‰œB\Ñ7\"@Vaw-QGkj#…Š\ÄKTs) •k\Ä\å³d£Š\ZV=‰jDw\ÕW<.’ß†º\Ç?%2BJ·/]\ÅÆº¼WÁ	iˆz\Í¾K\í¯k~÷5Rä’¹n6ªˆ\åX©Šˆ©\Ö<\ìÅ˜V2$Ä¹¨£lõ¬}\×\ì®**L¦*vNbQg\Ê »ƒSÙ’Ha-)M*”„5\èwñxö ú´80<8dO”\ÏÀ\ä/?·	.W\Ïıšö5e_â ¥!óG7½£\ßv7c£3‚@)”ƒak\Ñù\Ô4ur€\0° 0c@(\\\ÌBj—”\Ì\ï§\Î<¬^\Õ4D“-´ñğôL\ä\È\"Z\È+½~\ëX\Ï!NI¨\ÊX½n\Ôiú\Ä-˜9rh0µm\ç‡\Íu”—ü•}\ÂAw ·\Ò9Œ1D^=\ç2\âB\å-”¸km\Ö”(]€{C\Ì\Å¤\Î\Õ\0\Ø}®\rZ\nJ†c•4°kus¹q\á„½MÅµ\Ú}H\ÑcEša¹¡¨m¹’÷\".p$‚‘™©mzˆµJM	¢M;\Ìûsh\ÌR®$ƒ\İ;Ùƒy·H¶q5y·\Æ\ï¨X²Š\î—/G\ç\ß\Í\ëúA1fÌ ,\îzEL–\åóòa\çhX¡ügeŠ\ì3\ë”l(ª\î<\"{–²E(>10lõ _M[_„Y\×Wñ\0ı\ë¶]6 \nXKV¤Ğ‰…\ØY\É}º?~À3“M˜\Å\àğ)S3\Ñ\ÍU\Ë\ç±”2jvk¾°\Äaşb¹1‘ğ/üK¦`™9CMº¼$ ‡zWoX°–Pœ±foH¹Æ¤4ÿ\0–…Å†(¡1Eİš\Ü\Ûk|¬$©r¯\ÂOO¬-je..4x1,QY¨™\"-JMÀ=\êa¨GW9B\Ú\ÍhK¹RH©-\ËJW¬%kRªM‡°XN`\åÁK€nü\ÛNP\ÅM\ÌX:K6]š\ÑC&2c`.ô\å\êP\Õ—˜w\ÓAV\Ò2M—1ŠRd»>ƒ\"Ä¥;\Æ\Åô3F”5±\ß\Ì\\øÀaD<÷-Zry&\î¥\ÌZY))w©&\á©\Ã\ç¤ e	«]ò\Ô1‰)‰\ÈY»ÅCY:D\à;o\Ô©;\Æx˜„©/6\æ}\è…\É\0…6f\"¤\ÑÎ°¹)\0)Áz³’\\µiÔ»] ‡\' õ€\Â\ÍA¾fQ¢ƒq\ã\0@d?ñ\Ø\ZŠI*^$fSu\'`\Ö\Z˜\Ş¬•\0G{B\Zş±BzA\Ë-œš–z\ÌÙŒh\ÈPš½tb\çMc0Ò¯Tñ%¤Ö¢D°\Z\è…/ôhR2€J\è¡Z\Z³>m?Xz\çUD¥D8\Î\æ•ôxT°£˜¾ƒ¼\Ì5ü ˆ5zõÑ¿‰B\'\Õn§7Hg »˜b\å”\åà³»:Z\ÌMİ¢©›\Â3\n;m”\" SñV\ä(¹©\Ù\èyB\èõ\ä‚Lõ8@\âMM\èj	MM/F\é’	 \ê\r(\Ş<\àD\à.Gb\ê#bñ3\Ê\á\È\0€j~,5‚h\Ãn³\ÔlŒ\Ñ\ÎZÁ`\Î|\Ü(—~M12\İAA\Ít\ë0e’\Ö	Š°¨x[›g \È\Ûô‚’m\ç\ìN´t™\ÜX\naF•V¸\ã\ë	\ÃNJ\Îj¤¢a«=ÿ\0É¥Ÿ8İ“*AQ$X\Ø\Z\Z\èñ€\ÌL°\n\é9RXœ\Ä3›|:\Å<ƒL‘\Ô\ÚÕ“Î«’d\å•#ğ…(c”\ĞT?„™ ±FBR	gkóš–ùÁINT†Q3vt”D¨¶\ãZ\å\Ìy`!Y›…NüU\Z\êú¼<FN|©­\Î\æ™VHºôM”š\åRC(ğ%\ÅI5Ğœ\Ä^ñ¥if9€!œ\Z³hz\Âe=]\ê¥´\'M\é\Î&\nZB5%•QÄ­t:\r\ÑDD\çé—§´\ÉX«÷Y_(X\å\ÜVµ\å\n\ÔJ›Á\Ø\í\Ö\Z¹„\Ô\Ø\Øf.›|`V]*/E\n®\Ï~œ¡„\äz½:İª¬ê›™‰!.\å\"Œ[}v‚’’´…T8´,,Y<9MT–`õ„M2\Ü\æ%\'f>a$¿^Èµ‚ôK^\é~¤\Zs\Ú™‰/\ÅbEõ\ZE\år†·\Ùx†„¨ ˆFñ—ù¯“\ËD2RqNb\ì?X´(g<\íHHH«r\ä½Ixa«°oŒa…¥L„ıü\ç Y“”*\î‡¨„-`\ìöÎ±ylNŸ(Ô£\0ä¿7\ÒFOû3\Ö÷|¨ˆL˜Ã®¬*vø@ \Õ\Õk«@H`n«²”|\Ãr†M–”³ó©©/\ËHfñ%Qz¹a+š\êI(ŒÃ„3ª(\Â\ïZ\ë\çLŠ¤\Z\Ûô›‘T…)’\Î\å«M\àD\à¥0PH×À˜¼S×‚b2W•“\Â8‚”k­IuŠZ²°\Ì\rózš‘£)¹›J\0M¤\"p?	P9C9/x#³šm\ĞôÍ³¹e$ƒ”\Z„Š\İÁs¾\ĞJœV\ÓH	\â%¹§¦úBıò²• hkN00Y	_9mf<\Ù-SV\Î\ê*\ÌlÆƒVòøFU(€\r¨†U\Û{T}cETI²­kR¥õ…®\ë³›¿\Ö8\Å\Ã\ëú¦u’\\¹YX¤(&…L\êlÀ6Xµ)k\è²RM2ƒ§ƒúE•#!HR‹\0—{\röx¥)H™üC^+f	\rÿ\0Aù;\è|$6YQI‡\ág™š\ê$H·I²‹\á7H\"¹ŸGx\ÓRTrŠ§%\ÍjlñrI)¢T\Ä\×3&ô¡hH\áá··¿A¹Q,™yÀ\Ì\îM\Õ\Ë˜¬\\•,„\Óİ€w&F”\Z¹\ÍF¥ú\ÅÊ˜[1\Õ\ÊÀ ¥ˆ&ı ˆƒ\å\×+ó\Z¡²	¥h,V€\Â\Î\ã_¬:O°\0bXT\Öö8§(ğ„Ô©€¨•P_”e3TPsfl\È\Í@\Ã^°\ÜO×µ$°ªlå¤¨dvQ \Ü\n‘`K¸h˜Is¢¢T¤¬h7/mjD˜³\ïY!\İ9³V‡J\ä\Zô¤\Zñ$%4mJ\ÍO8`\à\Èk²6V©\é#‰g1`œ¿œ\'P:\Ûh\Ãï’‰e*R32Tj·K’Eu1ªcf(Èš\åÌ´š\ÓpE\r\Ê:cV€B™)A–\érr¸-Q_Xh!!ÉŒ·ğX)*j&Œ\Ê\áe%e\Ï\ÙZ“·3\rŸ\'0\ï%A\Í\ÒÁØ¸wpG\Ê¤¬¬$€ƒ-˜¤2j\ßMµx˜\Ùa‰±Q9p\r‹ƒgoÂ£\Ç\Î\Î\ã?\Ú\×ë©¦\âqÄ¦£0<yÂ¥eD‡­\Z‘ ¬\'+‚¥9a˜*^´\ë5!I\Í-Y’ZYg9”)•$8\rG¶ô7\á\æ¹PgnV:¦\Ä?C\ÖñÛŸ¾\Ï\ÑB@H*\\°K!\ênI›Ğ—FŠÌ…s\ÅkJ|=a³S]r’(\Â\Äe\×\Æ‰\à‚œÂŒF`5\æ9\ÂFdAÏ¦\ËM\Ú\Ë	¬\ÓÒ™œ f®_m\Î$É•\âg\æõ†\ÎÊTn\r(t£‘\ãUBsi]9\Ò÷‡†\"\ß+0+¼’E..wÉ„Q\êZ\çxTƒU@®–§\Æ)ivcMz\ÄD| 8~~™ušJ¦L^\Õ?8$M£;­>p \0j\ïoºÁ> S\×\Ê\'d\é\Ñ!Z’\ívas\çœQ)§*|b\Ö\Z¤İ©Y©R~\í8˜\Í=¶şµDQ\Z\æ\å\ïXøôˆ¹$©ôS\ë™aƒ;»Ô¹\'jÂ§)\ÅMEš¬5sŸ1is\åo\"\è\r\Í\Â^ÁJ\ï*\å´‰—)¨\î°¨Û˜k=/?¤Z¦\0W\Ä\ÇQn•…\é=\äõòL\éhÃ€I\Ì_m	\ä\"\ÊØ„„‡\"\ïo¤)8§Ì±Zğ¥´\İ\à´¤]\êI$\\İ ´,\Í?gçµ©Uˆ7G1Rª@e„ª•S\Ì\nC²ˆ\"\Ö\×A¤!O™@¹Kf¥A,\ÔM«¯/\Önb{ò\Û5¬“ˆ˜ ‚\îÅ‡t\à´*r†\î€A¥\Ï\Æ%jÊ¬®	r\ä\ĞJ4…e\0û†»\Å#ˆDC©\ì)²\Ã$‰xp\áNÀ\Õo\İ:1`C‚\é–€–K´9s@¡b:‡œ\"\\”f*(eQN*	jÍ¡k<‘uªL\æ!\Ò\Ê\î\æU\ê\ßh\â½\Ù!J\n$‚¬”øÀN\Ç!\ÂÖ X\ì4®õ…N”•‘œ(\ÆûsôŠœFiù7Á Î“J!\Ì*\Åb“ùIWú\Ãäƒ•\ÊA’\Ä×Ÿ(¡‡	j°£±ü\Ü\Şy*^Q”±	Sš³\Ü\ã\ï1dt	¸Œb@\Î‘O7¤\nIÍ“ˆÜš2\rXr;FLL…gI K$Ò¯r6†x§(\æ”\Íı»k\é\æs\ä\İl\ÖA€ß²bPS™KjÄ—m€§6~Q^\å‡\0C1«¹®ƒ\í\áR¥\ÌQH¦QBN¬Hzq\n\nP NP\\%@Ï«HQy¢Jˆœ2¹ªOf¢HĞm\é\n”¤¬	ŠURTHÚ¤{ShZR’TIRˆj\ìÂ•‰Ø·`’¬È© 9†‚‚„8€!--§ñ\É[BÒ„Î¢\Ü5}‰4\ÓK@\"@QR—”¨”„Ğ…\åò¤`\ì\ÌdÉ”)QB\Ô\0;%‹1\Z\ê\Ğ\ìhXX—-:BL\Ä\èV\Ì~±O´\Æ}t\ÜòYˆ,·*j‰	RRX¤¤š—\ä‘\ËQ¼\Z\Ö€	wsP”“\ê5„\á$¡)\Ó)/W\ÊH£jiµ…\'0UÁ.ÿ\00\×\Æ%#ıu¢T¥µ”ŒªÛ—¿H<Q„\Âu\á Ê– \'aÊ•˜²‰P¤ğ¨P£ƒúZ\Z“\Â\ÊQPcT\\FñhÅŒô‰`”®£ZUœ\æ3LÀ\ç9šûŠücbÊ–K¤>o\Ì\Ú^\æX~2­Zr¼Yˆo4C§bû©\ëó™ºzD‰\Ã\î\Çı(\Ånhñ\Ò*m‘\Ô\ÅÄ„‹¸y£’T¾ÿ\0ˆøF\Ã\Şğ‰²÷ûØ•IOUBğ¿õ\"DŠCXyÿ\0ÀZ\İf‡a\ÔA\âÿ\0†®‘\"D`¿4\çøõ’\\\ç„d›\İ\İ$,=\ãÕ‘ı£Áw\Ñ1\ÓG}=b¢GWÿ\0X\ÚU¯\Ís¦÷‡õŸŒ=wWô¸‘Ë‡NµT4–Ÿò\çú\Ìu0}\Äÿ\0Qÿ\0dH‘ÙƒS\ÖKc{®6üÊ¾õ\İ\Ãwõÿ\0\ë6—²\Ë\â=>°Œ\'ñüóŠ‰pU5\ËF&\Ëè¯Œ%V—ı_8‘#¢*ò÷S†d‘\'ü\ÌŞ‡ÿ\0Xo\à—şª~q\"Bù\Øz*›rôZq\á\Ôüb\ì¿óSÒ—ş\ã$^Ç—¨Qşo\Ò,ğ%LAa\Õ_8‘\"8ıñ·\íV\Çr›€º³ıª\â¼\"\âCÿ\0(ùú$¼ñ\è>“n¿8‘\"_\ÈòöX-¾z˜\âö·ñAğ‹‰8=ø·F\nò_ÿ\Ù'),(3,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0\n\Z!\Z\Z\Z\Z\Z\Z\Z!.%+!&8&+/1555\Z$;@;4?.4514,%+4444444444=444444444444444444444444444444444444444ÿÀ\0\0·\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0>\0\0\0\0!1AQaq\"‘¡2±ğBÁ\ÑR\á#b3C‚\ÂñSc’¢²ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0)\0\0\0\0\0\0\0\0!1AQ\"aqBR‘¡2ÿ\Ú\0\0\0?\0ùFe \åT®•\Ùne\Ù\ÕR¸\'AeÁ\êÁQšQAa!\Ë\Ğ\å\ZT\Ü\í\ZO’.—ª\í|\ìŠ”fRÎ˜R\à5k+ÿ\0ş|_~ˆ¡Ø¤TV2²b8;AJ%œ˜œ\ÄôºšŠEU!5\Ãp\êE\Ñ72¬\Äp\êmt6\è‰\r•aF\Å:©„cb[ªñô©ÄDƒ7aH^‡)»­D\È\Ô\Ï+¦Œ\ë©=Jg’\Ñ?Lj\â\n§ü+	³*3i\ä¢\n\Ó;…’$ªw$L\"˜¨FÊŠöb5xK†€ ª\á\\\ÍB!?\âšğRü\ËÖ½Q\ÕD\Ê•JŸ\ÍE…\"n%BT\rRtWÓ§\ÍH\ä*¦Q’Qc \"\Ä=G&N!V€:\'bq•\Êf\\˜ˆJ\ä~…T©ô´Ì­G\røD/\å?	\ÇQ \ç˜kK@™\áxgş˜÷û/ a¸K<-’}lih! 	U·È¬\Ê`~\î$\ï°ì™³\ášlˆg}Ö…3:j¬/“`mB¶(¡\Â\Ø+]\ÂD‹\Ù3`A\"|”_‰h±s}Bi ¶\ÌD\r\0T;ÙµÑ¦«\"\ïo¨CÔ¯L~±\ädĞ¥¤\nÀj\áA—B__\0=\Ó\ìePr¸ò\"t<•˜ªl \Ü\åa\Ö$·¯e„µ#\Ñi;£9CZğ\Çeò\İzü>S—\å»?($­mh{uû)¸\ÇQ#øYú®Š\îŒ#\Ú÷]¦P	w¢¢…2ñy‚/nr¾‰]5rŒ\Ò\Ñ#]wè­¯A”xÄ›\ryôMJÁº>uÀ9ö1Å‡S”\Çy…KªÌ¯¥a\Ü\Í$¦\Äl@X|v-zlµ\æ;j¡Mdò+5s ŸUEFD©(ê”§Qy‰µp¾mt\é•h]V‹Ù©1\ÉZ*= \ë+KŒ€M¹ªñ4MÀ2:#\"²,­R„u\n\æ\Õh`q\0Î¡QQÎ€Öƒ}º¯E\Íc\Ù;N\á\Ì{\\ü€\Üxs	ğº;¢‰9r›†o†$y£p¨†#†½š\0\î\ÈWPv\à„\éõ%¢	ª\Ãb\ÜAi\0‰NÀVJf\ê{ xLy!«p÷´‡š¢‡h\r\ê*UI \ê‡9<rrõ\ÅTS$Ÿ\Ì\\ª•\È\èj\ä\Ò\Ğ\ß\æ\İşË‡\Ãdø±\è«w\Ã$ÿ\0\Î\ËRgG§\×q/ı\ÇGxP<E›½\Ç\Íx\ï…ş»Uoø]\ÃşsJ7\Ìj=<Qœ\İ\æWŸæŒ™¿¨«Yğ\ã®\î\Èû+[Ài\Ğ\ÃŞ«\ÓN_\ÈNºˆ¸£­r$¯\Å\Ûı-î˜œ&\\Ğ¢\à?\ß?pˆ`\Ã\á\Ä½£ş\Ô+¸O´J\Î3@gQ\ê\â¯v€4\0û-\0\Ç\ØP£\åQ£\×Â„\â\\m\åkh±½CÁ\Ó\É’Ì7\ÔE|#‹8b\Zo\ã0\ëo±+p\ÜC\\\\\Ç\Ü8\\sU“f2 ±7?t\Õ\ï\r3\Í)4ğK§‘\Æ&\Æ—è£‹s›\rv2:‚³|CúX\ÒƒÏ…ócQşkIUÿ\02”\î\äøòN\Ş\Ë(T™iĞ…[\ê™t\\%Kµ{ˆt9\ÊTšpê„9$8¼cN\"¥ÿ\0Y–Z!cñ,\Î\âö¨“\ŞL«Ó”¹E(¦ò0}VÁ×¾\Û;\É%mS7\Ô+«Ô–È²\İN]‡§\ÃM„_]•”hI~Š%\Ä„ò\"jk¸\Æ\è\ÇUm-g\Ì.uFaøs„€{ª\Åi/h\Ö \İq\ËZRÍ˜6\Úä§Œğ6—D›n²µ¨9€8ß§%ôÚ¯c\ÜwcÆ‚W^œ\Ò\ÃukÁ‡‡3\'HU†xl$\êy§U°™	a\Õ-§H\Ì1\Úó]n¤/ùq\"l§B³\Ød\Íhéº½\ì9\ÄÍŠY*\Ñ\ß\â\Ã\Û\ã`3º¦¯.ú;\å?±Q¥PÁme3vf\Ú\àB¤ü€ª­74Ãª©\Åh°\ç;^\Ğwµò(_0]L\æ\0\Üo\å\Í1X¢W/KW¨^+\â	Œ¦=\åZ\êx¯\è>£\Ú\ëJÀ\Ì\Í6ˆò\äŒw‹/ ³ı<\rS#0Ø³£¨şT›Å™ği¯‰¿\Ê\Ø\n\ÓC\Éd>,\Å>“\ÆG‘œx€CĞ‚\Zú‰°GQ¯ \Ş,\éU\ZX^\êş\âK`\Ú\'\Ïu £{–®zWƒ}Ï¶!¥Ã±£\ÌÛ½‘¬øk\á?:Ÿ«¿„\ÌÀ&Jñ\ï-nªâ¢¹D\É\ÉğÅ¯øj¨,E1ÿ\0È¡+ğw‹|\àm³OòŸµv¦\å\n\æ@\Õe©*V\'.\Ø~\Z\\;±d†¯\rw\Ì/\\.Q¦\Æ5ZZBiy%O`kòu\Öt¢-\é*7`ˆá°)D=ŒqiûˆGğ‡\Ë\èƒ.š#²³ƒ¾,¡ºhu†yƒ0ø\äHô+¸£ˆ{@sÀ=€\'\î±¬ÿ\0]\İo\ê÷ŠPsI\ÃF¼\æ\ìXñÿ\0\ë/ª¨÷ù%òjT\ÉI\ï\ä\Ó\ë÷…£T6Ö‰\×\Å\\G\åSc\Ôó?ô¶\ç\Ş=\Ò‰k\İ\â\ëm6£¢¢®\Ú$\ì\Üğ\ì\Ö\Ğ\ì½\r\Î\ÈğŠ}(²YF¾W\å\Ö\ïQVÁ\è\Ñ{\Ğ\Ô\"\'TKñ,-\Ğ\Øò\Ó\Z°µ‚u.Qj‚pø˜Mp¡¯\Ô\Â\ËÒ®‰f-Ä†¶\Ãr¸\Ô)\å`\àQm›<3\àú+\Å_\î”aªø@\áJ¸=½\n\èJ\ãKğd\ÖO8\Æ0\Ì\ÖY\Ô\ÄHB\Ú5\ÒJ\Éqf<Æ„­´µ)S7\Ò}:ş8¸B¶ht‹Ì]B)»gš©\Í!¥±©7]\nI›U™–H‚C´\îªf—MÁ\Zÿ\0dÅŒ\Êtˆ ÷Vbpa\ÒZ@1\â‚Š\Òt:^\é@­e:Ur\0ö›ƒ÷\Úq4À\í#œn©h‘}¸˜@\Ãò²§ˆ\Ó\é\'_5\ÈJ¡õ×ª\åV*>ƒ‡ú€7•®¯‹Ïš\éh$F‘\ì‡\Æ\×ğ¸şh‹¡ò_ˆ\àu$ú,\Ï\Å\nØ‹ø„Gš–?\\\\\Ö\\l:g\á =÷|\ØrY\ËQQqƒ±—\ncH€\"5L]S-¶P\Ãİ€{ˆ…ö\Ñbt»,p©\ÄV›\nU9‹«şX|X\Ø#•‚n¹¨LrRpU?\rS8$Kö\n\ç†³\Â@0†XB\ËqJ~!˜pl‡8ÿ\0Pú t±óì´˜	;ªñXj2¤]¡\Íõ‚”-ô.\ÈbO†9(\àŸR¬Ù\ÈjN‡z,¥\ÉkŠ\Ìı¿ºº³¶\çûTP2ù\è¦ÿ\0©h»3f#\ãwN!£•6ùK~Ğ‘a\É²iñm`qu Áÿ\0Ñ¶e.\áÿ\0\\®ºö\äQyÀcø±\r‚.—\Òt’N¥OCŒ¡õV6˜n‘i\ä#M\ç]¼Fƒ\Ú\ÑihĞ\İs*H2š\á\ê2¸H)96=ªŒ­*ğuL°8‰vğ5<•¼W‚\È/¥}\Ë„·…bKZ\á ‚Ÿ§\Zšn&³\r‰ƒª6¥|¾!¡\×ùY¡_#\Û4\Å< \ë«HY8\ìy\à\ç¦\Z\ìKòK.\á§T\'\rZ£!\Ì\Ô_º?\à\0\0h›ˆSH»i\Õ†pKnÈD®­C\Ñ¥ nÛ­\å7À\î§S.[\Ùk\ĞÖ¤œ\Ó\Æ4‹ÍµP½{ZHs$H½\ÓŠi\Ó\Î\Ò\Èkş\ãªPÇ‰¼Ÿu´eh\Ò2·“«1\Ík„\Î\ã§UNrm\æH2\Ã\Ğk\Î\Ê/Ã€%\Öt?9­(\ÒÁşkw\\¨©LN¡rC>‡QùA.0=ô•˜\ãFmšaÅ±D\İG\â\â¹ıI\Ò\á§La¶6ù.§2.S>\Å\Æ\ë=N™i“\n¨AZ\Ê+ ‹\éŸA§ˆ\Ä‰¶\Ê\àd\0w\Ñ|ó\r\Ä\ÃbVÏÕ¨ğö6\'q\ÙK´6\×C¦\á\Ú’\ï²øƒ›(#•¹ªq¸¬’Às¿T/¬*=Î4\êy¬\Ş~\ä\ÕeŒ1Ó”U4\îPô±N¨÷»)\È$s \ÄN]s\êbTZX/c\ËjE y\ÜÏºa\\\Û\Ì*_DÀu¬¥‰˜²·è…–‰phy:\0O]L±/\0i2€µ–rU*/#.wD\rgóEN°\n\'i\ëı•Ã„L¹`X \ÖTùo¢^,€ƒ=R‰~ia­†fR>¶h ş¡\Ê¹¬b[\İKZ)¸\ÚA[E\ç\à\Î\ëƒ\æ˜\ç˜†ò×¸ş\núFÿ\0IıCO>I\æ\',L\Ø\r\åO‚qf\ÕH\'i\Üsî´–«meg\áË¢(\â\Üd\ç!\å‡qá¶·´!\ëp:\á²\Ö\é(û\r5\Ù,& D™Y,wübóp´#Q-xsH¸RZ•š\Ã\Û2ªfZ\ëÛ€ª´\Ä4\È ™L¨\×\ÙfhWƒ´Lğõ–?P›vG\ZF—Ré³Ÿn‹7„©ŸQvf•\ÉòŒ\äfúª\Î 9\Ğt\n,t\å\ìR\×\ÒIĞ¸ß‘[6Ò²P\ë€§Q°ö‚\n\Èqh‚öKš‡P9­FšÈŒHij]0–-t|\Ï^O²2«ó­şÛ q¸_–ò6’;A·´#°n\\™\0Áå½¹•¤eN¼‘\Ìl˜pû“\Ó\Ñz¯+pOX×¯¬®ZŠ\ÂqõI\Òw»T~5\×K\å\çh\Ç£#\Ü>\Õ3°E\n\ÆıUšX´¶3ş\èü7ù†\ZZ{7÷+OVM\ÒFN	e±+0ikÀp\'´­µW‚Áı1·²K[ƒÑ¦\ï`\ÔôE\á1T\ä1/n‡ò\'O€pjµeÀ6uyû&\\7ò\Z\æµ\ÅÜ¹«1ù…\Í\ÎX\Æ°Ø“¹=©q¦Æ¸\×\âsA\ïÏ²ºn7\Â%ø\ÓfV1“9FÛ™WŒ>P	\İUIÙˆ\è¥V½®tü²\ânİ²²×Œ„G\ä¯\\\Ù tK©b³9¯ñ\ÇEjVK…¨\Ö\ÉvÀ\Çy„™‡\ïû¦vGô™÷¸ü\è–\Ö>\'‘¦c¥Lß¶‹#œ/Ò¤.\Ó<Áó\Ì˜F\Ëcšö‘–œz%öF®(±\ìh\ÑÀ\É\ìD}\Ê)\Ïc†±¨\æ•\â29\à—¼ÿ\0:+x}61\Å\Íq“¬ºG¢¥*|“·\0mÀÑ©\"›ò;¼ú‚±\Üvƒğø†\ìğd¡¾¡nÁâ¡ªÇ¤´\ì	¸ñ¦:¦Å²K\Ë]\ÚDJ\Ş\æÁË Å…l™„8k#~aU\Çø­Z]ı&\ì\äGtO\Z®\Ê&›Z\Ğ	\"\ÑOusş^*–G\ëú]»OO\áN\êtÄ’\æ°S\â,\ÆS\ÊñÛ›O0²ø\ì	/-vYi \Ú.?”w\Â?‰kc”ö7\Ô#8\Û?Ô¨\é\"!\Ñh\Ño¥İŠI].>†WOşT°õtVb\ê8“¹@—A„Ò¦)Á#E…®´<;±X¼&#šy\ÃñP{.IA\ÆVrN&‰¯³o¹\nL\ìx\äg\İ$v8\Ü\èñû\áÁqF]?¬º<\Õ\é«2j8n$‡–Gºuˆ\Ä\ÃAY¾+şV¼hMşÿ\0Ê»†:L:\äu‡ªµ\Ò-GsTgx\Ö\"^ğG\ê(!SÃ±™\"d\ÉUù‰™¹•n\nIZa%gJ‹J\Ë\æ“p,gÜ’¹@¹¢Nb\İ--ˆ¿\Ô\r,3\àÖ‰%h8¶q0tõI0˜ƒM\àÅ¥q\é\Üm>Q\èÉ©+A\Õx)¢\Ğúò\Î%9Á\Ô\ÏF\â\×Z\Ï4¯‰Ô«ˆ ³\èÀs\'ód5:\Ç\às\É:¢Ñ»\Ê2\Ë\ÇaN\àµ^K\Şÿ\08¿ B6ˆ¢ğ[˜‘¼D§\ØN\"Ê¢\Î\Ê\îšún­­Q\à]\ã ıŠ‰I¼´\"\Ç\ÖYa‘ß¨\ß\ÅßšŸ¨úL\r-4\Ós;¢ˆc™”`ƒ\èR÷\âó\ï\ÒÜ¦\Ûj/\ÈÇb;”;š\ç‘\â\ß@©£\Ä\Z\\“6k2›ŠTğ\í/tùf…†Â®‹pqN\äøø\0F0\ÅHDÏœ˜ÿ\0:k\Şhƒôÿ\0u®cs¼i\Çğ&\Ó\âˆx\Ë\ÇHvo\Óö: \ë=\áK\Ş\Ç\r\rºˆU‰§j\ÎK\r•šc<=™u\í\'X\ÇUX|0şn¥@øL¸ôC\ì\Z¶5\à\Â\ì?\r|ş–ò}‘=»¼û\"XÀ\á2\à9\ÌOeT›È­¢_!¬n²y\Â\êP\ç8f\Ò5R}RFV4\Ìÿ\0}UWºCo:\\j©mD;|uM\Ì}…\Í÷nM\ïk\Ël\ZlzÀMø˜f&\Åğ\æ8u¹~z®\n_*‰»º\îz•~\Ée¼{Œh«[=×8=`œ®ş\Èn#Lb)g§\âvX\"`Ÿ\î9#\ÎÆ\Êe\Éfoy›,û°\Õğ\å\Ï,s\äÌ±ù@\îÜ¾\ëHµ\Ó!N/†gL\ànˆ\î£UŒf£1\å²+ˆq·\ÕthO™%-xÓ§y\à\Õ\É8ü8U\Z5ÁfL\ÄŠ›\ËN­0zõ\n®X² s\'—>h®1‹eRÁ#\Ç\ÊvuN)£Uex\Êò nœ#ˆ–<0Lv;ªfV‚\éşŸ\ê\ÖÜ¥¨\à\ÎQT:\ã|D‚ZH0\í\"E\ÂIŠ\â©\ÆCD°T>¡v¥VÆ«\\d¸F‹é‹¦xF‘\æB\rD¸À\æ˜\Õğ´·\ïùºÎ®Vo\'¶5\ä\ï°õ\\½v¸“}o\á:ú®Z\Ó1£HÚ³\à~hµ\È\Ó}ô´ÿ\0	?Áe!ß¤ŸT\Ë\ÄA\Z‚	¸t\\\Ì#\ßH>\\Ü€a—\r‘¨\0Lª™\é[\İM¡©·V-\Î} (º\ÃVƒ\ZtYª\åÀÃ¦z\Ï\î´\å¯\Ï,\ÌÁ7‹Û˜\æ:¢±g\åW»Dÿ\0uŠ¸ò‹mt\Ìÿ\0cI2\è;&15)ØºG­¹¥•ª31ÿ\0O#¹\\\å²\ç\ã‰f:\İ)F\İ\ÑI¾\Øé¸¬\Ã\Ä$*jpÆ½¥¬vY\ç~½\ÒVb.\İWV-¢*nuõ²[ek¡¯\0\á¿/3\ß´l\\\Ìu?·UWÅ´¸‡4¸ƒa•ÎA\ÜN\'\å\á\Øó¹h>bO\Ùuj\ç&fÖ˜cª†\í\ä•\äEP´‰­Õ‘÷Oğ§o\Ë6 [«zvşn¶-õ6	\åuo\r&W\âÍ·Sq\é(ù.J\Õx\ä\Ó\Å5Ù²Ù¤ˆúO\Ù5\â6k]\Ö=‘Xü<U,\áv¼}L<\ÇNcu\'O-\'g¶[“\Ût¤”–\ÓÊ°\Z\Ø\ĞXŸE\Å3;„\\\ØôHh½¯w¤“«\İ:tşÉ\\f\\”\Ø\Ò\ç˜\Ø\rIôR¢\ï­*¡Ã‹/6hÀª\0üII\Î\rgŒ›\Ó\Õg8¦)õC!€\è?të²œ5ƒıGUk+ä©rlq˜Š\í©\â\È\ÚdHv\ç›n†\Ç\âKÛ‘®-iú\är\n\Æ\×ùø`\áõ6\æ,\ïiôI\ÍNk=F\×œó“A\Øp\Ö}#\Ïtm:‰]:ÈªU5\Î\íœòm\åğÀ“ù¢iV£rÛòY\Ú5SW8\ZDò:t]\ßOTÑ“2_pF5Æµ0Ÿ\îo^ag°øPûÈ¶\ÂÀ~uMx­g¹\Ğ\ç“i\è\Ğ \Ù]¬y\È\ïô\Ü\0v³\04¸Aƒs¾—è·¦ùeon4E\Ü=®9Z]\ä\í<n\åøLƒ\0¬ƒ¸?š\'¸ş$\Úml4\ç: w\ê?…—{³L’›Š.Ê…òTQx*!\Î\r$[\Ä`\ÏA©U5›\îtı\Ó!Y„2r´D\ÚKŒftvª¶9K L^S \ÇÈƒ¨‘¡±^6”¸F»\\¯\Õ‡\á\îs¬\Ímy%h°\\\r\ÂK\àLX\Ü\é¨\Òı\åRN\\\"\â\é\äW†¤G…—\'[yLğ\Ü\Z\ä¼\ïk\ë\ê,5·dÅ¢\á×şiø€»\Â\Ï^]–‘‚Š\È\Ûrc§T¤\Ï4F\Ğ\Õ\Ëú&K®¹V\à\Ú-¥Y\Ì2\ÒG\ç$\ï‡ñÍ`\í\ÊeŸ^)¡\ÙôJ\\E¥­‡\Ât\Ô__dC\ÌÀ‹hmö_<\Ãc\\\Ëj=üŠs…\â¾—=}\nMyj14Q¿\êSG«®R4\ÛuŸ\Åp7\r\"\\p\Ò<v\è5öFR\â\Î\r\ÊM¦~\ß\Â2p£j-I£)™\Ìwˆy&X\n\Í{\r3©°¸Z\'QcÃƒÀ¶¿`aS‡ÀRg‰‡&5½¹iJ°5$[ş^j\áE\'sCn/vÿ\0#\î’\ĞÄ¶‡…®s\Ä\é©o ·e¡Â´±\î ¹\Í;¶\í\ç\Ùy[\Ç<\Ò`–øbûˆ•ƒ„ªš.2IŠ\É°€\ãx\"/\×ùI1%\á\Ä;^Zz\Ö\Ã\ä1º´ùƒ\ì«\Ä`\é?\êAY/o&Še\Ü_‡m\Ş\ÑLIn ¦\Ç\Í:y)Áiƒy‹\Ä%<7\ÊVdA7qªeAğ\ä­\'‚¿~sK>XcŒg\'£uöH1\ØLƒ#^÷F£1-},¼­]\Ò\á£s\ÜD˜6\è \ì5Wİk‡ôƒ\ÑJ›n‘¾Ô„\ÕZ\æ›a77G:›\Ú`¶:;U\n\ÕCE\â\å\Z-—‚%\ÈÇqFQkšò\è7\'Q ÿ\0Jø‚÷½\ìi\r&@:\ÜI\é¬\Ù)\Î\á\Ï\ì¥J³šdGš·\ÕQ“‚o!´ñğ`˜<‘ô1‹\Ş\Ã]\\\æ\ØªBûôJ«3#\Ü\Ë\Ë]7òY=(¾”tjpõ\å3f,6›­2\"w‡mrV=À\èr:œB$RÄ½°\ÖıV\Út\éxW¥	Eğc-3\ÜN\"`8LXF±hö•}Y{r6$ç¹‘&º \ÇyGpüF2r†»B\à}4\Ì\â\èô…7ğpÿ\0­\ä4\êÖ“.\Zø|Dt$vF8·ÉŠ\Óòd8®1µ^[¶ın\ê\èûl¼\Ãp\çº\Ğ\ß_A%l\Ç\n\ÃS2\Ö3#^¾^Šú¸\ÚL™‰¤\Ş s\Õ\'ùf´¸F~—Â,my\ïk[\Îıq\àXzB[x3r\àm\Ö\ÈG›0\'ş‘\Ê\éV/‹;õ\ŞÓ¯\İTb—Cª5Ux:C+\0hò=ŠCø—P\Ñ\'i:_\Í\Öcs\ì$\ì©aUcH;Š{Ì¸\Ï\ÙRIU\ç^—J’‰\Ê\åË0Ò¼^ª \åÀÁ‘b¹r\0?\ÄH³\ï\×ù¦T\ë‡	Ë§¶…g”™P´\È$4jUÀøI\Ğ\ÍÎµW3ˆ8~k\Õgiq£„õ\Â?‹iĞ=¼’¡\ØõœL‹ß¯÷D\Ó\âm1&?R.\ï÷‰ü…\Í&/›%‘šoñ¢\ã0#q¨\î?”Hª\Çpb<¦dy,›]¹>\ÚöSmh\Òó\ßğ\"€\×R\é\ÖÛˆ¹\ÂğÕ.cC¤‡\Ée\éb›\êw;=o{/_\Är\ë5\ÒJbù@›4µ°Tb\Äx†\Óc7\Ş\Û\Ù\Î\Æ\Ü8ƒ\Ğÿ\0)+q¯sG+~~\è\Ç8$M÷•/N¤Rœ—f„\0ÿ\0ÿ\0pP©2‹‡€ƒ¸0GP?4Hİy&1¸ô\\\ìs\ã\ê\ë§\îˆ\Â+ r—‘\Õ>‡œ€ôuÀ\íu&p\Ú+<\ä\Ï`‘{\É$;i\å:]E˜‡¼Ì™ô7\èU\íUº]³UA\ì¸\å=Iƒ±\ÙA\Õ)p\Órt\ßøYQˆuüNö¿\"eUœØ’\íM\äşnšTKÉ®`ˆ¤!ªñö€\éq÷ü\Ñf˜m#oq\ÕxÇ‰\ç\å1%;aCªœl“\r¡*qw\è›õ:\Û]\âª_Y­»ˆ\é\×h„À.¶%\îğ\ç\ïi\í(W¸$€??,„v.O„zû@B\â^N¦\è\neµ¸ŒY§$œI’I+\È\\€$Ò¤\Ó:(´.\Ñ\0]L\İHº4\\\ç~~~]H\Éşj¹RJ\äƒ®\\¹PW.\\€=\\¹r9r\å\È†>k±ED}\×.Iò4X*Ä6\Ğ\áH>F‘\é~k—&#›W¿m$wReK½ys— 	ƒa~Ó¤~lº¥I7ıµ\ÚÃ²\å\È\ÂD›ƒ\ëÛ–\ÊÏšD\í9‹W.@1\â÷#rT¾dI\'y\ï .\\€<s\Û/\Ü\0¼b@\Ş{•Ë•Q\Äy.ŸÜ \ß\Å@údù\İr\ä¦1\çx\íü¨±«—$Æ‚X]+—!\È¼r\ä\É&\Õ\ä.\\€:W¥r\å Fz/W.Tÿ\Ù'),(4,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z ,$) %6%).0333\Z\"9>92=,2302*$)22222244282222222222222222222222222222222222222222ÿÀ\0\0·\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0;\0\0\0\0!1AQ\"aq2B‘¡#R±Á\Ñb\á$ğ3r’¢ñ‚ÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0*\0\0\0\0\0\0\0!1\"AQa2qB‘¡ÁRÿ\Ú\0\0\0?\0\ÚCqV¤fü\×S)\àW\Ãpk\æ\Ôsg¯d˜kÖš\Ãz\ïV\Û\×i\Z°¡W£]lò#¨WLT]\"UƒsE,\äË½ª\Éã¸ª>¢ªGó\Å¿5\åK‰hÍ­±\ëC\âRC\êSM\Ì*ÜŠº—Š\ÔBœ.\ç\ÖOŞ˜œ¾1\ĞU\î€¨WœƒjÉ¤\r–AˆMª\é$F;P‘\á…õ\Z¢BU®£j.]´‡cCfºıš:9F›‘j_ø«‹\ĞûPVX£‹ŸP:mŞ´FÔ‚ô6!\Ë~JöbO^Ô–3\ÊG\é^²\Õ\Ü¤sW]zS\Ókd›¦\n¶\Õ\ÜÈ¡x\ä\èª.)t\ï#)±¡$ã’¼Œ†š\âßµ*ËFbŠg,ìµ’aiK\Ûc\\ÊŠ¤_{\ÕQ#£Gj7\Ék’)–›t\Ò›	¨‚¢\ßL8R¢õ\ÎYj\ÏÄ°ØŠ»`|´Še\Âj7&¡\ÄWj÷4`ŒZôb¹,R\ã°V[Ş¼\ÅF\\mVJCl*¶%V´›X2\É\æ@\Ü\ĞY–±Ùˆø®ğ\ë#5É°¯1P=õ)­I\Äl¦p™Q°\ÜÔ¢£Ä›š”¶r:ošµ\Û\Ğ/j\Ô\Õ\ì÷6±±¢¤Z²\Æ@95\ï\àÔ–+¥‰ŞªŠeAf4#l\ï\ì\ä\ÜXQb0\r\Å\n38×µx¹´d\ÚôSŠBµ\'\à5\äKoj\Ê	°¡İ‘\ÎÆ–c\ÚE`#\ïñAË\Ê4:•l,9ª0\Ê\ÊMú×°bt\ælhA÷]\ë¬bTrmU4z\Ú\â•bpòI%¸µŒñ\Í\Å5zÍ…{lj$mÁ–\Í\â\0¢õ~$£U\íM\ÚÅ©-Db\Ö5\Ä $mz]‡I–cµ`(\Û\Ñ\ä·@\ã\â\Ã5 \æ—H#IµU›\Äö\Z\æ4Œ¦üÚ–RöF²¹$´g\ÓL\Ú7Q§­s”Dö¢ä½€¦Š·`¬šo¨\Ñx\\\Ü\×RN\ìÁx®ç‘”Zô{Ar\ÑL3(%G5g\×j\î\"¯©«]\ã\äŠDšwaµ\è9\×2e:Å‹Ö­—§uŞ¬\ä^ö¦T\Ø2‘\Æ±#š¿Aµ1ˆ›1Ş’\æ\Ó+/¦¶\rMŒ\"\Ç\"¹x¯f\ÍA`Š„\\B\ë\Ó>QlEÈ­X¡Xa`«¨nk\Ü33­\ØZ‘\Ú`\ÄşQÒ¡ñúoÅ«W³5\ènH\n\çğòi;\ĞŒxTA½Hó96%HZ	g&w\àğ\å\Òÿ\01©OcÄ‚J§Ò±y\ËĞ½Ù—a¸®\âˆ6\ãš\åøô\ï^Ã˜\"j*	\í&\ëB&&Æ‡tT>¾(˜±^c]x¯q¸O0X\ÑiU \'[+ƒ	‹ZõB\à\á¹caE„1 ^E,\Æ\áR\Ê\Ö?5°°Ÿ!h\Ñ\'Wp\â£c\éŞ“å“«]šm…\ÃD‡k\Ò\Ûl-$uŠ\Â\Ç\'\Ôz¶T\Ùwø gÀ\İ\îÛµ=\ÂeöµW§	M\ÔQ9\Ê1Y`š€Ü‹^‡\Å`™·\éNŸ„[Uvp¶æª¿Ål—\×KFuò¨\Ùl@½[†Âˆ\ÖÀñFc¡\ê\rÈšl[zƒƒ‹¦Z2µeI.A¾\İjfXõC{×ccc\\L\Ñ\Ì\â\Â\äPiPk6`….\İk\ØLf\åEş*¬\Ë¢>:P9&,Ø¨Bi›ö\nò†±\Ê7MWúu\æª|{#X§5\ëJ\în\ß4«f¢¬\ï\è5*š_‚\ÄK&ö6÷§q!}\ÖdF5\ZE…3\é©f\ÍÏŠª8\Ã®ôŸ—™\ZÁ­L±û/ \ïJf†U—rzV”R\Å\Z>\ÆO:a\ãõXÚ¨Á\çQH/zU\Ég2´\ß\ïI0‘9Fr}\éÕ¸ú5#Eš\å\ÂoToc\íT\áò™eZ\Ä÷¡\å”\áÆ­w¨¨3y4j*mR—$?\à»ÿ\0…M&»›=Q½,”s5œºU˜|m&\ç\Ò(\Ûh¬k…\Æù¾¡q\Ù41“*ıT>x\n\0`;q]¦\äŒ31¿$SG\r^\ßu\Ô\È@tª\É¥.j¦f.šmÁ4^[4QFÂ…†€¿ÔŸù\Z¥8ü@\è•\å	Ô“\ÙFô½`³\ë‘½DÏ¢Õ½wú\ÌO`,Me¬\ÚğT0\ç”:ikc¦F:¯aÖÈ¤Ù‡&\n\ëÅ¨R£X3–”\èz?–5\î\Ò;QX|4c` {\Õ2\á_U‘¶¤A¿*\\<IkÚˆ“®¶PA4\åw!\ŞSu7k}\èhüC¦S\åj«Š}\Äé¿µ2Ü™bõ»n—\àPyşå€¨ü “ûQ˜|wš»’kØ—K\ÙQEùj\î]H¨\Ô#™\Åò¹lE‚\Ç\Í#\0 ıÁÖšÁŒ+­\ïÅ·n\"+‘bøª\Ó\nÚ®\Ò|XTznPx)&¤²q\n\ÂÎ¶¿}\èIr8[u%~û~•dh\å›U+Ÿ=P\Ä*³\ëÅ®\è¡!	_kÌ¼*\Ä\Ş2O\ßûPøL¦L1½\Ë\\õ\éM°Y¹\Ö.v=ø§rÎŒ=B\â¥ô\ç\â\éü”}IÁÔ•¡\Ğ;%\ËW\Ò1\È\ÕL\ä\ÂSõ/mø¤M\á\ç\'P•­R—NQ\Ê3‹YcEM^¦µ&dü½¤8\ì|±?—¹÷¦Yn!üG7sŞ¹Ó”Ÿ¡ø¥–&%-e>ª\èe¬\ÃQ}\ë\'\â\Ìh‰\Ğ\Å\Íø¤ğ\ä²K¹A\ÕhGÌ<,°Ù‡—+G!½¸­*zÀkÚ‘\ç¹tm\ëMw¥Ëœ¶	±Vm#W%cL\ë6hÁ\Õx\Î2šÄš$r\Éb=\é†#\r†+\é\ãµ\íl5^\0q9G\â˜0¸\0Ş›Ìº#\ĞËµ­U`³EE\Ò\ÛÚ¨\Æ\æ\ÃR­\ÔQO	 S¿^Ãš&óHôójsŠ…$\ZSc\íK£ÎŒ…\ä\íj3/Á¼!\ÉŞ´¤\Z,\0cµ÷½_Œ\ÃYn¢¸\ÃcŒ\ç\ÓÒ‹p\ä\é6µd¢À\ÛòQ‡\Ä(K[\æ‡b8.9£¤‹B·¥M$\É\ÂúMš\Ã\nÎ¤Ï¼²P§j”\Î<$L*.y©Icc\Ğ6\'Ã˜r\Å\Ï\Ôyÿ\0ò¹Á\å\ĞÅ¹S~\æ\Âövk\Õì ’ob£z¤,U\è\ZS\n\Ø\èø¢Š,ŸIµ«\Ü.+Pô%\è|S7–\î£I]\Í\é8¹4¡Œ˜k-¶5\Ì8T]Ù¯\ízÊ®g‹m\Zcr¬Àj±Ç­øµ8“)—Ia*–\çOÿ\05E\n\Ê@w¦À±b]\İc·›-÷§Y\Ë_\â\"+şn	\'\çµfğ\Ş$xµFÀkV!½…0˜ŒW­X\"¶÷bG\è©§\äÒ¶šxF€\ÎÊªj-¾\ÃoaC\ã±%]u«!\'b8>\×i—‡&7a#rºnN\Ü_›\ĞXº)\Ö/¤ğ{ÿ\0š{\Å\n¡›C¼\ælGÖ‘¾½7?¥\ïûSŠd“\×`l\ÃÚ³m\ãS¤\Ø_j\Î\äØ¹±’ùjl\×$¶­*O\ê©”s{3N©\àúFa6³)\Úı~õ\ÖdŒmÿ\0´~¢–&\0\áÁy&Y\0\á–\Ö=\r\îoj	üKcaK\ÉÅ»ş\r\Â\Ö?“O4©¤¨·Ã¥(»;Pv\à\rÿ\0jBs9<\Í\Ñ\Ô9ô’¤=;¦ø{	3<¥\äsrM½\"û\"õ°\îy¥\é\Ü\Ş]PP^Ã±1\ÈV³~\ÄZşÂ…Ln%SQ\Ëò/nö¢ñ24¡”2…\Û\Ôy¦\Ô&2i(n\ãk¶\â·QVStg\r\"Ü»€ùC×±¥¹\ÎP%a\äJªz©\ëñE\á2\ì$g[zß¹cnû/ªó§S¡\àK\È\r¬A\æÿ\0öø«§_É—İ‹ÿ\0€ñxY},ì¥†ôT¹Ÿ”|½…©> \â\Â\ë) ¿°§YZ\áq(…ş±É½®}\éa	uG\ÊJ*\ŞApÙ´z‰nMx\Ø,,\ìXı(\ì\ïÂ¢`<¶\nGQ\Í`L\Z€÷\'¹\ëB})\Ãhh\Îû^O $-d±˜¤R2u\Úô\Ùs`C£½XÙ¬zmaH©‡¹¶i	\Zt\ïH\ß21A(ÿ\0I\è>i\æ	ªM \ê4\ÅpÀr-Ò™[j&‘\â`‘¦6`w\ÓÚ´¸LR\Ëñ\Z\İ½ªù\ÒMaSÔ§c\ì)}\á\×­\ÈÔ¾\İhT¤\í›\Z\åXd\ØFŞ’o\\\çø‰”^/[v¦¸(^‚«hŠ\É}´š\Ü^\ÍjÅ¹,“Iÿ\0¬¥}š96D65|\Ó!a¤‚j\ìLV\ì7\ïY¦\İ•4\ÅK¹}úÔ©ø(\ç?­JN%9\åÚ‡¡ÿ\0j/*Dºd>¯z÷+¨c7cµ3ü\n\í$ ]À\è?É®IË¹z!\Ô\ê%†q„\Â\ê„\æ\İOø«\Æ9„qÀS¦\×­6Ÿ0Fj·\Åg±8\å‰\É+\æ1úv¹·°\ïW—W§Ó\"Q„¤\í€\ÔNË¦5fK\r\ÕI\n:^\ÜSr\Ù\äEu•}[\Ú\ä€>G&©ƒ97²Ç¥˜ı:t±<pj\Æ\ÍLGA²tz\åúŠòt8¿e¸T%Dywf]\É>\ç{U™¶%R2ñ6\È/¦ıoŠIœ\à1Rÿ\0P¸\Ôÿ\0´ÕÂ«\ÄN$²Ü‘ ›o_Í¸\íóE÷*B¥]Í°Ùš.›‘\Æ\ç©5œÏ †IŒ¬—Ö¡4€If\Ş\ÆÃ“o\è*¯á¼‚†ò+!@.À\Úû\"À\×Y>fñ\êya’6[ÖŒ¦\Än\ÃPûR\ÅOö£µ³Ü£\Ãxhc\Õ:;³\\€ú‚¨<(^ö\ïK±‰Fhcx\Ñ\Æ\çKhÛ¥ø¿\íZ\â„v\àõ\0E\îW~\ëö¢\ê”kƒkpA\ã\ïO\Ë\ÛbÔ—^O\n\â#g™ˆŠúl\r‹ÛûU^#À`\Ä%\âÔŒ–?[\Â\â\à†\'¥.\Ã\ÂòJa\Ã\"Ÿ\ÔHT\Ä\Û\â\ä\Ø\íLq¾wP%)]v\Ş\Úõµ§^‹²Ì‹2|H\Ğ\nˆ\Ğ\0Kocm­\ïAf\Ø90\Ç]\Ã\Ç¨q\ÛP4.\'22a0Îª»>5½D›j° óŒ\ìÄº•\Øi\Ğ\Â\Ç~¿õ”–\äjM‹{\È\Ä‚\Æß˜G\éZ‰‹X‘”_·6ù\éH²:¨Q\ÅX#T‘\ãK\"ƒk\r” }É¡5ğ½\â0\ÒP€.½”-\ís\ï}­N\Ó‘:²¹b †¾À\Ş\Ûı­Jñr\Ñ>1$%ü»\Ú\ÚT“\é<\Ş\Ä\Ò<Ÿø²b\Ê¹~\Üt\ëK\Å\Ğ\Ûò}L\Ú2ºCúşoI²L¹|\É%rQK)\Ç\É?{\×ôÂ¢.{½Ám@z‡`G½.jJµ¸#û\ÕvKŠ¬†)\ÚM¾ûQ³C‘\ÚEVR7.)>Y‚ÒŠó‹u\ny~oj\ç™\Øl+\Ğ\é·\\üø9e\ßi\Î+\Ú#`…\ïK—\Ã7Œ\ês¨û\Ñx‰Œq‡\'”¾,\á\Â\0šó\'(òvÈ©q\Ã\Ëğş\\E]\É\"ô·\"\Í<\ÉY¬¥58+Ÿ\â>\ŞÇš0Ë‚€° \Ô\Ç\êş\æ”l1\Ğ\Å\Æ\r”Ú©\Ä\Ë\ë[0 óYøò¹\ÒEótrm\Í8Ÿ\Êm:~¡\Å#›\ÓŠN\Ñng#\"\r\ÇJB3ƒi=li\î5_@\á¸\ØQ¶]Z\Ú\ã·\Ô\än\\P¤a\â	\æ)%†÷¡\ÆwI\ëµ3\\L¦;Š\ÍO€X¤‡ÔŸ\Ë\ØÖ’\Î\Ã\íÉ”\ÊÄ‘{*ShóJ”pkf“\0€ \Ü¶\çûVG\ÆY–!Yc…ÜŸ¥y sA¦o\"‰µ6\ÂøœkP}\Ï?­z©\ÅÃŒpqqj\\™™Ã¼®ú9–¹R¤[ä¿zi•b\Ù™\âd‘±a\È6SÁ\ã¥i£\ÅE&\èúX÷\ÜR|\Ó	‰ó\"c‘¯©\r\í±±e\æ×·z\âŸøòN\êÎˆõT°É›\Ë3G\ç&‹*±R\0/\ÇAõo\íYL·Á\ç\ÄjfF²©¸\Ò\ËbI\Ş\älkR¹Ûƒc\Ş\Ç\ØÒœ\Ã\Ä`¬J_F\ÚK_\ên\æ\ÛRM/\Üx]Q_ıT\ãƒu<\ÇüVy³‰d’F\ĞYo{ƒÁ\ín´~m—.,”‡LrXCĞ wktª`ğüøH[Ö“X–:5j÷Ù¹¦„a\Æ\ìÍ»¤‡ş\Í\Äqy’-¤facÊ€H\ïkı\ÅOgi.ÕˆG ÿ\0+t\"—dş\ÅÈg™jö`¥˜\\lIi6¶\Û\Ñù~^¸fc‹X\å}^N¥	a¸Vü×¾ÿ\0¥.>p\nM\Ú\Ùd|½QQ\ãV }mõß«jµ«!™ÀS\åG!x\ÜjR¦û¹·zw\âˆ\Õ\Ìo†(—p¤z\0<2Á‡4\ï$\áA(Á\ä`5\ÈmsnƒùTv4°j®Ovµ³)\Ìb\Ã\é»Y\ÏRE÷?¿\ëOò,“Æ²³ˆÑ…\Ò÷,Àğ\Úv°=+¯ecô¹m=,\Ã`Àñ«¹7\ÓVÊF9IeP5¬l-m¸\ãŞ„\ã[2“XxÆ—\ÂG©d€\î@\ÒAc\Ëry¬¦c><iˆmZ.Ş“co\å$n;ı©\Î_˜\Äx¬|»”±\Ò©A\êø\âô\éòœJ#ü4IÙ€¾¿ªş÷­\Å]´Á\'šÙ‹ñ]F\Ã;G>‡[–¾Ä‚¥·b>â´¸L\Ò(BÑ¡@-b{ûûÑ™>XcZ5™Š3¨\ÙOÓ¤¶°&Û›\Ò/\ŞDÿ\0·MQeÔ¿˜µˆ\ïO–’¼SeF<@\Ö8\ÜFK*¶\Æ\ÊI\0‘{\ÛŞŒğÿ\0…\"üCm½€	~Às÷½=\Ê\ÌqÂ©#\êm Û§_½esGq‹@²JÌ¡\ÕT\\ª’A\Ôx\êw6\äRAJ]±ÍŒ\Ú\Û\ÅÙ’FFp\n›úÖ³(Ë‘	\ÅH\Úİ€(§…\Z@¸X\Ú÷<_j«/ğş\rªYd\Ä9\ÔÅ½A6\ÙTp\0°ß“U\ã1¤š\ë‡It²öBsú˜Z	\Æ\ãË\ÎÔ¹V\í\Ís#‚/CK‰(¦N‹ıö³›y\Z1Hsˆ°ò\ä#\Ë=G4 \ÊğªA‹i:š*)\Õî¤“Ôª¨!\'šHµ´ô¿z\à“¦] \ßô†p…\Ü\ìnGj/(K\Üö\ëHó¼\ã\ËMi%…\ìkŒ¯6BC³,¾*œ£\ÇÈœ$ò\ÆR`’M\äv_ö\Ş\Ô<=\Ëw;\ÓÚ\Íc’HıA\éÒ”a0\î²ˆOH\İnn	¥i^¿q¢\íoöƒ\æŸE†“½]Ä¸\Z-¨‘µª©á»¨A£W\Ômaj»¢†V³q¿\ï[‹ğkVŒ„yv)¤\Ò\ë¢\ç’oµ<\Æd\"\ŞN\'\Üjü\\…Fµ}Dt\ïñQ0‡\Z\×\Ë~j8ğ‚\äı‡EŠ„½Jñ1/¤ \Ûj”œ™«òg±\Ñir8\ÛoŠ	Zx‡wV\ÒV\â\Ö;qH™­]±x\"\Î\ÒV\Zg‚\ÏdO\ÌiG½x­UQ¡\\6IÁ.\Ó\"“ü\Ãcú\êœ†0\Çq	!\ÚÊbq¸\Û~¶¿z\Êj«\á\Å:pÖ¦rŒö…\à\ãö³K\ÂÀá…(\ál	?J–	µ]‡Ê¢D´®\Ì\äzˆbú\ØŸ4»\âyf!\×Ş˜¾+‰b\Ñ=­¨qúqSÿ\0^9\â\ïò¨ô\×ğf1y¦‡>\\„:w<Şˆ\Ä\ä8¼Xõ¤j·6}E›U­°úx\ëúW˜/<3Iˆ,˜…°\ĞV\àƒrY™\r\Åøµ‰\ëK¦ñ\Å\Èólw¿OÖ¹\å\Ñ\ã+«.§\Ê=¬o‚\È#\ïHÀ\Ü*³\Ø\ìn,Xü\í\íJ3\Ì\Æ1.ˆ\×J[m Ÿ›G\à lj·ıÀVKşMJvz…©E”\ÅdI i\Z\å™@\ÙF­\ì?\Í%5½\Ò\ÎÙ‰\Çf#*ß¶\à´\Ã\'l\\\Ñ\ë†	\\tm”‚\Ä_\íN3¬\ÏG‰|»uv!@\ß\Ú\æût¢\àñGh\Ğ.”ô€8\0mMf”¥úD¹fk$Hce(á˜²‘¤†,X\Ü{“{\ĞÙ·Š4OŸU˜»\Â\Ä-şö?ÿ\04\×0ƒñ’F\ÒŒ!:™9t·\Ğ[¦ö7ù·4\Îo\åò\ÆÑˆ\Õ	2\05\Ş\Ûgv#noY(r¹09:\Ñf[Ÿ\Ë>Ñ©c\Ö\İ>I\ØQ–S~\"%óZ\åEÈ·\Çö4\Ú<º4H~†Ø±>¦p9c\î?¡¢ğx¯ÆŸ-›H[9`A À=	\ã\ïZ)\É\Òv,©f©bùr™\ß\åÀ¿\Âe\Ò?Ò‚\åtÿ\0¹¶¸¾ö\æµ+\åaTªz¤6\Ô\ÆÚš\Ü\\ö\Øp/S˜,k\å\Æ,£oü÷¤HZ»b£\ÓXß²\r\Ê{\Ñ~\'\Ïsz¤¸µRòAOˆ**m¹2‰PYŞ‡‹8Hœ]W\ékñÖ²Ø¬\æó¬w\ØnkYñ\è¡um\ÛcI\Ô\íTÆ†FÏ,© €ß¥\è|31,\ÊTn	¿\éFÅ—a\Ü\ëª\ßH>›÷µgg\Î\Ú)\Z7’\ÚM¾{Z¹w’\Ë\Ôp6\Ë#H\ËR«°>‘õ-¿˜^Œ‘\áwG;²‚ıÀ¥¹†K<ğ¬±®\×\n\æ\×>+Ü‹\Øx‚\È-%Î¾\àßŠ4\Òø¦ñ±ö#:d\ÙÔ¯ÈµRe]Q\Ô#~OoŠL`\Å2\ÆË«{\í\Ïÿ\0•\Öe“\éx#\å\é>¡\È+o\ëY\Û\È,Uñªú.½¸\íKq™n´\Ér7#¡ö®§\ÙE¤¿·[S\Ñk\0û\Ğr¶µ!N¶ò(XøÍ¶£f\Í`µ…\ËC¢§šÁG6¶õ\Íò&]/„¦ ÍPkF^¢As\\4\í3²H4“µûXT­¦…şö\í~9!^|\ìcRì¤ƒÀ\ä^²’8«3¬RÇ¨™,\r\ï\ÔûV[™\Éb^6\Ò\rµ\ÛüWOF\ã‘&\Òx4ev®).1GúX\Z)\'W\Z1ˆjõ· \Öj±^€lº=ª\Ğö¡Ä•\í\èY†x\\\ÎHÏ¥\Èû\ÑßŒ\ÂÍ¶+ÿ\0»H\róq¸¬ø55\Õ#6…qF¿/\É0¡O\á$(Mın7\és\ê·\ëH³œ¿h¤(?2z\×\ï§p>@¡U\Ê\î\r9Àxhö¾¥\ìkJ=>¦\Õ9\ÃY*ğşb¦?4D’û\Ø\r¿^hO°’6™—\"\Ú\äm¨\\üÖ\Ó	>\Ò $m¿{\ïK¼E\àù1\é\ÃÎ¥I¹\r±6\Ü\rCn}ª_\ê´ûr‡ú\Ë\ÎƒñµZ¹¾ÿ\0Ö†Î±\Ñ\Ã)P\Ú½c};?OŞ…Ë²Œ\Î&16˜:i?&õ«\Ë<,±¸\Ä\âÊ¼£\èAº\'[‹ıo\îE‡AÖŒÇ“u-õ¢²Š0~\\Lhø\Ë!\Â«>\Ûjê©¿Ÿa\É8††/L1¬k\ÙE¯óWæ™¡sa\Å\'{\Z«q‚\ãk”\ÈöI\ïC™«Æµ‰—‘R\Øôy‰\ÆZ‘ÉŒ2±¿ö&\Ís[\ËC\êü\Çù\æ–`_ğ\Ó\rõ)7¿¿½S/]±\Ô\Ş	(­#±\æ\áxÿ\0Š\Òø^£Œy–‘÷;kDd\ÙûJ4ª· R+7ŸGˆ…\ÚE†A7¥€º‹ô?Ë½r\ÎS\ê>,´Tbl0\Íš\ÇW§k \ï\×\íAx£&}2@\0‘¢\æû\ÑYNk*\0@X©,m\É?Ú˜®a¬Gs\ì:{Ú¡Zy§zÀ&H˜‰\"W\Ôp¤›\ÛûWP\à\áfs2“!°\"\çku\ïŞŠ¥Â©Ğ z—‹v°«\'’4&D{~I\ß`Şµ›%>ÀÁ;jff;;¨è¢Š\Íw[·ğù6\æı\Å(\Ä\å8·-%\ã\ßpºˆo-zY…ŠK\Ætc}{j#b¶Öš\ä\Õ0%\åfŠ|dVô \Ôµ†õœ“\Åvv·Ku¢²9ü²\í:\ÙÕŠ…;¿7½\è¬\Öh1 F\ê’,\à¯\ÅM¥ycH;‡gŒ1E\í\ìz^»¥ü€ƒPtùª0\Ø\Ø!\Z@\Õm®Ûš­`IXØ£”şÓ¹\"\ã¡ø­@\Û\È\Çş\çºòÿ\0Šò²\ë.0\î ‘†ö=\ìmRK\Ği|	±9‘†[\n\0°¿}\éJzŠa\ïb‰ûnElsœF\Ë\"=1µ€[l¾À÷7\à0€\\(2Z\Ú\ï\ê?~ƒÚº>¥,ş\Â8\Ùó\ì\Û\'X›\\n\Äuÿ\0‹W‰‰5P²ûSL\Û?¬\Ç\É\ßPù\çâ†—0(URX‹\0–¿kWd&\ÜUä„ ¯.\Ã\æ¨\ÛI÷ÿ\04\Ê)\Çz_<a4H\Ş\ãrO4Ÿ‡­vS¾›\ßÿ\0¯J\ÉF@vz\ÍV¬µš‡1`¡œr:Š;\r˜#\r˜\ZR«\ÒÕˆIi\Z45u¨P‰\'½w¯{ŠP\Ø]\èŒ.e$g\Ğ\äZ\ÕQ84Tš\Ğ\ZOfb86>õd™ƒÉ»\Z\ÎÁÈ¦—ô\Ó>¤\ÓH¼½ª™[­p_j‰\n1\0I\ØRGxŒ@±¬\î7ò‡H\\\\r\İ\í\È_óTOš»8ô‹ùˆúÿ\0Àö®\ã\ÃHdócˆù@\\•\âıv\æ\Ô\ÍqVe“¬†(\ÜÒ¤õ\'›ü÷«\ä\Êó4º16#…4\Ï\å\É¡BÈ¶±\ß{Û‘Lğ¸<4±„vf\"\Æ÷\Ú\ãÛ·µsOª\ïà²‚<\Èsh¡ˆG\Z…{’y\'½2“4\È\â5Ö¶ \î-s\Óz\È£\ãù`nXv<i\Ï\íZ8p?…‰D2´‚\â\á¬\Z\ì@½\Ç;šœ®®Â’\ÑD>\rñ²E—H?qCxC‰LLˆN¢›3Ÿ¦\Çqo‘½«R2„ji=­u \Ò\ßÖ”ePK†2yì¬†B‡.3–\Ö\î;VR¨\Şv\èu™eFIMC\Ópúye¶\Ãõ·\ïUl6°UÛ¯_Ö¬8\äeº-Ó±=u”\ä\âr\îÅ·(;\é_óJÓP©ñY3˜ô\Í9„1-\ÏESb¥h#B\ÛV\ç}\Å\Îõf1Œ\\\\+‘m-óÍ¯\ÍQ.(aUT€o¶®n\ßæ´ª:\nn_\\>]†—U¤s#rC_p-²ğ(\\Yÿ\0\İ)‘‹Ş‹~[ıV\ïOa\Ê\Ø‘4\Æ\Î¡\î>6ô¬\ÎgH¸˜°\Í¹YÁU?\Îa¾şÆxY\ni·œø‹*“Tm…R¶–”ó_ ö¦˜o”@\âfg‘a Û¥¹µ>§\Ö÷>\Û\n\rñk—UÁ½‰\äü\Ó$\Ò\îBòoÎ·bGªS\ï\Å\Ã\ÑW¿“¹ı\êT¸ü”¿ƒ#\âLfŒ\ß\ËÆ †Á\Ô\\•°\à\ì7ô\Îi\"<ˆ\ÑAµ—HN\ÛzZˆÿ\0PÁªy~J¤7\Ü\ßú\ÖzXñºpŞ¯5,¨\rô2›½\ÏE\"\Ç~\ÇÚ¯÷*½\n±´9Ìµ\á\â@Át¨\Ònµ·ÿ\0>õ›ğö]!\ÄÍŠHIGPÍ€¿\ç+{^öz\Õ\çY\\­‚\É!+º¹¦\Üş”¯â…‘’(\ÈU\"\Ö\ãHQ¾\ßj0“Š }\Ô,\Æ\å\Òbİ‚BŒ¤–ü¬,@©·õ¤y¦W?˜±›1v\00;|Ãš\İ6//\Üòu\Ïı¨6V$9¦\"1ÿ\0¦¢\×&\Ä\Æ\ÜSG«@p2™‡‡<¨\í\æ>\à[ö\éY\Ø$ER„Y\Ã¾\Û\Ö\ã\Ä0·–u\ê!ly»~\×\"—\ã|B\í3™ü¡tı\Üşµ\Ñ\Òêª¹2S\é»\í2c6t;ú‡\ïú\Ólt\ÖÇ±\Û÷ª!ÀÔ£]\Í\É7·;kR\á,«®\ÚMÍº\Õ\Ñ\Ù\"]\Ñ5‘b/Ö‹Y«0‰#’a›ı?ùñV«4d,«¤÷Suÿ\05.¢œ«f¡^®R\\69_u`E“\Ô\ÜB¤5\Ãé‰’Â“a%¯3<\ÑbB\Í`94l-„\ãñ©\Z–v\n£ÿ\0,;šA‰±1—\ÖP/©S½·\Zı\Ï\íC²>-	©¹MÀ\0üšu•`\Ñ—ˆ\ç\êÛ\Ö;znJ?“SgN\0\Ï	SP\Ú\â\äv\ëMòU’)\Û(7ü¥Oö;{U9†_M†KF\í¥®o§bÀ¤lG\éV\ç,hq\Ì\ÌQ}H\ÖúA\ä9â¹¦\ÛtY$<\Ëğ_ƒUÕ‡.Ã\Ï[ôPYnS!\ÄI1KFlÈ„‹’~¢W°\ì{×¹\ÂxuI&•q°;w7ş”F2I#tDmz\É\nGq¹¿m·©N_¤)¶-ec\íÁ±÷\éCÁ„ü4m$É¬Fû2ªƒ\é\ãƒkoRs&T\Ò³U½F\Û\í\ïD\Ã\â\İt\íKI+fw\ãFV/¸¹U<jBy£09¼s\\\Éf\n\Â\Âû\ç¸\ßö§x\èd\ÄB\ã\Ê„7[\ÖóIrÿ\0Æ°\â0š\×$ı õ]=¿zeÑ¹¡¼™–eÑ¥T\n€v±)D~%f\à\ì	ö¬\ë,ñ\â\Ò	F¯Vµ¹º‚°ûÖ›4ğ\ÆTH1H¶7F!^Û•u½ˆ<_\éş}Îii\âüI$cQO,\ë\Ğ\Ú.{=´şô\×4R$o:‡;:«p§ò›wŞ¸Á\æ2´;\Ä\ŞQ[X¡\ÒV\Ö7qj)Èš@\ÎòªFXˆÀ\Z›\Ë)$¿zN)»×³7K?\Ğ\Ë›úF$iPI\Ø_`*¶ò¼\Èñˆ\ÙdŒ:¦«©³\ÛW\Ïö¹©€\Ëd\ÃHl\Ë.³\é{iĞ «»\Üs·j\ë\Åx9e„¬r!pT€n\Ä^\Ç}\ízek\ÎE|]z=GlC´­Î²\×ôö·s\íGÅ—¬gS‘‡Ó¨¦ü\Ú\ä\ï·5œl\Ê8¤Mù}W;–\à“\ïş*¯õ\Â\ÄÀl7\äô¢2\ãF†\\\Ú0H(·\ì*V\Z\æ,ÅµÇ¹¿\Ö\ß\â¥?ÓşHa\á¬lQ¡“N§wf…ô©c¥µ…·¦«ŒÌ¦4U\Ú\Ä&Ú¯ü\Û\é°ÿ\0š•+šR|\ß\ä­*\rÌ dMI!f\ä`G[v\Úô¶h°«˜\âE’\ÚF¢M\îKZ÷\Ü\ï^Ô¦rhDc¼?\â±Á\İ]0Ì¡Ÿr\Äˆ>Ü‘DfvR)>\ÇC-Àa~ \î¸ıy¯jWlâ¯‚pn\ÍFW‹X¡M®Î¡˜òM\Å\í~Â…\ÂNŸˆ‘¿Ú¶l¤–GÍ‡\ïŞ¥J\à[e…^!qFŞ»9+bHı@¯3L£\nP©vŞ }›ŸŞ¥J´z’\ÆI¸¡nY•K\ä\r!U7\çv\Ü\îmŞ–®P&flğ&\İûoR¥t©;b4¨Uš\à\ÄA\"\Ş\çú\ÑYOÑ‰6a½®@6*U¯°’]\ÅÍœ²B\ï\îv¿ÚÀD¸…7\ÔXÅ¯Æ›qjò¥$ñL,\Ä\ÚAúI¡­¬H\Ë1B8 wù\éÁûT©P\ê\â¤R:c\\»0À$„9\Üj·\'\ã ö£°YJº+«t¸¡O\å\ÒnûW•+Ÿõ-3Œ©\Æ0\à \Öl¡M\Í\Ôp·oNpù„hz‡qsú÷©RŠ6\Ñó\ßfM.!°ˆ\Ç\Ô\Ê\ärøŸ\à<ş_«ú­Ê¢ÿ\0qR¥tI(\ÅP·–1ğô¦´’B3 ¹}½ºlG4?‹%–$lDO­]Õ…‡,^›T©S‚NJ\Âü0Y²*±\æ\Ü\í{ÿ\0\Å	4+ˆ˜0¢¯Õ¤z˜\Ü‹\r¯sñR¥Fİ‡Š\Ìó\njÌ €n7\ßkñ¾öª2¼tR\ÆÇ§\0[“j•+u1 \Æ*ƒ1p‰˜‰W¶À“¤û\ß4§&³\Æ$•œ\\\\\0w·¹\ßö¯jRK\í\åòdŠ1ra`!@Å›SX±7\ßUÇ¸\â”f¸£|4ze.ªzT\ß\ä\Ø[›ûWµ*“ÀÔ<YN.\ÃÖŸü›üWµ*Q\âˆsgÿ\Ù'),(163,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z!.%+!\Z&8&+/1555\Z$;@;4?.4514+$,44444444444644444444444444444444441444444444444444ÿÀ\0\0·\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0>\0\0\0\0\0!1AQa\"q‘2B¡±ÁğR\Ñr’\á#b‚ñ3S¢\Ò4Cÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0*\0\0\0\0\0\0\0\0!1A2Qa\"R±#Bq‘Áÿ\Ú\0\0\0?\0ó,5«zl€ \Ã1)’´z3û`\Õ\n\íVƒ\n£~ªc)]IB\êJÂ©	T¥´\Z`\à\'šB\èj¦†&)Oj‰uU •„—\Z\åeÂ¸C«¸|,Ô¸ºsKªR·O¡“.¤­Gaø>!\â[M\Ñ\Öòq\Ğû=Ù¶6)‡s{\È\ïxZ@ğV¸¾\Æ\0S)Z\Øı\æ72²_”õ¹]~Y¢p-\êŸ£\ÊjğLCDš~i>€\Ê\Í ÁF\Ç\Ñz\ŞJm2\Ü\â#)–j\r\ÌE¬¦­À(\â}Q%\ĞD1¤\Ç\ë\É/7“\Ó_ô\àR¶]…¤â½—s# é³€_5›t‹EÆ«dd›]1}‰q)HbÎ€ºW%KE’©½»\è\î”Ü£TN9F¨Gb®•\Å\×aºR»,[DjJ†­m‚\Ø\ÛFª6T\Ìn™8Ÿ¶*òşb^M—p\îº!\ÔA\n2\nĞŒ\Ô\Ùi‡h!K’8W¢Šd±t†±\ÊV…))¦ \Z\Zºœ\Z–U	\'\åü•\Õ\r‡¡¥‘\á .Rbs\İt4Ã”4ºÊ·ˆ‹#q ,\æ;.„¦1!…÷LyMcIº‘­’£/\Ğ9)Í”Spn;)Ù„p\Õ	{+²)@’\0“¤jJ<\á	0“`7%i¸\'e>õMbOş\êy¬ùó\Î5ß³N•õ\èvbK]R;\×‡p©<\ál\èai´\Ä1¶z„jHø[´G5ItXXe\Z5¿¤y#\ìÎ˜³}\Ö\Ï\Â\ÒPEä‚¸™<‡tşVq(ZDx¬k\İi\rn\Ím€ó\İCF3Iˆ;»OùF\ÓÁ\ÍG·\\¬y#\ÂÛ¨ªñZ¦A<š-?§’[Oİ¾\ÆO}J;ü#\Ì\Üå»¸†±³´N£Tƒ\Ü\Ğ^ˆ\Ì\Ø\Ğ\0\ç[\Â‰s\É.yw)´ X.\ájg†\rœ\Å\Ñ0\0ú˜VšuüQ|\Z\Ñ#\Şñ³3\Ç\ß<ùS\àÁÄŠŒkI¸?>\é\nôñ—‚\\ø‡6ji¤¹\ŞSkµ\Õi9\ÄÁd\Ø7)9£ót}\Ç\Úû)w\Õ./\Ç\àIÅ®ñB\Ğ«‹Pö­{Ít#”ù,…PA…\×ñ\ë\êNß³™\åGÒ­|Îœ\ÜD(Z\Òta:§Šù2sd•+’¡)Ğ»•\é¿c@]]p\êT\Ü\Òª³‡\È\â56F‰\èWµõRÉ•\\¬pnuO¢%°\Ü=[XÈ…\ÂT†ö\r£†šP¥\n:…¤N‰\nD;×«\ÙZ$I32Jl²zf5B½òQ8,£\Âpº¯6a™ºQW\Ä*ÀUT¨É’µ˜ÆŸó*\Ç0 }nºY‚d@\Ï.Kw+\Û\rc§\éj\ÎøB¶\áXnB°w¤\ßrˆôhLÿ\0\"Á‚\Şi\Z°PaÂ€=\ÙğC6aô)\ï\í\âZ<\Êüf¡ı?4?Y¼wù-¸F(/:è€÷\Û\É\\6‘²6\Ì<6(\\‰c	Ô´[«*Ø÷\rôû.“n\î›;¸1}8”¿¹+-¯Ÿ\ç’uF¹°L‡j÷ºœ\×)›\Ê\âbüÁñ\Ò}!b–5\ÏdUœnI=L•Ÿø>X>“I\È]\0‰kÍ†—k¼÷\Û\Ã@ğ^\Zr¶ù¶\Ô	\ÇP¡¾ı‘TúôK†¼™phıP;\İŠci6C›r;­L›\àu\è„<MùC`;\\Ó©3gH¸ |˜š¹¥\Î$8¸Œ»4o©·„z-*±©\Ò]\Â\ê»ôK\Âë±uGsA\Ê\İIs¬<wº¿\àôƒ©šò\âv»µ\Õcª},m\ë÷Gÿ\0ö³$\Ø\Ä4\0\Ó\Ô{\Î\Üu¾°ª[Z\Ù2\âß§\Ø6\r\ì\ê»3Cƒd7B\r\ìnˆÿ\0\ã±E\ÕKX\İ$\é`@“­\â\ÛB7†ğ\Z•sKH\Ì&l‘iê¬™§O¸úsª\r[š\Í[$6\ä\\\ïpŸŠ-W\'\Òÿ\0“>kŠZö\×÷)\ÙÁ0”\09ƒKš d‡ƒw	ğ‰±Ôªñİˆ{À\æ{—²¸ó½\î\"M\âó]Œ9Ö°xu„H™ı\Î\Å?\rQ\Íkˆk”–\ê3;r9Àh7•UŸm6\Ñ\Ú\í)Â¤\ÈnW\â|: \ÂBß¿\0´rUüO` \0s6f\ÃWõBÑ‡\Ï\äø×³6ò—Ñ‘~\r\Ô\Æaª¯\ÄT.\Õlƒšö\ŞKˆ4g0º\\Œ<@‘”bP„#°\Õ,­ 	\ÃbÎˆ¦b¦xƒ!uµ\n´´S{/¿ˆĞ•17„\Ì5\Â!˜K£I°^\ê(†¹u˜pı˜LH[cNÊº‹E•xö–¥O9ıGOw\Ø*¬o®ı\ÚÁ\ĞIõ*±\ïEJ\ä\ÖZ£­8¦GUy&\\d¨œøQ½\à(_XòT§a6H\êª#P®‘iP‚e\Z”ScQpT+…‰9¡\ZH­³mÁ\ëf¤Î\rô°ú+\nNº\ÌpD0·ôŸ‘¿\ÖVƒ\rˆ-\Îş=\ÈÇ«gsòÆšüT«	’T¯\0\í*¹\í?~‘²T«¸ZŞ£\åu•\ã~\Ğ\Î!ùN‘cdU,NV\äl¶ZFg\è&\Zt\Ónj­˜®‰¯Ç‘\î\Ç\Õ\\;—\Ğ‰W²2ö´^FS{E9\Äeµ\í7“¿\ÛT%g˜“~V·¯‘ôVœ9ši\0\Zxóş\é\Íq[ZH2†g\Ôgõ<Du°°\êT­Á0<9¯sŸ2]\İ\Ê “y’M¹ˆ‘\à\Za®\î¸:\çp9di\rw‰º›‰k\ÃLw¢r\å ˜D²)–Ş¶c¥U_:-jqG;.a‘\×h$‚Ü Œ\Ä:Àé¾†,UF;™\Öt‹C\Æ6ğB9×¾\Ú&‹›\ÙVO&²-0öXa\Ì\Ù\Ş\ì\Î.¼¶2\Î\àÁ\'åª‡ü\Ïsõo˜ª\Ô\×9¦;¦	\Ú5y6\n\ç\Ü\r\çMÀ\Ê\îõ)”\Ïò\Øf‡4\àZm¨™:øG$?\n\æ·+š¸¹®]”‹5ø~EOR€g¼\â^\"\0¼<€\åı\ác\ê¹\ã)ø®v@\ZøO]\Óu3:kLV\é\Òi\í\î:÷1{›\Ò\Ü\×\ïÑ–\Ú\ãuy“\'u®\í˜ÿ\0¦9f9÷f\ÚjOª\Ë®Ç‡\Ş$\Î?šÿ\0\Öh\ÌR\Ñb•\ÔÓ˜Õ¬Ë±Á5\ÔTH\Ç+(•KJ´\ÃbÁB:Œ¡‹tW\è¯f…¯EÒ©D³\Õ$W\Å$/ñƒŸ\Í%9\"q\Ì]`\ÒO‚%¼*±‰\ço’\Ô\Ó\ÈÆ\Æ\É\ÇUƒ\Ü$\Ìs:/>ü\éG¡œ\Ô\Ì\Í.\rS|£\ÎQ\Ôx>\'™\ä²e\':r\Ş.Rk£tŸ\'±“‚\0YÀ)^\áù\à£Ÿi=\×À\ê­ğ˜Z•q¦9›U.ˆa\Ê\\\í\ãek&T¶ı\écoH \Äğ3|¯5Z%¦…¯có\rJ‹‰p\Ò\î\ëÀiNÇ¯»\Ğ<yo³=Â«\å|l\ëy\ì´\rz©£\Ã\073€£MOUY\Ü\ÛÜ›|S.h²etóXª\ÆTDR}\àş\Ë3ƒm ²òu)h5“{FƒYú¦ˆ›IôFS\Ã\ço\Ê\à\Şz|]P\é/b©\è®&Uõ€:j™W…fh-\È\Ò\rúøÆŸœ\Ô\Õ8mF¶e¦5‡	ô)V\Õt˜·Rıkº\Ù5\Î@\n\ä6ªš•W¸\ÃAq\è\İ\'\é\×ÁoHË¬n\å;¨ó.k\à\Ê\Ğ¤\0\ænº\ê°34\Èxƒ¾kO¥ö”Ç†¥mŠw-\é2Z„\İÑ¼\0\âMÀ\0‘\Ê_’&›İ–\Íh±{ló¥šI›ı\Ğô0Ù„œ\Ù\Z$Àt4›y\ì\Z§ef±„2fL¼~ú&\Ë\ã\Û\èE$ú]¥Hó\Ú\é\ĞÉ±\Ó,nz\ŞŞˆlN$˜\å18‘±3\Ğt@:¢EW7úß¶g»PşóGXb¨²«\î(\àê¸†\Ã?§\Şÿ\0\ÊPN{\Z½Œ¸\âHóşWò\Ì\Úe\"B\æUg†hš†½¦•Fg-\ÂsQ¢€§œ\æ‰R)\Ë#¦\ä\ç\ÓNv\Í\Õ@|‘\\YXüD3ğ¤-(¦Òü;\ÊrE­™,\ê’\Ôÿ\0\Î_?î’­¢öÍ®‚¼Ä±\ã@}\àn\à$—÷ù4`>UGR£°\Îÿ\0*³\\re³\Ôh‚~6³\Ü]\í\'“œ=\06\\iËŠgM×\é\í3YG\0\Æ!£]5\ä©ñ\"€ªK›¿èŒ õ;”g+ó2I#¼^\ã[”Ê´Z	qahAU\çM%(‘…\Ëm°üg{Àed`\Ş\Ã\ÅTSÁ\ã\'1ôh<\\l´†›\çcòiy½a\İ\0¸\ÉĞ·ì¬«\ÔcX\Ö1­‹±ÀÉ‰p\ZH\ï\âU¹woDV¢¸\ÊÙ˜¥N“.Z_—èh÷¹€.2#Ş¿—-B7‹º%\Ç6h³{­69@yê³¸œAq|VN/z\Ş\Íp¹ \\][ª÷8\Ê(µp\Ó f‹E8Z\'I\Z•hNö©õ(\ÚP\îiW\Ó\Z©0–U\'\â*Ó‡\×\ÊfI•F\Änğe\ÎÖŠ¤k©\â\ZD\êŠk§OB²\ÔñhQ˜n!\Õs¯/@8Ù ‘Z\Óy2\Ğg¡”b†g9¶Ÿx¹³\Z\èH¸ŸˆŸ<|\î§n$B¸Ë’:kh\Ïxñ(.-.lAq`\Â\"\\- 9(©²“ƒ‰q$\Ä\Ã[~ƒmùl%CW\Z\Ùîµ§PK„\Û\í\Ï\ÑÚ€`O;\ÛÀ-›’]`\'\r\"\ÔW-i¦\ç0yp°7\0‹Ÿ¢¯¯ˆ\r\Şf&9tCU\ÄN¤”%ZÒ—\İkc£»uU\rZù\Z_¸\Ï\Â=S)•MÆ±\r\ÊCól\\zôû­>>u¡>fe‹üün{Á9µ\Üó\'UBN\åZ\ä\Ê7\Ãv]\Ù\Ñ\æk~\ÈğÔÛóW8~R³s85…š•2\Ø]z5<V@)­°—£Ï›„,´!ê¸‚µ¸ü(eVş ”µ-Ñ¡´¤Î¿!@+MÚ—hiCp¦Jbé‰¹\Ú\rmgs)\í¬\îg\Õ\Ú\Éı;\rö\î\æRB{T•\él\ÖP7>Gd‰-C\á\Õ5´ˆvSby\\ü•\ï\â\ìu\Ù`øCGºOŒ*_n\"\Æ\æ\İc\ÅyŒ²¦µ/hõ0\ê–\éh\ì\Ó\0SûõDa]Z\ÄO™\Øğ\è«ó\ÍÇ)±œNœ{Á‰pr’K§OøSĞ©R±qi,h!\Îy‹8\ÚIs…ü6‚õR\ËK­ >fE\ã\ì£~\î\ÉIŒyñ“)$Ø¸’L\Ì˜Å€Zp¾^öÿ\0@\ÒKÖ—\ìg\Â5‡(©\çR¼É¼•Vú.!^3‚Uv\íf\ç¨[&.\Â9ï²ƒŠp¦°\0\Â\ç¸_\İ\Ê¦^\î­\Ô\ëı“*\Z\ïZE\ÆY\êw²…\É\Ä\Ø6\Ğ^\åJ\êÙ§\È)°­ikš\æ\0òe.ˆ6\\\r ó\Øô\ÒOcª´¶BÁ#ód;\Û\nÆ\é\Ê!¬÷\\¶E¶\ÒM\0\Ï\ÍĞ­¦E]€½¼’kÔµ¡-M]š\n§T… ¨€c\áL‚¤jf \Ô\ãN¥U\nŠOk¥¼hl²ş!#ˆU¾Ô®\ç*¾’ \Ç\ÕMÎ««c˜\Ïy\×\ä.²\Ä\İR£XÖ†´‘ —\î~É³\ã\Ó\ï]rù1o²n!te§sñ·A\Ìşj¡\ÃqPş\ãÀqo0PüF©§‰¨\Ã\î‡\Ün$??šÀdcj³\İ1›•ôwš\êb\Å1:Gò3\ÖZm‡b’s~|˜ ®\ê¿	ÅœÁ•\Â[ôş\İ˜Š\ÃVhuLÖ„>Ñ¡\à=\Æ\ç[®\Ä\Ú\æA7…‰¡Dœ0pñK„\â\È$§mS5\Î4\å\Z\ê÷*+P4\Ïe¸\Ï(¹ôS\Ç\ÙQ\Å%X\à)†a\Ü\ã©<NŠ®›K\İn¬qn$4o\Ì\îQ\Æ\Û\ìNG\Åh®-\\„PÂ¸\ì¤nü‡ª\ÑÑ“°…$ø{ú~y$«h–\Ø\nxö`^m$	\Ön\ë|÷N	\ÄXøªÚ¸‡1\Ì{Oºd¸ù«6°Ô‡3¼\çóm ›\È\é¯%\ç\î>\'­\ßòhqª\Ó\ÙVt\ÕWT¤ü\Ù]#Q\é{F¾Jÿ\0\Â\Ú\Êa\Ï2÷wôƒ{\ßX¼ùs”\ÔÌ­¶^÷\Ò\"\á¬9¦%\ÆÀ,$ştWo~\"^V5“\rœ¢y\ÛO¼\Õ‹˜{0\"ó\Ô~~ˆŠT\Ü]£š]¤’\Z,e\ÒôEš}|‹¸\ßl5øJ\ïx»¯«²9\ÍøH\ÚıB;‡±´ó\0÷\Û3\ä\å;\Ô~\æf\Ñ>vpª®’\ZjTh÷\Üú™X\Û!„œ\Ş4\Øh/¬\Â\'\Û¶e¬c!\Òu/s„Ì™[e\Ì\Îı¿Ù¹Uk\ãôş\Çb\Ùk\Ø38Œ\äL2ò\ã§z\Ó)W\à­csXpó“6h\0†Ä˜ƒ2fÓ©ƒ\È\écm{\Î/&ú¡£\Şh\çq\n…ğ\êpûß\é/É–\âò`ò\ÑTpk¿a\ÕZ}z!§Y¢˜¤\ì3\ä’C»\Ü/›)‘m\Ì²§Ç€!²d\\e™1\0k©’o\ÍhkcÀX\ç\æ$Kr³)\rÙY32haR\Ô\É-˜½\Ìt$ZNi¢y!\Ê\×I\rÃ´ù2£yü\Ş>\Ê\'HÇ´I·”|\ï\Zşh=w‚ó£o\ât\ÌıRç·£_$–\Ê\\Ub×¸\rÿ\0•\Æñ5j\ï.$MÏÊŒ­\Ê%û9o\Ê\É-\é–\â#ôŸ’p\â-ı\'\äª\Ò\nşŒü\ìß’\Å\ÜP\ì\ßR‡«Œ{¾(,‡]„K¯HMyo\Û#\İ^vg\r³zAù\Ï%H\ÖË²xluS\à\à\'\ÇU-õ¡1¾\Û(8\ëÁ\Ä\Õ?\ë@\Ù\\vz«jR}\é<\ìVk\\=\Î\ê%Ş¦B+ƒb‹*°\ìL5¥}¦\'÷0g\Ñ\Ê\âÓ¨$+.=\Ä@\Z+N\Ò\Ñ\É\\¾\Çè‚¡r-¸Dô\Ñ³\Ñx3@¤\Ğ\álº!q)\ÌÏ‹o\Ù† 1¼\à#°\Ï\ÍnK3”Íª´g«ğú¦Á¥E†\ì£\Şe\ç+V\ê&2³}¦\ãY²a\ï»Sú[û‘¬b\ë+Ñ™\â•)\Ò~JWy\ÃIı#÷QRÄ‚Ş½Sr7’C\ßÕF[\ÉÈ‘µH\Ü)góú(†\ê»\ì\Å²ojşg\åû$‡\È\îi)¯\Ñ[Ju\äÊ›Q\ÒE\É\0x˜UoÁøF«Yxph/l÷Ü\æÆ³b¯øVI\áÀ9\ï»œ\Èi\è,\'q+‹“$Krÿ\0Á\ég#©\ßø\Ã0n\Ê\Ò÷’,\è¿xÁ0A20n9ø•\Ä÷E¹sùıQ¸›s\è üÑ¢¦y\×M€™\×\Ò*\ï•ÿ\0€¦ª_&ŒZı\á\Ş\Ú?=Q˜LQ¸\ÈÁ?ºƒŒp²Ê§)\0\\€LGN[Ğ´ª-zZM:¹4,\à\Õ^L71\r’l[k‡|Õ&™ô)4\ï\Ô\rş£-“\Ì>Š“\ÄÁ•¯,Í‰\æñ\åqqŸ‰¿#c®¼ı\Å\Ä÷\ßşr\â·\ÓÖ‹n\'\Å \Å\ÄDZÎ°\ë‚w\Ö\ë5ˆÄ¾ğ‚n\ZL9’eÇ©$©_@9Á1-\éh`ƒa\Î/ºm:lˆ{§ ³¶¹9n,w\ß\Öòetı\é%+¥°!™\Ä©\r\Ï\ç\ÙMQ\ígu‡4\Ş\0Ÿx´‹»–bM‰eLú\r!€m ¹\èW06KŒV.ùX_s\Ë\É¥®‡)o\Ø!dò\É;s2¨8\Î+1oº\İzg\×\æ¬8§\0em‡)¹ÏªÎ¸\îµøø\Şù3?““S\Å+]%r\Ôs‘\ÈI8ˆW²\Ú8Ğ­j\ëZ£`¤?…/¨ÖrO&O\çE¯\í#\Æ(p\0‹\Ës4÷Oò²‹ú);;Â›F™¯TI‘\r&\Ï}\Ë#\áo¼\ã\Ñex\Î?Ú¿4’\Ñf\ÌÉ¼—™\İ\Æşƒeq<«ò\×\ÑR3‡\áU\íkZuc@™†k3Œó—xW\'´…Œ,¤Æ´h\ï¡şŒ»k*4\Õc’\ÆC¼N\ß/š‡³3\Ú:…^÷I&I¹=U·gš¨\ä\Ñ*>‘\'ºFú‹_e¡º­Á36º~YZ\â^)°¹\Æ\0JZFšeh8\Ãp\ì1w›5½zô^~\ê\Å\Î.q—8\É=W8\Ç5j9\ä\ÛFC÷AÒ¨˜Œõ[-WZøB±\êbQ¦(!¯]2…awÛ£\ÙD\ÒRPûT•‡Æ±Q\09\à29\İ :\Û\ÅZğ\Ş)Eù\Í`\ênn¹\\\è- ‰Ÿ0²\ÎiÔµ\"È·qGœ¤†—6\Åùe\îlAk\Ü}\á\çnAa¼3^‘¿j‡\ì\Ø\â^e@\æ´»K´Og\ãµ*\Õe8\rhtI\Ş`tX\Ê\\E¤e&9O\ÑZğN\"\Ö=€5\Å\Íp$\ê üQ\Ò\Ëø“®\ÖÙ¥yUM-ôi¸ı—{\Ó?\é:\ÉòY\ê¯\ry\0ÈµÆš^:+9‹q!Á\ìpp \å\"D™&\Ä\ë\Â\Ï\â«6À\\÷Y±\Ç­|Y6½‡2ª‘•H\Ñ\ÄxWJ¢µP\Ô\äY²»·q²\â? ú*\áU5õ\ãt6\Ğ}LL\rU7\â \ro\É	\â[7UN÷—+fı\Ôb\Ï\ä\Ìõ>\É_X¸\ÉJTmOh[ZK\Ñ\Î\ä\Û\Û\Zû\'0$\àºôR]Ê¸àºŸ‡Ã½\î\ÊÆ—ŸS\È!\rµ¡ -g8\0hö\Õû­l£wŸ–§§8o\r§‡‡¼\æy¸7\Ê\Ûh\ŞÌ£\Çq\ÕÏ”\å¦\É$†tcO\Ä÷XN\Ó>\ÇoBjôº!\í\'5X\Øk\Z2›7l\ï$I\'R9\0³•¤ºc\Ê\ß¥h\çd·TZ›•N\æ®5ŠøÈŠŸ²xc.1\ïXxD\Ê9˜^ƒ\Ù\Ş\Z\Ëú¥\ä_Œ?4\\`°§Qÿ\0+\Û^.rŠ!\Òn]4¯‹öTœùƒ@\æO\äŸ¼‹Š\ÏQÏ›o¡”ôˆ“šõ	\ÙQ\n\Ğe¢s h”ctV€gSe?\"AˆŠ9)\'û5\Õd;€\ÇS\0µô\ØöŸ¶\Öv­(³ÀpÕ‡ù5\ÇşŠƒ3OL\Â\àõĞ¬ç‚š(·xYµ£VöI\Äxz2^\ÂZ>6w™\ê4óAR\Ä9³úuW\Ø>?Y°s“h9 ‚9~j\\EJg\Ó\rqÔ²\Ó\è£h¤€8©\ß\×X\ÍÀşa»v#ª+Š\Òk,=\Ç\Í\Ş&ñ;‹‚\"°\Üóÿ\0\Ø-@>\nÚ—f\ØüSÆ™e²¹º‚\Ùq°31$ª„\ŞÑ§z\Æô\Ìû+)™ˆV˜¾\ÇT\r†\çlC\ÚZzSù\ÌT¿³XÁ­ùAû¥<	›WúLh 1\Ç:\ÃDH\àŸûôNo\ÄOıÿ\0IW8\æEß•w×¤U†§µªİŸÄ(¿úQ4û/Š?ş.ó÷Ll\ÎQ5©\á«H\Î\Ç\â~ \ÆnxR\Í\Ò\â[:\Ã\ZOÌ˜C\Ûø/”¯“+\n|6\ï0\Æ9\Ş\êvW¯ƒ¢\ÜÌ¦j™‰¨tÿ\0h\ÕEŠ\í\Ì\Öòkr¶<5E ]¯øNÏ€G¶{[ş†¸OvL\î+Nˆ,¦À\ĞF’]±2nV\Ä\\\çL©0\ì\ÎcR}|I\Ø+RXM\\m\\C\ËdÅ³8\ÜÆ~C‰¬[şXÆ’z¹Û¹\ÛrôVø(c²W‹z~n„ã´š1y…¢!.Ì·{\éo¨´˜A„M\Âz\Ğ\ÃLÊR6$j™Z·{¦\êÛ‰\å,¦XA¨\ç\ÕS½4ˆ£i³¼/™\à¢2VûL´7h\Ùg8\Ëmp$ô\'o\ÎKT÷†5\ÎvŸö\İg\åÉº6)\ã)\Ü\ã\ïw»ş\ç	w£cú\Ö5Zñ¼I}C;I?\Ì\ã™Ş–oûUaE+­Šª\ïCCa=u­DSb-l\ÇRb2\\§L#\èR„JAl\ØBp¦\ÊM ¬ /f’7\Ù$¡s]¹’I \Ğt\ĞH\İu%C¿ˆ\æ¦f)\Ã\İq	$‚ˆ˜M>)P|e\Ş=\\hò’Jƒ\'ohñ¬ú”ñ\Ú|O\ë?\Ô\ï\İ$”e=¥\Ä\Üwõ8ıJ§h+›”’TP9\ã5¶yù!Ÿˆ{µrI\"\Ñ€1ù÷M¤\Şğ’’JY\àøfa˜÷F\ÚIô\Ñv›E*’t&,’H\Ğ\ÑÒ‡G\Ä}ª¾\ÓT#+#¬şx¤’r\Ìú.‹€	$ˆ\n”ÁV<%\ÔÈq:#\ï‰%fû\Ì\Ú6İŸd	\'_^E?i±9)o˜’|)÷©\æWH±\Zòı\ÌóI$\É$’y“r}S]IifO\nr\æ\ÙOBšI)$ –6\è\Ù\Ù$‘‚‰˜\íRIB\Îf)$’„?ÿ\Ù'),(225,_binary 'ÿ\Øÿ\à\0JFIF\0\0\0\0\0\0ÿ\Û\0„\0		\n\n	\r\r\r \"\" $(4,$&1\'-=-157:::#+?D?8C49:7\n\n\n\r\r\Z\Z7%%77777777777777777777777777777777777777777777777777ÿÀ\0\0\×\0\×\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0B\0\0\0\0\0\0!1AQqa\"2BR‘¡±Á#3br‚’\Ñ\á4C\Âğñ$Ss¢²ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\06\0	\0\0\0\0!1AQa‘\"qÁ\Ñ\áğ2B¡±Rñ3S\Âÿ\Ú\0\0\0?\0\ëH\0€ \0€ \0pJó)dvğ\Z<P›F\ßy\ÄôØ€¸)¢\îz”B(\Æ\è\Ûò@{İ³\ào\É\áŠ3¾6ü\Zh»…m\Ôc\İyB\Ó\é¥o»¬<wo@\0@\0@\0@­iq\ÃA\'Á&*N2 €’\Æ5ƒ\rh\n\0@\0@¾6H=v‚€‹-!c9Š1‚€ \0€ \0€ \ì0:]§cy \'Gch\Â¤\0@\0@\0@\Ä\ÉG¬6ğ<BĞº#·ky - \0€ \0€ $\Ó\Ó\ëaòn\à9 & \0€ \0€ \0€ \0€Á¢œ\Ç\ë3k>\È\0€ \0€“K·®ñ\êğ\Ğ\0@\0@\0@\0@~ô\n˜;£¬\ß`ıP\0@i\â\ï_·\Ù\Ğˆ\0€ \0€ \0€ \0€ \0€ <p8d:h\ÌO\Õ;¸\0€ô\â\0%‘Š1G™æ€­\0@A¾×º\Ùg«®dbGA{ZN>+%¹\"N%\"øTŞš½\r2\Ù\ÚS\\ğË­£Où´\î\Ö\ÇVŸÈ•‹÷\"ÿ\0#Ñ¹%­\×ÁıM\â\ß_Kr¦mM\ìšnsOG‘ğS#%%ª9Ë¨²‰¸Y%dj\"]nT¶š++dÔ‰Ÿ7\0%c9¨-Y¿Ì›u­[4ª[\î–i#\ä–\ÇOOGF\×j¶IFrzrz\rŠ\"¶\ëxÁh‹û0vn\nQÉ“”û—\çö\ÉN‡´\nf—Šš\n¬m\Ô\0dÿ\0\êßº\ËL•\Ü\Í;ûÇ¦\ì£ù\ïeı\Ó3W]ø]\ê›Ğ«Ãµ\Â\Z\çrÁ\Ú-\àó^Õ‘¬·&´f¼\í\ÙU\Û\ãK~\Ï\ß\å\Üm\êQFk\ÚM¥\Ô\Ñ?3Õ–\ä@ÃŒn<\Õhºø\×Áó-6~Ê»7\Ú\\#\ßô\ï5\èo\Zoy\íº†:Xµ®,gW½@Z™ı+B\ÒX{Ù¶nOó»—™q\×-8³ú\áEu8\ÚıF‚@ş\r£ùJ÷\"dµ1X\Û+ÙªnñûıM—G4’ƒH .¥qd\ì¤ş\Ó||GˆR*º6.FvÎ»\nZOŠ|ŸC2¶N‘_\è\ì‚j¢]#ò\"…¾\Ó\Ï\ä<V«mkVMÁÀ·2{µò\êú#O\Ñ\İ5¹\Üôš\né”“—3¹c}ŸTu·“‘\Ón\å¬™\ÎÄŸ\"û;b\ã\ã\á\Êp\Õ\Éuø÷O9@€pwo@[¨‹½\ÚB€ 	TQ\ä™\r(I\0%‰´i-¦ñ;à «k\åf}G\Ò\à8·;\ÇE®BoH²nN\Î\ÉÅŠ•±\Ñ?\Î=\Æ]l!}1-n‹]5¸\Ó<¤`}V«ÿ\0\ë‘?e¦ój\Óü‘Ä•9ôc-£7\Ù\ì\Ïs yx‡¾\Ş}G¶›]r×¡_´p!›V\ëıK“ü\èvºy£©‚9\àx|R4=ˆ;AVé¦µG\Ï\'	BN2Z4s}2’[\îšRY…°D\æ³\âp\Ösº\ê\ì\İ@½».Uô:Í•\á\ì\é\å\é\í=	y“{R¿Ë¢:1KGdZ—w=¿\ä\Æ—ø\îyà§¤¢´G)e’²nsz¶j½’X¨4‚–º\áv¹\×\É[Úc+\ä‰Ñ·TrZ\àNI#$\ã\Õ\ê½02\ZE-5\æ\ÓU_MQ\é3\Ú+\Í\ë\ZFg\r-q-\ØH.#ˆ\'Š‡—»¿\Õ\'£¹RV¼wúdµø¯ª7\Ë%\ë\Ò4F;µA\Ött\ït¾.fC¾e«uvkVû+2ğ»<\ç­iñ\åıšgöÁ{ºV^®€L\è\ä\È\Ú§i8ğÀñğ\n.4;I9È¾\Ûy>©L1h\àšş9=M{¶]-¸\Û\ì45\Ó\ÒÒ±¦n\éå®™\î\Z\Ø${ ³™9\à¬@\Ù,Ö‹UƒB\ã\Ò\Z;\ÕHªm œ\Ô>±ÎŠW\ã=ÙŒR	õqnG;P.N§¦½\è\æ’\Ûc\îc¹–	˜İ€‰vŸ;o‹APíŠ®\Ø\Íu:<e•ƒv=œwV«\áùüYo’G±€¹\Äğz˜ø\ìS“Isg¾\İe½]&®”œ<\â&qƒpÿ\0|IT\ÖX\ì–ñôœ,H\âPª\Ç\Åõ-Z\ë?¹\Ò\Öp‚V¼ôo\Ó+KvI›2©\í\è}\é\é®hsNZFAU\Ùó´\à\ÍwLô‘–*\È\×W\Ì1\İQñ‘\È}Oš\Ñ}İœxs-vV\Îy–û_¡sú\Z„Ş¦ \ÒH\İ<\Ïtu¯\î\ç/9\Ös½—ı	Pq\íq³S¨\Úø0»\r¨-8¯ræ¼Ä­NY¤º\Ã\Ù\İe\0ß¹“\Ümo €\Äi•K©4^\ã+«ŒZ€ò.!¿š\Õ{İ­²~Ë©[›\\_~¾\\N+†VK\İŒ:\Ì{NO0UBmqG\Ñ%\Î.2Z¦t-\í\rº¬§¾°µÛ½*1y£wQò\nuY}&r™Ş5¬ñŸ\çòRnŸ_(&\Ñw\ÅGYÏª{\ZÁÃ½P\à\âvxy­™6G³\Ñ>dm‹…tsT¬ƒ[ºó^\Z#—*Ã¶Ÿ\Ù}\Ğ\Ô\Û&·JrúG~gg‘\Ï\Ì+,I\ë\Ş\ã‹ô‹Wzº<¥ı¯±‡¾‘i\í2\nÉ½X¤’95\à\Ş\ìŸ,ª\Ïc!I“ğ×¬\ìiWkU\ä÷Œÿ\0iz%.–Xã†VG[K/{xp\×\ì ´\ç\Ì`q\ç‡³M.¯\Ñ\İf1m-2\Ë4b0:‚r:€\ß.ÖŠm\Ğhl\r³VVN\'¨x\É$\Èjµ£¢‰—4¡»\Şt\ã\Êy.Ş‘O\Íğ7=³>-	e²`Y$ôòkƒ\î™2qå¬¶U^”\î¾\â&nb–\ÑwÇ’kO†ŸC\\ì¾½´µUÖŠ¯\Ñ\Î\çëµ§‹\Ûê½½FÈ¨ø’Ñ¸2\Û\Ò*†L8\ÇM>Šf3µNÏ®w{³¯v62¡òF\Ö\ÏM¬\Zò\æŒ4‡f27qÊr†§£ı”\é\rÎ­‚\çMøe vd–G4¼:\íñ8w :^’6\n»ş\èõ¼\rZ9,»{¦0\å\æ9¨—=û#\ï:\r›‡~Lù5º¼uüş\ÌÎŸUšM­-ö¦\r„\0ı2¶d\Ëv¶C\Ø\Ôö¹°O§/¹\Æ\ÕIô€\İ\íı IE£ñQŠWI];¶J÷zš£`\'‰8\áÇš›½\Øi§š»\ÑõnS³{H7®}\İÆYU=mL•5rºY¤9sİ¼ÿ\0¾J$¤\äõgCUP¦\n­,‡º2Ã‡4\ë\âš\èfÒ’ÑŸB0—1¤\ï!^,|\ËuQ÷¸\r\ãhê‡†8Œ /R·Zføm@d]3¥uf‹\Ü!`%\Â>ğ\ÇT‡~KUñŞ­¢~ËµU›\\Ÿ~|(©Ï£ˆP\ã\Ùgyÿ\0\è*5W\è®\Ö\ë¬\Ü~j^»\ï\Üsş‘\é\ê±×÷É›Æ•h\Õ>‘Rµ¯sQ{©€\Î3¼\Ä)—R­^\'7³¶•˜6j–±|\×\çS]¤¬\Ò\í`¦«·¥#62HIs€\ê~c\ÍhR¾®\rj‹Ki\Ùy\Ï~»;9>iòúy?€v›]\îf\İh²ˆ«H\ÚÚ™6³Ö^)\ë3“İŒxø\\Zk\í¯»Xx.$\Ë&†\Ìë€»i-H¬­\ÈscX\Ò7g8\0\0+*ñ\ŞöıVh\Ë\ÛUz¾wa\ß\×ñõ\ênJYBi\Ú[¡Ï¸U‹QO^.ê‡‘¹À\Îû¨·c\ï=\ès/¶n\ØTC°\È[\Ğş¾Q‡›K4£G\Ã\"½\Ğ\Ã&rù0\Òüo:\Í$§}\Õğš\'Cel\ì\İe6¼;¼øÿ\0$³¤zYvg£\ÛlN£sö\åk°\Ñ\Ì\0×¢Ë¶º|#\r?ñ\Û3\ï\İv÷‚\Ó\å¯\Ë\ŞgôWF\ã±\Å$\Ó\Êj.g\Û|p3\Ã\ïö\ßM=š\Õñe^\Ñ\Ú2Ë’ŒV\ì#\É\î\ÔZã£‘–û-ªawL8}ğµ\åÿ\0\ÖLôu¯\\zÿ\0‹ù©V¸@\Û%¸^(©\Z3\Ş\Ì\Ğw9w\ĞqŞšDlË•8ó±ôO\íü\á]3\\\î\æ{8‘\Ñ*…»\ï$¤\0ŒŒ¡\Å4º\È\ë\âH\Z\Ó\è²\æJwp\Õø|·|¹ª‹\ê\ì\ç\à}e\ç,\Ìu\'ú—õø˜U¤²\0€êšÙŸAl’º¡…³V`µ¤m\ß<“\Ó\n\Ï½\Ø\ï>§·óU÷ª õPşúı\r\ÅJ(B\él–Ğªk€9†¡#\âicr<Á!U\Û-\Ë÷\ë\n•“²cWzk\ã«\Óù:\Û%ñ6V=¥\ÍvvUšiœ3‹MÅ®(w\Ñ\İgó\Õ\îK¸¨8;\Ù ô^˜µ¡\Ê;R­\Ö\Ó)`\0ø9\ÛO\ÓUVfKY\é\ÜvşS¹Œ\ìÿ\0\'ü.S¨\Ğ\ëz>¿µ\İ7=p¬£\Éeºv’Ó½—×¦²\rò\Û\Ş\ÕSA)À™˜Ç²\á´\"\Â\È)\ÅÅ’12%|mO\Æp\ê\ÊI\èj¥¥«Œ\Ç<N\Õ{§‡Š§”\\^ŒúE7B\êÕ•½S,¬M¡\0@t\Ì,o’óP\Â\ZZc¦\Ä\ï\Èy©ø•~ör\ç\'¦,‹ù/Ÿ‘\Ñ\ã•\í\Ä\ìw\Ä\Ü|¿\å&Œb\âI@^@\Ûõ–’û@\êJ¶ŸŠ9\íF\îak²¸Ø´d¼<\Ëq-\í+ø®ôr[\æŒ\\\ì²;¿\ÒÓf¢&’\Â<~?ª¬²‰Áñ\äw8{S-{/Iw>s	®Ã¹\Íù­%–Œ•ø}o¢¾¨\Ñ\Ô\nvcZS\r8z¬·%¦ºp#ú\Í;\ê½õ¼úk\Ä\Ú;<µY\îUu|†J¸N´t¯c‡\ÅûX\å÷Rqk„ŸµÌ¦Û¹YTA*–‘|\ß_w\ÕU‘\Å®·jE?p¨d,÷A\Ú\\y¼¬\'8Ák&H\ÇÅ»&{•GVh—n\Ò\'{œ\ËEcg	j6¸ÿ\0\Ø>eCcı¨\éq½ŠZ\ß=|\×\ìiw+…UÎ­\Õu\Ò÷“8\0]ª°n\Ø9\Í\Í\ë#¡\ÇÇ¯µ]KDGq/\0<—°d\ç\ÃrIrE\ZŒø[ò^he«*a,\Ú\Â[û§b\Ò|\Ï^\ç=\Å\Ïqsò\ã’W¡$–ˆ\Ø\èt\æıI€ú˜\êX=\Ù\ãv\à­ñÊ²>%=\Û\n\ÎQ\İ÷?®¦\Ûd\í\n†±\í†\ç¢\ìkkF|÷=*Uyq—	p(ó=¾•½K\ß^O\ïùÀ\Ü\Ú\à\æ‡4‚\È#Š–s\ï‡3O\í\Z;  \ÜX}<‚\Ún\è\âGuı‘\ã\åµE\ÉU\î\ë.eöÂ–c·v—\ìu×—û÷G9³Z+/UFš|a{µ\0|\Õ}u\ÊÇ¤N·/2¬Ho\Úør2\ÃA4„»‰ñ3³u·\Õm\î ÿ\0\Ï`\éúŸ“3¶>\Î^&l×¹\ãtm\Û\èğuº»fÎŸ5¾¼>:Ì¬\Ìô‰8¸\ãG\âş‡BŒŠ6\ÇC\ĞZÑ€\0\à\åÀåœœ¯™R;ı\Éß’E8\Äè€¸€ A\Ú\Â6s\Õ^hŒ·¥\ËRŠ\ÚXk©&¥©n´30±\ãÀ¤¢¤´fUY*¦¬‡¸œb÷h¯Ñ‹£2ùªıjj¦\ì\Öşü\Ç\äªl®T\Èú]F‡\Ã\ßÎ\Ï\ælöş\Ò^\Ê7²\áE\ŞTµ‡RHˆ\ry\á¬\ï,ôR#˜ôö—ÿ\0FÓ±:§¤|y¯wy¤Ü®WJ·\Õ\×Jd™\ŞA£‰9\ÊoVtXø\ÕcV«©h¿9‘–ğ€ \0€ õ£K®Ö‹s¨i_£\Ï\èÌ­\Ö1MÛ»®p·\Ã\"p\ê*²¶>.Mİ¬ø>ºu÷‘©\í÷½#®26*Š™¤ö§”À<]¸\ä*[.ótò0ğ*\İ\ÕE.‹Ÿ‘\ÕtWG`\Ñ\ê]\Ş\ÔËƒ<\Øö\09ÁY\ÓR®:u8£´\'›nó\á\É~u3ki^\0@E¹ÿ\0ƒy\äG\İ~Ô³÷B´\0@jªš\n¸]\rT1\Í½¦H\Ğ\à|Šñ¤ÖŒ\ÎN¹oA\èü9¦¬¡ƒH\'¥¶\ÓG4\à1ÁƒcŸŒ“õ\ÉUdn©\éw\Û\İ<Ue\Ò\ÕËÀÁ-¡j\ßFŸV¦=H]I\È\Ï#\Én[ñ\Ö/q]v«İ»|tƒ\å.Ÿ\âX €A\È+I`škTz‡¡\0@\ëªE-3¤\Æ^}V7\âq\ÜÊ«ß–„<ì¥‹KŸ7\É.öù\"\ìZı\Ó;\Üwš£[Wvx¬e¦¼9*\ß\ì\×iú´\ã§yX$ZH#h \íbf\ÒkFw\rº~1b¥¬që›«.8<l?\×\Í\\\Ó=ø&|\ãhbú®L\ê\\º{Ÿ#*¶‚\0€ -\Ïü_p€»Ls: . \0€ \İ%3\İ+fqÉ’¢G|\ÜJ¤›\ÖMŸNÅ‚…Š\è—ôFX›\ÏÖ½¥¯hsHÁl+\Ô\Úz£\Â3‹Œ–©=\Z¢ˆ—Pò4\ï;¿tğ\è¤v³…œÔ¨õ\\Œ\'®\'µğü¾\æVË1:“9\ĞIğL5~»–/|\ã\Åx«\Ú\Ø\Í\î\Ú÷%\İ.\Ï\"Se\Ã-‘¤x8-N-t\'\Æ\êäµŒ“ø”KUOÌ³\ÆÎ®\Ø\×9rF«s1\éZ\Ù4¾$cqt\Û(i\ä›ö\Ü5X<\Ê\ÛØ¨ñ±\éı^Ó•\Ü1+sñ|#\æùü\n £\Ì*+d\Ê\ßa­c:s>+\ÉZ´İ‚\Ñ(Á±Ú¯Ê–ô—$¹G\İ\ã\âMZ0€\èı“T—R\ÜiI8FH?ˆù\n\Ã	ğh\ä=%¯K+³½5\åş\ÍùM9€ \0€‰u?ôn\È”G0\ã‘(\è\0€ \0€\à\Ì1WUFw²g´õ!RIi&¨Q-\ê¡.ô¿¢\Ê\Ä\Ú/c$n¬Œk‡\'¯Sk‘„ë…‹I­W‰ÖºšX¼†Õ‘jı\Älœ=]H®*\n8Nc¦ˆz»W’º\ÉsfÊ¶nOXV“÷V¢h@Å¢ZL\İô‚\ê\'Njµp\îóS¹İ°\ç\ÚR(»²×‡2Ÿi\ì×\ã¤ô\İ×¦¼ş\'C\Ñ\í.¶\ßd\î\"×‚«\îe\Æ]û¤l?u:¬ˆYÁs9\\í“‘†·¥\Æ=\ë\ælyX\0@AºŸR&sq?!ı\ĞP»\Ö{yŒ & \0€ -\Ô\Ï-<•Š&—½\Çpy^6’Õ™B²JZ¶s*ı-¾i\r\ÄQX$¸áŒñ\Ã\âs½\Ñò\Ç2«\å}–\Ëv³°§d\á\áS\Ú\å=_ñ\îK©®\é\rª®\Ïr4õò	f{¦@I\×\Öß´\ïÛ«E°”%¤‹lº²©ß©h—\r;´ûÕ¨š\0@\0@xP\íƒK,Zi\í{\ÛN\Æ\á\Ï{¬s÷¿i$\î*uwÕº¡$rù»\':W\Ë&©ûO»ƒüø”\éCKZC¢r\Å„¦8ß¬6\ë4ò\æ\ßø^[JK´¨am)X\ŞzÑ¾\Z¾ògC·U\Ç_AMY\êç‰²7¡S£%(¦^\ê¥M’®\\\Óh²5\0@c+İ¯XÁŒúŸöÀıIšxg’@\0@k}¢J\è´J³S9{£f\ÎE\íÊ”ô©–\Û*Y\Ğ×¦¯\É3”º£Q:X›%Ò¨d³‹ÈŸ…¹\Çü­z¬züY2q·l\æ5¥qş¾¯ó‘©\Ò\Ò_4Ò¾Iœşô\Æd“Õ>!£—O2£(\Ù|µ/l»dÔ¢–šô\\ß‹ü÷Jªi¨\êe¦©f¤\Ñ;U\í\È8>KL¢\âôe•V\Â\Ø+ õL´±6\0@&†\İ[p\×44“TÁ.1°<ùøoYF—\éF‹²i£N\ÖIk\Şd4bø\Û\rl’KCK$Ü\Ã\×h\âAße6öoŠ\"m›ZQq]\ßu«\Ñ+‘\Ğ6\ác{i_(\ËLc\Ô\'ˆs8òÇš™*+¶;\Ğ\àsµml\Ì]9>\Ò]üş©\ĞÊª\Í\Ò\Â+\Ú\è\ÙP\î\îH\É\Ëuı\×»³\Ç>EUY¹.¥Öª¬\ì/Y«‹|:§\î\æu\Zx\"¦…°\Ó\Æ\Ø\âo²ÆŒ\ÑX¤’\Ñl\ç)\ËzOV\\^˜„\0@a˜\îöI%øİ‘Ó‚\â#O\'y<F\Ã\Õq\0@šªX*\ã\Ô\Æ$`{^øšA\æñ\Å>Î»\'[\ÖG\Åyğ9®AQv\ÓZkt>Ó¢6rnI.w\Ëo’¯\ÈNw(£®\Ø\ÖCgJùw¿–†\íU:3¢\Õ‡\Æ\0¥§qf}\ç\ãy\æI\ÚTÇ¥U½:\ínyù±\í_\êk\È\å\Ú)f~^[®q…¹–¢L\í#<ù“ù•[E}¤ôgi´óV>ôWÁ/\Î\ã|®\ì\î\ÍPK©ŸSJy1ú\Íù;?u6X•¾\\fŸHr\á\ÂzKŞ¾†\"nÌ¥\Ï\è.\Ì#””\ç\îµ<.\é\á\é2ı\Õy?±ökq\áp¥=Z\à±õ9w›ı-?ù¿4z\Ş\Í.õÆ”tcŠz”»\Ï¤´ÿ\0\æü\Ñz>Ì§?¬»F?vœŸõ,½Iÿ\0‘ƒôš=*ş~\Ä\È{3¢ô‹•Sÿ\0ñ±­û\åd°£Õ‘\ç\é-\ÏôÖ—¿Wô3Z`¤!ÆŒ\Ô;C\Ë\Ç\Ëw\Ñn5q\è@»m\çYûô÷pû›1Gm\Ù°5\0 ·¥§\"ªRrz\É\ê\ÍWM4J­<µ´\\Z5½]‚\ãÈ¨\×Ğ¦µ\\Ë­“µ§5]X?\ã\İ\á\àa{\'¬x¾\Ä\ê¶f´ğ9\Õwú~KN¸¸–>’Ò·k¹{¾k\æmZO£Ì¼¶x\\Ø«©dká”‡S\á³\ÉI¶¥=TR`g\ËzŒ$´k\ægV\â¸ -\Ê^î˜±¾Ô¨ü\Ğ˜5Z¤úI5$\Õ;÷@N@\0@b›dˆi,—§;ZCN\ØX\Ì{\'\'.ó>k_f»MòcÌ—ª,U\Ë]~\Å\ëõ)®²WÒ·Ú–\ío\\lú¯lô\Z0Ã·±È…£F©\Ù=(m®²´·iƒı–€~\î*6}–Ë¿Im\ÖøUÜµóÿ\0Fô¦\Ø@\0@©Û¬R\Ûtö¦²È¢ª¤{õ€\Ø\ÙÙ–ù\ïó<”h\Ô\ãs’\ä\Ñu~toÙ‘ªOÛŒ—–ıb’R„\0@‰\åôš¢\áú¶z­ñ\æP !M/{\ßhl(¨\0€ -¶‚\ÛM\èôlÔ‹]\ï\Æx¹ÄŸº\Æ1QZ#u÷\Ù|÷\ìz½òZ–F€ \0€ \0€ \0€‡q¨1\Æ\"Œş’O \âP#`c\0\nTr\Ş\ß1\Ì 2L{^\Ğæœ‚€õ\0@\0@\0@\0@\0@\ê&e<FG\î‡3\É‰f¼’:i}·}<P\0@ ˜\Â\îl;\Ç\æ€\È5Á\Íi\È;Š\Ô\0@\0@\0@\0@\È\Èc2H\ì4q@b_#\ê\æ\ï$`ö\Ëû . \0€ ¸ftf\Ö\íşˆ„r6F\ë0\ä *@\0@\0@\0@ª‰\ã§f¼‡ \ÏD.G\ÉW |»\Z=–rş\è\n\Æ\Í\ÈP\0@\0@\çF\íx\ÎE6\n¶I†¿\Ô#¸ô(	\0€ \0€ \0€ U70–@’s÷Gšc¤y;‹\Şyğ@]@\0@\0@„q\Ï4;\Zu\Ûğ»ò(	Q\Ö\Âı=Û¹;w\Í$m\0@\0@xHh%\Ä\07’€‰5\Êl‹2»öw|\Ğå’¢«d®Ô\ànÁ\ç\Í\0c\ZÁ†„h\0€ \0€ \0€ \ÂŞ€ñ­tg1=\Ì\èv|[WR\Íú#è€¬\\ˆö\à?\Â\à¢¯\Ä\à\â\ÙP?ªø¥77ÿ\0*\Ãtƒ\İd®\èõ@Pë›\ê\é\Ïñ?n««“s™îŒŸªË¡2\Ì÷<ş\Ñ\Ê\ãX\Ö\î\n\0@\0@ÿ\Ù');
/*!40000 ALTER TABLE `food_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generates`
--

DROP TABLE IF EXISTS `generates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generates` (
  `g_process_id` int NOT NULL,
  `g_flavor_id` int NOT NULL,
  PRIMARY KEY (`g_process_id`,`g_flavor_id`),
  KEY `g_flavor_id_idx` (`g_flavor_id`),
  CONSTRAINT `g_flavor_id` FOREIGN KEY (`g_flavor_id`) REFERENCES `flavor` (`idflavor`),
  CONSTRAINT `g_process_id` FOREIGN KEY (`g_process_id`) REFERENCES `processes` (`idprocesses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generates`
--

LOCK TABLES `generates` WRITE;
/*!40000 ALTER TABLE `generates` DISABLE KEYS */;
INSERT INTO `generates` VALUES (5,1),(7,4);
/*!40000 ALTER TABLE `generates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `health_score`
--

DROP TABLE IF EXISTS `health_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_score` (
  `user_id_health` int NOT NULL,
  `score` double NOT NULL,
  `record_time` datetime NOT NULL,
  `advice` text,
  PRIMARY KEY (`user_id_health`,`record_time`),
  CONSTRAINT `user_id_health` FOREIGN KEY (`user_id_health`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_score`
--

LOCK TABLES `health_score` WRITE;
/*!40000 ALTER TABLE `health_score` DISABLE KEYS */;
INSERT INTO `health_score` VALUES (1,87.5,'2017-03-17 20:31:15','Run more.'),(1,88.5,'2017-03-18 06:31:12','Play \"Taiji\" more.');
/*!40000 ALTER TABLE `health_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `howto`
--

DROP TABLE IF EXISTS `howto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `howto` (
  `how_food_drink_id` int NOT NULL,
  `how_process_id` int NOT NULL,
  `note` text,
  PRIMARY KEY (`how_food_drink_id`,`how_process_id`),
  KEY `how_process_id_idx` (`how_process_id`),
  CONSTRAINT `how_food_drink_id` FOREIGN KEY (`how_food_drink_id`) REFERENCES `food_drinks` (`idFood_Drinks`),
  CONSTRAINT `how_process_id` FOREIGN KEY (`how_process_id`) REFERENCES `processes` (`idprocesses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `howto`
--

LOCK TABLES `howto` WRITE;
/*!40000 ALTER TABLE `howto` DISABLE KEYS */;
INSERT INTO `howto` VALUES (1,2,NULL),(2,2,NULL),(3,2,NULL),(4,1,NULL),(163,6,NULL),(225,1,NULL);
/*!40000 ALTER TABLE `howto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leads_to`
--

DROP TABLE IF EXISTS `leads_to`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leads_to` (
  `leads_process_id` int NOT NULL,
  `leads_diesease_id` int NOT NULL,
  PRIMARY KEY (`leads_process_id`,`leads_diesease_id`),
  KEY `leads_diesease_id_idx` (`leads_diesease_id`),
  CONSTRAINT `leads_diesease_id` FOREIGN KEY (`leads_diesease_id`) REFERENCES `disease` (`iddisease`),
  CONSTRAINT `leads_process_id` FOREIGN KEY (`leads_process_id`) REFERENCES `processes` (`idprocesses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads_to`
--

LOCK TABLES `leads_to` WRITE;
/*!40000 ALTER TABLE `leads_to` DISABLE KEYS */;
INSERT INTO `leads_to` VALUES (4,2),(4,3),(5,3),(5,4);
/*!40000 ALTER TABLE `leads_to` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performs`
--

DROP TABLE IF EXISTS `performs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performs` (
  `peform_uid` int NOT NULL,
  `peform_aid` int NOT NULL,
  `activity_start_time` datetime NOT NULL,
  `activity_end_time` datetime NOT NULL,
  PRIMARY KEY (`peform_uid`,`peform_aid`),
  KEY `peform_aid_idx` (`peform_aid`),
  CONSTRAINT `peform_aid` FOREIGN KEY (`peform_aid`) REFERENCES `activity` (`idactivity`),
  CONSTRAINT `peform_uid` FOREIGN KEY (`peform_uid`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performs`
--

LOCK TABLES `performs` WRITE;
/*!40000 ALTER TABLE `performs` DISABLE KEYS */;
INSERT INTO `performs` VALUES (1,1,'2017-03-17 15:00:25','2017-03-17 16:12:35');
/*!40000 ALTER TABLE `performs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `processes`
--

DROP TABLE IF EXISTS `processes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `processes` (
  `idprocesses` int NOT NULL,
  `process_name` varchar(45) NOT NULL,
  `process_chinese_name` varchar(45) DEFAULT NULL,
  `process_description` text NOT NULL,
  `process_chinese_description` text,
  PRIMARY KEY (`idprocesses`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processes`
--

LOCK TABLES `processes` WRITE;
/*!40000 ALTER TABLE `processes` DISABLE KEYS */;
INSERT INTO `processes` VALUES (1,'Stir-fried','ç‚’','Use oil and spoon to quickly make the food done.','å¤§ç«ä¸é£Ÿç”¨æ²¹çš„æ°ä½œã€‚'),(2,'Boil','ç…®','Use water to slowly cook the food until it is done.','æ–‡ç«åŠ æ°´ï¼Œç›´åˆ°ç…®ç†Ÿã€‚'),(3,'Steam','è’¸','Use the heat of water steam to make the food available.','åŠ å…¥è°ƒæ–™å¹¶ç”¨æ°´è’¸æ°”åœ¨å¯†é—­å®¹å™¨ä¸­åŠ å·¥é£Ÿç‰©çš„æ–¹å¼ã€‚'),(4,'Fried','ç‚¸','Put the whole portion of food into oil.','å°†é£Ÿç‰©æ”¾è¿›æ²¹ä¸­ä¸­å°ç«åŠ å·¥åˆ°ç†Ÿçš„å·¥è‰ºã€‚'),(5,'Sause','è…Œåˆ¶','Put salt onto food to make it available','åœ¨é£Ÿç‰©ä¸Šæ’’ç›å¹¶é™ç½®ã€‚'),(6,'Washed','æ´—å‡€','Use running water to wash this food.','å°†é£Ÿç‰©æ´—å‡€é£Ÿç”¨ã€‚'),(7,'honeydrew','èœœæ±','Use sweet syrup to process food.','ç”¨ç”œæ±æµ‡çŒé£Ÿç‰©ã€‚');
/*!40000 ALTER TABLE `processes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend_diet`
--

DROP TABLE IF EXISTS `recommend_diet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend_diet` (
  `r_uid` int NOT NULL,
  `r_food_drink_id` int NOT NULL,
  `r_time` datetime(6) NOT NULL,
  `r_unit_amount` varchar(45) DEFAULT NULL,
  `r_measure_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`r_uid`,`r_food_drink_id`),
  KEY `r_food_drink_id_idx` (`r_food_drink_id`),
  CONSTRAINT `r_food_drink_id` FOREIGN KEY (`r_food_drink_id`) REFERENCES `food_drinks` (`idFood_Drinks`),
  CONSTRAINT `r_uid` FOREIGN KEY (`r_uid`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend_diet`
--

LOCK TABLES `recommend_diet` WRITE;
/*!40000 ALTER TABLE `recommend_diet` DISABLE KEYS */;
INSERT INTO `recommend_diet` VALUES (1,1,'2017-03-17 18:00:00.000000','1','1'),(2,3,'2017-03-17 18:00:00.000000','2','3');
/*!40000 ALTER TABLE `recommend_diet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registered_user`
--

DROP TABLE IF EXISTS `registered_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registered_user` (
  `iduser` int NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `registered_date` datetime NOT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registered_user`
--

LOCK TABLES `registered_user` WRITE;
/*!40000 ALTER TABLE `registered_user` DISABLE KEYS */;
INSERT INTO `registered_user` VALUES (1,'Sam_Yjy','123456','yanjia@kean.edu','2017-03-15 21:09:00'),(2,'Mr.Freddy','123456','wangr@southcalifornia.edu','2017-03-15 21:12:00'),(3,'John Zan','123456','john@edinburgh.edu','2017-03-15 21:13:00');
/*!40000 ALTER TABLE `registered_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registered_user_bmi`
--

DROP TABLE IF EXISTS `registered_user_bmi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registered_user_bmi` (
  `BMI_uid` int NOT NULL,
  `Measured_time` datetime NOT NULL,
  `height` double NOT NULL,
  `weight` double NOT NULL,
  PRIMARY KEY (`BMI_uid`,`Measured_time`),
  CONSTRAINT `BMI_uid` FOREIGN KEY (`BMI_uid`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registered_user_bmi`
--

LOCK TABLES `registered_user_bmi` WRITE;
/*!40000 ALTER TABLE `registered_user_bmi` DISABLE KEYS */;
INSERT INTO `registered_user_bmi` VALUES (1,'2017-03-16 21:10:00',1.75,76),(1,'2017-03-17 21:13:00',1.75,80),(3,'2021-07-26 17:25:46',1.75,67);
/*!40000 ALTER TABLE `registered_user_bmi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stimulates`
--

DROP TABLE IF EXISTS `stimulates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stimulates` (
  `cause_food_id` int NOT NULL,
  `disease_id` int NOT NULL,
  PRIMARY KEY (`cause_food_id`,`disease_id`),
  KEY `disease_id_idx` (`disease_id`),
  KEY `food_id_idx` (`disease_id`),
  CONSTRAINT `cause_food_id` FOREIGN KEY (`cause_food_id`) REFERENCES `food_drinks` (`idFood_Drinks`),
  CONSTRAINT `disease_id` FOREIGN KEY (`disease_id`) REFERENCES `disease` (`iddisease`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stimulates`
--

LOCK TABLES `stimulates` WRITE;
/*!40000 ALTER TABLE `stimulates` DISABLE KEYS */;
INSERT INTO `stimulates` VALUES (1,1),(2,1),(3,1),(225,4);
/*!40000 ALTER TABLE `stimulates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suffers`
--

DROP TABLE IF EXISTS `suffers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suffers` (
  `suffer_uid` int NOT NULL,
  `suffer_disease_id` int NOT NULL,
  PRIMARY KEY (`suffer_uid`,`suffer_disease_id`),
  KEY `suffer_disease_id_idx` (`suffer_disease_id`),
  CONSTRAINT `suffer_disease_id` FOREIGN KEY (`suffer_disease_id`) REFERENCES `disease` (`iddisease`),
  CONSTRAINT `suffer_uid` FOREIGN KEY (`suffer_uid`) REFERENCES `registered_user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suffers`
--

LOCK TABLES `suffers` WRITE;
/*!40000 ALTER TABLE `suffers` DISABLE KEYS */;
INSERT INTO `suffers` VALUES (1,2),(1,4);
/*!40000 ALTER TABLE `suffers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplies`
--

DROP TABLE IF EXISTS `supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplies` (
  `vendorID` int NOT NULL,
  `supplyFoodDrinkID` int NOT NULL,
  `produced_time` datetime(6) NOT NULL,
  `storing_duration` varchar(45) NOT NULL,
  KEY `supplyFoodDrinkID_idx` (`supplyFoodDrinkID`),
  KEY `vendorID_idx` (`vendorID`),
  CONSTRAINT `supplyFoodDrinkID` FOREIGN KEY (`supplyFoodDrinkID`) REFERENCES `food_drinks` (`idFood_Drinks`),
  CONSTRAINT `vendorID` FOREIGN KEY (`vendorID`) REFERENCES `vendor_user` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplies`
--

LOCK TABLES `supplies` WRITE;
/*!40000 ALTER TABLE `supplies` DISABLE KEYS */;
INSERT INTO `supplies` VALUES (1,1,'2017-01-17 05:00:00.000000','12 months');
/*!40000 ALTER TABLE `supplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tastes`
--

DROP TABLE IF EXISTS `tastes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tastes` (
  `taste_food_id` int NOT NULL,
  `taste_flavor_id` int NOT NULL,
  PRIMARY KEY (`taste_food_id`,`taste_flavor_id`),
  KEY `flavor_id_idx` (`taste_flavor_id`),
  CONSTRAINT `taste_flavor_id` FOREIGN KEY (`taste_flavor_id`) REFERENCES `flavor` (`idflavor`),
  CONSTRAINT `taste_food_id` FOREIGN KEY (`taste_food_id`) REFERENCES `food_drinks` (`idFood_Drinks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tastes`
--

LOCK TABLES `tastes` WRITE;
/*!40000 ALTER TABLE `tastes` DISABLE KEYS */;
INSERT INTO `tastes` VALUES (3,1),(163,4),(1,7),(2,7);
/*!40000 ALTER TABLE `tastes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor_user`
--

DROP TABLE IF EXISTS `vendor_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor_user` (
  `vendor_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `vendor_name` varchar(45) NOT NULL,
  `vender_chinese_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor_user`
--

LOCK TABLES `vendor_user` WRITE;
/*!40000 ALTER TABLE `vendor_user` DISABLE KEYS */;
INSERT INTO `vendor_user` VALUES (1,'sanlu','123456','SanLu','ä¸‰é¹¿','sanlu@china.cn'),(2,'guishengyuan','123456','Gui_Shengyuan','è´µç”Ÿæº','guishengyuan@nanjing.com');
/*!40000 ALTER TABLE `vendor_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verified`
--

DROP TABLE IF EXISTS `verified`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `verified` (
  `verified_food_id` int NOT NULL,
  `expert_v_id` int NOT NULL,
  `info_provider_uid` int NOT NULL,
  `verfied_status` bit(1) NOT NULL,
  PRIMARY KEY (`verified_food_id`),
  KEY `verified_food_id_idx` (`verified_food_id`),
  CONSTRAINT `verified_food_id` FOREIGN KEY (`verified_food_id`) REFERENCES `food_drinks` (`idFood_Drinks`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verified`
--

LOCK TABLES `verified` WRITE;
/*!40000 ALTER TABLE `verified` DISABLE KEYS */;
INSERT INTO `verified` VALUES (1,1,1,_binary '\0'),(2,2,3,_binary ''),(3,2,1,_binary '');
/*!40000 ALTER TABLE `verified` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-26 17:45:58
