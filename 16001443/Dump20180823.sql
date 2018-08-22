-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: nsbmuni
-- ------------------------------------------------------
-- Server version	5.5.2-m2-community

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
-- Table structure for table `coursework`
--

DROP TABLE IF EXISTS `coursework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursework` (
  `cwid` int(11) NOT NULL AUTO_INCREMENT,
  `subid` varchar(100) NOT NULL,
  `cwtid` int(11) NOT NULL,
  `courseWorkName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cwid`),
  KEY `subid` (`subid`),
  KEY `cwtid` (`cwtid`),
  CONSTRAINT `coursework_ibfk_1` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `coursework_ibfk_2` FOREIGN KEY (`cwtid`) REFERENCES `courseworktype` (`cwtid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursework`
--

LOCK TABLES `coursework` WRITE;
/*!40000 ALTER TABLE `coursework` DISABLE KEYS */;
INSERT INTO `coursework` VALUES (6,'MAT 113',1,'Assignment1'),(7,'MAT 113',1,'Assignment 2'),(8,'MAT 113',1,'Online Quiz');
/*!40000 ALTER TABLE `coursework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseworktype`
--

DROP TABLE IF EXISTS `courseworktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courseworktype` (
  `cwtid` int(11) NOT NULL AUTO_INCREMENT,
  `courseWorkTypeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cwtid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseworktype`
--

LOCK TABLES `courseworktype` WRITE;
/*!40000 ALTER TABLE `courseworktype` DISABLE KEYS */;
INSERT INTO `courseworktype` VALUES (1,'Assignment'),(2,'Exam');
/*!40000 ALTER TABLE `courseworktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `degree` (
  `degid` int(11) NOT NULL AUTO_INCREMENT,
  `facid` int(11) NOT NULL,
  `degreeName` varchar(100) DEFAULT NULL,
  `graduationType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`degid`),
  KEY `facid` (`facid`),
  CONSTRAINT `degree_ibfk_1` FOREIGN KEY (`facid`) REFERENCES `faculty` (`facid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES (1,1,'BSc','UG'),(2,1,'MSc','PG'),(3,2,'BSc','UG'),(4,3,'MSc','PG'),(5,2,'MSc','PG'),(6,3,'BSc','UG');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `facid` int(11) NOT NULL AUTO_INCREMENT,
  `facultyName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`facid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'FACULTY OF COMPUTING'),(2,'FACULTY OF BUSINESS'),(3,'FACULTY OF ENGINEERING');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `incid` varchar(100) NOT NULL,
  `subid` varchar(100) NOT NULL,
  `facid` int(11) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `instructorAddress` varchar(100) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`incid`),
  KEY `facid` (`facid`),
  KEY `subid` (`subid`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`facid`) REFERENCES `faculty` (`facid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `instructor_ibfk_2` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES ('I001','CS2',3,'Pushpa','Damayanthi','Galle','077-7609476','MALE','p@gmail.com'),('I002','MAT 113',1,'Kumudu','Priyankara','Gampaha','0777609470','MALE','kum@gmail.com');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `lecid` varchar(100) NOT NULL,
  `facid` int(11) NOT NULL,
  `lecturerName` varchar(100) DEFAULT NULL,
  `lecturerAddress` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`lecid`),
  KEY `facid` (`facid`),
  CONSTRAINT `lecturer_ibfk_1` FOREIGN KEY (`facid`) REFERENCES `faculty` (`facid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES ('L001',1,'Dimuthi','Galle','FEMALE','077-6094767','dimuthi@gmail.com'),('L002',2,'Tharaka','Homagama','FEMALE','077-7995674','tharaka@gmail.com'),('L003',3,'Dimuthi Tharaka','Panadura','FEMALE','077-0965478','dimuthi@gmail.com'),('L004',3,'Amali Jayasekara','Rathnapura','FEMALE','0912275128','ama@gmail.com'),('L005',2,'Ayesh Buddhima','Rathmalana','MALE','091-5674382','ayesh123@gmail.com'),('L006',2,'Chathura Jayalath','Pannipitiya','MALE','071-7655342','chathura476@gmail.com'),('L007',1,'Chathuri Weerasinghe','Kottawa','FEMALE','071-9843098','chweer@yahoo.com'),('L008',3,'Prasanna Baddewithana','Kaluthara','MALE','075-0965390','prasannabaddewi@gmail.com');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marks`
--

DROP TABLE IF EXISTS `marks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marks` (
  `markid` int(11) NOT NULL AUTO_INCREMENT,
  `cwid` int(11) NOT NULL,
  `subsemregid` int(11) NOT NULL,
  `marks` int(11) DEFAULT NULL,
  PRIMARY KEY (`markid`),
  KEY `cwid` (`cwid`),
  KEY `subsemregid` (`subsemregid`),
  CONSTRAINT `marks_ibfk_1` FOREIGN KEY (`cwid`) REFERENCES `coursework` (`cwid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `marks_ibfk_2` FOREIGN KEY (`subsemregid`) REFERENCES `subjsemregistration` (`subsemregid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marks`
--

LOCK TABLES `marks` WRITE;
/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` VALUES (3,7,2,90),(4,6,2,80),(10,8,2,60);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `payid` varchar(100) NOT NULL,
  `semrgid` varchar(100) NOT NULL,
  `totalAmount` double DEFAULT NULL,
  `amountToPay` double DEFAULT NULL,
  `dateOfPay` date DEFAULT NULL,
  PRIMARY KEY (`payid`),
  KEY `semrgid` (`semrgid`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`semrgid`) REFERENCES `semesterregistration` (`semrgid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('PUCO4Y1S11','UCO4Y1S1',7000,1000,'2018-08-22'),('PUCO5Y1S11','UCO5Y1S1',7053,4000,'2018-08-22');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postgraduatedetails`
--

DROP TABLE IF EXISTS `postgraduatedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postgraduatedetails` (
  `pgdid` int(11) NOT NULL AUTO_INCREMENT,
  `rgid` varchar(100) NOT NULL,
  `qualificationType` varchar(100) DEFAULT NULL,
  `institute` varchar(100) DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pgdid`),
  KEY `rgid` (`rgid`),
  CONSTRAINT `postgraduatedetails_ibfk_1` FOREIGN KEY (`rgid`) REFERENCES `registration` (`rgid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postgraduatedetails`
--

LOCK TABLES `postgraduatedetails` WRITE;
/*!40000 ALTER TABLE `postgraduatedetails` DISABLE KEYS */;
INSERT INTO `postgraduatedetails` VALUES (1,'UCO2','BSC in Information Technology','IIT','2015');
/*!40000 ALTER TABLE `postgraduatedetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registration` (
  `rgid` varchar(100) NOT NULL,
  `stid` varchar(100) NOT NULL,
  `degid` int(11) NOT NULL,
  `facid` int(11) NOT NULL,
  `dateofRegistration` date DEFAULT NULL,
  `intake` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rgid`),
  KEY `stid` (`stid`),
  KEY `facid` (`facid`),
  KEY `degid` (`degid`),
  CONSTRAINT `registration_ibfk_1` FOREIGN KEY (`stid`) REFERENCES `student` (`stid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registration_ibfk_2` FOREIGN KEY (`facid`) REFERENCES `faculty` (`facid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registration_ibfk_3` FOREIGN KEY (`degid`) REFERENCES `degree` (`degid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES ('UCO2','S2',2,3,'2018-08-16','JULY'),('UCO3','S3',1,1,'2018-08-17','FEBRUARY'),('UCO4','S4',1,3,'2018-08-22','FEBRUARY'),('UCO5','S5',1,3,'2018-08-22','JULY');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester`
--

DROP TABLE IF EXISTS `semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semester` (
  `semid` int(11) NOT NULL AUTO_INCREMENT,
  `semesterName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`semid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester`
--

LOCK TABLES `semester` WRITE;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` VALUES (1,'Year 1 Semester 1'),(2,'Year 1 Semester 2'),(3,'Year 2 Semester 1'),(4,'Year 2 Semester 2'),(5,'Year 3 Semester 1'),(6,'Year 3 Semester 2'),(7,'Year 4 Semester 1'),(8,'Year 4 Semester 2');
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semesterregistration`
--

DROP TABLE IF EXISTS `semesterregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semesterregistration` (
  `semrgid` varchar(100) NOT NULL DEFAULT '',
  `semid` int(11) NOT NULL,
  `rgid` varchar(100) NOT NULL,
  `dateofSemRegistration` date DEFAULT NULL,
  PRIMARY KEY (`semrgid`),
  KEY `semid` (`semid`),
  KEY `rgid` (`rgid`),
  CONSTRAINT `semesterregistration_ibfk_1` FOREIGN KEY (`semid`) REFERENCES `semester` (`semid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `semesterregistration_ibfk_2` FOREIGN KEY (`rgid`) REFERENCES `registration` (`rgid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semesterregistration`
--

LOCK TABLES `semesterregistration` WRITE;
/*!40000 ALTER TABLE `semesterregistration` DISABLE KEYS */;
INSERT INTO `semesterregistration` VALUES ('UCO2Y1S1',1,'UCO2','2018-08-16'),('UCO3Y1S1',1,'UCO3','2018-08-17'),('UCO4Y1S1',1,'UCO4','2018-08-22'),('UCO5Y1S1',1,'UCO5','2018-08-22');
/*!40000 ALTER TABLE `semesterregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stid` varchar(100) NOT NULL,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `studentAddress` varchar(100) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S2','Udari','Vimansana','Gampaha','MALE','1989-10-17','077-7609476','udari@gmail.com'),('S3','Charini','Wickramathilake','Matara','MALE','1995-02-05','076-5467832','charini@gmail.com'),('S4','Nirmani','Gunathilaka','Galle','MALE','1997-01-01','097-8654321','nirmani@gmail.com'),('S5','Lasitha','Wijethilaka','Hapugala','MALE','1994-05-10','097-1234567','lasitha@gmail.com');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subid` varchar(100) NOT NULL,
  `lecid` varchar(100) NOT NULL,
  `semid` int(11) NOT NULL,
  `facid` int(11) NOT NULL,
  `degid` int(11) NOT NULL,
  `subjectName` varchar(100) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `fee` double DEFAULT NULL,
  PRIMARY KEY (`subid`),
  KEY `semid` (`semid`),
  KEY `facid` (`facid`),
  KEY `lecid` (`lecid`),
  CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`semid`) REFERENCES `semester` (`semid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_ibfk_2` FOREIGN KEY (`semid`) REFERENCES `degree` (`degid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_ibfk_3` FOREIGN KEY (`facid`) REFERENCES `faculty` (`facid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_ibfk_4` FOREIGN KEY (`lecid`) REFERENCES `lecturer` (`lecid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('CS2','L004',1,3,1,'Computer Systems',2,3000),('CSC 141','L002',1,2,1,'Computer Science',3,43),('E11','L006',1,2,2,'Econ 1',3,4000),('E12','L006',2,2,2,'Econ 1',3,3800),('E2','L006',1,2,2,'Econ 2',3,3800),('IT1','L001',1,1,2,'Information Technology 1',3,3000),('MAT 113','L001',1,1,1,'Mathematics',2,2300),('MAT114','L007',1,1,1,'Maths 4',3,3000),('MAT2','L004',1,3,1,'Mathematical Methods 2',3,4000),('PHY 183','L003',1,3,1,'Physics',4,53);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjsemregistration`
--

DROP TABLE IF EXISTS `subjsemregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjsemregistration` (
  `subsemregid` int(11) NOT NULL AUTO_INCREMENT,
  `semrgid` varchar(100) NOT NULL,
  `subid` varchar(100) NOT NULL,
  PRIMARY KEY (`subsemregid`),
  KEY `semrgid` (`semrgid`),
  KEY `subid` (`subid`),
  CONSTRAINT `subjsemregistration_ibfk_1` FOREIGN KEY (`semrgid`) REFERENCES `semesterregistration` (`semrgid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subjsemregistration_ibfk_2` FOREIGN KEY (`subid`) REFERENCES `subject` (`subid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjsemregistration`
--

LOCK TABLES `subjsemregistration` WRITE;
/*!40000 ALTER TABLE `subjsemregistration` DISABLE KEYS */;
INSERT INTO `subjsemregistration` VALUES (2,'UCO3Y1S1','MAT 113'),(3,'UCO3Y1S1','MAT 113'),(4,'UCO4Y1S1','CS2'),(5,'UCO4Y1S1','MAT2'),(6,'UCO5Y1S1','CS2'),(7,'UCO5Y1S1','MAT2'),(8,'UCO5Y1S1','PHY 183');
/*!40000 ALTER TABLE `subjsemregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `undergraduatedetails`
--

DROP TABLE IF EXISTS `undergraduatedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `undergraduatedetails` (
  `ugdid` int(11) NOT NULL AUTO_INCREMENT,
  `rgid` varchar(100) NOT NULL,
  `alResults` varchar(100) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `zscore` double DEFAULT NULL,
  `year` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ugdid`),
  KEY `rgid` (`rgid`),
  CONSTRAINT `undergraduatedetails_ibfk_1` FOREIGN KEY (`rgid`) REFERENCES `registration` (`rgid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `undergraduatedetails`
--

LOCK TABLES `undergraduatedetails` WRITE;
/*!40000 ALTER TABLE `undergraduatedetails` DISABLE KEYS */;
INSERT INTO `undergraduatedetails` VALUES (1,'UCO3','Maths-\'A\' Chemistry-\'B\' Physics-\'A\'','Devi Balika College',1.8,'2014'),(2,'UCO4','Maths-\"A\"\nChemistry-\"B\"\nPhysics-\"A\"','Anuladevi College',1.7,'2012'),(3,'UCO5','Maths-\'A\'\nChemistry -\'A\'\nPhysics -\'A\'','Richmond College',1.9,'2015');
/*!40000 ALTER TABLE `undergraduatedetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-23  0:09:47
