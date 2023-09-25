-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: dangan_management
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `archive`
--

DROP TABLE IF EXISTS `archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archive` (
  `ArchiveId` varchar(50) NOT NULL,
  `ObjectId` int NOT NULL AUTO_INCREMENT,
  `ArchiveTypeId` varchar(50) NOT NULL,
  `SaveId` int NOT NULL,
  `Title` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Content` longtext,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Creater` varchar(50) NOT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `LastModiUser` varchar(50) DEFAULT NULL,
  `LastModiTime` datetime DEFAULT NULL,
  `LevelId` int DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `State` varchar(50) DEFAULT '正常',
  `EndIsAlert` int DEFAULT NULL,
  `EndBeforeDay` int DEFAULT NULL,
  `IsOften` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FileCode` varchar(50) DEFAULT NULL,
  `FromDept` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FromUnit` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FromUser` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ImpactTime` datetime DEFAULT NULL,
  `UseTime` datetime DEFAULT NULL,
  `ProductCode` varchar(50) DEFAULT NULL,
  `StuffCode` varchar(50) DEFAULT NULL,
  `Number` int DEFAULT NULL,
  `PageCount` int DEFAULT NULL,
  `PatentCode` varchar(50) DEFAULT NULL,
  `CheckUser` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`ArchiveId`),
  UNIQUE KEY `ObjectId` (`ObjectId`),
  KEY `archiveid_archive_atid` (`ArchiveTypeId`),
  KEY `save_archive_sid` (`SaveId`),
  CONSTRAINT `archiveid_archive_atid` FOREIGN KEY (`ArchiveTypeId`) REFERENCES `archivetype` (`ArchiveTypeId`),
  CONSTRAINT `save_archive_sid` FOREIGN KEY (`SaveId`) REFERENCES `save` (`SaveId`)
) ENGINE=InnoDB AUTO_INCREMENT=1000014 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archive`
--

LOCK TABLES `archive` WRITE;
/*!40000 ALTER TABLE `archive` DISABLE KEYS */;
INSERT INTO `archive` VALUES ('CA_0000111',1000009,'CA',2,'test','无','测试档案','invyasha','2023-08-24 00:00:00','invyasha','2023-08-24 00:00:00',2,'2029-12-21 00:00:00','正常',1,60,'不常用','0000111','系统开发部门','系统开发单位','白鲨同学','2023-08-24 00:00:00','2023-08-24 00:00:00','temp','temp',1,1,'PatentCode000002','cja'),('CK_0000022',1000008,'CK',2,'员工档案','        原来这个世界，紧紧地披着一层伪装的外表。\r\n        媒体，报纸……这一切都是那么虚伪。 翻开报纸，全都是歌颂好人好事之类的文章；打开电视，全都是国家重要人物在干些什么重要的事…… \r\n        关上电视，扔掉报纸，我看着窗外开着的花，轻蔑地笑了：我不相信这个世界就那么好，我不相信没有贫困，没有贪欲……虚伪，这个世界好虚伪！\r\n        我只记得一个节目----笑口组，它除了给我带来欢笑，但我喜欢的，却是它所反映的，是现实生活中的虚伪，撕开伪装的外表，把血淋淋的真相毫无保留地呈现在眼前。\r\n        但又怎样，我们还是一样要生活在这个虚伪的世界上？','白鲨同学的档案','白鲨同学','2016-01-12 00:00:00','invyasha','2023-08-18 00:00:00',1,'2026-01-12 00:00:00','正在借阅',1,60,'不常用','0000022','测试部门','测试单位','白鲨同学','2016-01-13 00:00:00','2016-01-13 00:00:00','temp111','123test',1,12,'PatentCode000001','白鲨同学'),('DEPT_0000013',1000006,'DEPT',3,'3','333333333333333333333333333333333333333333333333333333333333333','3','3','2023-08-06 00:00:00','3','2023-08-18 00:00:00',1,'2023-09-23 00:00:00','正在借阅',1,3,'3','0000013','3','3','3','2023-08-14 00:00:00','2023-08-14 00:00:00','3','3',3,3,'3','3'),('TEST_0000001',1,'TEST',0,'temp','这是一份测试档案这是一份测试档案这是一份测试档案这是一份测试档案','暂无','invyasha','2010-03-04 00:00:00','invyasha','2016-04-06 00:00:00',0,'2028-11-23 00:00:00','正在借阅',0,30,'不常用','0000001','系统开发部门','系统开发单位','invyahsa','2010-03-05 00:00:00','2010-03-07 00:00:00','aaabbbccc111','abc123',1,50,'aabbccdd1122','invyasha'),('TEST_0000113',1000012,'TEST',2,'test','443322','无','invyasha','2019-02-16 00:00:00','invyasha','2023-08-28 00:00:00',0,'2025-12-03 00:00:00','损坏',1,3,'不常用','0000113','系统开发部门','系统开发单位','invyasha','2023-08-10 00:00:00','2023-08-10 00:00:00','temp','temp',1,2,'PatentCode000002','白鲨同学'),('TEST_0000114',1000013,'TEST',3,'test','1212121234','无','invyasha','2023-08-05 00:00:00','invyasha','2023-08-28 00:00:00',0,'2023-12-15 00:00:00','丢失',1,3,'不常用','0000114','系统开发部门','系统开发单位','invyasha','2023-08-12 00:00:00','2023-08-12 00:00:00','temp','temp',1,1,'PatentCode000001','1'),('TEST_0001111',1000010,'TEST',0,'测试','11111111','无','invyahsa','2017-01-28 00:00:00','invyasha','2023-08-28 00:00:00',0,'2023-10-11 00:00:00','销毁',0,3,'不常用','0001111','系统开发部门','系统开发单位','invyasha','2023-08-23 00:00:00','2023-08-23 00:00:00','temp','temp',1,1,'PatentCode000001','st'),('TEST_0001112',1000011,'TEST',0,'test','2121212121','无','invyasha','2021-07-23 00:00:00','invyasha','2023-08-28 00:00:00',2,'2024-02-01 00:00:00','销毁',0,3,'不常用','0001112','系统开发部门','系统开发单位','invyasha','2023-08-10 00:00:00','2023-08-10 00:00:00','temp','temp',1,1,'PatentCode000001','st');
/*!40000 ALTER TABLE `archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archivetype`
--

DROP TABLE IF EXISTS `archivetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `archivetype` (
  `ArchiveTypeId` varchar(50) NOT NULL,
  `ArchiveTypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ArchiveTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivetype`
--

LOCK TABLES `archivetype` WRITE;
/*!40000 ALTER TABLE `archivetype` DISABLE KEYS */;
INSERT INTO `archivetype` VALUES ('CA','公司档案'),('CK','员工档案'),('DEPT','部门档案'),('TEST','测试档案');
/*!40000 ALTER TABLE `archivetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `att`
--

DROP TABLE IF EXISTS `att`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `att` (
  `AttId` int NOT NULL AUTO_INCREMENT,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `Title` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `UpTime` datetime DEFAULT NULL,
  `AttType` int DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `FileUrl` varchar(100) DEFAULT NULL,
  `FileSize` decimal(15,2) DEFAULT NULL,
  `Creater` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AttId`),
  KEY `archive_att_aid` (`ArchiveId`),
  CONSTRAINT `archive_att_aid` FOREIGN KEY (`ArchiveId`) REFERENCES `archive` (`ArchiveId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `att`
--

LOCK TABLES `att` WRITE;
/*!40000 ALTER TABLE `att` DISABLE KEYS */;
INSERT INTO `att` VALUES (1,'TEST_0000001','temp','2014-05-07 00:00:00',1,'这是一条上传测试记录','www.aaabbbccc.com',44.44,'invyasha');
/*!40000 ALTER TABLE `att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow` (
  `BorrowId` int NOT NULL AUTO_INCREMENT,
  `Borrower` varchar(50) DEFAULT NULL,
  `LoginId` varchar(50) DEFAULT NULL,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `BorrowTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `ReturnTime` datetime DEFAULT NULL,
  `remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `RetuenLoginId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BorrowId`),
  KEY `archive_borrow_aid` (`ArchiveId`),
  KEY `userinfo_borrow_lid` (`LoginId`),
  CONSTRAINT `archive_borrow_aid` FOREIGN KEY (`ArchiveId`) REFERENCES `archive` (`ArchiveId`),
  CONSTRAINT `userinfo_borrow_lid` FOREIGN KEY (`LoginId`) REFERENCES `userinfo` (`LoginId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES (1,'invyasha','admin00001','TEST_0000001','2011-08-03 00:00:00','2011-08-30 00:00:00','2023-08-22 00:00:00','这是一条借阅测试记录','admin00001'),(6,'invyasha','admin00001','DEPT_0000013','2023-08-20 00:00:00','2023-08-31 00:00:00','2023-08-22 00:00:00','2023-8-20invyasha进行借阅操作','admin00001'),(7,'invyasha','admin00001','DEPT_0000013','2023-08-22 00:00:00','2023-08-25 00:00:00','2023-08-22 00:00:00','无','admin00001'),(8,'沈桐','st','TEST_0000001','2023-08-22 00:00:00','2023-09-01 00:00:00','2023-08-22 00:00:00','队友呢队友呢救一下啊','admin00001'),(13,'invyasha','admin00001','CK_0000022','2011-08-03 00:00:00','2023-08-25 00:00:00',NULL,'这是一条借阅测试记录',NULL),(14,'invyasha','admin00001','DEPT_0000013','2011-08-03 00:00:00','2023-08-20 00:00:00',NULL,'这是一条借阅测试记录',NULL),(15,'invyasha','admin00001','TEST_0000001','2011-08-03 00:00:00','2023-08-31 00:00:00',NULL,'这是一条借阅测试记录',NULL);
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datafileback`
--

DROP TABLE IF EXISTS `datafileback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datafileback` (
  `FileId` int NOT NULL AUTO_INCREMENT,
  `FileName` varchar(50) DEFAULT NULL,
  `BackDate` datetime DEFAULT NULL,
  PRIMARY KEY (`FileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datafileback`
--

LOCK TABLES `datafileback` WRITE;
/*!40000 ALTER TABLE `datafileback` DISABLE KEYS */;
/*!40000 ALTER TABLE `datafileback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `DeptId` int NOT NULL,
  `DeptName` varchar(50) DEFAULT NULL,
  `TelePhone` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `ManageId` varchar(50) DEFAULT NULL,
  `Remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DeptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (0,'系统开发部门','111222333','3322112233','张三','暂无'),(1,'测试部门1','121234','aabbcc','白鲨同学','无'),(2,'测试部门2','111222333444','12121212','无','无'),(3,'wxw的部门','暂无','暂无','wxw','wxw的部门');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destory`
--

DROP TABLE IF EXISTS `destory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destory` (
  `DestoryId` int NOT NULL AUTO_INCREMENT,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `LoginId` varchar(50) DEFAULT NULL,
  `DestoryTime` datetime DEFAULT NULL,
  `Reason` varchar(9999) DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`DestoryId`),
  KEY `archive_destory_aid` (`ArchiveId`),
  KEY `userinfo_destory_lid` (`LoginId`),
  CONSTRAINT `archive_destory_aid` FOREIGN KEY (`ArchiveId`) REFERENCES `archive` (`ArchiveId`),
  CONSTRAINT `userinfo_destory_lid` FOREIGN KEY (`LoginId`) REFERENCES `userinfo` (`LoginId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destory`
--

LOCK TABLES `destory` WRITE;
/*!40000 ALTER TABLE `destory` DISABLE KEYS */;
INSERT INTO `destory` VALUES (2,'TEST_0000001','admin00001','2012-05-03 00:00:00','无','这是一条销毁测试记录'),(3,'TEST_0001111','admin00001','2023-08-28 00:00:00','销毁测试','无'),(4,'TEST_0001111','admin00001','2023-08-28 00:00:00','null','null'),(5,'TEST_0001112','admin00001','2023-08-28 00:00:00','null','null');
/*!40000 ALTER TABLE `destory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `find`
--

DROP TABLE IF EXISTS `find`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `find` (
  `FindId` int NOT NULL AUTO_INCREMENT,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `LoginId` varchar(50) DEFAULT NULL,
  `Finder` varchar(50) DEFAULT NULL,
  `FindTime` datetime DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`FindId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `find`
--

LOCK TABLES `find` WRITE;
/*!40000 ALTER TABLE `find` DISABLE KEYS */;
INSERT INTO `find` VALUES (1,'TEST_0000114','admin00001','st','2023-08-28 00:00:00','无'),(2,'TEST_0000114','admin00001','wxw','2023-08-28 00:00:00','1');
/*!40000 ALTER TABLE `find` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginfo`
--

DROP TABLE IF EXISTS `loginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loginfo` (
  `LogId` int NOT NULL AUTO_INCREMENT,
  `LogType` varchar(50) DEFAULT NULL,
  `OperateUser` varchar(50) DEFAULT NULL,
  `OperateDate` datetime DEFAULT NULL,
  `LogDescp` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`LogId`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginfo`
--

LOCK TABLES `loginfo` WRITE;
/*!40000 ALTER TABLE `loginfo` DISABLE KEYS */;
INSERT INTO `loginfo` VALUES (1,'错误','invyasha','2023-08-10 00:00:00','这是一条测试日志'),(2,'普通','invyasha','3923-09-11 00:00:00','这是第二条测试日志'),(4,'普通','白鲨同学','3923-09-11 00:00:00','这是第二条测试日志'),(5,'普通','test00001','3923-09-11 00:00:00','这是第二条测试日志'),(8,'普通','invyasha','2023-08-11 00:00:00','这是第二条测试日志'),(9,'普通','invyasha','2023-08-11 00:00:00','用户invyasha登录'),(10,'普通','invyasha','2023-08-11 00:00:00','用户invyasha登出'),(11,'普通','invyasha','2023-08-11 00:00:00','用户invyasha登录'),(15,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改员工信息,用户名为${LoginName}'),(16,'更新','invyasha','2023-08-12 00:00:00','用户invyasha删除员工信息,用户名为invyasha111'),(17,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加员工信息,用户名为wxw'),(18,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(19,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改系统配置'),(20,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加角色信息,增加角色id为4'),(21,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改角色信息,该角色id为4'),(22,'更新','invyasha','2023-08-12 00:00:00','用户invyasha删除角色信息,删除角色id为4'),(23,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加部门信息,新增部门id为3'),(24,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登出'),(25,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(26,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改部门信息,该部门id为3'),(27,'更新','invyasha','2023-08-12 00:00:00','用户invyasha删除部门信息,删除部门id为3'),(28,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加部门信息,新增部门id为3'),(29,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登出'),(32,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(35,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登出'),(40,'普通','wxw','2023-08-12 00:00:00','用户wxw登录'),(41,'普通','wxw','2023-08-12 00:00:00','用户wxw登出'),(42,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(44,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加存档点信息,增加存档点id为2'),(45,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(47,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改存档点信息,该存档点id为2'),(48,'更新','','2023-08-12 00:00:00','用户null增加存档点信息,增加存档点id为3'),(49,'更新','','2023-08-12 00:00:00','用户null增加存档点信息,增加存档点id为4'),(50,'更新','','2023-08-12 00:00:00','用户null删除存档点信息,删除存档点id为4'),(51,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(52,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登出'),(53,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(55,'更新','invyasha','2023-08-12 00:00:00','用户invyasha增加档案分类信息,删除档案类型id为TEMP'),(56,'更新','invyasha','2023-08-12 00:00:00','用户invyasha修改档案分类信息,该档案类型id为TEMP'),(57,'更新','','2023-08-12 00:00:00','用户null删除档案分类信息,删除档案类型id为TEMP'),(58,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登录'),(60,'普通','','2023-08-12 00:00:00','用户null登出'),(64,'普通','invyasha','2023-08-12 00:00:00','用户invyasha登出'),(65,'普通','invyasha','2023-08-16 00:00:00','用户invyasha登录'),(66,'更新','invyasha','2023-08-16 00:00:00','用户invyasha修改系统配置'),(67,'普通','invyasha','2023-08-16 00:00:00','用户invyasha登出'),(69,'普通','invyasha','2023-08-17 00:00:00','用户invyasha登录'),(70,'更新','invyasha','2023-08-17 00:00:00','用户invyasha修改档案信息,该档案id为TEST_0000001'),(71,'普通','invyasha','2023-08-17 00:00:00','用户invyasha登出'),(73,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登录'),(75,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登出'),(76,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登录'),(77,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_0000111'),(78,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_3'),(79,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登出'),(80,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登录'),(82,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登出'),(83,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登录'),(84,'更新','invyasha','2023-08-18 00:00:00','用户invyasha修改档案信息,该档案id为TEST_0000001'),(85,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_0000112'),(86,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为DEPT_0000013'),(87,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登出'),(88,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登录'),(89,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_0000014'),(90,'更新','invyasha','2023-08-18 00:00:00','用户invyasha删除档案信息,删除档案id为TEST_0000014'),(91,'更新','invyasha','2023-08-18 00:00:00','用户invyasha增加档案信息,增加档案id为CK_0000022'),(92,'普通','invyasha','2023-08-18 00:00:00','用户invyasha登出'),(93,'普通','invyasha','2023-08-20 00:00:00','用户invyasha登录'),(94,'更新','invyasha','2023-08-20 00:00:00','用户invyasha借阅档案,该档案id为DEPT_0000013'),(95,'普通','invyasha','2023-08-20 00:00:00','用户invyasha登出'),(96,'普通','invyasha','2023-08-22 00:00:00','用户invyasha登录'),(99,'普通','invyasha','2023-08-22 00:00:00','用户invyasha登出'),(100,'普通','st','2023-08-22 00:00:00','用户st登录'),(101,'普通','st','2023-08-22 00:00:00','用户st登出'),(102,'普通','st','2023-08-22 00:00:00','用户st登录'),(103,'更新','st','2023-08-22 00:00:00','用户st借阅档案,该档案id为TEST_0000001'),(104,'普通','st','2023-08-22 00:00:00','用户st登出'),(105,'普通','invyasha','2023-08-22 00:00:00','用户invyasha登录'),(106,'更新','invyasha','2023-08-22 00:00:00','用户invyasha归还档案,该档案id为TEST_0000001'),(107,'普通','invyasha','2023-08-22 00:00:00','用户invyasha登出'),(108,'普通','invyasha','2023-08-28 00:00:00','用户invyasha登录'),(109,'更新','invyasha','2023-08-28 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_0001111'),(110,'更新','invyasha','2023-08-28 00:00:00','用户invyasha销毁档案,该档案id为TEST_0001111'),(111,'更新','invyasha','2023-08-28 00:00:00','用户invyasha增加档案信息,增加档案id为TEST_0001112'),(112,'普通','invyasha','2023-08-28 00:00:00','用户invyasha登出'),(113,'普通','invyasha','2023-09-09 00:00:00','用户invyasha登录'),(114,'普通','invyasha','2023-09-09 00:00:00','用户invyasha登出'),(115,'普通','invyasha','2023-09-18 00:00:00','用户invyasha登录'),(116,'普通','invyasha','2023-09-18 00:00:00','用户invyasha导出txt档案,导出档案id为CA_0000111'),(117,'普通','invyasha','2023-09-18 00:00:00','用户invyasha登出');
/*!40000 ALTER TABLE `loginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lose`
--

DROP TABLE IF EXISTS `lose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lose` (
  `LoseId` int NOT NULL AUTO_INCREMENT,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `LoginId` varchar(50) DEFAULT NULL,
  `Loser` varchar(50) DEFAULT NULL,
  `LoseTime` datetime DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`LoseId`),
  KEY `archive_Lose_aid` (`ArchiveId`),
  KEY `userinfo_Lose_lid` (`LoginId`),
  CONSTRAINT `archive_Lose_aid` FOREIGN KEY (`ArchiveId`) REFERENCES `archive` (`ArchiveId`),
  CONSTRAINT `userinfo_Lose_lid` FOREIGN KEY (`LoginId`) REFERENCES `userinfo` (`LoginId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lose`
--

LOCK TABLES `lose` WRITE;
/*!40000 ALTER TABLE `lose` DISABLE KEYS */;
INSERT INTO `lose` VALUES (1,'TEST_0000001','丢失','admin00001','invyasha','2009-05-09 00:00:00','这是一条丢失测试记录'),(2,'TEST_0000113','损坏','admin00001','st','2023-08-28 00:00:00',''),(3,'TEST_0000114','丢失','admin00001','wxw','2023-08-28 00:00:00','null'),(4,'TEST_0000114','丢失','admin00001','st','2023-08-28 00:00:00','无'),(5,'TEST_0000114','丢失','admin00001','invyasha','2023-08-28 00:00:00','丢失');
/*!40000 ALTER TABLE `lose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `RoleId` int NOT NULL,
  `RoleName` varchar(50) DEFAULT NULL,
  `Power` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (0,'系统管理员','能够查看所有功能'),(1,'档案管理员','能够查看档案管理和档案鉴定功能'),(2,'数据维护员','能够进行数据恢复和数据备份'),(3,'员工','只能访问基本功能');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save`
--

DROP TABLE IF EXISTS `save`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save` (
  `SaveId` int NOT NULL,
  `SaveName` varchar(50) DEFAULT NULL,
  `SaveAddress` varchar(150) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Linker` varchar(50) DEFAULT NULL,
  `TelePhone` varchar(50) DEFAULT NULL,
  `Fax` varchar(50) DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`SaveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save`
--

LOCK TABLES `save` WRITE;
/*!40000 ALTER TABLE `save` DISABLE KEYS */;
INSERT INTO `save` VALUES (0,'测试存档点','invyasha','暂无','13738274549','1234-123456','这是一条测试记录'),(1,'测试存档点1','1','暂无','1','1','测试存档点1'),(2,'测试存档点2','2','2','2','2','测试存档点2'),(3,'测试存档点3','3','3','3','3','测试存档点3');
/*!40000 ALTER TABLE `save` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysconfig`
--

DROP TABLE IF EXISTS `sysconfig`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sysconfig` (
  `SysName` varchar(50) DEFAULT NULL,
  `ComName` varchar(250) NOT NULL,
  `ComTel` varchar(50) DEFAULT NULL,
  `ComFax` varchar(50) DEFAULT NULL,
  `ComAddress` varchar(250) DEFAULT NULL,
  `ComURL` varchar(250) DEFAULT NULL,
  `BrowserType` varchar(50) DEFAULT NULL,
  `BrowserVersion` varchar(50) DEFAULT NULL,
  `ClientIP` varchar(50) DEFAULT NULL,
  `ClientOS` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ComName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysconfig`
--

LOCK TABLES `sysconfig` WRITE;
/*!40000 ALTER TABLE `sysconfig` DISABLE KEYS */;
INSERT INTO `sysconfig` VALUES ('企业档案管理系统','伍贰伍企业股份无限公司','400-8515151','012-4008515151','京海市上城区中环西路666号','localhost','Microsoft Edge','Microsoft Edge11.0','192.168.43.31','Windows10');
/*!40000 ALTER TABLE `sysconfig` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysmsg`
--

DROP TABLE IF EXISTS `sysmsg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sysmsg` (
  `MsgId` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `Content` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `LoginId` varchar(50) DEFAULT NULL,
  `ArchiveId` varchar(50) DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  `IsRead` int DEFAULT NULL,
  `MsgTime` datetime DEFAULT NULL,
  PRIMARY KEY (`MsgId`),
  KEY `archive_sysmsg_aid` (`ArchiveId`),
  KEY `userinfo_sysmsg_lid` (`LoginId`),
  CONSTRAINT `archive_sysmsg_aid` FOREIGN KEY (`ArchiveId`) REFERENCES `archive` (`ArchiveId`),
  CONSTRAINT `userinfo_sysmsg_lid` FOREIGN KEY (`LoginId`) REFERENCES `userinfo` (`LoginId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysmsg`
--

LOCK TABLES `sysmsg` WRITE;
/*!40000 ALTER TABLE `sysmsg` DISABLE KEYS */;
INSERT INTO `sysmsg` VALUES (1,'档案到期提示','档案到期','警告！警告！警告！这是一条测试记录','admin00001','TEST_0000001','2009-05-09 00:00:00',1,'2007-05-09 00:00:00');
/*!40000 ALTER TABLE `sysmsg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `LoginId` varchar(50) NOT NULL,
  `LoginName` varchar(50) NOT NULL,
  `LoginPwd` varchar(50) NOT NULL,
  `RoleId` int DEFAULT NULL,
  `LevelId` int DEFAULT NULL,
  `CardId` varchar(50) DEFAULT NULL,
  `DutyId` int DEFAULT NULL,
  `DeptId` int DEFAULT NULL,
  `JoinDate` datetime DEFAULT NULL,
  `TelePhone` varchar(50) DEFAULT NULL,
  `EnduId` int DEFAULT NULL,
  `Address` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Sex` char(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Remark` varchar(9999) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`LoginId`),
  KEY `roleid_userinfo_rid` (`RoleId`),
  KEY `roleid_dept_did` (`DeptId`),
  CONSTRAINT `roleid_dept_did` FOREIGN KEY (`DeptId`) REFERENCES `dept` (`DeptId`),
  CONSTRAINT `roleid_userinfo_rid` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('${LoginId}','${LoginName}','${LoginPwd}',0,0,'${CardId}',0,0,'2010-01-03 00:00:00','${TelePhone}',0,'${Address}','9','${Remark}'),('admin00001','invyasha','a547896321',0,0,'513921200201120018',0,0,'2009-12-29 00:00:00','13738274549',0,'北京市朝阳区','男','我是个傻逼'),('cja','cja','cja',3,0,'1',4,0,'2023-08-12 00:00:00','1',1,'1','1','我是cja'),('st','st','st',3,0,'1',0,0,'2023-08-12 00:00:00','1',0,'1','1','无'),('test00001','test00001','1',1,0,'000000000000000001',0,1,'1010-10-10 00:00:00','10000000000',0,'aaa市bbb区','男','测试用户1'),('test00002','test00002','2',2,0,'000000000000000012',0,2,'1010-10-10 00:00:00','10000000000',0,'aacvf市badr区','女','测试用户2'),('test00003','test00003','2',3,4,'000000000000000123',0,1,'1010-10-10 00:00:00','10000000000',0,'aacvf市badr区','女','测试用户2'),('wxw','wxw','0603',3,0,'1111111',2,1,'2015-02-11 00:00:00','12121212',1,'121212121','2','我是wxw'),('白鲨同学','白鲨同学','a547896321',2,0,'qwertyuiopasdfghjk',4,2,'2010-02-03 00:00:00','13738274549',2,'浙江省杭州市','男','我是数据维护员');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-18 13:01:12
