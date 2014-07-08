/*
SQLyog Ultimate v9.02 
MySQL - 5.6.16 : Database - estudio_juridico
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`estudio_juridico` /*!40100 DEFAULT CHARACTER SET latin1 */;

/*Table structure for table `arancel` */

CREATE TABLE `arancel` (
  `id_ara` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `costo` float NOT NULL DEFAULT '0',
  `flag` int(1) NOT NULL,
  PRIMARY KEY (`id_ara`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `backup` */

CREATE TABLE `backup` (
  `id_back` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sql` text,
  PRIMARY KEY (`id_back`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `cargo` */

CREATE TABLE `cargo` (
  `id_car` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_car`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `caso` */

CREATE TABLE `caso` (
  `id_cas` int(6) NOT NULL AUTO_INCREMENT,
  `id_tip` int(6) NOT NULL,
  `ci` varchar(10) NOT NULL,
  `descripcion` text,
  `inicio` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `pagado` float DEFAULT '0',
  PRIMARY KEY (`id_cas`,`id_tip`,`ci`),
  UNIQUE KEY `id_cas` (`id_cas`),
  KEY `FK_caso_persona` (`ci`),
  KEY `FK_caso_tipo_Caso` (`id_tip`),
  CONSTRAINT `FK_caso_tipo_Caso` FOREIGN KEY (`id_tip`) REFERENCES `tipo_caso` (`id_tip`),
  CONSTRAINT `FK_caso_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `cita` */

CREATE TABLE `cita` (
  `id_cit` int(11) NOT NULL AUTO_INCREMENT,
  `ci` varchar(10) NOT NULL,
  `id_cas` int(6) DEFAULT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `costo` float NOT NULL DEFAULT '0',
  `pagado` float NOT NULL DEFAULT '0',
  `activa` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_cit`,`ci`),
  UNIQUE KEY `id_cit` (`id_cit`),
  KEY `FK_cita_persona` (`ci`),
  KEY `FK_cita_Caso` (`id_cas`),
  CONSTRAINT `FK_cita_Caso` FOREIGN KEY (`id_cas`) REFERENCES `caso` (`id_cas`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_cita_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `documento` */

CREATE TABLE `documento` (
  `ci` varchar(10) NOT NULL,
  `id_tip` int(6) NOT NULL,
  `copia` int(2) NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(50) NOT NULL,
  `ubicacion_fisica` varchar(50) NOT NULL,
  PRIMARY KEY (`ci`,`id_tip`,`copia`),
  UNIQUE KEY `copia` (`copia`),
  KEY `FK_documento_tipo_documento` (`id_tip`),
  CONSTRAINT `FK_documento_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`),
  CONSTRAINT `FK_documento_tipo_documento` FOREIGN KEY (`id_tip`) REFERENCES `tipo_documento` (`id_tip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `documento_emitido` */

CREATE TABLE `documento_emitido` (
  `ci` varchar(10) NOT NULL,
  `id_pla` int(6) NOT NULL,
  `vez` int(6) NOT NULL,
  `costo` float NOT NULL,
  `pagado` float NOT NULL,
  PRIMARY KEY (`ci`,`id_pla`),
  KEY `FK_documento_emitido_plantilla` (`id_pla`),
  CONSTRAINT `FK_documento_emitido_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`),
  CONSTRAINT `FK_documento_emitido_plantilla` FOREIGN KEY (`id_pla`) REFERENCES `plantilla` (`id_pla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `ocupa` */

CREATE TABLE `ocupa` (
  `id_car` int(6) NOT NULL,
  `ci` varchar(10) NOT NULL,
  `rep` int(3) NOT NULL AUTO_INCREMENT,
  `inic_gest` date NOT NULL,
  `fin_gest` date NOT NULL,
  `observacion` text,
  PRIMARY KEY (`id_car`,`ci`,`rep`),
  UNIQUE KEY `rep` (`rep`),
  KEY `FK_ocupa_persona` (`ci`),
  CONSTRAINT `FK_ocupa_cargo` FOREIGN KEY (`id_car`) REFERENCES `cargo` (`id_car`),
  CONSTRAINT `FK_ocupa_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `persona` */

CREATE TABLE `persona` (
  `ci` varchar(10) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido_paterno` varchar(30) DEFAULT NULL,
  `apellido_materno` varchar(30) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `id_tit` int(6) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ci`),
  KEY `FK_persona_titulo` (`id_tit`),
  CONSTRAINT `FK_persona_titulo` FOREIGN KEY (`id_tit`) REFERENCES `titulo` (`id_tit`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `plantilla` */

CREATE TABLE `plantilla` (
  `id_pla` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `directorio` text NOT NULL,
  PRIMARY KEY (`id_pla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `telefono` */

CREATE TABLE `telefono` (
  `ci` varchar(10) NOT NULL,
  `numero` varchar(20) NOT NULL,
  PRIMARY KEY (`ci`,`numero`),
  CONSTRAINT `FK_telefono_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tipo_caso` */

CREATE TABLE `tipo_caso` (
  `id_tip` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `tipo_documento` */

CREATE TABLE `tipo_documento` (
  `id_tip` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`id_tip`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `titulo` */

CREATE TABLE `titulo` (
  `id_tit` int(6) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `abreviatura` varchar(15) NOT NULL,
  PRIMARY KEY (`id_tit`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Table structure for table `usuario` */

CREATE TABLE `usuario` (
  `id_usu` int(6) NOT NULL AUTO_INCREMENT,
  `user` varchar(10) DEFAULT NULL,
  `pass` varchar(40) DEFAULT NULL,
  `activo` int(1) DEFAULT NULL,
  `ci` varchar(10) NOT NULL,
  `tipo` int(1) DEFAULT NULL,
  PRIMARY KEY (`id_usu`),
  KEY `FK_usuario_persona` (`ci`),
  CONSTRAINT `FK_usuario_persona` FOREIGN KEY (`ci`) REFERENCES `persona` (`ci`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
