CREATE DATABASE  IF NOT EXISTS `cine` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cine`;

DROP TABLE IF EXISTS `salas`;

CREATE TABLE `salas` (
  `nroSala` int NOT NULL,
   PRIMARY KEY (`patente`),
   ) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;