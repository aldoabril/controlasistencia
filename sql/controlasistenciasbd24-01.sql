/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : controlasistenciasbd

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-01-24 23:41:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agencia
-- ----------------------------
DROP TABLE IF EXISTS `agencia`;
CREATE TABLE `agencia` (
  `id` int(11) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for asistencia
-- ----------------------------
DROP TABLE IF EXISTS `asistencia`;
CREATE TABLE `asistencia` (
  `id` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `entrada` time NOT NULL,
  `salida` time NOT NULL,
  `refrigerioen` time NOT NULL,
  `refrigeriosa` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dia_asistencia_fk` (`dia`),
  CONSTRAINT `dia_asistencia_fk` FOREIGN KEY (`dia`) REFERENCES `dia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for dia
-- ----------------------------
DROP TABLE IF EXISTS `dia`;
CREATE TABLE `dia` (
  `id` int(11) NOT NULL,
  `nombre` char(1) NOT NULL,
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
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `cargo` int(11) NOT NULL,
  `PersCod` varchar(50) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechaactualizacion` datetime NOT NULL,
  `vigente` tinyint(1) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `usuariocreador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `persona_empleado_fk` (`idpersona`),
  KEY `cargo_empleado_fk` (`cargo`),
  KEY `usuario_empleado_fk` (`usuariocreador`),
  CONSTRAINT `usuario_empleado_fk` FOREIGN KEY (`usuariocreador`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cargo_empleado_fk` FOREIGN KEY (`cargo`) REFERENCES `cargo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persona_empleado_fk` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for empleado_agencia
-- ----------------------------
DROP TABLE IF EXISTS `empleado_agencia`;
CREATE TABLE `empleado_agencia` (
  `id` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `agencia` int(11) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechaact` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `agencia_empleado_agencia_fk` (`agencia`),
  KEY `empleado_empleado_agencia_fk` (`empleado`),
  CONSTRAINT `empleado_empleado_agencia_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `agencia_empleado_agencia_fk` FOREIGN KEY (`agencia`) REFERENCES `agencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for empleado_horario
-- ----------------------------
DROP TABLE IF EXISTS `empleado_horario`;
CREATE TABLE `empleado_horario` (
  `id` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `horario` int(11) NOT NULL,
  `fechacreado` datetime NOT NULL,
  `fechaact` datetime NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `horario_empleado_horario_fk` (`horario`),
  KEY `usuario_empleado_horario_fk` (`usuario`),
  KEY `empleado_empleado_horario_fk` (`empleado`),
  CONSTRAINT `empleado_empleado_horario_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `horario_empleado_horario_fk` FOREIGN KEY (`horario`) REFERENCES `horario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `usuario_empleado_horario_fk` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for horario
-- ----------------------------
DROP TABLE IF EXISTS `horario`;
CREATE TABLE `horario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `refrigerio` tinyint(1) NOT NULL,
  `vigente` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for hora_extra
-- ----------------------------
DROP TABLE IF EXISTS `hora_extra`;
CREATE TABLE `hora_extra` (
  `id` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `tiempoextr` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dia_hora_extra_fk` (`dia`),
  KEY `empleado_hora_extra_fk` (`empleado`),
  CONSTRAINT `empleado_hora_extra_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dia_hora_extra_fk` FOREIGN KEY (`dia`) REFERENCES `dia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for huella
-- ----------------------------
DROP TABLE IF EXISTS `huella`;
CREATE TABLE `huella` (
  `id` int(11) NOT NULL,
  `fechacrea` datetime NOT NULL,
  `fechaact` datetime NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `empleado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empleado_huella_fk` (`empleado`),
  CONSTRAINT `empleado_huella_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for marcador
-- ----------------------------
DROP TABLE IF EXISTS `marcador`;
CREATE TABLE `marcador` (
  `id` int(11) NOT NULL,
  `agencia` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ip` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ip` (`ip`),
  KEY `agencia_marcador_fk` (`agencia`),
  CONSTRAINT `agencia_marcador_fk` FOREIGN KEY (`agencia`) REFERENCES `agencia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for perfilvacaciones
-- ----------------------------
DROP TABLE IF EXISTS `perfilvacaciones`;
CREATE TABLE `perfilvacaciones` (
  `id` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for permiso
-- ----------------------------
DROP TABLE IF EXISTS `permiso`;
CREATE TABLE `permiso` (
  `id` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dia_permiso_fk` (`dia`),
  KEY `empleado_permiso_fk` (`empleado`),
  CONSTRAINT `empleado_permiso_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dia_permiso_fk` FOREIGN KEY (`dia`) REFERENCES `dia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidop` varchar(50) NOT NULL,
  `apellidom` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for registro
-- ----------------------------
DROP TABLE IF EXISTS `registro`;
CREATE TABLE `registro` (
  `id` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `dia` int(11) NOT NULL,
  `hora_en_real` time NOT NULL,
  `hora_sa_real` time NOT NULL,
  `hora_ren_real` time NOT NULL,
  `hora_rsa_real` time NOT NULL,
  `empleado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empleado_registro_fk` (`empleado`),
  CONSTRAINT `empleado_registro_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tarjeta
-- ----------------------------
DROP TABLE IF EXISTS `tarjeta`;
CREATE TABLE `tarjeta` (
  `id` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechaactualizacion` datetime NOT NULL,
  `empleado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `empleado_tarjeta_fk` (`empleado`),
  CONSTRAINT `empleado_tarjeta_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `rol` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `persona_usuario_fk` (`idpersona`),
  KEY `rol_usuario_fk` (`rol`),
  CONSTRAINT `rol_usuario_fk` FOREIGN KEY (`rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `persona_usuario_fk` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for vacaciones
-- ----------------------------
DROP TABLE IF EXISTS `vacaciones`;
CREATE TABLE `vacaciones` (
  `id` int(11) NOT NULL,
  `perfil` int(11) NOT NULL,
  `empleado` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `perfilvacaciones_vacaciones_fk` (`perfil`),
  KEY `empleado_vacaciones_fk` (`empleado`),
  CONSTRAINT `empleado_vacaciones_fk` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perfilvacaciones_vacaciones_fk` FOREIGN KEY (`perfil`) REFERENCES `perfilvacaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
