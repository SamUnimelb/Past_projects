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
INSERT INTO `activity` VALUES (1,'swimming','游泳',800),(2,'running','快跑',700),(3,'ice burg','冰球',700),(4,'jogging','慢跑',655),(5,'dancing','跳舞',600),(6,'cycling','骑行',500),(7,'tennis','网球',500),(8,'rope skipping','跳绳',440),(9,'walking (quick)','快走',555),(10,'walking (general)','慢走/步行',255),(11,'golf','高尔夫球',360);
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
INSERT INTO `amount_measurement` VALUES (1,'bowl','碗（普通）',100),(2,'small bowl','小碗',75),(3,'big bowl','大碗',200),(4,'spoon','勺（普通）',10),(5,'teaspoon','小勺',5),(6,'big spoon','汤勺',20),(7,'huge spoon','（食堂用）大长柄勺',100),(8,'plate','盘',100),(9,'small plate','小盘',50),(10,'big plate','大盘',150);
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
INSERT INTO `disease` VALUES (1,'diabetes','糖尿病','Can not tolerate sugar.','这人不能吃太多糖。'),(2,'obesity','肥胖','The person is overweight. Can not take too much fat.','这人脂肪摄入过多，太胖。'),(3,'cancer','癌症','A disease which is difficult to cure.','一种没药救的毛病。'),(4,'High blood pressure','高血压','A disease which makes you feel bad.','一种感觉很糟糕的毛病。');
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
INSERT INTO `flavor` VALUES (1,'salty','咸'),(2,'bitter','苦'),(3,'sour','酸'),(4,'sweet','甜'),(5,'spicy','辣'),(6,'umami','鲜'),(7,'nice','香');
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
INSERT INTO `flavor_stimulates` VALUES (4,1,'Sugars make food feel sweet, but adds the risks of ','糖原增加血糖，提升糖尿病风险。');
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
INSERT INTO `food_drinks` VALUES (1,'Cooked rice','大米饭',351,79,0.5,7.5,0.4,0.112,12.488),(2,'millet','小米',362,77,1.7,9.7,1.4,0.2657,NULL),(3,'noddles','面条',339,70,12,0.8,1.5,0.2096,NULL),(4,'beans','大豆',413,25,17.4,39.2,5,0.8959,12.5041),(163,'persimmon','柿子',48,11,0.1,0.7,2.9,0.0292,NULL),(225,'crab','螃蟹',139,7.4,5.9,1.4,1.8,0.287,NULL),(226,'Cooked rice','大米饭',351,79,0.5,7.5,0.4,0.112,12.488);
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
INSERT INTO `food_image` VALUES (1,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z!.%+&8&+/1555\Z$;@;4?.4514+$,44444444444444444444444444444444444444444444444444��\0\0\�\0\�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0=\0\0\0\0!1A\"Qaq2��B�\�#R��\��b���rs��CS�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0\'\0\0\0\0\0\0\0\0!1AQ\"a2q�#���\�\0\0\0?\0��QI����+�&{�\��	O���\�x\�Ł�\�tZf�o��p�mƊ�7�{�����CG՗�Y���\�%�S�B�D\�M��\�@\�51lQ\�kHg\�+n5\ro^\�K�i/2B?�H\�5Hڬ\�^\0���3��i~\�k�\�\�\\\�\�{�ʻ0�̻D\�����\����]�Sy(��\�z�$\��S\\�\����\�ŋ1f�m\'t�w��\�@�_�=�<�*v���f+�n,�}稭�~�(�_\�\�E��+�n\�vn�חUb�>_�ȓ<F+�aA\�)\�\�;\�����N\�Bg���N1P\�94\�Ȅ��B�\�qMGG���j�&����r\�T)Z�\rJ��P\�Ȧ�M�$ԭ���S\�h�����dT\r�Dۢ�$��V���kN\��Tc�I�hU�D�)bD�@̞hk{��\�e\'��Et\�\�V���Ŷȋ\�f�\�ffb�etUU\�9X�\�#�\�4\�%oD\'�qt�x[�wR\n���\0,	��Z\�{�\��MI]M�!	]\��\�\"�Um\�	�5H�(�9�\�)*)k�=.�GPP\�>\�U�\��ѱu��l�����u&���;��d\�9G�dw�Ɩȷ;�X��>�1ZN�2�Uj*��m�li��u��3\�E\�փ�\Z��ڬ\�`�\�v��1�^Us�����)�T0&�v$\�/:\�\0gҒQR\�-\�\�(j\'�\�R����A�\�}�q��\�i�4\'�gwI޹�Gu5h�\�\�GP ��Q��>��Ȥ�f%5M��A�=A\�@j�J*qJ+Y�_������S�^��$*�/Z�\�8�\��\�(�\�vX)o�\ny���+��;�_UtZ��$�0\0\�w7�V�:F{\�\�\�\���Qx\�9\�W\�}\�\�\�m�\0�s�os��\��3�t�]�}���_g�����\�f�\�zev-�2촀q��X�ԓZ\�i:zUc��NNy\�M�B>��D��vH5E\�Lg��YT�1t\�*+5zɆ���\0��{�\�M�4�Ű\�$㨨�\�\�z\n�\��\�<\�6J�E{�8\�b\���6�� \n��\�6��\��J�9\'#\�~�=H�|P���\�N���J6�\ZM�\�;\�\�\�u\�Y\�ض\�\�y��\'\�\\~�N\�ث�FA�uC���t��\�~\�>N0\�؊L2\�\�\�qT\�\��%\�\�\'\�\���}97m�~5޸��\n�VX`� �\�)\\k�˕\�ZZ��}�����h4�SW�`�e)�\Z4Қ�L\��8�b\�8�c�=\�>>����ۉ\�9\��\�q�\�U�\0g=\�W[}fse��\���BK� <\�\�U�ps�+\�?\�ePH���|:tJ�\Z�9AsRc\�TӃ�[0ˊ�i��\�\��P\�\�JG4�2�e�\�IF(V��\�Zu&}?:)��Q7QA\�Y򚺮s\")1�(\�ѓ�8\�\��)�\�X�{��LP�\'�ғ�❾ƶA�9\�S�?ڗY4\�\�*�\�^\�Y�=O��d`G����&�MɅ|:�I��İ�\rE�LUo�<���ze�\���\r 4�l\rm_�\�⹮�w5�n\�!/�\0\��\��Z\�f�5kA������%�\�\'\��\�\�v�qJ��*y\r�\�=�\�k\��\�x[�\��[�\�^z\�+20*\�He<�0ENQqg_$d�$b���\�R�\�d���\��\�:�R[i�k\�ȤH�\0\�H_��e\�\�߲\�M5\�A+���[\��\�\�aKǷ\�_�\� \�\�\�\�Y�\�\0G\0\0<�:{,1���rA\'\�Q\�k��\�\�\�5�t�P�r�\�`\�*��\�\�\�w4�i�\rǯJ\�r����IvYTܰsNքE8���b��<B4���֜D\�-�\�\�My1+�\�K�ߠ�d\�\�n�b���\�>��p�\�\�A�&�lF-5+\n\��P�\"s\�F�{ӟʒ/{�>昙DTn^�#�_$��@݃A�rh7d�n�\�\�\�\�S|��:@��(ȊpLO�Ҝ\�\�j�\�e�\'O\�<\�v\�\�\�n\�?�����OҚ\�N\�Ԉ�}z�MOMm��??*���+z\roJ�u\'֢�Q$��\�F29?J��Z�I	a�׊0\�p?��[mban�\�p���\�\�\�v�\�*\�[ME����H�\�u$\�`�gΠS\�uV\r�{m�#2�u$\�@\�\\���.-{u\�\�\�0Sw\�ݘ�\0Z�\r�\�]\�`ݝ����鸖�����4�\�H�<�\�i\�\��k3F@5r\�f�n�\�˲\��\�\�\��j\�L�[\n\�#\�SP\0�\�6\�j{���҆���\�\�\�K`#�\�Ѵ��P.�#DDL\�\�L\nҕ%~L�!k4B�R��}?:�\nъ�6 �Б|^�h\�(H��-#\".�$sQ�x�O�Ń ��\�j�]e�q\�\'3\�\��Ԥ\�i���A҄\�\��]y\\��\�*���\�8ϧ�3�N���\nd���U\�M��$�E����&�\�l�,z\�/Z��sB\�\��}\�UcI�\�ڇ�b��4���\�{=NSq1�\�~�[W\n�F\rW�f\\Ө.�:�\0cM\r\�Y9߻q��@�\�^=Y�\�k�5\��\�\�\�ݎ�\���T�G��\�ڋ\�潏�u�ߤKm?+G�����*��F��.\�\�\�Y�\�\��\\)\'��I�,:\�pSm?(o���\�;� $�\�H>gʭ\�r�\�g��k�+���6~R9�<�����\�KN2Ŝ=�6�qBs�\�D�y�{�$\�]P�qzj.͂3\�\�=j�j�\0`�M\���2|�*Y\'\�j�����h��P\0\�S\\2 U\rE�\�\"=\�eqw���{Kb��\��G�R\�\�\�q\��\�i�\���\�\�\��O���T\�;n��\�1�q˖M��;瘌F|\�MdLɧ(\� ��\�v\�\�4�Ʉ8�\�\�Z�<����\�\�Uo ���\�l+D46Ja�\��\�\�\�]\�\�t�%�q�V5\���NOQS�\�$�\nv\�վ\�\�\�8���&��\�\'�m[�Cm�̫$�ɀH\��\�Z�G`F	\��=\�\r9\�CITMR���\�wBh���o�\�D\����Ud�\��\�\��T\�]��Pm z\�?jʶ�}]�\�TG�y\�9h�U\"�����\�g %�A�Ľ�(�T0\"$�|�^h=�\��\�|\0�w\�>S\�\��>T��\0@q�\0�����\�_�t�7f\�\����\��Ɋi4\�]r$�#I�p+���\�\� #q@\�?))�0>�\\\�0�V\�tu_Wl�iC\�`}X(�\�\�I\���\�{�>\��m9ڂe���ܣ9P V�\��m��܏L\�s4\�\�\�$���\�.m��T\��\"�{/�Z\�-�\�yv \n�\�6�cy�h�k�pRߓ˷l�\�@�\�6G��eއr�cЎ�%��ӭFJ�3/�-N�@�8����VV\�\"ry�\rXr`�\�r$\rM�\�i\r�\�w�<\�l\�@\"*/c{\0I�N|��)�\��P�p \�b|�\0\�j-�׊�bi5\�\�h�F�\0,\r\�\�bGA֣r�ځ\�Q~T���\�2AYzV^�ZA���V�\� ��\�i\�a�߭Nk8\�\Z.�\�\�\�\0#��}B��\n�\�mߟ�Z<�J���)`\�2dbq&~��Xkp���∉�I�\�:T�ݑ��Wi3P��wnUW�v���jriR\�b��&9<֋\������M$�ey\�t$v\�Wt��b���oJ�PC?\�#u3���O�.]\r\'A�\�\����\"E�82Dn>�1\�2}<���A�o9�\�@=\"f=:�kC�;R\�\�\�HE\�\�`\0v�y\�\�\�\��׹\"x�L�J\�\�\�#�d\���&��sVm\�*�\��0�S#��2���$z\�Ug�k�\�\�m��*�oi�m��O�\r\�r�\�&��\�,�wTԔ�8��\�ԫxe@oFA\0�C�}��ثx\�#�Oô+�\�V[\�q��\�5��\�l%����	�\�Wx����b���)�W$1�Dy��+3�\�C<�`�@\\�ψ\0b�mk�jS��2�$O@c�К\�:��\�^4췂�ï�\�\�\r\��<n���c\�;&\�\n`\��$�!����2JJ�*��K\�n�*\�b�]k\�m�GE\\��R�Z�3��\�\�\�ޏ�,\�\�1\�0\�:��\� パS\\*+\�g&�}�\�J5�\�O�>�\��<�\�\�\���\Zr�#\�\��\�hM\����I�{TuwOVV�T�I,|��NLXэ�W\�	�\���2����P\��\rqC?�p9&c200k\\x((�7�}\�\�\�\�5WR�}�?W�r\�P�\��\�Db�\�N\�FQ��W\�D����\�P1�ǯ\�\�I���?*��zтo#7��V�s֏y���\���/�\�Fn�c^\������I�\�\�Ս>�\�|�=[\�?:`���.(�\��\�\'���(JRO�ͤ���U�A\�T_���\��$�\�\���\�\�>�ڶ��H�2H9�G�q��\�׵,�Z$J�	`w�S��z��\��\0s�&�Wjw�ޝ\n\�\��\�0ē<	��S\\V�\�\�-v\�J	�%\�2G�ު\�E�&\�\��9he�@\r�\�C\�\�.�\'6�\�\0>i\�ǈg\�C�-!�����R�%A�!d�r\�YDA4WP�;�`g��C@�\�WEb��4�¤(D\r\�>f�m9\�����2>�3􊯏\�M�\��\�\�\�\�A��1\�t#�5\�vn�jX޶Ȑ�W\�xŒ��\�>N\�\r\�D\�q\�*\�gkZ\�\�X �d9WS��:�F<�0O\�vt�4�\�\�\�]l�\�w�L�RC�B�\�i\�`\�Co��ܰ�X��W�o!~\'(n0�n28<\�vGie\�#��\�(\�0\n\�\� ��d�0�\0	\�F:F{l�D�#\���l�o��\n��\\FݵN-\0\�ld��6pqt\���\�޹�շ!Ut|������\�̑�\�w��=5���G�t�Z\�eɑ$<*��\��\09h���������du��$87tW\�\�gJ2��ù\n��rB�\rۣb��!4\Z��6O\�\r�CW��e\"8\�j柽�\��\�\0n �*�\�I��fq\�\n\�e��Х\�Wy!e�t��	�NFHnkY\r����ܾVA�\�\�4��\�ֻ\�e\�,Q�b$\�@<F3���M\��Wc�	�\�{\�\�\�\�m?\�V��)e�L�\�¨nGs\�Y��3L��\�mB!E`꒬\�Ԗ2�4b�c\�W�,\���<�)~�d�u~\�\�\��\�i݂2�ܗ	e(Ĉ\�\"2dFqMo��J6ϰ+K�~����Q3����\�\�_\���2Z�\0�/\��\��\�\�[G����1Tm\�qpIG(�\�\�Yk�(@�j��\�>�\nL �\�oYY������\�\�\Zu�d�&~¼۶-\�WW�\�m�α�T,0:M\Z\�c9`\�\�mŎ\�1,�Z@\n`��\�T�M�����9Tf\��N\"�GC\�X���\0(Wkaa`�ۙ������\�\Z�Mn\'9��L�;�~�B��՛\�m\�¨b��\�v(s�%\�l}�u�\�|x���\r��\�\"I\�I���\�\\:]ٴCcioI$��W�Wu�B\"rU	2\n9r	߭T�إf�f`Y¥K\�\�&I��Sr~FQEG�����hP\�HF%�$�i8\r\�hw��\�ڻX\nv�^ID�p ���y�6+ny>S���1\nc\��_P7N\�x��	�\09&@\�˟%o\�\�>�\�\�mq\� �$��\��+%����I\"z�:\��\Z5\�V`���P	%�,D�\�\�\�g_�\�:A3&<�\�1>�\�\�GQt���\0�\�\rF��\�\�N\r\Z��\�F���R\rU��ݙ�QߐVj�6\�3JdѠ\�e��\�0{d��#����I�wAmn�\�v\�\��6ʲ��NJ\�\�\�2k�\�\�~0[!s]/yA]>��`�9	LWG\�-�\"*m*:K\���\�K\�\�//�\�v\�\�wP�J\�bp7,�\�\�V�-�d�Ů]KLU\Z6����&\0�\r\r�5\�pL.�AWS �_Oz6�¯\��V-勶w�9c �6� � ��W�\�8%���m\�\�EFQ5A��H��΃��\0�\"1�w_�\�\�\�Q63�l�}\�>�$\0O�up$r\n�\�r�f��V\�¼����6\\=�Im��A\0\�P4u�[(\�vF��C38�Yf\�;w��� yQ�hǱخ\�ב�����_`&X��\�\'&\'��rvmXb��U�Q�{��\�\�\�`�I\�wO�v\�˻�Y\�\��\�d�\'ts����[ݤ\�+���	�~&�W,>c#�V�j	�\�&�\�i\0��gw!KO\�B$\�`\�\�o�>8g�\�n\�|�\\����\"$I>\�@\�=��qP\�K-�F71�+�*\�\�\�m�\\ #�`\�캅d8��FFij�A�).�{7U\�I0 n�\�v�V}A\�~ð�\�>�TneF\�E���p\�*:�C\\F�ŵ?1@\��o��~\�\�K�h\�\�*�\��\0\�\�i\"KH\�\�+1W�\�5\�k��{\":�$�C\�� \r��A�`5Ը.^\"\�.\�\�\�7�0�1&`\�U\�\�\�[�\�n3�\��\0\�\\u���\�P�\�%��\�\�<wb@hݱ\�<���}\�\��\'\�i\�o�,��\\\�\�\�u|&X�\�\ZFd��\�Z\Z�imR_`U*\��Ē\�¨�����{J\�q\��on\�Q@�de`n�\ZM \�&��T*1ӆ!YY\�r@&�YoT�U����yzO=b��@��渁��h�*D��s\�}j��++�\�\�\�7�+�n$��\"z�*m!���\�,\�3;�~>m��y\0\0\�f�=� \�C(�I%�\�c\'�*WU�&\� ��\��9�˿rO8�Ҳ\�\�R���@Q�\�ޕXTEHS��\�E*x�5\n�iR�2.O��E9\�Z���^\�\�\�J<�)��mt�$�Z:\�Xm9B~R#��2\��o;b��J�\�6\�7dv�\�5�q�)�Y|�\�ҽK�5�uh�$>DW��A��a\�\�b�>\�y\�SFTssq۵\�\�\r�=G�j��Mf\�b\�]�y���\�A\�# \��參�\�񟑏�t�?�t7t�\�U�9Z�3�\�N\�+[܎�	dP\�m\�;AȖ�T\�Kxy�ݿ�����xU�\�\�v���B�!f`c\�d⺋�B8?|\�rx��#򭔐1L\�\�h\�\�:�W{��([p\'l\�,6�HW��\�ιl[{W-�m�\"3�/\�;X\�\�9\�U�Ը\�~�\Zk[\��\0�͉���F�qn*ZdTӫʨɆ!\�\�\�y�#�\n�\�m=�[�Q{+\�u����\��6��$r[O�����\�U�R&v��\�3H�\r�0��Z֝�%��M�bw�`A<��\�Z��\�`\�\�\�3�xC��i_�\�8\�I��\���Y�|�\0!�)_#@%\�t�\�XF�uVf��5@\�E.Y˗\�@fa��<\�눓��S�\�[M\�H\�!\�Q_\�*�\�@�\�K<��\�U\�+6\\���j.���SX��i|/?z��3�b��\�O�x��R⮒J�ܝ�S\�S�XdJ�����T��P\r�\0�S}iMH���Ij \�\��jF��Bɑ��0�\�*b\rX+c�;ɨ\��G܃�?�cӪ�+-�B)\�!8�\�����/+[o?�>\�#\�[�5�n�GG�\0\�A�\"�\�F�\�H�\��{K\��\\ӊ�\���O���N\��\0T\�\�\�f�r\�\�\��ELJh\�_N*�\�\��\0�~��O��hoޫ\��G\����#�YZ\�Q\�W{�u\rˑ\�\0�\�F\��o���\�41G[�\�kK��%\�bj�m�\n6�3��+\"�(��92L\�&O���x�)���\�E=\0� *@V�fv_\�Gm\�v	���s���֍\�\��\0���~��y\�ʑ\�O[�\�\�w���9 \��{c֦�܍�\0\��w\�r$�\�\���a���ݣ �%I���(�\�$AX��[�gk1\�\�\0�i�\�TOIt�5\ZT� �Ʀ�J�A\Z�*U�}�Q�J��QjT��9tD\�R�D�#J�*\"\n��* b�J�`\n�*U�9�J�`�[�pH�\"	\�\�މ�X�\�\�}?A��V\Z\"GS�3���E��c#\'ҕ*2\�c\�\�$�\�}�\rܓ\'$\�J�`�\�'),(2,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0	\Z\Z\Z\Z\Z\Z\Z( \Z%\Z!1\"\')+...383,7(-.+\n\n\n\r.& %----//--/0--------/-----/--------------/----------��\0\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0B\0\0\0\0!1AQ\"aq2�����\��BR\�3br�#4s��C��\�Sc\�$�\�\0\0\0\0\0\0\0\0\0\0\0\0�\�\04\0\0\0\0\0\0\0!1AQaq��2����\�\"\�B�r�#C�\�\0\0\0?\0�lH�#,�H�#,�X��b{?�\��,���<c\�}�\���B�\�\�r�zk}��\�vyDg��X�¸���dx�1�����\"��\0�\\��*,�o\��+Z毼�I�\�\�:�������g\�\r%����\�s��<�مF8\�G\"f\�A\�]U0���\�tpXU\�ɶ��v{/�(N��6�F\\61﮾\Z\�\�\�\�B���s%N�ڎ\�ά�\�#ʭU��<�,�\�$����e�iY\01���\�=\�g\�ӆ��]\��Р f�\'\�;�dH\�\Z\�R��\Z���81�?چ<Ω4�\"�xaAӖ��KA�L\�!\�s\�Z�>X���\��*I@]�I�B!\�DD�����Y+\ZP��C:	i�h�<\�e\�AYt\�1CX\�,(\�.L֎��C�u�߆�I�\�\�\�8\�e�\�\�5ja�L��{9ٲ�(G�=�&Xdק\�>=�\�s�z~\�\��\�%7M	]N\�\�.i%�\��\�6f��I�)i�\�\��*���DH�W\�\�u0ݓ�.\��K��\�:��ب�\�R�J]\�,(\n�\'D�	\'`c\�\�{O��9K�:l�c�ZRT�\0K\�]\�\�\�\Z(�J!\�yH�#wg�l\�\�\�*Z��?���$\0护�V(�>\�{q\r>{�@��_�\0��v=����[M\�H��-�\�^�\�qX�eHd�h�wՃ}�\�gs�ߵω�`�f!�%\�HJE\0&f\�JIlƧd\�J�\0�\�*IR�&;�eIY-�`�i\�����\�b\�-\�¾4܅,(�b���\0i�\�g*`�%iiP<��&�\�Ĥ�\Z�x\�.PJ�\��n$Q~+\� ,=��+[h4�~*a�m��.𑀘�\�IQ\�#\�\�\�!\�\�Ms夒\�\��\�`\0������S<Ð\�s\��\�\�1\��!1>��K�_�%�Q�\0f�4!>�t\���=�VH�ꦚ$�F�\�\0\Z\n\��;O6\���\�-U�/j\�̘�!e\�$��\"��\��a�5���3\�\� l)\��\�O����DC�G^sM�8z�\�\�\�A���\�\�\�֕\n��**�Ӭ~�\�\�a\�v|��(\\�)&�@ �[#����Q���_�e�\�5=#\�]�\�r@B=ʴT��1�-\�?�9�#\�\�\\.���G���<\�[ڑ��QxwH�\�\�/\�lZ4��ُ����Ǜ))Z\�R�Y�\��b�<\�C	�e�P��af,�EBɂ\�\�ei�\Z\�M�/��e\�3`=�bL\�`TJ��\\SGO\r�P41��;9\��/Qٝ�5-\�c\�`}�I\�\'A���Κ\�+�{[�)���\0�c����^j��Th5S\n��@�TB�گ�%k8ie�ￔ�2��Z��\'�)�wc�0�I$�I$�$��u1b# �����߳\�H��t��L�BG�:�2fK���e�\0h�\�8\�YQ�JD|wi\�8���!���<qST�*\��\��$��k\�(Zؤ�6�\�\�%�KSkG!�j�\��)ś�gfv:P�Ĺ\Z\��~hTܠ�\��\�GΟ\�y�\�R�d��#̭˓W�\�a�q?����nA��np\�{X0�(z\�*I�\�é]\�OHH\����<�Y��Q�PU�B\Z��D�\�ݑP���o�u\��\0t�c]5�\�����P����\�M�O93Nm7V�Zr�0�o�k���I5��\�\�JBE\"\�\�\�o\�\���`���.!Fg��0E:_���&#Ba�-�l\�*\�\�K�LB!��\�Am:\rLQ\�\�\�\�\0%���\�49�\�=��\�;\�͈�S9}\�H�Z��	#¼�\��s�i][X_υ\���ܤwv$�$+A4\�0��\�S@{A)E�\�`[H��\��\�(L1\�D/:��\�\�z�KJjn6�b��\�\0XJ�.;\r)$�:\�*OG�3�H���	H{,θ�촂�\�2\�U0Q�oH�F?�g\�%+���p\�D}\�*a_�\0���(��\�\��q��4�c�/ϊ�E�^\�Gۻٙ8��I˗Tݶ\�K��g��0��1\�\�pb\�>^*!E�J��GJn��A#\�B\�aJ����0�U*\�=7g{\"�\':�P.O\�7\��\�kB�N\"�*���\�-į(Պ��b\'hv�Ha�ϒ�D\�%����J*��\�\0��)�����iB�D�TJu�0�P�ni҄\�*o��\�kL\�NT醪�\�$wP�\����\�k���\�be\�8i �JlN��\�g\�nO�&K�Y�\0�\r2�W\�\�!�\�B#�\��\\\�`\��\�\�Ã��B\��f\"\n�]�F��\�\�*L��r\����#�|NO��W�\"@�ۓxF��b8SY\�:�Ж)���!=��̴�IF�\�\�\�\�\�$\0\r��U\0:\�\�\�\'�\�O�) ��bU��I	\�\�j-݇X�$\\@	�\�\�\�<\�Q-\�@��7�����\�\r�^�SZ���>��\�K�\�_&{O�ul�+C;\��1�A!\�m�@��j\��1s&6�||�Xx\'\���W$\�6b\�!;*Pj�}\��A�\��h�\��\�\�\���+��\�\�~Q��BŪ��6�\04�\n�=k[��}\�@4>;\��Y�ľ�\�\��[�\�\�\���y�Z{\�\�M�� �2�;��h�=ufiO�Q*Ѳ�v�~��7���.\�9�C\�a��ĩ\�\\\�\�@i\���ԚxB=\�u�>�Q��AL�\�Js�\�\�&f,SAR_M���_p��g�e��4gg.����hnG]O�ZR\rTo^�DY� J�xF��+�\"�\�b�-\\j�Lgf��Q\nO@N���I�`hlS\��\�\���x&#ɐ�g�ȑ}2g��||yA�/\�\�JC�\�޻\���7�\�|!�dV���-\'\�9�,@^W\�Ob�9ErՑl�	�G6oe\��\�J֜\�%�\���\�҅\�k�yOm{*d\�>ilrU@�@\�s�S�v�O�!�iZh�(\�\0c��\�\n\�P�H�E���\�&1��ċ\rc�0�c\�\��.\"I�N�9a)JQ \\�@_�����\�P)w�0\ZM��!\'YH6?�\\V	���\'ݏ�I�\0\n?�6��x�\�O\rԦ\�M\�t}\"ݠ�U�\\9^�B/�\�\��GRnRjc&(+\�\n1x�b@!\Z.z<E;\�-�\�^q_x�(��Sٸ|�|�T͹�g�`�.x�\�\�\�暻\�0�1��\�b���^����c\0⊥78f\�\�)I`t\�\0�=u\�x�\���\�\Z\"\�\�Q�M\����\�\�\��\�O\�C�`9\�c�����e\�H\"\�\�q�f<\�AM=\�`MH7!�\���ڣ\�)w��S�݈nOO��H`\�(3�0\�h�a\�C�D\�w-�\��\�N��((	5�Ϳ��\nj��S�@9\�\�\�\����𹙹\�\�C;Z�\�bY.�-���\�(\0	4寬C4\�\�M\��\0H�=/�\�\0\�a�S\�\�,��\�j#U�ۙ?{�LS�ӟ/P�Nn���/�d��Ch�\�19\"W���ήԔ�dJ-\�\��\0�\0I-z�BDR^�kV�ߤgs�\�\�\"c�ĥ;\�3\r)�*NY!Ź6�\'m�`TK\�\��<�\� 2�6��\��[Z\� �KIR@\�c�\0\��\",\�bw�}\��9�\�*���4��\Z\�O\��w��՝\�`4�$Io\n0bZ�}kG{�#�dܳ%\�b/Q\�\�\�\�(R�7!�\�xmtɀS!\Z�`u[��B/Qz\��k\�Q\��n\�ȳ�\� f\�\��N�v\�\�X	�\nZ�5�jʀ\�\����\�\�ӥݡℊ���\rCG�\�\n��	��QG\�s1�G>pjI\��s_�k+�K�\�\�\0�L/\�\��rrA֙\�^Z�b��))$�s��k׫����Sd\0\�K�tzz�\�6O\�y<�4\n�\�85&a����׼r1�\�!tV%a\�\�ZO�u\rU��\�\'7��\�\�ae��	TվIz(J����\�<#���a\\���1^�b\�e(\�\�ݴ��\�\�p�q�zk��K��LG���U%\�&��\�\�of%\�zσ��14&�\��^l�ˋ\�\��be=\�F,~0�GT\'�x-\�\�C\r\�\0!��AٌX��0�\�j\�9�D��v\�\n�{4P�_�\�Mk_����^k�>�\�\�\�����X��&,}��s�\�\�P�\�\�.�9@�PV��x�W\�\�[k\�*\"�ܼ\�6ޓg��E,\08G�\�\�9��A&�\�k\�xRG�,\�o(�����?G\�\��\��k\�\�lF`�Jv���Q\�\Zk�\�\�I,ğrִ�[9��n��B\�Yō$\�)�ʴ�\�9�\r\�\�M�?\�\�z\�V���n�%dX;/m��xx\\m��{\�)\�h\�$\n!Ά�!U��֫�s1x�;]\�Wv3SV�H[\�4qC6 e��5�ل\�\�$�\Z\�.\�\�\�UIr\�R�Y@R���,6���V~j��M�W\��;ض\�\�j����]ݪ\�\�\� =)K��\�T\�u�\�\nMޏm�/J\�\��c����*S��r\�H�0\�!\r�R	\�L��ei+\\\�*��f\�\�\�\���$G\0PU\��_\�\���\nf\�\�,\r���\0\�\Z5�}>\�(�\���﹙�\�U�]I�QHH�;>\�j>\�\nB��U�����\�h9rд\�*R�A\0w��8�r�ht\�c5�È�p�\r4�\��\�Lܾ)��,\�=F\�@b\Z\���<\�\Z�\�+\�Pj\\3�Z\�T�\� �R\�d\�c\�\�\�*l\�cܱJ�9��vb7�.;\�;\�k\�J4\�GdԔ���Cv��\�\����rQ���y��H�	HX	*fJ�u;0C�\�\�b�\�+\�9\�&\�A`	\�= �\�H���fz\�fEf�]sZ&�C~Z`��$=��\��j<�\�,��\0\��\�\���\�jvg\0^�Qpkhx�p��ӫ��GF��\���\�X��\�{M+$�E֪K@,�p�j3+A�\�F�i�����gLgr%\��\�Ѷ\�\��\0�v���gc\'�|\�\�4\0wR�d$h��I$�$�����\�q\�\��\�6�\�{\��qH��Ռǯ1S&()J`t	�J\0�@@#~\0!��1\��\�.ѣ\��RK�Q��G�\�b�Up����IH�]<���I�\�\�\�5+\n(X�oN_%K����0Ƭ\�R�	\�^P\�Jjm���I\n�o��\�/�\�6K\�>\�\0�7b�3\�\���p\�\�\0_d��\���D�SW��%\�*j9�&h`\rV	Ըc]Z<	&��;=*���}Yb/F���EM\�\�| �\"�ލ\�$\�H\'ּۙ j\�U�\�\�\0hڞv�Cx�\�J��9�Q`�Һ�xÃ\�e\�<:�b�������@g�&\�ńY	$84#�v\�@��\�V�2\�\�L�\�g��ޥa�\�\�AM�\�%)�B@�Z���\�9Ж���S8�ZX\�B�a�i1�\�]�̅Md�]�\��s�4`�\nX4\�R�\�֚5(O�^�M���ߔR xbrHл�\�3y\\��������X �X��\��B\�N�I\�!\�َ��.Vz�f rR�+F�\�0q3\'�5:Oj�f�r��&ŀI:S�8J\�%Sf7\'��\��N����	s\�[0��\�m\�L�\0\�\�Fb(<9\�EL\���~��C_�TF����ݺ��\�Z�.�G]XP7\��,��/��*Y�b\��H9�ϻ% �����b�|d�\0�\�9]\�\�z,@R},�*�\n9zك\�\�8�.jI!.���ְ+ �A=\�ݶr��(%bNR�\�os\�\�\�NMe}���\"Ғr��J�ܻ$�h�>\�3�{e9]B�P6+B\�\\�����YV\\\�Y@�$\�07-�f0\�\���\�\0*\0U\���\�H\�j��\�W,�\�\�W�)�$3d\��1 \��j\� �\\Ù@�\n��� (� \�J)�d�ʮހ\nq;�\�\'��M&c1`ϙ\�)ш\�T\�!.ד\�`�{\n\�bK\ni\�?$2�ĐjÇ5@g|\��N�.׎gj{M\'��֥��ų-LJ}\�2ڊ\0I��O��+�:�(��\0*�\�H�_�}��\\\�.�N\�RZ�j�=4\0O\�O�>8\�\�-�\�zK�WU\�7o\�\�N3f�HH|�K\�)~�M\�$�\�#\rZ�4�ఢ�_\�\�\�ǜz\�\�\�x�	 ��44}.8�h��MJ\��faRY �ԫ�\�5L}K���F\\\�%39�H\�t�g0\���NPb�R¸H\nX�e6�V�\�H@.����T���\���(e\��G]@p\�.*�^B��*\0��-\�\�\�W�t�K*�v\"\�xG�R\�?����ɹz���1K\�i�\0h:�s=�:��=-�0c�3%�\�!�T?��{��P\0\"\�+�\�Wz5S�����?�QӦ	�yY]��*r@$6�jN\�g�IǤT�\� $�#f;\�\�Jb\��qbE\����\�\0�\'���	��$\�m\�ձn_(�o ��h\�\"!!K\�v��\�\�+$\�sKW\��!���A<�!Nl\�UWX�\�[��\�r\�!�&\�zԃ!�\�`h�\r\��7�A~ \�_\�\��2�Ԗ:o,>\�>�BC\�Kڏ�t�磣$R����\�%z\�w	\rx��Tf��3B\�\�JnѢ�BÍ��r,�*�pr$=~1+�w�j�\�\�`\�0\r]\�m�1K�A���\�ш�u��|X\���\��!߈$߮\��3	\0\n9\�XnH\�$�)\�\�ޣ\�XZe~L�SZ\�1�	��Ι��\�@2l\�05$���k\�\�)s\�Bob\��6��Ҭ\���\0�jv��j=\�;\�\�a\�\Z��\'\�/	\��\�x\�/sU6QZ�t\�\�\n)Z�(�J�\�/���\"\�\�����\�*\�4q\�-R���\�H?�ZТ.�\�[ߜ�E\�Qv(MR2��9һB\�\�T\nr���9��Q�X�_V!�\�R\�eZ=�<�����\nV�7g�\�\�?�0�\�\�$\�\�NnV\�T���\�Kfw�H\�\�g̠��H��9կM�DB�J\nrس�n^$mr�����\�XV�8����?�퓦f(qkLӔ�4b\0���W�\�r�\n �S8g�95t�b\n���t\���R�f\�9��!Vpɨx%���\�\�\�\�\�Y(4��B\�7\"@Vaw-QGkj#��\�K�Ts) �k\�\�d��\ZV=�jDw\�W<.�߆�\�?%2BJ�/]\�ƺ�W�	i�z\��K\�k~�5R䒹n6��\�X����\�<\�ŘV2$Ĺ��l��}\�\�**L�*vNbQg\����SْHa-)M*��5\�w�x����80<8dO�\��\�/?�	.W\����5e_⠥!�G7��\�v7c�3�@)��ak\��\�4ur��\0� 0c@(\\\�Bj��\�\�\�<�^\�4D�-����L\�\�\"Z\�+�~\�X\�!NI�\�X�n\�i�\�-�9rh0�m\��\�u����}\�Aw �\�9�1D^=\�2\�B�\�-��km\��(]�{C\�\��\�\�\0\�}�\rZ\nJ�c�4�kus�q\���Mŵ\�}H\�cE�a���m���\".p$����mz��JM	�M;\��sh\�R�$�\�;كy�H�q5y�\�\�X��\�/G\�\�\�\��A1f̠,\�zEL�\���a\�hX��ge�\�3\�l(�\�<\"{��E(>�10l� _M[_�Y\�W�\0�\��]6�\nXKV�Љ�\�Y\�}�?~��3�M�\�\��)S3\�\�U\�\���2jvk���\�a�b�1��/�K�`�9CM��$��zWoX��P��foH�Ƥ4�\0��ņ(�1Eݚ\�\�k|�$�r�\�OO�-je..4x1,QY��\"-JM�=\�a�GW9�B\�\�hK�RH�-\�JW�%kR�M��XN`\��K�n�\�NP\�M\�X:K6�]��\�C&2c`.�\�\�P\���w\�AV\�2M�1�Rd�>���\"ĥ;\�\���3F�5�\�\�\\��aD<�-Zry&\�\�ZY))w�&\�\�\���e	�]�\�1�)�\�Y�ōCY:D�\�;o\��;\�x���/6\�}\�\�\0�6f\"�\�ΰ�)\0)�z��\\�iԻ] �\'���\�\�A�fQ��q\�\0@d?�\�\Z�I*^$fSu\'`\�\Z�\���\0G{B\Z��BzA\�-���z\�ٌh\�P��tb\�Mc0үT�%�֢D�\Z�\��/�hR2�J\��Z\Z�>m?Xz\�UD�D8\�\��xT�������\�5� �5z�ѿ�B\'\�n�7Hg���b\�\�೻:Z\�Mݢ��\�3\n;�m�\"�S�V\�(��\�\�yB�\��\�L�8@\�MM\�j	MM/F�\�	 \�\r(\�<\�D\�.Gb\�#b�3\�\�\�\0�j~,5�h\�n�\�l�\�\�Z�`\�|\�(�~M12\�AA\�t\�0e�\�	���x[�g �\�\���m\�\�N�t�\�X\naF�V�\�\�	\�NJ\�j��a�=�\0ɥ�8ݓ*AQ$X\�\Z\Z\��\�L�\n�\�9RX�\�3�|:\�<�L�\�\�ՓΫ�d\�#��(�c�\�T?����FBR	gk����INT�Q3vt��D���\�Z\�\�y`!Y��N�U\Z\���<FN|��\�\�VH���M��\�RC(�%\�I5М\�^�if9�!�\Z�hz\�e=]\���\'M\�\�&\nZB5%�Qĭt:\r\�DD\�闧�\�X��Y_(X\�\�V�\�\n\�J��\�\�\�\Z��\�\�\�f.�|`V]*/E\n�\�~���\�z�:ݪ�ꛙ�!.\�\"�[}v�����T8�,,Y<9MT�`��M2\�\�%\'f>�a$�^ȵ��K^\�~�\Zs\���/\�bE�\ZE\�r��\�x�����F����\�D�2R�qNb\�?X�(g<\�HHH�r\��Ixa��o�a��L���\�Y��*\����-`\��αylN�(ԣ\0䁿7\�FO�3\��|��L�î�*v�@ \�\�k��@H`n���|\�r�M����/\�Hf�%Q�z�a+�\�I(�Ä3��(\�\�Z\�\�L��\Z\����T�)�\�\�M\�D\�0PHמ���Sׂb2W��\�8���k�Iu�Z��\�\r�z����)���J\0�M�\"p?	P9C9/x#��m\��ͳ�e$��\Z��\��s�\�J�V\�H	\�%����B�� hkN00Y�	_9mf<\�-SV\�\�*\�lƃV��FU(�\r��U\�{T}cETI��kR�����\����\�8\�\�\���u�\\�YX�(&�L\�l�6X�)k\�RM2����E�#!HR�\0�{\r�x�)H��C^+f	\r�\0A�;\�|$6YQI�\�g��\�$H�I���\�7H\"��Gx\�RTr��%\�jl�rI)�T\�\�3&��hH\�᷷�A�Q,�y�\�\�M\�\���\\�,�\�݀w&F��\Z�\�F��\�ʘ[1\�\�����&� ��\�\�+�\Z��	�h,�V�\�\�\�_�:O�\0bXT\��8�(���ԩ���P_�e3TPsfl\�\�@\�^�\�O׵$��l夨dvQ�\�\n�`K�h�Is���T���h7/mjD��\�Y!\�9�V�J\�\Z��\Z�$%4mJ\�O8`\�\�k�6V�\�#�g1`���\'P:\�h\�e*R�32Tj�K�Eu1�cf(Ț\�̴�\�pE\r\�:cV�B�)A�\�rr�-Q_Xh!!Ɍ��X)*j&�\�\�e%e\�\�Z��3\r�\'0\�%A\�\��ظwpG\����$��-��2j\�M�x�\�a��Q9p\r��go£\�\�\�\�?\�\�멦\�qĦ�0<y¥e�D��\Z���\'+���9a�*^�\�5!I\�-Y�ZYg9�)�$8\rG��7\�\�PgnV:�\�?C\��۟�\�\�B@H*\\�K!\�nI�ЗF�̅s\�k�J|=a�S]�r�(\�\�e\�\��\���F`5\�9\�FdAϦ\�M\�\�	�\�ҙ� f��_m\�$ɕ\�g\���\�ʐTn\r(t��\�UBsi]9\����\"\�+0+��E..wɄQ\�Z\�xT�U@���\�)ivcMz\�D| 8~~�u�J�L^\�?8$M�;�>p�\0j\�o��>�S\�\�\'d\�\�!Z�\�vas\��Q)�*|b\�\Z�ݩY�R~\�8��\�=���DQ\Z\�\�\�X��$��S\��a�;�Թ\'j§)\�ME��5s�1is\�o\"\�\r\�\�^�J\�*\���)�\��ۘk=/?�Z�\0W\�\�Qn���\�=\���L\�hÀI\�_m	\�\"\�؄��\"\�o�)8�̱Z�\�\���]\�I$\\ݠ�,\�?g絩U�7G1R�@e���S\�\nC��\"�\�\�A�!O�@�Kf��A,\�M��/\�nb{�\�5�������\�Ňt�\��*r�\�A�\�\�%jʬ�	r\�\�J4�e\0���\�#�DC�\�)�\�$�xp\�N�\�o\�:1`�C�\���K�9s@�b:���\"\\�f*(eQN*	j�͡k<�u�L\�!\�\�\�\�U\�\�h\�\�!J\n$�����N\�!\�֠X\�4���N����(�\��s�Fi�7��ΓJ!\�*\�b��IW�\�䃕\�A�\�ן�(��	j����\�\�y*^Q��	S��\�\�\�1dt	��b@\��O7�\nI͓�ܚ2\rXr;FLL�gI K$Ҏ�r6�x�(\��\���k\�\�s\�\�l\�A�߲bPS�Kj�ėm��6~Q^\�\0C1����\�\�R�\�QH�QBN�Hzq\n\nP�NP\\%@ϫHQy�J��2��Of�HНm\�\n���	�URT�Hڤ{ShZR�TIR�j\��ط`��ȩ�9����8�!--��\�[B҄�΢\�5}�4\�K@\"@QR�����Ѕ\��`\�\�dɔ)QB�\�\0;%�1\Z\�\�\�hXX�-:BL\�\�V\�~�O�\�}t\��Y�,�*j�	RRX����\�\�Q�\Z\��	wsP��\�5�\�$�)\�)/W\�H�ji��\'0U�.�\00\�\�%#��u�T�����ۗ�H<Q�\�u\� ʖ�\'aʕ���P���P���Z\Z�\�\�QPcT\\F�hŌ��`���ZU�\�3L�\�9����cb�ʖK�>o\�\�^\�X~2�Zr�Y�o4C�b��\�󎙺zD�\�\�\��(\�nh�\�*m�\�\�Ą��y��T��\0��F\�\������ؕIOUB��\"D�CXy�\0�Z\�f�a\�A\��\0���\"D`�4\����\\�\�d�\�\�$,=\�Ց���w\�1\�G}=b�GW�\0X\�U�\�s������=wW���ˇN�T4���\��\�u0}\��\0Q�\0dH�كS\�Kc{�6�ʾ�\�\�w���\0\�6��\�\�=>��\'���pU5�\�F&\�诌%V��_8�#�*��S��d�\'�\�އ�\0Xo\����~q\"B��\�z*�r�Zq\�\��b\��Sҗ�\�$^Ǘ�Q�o\�,�%LAa\�_8�\"8��\�V\�r��������\�\"\�C�\0(��$���\�>�n�8�\"_\���X-�z�\����A���8=��F\n�_�\�'),(3,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z!\Z\Z\Z\Z\Z\Z\Z!.%+!&8&+/1555\Z$;@;4?.4514,%+4444444444=444444444444444444444444444444444444444��\0\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0>\0\0\0\0!1AQaq\"���2��B�\�R\�#b3C�\��Sc����\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0)\0\0\0\0\0\0\0\0!1AQ\"aq�BR��2�\�\0\0\0?\0�Fe \�T��\�ne\�\�R�\'Ae�\��Q�QAa!\�\�\�\ZT\�\�\ZO�.��\�|\��fRΘR\�5k+�\0�|�_~��ؤTV2�b8;AJ%���\�����EU!5\�p\�E\�72�\�p\�mt6\��\r�aF\�:��cb[����ďD�7aH^�)��D\�\�\�+��\�=Jg�\�?Lj\�\n��+	��*3�i\�\n\�;��$�w$L\"��Fʊ�b5xK����\�\\\�B!?\���R�\�ֽQ\�D\��J�\�E�\"n%BT\rRtWӧ\�H\�*�Q�Qc�\"\�=G&N!V�:\'bq�\�f�\\��J\�~�T����̭G\r�D/\�?�	\�Q�\�kK�@�\�xg����/�a�K<-�}lih!�	U�Ȭ\�`~\�$\�왳\�l�g}֎�3:j�/�`mB�(�\�\�+]\�D�\�3`A\"|�_�h�s}Bi �\�D\r\0T;ٵѦ�\"\�o�CԯL~�\�d�Х�\n�j\�A�B__\0�=\�\�ePr��\"t<���l�\�\�a\�$��e��#\�i;�9CZ�\�e�\�z�>S�\�?($�m�h{�u�)�\�Q#�Y����\�#\��]�P	w���2�y�/nr��]�5r�\�\�#]w譯A��xě\ry�MJ��>u��9��1ŇS�\�y�K�̯�a�\�\�$�\�l@X|v-z�l�\�;j�Md�+5s �UEFD�(ꔧQy���p�mt\�h]V�٩1\�Z*=�\�+K��M���4M�2:#\"�,�R�u\n\�\�h`q\0ΡQQ΀փ}��E\�c\�;N\�\�{\\��\�xs	�;��9r��o�$y�p��#���\0\�\�WPv\��\��%�	��\�b\�Ai\0�N��VJf\�{�xLy!�p�������h\r\�*UI �\�9<r�r�\�TS$�\�\\��\�\�j\�\�\�\�\�\��ˇ\�d���\�w\�$�\0\�\�RgG�\�q/�\�GxP<E��\�\�x\���Uo�]\��sJ7\�j=<Q�\�\�W�挙����Y�\��\�\��+[�i\�\�ޫ\�N_\�N�����r$�\�\��-&\\Т\�?\�?p�`\�\�\����\�+�O�J\�3@gQ\�\�v��4\0�-\0\�\�P�\�Q�\�\�\\m\�kh��C�\�\��́7\�E|#�8b\Zo\�0\�o�+p\�C\\\\\�\�8\\sU�f2��7?t\�\�\r3\�)4�K��\��&\���裋s�\rv�2:��|C�X\��υ�cQ�kIU�\02�\�\���N\�\�(T�iЅ[\�t\\%K�{�t9\�T��pꄐ9$8�cN\"��\0Y�Z!c�,\�\����\�L�Ӕ�E(��0}V��׾\�;\�%mS7\�+�ԖȲ\�N]��\�M�_]��hI�~�%\���\"jk�\�\�\�Um-g\�.uFa�s��{�\�i/h\� \�q\�ZR͘6\�䧌�6�D�n���9�8ߧ%�گc\�wcƂW^�\�\�uk���3\'HU�xl$\�y�U��	a\�-�H\�1\��]n�/��q\"l�B�\�d\�h麽\�9\�͊Y*\�\�\�\�\�\�`3���.�;\�?�Q�P�me3�vf\�\�B�����74Á��\�h�\�;^\�w��(_0]L\�\0\�o\�\�1X�W/KW�^+\�	����=\�Z\�x�\�>�\�\�J�\�\�6��\�w�/ ��<\rS#0س���T��ř�i���\�\�\n�\�C\�d>,\�>�\�G��x�CЂ\Z���GQ� \�,\�U\ZX�^\��\�K`\�\'\�u��{��zW�}϶!�ñ���\�۽���k\�?:����\��&J�\�-n�⢹D\�\��ů�j�,E1�\0ȡ+�w�|\�m�O򟵍v�\�\n\�@�\�e�*V�\'.\�~\Z�\\;�d��\rw\�/\\.Q�\�5ZZBiy%O`k��u\�t�-\�*7`�ᰞ)D=�qi��G��\�\�.�#����,��hu�y�0�\�H�+���{@s�=�\'\����\0]\�o\���Ps�I\�F�\�\�X��\0\�/����%�jT\�I\�\�\�\�����T6֎�\�\�\\G\�Sc\��?��\�\�=\��k\�\�\�m6����\�$\�\��\�\�\�\�\r\�\���}(�YF�W\�\�\�QV�\�\�{\�\�\"\'TK�,-�\�\��\�\Z���u.Qj�p��Mp��\�\�\�Ү�f-Ć�\�r�\�)\�`\�Qm�<3\��+\�_\�a��@\�J�=��\n\�J\�K�d\�O8\�0\�\�Y\�\�HB\�5\�J\�qf<Ƅ���)S7\�}:�8�B��ht�̎]B)�g��\�!���7]\nI�U��H�C�\�f�M�\Z�\0dŌ\�t� �Vbpa\�Z@1\���\�t:^\�@�e:Ur\0����\�q4��\�#�n�h�}���@\�򲧈\�\�\'_5\�J���ת\�V*>����7�����Ϛ\�h$F�\�\�\���h���_�\�u$�,\�\�\n؋��G��?\\\\\�\\l:g\��=�|\�rY\�QQq���\ncH�\"5L]S-�P\�݀{���\�bt�,p�\�V�\nU9���X|X\�#��n��LrRpU?\rS8$K�\n\���\�@��0�XB\�qJ�~!�pl�8�\0P��t��촘	;��Xj2�]�\����-�.\�bO�9(\��R�ٞ\�jN�z,�\�k�\�������\��TP2�\��\0�h�3f#\�wN!��6�K�~Бa\��i�m`qu ��\0Ѷe.\��\0\\���\�Qy�c��\r�.�\�t�N�OC���V6�n�i\�#M\�]�F�\�\�ihЏ\�s*H2�\�\�2�H)96=���*�uL�8�v�5<��W�\�/�}\����bKZ\� ���\Z�n&�\r���6�|�!�\��Y�_#�\�4\�<�\��HY8\�y\�\�\Z\�K�K.\�T\'\rZ�!\�\�_�?\�\0\0h��SH�i\��pKnȎD��C\�� nۭ\�7�\�S.[\�k\�֤��\�\�4�͵P�{ZHs$H�\��i\�\�\�\�k�\�Pǉ���u�eh\�2���1\�k�\�\�UNrm�\�H2�\�\�k�\�\�/À%\�t�?9�(\���kw\\��LN�rC>�Q�A.0=���\�Fm�aűD\�G\�\��I\�\��La�6�.��2.S>\�\�\�=N�i�\n�AZ\�+��\�A��\���\�\�d\0w\�|�\r\�\�bVρը��6\'q\�K�6\�C�\�\��\����(#���q����s�T/�*=Ώ4\�y�\�~\�\�e�1Ӕ�U4\�P��N���)\�$s \�N]s\�bTZX/c\�j�E�y\�Ϻa\\\�\�*_D�u�������腖�phy:\0O]L�/\0i2���rU*/#.wD\rg�EN�\n\'i\���ÄL�`X� \�T�o�^,��=R��~ia��fR>�h ��\���b[\�KZ)��\�A[E\�\�\�\�\�\����׸�\n�F�\0I�CO>I\�\',L\�\r�\�O�qf\��H\'i\�s�meg\�ˢ(\�\�d\��!\�qᶷ�!\�p:\�\�\�(�\r5\�,& D�Y,w�b�p�#Q�-xsH�RZ��\�\�2�fZ\�ۀ��\�4\� �L�\�\�fhW��L���?P�v�G\ZF�R鳟n�7���Qvf�\��\�f��\� 9\�t\n,t\�\�R\�\�Iиߑ[6ҲP\���Q���\n\�q�h��K��P9�F�ȌHij]0�-t|\�^O�2����۠q�_��6�;A��#�n\\�\0�役��eN���\�l�p��\�\�z�+pOXׯ��Z�\�q�I�\�w�T~5\�K�\�\�h\��#\�>\�3�E\n\��U�X��3�\��7��\ZZ{7�+OVM\�FN	e�+0ik�p\'���W���1��K[�Ѧ\�`\��E\�1T\�1�/n��\'O�pj�e�6uy�&\\7�\Z\��\�ܹ�1��\�\�X\��ؓ�=��q�Ƹ\�\�sA\�ϲ�n7\�%�\�fV1�9FۙW�>P	\�UIو\�V��t��\�nݲ�׌�G\�\\\� tK�b�9��\�EjVK���\�\�v�\�y���\����vG�����\�\�>\'��c�L߶��#�/Ҥ.\�<��\��F\�c�����z%�F�(�\�h\��\�\�D}\�)\�c���\�\�29\�����\0:+x}61\�\�q���G��*|��\0m�ѩ\"��;����\�v����\��d���n�⡪Ǐ��\�	��:�ŲK\�]\�DJ\�\��ˠ�Ņl��8k#~aU\���Z]�&\�\�GtO\Z�\�&�Z\�	\"\�Ous�^*�G\��]�OO\�N\�tĒ\�S�\�,\�S\��ۛO0��\�	/-vYi \�.?�w\�?�kc��7\�#8\�?Ԩ\�\"!\�h\�o�݊I].>�WO�T��tVb\�8��@�A�Ҧ)�#E���<;�X�&#�y\��P{.IA\�VrN&���o�\nL\�x\�g\�$v8\�\����\��qF]?��<\�\�2j�8n$���G�u�\�\�AY�+��V�hM��\0ʻ��:L:\�u����\�-GsTgx\�\"^�G\�(!Sñ�\"d�\�U�����n\nIZa%gJ�J�\�\�p,gܒ�@��Nb\�--��\�\r,3�\�։%h8�q0t�I0��M\�ťq\�\�m>Q\�ɩ+A\�x)�\����\�%9�\�\�F\�\�Z\�4��ԫ� �\��s\'�d5:\�\�s\�:��ѻ\�2\�\�aN\�^K\��\08��B6���[���D�\�N\"ʢ\�\�\��n��Q\�]�\����I��\"\�\�Ya�ߨ\�\�ߚ���L\r-�4\�s;��c����`�\�R�\��\�\�ܦ\�j�/�\�ǝb;�;�\�\�\�@��\�\Z\\�6k2��T�\�/t�f��®�pqN\����\0F0\�H�DϜ��\0:k\�h����\0u�cs�i\��&\�\�x\�\�Hvo\��: \�=\�K\�\�\r\r��U��j\�K\r��c<=�u\�\'X\�UX|0�n�@�L��C\�\Z�5\��\�\�?\r|����}�=���\"X�\�2\�9\�OeT�ȭ�_!�n�y\�\�P\�8f\�5R}RFV4\��\0}UW�Co:\\j�mD;|uM\�}�\��nM\�k\�l\Zlz�M��f&\��\�8�u�~z�\n_*���\�z�~\�e�{�h�[=׏8=`���\�n#Lb)g�\�vX\"`�\�9#\�Ə\�e\�foy�,��\��\�\�,s\�̱�@\�ܾ\�H�\�!N/�gL�\�n�\�U�f�1\�+�q�\�t�h�O��%-x�ӧy\�\�\�8��8U\Z5�fL�\���\�N�0z�\n�X��s\'�>h�1�eR�#\�\�v�uN)��Uex\�� n�#��<0Lv;�fV�\���\�\�ܥ�\�\�QT:\�|D�ZH0\�\"E\�I�\��\�CD�T>�v�Vƫ\\d�F�鋦xF��\�B\rD��\�\���\���ήVo\'�5\�\���\\�v��}o\�:��Z\�1�Hڳ\�~h�\�\�}���\0	?�e!ߤ�T\�\�A\Z�	�t\\\�#\�H>\\܀a�\r��\0L��\�[\�M����V-\�} (�\�V�\ZtY�\��æz\�\�\�\�,\��7�ۘ\�:��g\�W�D�\0u���mt\��\0cI2\�;&15)غG�����31�\0O#�\\\�\�\�f:\�)F\�\�I�\�鸬\�\�$*jpƽ��vY\�~�\�Vb.\�WV-�*nu��[ek��\0\�/3\��l\\\�u?�UWŴ��4��a�ΏA\�N\'\�\�\��h>bO\�uj\�&f֘�c��\�\�\�EP���Ց�O�o\�6 [�zv�n�-�6	\�uo\r&�W\�ͷSq\�(�.J\�x\�\�\�5ٲ٤���O\�5\�6k]\�=�X�<U,�\�v�}L<\�Ncu\'O-\'g�[�\�t���\�ʰ\Z\�\�X�E\�3;�\\\��Hh��w����\�:t�ɍ\\f\\�\�\�\��\�\rI�R�\��*�Ë/6h��\0�II\�\rg��\�\�g8�)��C!�\�?t벜5���GUk+䝩rlq��\�\�\�\�dHv\�n�\�\�Kۑ�-i��\�r\n\�\���`\��6\�,\�i�I\�Nk=F\���A\�p\�}#\�tm:�]:ȪU5\�\��m\������iV�rې�Y\�5SW8\ZD�:�t]\�OTѓ2_pF5Ƶ0�\�o^ag��P�ȶ\��~uMx�g�\�\�i\�\� \�]�y\�\��\�\0v�\04�A�s��跦�eon4E\�=�9Z]\�\�<n\��L�\0����?�\'��$\�ml4\�:� w\�?��{�L����.ʅ�TQx*!\�\r$[\�`\�A�U5�\�t�\�!Y�2r�D\�K�ftv���9K�L^S \�ȃ����^6��F��\\�\��\�\�s�\�my%h�\\\r\�K\�LX\�\�\��\�RN\\\"\�\�\�W��G��\'[�yL�\�\Z\�\�k\�\�,5�dŢ�\�מ�i���\�\�^]����\�\�rc�T�\�4F\�\�\���&K��V\�\�-�Y\�2\�G\�$\��͞`\�\�e�^)�\��J\\E���\�t\�__dC\���hm��_<\�c\\\�j=��s�\���=}\nMyj14Q�\�SG��R4\�u�\�p7\r\"\\p\�<v\�5�FR\�\�\r\�M�~\�\�2�p�j-I�)�\�w�y&X\n\�{\r3���Z\'QcÃ���`aS��Rg���&5���iJ�5$[�^j\�E\'sCn/v�\0#\�\�Ķ���s\�\�o��e�´�\� �\�;�\�\�\�y[\�<�\�`��b�������.2I�\���\�x\"/\��I1%\�\�;^Zz\�\�\�1����\�\�`\�?\��AY/o&�e\�_�m\�\�LIn���\�\�:y)�i�y�\�%<7\�VdA7�q�eA�\�\'��~sK>Xc�g\'�u�H1\�L�#^�F�1-},��]\�\�s\�D�6\�\�5Wݎk��\�J�n��Ԅ\�Z\�a�77G:�\�`�:;U\n\�CE�\�\�\Z-��%\�ǁqFQk��\�7\'Q �\0J����\�i\r&@:\�I\�\�)\�\�\�\�J��dG��\�Q��o!���`�<���1�\�\�]\\\�\��B��J�3#\�\�\�]7�Y=(��tjp�\�3f,6��2\"w�mrV=�\�r:�B$RĽ�\��V\�t\�xW�	E�c-3\�N\"`8LXF�h��}Y{r6$繑&� \�yGp�F2r��B\�}4\�\�\��7�p�\0�\�4\�֓.\Z��|Dt$��vF8�Ɋ\��d8�1�^[��n\�\��l�\�p\�\�\�_A%l\�\n\�S2\�3#^�^���\�L���\� s\�\'�f��F~�,my\�k[\��q�\�XzB[x3r\�m\�\�G�0\'��\�\�V/�;�\�ӯ\�Tb�C�5Ux�:C+\0h�=�C���P\�\'i:_\�\�c�s\�$\�aUcH;�{̸\�\�RIU\�^�J��\�\�ː0Ҽ^� \����b�r\0?\�H�\�\���T\�	˧��g��P�\�$4jU��I\�\�Ν�W3�8~k\�giq���\�?�iЏ=���\���L�߯�D\�\�m1&?R.\�����\�&/�%��o�\�0#q�\�?�H�\�pb<�dy,�]�>\��Smh\��\��\"�\�R\�\�ۈ��\��Ր.cC��\�e\�b�\�w;=o{/_\�r\�5\�Jb�@�4��Tb\�x�\�c7\�\�\�\�\�\�8�\��\0)+q�sG+~~\�\�8$M��/N�R��f�\0�\0�\0pP�2������0GP?4Hݏy&�1��\\\�s\�\�\�\�\�+�r��\�>����u�\�u&p\�+<\�\�`�{\�$;i\�:]E���̙�7\�U\�U�]�UA\��\�=I���\�A\�)�p\�rt\��YQ�u�N��\"eU�ؒ\�M\��n�TKɮ`��!����\�q��\�f�m#oq\�xǉ\�\�1%;aC��l�\r�*qw��\���:\�]\��_Y���\�\�h��.�%\��\�\�i\�(W�$�??,�v.O�z�@B\�^N�\�\ne���Y��$�I�I+\�\\�$Ҥ\�:(�.\�\0]L\�H�4\\\�~~~]H\��j�RJ\���\\�P�W.\\�=\\�r�9r\�\��>k�ED}\�.I�4X*č6\�\�H>F�\�~k�&#�W�m$wReK��ys� 	�a~Ӥ~l��I7��\�ò\�\�\�D��\�ۖ\�ϚD\�9��W.@1\��#rT�dI\'y�\� .\\�<s\�/\�\0�b@\�{�˕Q\�y�.�ܠ\�\�@�d�\�r\��1\�x\������$ƂX]+�!\��r\�\�&\�\�.\\�:W�r\� Fz/W.T�\�'),(4,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z ,$) %6%).0333\Z\"9>92=,2302*$)22222244282222222222222222222222222222222222222222��\0\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0;\0\0\0\0!1AQ\"aq2�B��#R��\�b\�$�3r����\�\0\Z\0\0\0\0\0\0\0\0\0\0\0\0�\�\0*\0\0\0\0\0\0\0!1\"AQa2qB����R�\�\0\0\0?\0\�CqV�f�\�S)\�W\�pk\�\�sg�d�k֚\�z\�V\�\�i\Z��W�]l�#�WLT]\"�U�sE,\�˽�\�㸪>��G��\��5\�K�hͭ�\�C\�RC\�SM\�*܊���\�B�.\�\�Oޘ��1\�U\��W��jɤ\r�A��M�\�$F;P�\��\Z�BU��j.]���cCf���:9F��j_����\��PVX���P:m޴FԂ�6!\�~J�b�O^Ԗ3\�G\�^�\�\��sW]zS\�kd��\n�\�\�ȡx\�\�.)t\�#)��$げ����\�ߵ*˞Fb�g,쵒aiK\�c\\ʊ�_{\�Q#��Gj7\�k�)��t\��	���\�L8R��\�Yj\�İ؊�`|��e\�j7&��\�Wj�4`�Z�b�,R\�V[޼\�F\\mVJCl*�%V��X2\�\�@\�\�Y��و���\�#5ɰ�1P=�)�I\�l�p�Q�\�Ԣ�ě����r:o��\�\�/j\�\�\��6�����Z�\�@95\�\�Ԗ+��ު�eAf4#l\�\�\�\�XQb0\r\�\n38׵x��d\��S�B�\'\�5\�Koj\�	��ݑ\�Ɩc\�E`#\��Aː\�4:�l,9�0\�\�M�װbt�\�lh�A�]\��bTrmU4z\�\�bp�I%����\�\�5zͅ{lj$m��\�\�\0��~$�U\�M\�ũ-�Db\�5\��$mz]�I�c�`(\�\�\�@\�\�\�5�\�H#I�U�\��\Z\�4���ږR�F��$�g\�L\�7Q��s�D��佀����`��o�\�x\\\�\�RN\��x�瑔Z�{Ar\�L3(%G5g\�j\�\"���]\�\�D�wa�\�9\�2e:ŋ֭��uެ�\�^��T\�2�\���#��A�1��1ޒ\�\�+/��\rM�\"\�\"�x�f\�A`��\\B\�\�>QlEȭX��Xa`��nk\�33�\�Z�\�`\��Qҡ��oūW�5\�nH\n\���i;\��xTA�H�96%HZ	g&w\��\�\��\01�OcĂJ�ҏ�y\�нٗa��\�6\�\���\�^Ø\"j*	\�&\�B&&ƇtT>�(��^c]x�q�O0X\�iU \'[+�	�Z�B\�\�caE�1�^E,\�\�R\�\�?5���!h\�\'Wp\�c\�ޓ哫]�m�\�D�k\�\�l-$u�\�\�\'\�z�T\�w��g�\�\�۵=\�e��W�	M\�Q9\�1Y`��܋^�\�`��\�N��[Uvp�檿Şl�\�KFu�\�l@�[�\���Fc�\�\rȚl[z����Z2�eI.A�\�jfX�C{אcc�c\\L\�\�\�\�\�PiPk6`�.\�k\�Lf\�E�*�\��>:P9&,بBi��\n�\�7MW�u\�|{#X�5\�J\�n\�4�f��\�\�5*�_�\�K&�6��q!}�\�dF5\ZE�3\�f\�ϊ�8\������\Z��L��/�\�Jf�U�rzV�R\�\Z>\�O:a\��Xڨ�\�QH/zU�\�g�2�\�\�I0�9Fr}\�ո�5#E�\�\�oToc\�T\��eZ\���\�\�ƭw��3y4j*mR�$?\��\0�M&��=Q�,�s5���U�|m&\�\�(\�h�k�\�����q\�41�*�T>x\n\0`;q]�\�31�$SG\r^�\�u\�\�@t�\��.j�f.�m�4^[4QF���ԟ�\Z�8�@\�\�	ԓ\�F��`�\��DϢս�w�\�O`,Me��\��T0\�:ikc�F:�a֝Ȥه&\n\�ŨR�X�3��\��z?�5\�\�;QX|4c`�{\�2\�_U���A�*\\<Ikڈ���PA4\�w!\�Su7k}\�h�C�S\�j��}\�鿵�2ܙb��n�\�Py�倨����Q�|w���kؗK\�QE�j\�]H�\�#�\��lE�\�\�#\0���֚���+�\�ŷn\"+�b��\�\nڮ\�|XTznPx)&��q\n\�ζ�}\�Ir8[u%~�~�dh\�U+�=P\�*�\�Ů\�!	_k̼*\�\�2O\��P�L�L1�\�\\�\�M�Y�\�.v=��rΌ=B\��\�\�\���}I�ԕ�\�;%\�W\�1\�\�L\�\�S�/m��M\�\�\'P��R�NQ\�3�YcEM^��&d�����8\�|�?����Yn!�G7s޹Ӕ�����&%-e>�\�e�\�Q}\�\'\�\�h�\�\�\����\�K�A\�hǴ<,�ه�+G!���*z�kڑ\�tm\�M�w�˜��	�Vm#W%cL\�6h�\�x\�2��Ě$r\�b=\�#\r�+\�\�\�l5^\0q9G\�0�\0ޛ̺#\�˵�U`�EE\�\�ڨ\�\�\�R�\�QO	 S��^Ú&�H��js��$\ZSc\�K�Ό��\�\�j3/��!��\�޴�\Z,�\0c���_�\�Yn��\�c�\�\�ҋp\�\�6�d��\��Q�\�(K[\�b8.9���B���M$\�\��M�\�\n΁�ϼ�P��j�\�<$L*.y�I�cc\�6\'Ør\�\�\�y�\0��\�\�ŹS~\�\��vk\�젒ob�z��,U\�\ZS\n\�\����,�I��\�.+P�%\�|S7�\�I]\�\�8�4���k-�5\�8T]ٯ\�zʮg�m\Zcr��j�ǭ��8�)�Ia*�\�O�\05E\n\�@w���b]\�c��-���Y\�_\�\"+�n	\'\�f�\�$x�F�kV!��0��W�X\"��bG\���\�Ҷ�xF�\�ʪj-�\�oaC\�%]u�!\'b8>\�i��&7a#r�nN�\�_�\�X��)\�/��{�\0�{\�\n��C�\�lG֑���7?�\��S��d�\�`l\�ڳm\�S�\�_j\�\�ع���jl\�$��*O\���s{3N�\��Fa�6�)\��~�\�d�m�\0�~��&\0\��y&Y\0\�\�=\r\�oj	�KcaK\�Ż�\r\�\�?�O4����å(�;Pv\�\r�\0jBs9<\�\�\�9���=�;���{	3<�\�srM�\"�\"��\�y�\�\�\�]PP^ñ1\�V�~\�Z�Ln%SQ�\��/n���24��2�\�\�y�\�&2i(n\�k�\�QVStg\r\"ܻ���Cױ��\�P%a\�J�z�\��E\�2\�$g[z߹cn�/��S�\�K\�\r��A\��\0����_ɗ݋�\0��xY},쥆�T���|���> \�\�\�) ����YZ\�q(���ɽ�}\�a	uG�\�J*\�Apٴz�nMx\�,,\�X��(\�\�¢`<�\nGQ\�`L\Z��\'�\�B})\�hh\��^O $�-d���R2u\��\�s`C��X٬zmaH����i	\Zt\�H\�21A(�\0I\�>i\�	�M \�4\�p��r-ҙ[j&�\�`��6`w\�ڴ�LR\��\Z\����\�MaSԧc\�)}\�\���\�Ծ\�hT�\�\Z\�Xd�\�Fޒo\\\����^/[v��(^��h�\�}��\�^\�jŹ,�I�\0��}��96D65|\�!a��j\�LV\�7\�Y�\��4\�K�}�ԩ�(�\�?�JN%9\�ڇ���\0j/*D�d>�z�+�c7c�3�\n\�$�]�\�?ɮ��I˹z!\�\�%�q�\�\��\�\�O��\�9�q�S�\��6�0Fj�\�g�8\�\�+\�1�v���\�W�W�Ӎ\"Q��\�\�N˦5fK\r\�I\n:^\�Sr\�\�Eu�}[\�\�>G&��97�ǥ��:t�<pj\�\�LGA��t�z\����t8�e�T%Dywf]\�>\�{U��%R2�6\�/��o�I�\�1R�\0P��\��\0�՞«\�N$�ܑ��o_͸\��E�*B�]͎�ٚ.��\�\�5�Ϡ�I���֡4�If\�\�Óo\�*�ἂ��+!@.�\��\"�\�Y>f�\�ya�6[֌�\�n\�P�R\�O����ܣ\�xhc\�:;�\\����<(^�\�K��Fhcx\�\�\�Khۥ��\�Z\�v\��\0E\�W~\���\�k�kpA\�\�O\�\�bԗ�^O\n\�#g����l\r�۝�U^#�`\�%\�Ԍ�?[�\�\�\��\'�.\�\��Ja\�\"�\�HT\�\�\�\�\�\�Lq�wP%�)]v\�\����^��̋2|H\�\n�\�\0Kocm�\�Af\�90\�]\�\��q\�P4.\'22a0Ϊ�>�5��D�j���\�ď��\�i\�\�\�~����\�jM�{\�\��\�ߘ�G\�Z���X��_�6�\�H�:�Q\�X�#T�\�K\"�k\r� }ɡ5��\�0\�P�.��-\�s\�}�N\��:��b����\�\���J�r\�>1$%��\�\�T�\�<\�\�\�<���b\��~\�t\�K\�\�\��}L\�2�C���oI�L�|\�%rQK)\�\�?{\��¢�.{��m@z�`G�.jJ���#�\�vK���)\�M��Q�C�\�EVR7.)>Y�Ҋ�u\ny~oj\��\�l+\�\�\\��9e\�i\�+\�#`�\�K�\�7�\�s��\�x��q�\'���,\�\�\0��\'(�v�ȩq\�\���\\E]\�\"��\"\�<\�Y��58+�\�>\�ǚ0˂�� \�\�\��\�l1\�\�\�\r�ک\�\�\�[0 �Y��\�E�trm\�8�\�m:~�\�#�\��N\�ng#\"\r\�JB3�i=li\�5_@\�\�Q�]Z\�\�\�\�n\\P�a\�	\�)%���\�wI\�3\\L�;�\�O�X��ԟ\�\�֒\�\�\�ɔ\�đ{*Sh�J�pkf�\0� \��\��VG\�Y�!Yc�ܟ�y sA�o\"��6\���kP}\�?�z�\�Ìpqqj\\��ü��9��R�[䝿zi�b\��\�d��a\�6S�\�i�\�E&\��X�\�R|\�	��\"c���\r\�e\�׷z\���N\�Έ�T�ɛ\�3G\�&�*�R\0/\�A�o\�YL��\�\�jfF���\�\�bI\�\�lkR�ۃc\�\�\�Ҝ\�\�`�J_F\�K_\�n\�\�RM/\�x]Q_�T\�u<\��Vy��d�F\�Yo{��\�n�~m�.,��LrX�CРwkt�`���H[֓X�:5j�ٹ��a\�\�ͻ���\�\�qy�-�facʀH\�k�\�Ogi.ՈG��\0+t\"�d�\�Ȟg�j�`���\\lIi6�\�\��~^�fc�X\�}^�N�	a�V�׾�\0�.>p\nM\�\�d|�QQ\�V }m�߫j���!��S\�G!x\�jR�����zw\�\�\�o�(�p��z\0<2���4\�$\�A(�\�`5\�msn��Tv4�j�Ov��)�\�b\�\��Y\�RE�?�\�O�,�Ʋ��х\��,��\�v�=+�ec��m=,\�`��7\�VʐF9IeP5�l-m�\�ބ\�[2�XxƗ\�G�d�\�@\�Ac\�ry��c><i�mZ.ޓco\�$n;��\�_�\�x�|����\���A\��\��\��J#�4Iـ�������\�]��\'�ً�]F\�;G>�[��Ă��b>ⴸL\�(Bѡ@-b{��љ>XcZ5��3�\�OӤ��&ۛ\�/\�D�\0�MQeԿ���\�O����SeF<@�\�8\�FK*�\�\�I\0�{\�ތ��\0�\"��Cm��	~�s��=\�\�q©#\�m ۧ_�esGq�@�J̡\�T\\��A\�x\�w6\�RAJ]�͌\�\�\�ْFFp\n��ֳ(ˑ	\�H\�݀(��\Z@�X\��<_j�/��\r�Yd\�9\�ŽA6\�Tp\0�ߓU\�1��\�It��Bs��Z	\�\�˝\�ԹV\�\�s#�/CK�(�N�����y\Z1Hs����\�#\�=G4 \��A�i:�*)\�ԍ��!\'�H����z\���] \��p�\�\�nGj/(K\��\�H�\�\�Mi%�\�k��6BC�,�*��\�Ȝ$�\�R`�M\�v_�\�\��<=\�w;\�ڍ\�c�H�A\�Ҕa0\��OH\�nn	�i^�q�\�o��\�E���]�ĸ\Z-�����ỨA�W\�maj���V�q�\�[��kV��yv)�\�\�\�o�<\�d\"\�N\'\�j�\\�F�}Dt\��Q0�\Z�\�\�~j8��\���E���J�1/��\�j�����g�\�ir8\�o�	Z�x�wV\�V\�\�;qH��]�x\"\�\�V\Zg�\�dO\�iG�x�U�Q�\\6I��.\�\"��\�c��\��0\�q	!�\�ʏbq�\�~��z\�j�\�\�:p֦r���\�\���K�\��ᅐ�(\�l	?J�	�]�ʢD��\�\�z�b�\��4�\�yf!\�ޘ�+�b\�=��q�qS�\0^9\�\����\��f1y��>\\��:w<ވ\�\�8�X���j�6}E�U���x\��W�/<3I�,���\�V\��rY�\r\����\�K��\�\��lw�Oֹ\�\�\�+�.�\�=�o�\�#�\�H�\�*�\�\�n,X�\�\�J3\�\�1.�\�J[m ���G\� lj���VK�MJvz���E�\�dI i\Z\�@\�F�\�?\�%5�\�\�ى\�f�#*ߝ�\���\�\'l\\\�\�	\\tm��\�_\�N3��\�G�|�uv!@\�\�\��t�\��Gh\�.��8\0mMf���D�fk$Hce(ᘲ���,X\�{�{\�ٷ�4O�U��\�\�-��?�\04\�0��F\��!:�9t�\�[��7��4\�o\��\�ш\�	2\05\�\�gv#noY(r�09:\�f[�\�>ѩc\�\�>I\�Q��S~\"%�Z\�Eȷ\��4�\�<�4H~�ر>�p9c\�?���x�Ɵ-�H[9`A �=	\�\�Z)\�\�v,�f�b�r�\�\���\�e\�?҂\�t�\0�����\�+\�aT�z�6\�\�ښ\�\\�\�p/S�,k\�\�,�o���HZ�b�\�X߲\r\�{\�~\'\�sz���R�AO�**m�2�PY�އ�8H�]W\�k�ֲج\��w\�nkY�\��um\�cI\�\�TƆFϞ,���ߥ\�|31,\�Tn	�\�Fŗa\�\��\�H>���gg\�\�)\Z7�\�M�{Z�w�\�\�p6\�#H\�R��>��-��^��\�wG�;���������K<��\�\n\�\�>+܋\�x�\�-%ξ\�ߊ4\�����#:d\�ԯȵRe�]Q\�#~Oo�L`\�2\�˫{\�\��\0�\�e�\�x�#\�\�>�\�+o\�Y\�\�,U��.��\�Kq�n�\�r7#����\�E���[S\�k\0�\�r��!N���(X�Ͷ�f\�`���\�C����G6���\��&]/���͏PkF^��As\\4\�3�H4���XT�����\�~�9!^|\�cR줃�\�^��8�3�RǨ�,\r\�\��V[�\�b^6\�\r��\��WOF\�&\�x4�ev�).1G�X\Z)\'W\Z1�j���\�j�^�l�=�\���ĕ\�\�Y�x\\\�Hϥ\��\�ߌ\�Ͷ+�\0�H\r�q���55\�#6�qF�/\�0�O\�$(M�n7\�s\�\�H���h�(?2z\�\�p>@�U\�\�\r9�x�h���\�kJ=>�\�9\�Y*��b�?4�D��\�\r�^hO��6��\"\�\�m�\\�֞\�	>\� ��$m�{�\�K�E\��1\�\�ΥI�\r�6\�\rCn}�_\��r��\�\�����Z���\0ֆα\�\�)P\��c}�;?Oޅ˲�\�&16�:i?&��\�<,��\�\�ʼ�\�A�\'[��o\�E�A֌Ǔu-����0~\\Lh��\�!\��>\�jꩿ�a\�8��/L1�k\�E��W晡sa\�\'{\Z�q�\�k��\��I\�C��Ƶ���R\��y�\�Z�Ɍ2����&�\�s[\�C\��\��\�`_�\�\r�)7���S�/�]�\�\�	(�#�\�\�x�\0�\��^��y����;�kDd\��J4�� R+7�G��\�E�A7�����?˽r\�S\�>,�Tbl0\��\�W�k \�\�\�Ax�&�}2@\0��\��\�YNk*\0@X���,m\�?ژ�a�Gs\�:{ڡZy�z�&H��\"W\�p��\��WP\�\�fs2�!�\"\�ku\�ފ��©Рz��v��\'�4&D{~I\�`޵�%>��;jff;;�袊\�w[���6\��\�(\�\�8�-%\�\�p��o�-zY���K\�tc}{j#b�֚\�\�0%\�f�|dV� \������\�vv�Ku��9��\�:\�Պ�;��7�\�\�h1 F\��,\��\�M�ycH;�g�1�E\�\�z^������Pt��0\�\�!\Z@\�m�ۚ�`�IXأ��ӹ\"\���@\�\�\��\���\0��\�.0\� ���=\�mR�K\�i|	�9��[\n\0��}\�Jz�a\�b��nEls�F\�\"=1��[l���7\�0�\\(2Z\�\�\�?~�ں>�,�\�8\��\�\�\'X�\\n\�u�\0�W���5P��SL\�?�\�\�\�P�\�↗0(URX�\0��kWd&\�U䄠�.\�\�\�I��\04\�)\�z_<a4H\�\�rO4����vS��\��\0�J\�F@v�z\�V����1`��r:�;\r�#\r�\ZR�\�՞�Ii\Z45u�P�\'�w�{�P\�]\�.e$g\�\�Z�\�Q84T�\�\ZOf�b86>�d��ɻ\Z\��Ȧ��\�>��\�H����[�p_j�\n1\0I\�RGx�@��\�7�H\\\\r\�\�\�_�TO��8������\0���\�\�Hd�c��@\\�\��v\�\�\�qVe���(\�Ҥ�\'����\�\��4�16#�4\�\�\��Bȶ�\�{ۑL�<4��vf\"\��\�\�۷�sO�\�ಂ<\�sh��G\Z�{�y\'�2�4\�\�5ֶ \�-s\�z\���\��`nXv<i\�\�Z8p?��D2��\�\�\Z\�@�\�;����\�D>\r��E�H?qCxC�LL�N��3��\�qo���R2��ji=�u \�\�֔ePK�2y쬆B�.3�\�\�;VR�\�v\�u�eFIMC\�p�ye�\���\�Ul6�Uۯ_֬8\�e�-ӱ=�u�\�\�r\�ŷ(;\�_�JӞP��Y3��\�9�1-\�ESb�h#B\�V\�}\�\��f1�\\\\+�m-�ͯ\�Q.(aUT�o��n\�洪:\nn_�\\>]��U�s#rC_p-��(\\Y�\0\�)���ދ~[�V\�Oa\�\��4\�\��\�>6��\�g�H���\��Y�U?\�a��ƏxY\ni����*�Tm�R����_����o�@\�fg�a�ۥ��>��\��>\�\n\r�k�U���\��\�$\�\�B�oΏ��bG��S\�\�\�\�W����\�T�����#\�Lf�\�\�Ơ��\�\\��\�\�7�\�i\"�<�\�A��HN\�zZ��\0P��y~J�7\�\��\�zX�pޯ5,�\r�2��\�E\"\�~\�گ�*�\n��9̵\�\�@�t�\�n���\0>����]!\�͊HIGP̀�\�+{^��z\�\�Y\\��\�!+����\����⅑�(\�U\"\�\�HQ�\�j0�� }\�,\�\�\�b݂B�����,@����y�W?���1v\00;|�Ú\�6//\��u\���6V$9�\"1�\0��\�&\�\�\�SG�@p2���<�\�\�>\�[�\�Y\�$ER�Y\���\�\�\�\�0��u\�!ly�~\�\"�\�|B\�3���t��\���\�\�ꪹ2S\�\�2c6t;��\��\�lt�\�Ǳ\���!�ԣ]\�\�7�;�kR\�,��\�Mͺ\�\�\�\"]\�5�b/֋Y�0�#�a��?��V�4d,���Su�\05.���f�^�R\\69_u`E�\�\�B�5\�鉒a%�3<\�bB\�`94l-�\��\Z�v\n��\0,;�A���1�\�P/�S��\Z�\�\�C�>-	��M�\0��u�`\���\�\�۞\�;�znJ?�SgN\0\�	��SP\�\�\�v\�M�U�)\�(7��O�;{U9�_M�KF\�o�b���lG\�V\�,hq\�\�Q}H\��A\�9⹦\�tY$<\��_��UՇ.Ý\�[�PYnS!\�I1KFlȄ��~�W�\�{׹\�xuI&�q�;w7��F2I#tDmz\�\nGq��m��N_�)�-ec�\����\�C���4m$ɬ�F�2��\�\�koRs&T\��U�F\�\�\�D\�\�\�t\�KI+fw\�FV/��U<jBy�09�s\\\�f\n\�\��\�\���x\�d\�B\�\��7[�\��Ir�\0ư\�0�\�$� �]=�zeѹ����eѥT�\n�v�)D~%f\�\�	��\�,�\�\�	F�V������֛4�\�TH1H�7F!^ەu��<_�\���}΁ii\��I$cQ�O,\�\�\�.{=���\�4R$o:�;:�p��w޸�\�2�;\�\�Q[X�\�V\�7qj)Ț@\��FX��\Z�\�)$��zN)��׳7K?\�\����F$iPI\�_`*��\���\�d�:����\�W\�����\�d\�Hl\�.�\�{iР���\�s�j\�\�x9e��r!pT�n\�^\�}\�zek\�E|]z=GlC��β\����s\�Gŗ�gS��Ө��\�\�\�5�l\�8�M�}W;�\��\��*��\�\��l7\����2\�F�\\\�0H(�\�*V\Z\�,ŵǹ�\�\�\�?ӏ��Ha\�lQ��N�wf���c�������̦4U�\�\�&گ�\�\��\0��+�R|\�\�*\r̠dMI!f\�`G[v\���h���\�E�\�F�M\�KZ�\�\�^ԦrhDc�?�\��\�]0̡�r\��>ܑDf�vR)>\�C-�a~�\���y�jWl⯏�pn\�FW�X�M�Ρ��M\�\�~\�N����ڶl��G͇\�ޥJ\�[e��^!�qF޻9+bH�@�3L�\nP��vޠ}��ޥJ�z�\�I��nY�K\�\r!U7\�v\�\�mޖ�P&fl�&\��oR�t�;b4�U�\�\�A\"\�\��\�YO�щ6a��@6*U���]\�͜�B\�\�v�ڎ�D��7\�X�ůƛqj�$�L,\�\�A�I����H\�1B8 w�\���T�P\�\�R:c\\�0�$�9\�j�\'\����YJ�+�t��O\�\�n�W�+��-3��\�0\� \��l�M\�\�p�oNp��hz�qs���R�6\��\�fM.!��\�\�\�\�r��\�<�_���ʢ�\0qR�tI(\�P��1�����B3��}���lG4?�%�$lDO�]Յ��,^�T�S�NJ\���0Y�*�\�\�\�{�\0\�	4+��0���դz�\��\r�s�R�F݇�\��\nj̠�n7\�k���2�tR\�ǧ\0[�j�+u1�\�*�1p���W�����\�4�&�\�$��\\\\\0w��\���jRK\�\��d�1ra`!@śSX�7\�UǸ\�f��|4ze.�zT\�\�\�[��W�*���ԍ<YN.\�֟���W�*Q\�sg�\�'),(163,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0\n\Z\Z\Z\Z\Z\Z\Z\Z\Z\Z!.%+!\Z&8&+/1555\Z$;@;4?.4514+$,44444444444644444444444444444444441444444444444444��\0\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0>\0\0\0\0\0!1AQa\"q��2B����R\�r�\�#b��3S�\�4C�\�\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0*\0\0\0\0\0\0\0\0!1A2Qa\"R��#Bq���\�\0\0\0?\0�,5�zl��\�1)��z3�`\�\n\�V�\n�~�c)]IB\�J©	T��\Z`\�\'�B\�j��&)Oj�u�U����\Z\�e¸C��|,Ը��sK�R�O��.���Ga�>!\�[M\�\��q\��=ٶ6)�s{\�\�xZ@�V��\�\0S)Z\��\�72�_���]~Y�p-\��\�j�LCD�~�i>�\�\� �F\�\�z\�Jm2\�\�#)�j\r\�E����(\�}Q%\�D1�\�\�\�/7�\�_�\�R��]��⽗s�#���鳀_5�t�Eƫdd�]1}�q)Hb΀�W%KE����\�\��ܣTN9F�Gb��\�\�a�R�,[DjJ��m�\�\�F�6T\�n�8��*��b^M�p\�!\�A\n2\nЌ\�\�i�h!K�8W��d�t��\�V�))��\Z\Z��\Z�U	\'\���\�\r����\�.Rbs\�t4Ô4�ʷ��#q ,\�;.��1!��LyMcI�����/\�9)͔Spn;)لp\�	{+�)@�\0��jJ<\�	0�`7%i�\'e>�MbO��\�y���\�5߳N��\��vbK]R;\��p�<\�l\�ai�\�1�z�jH�[�G5ItXXe\Z5��y#\�Θ�}\�\�\�\�PE䂸�<�t�Vq(ZDx�k\�i\rn\�m��\�CF3I�;�O�F\��\�G�\\�y#\�ۨ��Z�A�<�-?��[Oݾ\�O}J;�#\�\�廸����N�T�\�\�^��\�\�\�\0\�[\��s\�.yw)��X.\�jg�\r�\�\�0\0��V�u�Q|\Z�\�#\��3\�\�<�S�\��Ċ�kI�?>\�\n����\\��6ji��\�Sk�\�i9\��d\�7)9��t}\�\��)w\�.�/\�\�IŮ�B\���P��{͝t#��,�PA�\��\�\�N߳�\�Gҭ|Μ\�D(Z\�t�a:���2sd�+��)л��\�c@]]p\�T\�\����\�\�56F�\�W��Rɕ\\�pnuO�%�\�=[X�ȅ\�T��\r���P�\n:���N�\nD;�׫\�Z$I32Jl�zf5B��Q8�,�\�p��6a��QW\�*�UT�ɒ���Ɵ�*\�0 }n�Y�d@\�.Kw+\�\rc�\�j\��B�\�XnB�w�\�r��hL�\0\"��\�i\Z�Pa=\��C6a�)\�\�\�Z<\��f��?4?Y�w�-�F(/:�蝀��\�\�\\6��6\�<6(\\�c	Դ[�*ؐ�\r��.�n\�;�1}8���+-��\�uF��L�j���\�)�\�\�b���\�}!b�5\�dU�nI=L���>�X>�I\�]\0�k͆�k��\�\�@��^\Zr���\�	\�P�����T��K���ph�P;�\��ci6C�r;��L��\�u\�<M�C`;\\ө3gH� |�����\�$8���4o���z-*��\�]�\�\��K\�뱏uGsA\�\�Is�<w��\����\�v��\�c�},m\��G�\0��$\�\�4\0\�\�{\�\�u���[Z\�2\�ߧ\�6\r\�\�3C�d7B\r\�n��\0\��E\�KX\�$\��`@��\�\�B7��\Z�s�KH\�&l�i꬙��O���s�\r[�\�[$6\�\\\�p��-W\'\��\0�>k�Z�\��)\��0�\09�K� d��w	���ԍ��ݝ�{�\�{�����\�\"M\��]�9ְxu�H��\�\�?\rQ\�k�k��\�3;r9�h7�U��m6\�\�\�)¤\�nW\�|:�\�B߿\0�rU�O` \0s6f\�W�Bч\�\��׳6��ё~\r\�\�a��\�T.\�l���\�K�4g0�\\�<@��bP�#�\�,��	\�bΈ�b�x�!u�\n��S{/��Е17�\�5\�!�K�I�^�\�(��u�p��LH[cNʺ�E�x���O9�GOw\�*�o��\��\�I�*�\�E�J\�\�Z��8�GUy&\\d���Q�\�(_X�T�a6H\�#P��iP�e\Z�Sc�QpT+��9�\ZH��m�\�f�΍\r���+\nN�\�pD0�����\�V�\r�-\��=\�ǫgs�ƚ�T�	���T�\0\�*�\�?~��T��Zޣ\�u�\�~\�\�!�N�cdU,NV\�l�ZFg\�&\Zt\�nj�����Ǒ\�\�\�\\;�\��W�2��^FS{E9\�e�\�7��\�T%g��~V����V�9�i\0\Zx��\�\�q[ZH2�g\�g�<Du��\�T��0<9�s�2]\�\� �y�M���\�\Za�\�:\�p9di\rw�����k\�Lw�r\���D�)�޶c�U_:-jqG;.a�\�h$�ܠ�\�:�龆,UF;�\�t�C\�6�B9׾\�&��\�VO&�-�0�Xa\�\�\�\�\�.��2\�\��\'媇�\�s�o���\�\�9�;�	\�5y6\n\�\�\r\�M�\�\��)�\��\�f�4��\�Zm��:�G$?\n\�+�����]��5�~EOR�g�\�^\"\0�<�\��\�c\�\�)��v@�\Z�O]\�u3:kLV\�\�i\�\�:�1�{�\�\�\�\�і\�\�u�y�\'u�\��\0�9f9�f\�jO�\��Ǉ\�$\�?��\0\�h\�R\�b�\�Әլ˱��5\�T�H\�+(�KJ�\�b�B:���tW\�f��Eҩ�D�\�$W\�$/�\�%9\"q\�]`\�O�%�*���\�o�\�\�\�Ɛ\�\�\�U�\�$\�s:/>��\�G��\�\�\�.\rS|�\�Q\�x>\'�\��e\':r\�.Rk�t�\'���\0Y�)^\��\��i=\��\��Z�q�9�U.�a\�\\\�\�ek&T��\�coH�\��3|�5Z%���c�\rJ��p\�\�\��iNǝ��\�<yo�=«\�|l\�y\�\rz��\�\073��MOUY\�\�ܛ|S.h�et�X�\�TDR}\��\�3�m ��u)h5�{F�Y����I�FS\�\�o\�\�\�z|�]P\�/b�\�&U��:j�W�fh-\�\�\r��Ɵ�\�\�8mF�e�5�	�)V\�t��R��k�\�5\�@\n\�6����W�\�Aq\�\�\'\�\��oH�ˬn\�;���.k\�\�\����\0\�n�\��34\�x��kO���ǆ�m�w-\�2Z�\�Ѽ\0\�M�\0�\�_�&�ݖ\�h�{l�I��\��0ل�\�\Z$�t�4�y\�\Z�ef��2fL�~�&\�\�\�\�E$�]��H�\�\�\�ɱ\�,nz\�ވlN$���\�18��3\�t@:�EW7�߶g�P��GXb���\�(\�ꎸ�\�?�\��\0\�PN{\Z���\�H��W�\�\�e\"B\�Ug�h�����Fg-\�sQ����\�R)\�#�\�\�\�Nv\�\�@|�\\YX�D3�-(�ҝ�;\�rE��,�\�\��\0\�_?��ͮ��ı\�@}\�n\��$���4`>UGR��\��\0*�\\re�\�h�~6�\�]\�\'��=\06\\iˊgM׎\�\�3YG\0\�!��]5\��\"��K���茠�;�g+�2I#�^\�[�ʴZ	q�ahAU\�M%(��\�m��g{�ed`\�\�\�TS�\�\'1�h<\\l���\�c�iy�a\�\0�\�з쬫\�cX\�1����ɉp\ZH\�\�U�woDV��\�٘�N�.Z_��蝍h����.2#޿�-B7���%\�6h�{�69@y곸�Aq�|VN/z\�\�p� \\][��8\�(�p\� f�E�8Z\'I\Z�h��N���(\�P\�iW\�\Z�0�U\'\�*Ӈ\�\�fI�F\�n�e\�֊�k�\�\ZD\�k�OB�\��hQ�n!\�s�/@8٠�Z\�y2\�g���b�g9��x��\Z\�H����<|\�n$B�˒:kh\�x�(.-.lAq`\�\"\\-��9(�����q$\�\�[~�m�l%CW\Z\�PK�\�\�\�\�ڀ`O;\��-��]`\'\r\"\�W-i�\�0yp�7\0������\r�\�f&9tCU\�N��%Zҗ\�kc��uU\rZ�\Z_�\�\�=S)�MƱ�\r\�C�l\\z���>>u�>fe���n{�9�\��\'UBN\�Z\�\�7\�v]\�\�\�k~\��Ԟہ�W8~R�s85���2\�]z5<V@)����ϛ�,�!긂���(eV� ��-ѡ��ο!@+MڗhiCp�Jb鉹\�\rmgs)\�\�g\��\�\��;\r�\�\�RB{T�\�l\�P7>Gd�-C\�\�5��vSby\\��\�\�\�u�\�`�CG�O�*_n\"\�\�\�c\�y����/h�0\�\�h�\�\�\0S��Da]�Z\�O�\��\��\�ǝ)��N�{��pr�K�O�SЩR�qi,h!\�y�8\�Is��6���R\�K��>fE\�\�~\�\�I�y�)$ظ�L\��ŀZp�^��\0@\�K֗\�g\�5�(��\�R�ɼ�V�.!^3�Uv\�f\�[&.\�9ﲃ�p��\0\�\�_\�\��^\�\�\���*\Z\�ZE\�Y\�w��\�\�\�6\�^\�J\�٧\�)��ik�\�\0�e�.�6\\\r��\��\�Oc���B�#�d;\�\nƝ\�\�!��\\�E�\�M��\0�\�\�Э�E]����kԵ�-M]��\n�T� ��c\�L��jf �\�\�N�U\n�Ok��h�l��!#�U�Ԯ\�*���\�\�MΫ�c�\�y\�\�.��\�\�R�Xֆ����\�~ɳ\�\�\�]r�1o�n!�te�s��A\��j�\�qP�\���qo0P�F����\�\�\�n$??��dcj�\�1���w�\�b\�1:G��3\�Zm�b�s~�|� �\�	Ŝ��\�[��\���\�VhuLք>ѡ\�=\�\�[�\�\�\�A7���D�0p�K�\�\�$�mS5\�4\�\Z\��*�+P4\�e��\�(��S\�\�Q\�%X\�)�a\�\�<N���K\�n�qn$4o\�\�Q\�\�\�NG\�h�-\\�P¸\�n���\�ѓ��$�{�~y$�h��\�\n�x�`^m$	\�n\�|�N	\�X��ڸ�1\�{O�d����6�ԇ3�\��m �\�\�%\�\�>\'�\��hq�\�\�Vt\�WT��\�]#Q\�{F�J�\0\�\�\�a\�2��w�{\�X��s�\�̭�^�\�\"\�9�%\��,$�tWo~\"^V5�\r��y\�O��\���{�0\"�\�~~��T\�]��]��\Z,e\��E��}|��\�l5�J\�x����9\��H�\��B;����\0�\�3\�\�;\�~\�f\�>vp���\ZjTh�\���X\�!��\�4\�h/�\�\'\��e�c!\�u/s�̙[e\�\���َ�Uk\���\�b\�k\�38�\�L2�\�z\�)W\�csXp�6h\0�Ę�2fө��\�\�cm{\�/&����\�h\�q\n��\�p��ߐ\�/ɖ\��`�\�Tpk�a\�Z}z!�Y���\�3\�C��\�/�)�m\���ǀ!�d\\e�1\0k��o\�hkc�X\�\�$Kr�)\rَY32haR\�\�-��\�t$ZNi��y!\�\�I\rô�2�y�\�>\�\'�HǴI��|\�\Z�h=w��o\�t\��R緣_$�\�\\Ub׸\r�\0�\��5j\�.$�Mϝʌ�\�%�9o\�\�-\�\�#���p\�-�\'\�\�\n���\�ߒ\�\�P\�\�R���{�(,�]�K�HMyo\�#\�^vg\r��zA��\�%H\�˲xl�uS\�\��\'\�U-��1�\�(8\��\�\�?\�@\�\\vz�jR}\�<\�Vk\\=\�\�%ަB+�b�*�\�L5�}�\'�0g\�\�\�Ө$+.=\�@\Z+N\�\�\�\\���\�股r-�D�\��\�x3@�\�\�l�!q)\�ϋo\�� 1�\�#�\�\�nK3�ͪ�g������E�\�\�e\�+V\�&�2�}�\�Y�a\�S�[����b\�+љ\�)\�~JW�y\�I�#�QRĂ޽Sr7�C\�ՏF[\�ȑ�H\�)g��(�\�\�\��oj�g\��$�\�\�i)�\�[�Ju\�ʛQ\�E\�\0x�Uo��F�Yxph/l��ܐ\�Ƴb��VI\��9\���\�i\�,\'q+��$Kr�\0�\�g#�\��\�0n\�\���,\�x�0A20n9���\��E�s��Q��s\� �Ѣ�y\�M��\�\�*\��\0���_&�Z�\�\�\�?=Q�LQ�\��?���p�ʧ)\0\\�LGN[д�-zZM:�4,\�\�^L71\r�l[k�|Տ&��)4�\�\�\r��-�\�>��\����,͍�\��\�qq����#c���\�\��\��r\�\�֋n\'\� \�\�DZΰ\��w\�\�5�ľ��n\ZL9�eǩ$�_@�9�1-\�h`�a\�/�m:l�{�����9n,w\�\��et�\�%+��!�\���\r\�\�\�MQ\�gu�4\�\0�x����bM��eL��\r!�m ����\�W06K�V.�X_s\�\����)o\�!d�\�;s2�8\�+1o�\�z�g\�\�8�\0em�)��Ϫθ\���\��3?��S\�+�]%r\�s�\�I8�W�\�8Н�j\�Z�`�?�/�֎rO&�O\�E�\�#\�(�p\0�\�s4�O���);;F��TI�\r&\�}\�#\�o�\�\�ex\�?ڿ4�\�f\�ɼ��\�\���eq<��\�\�R3�\�U\�kZuc@��k3��xW\'���,�ƴh\�����k*4\�c�\�C�N\�/���3\�:�^�I&I�=U�g��\�\�*>�\'�F��_e�����36�~YZ\�^)��\�\0JZF�eh8\�p\�1w�5�z�^~\�\�\�.q�8\�=W8\�5j9\�\�F�C�AҨ���[-WZ�B�\�bQ�(!�]2�awۣ\�D\�RP�T��ƱQ\09\�29\� �:\�\�Z�\�)E�\�`\�nn�\\\�- ��0�\�iԍ�\"ȷqG����6\��e\�lAk\�}\�\�nAa�3^��j�\�\�\�^e@\���K��Og\�*\�e8\rhtI\�`tX\�\\E�e&9O\�Z�N\"\�=�5\�\�p$\� �Q\�\����\�٥yUM-�i���{\�?\�:\��Y\�\ry\0ȵƚ^:+�9�q!�\�pp \�\"D�&\�\�\�\�\�6�\\��Y�\��|Y6��2���H\�\�xWJ���P\�\�Y���q��\�?��*\�U5�\�t6\�}LL\rU7\� \ro\�	�\�[7UN��+f�\�b\�\�\��>\�_X�\�JTmOh[ZK\�\�\�\�\�\Z�\'0$\���R]�ʸຟ�ý\�\�Ɨ�S\�!\r���-g8\0h�\���l��w����8o\r����\�y�7\�\�h\�̣\�q\�ϔ\�\�$��tcO\��XN\�>\�oBj��!\�\'5X\�k\Z2��7l\�$I\'R9\0����c\�\��h\�d�TZ��N\�5���Ȋ��xc.1\�XxD\��9�^�\�\�\Z\���\�_�?4\\`��Q�\0+\�^.r�!\�n]4����T���@\�O\����\�Qϛo������	\�Q\n\�e�s h�ctV�gSe?\"A��9)\'�5\�d;�\�S\0��\�����\�v�(��pՇ�5\����3OL\�\��Ь炚�(�xY��V�I\�xz2^\�Z>6w�\�4�AR\�9��uW\�>?Y�s�h9��9~j\\EJ�g\�\rqԲ\�\�h��8�\�\�X\���a�v#�+�\�k,=\�\�\�&�;��\"�\���\0\�-@>\nڗf\��Sƙe����\�q�31$��\�ѧz\��\��+)��V��\�T\r�\�lC\�ZzS�\�T��X���A��<	�W��Lh�1\�:\�DH\����No\�O��\0IW8\�EߕwפU����ݝ�ĝ(��Q4�/�?�.��Ll\�Q5�\�H\�\�\�~ \�nxR�\�\�\�[:\�\ZO̘C\��/���+\n|6\�0\�9\�\�vW����\�̦j���t�\0h\�E�\�\�\��kr�<5E�]���NπG�{[���O�v�L\�+N�,��\�F�]�2nV\�\\\�L�0\�\�cR}|I\�+RXM\\m\\C\�dų8\�ƞ~C��[�X�ƒz�۹\�r�V�(c��W�z~n�㴚1y��!.̷{\�o���A�M\�z\�\�LʐR6$j�Z�{�\�ۉ\�,�XA�\�\�S�4��i��/�\���2V�L�7h\�g8\�mp$�\'o\�KT��5\�v���\�g\�ɺ6)\�)\�\�\�w��\�	w�c�\�5Z�I}C;I?\�\�ޖo�UaE+���\�CCa=�u�DSb-l\�Rb2�\\�L#\�R�JAl\�Bp��\�M ��/f�7\�$�s]��I \�t\�H\�u%C��\�f)\�\�q	$���M>)P|e\�=\\h�J�\'oh�����\�|O\�?\�\�\�$�e�=�\�\�w�8�J��h+���TP9\�5�y�!��{�rI\"\��1��M�\��JY\��fa��F\�I�\�v�E*�t&,�H\�\�҇G\�}��\�T#+#��x��r\��.��	$�\n��V<%\�Ȑq:#\��%f�\�\�6ݟd	\'_^E?i�9)o��|)����\�WH��\Z��\��I$\�$�y�r}S]IifO\nr\�\�OB�I)$��6\�\�\�$����\�RIB\�f)$��?�\�'),(225,_binary '�\��\�\0JFIF\0\0\0\0\0\0�\�\0�\0		\n\n	\r\r\r \"\" $(4,$&1\'-=-157:::#+?D?8C49:7\n\n\n\r\r\Z\Z7%%77777777777777777777777777777777777777777777777777��\0\0\�\0\�\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0B\0\0\0\0\0\0!1AQqa�\"2BR����#3br��\�\�4C\���$Ss���\�\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\06\0	\0\0\0\0!1AQa�\"q��\�\��2B��R�3S\��\�\0\0\0?\0\�H\0� \0� \0pJ�)dv�\Z<P�F\�y\��؀�)�\�z�B(\�\�\��@{ݳ\�o\�\�3�6��\Zh����m\�c\�yB\�\�o��<wo@\0@\0@\0@�iq\�A\'�&*N2 ��\�5�\rh\n�\0@\0@�6H=v���-!c9�1�� \0� \0� \�0:]�cy�\'Gch\��\0@\0@\0@\�\�G�6�<Bк#�ky�-�\0� \0� $\�\�\�a�n\�9�& \0� \0� \0� \0����\�\�3k>\�\0� \0��K���\��\�\0@\0@\0@\0@~�\n�;��\�`�P\0@i\�\�_�\�\��\0� \0� \0� \0� \0� <p8d:h\�O\�;�\0��\�\0%��1G�怭\0@A�׺\�g��dbGA{ZN>+%�\"N%\"�Tޚ�\r2\�\�S\\�˭�O��\�\�\�V�ȕ��\"�\0#ѹ%�\���M\�\�_Kr�mM\�nsOG��S#%%�9˨���Y%dj\"]nT��++dԉ�7\0%c9�-Y�̛u�[4�[\�i#\�\�OOGF\�j�IFrz�rz\r�\"�\�x�h��0vn\nQɓ���\��\�N��\nf���\n�m\�\0d�\0\�ߺ\�L�\�\�;�Ǧ\��\�e�\�3W]�]\�Ыõ\�\Z\�r�\�-\��^Ց��&�f�\�\�U\�\�K~\�\�\�\�m\�QFk\�M�\�\�?3Ֆ\�@Ìn<\�h��\���-6~ʻ7\�\\#\��\�5\�o\Zoy\�:X��,gW��@Z��+B\�X{ٶnO󻗙q\�-8���\�Eu8\��F�@�\r��J�\"d�1X\�+٪n���M�G4��H .�qd\����\�||G�R*�6.Fvλ\nZO�|�C2��N�_\�\��j�]#�\"��\�\�\�<V�m�kVM���2{��\��#O\�\�5�\����\n�锓�3�c}�T�u���\�n\���\�ğ\"�;b\�\�\�\�p\�\�u��O9@�pwo@[����\�B� 	TQ\�\r�(�I\0%��i-��;ࠫk\�f}G\�\�8�;\�E�BoH�nN\�\�Ŋ��\�?\�=\�]l!}1-n�]5�\�<�`}V��\0\�?e��j\���ĕ9�c-�7\�\�\�s�yx��\�}G��]rס_�p!�V\��K��\�v�y���9\�x|R4=��;AV馵G\�\'	BN2Z4s}2�[\�RY��D\�\�p\�s�\�\�\�@��.U�:͕\�\�\�\�\�\�=�	y�{R�ˢ:1KGd�Z�w=�\�\���\�y৤��G)e��nsz�j��X�4���\�v�\�\�[ڍc+\�ѷTrZ\�NI#$\�\�\�02\ZE-5\�\�U_MQ\�3\�+\�\�\ZFg�\r-q-\�H.#�\'�����\�\'��RV�w�d����7\�%\�\�4F;�A\�tt\�t�.fC�e�uvkV�+2�<\��i�\���g��{�V^��L\�\�\�\��i8����\n.4;I9Ⱦ\�y>�L1h\���9=M{�]-�\�\�45\�\�ұ�n\�宙\�\Z\�${���9\�@\�,֋U�B\�\�\Z;\�H�m �\�>�ΊW\�=ٌ�R	�q�nG;P.N���\�\�\�c\�c��	�݀�v�;o�AP튮\�\�u:<e��v=�wV�\����Yo�G���\��z��\�S�Isg�\�e�]&���<\�&q�p�\0|IT\�X\����,H\�P��\�\��-Z\�?�\�\�p�V��o\�+KvI�2�\�\�}\�\�hsNZFAU\���\�\�wL���*\�\�W\�1\�Q�\�}O�\�}ݜxs-vV\�y��_�s�\Z�ަ�\�H\�<\�tu�\�\�/9\�s���	Pq\�q��S�\��0�\r�-8�r漎ĭN�Y��\�\�\�e\0߹���\�mo �\�i�K�4^\�+��Z��.!��\�{ݭ�~˩[�\\_~�\\N+��VK\��:\�{NO0UBmqG\�%\�.2Z�t-\�\r������۽*1�y�wQ�\nuY}&r�ޏ5��\��Rn�_(&\�w\�GYϪ{\Z�ýP\�\�vxy��6G�\�>dm��tsT��[��^\Z#�*ö�\�}\�\�\�&�Jr�G~gg�\�\�+,I\�\�\��Wz�<�������i\�2\nɽX��95�\�\�\�,�\�c!I��׬\�iWkU\����\0iz%.�XㆎVG[K/{xp\�\� ��\�\�`q\���M.��\�\�f1m-2\�4b0:�r:�\�.֊m\�hl\r��VVN\'�x\�$�\�j�����4��\�t�\�\�y.ޑO\��7=�>-	e�`Y$��k�\�2q嬶U^�\�\�&nb�\�wǒkO��C\\쾽��U֊�\�\�\�뵧�\�꽽FȨ��Ѹ2\�\�*��L8\�M>�f3�NϮw{��v62��F\�\�M�\Z�\�4��f27qʞr�����\�\rέ�\�M�e vd�G4��:�\��8w :^�6\n���\���\rZ9,��{�0\�\�9��=�#\�:\r���~L�5��u��\�ΟU�M�-��\r�\0�2�d\�v�C\�\����O�/�\�\�I��\�\���IE��Q�WI];�J�z��`\'�8\�ǚ��\�i���\��nS�{H7��}\�ƝYU=mL�5r�Y�9sݼ�\0�J$�\��gCUP�\n�,��2Ç4\�\��\�fҒџB0�1�\�!^,|\�uQ���\r\�hꇆ8��/R�Zf�m@d]3�uf�\�!`%\�>�\�T�~KU�ޭ�~˵U�\\�~�|(�ϣ�P\�\�gy�\0\�*5W\�\�\�\�~j^�\�\�s��\�\�מ�ɛƕh\�>�R��sQ{��\�3�\�)�R�^\'7����6j��|\�\�S]��\�\�`����#62HIs�\�~c\�hR��\rj�Ki\�y\�~�;9>i��y?�v�]\�f\�h���H\�ڙ6��֝^)\�3�݌x��\\Zk\�Xx.$\�&�\�뀻i-H��\�scX\�7g�8\0\0+*�\����Vh\�\�Uz�wa\�\���\�nJYBi\�[�ϸU���QO^.ꇑ���\����c\�=\�s/�n\�TC�\�[\���Q��K4�G\�\"�\�\�&r�0\��o:\�$�}\��\'Cel\�\�e�6�;���\0$��zYvg�\�lN�s�\�k�\�\�\0ע˶�|#\r?�\�3\�\�v��\�\�\�\�g�WF\�\�$\�\�j.g�\�|p3\�\��\�M=�\��e^\�\�2˒�V\�#\�\�\�Z㣑��-�awL8}�\��\0\�L�u�\\z�\0���V�@\�%�^(�\Z3\�\�\�w9w\��qޚDl˕8��O\���\�]3\\�\�\�{8�\�*��\�$�\0���\�4�\�\�\�H\Z\�\�\�Jwp\��|�|���\�\�\�\�}e\�,\�u\'�����U��\0�ꝚٟAl�����V`��m�\�<�\�\n\��\�\�>���U����P���\r\�J(B�\�l��Ъk�9���#\�icr<�!U\�-\���\�\n���cWzk\�\��:\�%��6V=��\�vvU�i�3�MŮ(w\�\�g�\�\�K��8;\� �^���\�;R�\�\�)`\0�9\�O\�UVfKY\�\�v��S��\��\0\'�.S�\�\�z>��\�7=p��\�e�v�ӽ�צ�\r�\�\�\�SA)���ǲ\�\"\�\�)\�Œ12%�|m�O\�p\�\�I\�j����\�<N\�{�����\\^��E7B\�Օ�S,�M�\0@t\�,o��P\�\ZZc��\�\�\�y���~�r��\�\'�,��/��\�\�\�\�\�w\�\�|�\�&�b\�I@^@\�����@\�J���9\�F\�ak��شd�<\�q-\�+���r[\�\\\�;��\�ӏf�&�\�<~?������\�w8{S-{/Iw>s	�ù\���%����}o���\�\�\nvcZS\r8z��%��p#�\�;\����k\�\�;<�Y\�U�u|�J�N�t�c�\��X\��Rqk���̦۹YTA*��|\�_w�\�U�\���jE?p�d,�A\�\\y��\'8�k&H\�Ż&{�GVh�n\�\'{�\�Ecg	j6��\0\�>eC�c��\�q��Z\�=|\�\�iw+�Uέ\�u\���8\0]��n\�9\�\�\�#�\�ǯ�]KDGq/\0<��d\�\�rIrE\Z��[�^he�*a,\�\�[��b\�|\�^\�=\�\�qs��\�W�$��\�\�t\��I���\�X=\�\�v\��ʲ>%=\�\n\�Q\��?��\�d\�\n��\�\���\�kkF|��=�*Uyq�	p(�=���K\�^O\���\�\�\�\�4�\�#��s\�3O\�\Z; �\�X}<�\�n\�\�Gu��\�\�E\�U\�\�.e�c�v�\�uח��G9�Z+/UF���|�a{��\0|\�}u\�ǤN�/2�Ho\��r2\�A4����3�u�\�m\� �\0\�`\����3�>\�^&l׹\�tm\�\��u��fΟ5��>:̬\��8�\�G\���B���6\�C\�Zр\0\�\��圜���R;��\�ߒE8\�耸� �A\�\�6s\�^h���\�R�\�Xk�&��n�30�\������fUY*�����b�h�ы�2���jj�\�\���\�\�l�T\��]F�\�\�Ν\�\�l��\�^\�7�\�E\�T��RH�\ry\�\�,�R#������\0Fӱ:��|y�wy�ܮWJ�\�\�Jd�\�A���9\�oVtX�\�cV��h�9���� \0� ��K�֋s�i_�\�\�̭\�1Mۻ�p�\�\"p�\�*��>.Mݬ�>�u���\���#�26*�������<]�\�*[.�t�0�*\�\�E.���\�tWG`\�\�]\�\�˃<\���\09�Y\�R�:u8���\'�n�\�\�~u3ki^\0@E��\0�y\�G\�~Գ�B�\0@j��\n�]\rT1\���H\�\�|��֌\�N�oA\��9����H\'��\�G4\�1��c����\�Udn�\�w\�\�<Ue\�\�ˏ��-�j\�F�V�=H]�I�\�\�#\�n�[�\�/�q]v�ݻ|t�\�.�\�X �A\�+I`�kTz��\0@\�E-3�\�^}V7\�q\�ʫߖ�<쥋K�7\�.��\"\�Z�\�;\�w��[Wvx�e��9*\�\�\�i��\�yX$ZH#h \�bf\�kFw\r�~1b��q뛫.8<l?\�\�\\\�=�&|\�hb��L\�\\�{�#*��\0� -\���_p��Ls: .�\0� �\�%3\�+fqɒ�G|\�J��\�M�Nł��\��FX�\�ֽ��hsH�l+\�\�z�\�3�����=\Z���P��4\�;�t�\�v����Ԩ�\\�\'�\'�����\�V˝1:�9\�I�L5~��/|\�\�x�\�\�\�\�\��%\�.\�\"Se�\�-��x8-N-t\'\�\�䵌���KUO̳\�ή\�\�9rF�s1\�Z\�4�$cqt\�(i\��\�5X<\�\�ب�\���^ӕ\�1+s�|#\���\n���\�*+d\�\�a�c:s>+\�Z�݂\�(��گʖ��$�G\�\�\�MZ0�\���T�R\�iI8�FH?��\n\�	�h\�=%�K+��5\��\��M9�� \0��u?�n\��G0\�(\�\0� \0�\�\�1WUFw�g��!RIi&��Q-\�.���\�\�\�/c$n��k�\'�Sk��녋I�W�ֺ�X��Ցj�\�l�=]H�*\n8Nc��z�W��\�sfʶnOXV��V�h@ŢZL\��\�\'Nj�p\��S�ݰ\�\�R(��ׇ2�i\�מ\��\�צ��\'C\�\�.�\�d\�\"ׂ�\�e\�]��l?u:��Y�s9\\퓑���\�=\�\�lyX\0@A��R&sq?!�\�P�\�{y��& \0� -\�\�-<��&��\�py^6�ՙB�JZ�s*�-�i\r\�QX$�ፌ�\�\�s�\��\�2�\�}�\�v���d\�\�S\�\�=_�\�K��\�\r��\�r4��	f{�@I\�\�ߴ\�۝�E��%��l���ߩh�\r;��ը�\0@\0@xP\�K,Zi\�{\�N\�\�\�{�s���i$\�*uwպ�$r��\':W\�&��O�����\��CKZC�r\���8߬6\�4�\�\��^[JK��am)X\�zѾ\Z��gC�U\�_AMY\�牲7�S�%(��^\�M��\\\�h��5\0@c+ݯX�������I�xg�@\0@k}�J\�J�S9{�f\�E\�ʏ����\�*Y\�צ�\�3���Q:X�%Ҩd���ȟ��\���z�z�Y2q�l\�5�q����\�\�_4ҾI���\�d�Վ>!��O2�(\�|�/l�dԢ���\\ߋ��J�i�\�e��f�\�;U\�\�8>KL�\��e�V\�\�+ �L��6\0@&�\�[p\�44�T�.1��<��oYF�\�F��i�N\�Ik\�d4b�\�\rl�KCK$܁\�\�h\���Aߎe6�o�\"m�ZQ��q]\�u�\�+�\�6\�c{i_(\�Lc\�\'�s8�ǚ�*+�;\�\�s�ml\�]9>\�]����\�ʪ\�\�\�+\�\�\�P\�\�H\�\�u�\���\�>EUY�.��֪�\�/Y���|:�\�\�u\Zx\"���\�\�\�\�o�ƌ\�X��\�l\�)\�zOV\\^��\0@a�\��I%�ݑӂ\�#O\'y<F\�\�q\0@��X*\�\�\�$`{^��A\��\�>λ\'[\�G\�y�9��AQv\�Zkt>Ӣ�6rnI.w\�o��\�Nw(��\�\�CgJ�w���\�U:3�\��\�\0��qf}\�\�y\�I\�TǥU�:\�ny��\�_\�k\�\�\�)f~�^[�q����L\�#<����[E}��gi��V>�W�/\�\�|�\�\�\�PK��SJy1�\��;?u6X��\\f�Hr\�\�zK޾�\"n̥\�\�.\�#��\�\��<.\�\�\�2�\�y?��kq\�p�=Z\��9w��-?��4z\�\�.�Ɣtc�z��\����\0\��\�z>̧?��F?v���,�I�\0����=*�~\�\�{3��S�\0��\�d��Ց\�\�-\��֗�W�3Z`�!ƌ\�;�C\�\�\�w\�n�5q\�@�m\�Y���p��1Gm�\��5�\0 ���\"�Rrz\�\�\�WM4J�<��\\Z5�]�\�Ȩ\�Ц�\\˭����5]�X?\�\�\�\�a{\'�x���\�\��f��9\�w�~KN���>�ҷk�{�k\�mZO�̼��x\\ث�dkᔍ�S\�\�I��=TR`g\�z�$�k\�gV\� -\�^�Ԟ��\��5Z��I5$\�;��@N@\0@b�d�i,��;ZCN\�X\�{\'\'.�>k_f�M�c̗�,U\�]~\�\��)��Wҷږ�\�o\\l��l��\Z0÷�ȅ��F�\�=(m����i����~\�*6}�˿Im\��Uܵ��\0F��\�@\0@�۬R\�t���Ȣ��{��\�\�ٖ�\��<�h\�\�s�\�\�u~toّ�Oی����b�R�\0@�\����\���z��\�P !M/{\�hl(�\0� -���\�M\��lԋ]\�\�x�ğ�\�1QZ#u�\�|�\�z��Z�F�� \0� \0� \0��q�1\�\"���O�\�P#`c\0\n�Tr\�\�1\� 2L{^\�朂��\0@\0@\0@\0@\0@\�&e<FG\��3\��f��:i}�}<P\0@ �\�\�l;\�\�\�5�\�i\�;�\�\0@\0@\0@\0@\�\�c2H\�4q@b_#\�\�\�$`�\���. \0� �ftf\�\����r6F\�0\� *@\0@\0@\0@��\�f���\�D.G\�W |�\Z=�r�\�\n\�\�\�P\0@\0@\�F\�x\�E6\n�I��\�#��(	\0� \0� \0� U70�@�s�G�c�y;�\�y�@]@\0@\0@�q\�4;\Zu\���(	Q\�\���=۹;w\�$m�\0@\0@xHh%\�\07���5\�l�2��w|\�咢�d�ԏ\�n�\�\�\0c\Z���h\0� \0� \0� \�ހ�tg1=\�\�v|�[WR\���#耬\\��\�?\�\���\�\�\�\�P?���77�\0*\�t�\�d�\��@P뛏\�\�\��?n���s��ˡ2\��<�\�\�\�X\�\�\n�\0@\0@�\�');
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
INSERT INTO `processes` VALUES (1,'Stir-fried','炒','Use oil and spoon to quickly make the food done.','大火与食用油的杰作。'),(2,'Boil','煮','Use water to slowly cook the food until it is done.','文火加水，直到煮熟。'),(3,'Steam','蒸','Use the heat of water steam to make the food available.','加入调料并用水蒸气在密闭容器中加工食物的方式。'),(4,'Fried','炸','Put the whole portion of food into oil.','将食物放进油中中小火加工到熟的工艺。'),(5,'Sause','腌制','Put salt onto food to make it available','在食物上撒盐并静置。'),(6,'Washed','洗净','Use running water to wash this food.','将食物洗净食用。'),(7,'honeydrew','蜜汁','Use sweet syrup to process food.','用甜汁浇灌食物。');
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
INSERT INTO `vendor_user` VALUES (1,'sanlu','123456','SanLu','三鹿','sanlu@china.cn'),(2,'guishengyuan','123456','Gui_Shengyuan','贵生源','guishengyuan@nanjing.com');
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
