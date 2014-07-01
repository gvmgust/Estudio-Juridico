CREATE DATABASE `db_estudio_juridico`; 

CREATE TABLE `usuario`( 
	`id_user` INT(2) NOT NULL AUTO_INCREMENT , 
	`user` VARCHAR(16) , 
	`pass` VARCHAR(40) , 
PRIMARY KEY (`id_user`)); 
