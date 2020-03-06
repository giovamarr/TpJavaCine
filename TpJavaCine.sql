-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `butacas`
--

DROP TABLE IF EXISTS `butacas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `butacas` (
  `nrobutaca` int(11) NOT NULL,
  `estadoButaca` int(11) NOT NULL,
  `id_sala` int(11) NOT NULL,
  PRIMARY KEY (`nrobutaca`,`id_sala`),
  KEY `fk_sala_idx` (`id_sala`),
  CONSTRAINT `fk_sala` FOREIGN KEY (`id_sala`) REFERENCES `salas` (`nroSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `butacas`
--

LOCK TABLES `butacas` WRITE;
/*!40000 ALTER TABLE `butacas` DISABLE KEYS */;
INSERT INTO `butacas` VALUES (0,0,62),(0,0,1234),(1,1,1),(1,1,62),(1,0,1234),(2,1,62),(2,0,1234),(3,1,62),(3,0,1234),(4,1,62),(4,0,1234),(5,1,62),(5,0,1234),(6,1,62),(6,0,1234),(7,0,62),(7,0,1234),(8,0,62),(8,0,1234),(9,0,62),(9,0,1234),(10,0,62),(10,0,1234);
/*!40000 ALTER TABLE `butacas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clientes` (
  `nroCliente` int(11) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`nroCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'12','12'),(2,'12','12'),(3,'32','32');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL,
  `id_nrosala` int(11) NOT NULL,
  `id_codPelicula` int(11) NOT NULL,
  `horaFuncion` int(11) NOT NULL,
  `diaFuncion` varchar(50) NOT NULL,
  PRIMARY KEY (`idFuncion`),
  KEY `fksala_idx` (`id_nrosala`),
  KEY `fkpeli_idx` (`id_codPelicula`),
  CONSTRAINT `fkpeli` FOREIGN KEY (`id_codPelicula`) REFERENCES `peliculas` (`codPelicula`),
  CONSTRAINT `fksala` FOREIGN KEY (`id_nrosala`) REFERENCES `salas` (`nroSala`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,5,4,12,'2020-12-12'),(2,62,4,13,'13');
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `peliculas` (
  `codPelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePelicula` varchar(45) NOT NULL,
  `descripcionPelicula` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`codPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (4,'asd','asd'),(8,'aaaaaaaaaaaa','aaaaaaaaaaaa');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reserva` (
  `fechaCompra` varchar(50) DEFAULT NULL,
  `idbutaca` int(11) DEFAULT NULL,
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `idFuncion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fkbutac_idx` (`idbutaca`),
  KEY `fkfunc_idx` (`idFuncion`),
  CONSTRAINT `fkbutacas` FOREIGN KEY (`idbutaca`) REFERENCES `butacas` (`nrobutaca`),
  CONSTRAINT `fkfunc` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `salas` (
  `nroSala` int(11) NOT NULL,
  `estadoSala` int(11) NOT NULL,
  PRIMARY KEY (`nroSala`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (1,0),(2,1),(3,0),(5,1),(6,1),(7,1),(8,1),(9,0),(10,1),(14,1),(18,4),(25,1),(44,1),(45,1),(52,0),(62,1),(63,0),(64,1),(65,0),(84,1),(87,1),(92,1),(99,1),(112,1),(158,1),(198,1),(298,1),(465,1),(546,1),(645,1),(654,1),(864,1),(948,1),(949,1),(978,1),(1234,1),(2196,1),(2245,1),(2965,1);
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarjeta` (
  `idTarjeta` int(11) NOT NULL,
  `empresa` varchar(45) NOT NULL,
  `fechaVto` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`idTarjeta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `id` int(10) unsigned NOT NULL,
  `email` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'aa','aa','aa','123','',''),(2,'email','email','email','pass','','');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-06 13:22:54
