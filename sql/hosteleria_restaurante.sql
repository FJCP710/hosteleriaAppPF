-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: hosteleria
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurante` (
  `id_restaurante` int NOT NULL AUTO_INCREMENT,
  `nombre_comercial` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `razon_social` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `calle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci NOT NULL,
  `numero` int NOT NULL,
  `ciudad` varchar(60) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `aforo` int NOT NULL,
  `mesas_disponibles` int NOT NULL,
  `reservar_local` tinyint NOT NULL,
  `correo` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`id_restaurante`),
  UNIQUE KEY `razon_social_UNIQUE` (`razon_social`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (1,'bar de paco','barPaco','Virgen de los Reyes',2,'Sevilla',50,9,0,'paco@correo.es'),(2,'Restaurante El Jardín','El Jardín S.L.','Calle de la Rosa',3,'Ourense',50,10,0,'jardin@correo.es'),(3,'Restaurante Bosque','Bosque SL','Virgen de los Reyes',6,'Sevilla',35,5,1,'bosque@correo.es'),(9,'bar Mari','Mari SA','Virgen de los Reyes',8,'Ourense',25,8,1,'mari@correo.es'),(10,'Restaurante CarneRes','Res Res','Calle Agua',9,'Sevilla',10,5,0,'res@correo.es'),(11,'BarJose','Jose A','Calle Monica',11,'Sevilla',42,7,1,'jose@correo.es');
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-31 10:18:17
