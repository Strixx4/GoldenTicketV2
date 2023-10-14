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
-- Table structure for table `eventi_artisti`
--

DROP TABLE IF EXISTS `eventi_artisti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventi_artisti` (
  `eventi_id` bigint NOT NULL,
  `artisti_id` bigint NOT NULL,
  KEY `FKqvhk2ph9jn7do15h001c9i66q` (`artisti_id`),
  KEY `FKg3uvayh46ybywnpocaagilqfr` (`eventi_id`),
  CONSTRAINT `FKg3uvayh46ybywnpocaagilqfr` FOREIGN KEY (`eventi_id`) REFERENCES `eventi` (`id`),
  CONSTRAINT `FKqvhk2ph9jn7do15h001c9i66q` FOREIGN KEY (`artisti_id`) REFERENCES `artisti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventi_artisti`
--

LOCK TABLES `eventi_artisti` WRITE;
/*!40000 ALTER TABLE `eventi_artisti` DISABLE KEYS */;
INSERT INTO `eventi_artisti` VALUES (29,1),(30,2),(31,4),(32,12),(33,1),(34,12),(15,5),(15,6),(17,5),(17,7),(18,7),(18,5),(21,6),(22,6),(23,5),(7,7),(7,6),(16,6),(19,5),(20,7),(22,7),(23,6),(16,5),(1,6),(1,5),(5,21),(6,21),(8,22),(9,23),(10,24),(11,25),(12,26),(13,27),(14,28),(14,29),(10,30),(2,10),(3,11),(4,13),(2,14),(3,15),(4,16),(24,20),(25,19),(26,18),(27,2),(28,4);
/*!40000 ALTER TABLE `eventi_artisti` ENABLE KEYS */;
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
