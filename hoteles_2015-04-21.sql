/*
 Navicat Premium Data Transfer

 Source Server         : Mamp
 Source Server Type    : MySQL
 Source Server Version : 50538
 Source Host           : localhost
 Source Database       : hoteles

 Target Server Type    : MySQL
 Target Server Version : 50538
 File Encoding         : utf-8

 Date: 04/22/2015 00:06:20 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `ciudad`
-- ----------------------------
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `ciudad`
-- ----------------------------
BEGIN;
INSERT INTO `ciudad` VALUES ('1', 'Bogotá'), ('2', 'Cali'), ('3', 'Medellín'), ('4', 'Bucaramanga'), ('5', 'Villavicencio');
COMMIT;

-- ----------------------------
--  Table structure for `hotel_habitaciones`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_habitaciones`;
CREATE TABLE `hotel_habitaciones` (
  `id_hotel` int(11) DEFAULT NULL,
  `id_tipo_habitaciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `hotel_habitaciones`
-- ----------------------------
BEGIN;
INSERT INTO `hotel_habitaciones` VALUES ('1', '2'), ('1', '8'), ('1', '5'), ('2', '8'), ('2', '9'), ('2', '10'), ('3', '7'), ('3', '4'), ('3', '6'), ('4', '5'), ('4', '1'), ('4', '5'), ('4', '4'), ('5', '1'), ('5', '9'), ('5', '3'), ('6', '4'), ('7', '3'), ('7', '2'), ('7', '9'), ('8', '1'), ('8', '4'), ('8', null), ('9', '10'), ('9', '9'), ('9', '5'), ('10', '1'), ('10', '10'), ('10', '8');
COMMIT;

-- ----------------------------
--  Table structure for `hotel_servicios`
-- ----------------------------
DROP TABLE IF EXISTS `hotel_servicios`;
CREATE TABLE `hotel_servicios` (
  `id_hotel` int(11) DEFAULT NULL,
  `id_servicios` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `hoteles`
-- ----------------------------
DROP TABLE IF EXISTS `hoteles`;
CREATE TABLE `hoteles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_ciudad` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `hoteles`
-- ----------------------------
BEGIN;
INSERT INTO `hoteles` VALUES ('1', 'hotel1', '12321312', '123123', '1'), ('2', 'hotel2', '98789', '7989', '1'), ('3', 'hotel3', '6876', '786876', '2'), ('4', 'hotel4', '234234', '89u987', '1'), ('5', 'hotel5', '98', '987', '3'), ('6', 'hotel6', '9878', '97898', '5'), ('7', 'hotel7', '98798', '987897', '3'), ('8', 'hotel8', '98789', '987897', '2'), ('9', 'hotel9', '87674556', '564654', '2'), ('10', 'hotel10', '123', '12313', '4');
COMMIT;

-- ----------------------------
--  Table structure for `reserva`
-- ----------------------------
DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `estado` tinyint(4) DEFAULT NULL,
  `fecha_llegada` datetime DEFAULT NULL,
  `fecha_salida` datetime DEFAULT NULL,
  `id_hotel` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_ciudad` int(11) DEFAULT NULL,
  `numero_habitaciones` int(2) DEFAULT NULL,
  `id_habitacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `reserva`
-- ----------------------------
BEGIN;
INSERT INTO `reserva` VALUES ('1', '1', '2015-04-19 22:03:32', '2015-04-30 22:18:31', '1', '1', '1', '2', '1'), ('2', '1', '2015-04-19 23:59:52', '2015-04-19 23:59:55', '2', '2', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `servicios`
-- ----------------------------
DROP TABLE IF EXISTS `servicios`;
CREATE TABLE `servicios` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_servicio` varchar(100) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `tipo_habitacion`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_habitacion`;
CREATE TABLE `tipo_habitacion` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `valor_dia` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `tipo_habitacion`
-- ----------------------------
BEGIN;
INSERT INTO `tipo_habitacion` VALUES ('1', 'th1', '100'), ('2', 'th2', '100'), ('3', 'th3', '100'), ('4', 'th4', '200'), ('5', 'th5', '300'), ('6', 'th6', '800'), ('7', 'th7', '900'), ('8', 'th8', '1000'), ('9', 'th9', '1500'), ('10', 'th10', '200');
COMMIT;

-- ----------------------------
--  Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT '',
  `documento` varchar(100) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `usuarios`
-- ----------------------------
BEGIN;
INSERT INTO `usuarios` VALUES ('1', 'Nestor', 'Castro', '9898', '97987'), ('2', 'jairo', 'blentran', '9898', '97987');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
