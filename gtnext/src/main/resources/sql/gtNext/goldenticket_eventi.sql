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
-- Table structure for table `eventi`
--

DROP TABLE IF EXISTS `eventi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventi` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` varchar(255) DEFAULT NULL,
  `genere` varchar(255) DEFAULT NULL,
  `giorno_settimana` varchar(255) DEFAULT NULL,
  `locandina` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `ora` varchar(255) DEFAULT NULL,
  `tipologia` varchar(255) DEFAULT NULL,
  `id_localita` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjjdab8brgqnsfhtiqe9nmc0bi` (`id_localita`),
  CONSTRAINT `FKjjdab8brgqnsfhtiqe9nmc0bi` FOREIGN KEY (`id_localita`) REFERENCES `localita` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventi`
--

LOCK TABLES `eventi` WRITE;
/*!40000 ALTER TABLE `eventi` DISABLE KEYS */;
INSERT INTO `eventi` VALUES (1,'2024-09-07','Calcio','Lunedì','https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg','Partita','20:30','Sport',1),(2,'2024-07-26','Commedia','Domenica','https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg','Teatro','21:30','Spettacolo',25),(3,'2024-11-13','Commedia','Mercoledì','https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg','Teatro','21:30','Spettacolo',24),(4,'2024-09-07','Commedia','Lunedì','https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg','Teatro','21:30','Spettacolo',3),(5,'2024-11-13','Storico','Lunedì','https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg','Museica','14:30','Visita guidata',6),(6,'2023-07-24','Storico','Sabato','https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg','Museica','14:30','Visita guidata',6),(7,'2023-12-06','Calcio','Giovedì','https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg','Partita','14:30','Sport',1),(8,'2023-07-24','Storico','Sabato','https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg','Museica','14:30','Visita guidata',7),(9,'2023-12-06','Storico','Giovedì','https://www.museoliberazione.it/media/filer_public_thumbnails/filer_public/9a/a8/9aa897bc-c7dd-40c5-a828-8c49c644cfbc/cella_1_fosse_ardeatine_risultato.jpg__3240x2160_q85_subsampling-2.jpg','Museica','13:30','Visita guidata',12),(10,'2023-12-06','Scientifico','Giovedì','https://www.focusjunior.it/content/uploads/2022/06/musei-scientifici.jpg','Museica','14:30','Visita guidata',13),(11,'2023-07-24','Svago','Sabato','https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg','Museica','17:30','Visita libera',15),(12,'2023-12-05','Svago','Domenica','https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg','Museica','17:30','Visita libera',18),(13,'2023-07-24','Storico','Sabato','https://www.comune.pinerolo.to.it/web/images/immagini/pagine/turismo/Musei/Museo_Arma_Cav.jpg','Museica','13:30','Visita guidata',21),(14,'2023-12-05','Storico','Mercoledì','https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg','Museica','17:30','Visita guidata',29),(15,'2023-08-17','Basket','Martedì','https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1','Partita','17:30','Sport',1),(16,'2023-08-17','Pallavolo','Sabato','https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png','Partita','13:30','Sport',4),(17,'2024-07-26','Calcio','Sabato','https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg','Partita','13:30','Sport',5),(18,'2023-07-24','Basket','Lunedì','https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1','Partita','17:30','Sport',14),(19,'2024-07-26','Pallavolo','Martedì','https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png','Partita','17:30','Sport',28),(20,'2024-07-26','Basket','Sabato','https://i0.wp.com/www.linkiesta.it/wp-content/uploads/2020/03/c0633fee-21aa-47e6-b89e-de45d31d95a9_large.jpg?fit=1200%2C638&ssl=1','Partita','13:30','Sport',27),(21,'2024-11-13','Pallavolo','Mercoledì','https://www.uliveto.it/wp-content/uploads/2020/12/Uliveto-Articolo-Dec-Volleyred.png','Partita','17:30','Sport',27),(22,'2024-11-13','Calcio','Mercoledì','https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg','Partita','11:30','Sport',1),(23,'2023-12-06','Calcio','Giovedì','https://cdn.skuola.net/news_foto/image-grabber/image-64621625e9ba2.jpg','Partita','11:30','Sport',10),(24,'2023-12-05','Commedia','Mercoledì','https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg','Teatro','19:30','Spettacolo',2),(25,'2023-12-06','Cabaret','Lunedì','https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png','Teatro','19:30','Spettacolo',19),(26,'2024-09-07','Cabaret','Lunedì','https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png','Teatro','19:30','Spettacolo',9),(27,'2023-07-24','Cabaret','Sabato','https://images.squarespace-cdn.com/content/v1/5dc085fcdab5d85fc866faec/7ebb852a-c145-4b6f-8472-850a53e80e3f/Cabaret+Face+Landscape+psd+copy+%281%29.png','Teatro','19:30','Spettacolo',11),(28,'2023-12-06','Commedia','Domenica','https://www.studiarapido.it/wp-content/uploads/2016/04/commedia.jpg','Teatro','19:30','Spettacolo',16),(29,'2023-07-24','Rock','Domenica','https://www.virginradio.it/resizer/1200/720/true/1522324821926_1522324836.jpg--assistere_a_un_concerto_ogni_quindici_giorni_allunga_la_vita_di_nove_anni__scopri_i_risultati_della_ricerca_.jpg?1522324837541','Musical','22:00','Concerto',17),(30,'2024-11-13','Pop','Mercoledì','https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg','Musical','22:00','Concerto',30),(31,'2023-12-06','Rock','Giovedì','https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg','Musical','21:00','Concerto',30),(32,'2023-08-17','Rock','Domenica','https://www.artribune.com/wp-content/uploads/2020/06/Museo-del-Prado-sala-24.jpg','Musical','20:00','Concerto',19),(33,'2023-07-24','Pop','Sabato','https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg','Musical','22:00','Concerto',17),(34,'2024-09-07','Pop','Lunedì','https://flawless.life/wp-content/uploads/2022/04/I-Concerti-da-non-perdere-in-primavera-a-Milano-cover.jpg','Musical','21:00','Concerto',30);
/*!40000 ALTER TABLE `eventi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-14 10:38:28
