-- --------------------------------------------------------
-- Host:                         80.59.11.241
-- Versión del servidor:         10.5.8-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para sge_crud_python
CREATE DATABASE IF NOT EXISTS `sge_crud_python` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sge_crud_python`;

-- Volcando estructura para tabla sge_crud_python.ingresos
CREATE TABLE IF NOT EXISTS `ingresos` (
  `idIngreso` int(11) NOT NULL AUTO_INCREMENT,
  `procedencia` varchar(40) NOT NULL DEFAULT 'Desconocida',
  `fechaIngreso` timestamp NOT NULL DEFAULT current_timestamp(),
  `numPlanta` char(2) NOT NULL DEFAULT '1',
  `numCama` char(2) NOT NULL DEFAULT '1',
  `observaciones` varchar(100) DEFAULT NULL,
  `idPaciente` int(11) NOT NULL,
  `idMedico` int(11) NOT NULL,
  PRIMARY KEY (`idIngreso`),
  KEY `ingresos_ibfk_1` (`idPaciente`),
  KEY `ingresos_ibfk_2` (`idMedico`),
  CONSTRAINT `ingresos_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ingresos_ibfk_2` FOREIGN KEY (`idMedico`) REFERENCES `medicos` (`idMedico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sge_crud_python.ingresos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;

-- Volcando estructura para tabla sge_crud_python.medicos
CREATE TABLE IF NOT EXISTS `medicos` (
  `idMedico` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `numColegiado` varchar(10) NOT NULL,
  `cargo` varchar(20) NOT NULL DEFAULT 'Interino',
  `observaciones` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idMedico`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sge_crud_python.medicos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;

-- Volcando estructura para tabla sge_crud_python.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `numSeguridadSocial` char(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `direccion` varchar(40) NOT NULL DEFAULT 'España',
  `poblacion` varchar(20) NOT NULL DEFAULT 'España',
  `provincia` varchar(20) NOT NULL DEFAULT 'España',
  `cp` char(5) NOT NULL DEFAULT '10000',
  `telefono` char(9) NOT NULL DEFAULT '123456789',
  `numHistorial` char(10) NOT NULL DEFAULT '9876543210',
  `observaciones` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `numSeguridadSocial` (`numSeguridadSocial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla sge_crud_python.pacientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
