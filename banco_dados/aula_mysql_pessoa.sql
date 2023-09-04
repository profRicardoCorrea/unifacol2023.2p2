-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aula_mysql
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idpessoa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(145) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `numero_reserista` varchar(45) DEFAULT NULL,
  `idendereco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpessoa`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Fulano da Silva','10101010101',NULL,NULL,NULL,NULL,NULL),(2,'Fulano da Silva Filho','1454545455','2020-01-01','MASCULINO','0000001','0222222',NULL),(3,'Rodelillo Airport','1111111111',NULL,NULL,'Watson',NULL,NULL),(4,'Dubrovnik Airport','1111111122',NULL,NULL,'Metheringham',NULL,NULL),(5,'Bismarck Municipal Airport','1111111133',NULL,NULL,'McCarroll',NULL,NULL),(6,'Midland Airpark','1111111144',NULL,NULL,'Haruard',NULL,NULL),(7,'Stan Stamper Municipal Airport','1111111155',NULL,NULL,'Kobpa',NULL,NULL),(8,'Sovetskiy Airport','1111111166',NULL,NULL,'Ingraham',NULL,NULL),(9,'Doutor Heráclito da Motta Luiz Airport','1111111177',NULL,NULL,'Biggans',NULL,NULL),(10,'Norfolk Naval Station (Chambers Field)','1111111188',NULL,NULL,'Rosendall',NULL,NULL),(11,'Windarra Airport','1111111199',NULL,NULL,'Rosensaft',NULL,NULL),(12,'Welshpool Airport','1111111210',NULL,NULL,'Bauckham',NULL,NULL),(13,'Sawan Airport','1111111221',NULL,NULL,'Meekin',NULL,NULL),(14,'Arathusa Safari Lodge Airport','1111111232',NULL,NULL,'Atwell',NULL,NULL),(15,'Minami Torishima Airport','1111111243',NULL,NULL,'Rippon',NULL,NULL),(16,'Usinsk Airport','1111111254',NULL,NULL,'Kirsch',NULL,NULL),(17,'Rishiri Airport','1111111265',NULL,NULL,'Veryard',NULL,NULL),(18,'Chevery Airport','1111111276',NULL,NULL,'Dalgetty',NULL,NULL),(19,'Mount Swan Airport','1111111287',NULL,NULL,'Spears',NULL,NULL),(20,'Glasgow Municipal Airport','1111111298',NULL,NULL,'Calken',NULL,NULL),(21,'Vatulele Airport','1111111309',NULL,NULL,'Standidge',NULL,NULL),(22,'Nain Airport','1111111320',NULL,NULL,'Malley',NULL,NULL),(23,'Ravensthorpe Airport','1111111331',NULL,NULL,'Bradlaugh',NULL,NULL),(24,'Tapeta Airport','1111111342',NULL,NULL,'Allibone',NULL,NULL),(25,'Chicago Rockford International Airport','1111111353',NULL,NULL,'Bleier',NULL,NULL),(26,'Taylor County Airport','1111111364',NULL,NULL,'Meece',NULL,NULL),(27,'Lakeland Airport','1111111375',NULL,NULL,'McCuffie',NULL,NULL),(28,'Diego Jimenez Torres Airport','1111111386',NULL,NULL,'McLae',NULL,NULL),(29,'Kassala Airport','1111111397',NULL,NULL,'Knights',NULL,NULL),(30,'Seunagan Airport','1111111408',NULL,NULL,'Cuppitt',NULL,NULL),(31,'Mogilev Airport','1111111419',NULL,NULL,'Timmes',NULL,NULL),(32,'Rurenabaque Airport','1111111430',NULL,NULL,'Nyssens',NULL,NULL),(33,'Chkalovskiy Air Base','1111111441',NULL,NULL,'Casarini',NULL,NULL),(34,'Piracicaba Airport','1111111452',NULL,NULL,'Beer',NULL,NULL),(35,'Moussoro Airport','1111111463',NULL,NULL,'Drinkel',NULL,NULL),(36,'Virginia Airport','1111111474',NULL,NULL,'Giblett',NULL,NULL),(37,'Lightning Ridge Airport','1111111485',NULL,NULL,'Alexandersen',NULL,NULL),(38,'Barriles Airport','1111111496',NULL,NULL,'Dellenbach',NULL,NULL),(39,'Mackall Army Air Field','1111111507',NULL,NULL,'Janicek',NULL,NULL),(40,'Ficksburg Sentraoes Airport','1111111518',NULL,NULL,'Chartman',NULL,NULL),(41,'Bisha Airport','1111111529',NULL,NULL,'Yurevich',NULL,NULL),(42,'Burg Feuerstein Airport','1111111540',NULL,NULL,'Ringwood',NULL,NULL),(43,'Gilgit Airport','1111111551',NULL,NULL,'Freeborne',NULL,NULL),(44,'Iwakuni Marine Corps Air Station','1111111562',NULL,NULL,'Astbery',NULL,NULL),(45,'Gamboa Airport','1111111573',NULL,NULL,'Hardway',NULL,NULL),(46,'Termal Airport','1111111584',NULL,NULL,'Lowings',NULL,NULL),(47,'John F Kennedy International Airport','1111111595',NULL,NULL,'Kless',NULL,NULL),(48,'Rexburg Madison County Airport','1111111606',NULL,NULL,'Lys',NULL,NULL),(49,'Yuendumu Airport','1111111617',NULL,NULL,'MacAlpine',NULL,NULL),(50,'Ruti Airport','1111111628',NULL,NULL,'Inchcomb',NULL,NULL),(51,'Vanua Balavu Airport','1111111639',NULL,NULL,'Baynam',NULL,NULL),(52,'Reginaldo Hammer Airport','1111111650',NULL,NULL,'Blastock',NULL,NULL),(53,'Samjiyŏn Airport','1111111661',NULL,NULL,'Hovard',NULL,NULL),(54,'Sharurah Airport','1111111672',NULL,NULL,'Brammer',NULL,NULL),(55,'American River Airport','1111111683',NULL,NULL,'MacNeilage',NULL,NULL),(56,'Columbia Metropolitan Airport','1111111694',NULL,NULL,'Jindrak',NULL,NULL),(57,'Perth Jandakot Airport','1111111705',NULL,NULL,'Tohill',NULL,NULL),(58,'Stephens Island Seaplane Base','1111111716',NULL,NULL,'Kielt',NULL,NULL),(59,'Carcassonne Airport','1111111727',NULL,NULL,'Eschalotte',NULL,NULL),(60,'Exmouth Airport','1111111738',NULL,NULL,'Hamor',NULL,NULL),(61,'Mahenye Airport','1111111749',NULL,NULL,'Blackford',NULL,NULL),(62,'Ono-i-Lau Airport','1111111760',NULL,NULL,'O\'Carrol',NULL,NULL),(63,'St George Municipal Airport','1111111771',NULL,NULL,'Theis',NULL,NULL),(64,'Querétaro Intercontinental Airport','1111111782',NULL,NULL,'Cowland',NULL,NULL),(65,'Marina Municipal Airport','1111111793',NULL,NULL,'MacTerrelly',NULL,NULL),(66,'Sørkjosen Airport','1111111804',NULL,NULL,'Scotcher',NULL,NULL),(67,'Blackpool International Airport','1111111815',NULL,NULL,'Toor',NULL,NULL),(68,'Aitutaki Airport','1111111826',NULL,NULL,'Duffan',NULL,NULL),(69,'Elrose Airport','1111111837',NULL,NULL,'Betun',NULL,NULL),(70,'Adado Airport','1111111848',NULL,NULL,'Varlow',NULL,NULL),(71,'Baoshan Yunduan Airport','1111111859',NULL,NULL,'Kencott',NULL,NULL),(72,'Staroselye Airport','1111111870',NULL,NULL,'Frankcomb',NULL,NULL),(73,'Qishn Airport','1111111881',NULL,NULL,'Bomfield',NULL,NULL),(74,'Warren \"Bud\" Woods Palmer Municipal Airport','1111111892',NULL,NULL,'Doran',NULL,NULL),(75,'Gamba Airport','1111111903',NULL,NULL,'McDool',NULL,NULL),(76,'Ben Bruce Memorial Airpark','1111111914',NULL,NULL,'Iannazzi',NULL,NULL),(77,'Muttaburra Airport','1111111925',NULL,NULL,'Glasebrook',NULL,NULL),(78,'Junin Airport','1111111936',NULL,NULL,'Hulke',NULL,NULL),(79,'Helsinki Vantaa Airport','1111111947',NULL,NULL,'McDunlevy',NULL,NULL),(80,'Pike County-Hatcher Field','1111111958',NULL,NULL,'Newvell',NULL,NULL),(81,'Gatokae Airport','1111111969',NULL,NULL,'Sabin',NULL,NULL),(82,'Marcos A. Gelabert International Airport','1111111980',NULL,NULL,'Allabush',NULL,NULL),(83,'Anshan Air Base','1111111991',NULL,NULL,'Mundy',NULL,NULL),(84,'Along Airport','1111112002',NULL,NULL,'Smallridge',NULL,NULL),(85,'Pasir Pangaraan Airport','1111112013',NULL,NULL,'McCritchie',NULL,NULL),(86,'Torwood Airport','1111112024',NULL,NULL,'Breed',NULL,NULL),(87,'Mogilev Airport','1111112035',NULL,NULL,'Ruby',NULL,NULL),(88,'Kolhapur Airport','1111112046',NULL,NULL,'Tappor',NULL,NULL),(89,'Kiev Zhuliany International Airport','1111112057',NULL,NULL,'Juszczak',NULL,NULL),(90,'Sesriem Airstrip','1111112068',NULL,NULL,'Vasyutkin',NULL,NULL),(91,'EuroAirport Basel-Mulhouse-Freiburg Airport','1111112079',NULL,NULL,'Beers',NULL,NULL),(92,'Melangguane Airport','1111112090',NULL,NULL,'Fane',NULL,NULL),(93,'Nyurba Airport','1111112101',NULL,NULL,'Adey',NULL,NULL),(94,'Spencer Municipal Airport','1111112112',NULL,NULL,'Sansum',NULL,NULL),(95,'Bonnyville Airport','1111112123',NULL,NULL,'Gottelier',NULL,NULL),(96,'Greymouth Airport','1111112134',NULL,NULL,'Hand',NULL,NULL),(97,'Bambu Airport','1111112145',NULL,NULL,'Round',NULL,NULL),(98,'Magway Airport','1111112156',NULL,NULL,'Hayers',NULL,NULL),(99,'Austin Bergstrom International Airport','1111112167',NULL,NULL,'Zannelli',NULL,NULL),(100,'Seguela Airport','1111112178',NULL,NULL,'Goatcher',NULL,NULL),(101,'Valence-Chabeuil Airport','1111112189',NULL,NULL,'Perri',NULL,NULL),(102,'Chickasha Municipal Airport','1111112200',NULL,NULL,'Evens',NULL,NULL),(103,'Chatham Kent Airport','1111112211',NULL,NULL,'Flinders',NULL,NULL);
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-04 20:27:49
