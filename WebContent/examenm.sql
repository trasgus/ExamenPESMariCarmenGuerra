-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.tarjeta
CREATE TABLE IF NOT EXISTS `tarjeta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(12) NOT NULL DEFAULT '0',
  `cupoMaximo` int(11) NOT NULL DEFAULT '0',
  `cupoDisponible` int(11) NOT NULL DEFAULT '0',
  `tipo` varchar(10) NOT NULL DEFAULT '0',
  `numeroComprobacion` varchar(7) NOT NULL DEFAULT '0',
  `contrasenha` varchar(4) NOT NULL DEFAULT '0',
  `bloqueada` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero` (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.tarjeta: ~7 rows (aproximadamente)
DELETE FROM `tarjeta`;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` (`id`, `numero`, `cupoMaximo`, `cupoDisponible`, `tipo`, `numeroComprobacion`, `contrasenha`, `bloqueada`) VALUES
	(1, '12521521', 123, 123, 'visa', '12321', '1231', 0),
	(2, '678', 678, 678, 'visa', '789', '789', 0),
	(3, '555', 555, 555, 'visa', '555', '555', 0),
	(4, '777', 777, 777, 'visa', '777', '777', 0),
	(5, '888', 888, 888, 'visa', '888', '888', 0),
	(6, '999', 10000, 10000, 'visa', '999', '999', 0),
	(7, '688', 688, 688, 'visa', '688', '688', 0);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
