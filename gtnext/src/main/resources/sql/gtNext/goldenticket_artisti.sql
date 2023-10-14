-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: goldenticket
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `artisti`
--

DROP TABLE IF EXISTS `artisti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `artisti` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nominativo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artisti`
--

LOCK TABLES `artisti` WRITE;
/*!40000 ALTER TABLE `artisti` DISABLE KEYS */;
INSERT INTO `artisti` VALUES (1,'Vasco Rossi'),(2,'Fiorella Mannoia'),(3,'Rosario Fiorello'),(4,'Ultimo'),(5,'Milan'),(6,'Inter'),(7,'Juventus'),(8,'Como'),(9,'Lecco'),(10,'Max Angioni'),(11,'Pippo e Pluto'),(12,'Bugo'),(13,'I Legnanesi'),(14,'Vanessa Incontrada'),(15,'Pio ed Amedeo'),(16,'Luca Ravenna'),(17,'Museo Archeologico'),(18,'Teatro sociale'),(19,'Teatro sociale'),(20,'Teatro del Sole'),(21,'Museo della Seta'),(22,'Museo Diocesano'),(23,'Museo di Geografia'),(24,'Museo Misteri'),(25,'Museo Palermo'),(26,'Museo Zoologia'),(27,'Museo Archeologico'),(28,'Museo del Mare'),(29,'Museo del Giocattolo'),(30,'Museo Civico');
/*!40000 ALTER TABLE `artisti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-14 10:38:27
