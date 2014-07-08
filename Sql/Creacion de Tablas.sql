CREATE DATABASE `Estudio_Juridico`; 
CREATE TABLE `estudio_juridico`.`titulo`( 
	`id_tit` INT(6) NOT NULL , 
	`titulo` VARCHAR(30) NOT NULL , 
	`abreviatura` VARCHAR(15) NOT NULL , 
PRIMARY KEY (`id_tit`) );

CREATE TABLE `estudio_juridico`.`telefono`( 
	`ci` VARCHAR(10) NOT NULL , 
	`numero` VARCHAR(20) NOT NULL , 
PRIMARY KEY (`ci`) ); 

CREATE TABLE `estudio_juridico`.`usuario`( 
	`id_usu` INT(6) NOT NULL , 
	`user` VARCHAR(10) , 
	`pass` VARCHAR(40) , 
	`activo` INT(1) , 
	`ci` VARCHAR(10) NOT NULL ,
PRIMARY KEY (`id_usu`) ); 

CREATE TABLE `estudio_juridico`.`persona`( 
	`ci` VARCHAR(10) NOT NULL , 
	`nombre` VARCHAR(30) , 
	`apellido_parterno` VARCHAR(30) , 
	`apellido_materno` VARCHAR(30) , 
	`direccion` VARCHAR(100) , 
	`id_tit` INT(6) NOT NULL , 
PRIMARY KEY (`ci`) ); 

ALTER TABLE `estudio_juridico`.`usuario` 
ADD CONSTRAINT `FK_usuario_persona` 
FOREIGN KEY (`ci`) 
REFERENCES `persona` (`ci`) 
ON DELETE CASCADE ON UPDATE CASCADE ; 

ALTER TABLE `estudio_juridico`.`telefono` 
ADD CONSTRAINT `FK_telefono_persona` 
FOREIGN KEY (`ci`) 
REFERENCES `persona` (`ci`) 
ON DELETE CASCADE ON UPDATE CASCADE ; 

ALTER TABLE `estudio_juridico`.`persona` 
ADD CONSTRAINT `FK_persona_titulo` 
FOREIGN KEY (`id_tit`) 
REFERENCES `titulo` (`id_tit`)
ON DELETE CASCADE ON UPDATE CASCADE ; 

ALTER TABLE `estudio_juridico`.`titulo` 
CHANGE `id_tit` `id_tit` INT(6) NOT NULL AUTO_INCREMENT; 

ALTER TABLE `estudio_juridico`.`persona` 
CHANGE `id_tit` `id_tit` INT(6) DEFAULT '0' NOT NULL; 

CREATE TABLE `estudio_juridico`.`backup`( 
	`id_back` INT(11) NOT NULL , 
	`fecha_hora` TIMESTAMP , 
	`sql` TEXT , 
PRIMARY KEY (`id_back`) ); 

ALTER TABLE `estudio_juridico`.`backup` 
CHANGE `id_back` `id_back` INT(11) NOT NULL AUTO_INCREMENT; 

ALTER TABLE `estudio_juridico`.`usuario` 
CHANGE `id_usu` `id_usu` INT(6) NOT NULL AUTO_INCREMENT; 

CREATE TABLE `estudio_juridico`.`cargo`( 
	`id_car` INT(6) NOT NULL AUTO_INCREMENT , 
	`nombre` VARCHAR(20) NOT NULL , 
PRIMARY KEY (`id_car`) ); 

CREATE TABLE `estudio_juridico`.`ocupa`( 
	`id_car` INT(6) NOT NULL , 
	`ci` VARCHAR(10) NOT NULL , 
	`rep` INT(3) NOT NULL AUTO_INCREMENT UNIQUE , 
	`inic_gest` DATE , 
	`fin_gest` DATE ,
	`observacion` TEXT , 
PRIMARY KEY (`id_car`, `ci`, `rep`) ); 

ALTER TABLE `estudio_juridico`.`ocupa` 
ADD CONSTRAINT `FK_ocupa_persona` 
FOREIGN KEY (`ci`) 
REFERENCES `persona` (`ci`); 

ALTER TABLE `estudio_juridico`.`ocupa` 
ADD CONSTRAINT `FK_ocupa_cargo` 
FOREIGN KEY (`id_car`) 
REFERENCES `cargo` (`id_car`); 

ALTER TABLE `estudio_juridico`.`usuario` 
ADD COLUMN `tipo` INT(1) NULL AFTER `ci`; 

ALTER TABLE `estudio_juridico`.`telefono` CHANGE `numero` `numero` VARCHAR(20) 
CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL, 
DROP PRIMARY KEY, ADD PRIMARY KEY(`ci`, `numero`); 
