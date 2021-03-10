CREATE DATABASE  IF NOT EXISTS `ddi_e1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ddi_e1`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: ddi_e1
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `CodigoAlumno` int NOT NULL,
  `DNI` char(9) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellidos` varchar(80) NOT NULL,
  `FechaNac` date NOT NULL,
  PRIMARY KEY (`CodigoAlumno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'52680032F','Manuel','Perera Jiménez','2001-10-02'),(2,'20095466K','Martín','Rodríguez García','1998-04-18'),(3,'87623497A','Baldomero','Peña Peña','1997-05-22'),(4,'77382991Y','Sara','Sánchez Martínez','1990-12-28');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignados`
--

DROP TABLE IF EXISTS `asignados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignados` (
  `CodigoAlumno` int NOT NULL,
  `CodEmpresa` int NOT NULL,
  `CodigoTutor` int NOT NULL,
  PRIMARY KEY (`CodigoAlumno`,`CodEmpresa`,`CodigoTutor`),
  KEY `CodEmpresa` (`CodEmpresa`),
  KEY `CodigoTutor` (`CodigoTutor`),
  CONSTRAINT `asignados_ibfk_1` FOREIGN KEY (`CodigoAlumno`) REFERENCES `alumnos` (`CodigoAlumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asignados_ibfk_2` FOREIGN KEY (`CodEmpresa`) REFERENCES `empresas` (`CodEmpresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `asignados_ibfk_3` FOREIGN KEY (`CodigoTutor`) REFERENCES `tutoresdocentes` (`CodigoTutor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignados`
--

LOCK TABLES `asignados` WRITE;
/*!40000 ALTER TABLE `asignados` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresas` (
  `CodEmpresa` int NOT NULL,
  `Nombre` varchar(80) NOT NULL,
  `CIF` char(9) NOT NULL,
  `Direccion` varchar(150) NOT NULL,
  `CP` char(5) NOT NULL,
  `Localidad` varchar(60) NOT NULL,
  `TipoJornada` varchar(8) NOT NULL,
  `DNIResp` char(9) NOT NULL,
  `NombreResp` varchar(40) NOT NULL,
  `ApellidosResp` varchar(80) NOT NULL,
  `DNITL` char(9) NOT NULL,
  `NombreTL` varchar(40) NOT NULL,
  `ApellidosTL` varchar(80) NOT NULL,
  `EmailTL` varchar(50) NOT NULL,
  `TelefonoTL` char(9) NOT NULL,
  PRIMARY KEY (`CodEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'Spyro','86022469L','c/ Tomatoe','33967','Cádiz','Continua','86477513P','Carlos','Rodríguez Ocelote','16499237K','Laura','López Pérez','laurita_morenita1992@gmail.com','916348162'),(2,'Wumpa Fruit','16723549L','c/ Crash Bandicoot','55691','Sevilla','Partida','76284953L','Enrique','Cedeño Xpeke','64523791K','Mario','Pepino Fernández','mario_redondito@gmail.com','923652478'),(3,'SuperCell','16481362L','c/ Bárbaro','11339','Toledo','Continua','91645129L','Salvador','Viciado Lolito','61894635K','David','Torres Hernández','davisillo_lokillo@gmail.com','945378162');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutoresdocentes`
--

DROP TABLE IF EXISTS `tutoresdocentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutoresdocentes` (
  `CodigoTutor` int NOT NULL,
  `NomAp` varchar(40) NOT NULL,
  `EmailTD` varchar(50) NOT NULL,
  `TelefonoTD` varchar(9) NOT NULL,
  PRIMARY KEY (`CodigoTutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutoresdocentes`
--

LOCK TABLES `tutoresdocentes` WRITE;
/*!40000 ALTER TABLE `tutoresdocentes` DISABLE KEYS */;
INSERT INTO `tutoresdocentes` VALUES (1,'Prudencio Ruiz','pruiz@fundacionsafa.es','666777888'),(2,'José Ignacio Naranjo','jnaranjo@fundacionsafa.es','676767676'),(3,'Alex Tolon','atolon@fundacionsafa.es','686868686'),(4,'Ana Coello','acoello@fundacionsafa.es','654321987');
/*!40000 ALTER TABLE `tutoresdocentes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-07 12:27:44
