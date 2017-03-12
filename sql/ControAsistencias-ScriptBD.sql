/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : controasistencias

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-01-22 05:33:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agencia
-- ----------------------------
DROP TABLE IF EXISTS `agencia`;
CREATE TABLE `agencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of agencia
-- ----------------------------
INSERT INTO `agencia` VALUES ('1', 'PIURA');
INSERT INTO `agencia` VALUES ('2', 'SULLANA');
INSERT INTO `agencia` VALUES ('3', 'PAITA');

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES ('1', 'PROGRAMACION');
INSERT INTO `cargo` VALUES ('2', 'PERSONAL');
INSERT INTO `cargo` VALUES ('3', 'JEFE DE AREA');
INSERT INTO `cargo` VALUES ('4', 'ADMINISTRACION');

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(8) NOT NULL,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidop` VARCHAR(50) NOT NULL,
  `apellidom` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `fechanac` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=INNODB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of persona
-- ----------------------------
INSERT INTO `persona` VALUES ('1', '74859612', 'Ricardo', 'Arevalo', 'Rios','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('2', '65321478', 'Tomas', 'Roca', 'Maes','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('3', '96125475', 'Carmen', 'Baca', 'Montero','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('4', '96354214', 'Cristina', 'Curo', 'Curo','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('5', '68750210', 'Cristobal', 'Luque', 'Soria','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('6', '30245875', 'Jose', 'Gonzales', 'Soria','PIURA','1980-01-01');
INSERT INTO `persona` VALUES ('7', '75423561', 'Luis', 'Marcelo', 'Quito','PIURA','1980-01-01');
-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES ('1', 'ADMINISTRADOR');
INSERT INTO `rol` VALUES ('2', 'EMPLEADO');

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `persona_usuario_fk` (`idpersona`),
  KEY `rol_usuario_fk` (`rol`),
  CONSTRAINT `persona_usuario_fk` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rol_usuario_fk` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for marcador
-- ----------------------------
DROP TABLE IF EXISTS `marcador`;
CREATE TABLE `marcador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agencia` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ip` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ip` (`ip`),
  KEY `agencia_marcador_fk` (`agencia`),
  CONSTRAINT `agencia_marcador_fk` FOREIGN KEY (`agencia`) REFERENCES `agencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of marcador
-- ----------------------------
INSERT INTO `marcador` VALUES ('1', '1', 'mar1', '128.0.0.0');
INSERT INTO `marcador` VALUES ('2', '2', 'mar2', '129.0.0.0');
INSERT INTO `marcador` VALUES ('4', '2', 'mar3', '130.0.0.0');

-- ----------------------------
-- Table structure for tarjeta
-- ----------------------------
DROP TABLE IF EXISTS `tarjeta`;
CREATE TABLE `tarjeta` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(50) NOT NULL,
  `fechacreacion` DATETIME NOT NULL,
  `fechaactualizacion` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tarjeta
-- ----------------------------
INSERT INTO `tarjeta` VALUES ('1', '123456', '2017-01-22 03:27:58', '2017-01-22 05:28:05');
INSERT INTO `tarjeta` VALUES ('2', '120547', '2017-01-16 05:28:31', '2017-01-18 05:28:35');
INSERT INTO `tarjeta` VALUES ('3', '524875', '2017-01-02 05:28:48', '2017-01-22 05:28:52');
INSERT INTO `tarjeta` VALUES ('4', '8594q7', '2017-01-10 05:29:05', '2017-01-21 05:29:08');
INSERT INTO `tarjeta` VALUES ('5', '698542', '2017-01-03 05:29:18', '2017-01-04 05:29:21');


-- ----------------------------
-- Table structure for perfilvacaciones
-- ----------------------------
DROP TABLE IF EXISTS `perfilvacaciones`;
CREATE TABLE `perfilvacaciones` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `fechainicio` DATE NOT NULL,
  `fechafin` DATE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of perfilvacaciones
-- ----------------------------
INSERT INTO `perfilvacaciones` VALUES ('1', '2017-01-02', '2017-01-06');

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` int(11) NOT NULL,
  `agencia` int(11) NOT NULL,
  `tarjeta` int(11) NOT NULL,
  --`PersCod` varchar(50) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechaactualizacion` datetime NOT NULL,
  `vigente` INT DEFAULT 1 NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `persona_empleado_fk` (`idpersona`),
  KEY `tarjeta_empleado_fk` (`tarjeta`),
  KEY `agencia_empleado_fk` (`agencia`),
  KEY `cargo_empleado_fk` (`cargo`),
  CONSTRAINT `agencia_empleado_fk` FOREIGN KEY (`agencia`) REFERENCES `agencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cargo_empleado_fk` FOREIGN KEY (`cargo`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persona_empleado_fk` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarjeta_empleado_fk` FOREIGN KEY (`tarjeta`) REFERENCES `tarjeta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empleado
-- ----------------------------

-- ----------------------------
-- Table structure for horario
-- ----------------------------
DROP TABLE IF EXISTS `horario`;
CREATE TABLE `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `refrigerio` tinyint(1) NOT NULL,
  `empleado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empleado_horario_fk` (`empleado`),
  CONSTRAINT `empleado_horario_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of horario
-- ----------------------------

-- ----------------------------
-- Table structure for dia
-- ----------------------------
DROP TABLE IF EXISTS `dia`;
CREATE TABLE `dia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `horaEn` time NOT NULL,
  `horaSa` time NOT NULL,
  `hora_ren` time NOT NULL,
  `hora_rsa` time NOT NULL,
  `fecha` date NOT NULL,
  `horario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `horario_dia_fk` (`horario`),
  CONSTRAINT `horario_dia_fk` FOREIGN KEY (`horario`) REFERENCES `horario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dia
-- ----------------------------




-- ----------------------------
-- Table structure for registro
-- ----------------------------
DROP TABLE IF EXISTS `registro`;
CREATE TABLE `registro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `hora_en_real` time NOT NULL,
  `hora_sa_real` time NOT NULL,
  `hora_ren_real` time NOT NULL,
  `dia_1` int(11) NOT NULL,
  `hora_rsa_real` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dia_registro_fk` (`dia_1`),
  CONSTRAINT `dia_registro_fk` FOREIGN KEY (`dia_1`) REFERENCES `dia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of registro
-- ----------------------------


-- ----------------------------
-- Table structure for vacaciones
-- ----------------------------
DROP TABLE IF EXISTS `vacaciones`;
CREATE TABLE `vacaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `perfilvacaciones_vacaciones_fk` (`perfil`),
  KEY `empleado_vacaciones_fk` (`empleado`),
  CONSTRAINT `empleado_vacaciones_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perfilvacaciones_vacaciones_fk` FOREIGN KEY (`perfil`) REFERENCES `perfilvacaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of vacaciones
-- ----------------------------
