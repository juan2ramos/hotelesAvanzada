# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: localhost (MySQL 5.5.38)
# Database: hoteles
# Generation Time: 2015-04-22 04:30:05 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ciudad
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ciudad`;

CREATE TABLE `ciudad` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;

INSERT INTO `ciudad` (`id`, `nombre`)
VALUES
	(1,'Bogotá'),
	(2,'Cali'),
	(3,'Medellín'),
	(4,'Bucaramanga'),
	(5,'Villavicencio');

/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hotel_habitaciones
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hotel_habitaciones`;

CREATE TABLE `hotel_habitaciones` (
  `id_hotel` int(11) DEFAULT NULL,
  `id_tipo_habitaciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `hotel_habitaciones` WRITE;
/*!40000 ALTER TABLE `hotel_habitaciones` DISABLE KEYS */;

INSERT INTO `hotel_habitaciones` (`id_hotel`, `id_tipo_habitaciones`)
VALUES
	(1,2),
	(1,8),
	(1,5),
	(2,8),
	(2,9),
	(2,10),
	(3,7),
	(3,4),
	(3,6),
	(4,5),
	(4,1),
	(4,5),
	(4,4),
	(5,1),
	(5,9),
	(5,3),
	(6,4),
	(7,3),
	(7,2),
	(7,9),
	(8,1),
	(8,4),
	(8,NULL),
	(9,10),
	(9,9),
	(9,5),
	(10,1),
	(10,10),
	(10,8);

/*!40000 ALTER TABLE `hotel_habitaciones` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table hotel_servicios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hotel_servicios`;

CREATE TABLE `hotel_servicios` (
  `id_hotel` int(11) DEFAULT NULL,
  `id_servicios` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table hoteles
# ------------------------------------------------------------

DROP TABLE IF EXISTS `hoteles`;

CREATE TABLE `hoteles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_ciudad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `hoteles` WRITE;
/*!40000 ALTER TABLE `hoteles` DISABLE KEYS */;

INSERT INTO `hoteles` (`id`, `nombre`, `telefono`, `direccion`, `id_ciudad`)
VALUES
	(1,'hotel1','12321312','123123',1),
	(2,'hotel2','98789','7989',1),
	(3,'hotel3','6876','786876',2),
	(4,'hotel4','234234','89u987',1),
	(5,'hotel5','98','987',3),
	(6,'hotel6','9878','97898',5),
	(7,'hotel7','98798','987897',3),
	(8,'hotel8','98789','987897',2),
	(9,'hotel9','87674556','564654',2),
	(10,'hotel10','123','12313',4);

/*!40000 ALTER TABLE `hoteles` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table reserva
# ------------------------------------------------------------

DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `reserva` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fecha_llegada` datetime DEFAULT NULL,
  `fecha_salida` datetime DEFAULT NULL,
  `id_hotel` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_ciudad` int(11) DEFAULT NULL,
  `numero_habitaciones` int(2) DEFAULT NULL,
  `id_habitacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;

INSERT INTO `reserva` (`id`, `fecha_llegada`, `fecha_salida`, `id_hotel`, `id_usuario`, `id_ciudad`, `numero_habitaciones`, `id_habitacion`)
VALUES
	(1,'2015-04-19 22:03:32','2015-04-30 22:18:31',1,1,1,2,1),
	(2,'2015-04-19 23:59:52','2015-04-19 23:59:55',2,2,1,1,1);

/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table servicios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `servicios`;

CREATE TABLE `servicios` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_servicio` varchar(100) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table tipo_habitacion
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tipo_habitacion`;

CREATE TABLE `tipo_habitacion` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `valor_dia` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `tipo_habitacion` WRITE;
/*!40000 ALTER TABLE `tipo_habitacion` DISABLE KEYS */;

INSERT INTO `tipo_habitacion` (`id`, `nombre`, `valor_dia`)
VALUES
	(1,'th1',100),
	(2,'th2',100),
	(3,'th3',100),
	(4,'th4',200),
	(5,'th5',300),
	(6,'th6',800),
	(7,'th7',900),
	(8,'th8',1000),
	(9,'th9',1500),
	(10,'th10',200);

/*!40000 ALTER TABLE `tipo_habitacion` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table usuarios
# ------------------------------------------------------------

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT '',
  `documento` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `documento`, `telefono`)
VALUES
	(1,'Nestor','Castro','9898','97987'),
	(2,'jairo','blentran','9898','97987');

/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
