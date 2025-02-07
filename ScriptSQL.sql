-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: elorbase
-- ------------------------------------------------------
-- Server version	8.0.40ciclosciclosusers
drop database if exists calendar;
create database calendar;

use calendar;

GRANT ALL PRIVILEGES ON *.* TO 'iker'@'%';

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ciclos`
--

DROP TABLE IF EXISTS `ciclos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclos` (
  `id` int NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclos`
--

LOCK TABLES `ciclos` WRITE;
/*!40000 ALTER TABLE `ciclos` DISABLE KEYS */;
INSERT INTO `ciclos` VALUES (1,'DAM'),(2,'DAW'),(3,'OTROS'),(4,'ASIR'),(5,'SMR') ;
/*!40000 ALTER TABLE `ciclos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `dia` enum('L/A','M/A','X','J/O','V/O') COLLATE utf8mb4_general_ci NOT NULL,
  `hora` enum('1','2','3','4','5','6') COLLATE utf8mb4_general_ci NOT NULL,
  `profe_id` int NOT NULL,
  `modulo_id` int NOT NULL,
  PRIMARY KEY (`dia`,`hora`,`profe_id`,`modulo_id`),
  KEY `profe_id` (`profe_id`),
  KEY `modulo_id` (`modulo_id`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`profe_id`) REFERENCES `users` (`id`),
  CONSTRAINT `horarios_ibfk_2` FOREIGN KEY (`modulo_id`) REFERENCES `modulos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES 
('L/A','1',4,5),
('L/A','2',4,5),
('L/A','3',4,5),
('L/A','4',4,4),
('L/A','5',4,4),
('M/A','1',4,10),
('M/A','2',4,10),
('M/A','3',4,4),
('M/A','4',4,4),
('M/A','5',4,2),
('X','1',4,4),
('X','2',4,4),
('X','3',4,5),
('X','4',4,5),
('X','5',4,5),
('J/O','2',4,1),
('J/O','3',4,2),
('J/O','4',4,10),
('J/O','5',4,10),
('V/O','3',4,2),
('V/O','4',4,5),
('V/O','5',4,5),

('L/A','1',2,9),
('L/A','2',2,9),
('L/A','3',2,9),
('M/A','1',2,3),
('M/A','2',2,3),
('M/A','3',2,3),
('M/A','4',2,12),
('M/A','5',2,12),
('X','2',2,1),
('X','3',2,9),
('X','4',2,9),
('X','5',2,9),
('J/O','2',2,2),
('J/O','3',2,3),
('J/O','4',2,3),
('J/O','5',2,3),
('V/O','3',2,2),
('V/O','4',2,12),
('V/O','5',2,12),

('L/A','1',8,6),
('L/A','2',8,6),
('L/A','3',8,2),
('M/A','2',8,1),
('M/A','3',8,2),
('X','1',8,8),
('X','2',8,8),
('J/O','1',8,8),
('J/O','2',8,8),
('J/O','3',8,8),
('V/O','1',8,6),
('V/O','2',8,6),

('L/A','4',7,13),
('L/A','5',7,13),
('M/A','2',7,1),
('M/A','3',7,13),
('X','2',7,2),
('J/O','2',7,2),
('V/O','1',7,11),
('V/O','2',7,11),
('V/O','3',7,11),

('L/A','1',6,5),
('L/A','2',6,5),
('L/A','3',6,5),
('L/A','4',6,4),
('L/A','5',6,4),
('M/A','1',6,10),
('M/A','2',6,10),
('M/A','3',6,4),
('M/A','4',6,4),
('M/A','5',6,2),
('X','1',6,4),
('X','2',6,4),
('X','3',6,5),
('X','4',6,5),
('X','5',6,5),
('J/O','2',6,1),
('J/O','3',6,2),
('J/O','4',6,10),
('J/O','5',6,10),
('V/O','3',6,2),
('V/O','4',6,5),
('V/O','5',6,5),

('L/A','1',1,9),
('L/A','2',1,9),
('L/A','3',1,9),
('M/A','1',1,3),
('M/A','2',1,3),
('M/A','3',1,3),
('M/A','4',1,12),
('M/A','5',1,12),
('X','2',1,1),
('X','3',1,9),
('X','4',1,9),
('X','5',1,9),
('J/O','2',1,2),
('J/O','3',1,3),
('J/O','4',1,3),
('J/O','5',1,3),
('V/O','3',1,2),
('V/O','4',1,12),
('V/O','5',1,12),

('L/A','1',5,6),
('L/A','2',5,6),
('L/A','3',5,2),
('M/A','2',5,1),
('M/A','3',5,2),
('X','1',5,8),
('X','2',5,8),
('J/O','1',5,8),
('J/O','2',5,8),
('J/O','3',5,8),
('V/O','1',5,6),
('V/O','2',5,6),

('L/A','4',9,13),
('L/A','5',9,13),
('M/A','2',9,1),
('M/A','3',9,13),
('X','2',9,2),
('J/O','2',9,2),
('V/O','1',9,11),
('V/O','2',9,11),
('V/O','3',9,11)

;
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matriculaciones`
--

DROP TABLE IF EXISTS `matriculaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matriculaciones` (
  `alum_id` int NOT NULL,
  `ciclo_id` int NOT NULL,
  `curso` int NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`alum_id`,`ciclo_id`,`curso`,`fecha`),
  KEY `ciclo_id` (`ciclo_id`),
  CONSTRAINT `matriculaciones_ibfk_1` FOREIGN KEY (`alum_id`) REFERENCES `users` (`id`),
  CONSTRAINT `matriculaciones_ibfk_2` FOREIGN KEY (`ciclo_id`) REFERENCES `ciclos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matriculaciones`
--

LOCK TABLES `matriculaciones` WRITE;
/*!40000 ALTER TABLE `matriculaciones` DISABLE KEYS */;
INSERT INTO `matriculaciones` VALUES (3,1,1,'2024-09-01');
/*!40000 ALTER TABLE `matriculaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulos` (
  `id` int NOT NULL,
  `nombre` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre_eus` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `horas` int NOT NULL,
  `ciclo_id` int DEFAULT NULL,
  `curso` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ciclo_id` (`ciclo_id`),
  CONSTRAINT `modulos_ibfk_1` FOREIGN KEY (`ciclo_id`) REFERENCES `ciclos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES 
(1,'Tutoria','Tutoretza',1,0,0),
(2,'Guardia','Zaintza',1,0,0),
(3,'Sistemas Informaticos','Informatika-sistemak',165,1,1),
(4,'Bases de datos','Datu-baseak',198,1,1),
(5,'Programación','Programazioa ',264,1,1),
(6,'Lenguajes de marcas','Markatzeko lengoaiak',132,1,1),
(7,'Entornos de desarrollo','Garapen-inguruneak',99,1,1),
(8,'Acceso a datos','Datu-atzipena',120,1,2),
(9,'Desarrollo de interfaces','Interfazeen garapena',140,1,2),
(10,'Programación multimedia y dispositivos móviles','Multimedia-programazioa eta gailu mugikorrak',100,1,2),
(11,'Programación de servicios y procesos','Zerbitzu eta prozesuen programazioa',80,1,2),
(12,'Sistemas de gestión empresarial','Enpresa-kudeaketako sistemak',100,1,2),
(13,'Empresa e Iniciativa Emprendedora','Enpresa eta ekimen sortzailea ',60,1,2);
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reuniones`
--

DROP TABLE IF EXISTS `reuniones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reuniones` (
  `id_reunion` INT AUTO_INCREMENT PRIMARY KEY,
  `estado` enum('pendiente','aceptada','denegada','conflicto') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `estado_eus` enum('onartzeke','onartuta','ezeztatuta','gatazka') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `profesor_id` int NOT NULL,
  `alumno_id` int NOT NULL,
  `id_centro` VARCHAR(6) DEFAULT '15112',
  `titulo` VARCHAR(150),
  `asunto` VARCHAR(200),
  `aula` VARCHAR(10),
  `fecha` datetime DEFAULT NULL,
  `dia` enum('L/A','M/A','X','J/O','V/O') COLLATE utf8mb4_general_ci NOT NULL,
  `hora` enum('1','2','3','4','5','6') COLLATE utf8mb4_general_ci NOT NULL,
  KEY `profesor_id` (`profesor_id`),
  KEY `alumno_id` (`alumno_id`),
  CONSTRAINT `reuniones_ibfk_1` FOREIGN KEY (`profesor_id`) REFERENCES `users` (`id`),
  CONSTRAINT `reuniones_ibfk_2` FOREIGN KEY (`alumno_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reuniones`
--

LOCK TABLES `reuniones` WRITE;
/*!40000 ALTER TABLE `reuniones` DISABLE KEYS */;
INSERT INTO `reuniones` (`id_reunion`, `estado`, `estado_eus`, `profesor_id`, `alumno_id`, `id_centro`, `titulo`, `asunto`, `aula`, `fecha`,`dia`,`hora`) VALUES
(1, 'pendiente', NULL, 1, 3, '15112', 'Seguimiento reto', 'Sprint 3', '5.105', '2025-01-13 11:30:00','L/A','4');
/*!40000 ALTER TABLE `reuniones` ENABLE KEYS */;
UNLOCK TABLES;
LOCK TABLES `reuniones` WRITE;
/*!40000 ALTER TABLE `reuniones` DISABLE KEYS */;
INSERT INTO `reuniones` (`id_reunion`, `estado`, `estado_eus`, `profesor_id`, `alumno_id`, `id_centro`, `titulo`, `asunto`, `aula`, `fecha`,`dia`,`hora`) VALUES
(2, 'pendiente', NULL, 2, 3, '15112', 'Seguimiento reto', 'Sprint 3', '5.105', '2025-01-13 11:30:00','L/A','4');
/*!40000 ALTER TABLE `reuniones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos`
--

DROP TABLE IF EXISTS `tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos` (
  `id` int NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name_eus` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos`
--

LOCK TABLES `tipos` WRITE;
/*!40000 ALTER TABLE `tipos` DISABLE KEYS */;
INSERT INTO `tipos` VALUES (1,'god','jainkoa'),(2,'administrador','administratzailea'),(3,'profesor','irakaslea'),(4,'alumno','ikaslea');
/*!40000 ALTER TABLE `tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apellidos` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `dni` varchar(9) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono1` int DEFAULT NULL,
  `telefono2` int DEFAULT NULL,
  `tipo_id` int NOT NULL,
  `argazkia` LONGBLOB DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_id` (`tipo_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`tipo_id`) REFERENCES `tipos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES 
(1,'jorge@elorrieta-errekamari.com','jorge','123456','jorge','gonzalez','123456789','example 10',666,NULL,1,NULL),
(2,'itziar@elorrieta-errekamari.com','itziar','123456','itziar','regidor','123456','example 10',666,NULL,2,NULL),
(3,'alumno@elorrieta-errekamari.com','alumno1','123','alumno','ejemplo','as','as',666,NULL,4,NULL),
(4,'maitane@elorrieta-errekamari.com','maitane','1234','maitane','ejemplo','1234','as',NULL,NULL,3,NULL),
(5,'iker@elorrieta-errekamari.com','iker','1234','iker','ejemplo','1234','as',NULL,NULL,3,NULL),
(6,'asier@elorrieta-errekamari.com','asier','1234','asier','ejemplo','1234','as',NULL,NULL,3,NULL),
(7,'unai@elorrieta-errekamari.com','unai','1234','unai','ejemplo','1234','as',NULL,NULL,3,NULL),
(8,'roman@elorrieta-errekamari.com','roman','1234','roman','ejemplo','1234','as',NULL,NULL,3,NULL),
(9,'oscar@elorrieta-errekamari.com','oscar','1234','oscar','ejemplo','1234','as',NULL,NULL,3,NULL);

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-09 16:40:46

INSERT INTO `reuniones` (`id_reunion`, `estado`, `estado_eus`, `profesor_id`, `alumno_id`, `id_centro`, `titulo`, `asunto`, `aula`, `fecha`) VALUES
-- 19 de enero
(3, 'pendiente', NULL, 4, 3, '15112', 'Tutoría General', 'Consulta dudas', 'Aula 4.204', '2025-01-19 11:00:00'),
-- 20 de enero
(4, 'pendiente', NULL, 1, 5, '15112', 'Evaluación', 'Primera revisión', 'Aula 2.102', '2025-01-20 10:00:00'),
(5, 'pendiente', NULL, 2, 3, '15112', 'Reunión Seguimiento', 'Organización Tareas', 'Aula 3.105', '2025-01-20 13:00:00'),
-- 21 de enero
(6, 'pendiente', NULL, 1, 3, '15112', 'Planificación Reto', 'Preparación Entregables', 'Aula 5.201', '2025-01-21 09:30:00'),
(7, 'pendiente', NULL, 4, 5, '15112', 'Consulta Académica', 'Ayuda en proyecto', 'Aula 4.303', '2025-01-21 14:00:00'),
-- 22 de enero
(8, 'pendiente', NULL, 2, 3, '15112', 'Análisis Progreso', 'Tareas completadas', 'Aula 3.104', '2025-01-22 08:00:00'),
(9, 'pendiente', NULL, 4, 3, '15112', 'Seguimiento', 'Consulta avances', 'Aula 1.101', '2025-01-22 12:30:00'),
-- 23 de enero
(10, 'pendiente', NULL, 1, 5, '15112', 'Revisión Código', 'Feedback y mejoras', 'Aula 2.203', '2025-01-23 10:00:00'),
(11, 'pendiente', NULL, 3, 4, '15112', 'Sesión Mentoría', 'Pruebas y errores', 'Aula 4.105', '2025-01-23 16:00:00'),
-- 24 de enero
(12, 'pendiente', NULL, 2, 3, '15112', 'Progreso Reto', 'Feedback global', 'Aula 3.101', '2025-01-24 11:00:00'),
(13, 'pendiente', NULL, 1, 5, '15112', 'Avances Proyecto', 'Consultas técnicas', 'Aula 2.205', '2025-01-24 14:30:00'),
-- 25 de enero
(14, 'pendiente', NULL, 4, 3, '15112', 'Revisión Documentos', 'Correcciones', 'Aula 5.201', '2025-01-25 09:00:00'),
(15, 'pendiente', NULL, 1, 3, '15112', 'Sesión Tutoría', 'Solución conflictos', 'Aula 4.103', '2025-01-25 12:00:00'),
-- 26 de enero
(16, 'pendiente', NULL, 3, 4, '15112', 'Revisión Código', 'Evaluación general', 'Aula 1.102', '2025-01-26 08:30:00'),
(17, 'pendiente', NULL, 2, 5, '15112', 'Seguimiento Proyecto', 'Consultas pendientes', 'Aula 3.202', '2025-01-26 14:00:00'),
-- 27 de enero
(18, 'pendiente', NULL, 1, 3, '15112', 'Análisis Avances', 'Planificación Sprint', 'Aula 5.101', '2025-01-27 10:00:00'),
(19, 'pendiente', NULL, 4, 5, '15112', 'Revisión Progreso', 'Resolución dudas', 'Aula 4.304', '2025-01-27 13:30:00'),
-- 28 de enero
(20, 'pendiente', NULL, 2, 3, '15112', 'Evaluación Proyecto', 'Feedback detallado', 'Aula 3.105', '2025-01-28 09:00:00'),
(21, 'pendiente', NULL, 4, 3, '15112', 'Consulta Académica', 'Dudas sobre teoría', 'Aula 1.202', '2025-01-28 15:00:00'),
-- 29 de enero
(22, 'pendiente', NULL, 1, 5, '15112', 'Tutoría Proyecto', 'Problemas detectados', 'Aula 2.201', '2025-01-29 10:30:00'),
(23, 'pendiente', NULL, 2, 4, '15112', 'Revisión Sprint', 'Planificación entregas', 'Aula 3.202', '2025-01-29 12:30:00'),
-- 30 de enero
(24, 'pendiente', NULL, 4, 3, '15112', 'Consulta General', 'Resolución problemas', 'Aula 5.301', '2025-01-30 08:00:00'),
(25, 'pendiente', NULL, 1, 5, '15112', 'Revisión Final', 'Últimos detalles', 'Aula 4.101', '2025-01-30 14:00:00'),
-- 31 de enero
(26, 'pendiente', NULL, 2, 3, '15112', 'Seguimiento', 'Preparación Examen', 'Aula 3.103', '2025-01-31 10:00:00'),
(27, 'pendiente', NULL, 1, 3, '15112', 'Planificación Final', 'Organización tareas', 'Aula 2.104', '2025-01-31 15:00:00'),
-- 1 de febrero
(28, 'pendiente', NULL, 3, 4, '15112', 'Consulta Académica', 'Tareas avanzadas', 'Aula 4.205', '2025-02-01 09:00:00'),
(29, 'pendiente', NULL, 1, 5, '15112', 'Revisión Objetivos', 'Metas del proyecto', 'Aula 2.301', '2025-02-01 14:00:00'),
-- 2 de febrero
(30, 'pendiente', NULL, 2, 3, '15112', 'Progreso Actual', 'Planificación futura', 'Aula 3.102', '2025-02-02 08:30:00'),
(31, 'pendiente', NULL, 4, 3, '15112', 'Consulta Detallada', 'Estrategias de mejora', 'Aula 5.104', '2025-02-02 13:00:00'),
-- 3 de febrero
(32, 'pendiente', NULL, 1, 5, '15112', 'Planificación Reto', 'Planificación entregas', 'Aula 2.102', '2025-02-03 10:00:00'),
(33, 'pendiente', NULL, 2, 4, '15112', 'Evaluación Examen', 'Consulta sobre teoría', 'Aula 3.105', '2025-02-03 15:30:00'),
-- 4 de febrero
(34, 'pendiente', NULL, 4, 3, '15112', 'Revisión Semanal', 'Avances generales', 'Aula 1.105', '2025-02-04 08:00:00'),
(35, 'pendiente', NULL, 1, 5, '15112', 'Consulta General', 'Dudas técnicas', 'Aula 5.202', '2025-02-04 11:00:00'),
-- 5 de febrero
(36, 'pendiente', NULL, 2, 3, '15112', 'Revisión Sprint', 'Preparación final', 'Aula 3.203', '2025-02-05 09:30:00'),
(37, 'pendiente', NULL, 4, 5, '15112', 'Consulta Personal', 'Resolución pendiente', 'Aula 4.301', '2025-02-05 13:00:00'),
-- 6 de febrero
(38, 'pendiente', NULL, 1, 3, '15112', 'Progreso Proyecto', 'Evaluación global', 'Aula 2.201', '2025-02-06 10:00:00'),
(39, 'pendiente', NULL, 2, 4, '15112', 'Evaluación Sprint', 'Planificación entregas', 'Aula 3.202', '2025-02-06 15:00:00'),
-- 7 de febrero
(40, 'pendiente', NULL, 4, 3, '15112', 'Seguimiento Final', 'Avance entregables', 'Aula 5.103', '2025-02-07 09:00:00'),
(41, 'pendiente', NULL, 1, 5, '15112', 'Consulta Técnica', 'Análisis objetivos', 'Aula 4.205', '2025-02-07 12:30:00'),
-- 8 de febrero
(42, 'pendiente', NULL, 2, 3, '15112', 'Revisión Semanal', 'Resolución dudas', 'Aula 3.201', '2025-02-08 08:30:00'),
(43, 'pendiente', NULL, 1, 4, '15112', 'Consulta Personal', 'Preparación examen', 'Aula 2.101', '2025-02-08 14:00:00'),
-- 9 de febrero
(44, 'pendiente', NULL, 3, 4, '15112', 'Planificación Final', 'Planificación global', 'Aula 4.102', '2025-02-09 10:00:00'),
(45, 'pendiente', NULL, 1, 5, '15112', 'Consulta Detallada', 'Detalles finales', 'Aula 5.304', '2025-02-09 15:30:00'),
-- 10 de febrero
(46, 'pendiente', NULL, 2, 3, '15112', 'Evaluación General', 'Revisión general', 'Aula 3.103', '2025-02-10 09:00:00'),
(47, 'pendiente', NULL, 4, 5, '15112', 'Consulta Final', 'Últimos pasos', 'Aula 4.205', '2025-02-10 13:00:00');

SET SQL_SAFE_UPDATES = 0;

update reuniones
set estado_eus = "onartzeke" where estado="pendiente";

update modulos
set ciclo_id = 1 where id = 1 or 2;
update modulos
set curso = 1 where id = 1 or 2;