CREATE DATABASE `db_estudio_juridico`; 

CREATE TABLE `usuario`( 
	`id_user` INT(2) NOT NULL AUTO_INCREMENT , 
	`user` VARCHAR(16) , 
	`pass` VARCHAR(40) , 
PRIMARY KEY (`id_user`)); 

-- creacion del usuario admin con password cifrada en sha1 password
INSERT INTO `db_estudio_juridico`.`usuario`(`id_user`,`user`,`pass`) VALUES ( '1','admin','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8'); 