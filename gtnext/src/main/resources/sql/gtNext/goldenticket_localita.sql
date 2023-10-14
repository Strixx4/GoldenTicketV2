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
-- Table structure for table `localita`
--

DROP TABLE IF EXISTS `localita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `localita` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `citta` varchar(255) DEFAULT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `posti` int NOT NULL,
  `zona` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localita`
--

LOCK TABLES `localita` WRITE;
/*!40000 ALTER TABLE `localita` DISABLE KEYS */;
INSERT INTO `localita` VALUES (1,'Ancona','Via dei Rododendri 40',22000,'Stadio del Conero'),(2,'Firenze','Via dei Tulipani 50',200,'Teatro Verdi'),(3,'Milano','Via dei Fiori 4',400,'Teatro la Scala'),(4,'Milano','Via Garibaldi 50',70000,'Stadio San Siro'),(5,'Roma','Via Tizio 2',50000,'Stadio Olimpico'),(6,'Genova','Via Boomer 5',1000,'Museo del Mare'),(7,'Verona','Via Napoleone 13',1000,'Museo Archeologico'),(8,'Verona','Via Shakespeare 40',30000,'Stadio Bentegodi'),(9,'Firenze','Via Ciro 7',600,'Teatro Puccini'),(10,'Venezia','Via Esposito 7',10000,'Stadio Penzo'),(11,'Como','Via Rosario 8',400,'Teatro sociale'),(12,'Lecco','Via Fiorello 80',800,'Museo Archeologico'),(13,'Catania','Via Nino Bixio 30',700,'Museo Zoologia'),(14,'Catania','Via Bottiglia 10',19000,'Stadio Angelo'),(15,'Palermo','Via Borraccia 9',500,'Museo Palermo'),(16,'Bari','Via Matita 20',450,'Teatro Piccinni'),(17,'Bologna','Via Portale 30',300,'Teatro del Sole'),(18,'Campobasso','Via Mattone 9',450,'Museo Misteri'),(19,'Brescia','Via Garibaldi 12',300,'Teatro Santa Chiara'),(20,'Brescia','Via Napoleone 2',10000,'Stadio Rigamonti'),(21,'Como','Via Aristotele 20',250,'Museo della Seta'),(22,'Cremona','Via Tutankhamon 50',300,'Museo Civico'),(23,'Perugia','Via Anassagora 8',350,'Museo del Giocattolo'),(24,'Assisi','Via Anassimene 5',300,'Teatro Lyrick'),(25,'Roma','Via Cilurzo 9',400,'Teatro Argentina'),(26,'Assisi','Via Breccia 8',350,'Museo Diocesano'),(27,'Como','Via Crostata 81',10000,'Stadio Sinigaglia'),(28,'Lecco','Via Paolo Giovio 83',4000,'Stadio Rigamonti'),(29,'Padova','Via Pino 49',300,'Museo di Geografia'),(30,'Sondrio','Via della Bresaola 58',500,'Teatro sociale');
/*!40000 ALTER TABLE `localita` ENABLE KEYS */;
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
