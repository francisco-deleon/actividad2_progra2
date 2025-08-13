/*
  Script SQL de la Actividad 2
  Programación II

  Universidad Mariano Gálvez de Guatemala
  Facultad de Ingeniería en Sistemas

  Autor:
  Francisco Antonio De León Natareno
*/

-- Crear base de datos 'db_empresa'
CREATE DATABASE db_empresa;

-- Seleccionar la BD 'db_empresa'
USE db_empresa;

-- Crear tabla 'clientes'
CREATE TABLE clientes(
 id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 nit VARCHAR(10) NOT NULL,
 nombres VARCHAR(60) NOT NULL,
 apellidos VARCHAR(60) NOT NULL,
 direccion VARCHAR(100) DEFAULT NULL,
 telefono VARCHAR(12) DEFAULT NULL
);

-- Crear tabla 'puestos'
CREATE TABLE puestos(
 id_puesto SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 puesto VARCHAR(45) NOT NULL
);

-- Crear tabla 'empleados'
CREATE TABLE empleados(
 id_empleado INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 codigo VARCHAR(20) NOT NULL,
 nombres VARCHAR(60) NOT NULL,
 apellidos VARCHAR(60) NOT NULL,
 direccion VARCHAR(100) DEFAULT NULL,
 telefono VARCHAR(10) DEFAULT NULL,
 fecha_nacimiento DATE DEFAULT NULL,
 id_puesto SMALLINT DEFAULT NULL,
 CONSTRAINT id_puesto_empleados_puestos FOREIGN KEY (id_puesto) REFERENCES puestos(id_puesto) ON UPDATE CASCADE
);

-- Crear nuevo usuario 'usr_empresa' contraseña 'Empres@123'
CREATE USER 'usr_empresa'@'localhost' IDENTIFIED BY 'Empres@123';

-- Asignar los permisos necesarios al nuevo usuario 'usr_empresa' en la base de datos 'db_empresa'
GRANT SELECT, INSERT, UPDATE, DELETE, EXECUTE, SHOW VIEW ON db_empresa.* TO 'usr_empresa'@'localhost';

-- Recargar la tabla de permisos
FLUSH PRIVILEGES;

-- Insertar registro de prueba en la tabla 'clientes'
INSERT INTO clientes(nit, nombres, apellidos, direccion, telefono) VALUES
  ('111329051', 'Jose Luis', 'Perez Lopez', 'Guatemala', '58577092');
  
-- Insertar registro de prueba en la tabla 'puestos'
INSERT INTO puestos(puesto) VALUES
  ('Programador');

-- Insertar registro de prueba en la tabla 'empleados'
INSERT INTO empleados(codigo, nombres, apellidos, direccion, telefono, fecha_nacimiento, id_puesto) VALUES
  ('E001', 'Francisco', 'De Leon', 'Guatemala', '46553526', '1990-05-22', 1);