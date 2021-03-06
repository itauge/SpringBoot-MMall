-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mmall
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `cost` float DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`product_id`),
  KEY `userId` (`user_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=180 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (178,774,2,200,27,'2021-07-18 19:12:10','2021-07-18 19:12:10'),(179,751,1,589,27,'2021-07-18 19:12:21','2021-07-18 19:12:21');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????',
  `order_id` int NOT NULL COMMENT '????????????',
  `product_id` int NOT NULL COMMENT '????????????',
  `quantity` int NOT NULL COMMENT '??????',
  `cost` float NOT NULL COMMENT '??????',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___66E1BD8E2F10007B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (86,109,733,2,304),(87,109,751,2,1178),(88,110,733,1,152),(89,111,733,1,152),(90,112,733,1,152),(91,113,733,1,152),(92,114,733,1,152),(93,115,733,1,152),(94,116,734,1,152),(95,116,745,3,1767),(96,116,768,1,5896),(97,117,742,4,632),(98,126,742,1,158),(99,126,733,1,152),(100,127,742,2,316),(101,127,733,1,152),(102,128,742,2,316),(103,128,733,1,152),(104,129,733,2,304),(105,130,733,1,152);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????',
  `user_id` int DEFAULT NULL COMMENT '????????????',
  `login_name` varchar(255) DEFAULT NULL COMMENT '?????????',
  `user_address` varchar(255) DEFAULT NULL COMMENT '????????????',
  `cost` float DEFAULT NULL COMMENT '?????????',
  `serialnumber` varchar(255) DEFAULT NULL COMMENT '?????????',
  `create_time` datetime DEFAULT NULL COMMENT '????????????',
  `update_time` datetime NOT NULL COMMENT '????????????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (118,1,'123','1231',100,NULL,'2021-07-17 15:23:24','2021-07-17 15:23:24'),(119,1,'123','1231',100,NULL,'2021-07-17 15:23:55','2021-07-17 15:23:55'),(126,27,'test','test123',310,'104688F03373503352EE035AB71AB44B','2021-07-18 11:28:46','2021-07-18 11:28:46'),(127,27,'test','test123',468,'30C3648DDA82A17C966931CA5A25DE8E','2021-07-18 11:33:52','2021-07-18 11:33:52'),(128,27,'test','test123',468,'4B033DCA6B42CDD2CF7CBBEFC75B80CD','2021-07-18 11:36:23','2021-07-18 11:36:23'),(129,27,'test','test123',304,'7C2CC16166B77B14D146D5666CC63207','2021-07-18 11:45:09','2021-07-18 11:45:09'),(130,27,'test','test123',152,'CD17EB1A33416303D96DC56B44DD8D41','2021-07-18 12:01:07','2021-07-18 12:01:07');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????',
  `name` varchar(200) NOT NULL COMMENT '??????',
  `description` varchar(1024) DEFAULT NULL COMMENT '??????',
  `price` float NOT NULL COMMENT '??????',
  `stock` int NOT NULL COMMENT '??????',
  `categorylevelone_id` int DEFAULT NULL COMMENT '??????1',
  `categoryleveltwo_id` int DEFAULT NULL COMMENT '??????2',
  `categorylevelthree_id` int DEFAULT NULL COMMENT '??????3',
  `file_name` varchar(200) DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=777 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (733,'?????????','??????',152,994,548,654,655,'baby_1.jpg'),(734,'?????????','',152,0,548,654,655,'baby_2.jpg'),(735,'????????????','',152,998,548,654,655,'baby_3.jpg'),(736,'??????','',152,1000,548,654,655,'baby_4.jpg'),(737,'??????','',152,111,548,654,655,'baby_5.jpg'),(738,'?????????','',45,109,548,654,655,'baby_6.jpg'),(739,'?????????','',156,99,548,654,655,'bk_2.jpg'),(740,'?????????','',158,100,628,656,659,'bk_1.jpg'),(741,'???????????????','',569,100,632,637,653,'bk_3.jpg'),(742,'????????????','',158,1000,660,661,662,'bk_4.jpg'),(743,'????????????','',589,1000,660,661,663,'bk_5.jpg'),(744,'??????2566','',589,996,670,671,672,'de1.jpg'),(745,'??????3C','',589,100,670,671,672,'de2.jpg'),(746,'????????????','',963,100,670,674,675,'de3.jpg'),(747,'??????2265','',896,1000,670,671,673,'de4.jpg'),(748,'????????????','',520,1,660,661,662,'de5.jpg'),(749,'??????????????????','',5866,100,628,657,0,'food_1.jpg'),(750,'??????Y??????','',569,1000,670,690,691,'food_2.jpg'),(751,'?????????1???','',589,999,676,677,680,'food_3.jpg'),(752,'????????????','',589,1000,676,678,0,'food_4.jpg'),(753,'???????????????','',859,100,676,679,0,'food_5.jpg'),(754,'????????????','',5896,100,676,679,0,'food_6.jpg'),(755,'?????????','',8596,99,628,696,0,'food_b1.jpg'),(756,'?????????','',5966,100,628,696,0,'food_b2.jpg'),(757,'?????????','',58,1000,628,696,0,'food_r.jpg'),(758,'????????????','',596,123,628,696,0,'fre_1.jpg'),(759,'???????????????','',5896,100,676,679,0,'fre_2.jpg'),(760,'?????????','',11000,100,681,682,687,'fre_3.jpg'),(761,'???????????????','',963,100,681,682,688,'fre_4.jpg'),(762,'???????????????','',569,1000,681,683,685,'fre_5.jpg'),(763,'???????????????','',8596,1000,681,683,684,'fre_6.jpg'),(764,'????????????','',5896,1000,660,661,662,'milk_1.jpg'),(765,'?????????','',5963,1000,660,661,662,'milk_2.jpg'),(766,'????????????','',200,1,660,661,663,'milk_3.jpg'),(767,'???????????????','',5896,1000,681,682,688,'milk_4.jpg'),(768,'??????','',5896,3,681,682,687,'milk_5.jpg'),(769,'?????????','',152,1000,676,679,0,'milk_6.jpg'),(770,'??????NTC','',8596,100,670,671,673,'milk_7.jpg'),(771,'??????1',NULL,100,100,548,654,655,'milk_8.jpg'),(772,'??????2',NULL,100,100,548,654,655,'pro1.jpg'),(773,'??????3',NULL,100,100,548,654,655,'pro2.jpg'),(774,'??????4',NULL,100,98,548,654,655,'pro3.jpg'),(775,'??????5',NULL,100,100,548,654,655,'pro4.jpg'),(776,'??????6',NULL,1,1,548,654,655,'pro5.jpg');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????',
  `name` varchar(20) NOT NULL COMMENT '??????',
  `parent_id` int NOT NULL COMMENT '????????????id',
  `type` int DEFAULT NULL COMMENT '??????(1:?????? 2????????? 3?????????)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (548,'?????????',0,1),(628,'????????????',0,1),(654,'????????????',548,2),(655,'?????????',654,3),(656,'??????',628,2),(657,'??????',628,2),(658,'??????',656,3),(659,'???',656,3),(660,'????????????',0,1),(661,'??????/??????/?????????',660,2),(662,'??????',661,3),(663,'??????',661,3),(669,'????????????',546,3),(670,'????????????',0,1),(671,'??????',670,2),(672,'????????????',671,3),(673,'????????????',671,3),(674,'??????',670,2),(675,'????????????',674,3),(676,'????????????',0,1),(677,'???????????????',676,2),(678,'???????????????',676,2),(679,'???????????????',676,2),(680,'?????????',677,3),(681,'??????',0,1),(682,'?????????',681,2),(683,'?????????',681,2),(684,'??????',683,3),(685,'??????',683,3),(686,'??????',683,3),(687,'??????',682,3),(688,'??????',682,3),(689,'??????',682,3),(690,'??????',670,2),(691,'????????????',690,3),(692,'??????',656,3),(693,'??????',656,3),(696,'????????????',628,2);
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????',
  `login_name` varchar(255) NOT NULL COMMENT '?????????',
  `user_name` varchar(255) NOT NULL COMMENT '?????????',
  `password` varchar(255) NOT NULL COMMENT '??????',
  `gender` int NOT NULL DEFAULT '1' COMMENT '??????(1:??? 0??????)',
  `identity_code` varchar(60) DEFAULT NULL COMMENT '????????????',
  `email` varchar(80) DEFAULT NULL COMMENT '??????',
  `mobile` varchar(11) DEFAULT NULL COMMENT '??????',
  `file_name` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C96109CC3A81B327` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'admin','???????????????','123123',0,'130406198302141869','hello11@bdqn.com','1583233515','7.jpg','2020-05-18 06:22:27','2020-05-18 06:22:32'),(10,'cgn','?????????','123',1,'140225189987854589','1044732267@qq.com','13366055011','2.jpg','2020-05-18 06:22:34','2020-05-18 06:22:37'),(11,'hyl','?????????','1231',1,'140225198874584539','1044732267@qq.com','13366055010','3.jpg','2020-05-18 06:22:35','2020-05-18 06:22:37'),(12,'ck','??????','123',1,'140225189987854589','1044732267@qq.com','13366055010','4.jpg','2020-05-18 06:22:36','2020-05-18 06:22:38'),(27,'test','?????????','123123',1,'120111199005288473','123@sdf.com','13987678766','4.jpg','2021-07-14 10:51:54','2021-07-14 10:51:54');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `user_id` int DEFAULT NULL COMMENT '????????????',
  `address` varchar(255) DEFAULT NULL COMMENT '??????',
  `remark` varchar(255) DEFAULT NULL COMMENT '??????',
  `isdefault` int DEFAULT '0' COMMENT '????????????????????????1:??? 0??????',
  `create_time` datetime DEFAULT NULL COMMENT '????????????',
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
INSERT INTO `user_address` VALUES (11,27,'???????????????????????????','?????????',0,'2019-06-03 02:32:39','2019-06-03 02:32:39'),(12,2,'???????????????????????????','???????????????',0,'2019-06-03 02:32:38','2019-06-03 02:32:39'),(13,23,'??????????????????????????????????????????','???????????????',1,'2019-06-03 02:32:37','2019-06-03 02:32:39'),(14,23,'????????????????????????','??????',0,'2019-06-03 02:32:33','2019-06-03 02:32:39'),(34,27,'????????????','??????',0,'2019-05-30 20:21:32','2019-06-03 02:32:39'),(35,27,'?????????','??????',0,'2019-06-02 20:06:41','2019-06-03 02:32:39'),(37,23,'????????????','??????',0,'2019-06-20 23:26:46','2019-06-03 02:32:39'),(41,21,'?????????','??????',0,'2019-06-21 03:03:37','2019-06-03 02:32:39'),(45,10,'??????','??????',0,'2019-07-03 20:50:29','2019-06-03 02:32:39'),(46,10,'?????????','??????',0,'2019-07-03 20:52:33','2019-06-03 02:32:39'),(47,10,'ddd','123',0,'2019-10-23 01:24:05','2019-06-03 02:32:39');
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-18 20:11:39
