-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_cap
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `codigo_area` varchar(255) DEFAULT NULL,
  `estado_area_activo` tinyint(1) DEFAULT NULL,
  `nombre_area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'A',1,'ADMINISTRACIÓN Y LEGISLACIÓN'),(2,'B',1,'AGRONOMÍA'),(3,'C',1,'ZOOTECNIA'),(4,'D',1,'ALIMENTACIÓN, GASTRONOMÍA Y TURISMO'),(5,'E',1,'TECNOLOGÍAS DE LA INFORMACIÓN Y COMUNICACIÓN'),(6,'F',1,'FINANZAS, COMERCIO Y VENTAS'),(7,'H',1,'CONSTRUCCIÓN E INFRAESTRUCTURA'),(8,'I',1,'FORESTAL, ECOLOGÍA Y AMBIENTE'),(9,'J',1,'EDUCACIÓN Y CAPACITACIÓN'),(10,'K',1,'ELECTRICIDAD Y ELECTRÓNICA'),(11,'L',1,'ESPECIES ACUÁTICAS Y PESCA'),(12,'M',1,'COMUNICACIÓN Y ARTES GRÁFICAS'),(13,'N',1,'MECÁNICA AUTOMOTRIZ'),(14,'O',1,'MECÁNICA INDUSTRIAL Y MINERÍA'),(15,'P',1,'PROCESOS INDUSTRIALES'),(16,'Q',1,'TRANSPORTE Y LOGÍSTICA'),(17,'R',1,'ARTES Y ARTESANÍA'),(18,'S',1,'SERVICIOS SOCIOCULTURALES Y A LA COMUNIDAD'),(19,'T',1,'INDUSTRIA AGROPECUARIA'),(20,'U',1,'TEMAS LEGALES'),(21,'V',1,'OTROS');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencias` (
  `id_asistencia` int NOT NULL AUTO_INCREMENT,
  `estado_asistencia` tinyint(1) DEFAULT NULL,
  `fecha_asistencia` date DEFAULT NULL,
  `observacion_asistencia` varchar(1000) DEFAULT NULL,
  `id_participante_matriculado` int DEFAULT NULL,
  PRIMARY KEY (`id_asistencia`),
  KEY `FKsh5e3nq02f7qfrruk3iaob7pr` (`id_participante_matriculado`),
  CONSTRAINT `FKsh5e3nq02f7qfrruk3iaob7pr` FOREIGN KEY (`id_participante_matriculado`) REFERENCES `partipantesmatriculados` (`id_participante_matriculado`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
INSERT INTO `asistencias` VALUES (9,1,'2023-10-08','',1),(10,0,'2023-10-08','',2),(11,0,'2023-10-09','',1),(12,0,'2023-10-09','',2),(13,0,'2023-10-10','',1),(14,0,'2023-10-10','',2),(15,0,'2023-10-11','',1),(16,0,'2023-10-11','',2);
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cantones`
--

DROP TABLE IF EXISTS `cantones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cantones` (
  `id_canton` int NOT NULL AUTO_INCREMENT,
  `canton` varchar(255) DEFAULT NULL,
  `id_provincia` int DEFAULT NULL,
  PRIMARY KEY (`id_canton`),
  KEY `FKi574rckkflvfjjex5q0xehpjw` (`id_provincia`),
  CONSTRAINT `FKi574rckkflvfjjex5q0xehpjw` FOREIGN KEY (`id_provincia`) REFERENCES `provincias` (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cantones`
--

LOCK TABLES `cantones` WRITE;
/*!40000 ALTER TABLE `cantones` DISABLE KEYS */;
INSERT INTO `cantones` VALUES (1,'Cuenca',1),(2,'Girón',1),(3,'Gualaceo',1),(4,'Nabón',1),(5,'Paute',1),(6,'Pucará',1),(7,'San Fernando',1),(8,'Santa Isabel',1),(9,'Sigsig',1),(10,'Oña',1),(11,'Chordeleg',1),(12,'El Pan',1),(13,'Sevilla de Oro',1),(14,'Guachapala',1),(15,'Camilo Ponce Enríquez',1),(16,'Guaranda',2),(17,'Chillanes',2),(18,'Chimbo',2),(19,'Echeandía',2),(20,'San Miguel',2),(21,'Caluma',2),(22,'Las Naves',2),(23,'Azogues',3),(24,'Biblián',3),(25,'Cañar',3),(26,'La Troncal',3),(27,'El Tambo',3),(28,'Déleg',3),(29,'Suscal',3),(30,'Tulcán',4),(31,'Bolívar',4),(32,'Espejo',4),(33,'Mira',4),(34,'Montúfar',4),(35,'San Pedro de Huaca',4),(36,'Latacunga',5),(37,'La Maná',5),(38,'Pangua',5),(39,'Pujilí',5),(40,'Salcedo',5),(41,'Saquisilí',5),(42,'Sigchos',5),(43,'Riobamba',6),(44,'Alausí',6),(45,'Colta',6),(46,'Chambo',6),(47,'Chunchi',6),(48,'Guamote',6),(49,'Guano',6),(50,'Pallatanga',6),(51,'Penipe',6),(52,'Cumandá',6),(53,'Machala',7),(54,'Arenillas',7),(55,'Atahualpa',7),(56,'Balsas',7),(57,'Chilla',7),(58,'El Guabo',7),(59,'Huaquillas',7),(60,'Marcabelí',7),(61,'Pasaje',7),(62,'Piñas',7),(63,'Portovelo',7),(64,'Santa Rosa',7),(65,'Zaruma',7),(66,'Las Lajas',7),(67,'Esmeraldas',8),(68,'Eloy Alfaro',8),(69,'Muisne',8),(70,'Quinindé',8),(71,'San Lorenzo',8),(72,'Atacames',8),(73,'Rioverde',8),(74,'La Concordia',8),(75,'Guayaquil',9),(76,'Alfredo Baquerizo Moreno (Juján)',9),(77,'Balao',9),(78,'Balzar',9),(79,'Colimes',9),(80,'Daule',9),(81,'Durán',9),(82,'El Empalme',9),(83,'El Triunfo',9),(84,'Milagro',9),(85,'Naranjal',9),(86,'Naranjito',9),(87,'Palestina',9),(88,'Pedro Carbo',9),(89,'Samborondón',9),(90,'Santa Lucía',9),(91,'Salitre (Urbina Jado)',9),(92,'San Jacinto de Yaguachi',9),(93,'Playas',9),(94,'Simón Bolívar',9),(95,'Coronel Marcelino Maridueña',9),(96,'Lomas de Sargentillo',9),(97,'Nobol',9),(98,'General Antonio Elizalde',9),(99,'Isidro Ayora',9),(100,'Ibarra',10),(101,'Antonio Ante',10),(102,'Cotacachi',10),(103,'Otavalo',10),(104,'Pimampiro',10),(105,'San Miguel de Urcuquí',10),(106,'Loja',11),(107,'Calvas',11),(108,'Catamayo',11),(109,'Celica',11),(110,'Chaguarpamba',11),(111,'Espíndola',11),(112,'Gonzanamá',11),(113,'Macará',11),(114,'Paltas',11),(115,'Puyango',11),(116,'Saraguro',11),(117,'Sozoranga',11),(118,'Zapotillo',11),(119,'Pindal',11),(120,'Quilanga',11),(121,'Olmedo',11),(122,'Babahoyo',12),(123,'Baba',12),(124,'Montalvo',12),(125,'Puebloviejo',12),(126,'Quevedo',12),(127,'Urdaneta',12),(128,'Ventanas',12),(129,'Vinces',12),(130,'Palenque',12),(131,'Buena Fe',12),(132,'Valencia',12),(133,'Mocache',12),(134,'Quinsaloma',12),(135,'Portoviejo',13),(136,'Bolívar',13),(137,'Chone',13),(138,'El Carmen',13),(139,'Flavio Alfaro',13),(140,'Jipijapa',13),(141,'Junín',13),(142,'Manta',13),(143,'Montecristi',13),(144,'Paján',13),(145,'Pichincha',13),(146,'Rocafuerte',13),(147,'Santa Ana',13),(148,'Sucre',13),(149,'Tosagua',13),(150,'24 de Mayo',13),(151,'Pedernales',13),(152,'Olmedo',13),(153,'Puerto López',13),(154,'Jama',13),(155,'Jaramijó',13),(156,'San Vicente',13),(157,'Morona',14),(158,'Gualaquiza',14),(159,'Limón Indanza',14),(160,'Palora',14),(161,'Santiago',14),(162,'Sucúa',14),(163,'Huamboya',14),(164,'San Juan Bosco',14),(165,'Taisha',14),(166,'Logroño',14),(167,'Pablo Sexto',14),(168,'Tiwintza',14),(169,'Tena',15),(170,'Archidona',15),(171,'El Chaco',15),(172,'Quijos',15),(173,'Carlos Julio Arosemena Tola',15),(174,'Pastaza',16),(175,'Mera',16),(176,'Santa Clara',16),(177,'Arajuno',16),(178,'Quito',17),(179,'Cayambe',17),(180,'Mejia',17),(181,'Pedro Moncayo',17),(182,'Rumiñahui',17),(183,'San Miguel de Los Bancos',17),(184,'Pedro Vicente Maldonado',17),(185,'Puerto Quito',17),(186,'Ambato',18),(187,'Baños de Agua Santa',18),(188,'Cevallos',18),(189,'Mocha',18),(190,'Patate',18),(191,'Quero',18),(192,'San Pedro de Pelileo',18),(193,'Santiago de Píllaro',18),(194,'Tisaleo',18),(195,'Zamora',19),(196,'Chinchipe',19),(197,'Nangaritza',19),(198,'Yacuambi',19),(199,'Yantzaza (Yanzatza)',19),(200,'El Pangui',19),(201,'Centinela del Cóndor',19),(202,'Palanda',19),(203,'Paquisha',19),(204,'San Cristóbal',20),(205,'Isabela',20),(206,'Santa Cruz',20),(207,'Lago Agrio',21),(208,'Gonzalo Pizarro',21),(209,'Putumayo',21),(210,'Shushufindi',21),(211,'Sucumbíos',21),(212,'Cascales',21),(213,'Cuyabeno',21),(214,'Orellana',22),(215,'Aguarico',22),(216,'La Joya de Los Sachas',22),(217,'Loreto',22),(218,'Santo Domingo',23),(219,'Santa Elena',24),(220,'La Libertad',24),(221,'Salinas',24),(222,'Las Golondrinas',25),(223,'Manga del Cura',25),(224,'El Piedrero',25);
/*!40000 ALTER TABLE `cantones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capacitadores`
--

DROP TABLE IF EXISTS `capacitadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capacitadores` (
  `id_capacitador` int NOT NULL AUTO_INCREMENT,
  `estado_activo_capacitador` bit(1) DEFAULT NULL,
  `tipo_abreviatura_titulo` varchar(255) DEFAULT NULL,
  `titulo_capacitador` varchar(255) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_capacitador`),
  KEY `FK35k7gd6so5ji76dv2qx5b62s2` (`id_usuario`),
  CONSTRAINT `FK35k7gd6so5ji76dv2qx5b62s2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitadores`
--

LOCK TABLES `capacitadores` WRITE;
/*!40000 ALTER TABLE `capacitadores` DISABLE KEYS */;
INSERT INTO `capacitadores` VALUES (1,_binary '','MSc.','MASTER EN SEGURIDAD INFORMATICA/ INGENIERO EN SISTEMAS',2),(2,_binary '',NULL,NULL,3);
/*!40000 ALTER TABLE `capacitadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidosilabos`
--

DROP TABLE IF EXISTS `contenidosilabos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenidosilabos` (
  `id_contenido_silabo` int NOT NULL AUTO_INCREMENT,
  `actividades_autonomas` varchar(1200) DEFAULT NULL,
  `actividades_docencia` varchar(255) DEFAULT NULL,
  `actividades_practicas` varchar(1200) DEFAULT NULL,
  `dia_contenido` int DEFAULT NULL,
  `estado_contenido` tinyint(1) DEFAULT NULL,
  `horas_autonomas` int DEFAULT NULL,
  `horas_clase_contenido` int DEFAULT NULL,
  `horas_practicas` int DEFAULT NULL,
  `horas_talleres` int DEFAULT NULL,
  `observaciones` varchar(1000) DEFAULT NULL,
  `tema_contenido` varchar(1000) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_contenido_silabo`),
  KEY `FKo5l1h9cxhl885q199bv4gnkx5` (`id_silabo`),
  CONSTRAINT `FKo5l1h9cxhl885q199bv4gnkx5` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidosilabos`
--

LOCK TABLES `contenidosilabos` WRITE;
/*!40000 ALTER TABLE `contenidosilabos` DISABLE KEYS */;
INSERT INTO `contenidosilabos` VALUES (1,'Revisión en casa.','Practica','Desplegar y configurar entorno de google analytics.',1,1,2,2,3,2,'esfasd','Google analytics',1),(2,'2323','docencia','practivc',1,1,3,4,3,6,'213123','n/a',2);
/*!40000 ALTER TABLE `contenidosilabos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `codigo_curso` varchar(100) DEFAULT NULL,
  `curso_occ` varchar(20) DEFAULT NULL,
  `descripcion_curso` varchar(1200) DEFAULT NULL,
  `duracion_curso` int DEFAULT NULL,
  `estado_aprovacion_curso` varchar(255) DEFAULT NULL,
  `estado_curso` tinyint(1) DEFAULT NULL,
  `estado_publicasion_curso` varchar(255) DEFAULT NULL,
  `fecha_finalizacion_curso` date DEFAULT NULL,
  `fecha_inicio_curso` date DEFAULT NULL,
  `foto_curso` varchar(250) DEFAULT NULL,
  `nombre_curso` varchar(255) DEFAULT NULL,
  `numero_cupos_curso` int DEFAULT NULL,
  `objetivo_generales_curso` varchar(1200) DEFAULT NULL,
  `observacion_curso` varchar(1000) DEFAULT NULL,
  `id_capacitador` int DEFAULT NULL,
  `id_especialidad` int DEFAULT NULL,
  `id_horario_curso` int DEFAULT NULL,
  `id_modalidad_curso` int DEFAULT NULL,
  `id_nivel_curso` int DEFAULT NULL,
  `id_parroquia` int DEFAULT NULL,
  `id_programa` int DEFAULT NULL,
  `id_tipo_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_curso`),
  KEY `FKonhabc2vrea8jqm2bvxqve1gf` (`id_capacitador`),
  KEY `FKsgeed7b1oix1w5dcvutl4ph5i` (`id_especialidad`),
  KEY `FKf3t4w22fq0dpmvyv5hbuh3ykm` (`id_horario_curso`),
  KEY `FKdmvytqpsk0j57wlcnkfms962n` (`id_modalidad_curso`),
  KEY `FK2rsbec5nb5wwd6ayjhkvyfu71` (`id_nivel_curso`),
  KEY `FKadpec2tj0kv691rp9i8n8sxnn` (`id_parroquia`),
  KEY `FKird2ase288swkbmsgahw93pox` (`id_programa`),
  KEY `FKiuaiwws7ngl7cdgbpd166do0f` (`id_tipo_curso`),
  CONSTRAINT `FK2rsbec5nb5wwd6ayjhkvyfu71` FOREIGN KEY (`id_nivel_curso`) REFERENCES `niveles_cursos` (`id_nivel_curso`),
  CONSTRAINT `FKadpec2tj0kv691rp9i8n8sxnn` FOREIGN KEY (`id_parroquia`) REFERENCES `parroquias` (`id_parroquia`),
  CONSTRAINT `FKdmvytqpsk0j57wlcnkfms962n` FOREIGN KEY (`id_modalidad_curso`) REFERENCES `modalidades_cursos` (`id_modalidad_curso`),
  CONSTRAINT `FKf3t4w22fq0dpmvyv5hbuh3ykm` FOREIGN KEY (`id_horario_curso`) REFERENCES `horarioscursos` (`id_horario_curso`),
  CONSTRAINT `FKird2ase288swkbmsgahw93pox` FOREIGN KEY (`id_programa`) REFERENCES `programas` (`id_programa`),
  CONSTRAINT `FKiuaiwws7ngl7cdgbpd166do0f` FOREIGN KEY (`id_tipo_curso`) REFERENCES `tipos_cursos` (`id_tipo_curso`),
  CONSTRAINT `FKonhabc2vrea8jqm2bvxqve1gf` FOREIGN KEY (`id_capacitador`) REFERENCES `capacitadores` (`id_capacitador`),
  CONSTRAINT `FKsgeed7b1oix1w5dcvutl4ph5i` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidades` (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'GOGLEANALITYC','Si','Google Analytics es una herramienta de analítica web de la empresa Google lanzada el 14 de noviembre de 2005.',50,'A',1,'I','2023-10-11','2023-10-08','0660d5f5-498f-46aa-a3d3-679a0906ece2_google.jpg','Google Analytics',10,'Ofrece información agrupada del tráfico que llega a los sitios web según la audiencia, la adquisición, el comportamiento y las conversiones que se llevan a cabo en el sitio web.','NA',1,45,1,1,2,3,1,2),(2,'121','No','Las Tecnologías de la Información y las Comunicaciones (TIC), son el conjunto de recursos, herramientas, equipos, programas informáticos, aplicaciones, redes y medios; que permiten la compilación, proces',30,'P',1,'O','2023-10-14','2023-10-11','b1c13069-298e-462b-a628-60cd9805f281_ista-email.png','tics',4,'Son el conjunto de recursos, herramientas, equipos, programas informáticos, aplicaciones, redes y medios; que permiten la compilación, proces','n/a',1,10,2,1,1,1062,1,1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallefichamatriculas`
--

DROP TABLE IF EXISTS `detallefichamatriculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallefichamatriculas` (
  `id_detalle_ficha_matricula` int NOT NULL AUTO_INCREMENT,
  `pregunta1` varchar(1000) DEFAULT NULL,
  `pregunta2` varchar(1000) DEFAULT NULL,
  `pregunta3` varchar(1000) DEFAULT NULL,
  `pregunta4` varchar(1000) DEFAULT NULL,
  `pregunta5` varchar(1000) DEFAULT NULL,
  `pregunta6` varchar(1000) DEFAULT NULL,
  `pregunta7` varchar(1000) DEFAULT NULL,
  `pregunta8` varchar(1000) DEFAULT NULL,
  `pregunta9` varchar(1000) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_detalle_ficha_matricula`),
  KEY `FKgtm1363gagqxlb19utf2t3ik1` (`id_usuario`),
  CONSTRAINT `FKgtm1363gagqxlb19utf2t3ik1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefichamatriculas`
--

LOCK TABLES `detallefichamatriculas` WRITE;
/*!40000 ALTER TABLE `detallefichamatriculas` DISABLE KEYS */;
INSERT INTO `detallefichamatriculas` VALUES (1,'dsfasdfsdfa','asdfasdf','javiergmaq@gmail.com','23123123','wrdtwertwert','No','N/A','N/A','N/A',3),(2,'El la cidada','asdfasdf','asdfasdfa','asdfasd','fasd','No','N/A','N/A','N/A',5);
/*!40000 ALTER TABLE `detallefichamatriculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseniocurriculares`
--

DROP TABLE IF EXISTS `diseniocurriculares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseniocurriculares` (
  `id_disenio_curricular` int NOT NULL AUTO_INCREMENT,
  `estado_disenio_curricular` tinyint(1) DEFAULT NULL,
  `estrategias_aprendizaje` varchar(1500) DEFAULT NULL,
  `temas_transversales` varchar(1500) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_disenio_curricular`),
  KEY `FKdmvq9dn5jg8cx26tf5uqwly8c` (`id_silabo`),
  CONSTRAINT `FKdmvq9dn5jg8cx26tf5uqwly8c` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseniocurriculares`
--

LOCK TABLES `diseniocurriculares` WRITE;
/*!40000 ALTER TABLE `diseniocurriculares` DISABLE KEYS */;
INSERT INTO `diseniocurriculares` VALUES (1,1,'Manejo de google analytics.\nUso de la herramienta.','Google Analytics.',1),(2,1,'caciones (TIC), son el conjunto de recursos, herramientas, equipos, programas informáticos, aplicaciones, redes y medios; que permiten la compilación, ','Las Tecnologías de la Información y las Comunicaciones (TIC), son el conjunto de recursos, herramientas, equipos, programas informáticos, aplicaciones, redes y medios; que permiten la compilación, ',2);
/*!40000 ALTER TABLE `diseniocurriculares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentossenecyt`
--

DROP TABLE IF EXISTS `documentossenecyt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentossenecyt` (
  `id_documento_senecyt` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(1500) DEFAULT NULL,
  `documento_exel` varchar(250) DEFAULT NULL,
  `estado_documento` tinyint(1) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_documento_senecyt`),
  KEY `FKt0xm3gciuoteqvh27ogwsh08e` (`id_usuario`),
  CONSTRAINT `FKt0xm3gciuoteqvh27ogwsh08e` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentossenecyt`
--

LOCK TABLES `documentossenecyt` WRITE;
/*!40000 ALTER TABLE `documentossenecyt` DISABLE KEYS */;
INSERT INTO `documentossenecyt` VALUES (2,'Nuevo documento de senecyt.','fb72705c-73d2-451d-b721-659ad580c9ca_ParticipantesAprovados.xlsx',0,'2023-09-30',1);
/*!40000 ALTER TABLE `documentossenecyt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidades` (
  `id_especialidad` int NOT NULL AUTO_INCREMENT,
  `codigo_especialidad` varchar(255) DEFAULT NULL,
  `estado_especialidad_activo` tinyint(1) DEFAULT NULL,
  `nombre_especialidad` varchar(1000) DEFAULT NULL,
  `id_area` int DEFAULT NULL,
  PRIMARY KEY (`id_especialidad`),
  KEY `FKecvcbcetny0uwtucpmwnpuj1p` (`id_area`),
  CONSTRAINT `FKecvcbcetny0uwtucpmwnpuj1p` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES (1,'A.1',1,'Administración General (Pública, Empresas, Microempresas, Cooperativas, Aduanera, Agrícola, Agropecuaria, Agroindustrial, Bancaria, Financiera, Forestal, Hospitalaria, Hotelera, Inmobiliaria, Pesquera, Minera, Etc.)',1),(2,'A.2',1,'Gestión del Talento Humano (Manejo de Personal, Desempeño, Motivación, Liderazgo, Coaching, Trabajo en Equipo, Selección por Competencias, Plan Interno de Carrera, Comunicación Organizacional, Profesiogramas)',1),(3,'A.3',1,'Administración Contable y de Costos (Matemática Financiera, Estadística, Tributaria, Normas de Contabilidad, Auditorías Financieras, Contables, de Costos y Relacionadas, Normas Internacionales de Información Financiera ...)',1),(4,'A.4',1,'Evaluación de Proyectos (Económica, Financiera)',1),(5,'A.5',1,'Atención y Servicios de Oficina: Secretariado (Operación de Máquinas de Oficina, Taquigrafía, Lectura Rápida, Oratoria, Redacción Y Ortografía), Recepción, Servicio al Cliente, Archivo, Conserjería, Etc.',1),(6,'A.6',1,'Legislación (Aduanera, Negociación, Mediación, Arbitraje, Patentes, Propiedad Intelectual, Tributaria, Laboral, Previsión Social, Agrícola, Financiera, Etc.)',1),(7,'A.7',1,'Gestión de la Calidad (Normas, Auditorías de Sistemas de Calidad y Mejoramiento Continuo)',1),(8,'B.1',1,'Agricultura Orgánica',2),(9,'B.2',1,'Semillas',2),(10,'B.3',1,'Cereales',2),(11,'B.4',1,'Cultivos (Siembra, Cosecha, Postcosecha, Manejo Nutricional de las Plantas)',2),(12,'B.5',1,'Leguminosas',2),(13,'B.7',1,'Floricultura',2),(14,'B.8',1,'Fruticultura',2),(15,'B.9',1,'Jardinería y Poda',2),(16,'B.10',1,'Horticultura',2),(17,'B.11',1,'Sanidad Vegetal (Control Fitosanitario, Control de Plagas y Malezas)',2),(18,'B.12',1,'Suelos y Agua (Manejo de Insumos Agrícolas, Fertilizantes, Riego, Abonos)',2),(19,'B.13',1,'Viticultura y Enología',2),(20,'C.1',1,'Sanidad Pecuaria (Veterinaria)',3),(21,'C.6',1,'Esquila (Ovejas, Conejos, Llamas, Cabras)',3),(22,'C.9',1,'Ganadería Mayor (Bovinos-leche/carne-,Ovino, Caprino, Camélido, Equinos)',3),(23,'C.10',1,'Ganadería Menor (Cuy, Conejo, Aves, Abejas, Anfibios, Moluscos, Porcinos, Anélidos)',3),(24,'C.11',1,'Helicicultura (Caracoles)',3),(25,'C.12',1,'Inseminación Artificial y Técnicas de Manejo Genético',3),(26,'C.15',1,'Producción de Pastos',3),(27,'C.16',1,'Alimentación de Rumiantes',3),(28,'C.17',1,'Alimentación de Monogástricos',3),(29,'D.1',1,'Elaboración, Tecnología y Producción de Alimentos (Higiene, Manipulación, Seguridad Alimentaria, Empaques, Etiquetado y Trazabilidad); y, Hazard.',4),(30,'D.2',1,'Banquetería',4),(31,'D.3',1,'Cocina Nacional e Internacional (Chef, Cocinero)',4),(32,'D.4',1,'Panadería y Pastelería',4),(33,'D.5',1,'Repostería y Confitería',4),(34,'D.6',1,'Catering y Servicio de Bar y Comedores (Barman, Mesero)',4),(35,'D.7',1,'Servicio de Recepción, Limpieza, Pisos y Afines (Recepcionista, Ama de Llaves, Botones, Camarera de Pisos, Encargado de Mantenimiento)',4),(36,'D.8',1,'Turismo (Ecoturismo, Agroturismo, Etnoturismo, Turismo de Aventura, Turismo Comunitario, Guía Nacional, Guía Especializado, Información, Organización y Coordinación de Eventos)',4),(37,'D.9',1,'Servicio de Agencias de Viaje (Operación, Transporte, Seguridad, Ventas, Operadores, Reservas)',4),(38,'D.10',1,'Diversificación de destinos y Desarrollo de Inclusión Comunitaria',4),(39,'E.1',1,'Servicios Telemáticos y Generados de Valor Agregado',5),(40,'E.2',1,'Telecomunicaciones (Comunicación Telefónica, Telegráfica, Satelital)',5),(41,'E.3',1,'Instalación, Mantenimiento y Reparación de Fibra Óptica',5),(42,'E.4',1,'Enlace de datos',5),(43,'E.5',1,'Transmisión, Emisión y Recepción de Información',5),(44,'E.6',1,'Servicios de Comunicación en Voz y Datos',5),(45,'E.7',1,'Base de Datos Relacional (Oracle, Sybase, Sql, Server, Db2, Access, Informix, Datacom, Unicenter Tng)',5),(46,'E.8',1,'Control de Calidad (Auditoría Computacional, Evaluación de Software, Sistemas de Seguridad)',5),(47,'E.9',1,'Hardware y Equipos (Arquitectura de Pc, Mantenimiento, Configuración)',5),(48,'E.10',1,'Internet E Intranet(Administración de Firewall, Correo Electrónico, Navegadores)',5),(49,'E.11',1,'Programas de Escritorio (Office, Hojas Electrónicas, Procesadores de Texto, Power Point), Computación Básica U Operación de Computadoras.',5),(50,'E.12',1,'Software Especializado (Flex, Smartsuit, Autocad, Softland, Arc View, 3d)',5),(51,'E.13',1,'Redes (Comunidades de Redes Tecnológicas, Servicios, Protocolos, Señalización, Armado, Operación, Mantenimiento y Conectividad)',5),(52,'E.14',1,'Sistema Operativo (Ms-Dos, Windows 3xx, 95, 98, 2000, Vms, Computación  Básica u Operación de Comput, Solaris, Novell, Unix)',5),(53,'E.15',1,'Análisis de Sistemas ( Proyectos Informáticos, Problemas, Modelamiento de Información,  Reingeniería)',5),(54,'E.16',1,'Lenguaje de Programación (Pascal, Básic, Cobol, Visual Básic, C+++, Power Builder, Clipper, Java, PHP, Puntonet)',5),(55,'E.17',1,'Codificación y Decodificación de Señales en Medios de Comunicación',5),(56,'F.1',1,'Marketing y Ventas (Negociación, Comercialización, Marketing y Ventas de Productos y Servicios)',6),(57,'F.2',1,'Comercio Exterior y Cambios',6),(58,'F.3',1,'Comercio y Distribución Interna',6),(59,'F.4',1,'Economía Aplicada',6),(60,'F.5',1,'Crédito y Cobranzas',6),(61,'F.6',1,'Detección de Circulante y Documentos Falsos',6),(62,'F.7',1,'Negocios y Comercio Electrónico',6),(63,'F.8',1,'Mercado Financiero (Bolsa de Valores, Capitales, Monetarios, Futuros, etc.)',6),(64,'F.9',1,'Presupuestos y Flujo de Caja',6),(65,'F.10',1,'Riesgo Financiero (Análisis, Solvencia, Liquidez, Endeudamiento, etc.)',6),(66,'F.11',1,'Seguros (Análisis, Costos, etc.)',6),(67,'F.12',1,'Trámites de exportación e Importación',6),(68,'H.1',1,'Albañilería',7),(69,'H.2',1,'Cañería (Conducción de Agua, Gas, Petróleo)',7),(70,'H.3',1,'Carpintería de Obra Gruesa (Paneles, Puertas, Vigas, Ventanas)',7),(71,'H.4',1,'Gasfitería',7),(72,'H.5',1,'Carpintería y Estructura Metálica',7),(73,'H.6',1,'Hojalatería (Bajadas de Agua, Canales)',7),(74,'H.7',1,'Instalaciones Sanitarias (Alcantarillado, Gasfitería)',7),(75,'H.8',1,'Mantenimiento de Edificios y Acabados',7),(76,'H.9',1,'Obras (Caminos, Puentes, Túneles)',7),(77,'H.10',1,'Enfierradura',7),(78,'H.11',1,'Recubrimiento de Interiores y Exteriores (Pintura, Alfombra, Azulejos)',7),(79,'H.13',1,'Tecnología de la Construcción (Planos, Materiales, Estructuras, Equipos, Etc.)',7),(80,'H.14',1,'Arquitectura y Urbanismo (Proyectos, Restauración de Edificios y Vivienda)',7),(81,'H.15',1,'Dibujo Técnico',7),(82,'H.16',1,'Construcciones Rurales',7),(83,'H.17',1,'Plomería',7),(84,'I.1',1,'Contaminación Ambiental',8),(85,'I.2',1,'Gestión e Impacto Ambiental',8),(86,'I.3',1,'Manejo y Conservación de Recursos Naturales',8),(87,'I.4',1,'Producción Limpia',8),(88,'I.5',1,'Tratamiento de Residuos (Líquidos, Sólidos, Gaseosos)',8),(89,'I.6',1,'Remediación Ambiental',8),(90,'I.7',1,'Economía Ambiental',8),(91,'I.8',1,'Combate de Incendios Forestal',8),(92,'I.9',1,'Plantación, Conservación y Explotación de especies forestales (Poda, Raleo Forestación, Reforestación, Agroforestería, Viveros)',8),(93,'I.10',1,'Sanidad  y Manejo Forestal',8),(94,'I.11',1,'Silvicultura',8),(95,'I.12',1,'Geofísica (Sismologí, Meteorología, Climatologí)',8),(96,'I.13',1,'Energías Alternativas',8),(97,'J.1',1,'Capacitación (Identificación de Necesidades, Procesos de Capacitación Continua y por Competencias Laborales, Evaluación y Seguimiento)',9),(98,'J.2',1,'Diseño Educativo y Curricular (Elaboración de Proyectos Educativos, Planes y Programas de Educación, Capacitación y Formación)',9),(99,'J.3',1,'Evaluación del Aprendizaje',9),(100,'J.4',1,'Formación de Instructores, Facilitadores, Monitores, Maestros, Guías, Formadores',9),(101,'J.5',1,'Medios y Materiales Didácticos (Diseño, Elaboración)',9),(102,'J.6',1,'Metodología y Técnica De Aprendizaje (Pre Básica, Básica, Media, Diferencial, Adulto, Superior)',9),(103,'J.7',1,'Orientación Vocacional',9),(104,'K.1',1,'Electricidad Domiciliaria (Reparación, Manejo y Mantenimiento)',10),(105,'K.2',1,'Electricidad Automotriz',10),(106,'K.3',1,'Electrodomésticos (Reparación, Manejo y Mantenimiento)',10),(107,'K.4',1,'Electromecánica (Instalación y Mantenimiento de Motores Eléctricos)',10),(108,'K.5',1,'Electrónica Industrial',10),(109,'K.6',1,'Electrotecnia y Luminotecnia (Uso Industrial y Artístico del Sistema de Alumbrado, Voltaje, Resistencia)',10),(110,'K.7',1,'Instalación Telefónica (Reparación, Manejo y mantenimiento)',10),(111,'K.8',1,'Redes Eléctricas (Baja, Media y Alta Tensión, Instalaciones)',10),(112,'K.9',1,'Electricidad Industrial (Reparación, Manejo y Mantenimiento)',10),(113,'K.10',1,'Electrónica Automotriz (Inyección)',10),(114,'L.1',1,'Biología Marina (Selección Genética de Especies Acuáticas)',11),(115,'L.2',1,'Manejo de Especies Acuáticas',11),(116,'L.3',1,'Cultivo de Especies Acuáticas',11),(117,'L.4',1,'Pesca Artesanal y Buceo',11),(118,'L.5',1,'Pesca Industrial',11),(119,'L.6',1,'Tratamiento de Especies Acuáticas',11),(120,'L.7',1,'Patologías de Especies Acuáticas',11),(121,'L.8',1,'Piscicultura (Producción de Peces)',11),(122,'M.2',1,'Medios de Comunicación Social (Televisión, Radio, Prensa Escrita)',12),(123,'M.3',1,'Medios Audiovisuales (Videos, Películas, etc.)',12),(124,'M.4',1,'Métodos y Técnicas de Promoción y Difusión',12),(125,'M.5',1,'Traducción e Interpretación',12),(126,'M.6',1,'Lenguaje (Señas, Tacto, etc.)',12),(127,'M.8',1,'Grabados y Litografía',12),(128,'M.9',1,'Gráfica (Impresión, Encuadernación, Diseño y Diagramación Gráfica, Fotomecánica Full Color, etc.)',12),(129,'M.10',1,'Periodismo e Investigación (Radio, TV. y Prensa)',12),(130,'M.11',1,'Edición',12),(131,'M.12',1,'Fotografía (Digital y No Digital)',12),(132,'N.1',1,'Ajuste y Mantenimiento de Motores',13),(133,'N.2',1,'Carrocería (Mantenimiento, Reparación, Enderezada y Pintura)',13),(134,'N.3',1,'Diagnóstico y Reparación de Sistemas Automotrices',13),(135,'N.4',1,'Interpretación de Catálogos y Diagramas',13),(136,'N.5',1,'Mecánica General (Básica)',13),(137,'N.6',1,'Sistemas de Dirección, Frenos, Suspensión, Transmisión',13),(138,'N.7',1,'Vulcanización (Montaje y Desmontaje Neumáticos, Balanceo de Ruedas, etc.)',13),(139,'O.1',1,'Construcción y Reparación de Hornos',14),(140,'O.2',1,'Exploración y Explotación Minera (Extracción, Perforación de Cobre, Hierro, Petróleo, Otros)',14),(141,'O.3',1,'Forja (Fabricación de Piezas Mediante Calor y Compresión)',14),(142,'O.4',1,'Fresado (Fabricación de Piezas, Engranajes, etc., Mediante Fresadora)',14),(143,'O.5',1,'Fundición (Fabricación de Piezas Mediante la Fusión de Metales)',14),(144,'O.6',1,'Matricería (Fabricación de Moldes y Matrices de Piezas en Serie)',14),(145,'O.7',1,'Mecánica de Banco (Fabricación de Piezas Mediante Herramientas de Mano)',14),(146,'O.8',1,'Metalmecánica Metalurgia (Estructuras Metálicas, Autopartes a fin de Obtener Plantas de Proceso Llave en Mano, Superestructuras, Equipos con Alto Grado de Automatización y Componente Tecnológico)',14),(147,'O.9',1,'Balance Metalúrgico (Preparación de Muestras, Análisis Químico y Balance de Materiales)',14),(148,'O.10',1,'Geología (Mineralogía, Petrología, Cristalografía, etc.)',14),(149,'O.11',1,'Rectificación (Terminación de Piezas y Medidas Mediante Abrasivos)',14),(150,'O.12',1,'Soldadura (Eléctrica y Oxigas, Radiografía, etc.)',14),(151,'O.13',1,'Tornería (Fabricación de Piezas y Partes Mediante Torno)',14),(152,'O.14',1,'Tratamientos Térmicos (Mejoramiento de Propiedades de los Metales Mediante Calor y Frío)',14),(153,'O.15',1,'Hidráulica',14),(154,'O.16',1,'Explosivos',14),(155,'P.1',1,'Petróleo (Exploración, Extracción, Procesamiento, Tratamiento y Distribución)',15),(156,'P.3',1,'Anticorrosivos (Cromado, Niquelado, Plastificado)',15),(157,'P.4',1,'Automatización Industrial y Robótica',15),(158,'P.5',1,'Madera (Diseño, Técnicas, Procesamiento y Acabado, Muebles de Hogar, Cocina, Oficina, Industria de la Construcción, Puertas, Ventanas, Pallets)',15),(159,'P.6',1,'Cemento (Materiales de Construcción)',15),(160,'P.7',1,'Cerámica y Vidrio (Diseño, Técnicas, Tallado, Procesamiento y Acabado, Diversificación en la Concentración del Sector Cerámico)',15),(161,'P.8',1,'Cuero y Calzado (Diseño, Técnicas y Acabado)',15),(162,'P.9',1,'Envases y Embalajes',15),(163,'P.10',1,'Refrigeración (Cadena de Frio)',15),(164,'P.11',1,'Textil (Diseño, Patronaje y Confección de Prendas, Transformación de Plantillas, Costura, Sastrería)',15),(165,'P.12',1,'Tapicería',15),(166,'P.14',1,'Seguridad, Prevención de Riesgos e Higiene Industrial',15),(167,'P.15',1,'Industria Química (Galvanoplastia, Tinturas, Abonos, Plaguicidas, Barnices, Lacas, Jabones, Cosméticos, Farmoquímica, Petroquímica, etc.)',15),(168,'P.16',1,'Lavandería, Tintorería y Planchado Industrial',15),(169,'P.17',1,'Lubricantes',15),(170,'P.19',1,'Calderos (Operación, Mantenimiento y Reparación)',15),(171,'P.20',1,'Operación, Reparación y Mantenimiento de Máquinas y Equipos (Agrícola, Agropecuario, Forestal, de Construcción, Textil, Minera, Pesquera, Médicos, de Comunicación, etc.)',15),(172,'P.21',1,'Papeles y Cartones',15),(173,'P.23',1,'Plásticos y Cauchos',15),(174,'P.24',1,'Prácticas de Manufactura (Estrategia de Producción y Gestión de Materia Prima, Programas de Diversificación Sectorial, etc.)',15),(175,'P.25',1,'Energía Renovable: Bioethanol (Materia Prima: Caña de Azúcar, Rechazo de Banano, Sorgo Dulce, Algas, Desechos, Bioethanol Artesanal, etc.), Biodiesel (Materia Prima: Aceite de Palma Africana, Piñón, Colza, Soya, Biodiesel Artesanal), Biogás (Materia Prima: Residuos Orgánicos), Extracción de Alcohol Artesanal.',15),(176,'Q.1',1,'Conducción de Vehículos Terrestres',16),(177,'Q.3',1,'Mantenimiento de Aeronaves y Naves',16),(178,'Q.4',1,'Transporte de Carga y de Pasajeros (Aéreo, Fluvial, Marítimo, Terrestre)',16),(179,'Q.5',1,'Aeronáutica (Control de Operaciones, Tránsito Aéreo, Diseño y Construcción de Aeronaves, etc.)',16),(180,'Q.6',1,'Pilotaje y Técnicas de Navegación (Aéreo, Fluvial, Marítimo, Visual, Instrumental, y/o Radar, etc.)',16),(181,'Q.7',1,'Logística Integral (Diseño, Producción, Entrega y Uso de un Producto o Servicio en el Mercado)',16),(182,'Q.8',1,'Cadenas de Abastecimiento (Información, Trazabilidad, Integración, Gestión de Nodos Logísticos Productivos Locales, Centros de Distribución Logística Internacional)',16),(183,'Q.9',1,'Manejo Integral de Bodegas y Almacenes',16),(184,'Q.10',1,'Sistemas de Información Geográfica y Rutas',16),(185,'Q.11',1,'Geodesia (Agrimensura, Cartografía, Fotogrametría, Topografía)',16),(186,'R.12',1,'Peluquería y Belleza, Barbería y Estilismo',17),(187,'R.13',1,'Cosmetología',17),(188,'R.14',1,'Artesanía (Cuero, Madera, Vidrio, Piedras, Metales, Telas, Cerámica, etc.)',17),(189,'S.1',1,'Gestión Cultural',18),(190,'S.4',1,'Género',18),(191,'S.6',1,'Salud y Medicina (Medicina General Tradicional y Alternativa, Nutrición, Tratamientos y Atención Infantil, Familiar, Ocupacional, Primeros Auxilios, Emergencias y Catástrofes, etc.)',18),(192,'S.10',1,'Servicios Domésticos',18),(193,'S.12',1,'Servicios de Seguridad Física, Guardianía',18),(194,'T.1',1,'Transformación de Productos, Subproductos (Agrícola, Ganadero, Pesca, Forestal)',19),(195,'T.2',1,'Conglomerados Agroindustriales (Cárnico, Madera, Lácteos, Frutas y Vegetales, Pescado, etc.)',19),(196,'U.1',1,'',20),(197,'V.1',1,'',21);
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estrategias_metodologicas`
--

DROP TABLE IF EXISTS `estrategias_metodologicas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estrategias_metodologicas` (
  `id_estrategia_metodologica` int NOT NULL AUTO_INCREMENT,
  `estado_estrategia_metodologica_activo` tinyint(1) DEFAULT NULL,
  `finalidad_estrategia_metodologica` varchar(1000) DEFAULT NULL,
  `nombre_estrategia_metodologica` varchar(1000) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_estrategia_metodologica`),
  KEY `FK8g3ra99232b63cmy6rntpac44` (`id_silabo`),
  CONSTRAINT `FK8g3ra99232b63cmy6rntpac44` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estrategias_metodologicas`
--

LOCK TABLES `estrategias_metodologicas` WRITE;
/*!40000 ALTER TABLE `estrategias_metodologicas` DISABLE KEYS */;
INSERT INTO `estrategias_metodologicas` VALUES (1,1,'Correcto manejo de google analitycs.','Tecnología y aprendizaje.',1),(2,1,'tecnologia','n/a',2);
/*!40000 ALTER TABLE `estrategias_metodologicas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluaciondiagnosticacurriculares`
--

DROP TABLE IF EXISTS `evaluaciondiagnosticacurriculares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluaciondiagnosticacurriculares` (
  `id_evaluacion_diagnostica_curricular` int NOT NULL AUTO_INCREMENT,
  `estadoEvaluacionDiagnostica` tinyint(1) DEFAULT NULL,
  `instrumneto_evaluar` varchar(1000) DEFAULT NULL,
  `tecnica_evaluar` varchar(1000) DEFAULT NULL,
  `id_disenio_curricular` int DEFAULT NULL,
  PRIMARY KEY (`id_evaluacion_diagnostica_curricular`),
  KEY `FKmxk8d9wwu9p3i2x019ps7qk9y` (`id_disenio_curricular`),
  CONSTRAINT `FKmxk8d9wwu9p3i2x019ps7qk9y` FOREIGN KEY (`id_disenio_curricular`) REFERENCES `diseniocurriculares` (`id_disenio_curricular`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluaciondiagnosticacurriculares`
--

LOCK TABLES `evaluaciondiagnosticacurriculares` WRITE;
/*!40000 ALTER TABLE `evaluaciondiagnosticacurriculares` DISABLE KEYS */;
INSERT INTO `evaluaciondiagnosticacurriculares` VALUES (1,1,'Moodle','Primera Evaluacíon',1),(2,1,'Test','Segunda Evaluación',1),(3,0,NULL,NULL,1),(4,0,NULL,NULL,1),(5,1,'na','hola',2);
/*!40000 ALTER TABLE `evaluaciondiagnosticacurriculares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evaluacionfinalcurriculares`
--

DROP TABLE IF EXISTS `evaluacionfinalcurriculares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evaluacionfinalcurriculares` (
  `id_evaluacion_final` int NOT NULL AUTO_INCREMENT,
  `estadoEvaluacionFinal` tinyint(1) DEFAULT NULL,
  `instrumneto_formativa_final` varchar(1000) DEFAULT NULL,
  `tecnica_formativa_final` varchar(1000) DEFAULT NULL,
  `id_disenio_curricular` int DEFAULT NULL,
  PRIMARY KEY (`id_evaluacion_final`),
  KEY `FKj602cpq17snd1ln7x88e6i86d` (`id_disenio_curricular`),
  CONSTRAINT `FKj602cpq17snd1ln7x88e6i86d` FOREIGN KEY (`id_disenio_curricular`) REFERENCES `diseniocurriculares` (`id_disenio_curricular`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacionfinalcurriculares`
--

LOCK TABLES `evaluacionfinalcurriculares` WRITE;
/*!40000 ALTER TABLE `evaluacionfinalcurriculares` DISABLE KEYS */;
INSERT INTO `evaluacionfinalcurriculares` VALUES (1,1,'Moodle','Exámen final',1),(2,1,'Moodle','Test',1),(3,1,'sdfas','dasfa',2);
/*!40000 ALTER TABLE `evaluacionfinalcurriculares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evalucionformativacurriculares`
--

DROP TABLE IF EXISTS `evalucionformativacurriculares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evalucionformativacurriculares` (
  `id_evalucion_formativa_curricular` int NOT NULL AUTO_INCREMENT,
  `estadoEvaluacionFormativa` tinyint(1) DEFAULT NULL,
  `instrumneto_formativa` varchar(1000) DEFAULT NULL,
  `tecnica_formativa` varchar(1000) DEFAULT NULL,
  `id_disenio_curricular` int DEFAULT NULL,
  PRIMARY KEY (`id_evalucion_formativa_curricular`),
  KEY `FKyu4ywyk1k75w56p6ywtgyn75` (`id_disenio_curricular`),
  CONSTRAINT `FKyu4ywyk1k75w56p6ywtgyn75` FOREIGN KEY (`id_disenio_curricular`) REFERENCES `diseniocurriculares` (`id_disenio_curricular`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evalucionformativacurriculares`
--

LOCK TABLES `evalucionformativacurriculares` WRITE;
/*!40000 ALTER TABLE `evalucionformativacurriculares` DISABLE KEYS */;
INSERT INTO `evalucionformativacurriculares` VALUES (1,1,'Moodle','Tareas y lecciones',1),(2,1,'asdfasdf','asdf',2);
/*!40000 ALTER TABLE `evalucionformativacurriculares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fasespracticas`
--

DROP TABLE IF EXISTS `fasespracticas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fasespracticas` (
  `idFasePractica` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `nombreFase` varchar(15000) DEFAULT NULL,
  `id_disenio_curricular` int DEFAULT NULL,
  `idInstalacion` int DEFAULT NULL,
  `idRecurso` int DEFAULT NULL,
  PRIMARY KEY (`idFasePractica`),
  KEY `FK5xmp65snjl0bkjvukiqw98qhr` (`id_disenio_curricular`),
  KEY `FKligo857enjn2cwr1tlmxmvh5k` (`idInstalacion`),
  KEY `FK5hn6gr4v2lddqnmaciyt7p6fr` (`idRecurso`),
  CONSTRAINT `FK5hn6gr4v2lddqnmaciyt7p6fr` FOREIGN KEY (`idRecurso`) REFERENCES `recursos` (`idRecurso`),
  CONSTRAINT `FK5xmp65snjl0bkjvukiqw98qhr` FOREIGN KEY (`id_disenio_curricular`) REFERENCES `diseniocurriculares` (`id_disenio_curricular`),
  CONSTRAINT `FKligo857enjn2cwr1tlmxmvh5k` FOREIGN KEY (`idInstalacion`) REFERENCES `instalaciones` (`idInstalacion`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fasespracticas`
--

LOCK TABLES `fasespracticas` WRITE;
/*!40000 ALTER TABLE `fasespracticas` DISABLE KEYS */;
INSERT INTO `fasespracticas` VALUES (1,_binary '','                            Proyector                      .      ',1,1,2),(2,_binary '','                            computador.                     ',1,1,1),(3,_binary '','                            servidor                            \n                        \n                        ',1,2,4),(4,_binary '','                            Laboratorios.                            \n                        \n                        ',1,1,3),(5,_binary '','                            cuadernos                            \n                        \n                        ',1,2,2),(6,_binary '','                            manual de usuario                            \n                        \n                        ',1,2,3),(7,_binary '','                            asdfas',2,1,2),(8,_binary '','                   fasdd         ',2,1,1),(9,_binary '','                            \n        fasd                ',2,1,3),(10,_binary '','                            \n                  asdf      ',2,2,4),(11,_binary '','                            \n                       asdf ',2,2,2),(12,_binary '','                            \n         asdf               ',2,2,3);
/*!40000 ALTER TABLE `fasespracticas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fasesteoricas`
--

DROP TABLE IF EXISTS `fasesteoricas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fasesteoricas` (
  `idFaseTeorica` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `nombreFase` varchar(15000) DEFAULT NULL,
  `id_disenio_curricular` int DEFAULT NULL,
  `idInstalacion` int DEFAULT NULL,
  `idRecurso` int DEFAULT NULL,
  PRIMARY KEY (`idFaseTeorica`),
  KEY `FKhhfqnfawsli5c5u9siysxnjil` (`id_disenio_curricular`),
  KEY `FKfr26iwvwj48wr1ulgd185ewj3` (`idInstalacion`),
  KEY `FK2qkmvk4m60ge88sslaafo3mp0` (`idRecurso`),
  CONSTRAINT `FK2qkmvk4m60ge88sslaafo3mp0` FOREIGN KEY (`idRecurso`) REFERENCES `recursos` (`idRecurso`),
  CONSTRAINT `FKfr26iwvwj48wr1ulgd185ewj3` FOREIGN KEY (`idInstalacion`) REFERENCES `instalaciones` (`idInstalacion`),
  CONSTRAINT `FKhhfqnfawsli5c5u9siysxnjil` FOREIGN KEY (`id_disenio_curricular`) REFERENCES `diseniocurriculares` (`id_disenio_curricular`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fasesteoricas`
--

LOCK TABLES `fasesteoricas` WRITE;
/*!40000 ALTER TABLE `fasesteoricas` DISABLE KEYS */;
INSERT INTO `fasesteoricas` VALUES (1,_binary '','                                                        computador.',1,1,1),(2,_binary '','Servidor',1,2,4),(3,_binary '','manual de usuario',1,2,3),(4,_binary '','Cuadernos',1,2,2),(5,_binary '','Proyector.',1,1,2),(6,_binary '','Documentación',1,1,3),(7,_binary '','fasdf',2,1,2),(8,_binary '','asdf',2,2,4),(9,_binary '','                            asdfas',2,1,1),(10,_binary '','asdf',2,2,2),(11,_binary '','dfas',2,1,3),(12,_binary '','asdf',2,2,3);
/*!40000 ALTER TABLE `fasesteoricas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hojavidacapacitadores`
--

DROP TABLE IF EXISTS `hojavidacapacitadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hojavidacapacitadores` (
  `id_hoja_vida` int NOT NULL AUTO_INCREMENT,
  `documento` varchar(100) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `id_capacitador` int DEFAULT NULL,
  PRIMARY KEY (`id_hoja_vida`),
  KEY `FKms2c2ex21rpsycml2t722aejt` (`id_capacitador`),
  CONSTRAINT `FKms2c2ex21rpsycml2t722aejt` FOREIGN KEY (`id_capacitador`) REFERENCES `capacitadores` (`id_capacitador`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hojavidacapacitadores`
--

LOCK TABLES `hojavidacapacitadores` WRITE;
/*!40000 ALTER TABLE `hojavidacapacitadores` DISABLE KEYS */;
INSERT INTO `hojavidacapacitadores` VALUES (1,'4e62bfe2-ac6b-4b30-aeb4-cdacdd364ecd_CertificadodePago.pdf',_binary '',1);
/*!40000 ALTER TABLE `hojavidacapacitadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarioscursos`
--

DROP TABLE IF EXISTS `horarioscursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarioscursos` (
  `id_horario_curso` int NOT NULL AUTO_INCREMENT,
  `dias` varchar(255) DEFAULT NULL,
  `estado_horario_curso` tinyint(1) DEFAULT NULL,
  `hora_fin` varchar(255) DEFAULT NULL,
  `hora_inicio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_horario_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarioscursos`
--

LOCK TABLES `horarioscursos` WRITE;
/*!40000 ALTER TABLE `horarioscursos` DISABLE KEYS */;
INSERT INTO `horarioscursos` VALUES (1,'Lunes-Viernes',1,'1 0 PM','7 0 AM'),(2,'Lunes-Viernes',1,'10 0 PM','6 0 AM');
/*!40000 ALTER TABLE `horarioscursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informefinalcursos`
--

DROP TABLE IF EXISTS `informefinalcursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informefinalcursos` (
  `id_informe_final_curso` int NOT NULL AUTO_INCREMENT,
  `lugar_informe_final_curso` varchar(500) DEFAULT NULL,
  `canton_informe_final_curso` varchar(500) DEFAULT NULL,
  `observaciones_informe_final_curso` varchar(1200) DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_informe_final_curso`),
  KEY `FKnsp5grkq1x8u4awfo8ko9m6kr` (`id_curso`),
  CONSTRAINT `FKnsp5grkq1x8u4awfo8ko9m6kr` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informefinalcursos`
--

LOCK TABLES `informefinalcursos` WRITE;
/*!40000 ALTER TABLE `informefinalcursos` DISABLE KEYS */;
INSERT INTO `informefinalcursos` VALUES (1,'dadsfasdf','asdfasdf','nada',1);
/*!40000 ALTER TABLE `informefinalcursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscritos`
--

DROP TABLE IF EXISTS `inscritos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscritos` (
  `id_inscrito` int NOT NULL AUTO_INCREMENT,
  `estado_inscrito` tinyint(1) DEFAULT NULL,
  `estado_inscrito_activo` tinyint(1) DEFAULT NULL,
  `fecha_inscrito` date DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_inscrito`),
  KEY `FKlo786cufu6vrjkn94in24uead` (`id_curso`),
  KEY `FKatt6jb6cu3io8ms0774sw1x9q` (`id_usuario`),
  CONSTRAINT `FKatt6jb6cu3io8ms0774sw1x9q` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `FKlo786cufu6vrjkn94in24uead` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscritos`
--

LOCK TABLES `inscritos` WRITE;
/*!40000 ALTER TABLE `inscritos` DISABLE KEYS */;
INSERT INTO `inscritos` VALUES (1,1,1,'2023-10-10',1,3),(2,1,1,'2023-10-17',1,5);
/*!40000 ALTER TABLE `inscritos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalaciones`
--

DROP TABLE IF EXISTS `instalaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instalaciones` (
  `idInstalacion` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idInstalacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalaciones`
--

LOCK TABLES `instalaciones` WRITE;
/*!40000 ALTER TABLE `instalaciones` DISABLE KEYS */;
INSERT INTO `instalaciones` VALUES (1,_binary '','Aula'),(2,_binary '','Taller o laboratorio');
/*!40000 ALTER TABLE `instalaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista_necesidad_cursos`
--

DROP TABLE IF EXISTS `lista_necesidad_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_necesidad_cursos` (
  `id_lista_necesidad_cursos` int NOT NULL AUTO_INCREMENT,
  `detalle_nececidad_curso` varchar(1500) DEFAULT NULL,
  `estado_detalle_necesidad` tinyint(1) DEFAULT NULL,
  `id_necesidad_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_lista_necesidad_cursos`),
  KEY `FKam4yxac5wyb4l7npxh2dkohy6` (`id_necesidad_curso`),
  CONSTRAINT `FKam4yxac5wyb4l7npxh2dkohy6` FOREIGN KEY (`id_necesidad_curso`) REFERENCES `necesidadescursos` (`id_necesidad_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_necesidad_cursos`
--

LOCK TABLES `lista_necesidad_cursos` WRITE;
/*!40000 ALTER TABLE `lista_necesidad_cursos` DISABLE KEYS */;
INSERT INTO `lista_necesidad_cursos` VALUES (1,'Tecnológico ',1,1),(2,'Tendencias. ',1,1);
/*!40000 ALTER TABLE `lista_necesidad_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_audiovisuales`
--

DROP TABLE IF EXISTS `material_audiovisuales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_audiovisuales` (
  `id_material_audiovisual` int NOT NULL AUTO_INCREMENT,
  `descripcion_material_audiovisual` varchar(1500) DEFAULT NULL,
  `estado_material_audiovisual` tinyint(1) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_material_audiovisual`),
  KEY `FKcrlfbpyckg4366djb12lr7b7h` (`id_silabo`),
  CONSTRAINT `FKcrlfbpyckg4366djb12lr7b7h` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_audiovisuales`
--

LOCK TABLES `material_audiovisuales` WRITE;
/*!40000 ALTER TABLE `material_audiovisuales` DISABLE KEYS */;
INSERT INTO `material_audiovisuales` VALUES (1,'Documentación ',1,1),(2,'Computadora',1,1),(3,'N/a',1,2);
/*!40000 ALTER TABLE `material_audiovisuales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_convencionales`
--

DROP TABLE IF EXISTS `material_convencionales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_convencionales` (
  `id_material_monvencional` int NOT NULL AUTO_INCREMENT,
  `descripcion_material_convencional` varchar(1500) DEFAULT NULL,
  `estado_material_convencional` tinyint(1) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_material_monvencional`),
  KEY `FKndo1whek05dd9odo2wmxfb10n` (`id_silabo`),
  CONSTRAINT `FKndo1whek05dd9odo2wmxfb10n` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_convencionales`
--

LOCK TABLES `material_convencionales` WRITE;
/*!40000 ALTER TABLE `material_convencionales` DISABLE KEYS */;
INSERT INTO `material_convencionales` VALUES (1,'Google Analytics Plataforma',1,1),(2,'n/a',1,2);
/*!40000 ALTER TABLE `material_convencionales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modalidades_cursos`
--

DROP TABLE IF EXISTS `modalidades_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modalidades_cursos` (
  `id_modalidad_curso` int NOT NULL AUTO_INCREMENT,
  `estado_modalidad_curso` tinyint(1) DEFAULT NULL,
  `nombre_modalidad_curso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_modalidad_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modalidades_cursos`
--

LOCK TABLES `modalidades_cursos` WRITE;
/*!40000 ALTER TABLE `modalidades_cursos` DISABLE KEYS */;
INSERT INTO `modalidades_cursos` VALUES (1,1,'Presencial'),(2,1,'Virtual');
/*!40000 ALTER TABLE `modalidades_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `necesidadescursos`
--

DROP TABLE IF EXISTS `necesidadescursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `necesidadescursos` (
  `id_necesidad_curso` int NOT NULL AUTO_INCREMENT,
  `estado_impartir_necesidad_curso` varchar(1500) DEFAULT NULL,
  `poblacion_dirijida` varchar(500) DEFAULT NULL,
  `resumen_curso` varchar(1500) DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_necesidad_curso`),
  KEY `FKcgly9pgfyqcl3mbv08ydykxd0` (`id_curso`),
  CONSTRAINT `FKcgly9pgfyqcl3mbv08ydykxd0` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `necesidadescursos`
--

LOCK TABLES `necesidadescursos` WRITE;
/*!40000 ALTER TABLE `necesidadescursos` DISABLE KEYS */;
INSERT INTO `necesidadescursos` VALUES (1,'Instalaciones ISTA','Estudiantes y Profesionales','Google Analytics es una herramienta de analítica web de la empresa Google.',1);
/*!40000 ALTER TABLE `necesidadescursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `niveles_cursos`
--

DROP TABLE IF EXISTS `niveles_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `niveles_cursos` (
  `id_nivel_curso` int NOT NULL AUTO_INCREMENT,
  `estado_nivel_curso` tinyint(1) DEFAULT NULL,
  `nombre_nivel_curso` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_nivel_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `niveles_cursos`
--

LOCK TABLES `niveles_cursos` WRITE;
/*!40000 ALTER TABLE `niveles_cursos` DISABLE KEYS */;
INSERT INTO `niveles_cursos` VALUES (1,1,'Básico'),(2,1,'Intermedio'),(3,1,'Superior');
/*!40000 ALTER TABLE `niveles_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `id_nota` int NOT NULL AUTO_INCREMENT,
  `examen_final` int DEFAULT NULL,
  `fecha_nota` date DEFAULT NULL,
  `informe1` int DEFAULT NULL,
  `informe2` int DEFAULT NULL,
  `informe3` int DEFAULT NULL,
  `observacion` varchar(1500) DEFAULT NULL,
  `parcial` int DEFAULT NULL,
  `id_participante_matriculado` int DEFAULT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `FKdmtgob030cmum6ki660q8wnuj` (`id_participante_matriculado`),
  CONSTRAINT `FKdmtgob030cmum6ki660q8wnuj` FOREIGN KEY (`id_participante_matriculado`) REFERENCES `partipantesmatriculados` (`id_participante_matriculado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parroquias`
--

DROP TABLE IF EXISTS `parroquias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parroquias` (
  `id_parroquia` int NOT NULL AUTO_INCREMENT,
  `parroquia` varchar(255) DEFAULT NULL,
  `id_canton` int DEFAULT NULL,
  PRIMARY KEY (`id_parroquia`),
  KEY `FK9r7danvcdn46drnjn6egimfqj` (`id_canton`),
  CONSTRAINT `FK9r7danvcdn46drnjn6egimfqj` FOREIGN KEY (`id_canton`) REFERENCES `cantones` (`id_canton`)
) ENGINE=InnoDB AUTO_INCREMENT=1400 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parroquias`
--

LOCK TABLES `parroquias` WRITE;
/*!40000 ALTER TABLE `parroquias` DISABLE KEYS */;
INSERT INTO `parroquias` VALUES (1,'Bellavista',1),(2,'Cañaribamba',1),(3,'El Batán',1),(4,'El Sagrario',1),(5,'El Vecino',1),(6,'Gil Ramírez Dávalos',1),(7,'Huaynacápac',1),(8,'Machángara',1),(9,'Monay',1),(10,'San Blas',1),(11,'San Sebastián',1),(12,'Sucre',1),(13,'Totoracocha',1),(14,'Yanuncay',1),(15,'Hermano Miguel',1),(16,'Cuenca',1),(17,'Baños',1),(18,'Cumbe',1),(19,'Chaucha',1),(20,'Checa (Jidcay)',1),(21,'Chiquintad',1),(22,'Llacao',1),(23,'Molleturo',1),(24,'Nulti',1),(25,'Octavio Cordero Palacios (Santa Rosa)',1),(26,'Paccha',1),(27,'Quingeo',1),(28,'Ricaurte',1),(29,'San Joaquín',1),(30,'Santa Ana',1),(31,'Sayausí',1),(32,'Sidcay',1),(33,'Sinincay',1),(34,'Tarqui',1),(35,'Turi',1),(36,'Valle',1),(37,'Victoria del Portete (Irquis)',1),(38,'Girón',2),(39,'Asunción',2),(40,'San Gerardo',2),(41,'Gualaceo',3),(42,'Chordeleg',3),(43,'Daniel Córdova Toral (El Oriente)',3),(44,'Jadán',3),(45,'Mariano Moreno',3),(46,'Principal',3),(47,'Remigio Crespo Toral (Gúlag)',3),(48,'San Juan',3),(49,'Zhidmad',3),(50,'Luis Cordero Vega',3),(51,'Simón Bolívar (Cab. En Gañanzol)',3),(52,'Nabón',4),(53,'Cochapata',4),(54,'El Progreso (Cab.En Zhota)',4),(55,'Las Nieves (Chaya)',4),(56,'Oña',4),(57,'Paute',5),(58,'Amaluza',5),(59,'Bulán (José Víctor Izquierdo)',5),(60,'Chicán (Guillermo Ortega)',5),(61,'El Cabo',5),(62,'Guachapala',5),(63,'Guarainag',5),(64,'Palmas',5),(65,'Pan',5),(66,'San Cristóbal (Carlos Ordóñez Lazo)',5),(67,'Sevilla de Oro',5),(68,'Tomebamba',5),(69,'Dug Dug',5),(70,'Pucará',6),(71,'Camilo Ponce Enríquez (Cab. En Río 7 de Mollepongo)',6),(72,'San Rafael de Sharug',6),(73,'San Fernando',7),(74,'Chumblín',7),(75,'Santa Isabel (Chaguarurco)',8),(76,'Abdón Calderón (La Unión)',8),(77,'El Carmen de Pijilí',8),(78,'Zhaglli (Shaglli)',8),(79,'San Salvador de Cañaribamba',8),(80,'Sigsig',9),(81,'Cuchil (Cutchil)',9),(82,'Gima',9),(83,'Guel',9),(84,'Ludo',9),(85,'San Bartolomé',9),(86,'San José de Raranga',9),(87,'San Felipe de Oña Cabecera Cantonal',10),(88,'Susudel',10),(89,'Chordeleg',11),(90,'Principal',11),(91,'La Unión',11),(92,'Luis Galarza Orellana (Cab.En Delegsol)',11),(93,'San Martín de Puzhio',11),(94,'El Pan',12),(95,'Amaluza',12),(96,'Palmas',12),(97,'San Vicente',12),(98,'Sevilla de Oro',13),(99,'Amaluza',13),(100,'Palmas',13),(101,'Guachapala',14),(102,'Camilo Ponce Enríquez',15),(103,'El Carmen de Pijilí',15),(104,'Ángel Polibio Cháves',16),(105,'Gabriel Ignacio Veintimilla',16),(106,'Guanujo',16),(107,'Guaranda',16),(108,'Facundo Vela',16),(109,'Guanujo',16),(110,'Julio E. Moreno (Catanahuán Grande)',16),(111,'Las Naves',16),(112,'Salinas',16),(113,'San Lorenzo',16),(114,'San Simón (Yacoto)',16),(115,'Santa Fé (Santa Fé)',16),(116,'Simiátug',16),(117,'San Luis de Pambil',16),(118,'Chillanes',17),(119,'San José del Tambo (Tambopamba)',17),(120,'San José de Chimbo',18),(121,'Asunción (Asancoto)',18),(122,'Caluma',18),(123,'Magdalena (Chapacoto)',18),(124,'San Sebastián',18),(125,'Telimbela',18),(126,'Echeandía',19),(127,'San Miguel',20),(128,'Balsapamba',20),(129,'Bilován',20),(130,'Régulo de Mora',20),(131,'San Pablo (San Pablo de Atenas)',20),(132,'Santiago',20),(133,'San Vicente',20),(134,'Caluma',21),(135,'Las Mercedes',22),(136,'Las Naves',22),(137,'Las Naves',22),(138,'Aurelio Bayas Martínez',23),(139,'Azogues',23),(140,'Borrero',23),(141,'San Francisco',23),(142,'Azogues',23),(143,'Cojitambo',23),(144,'Déleg',23),(145,'Guapán',23),(146,'Javier Loyola (Chuquipata)',23),(147,'Luis Cordero',23),(148,'Pindilig',23),(149,'Rivera',23),(150,'San Miguel',23),(151,'Solano',23),(152,'Taday',23),(153,'Biblián',24),(154,'Nazón (Cab. En Pampa de Domínguez)',24),(155,'San Francisco de Sageo',24),(156,'Turupamba',24),(157,'Jerusalén',24),(158,'Cañar',25),(159,'Chontamarca',25),(160,'Chorocopte',25),(161,'General Morales (Socarte)',25),(162,'Gualleturo',25),(163,'Honorato Vásquez (Tambo Viejo)',25),(164,'Ingapirca',25),(165,'Juncal',25),(166,'San Antonio',25),(167,'Suscal',25),(168,'Tambo',25),(169,'Zhud',25),(170,'Ventura',25),(171,'Ducur',25),(172,'La Troncal',26),(173,'Manuel J. Calle',26),(174,'Pancho Negro',26),(175,'El Tambo',27),(176,'Déleg',28),(177,'Solano',28),(178,'Suscal',29),(179,'González Suárez',30),(180,'Tulcán',30),(181,'Tulcán',30),(182,'El Carmelo (El Pun)',30),(183,'Huaca',30),(184,'Julio Andrade (Orejuela)',30),(185,'Maldonado',30),(186,'Pioter',30),(187,'Tobar Donoso (La Bocana de Camumbí)',30),(188,'Tufiño',30),(189,'Urbina (Taya)',30),(190,'El Chical',30),(191,'Mariscal Sucre',30),(192,'Santa Martha de Cuba',30),(193,'Bolívar',31),(194,'García Moreno',31),(195,'Los Andes',31),(196,'Monte Olivo',31),(197,'San Vicente de Pusir',31),(198,'San Rafael',31),(199,'El Ángel',32),(200,'27 de Septiembre',32),(201,'El Angel',32),(202,'El Goaltal',32),(203,'La Libertad (Alizo)',32),(204,'San Isidro',32),(205,'Mira (Chontahuasi)',33),(206,'Concepción',33),(207,'Jijón Y Caamaño (Cab. En Río Blanco)',33),(208,'Juan Montalvo (San Ignacio de Quil)',33),(209,'González Suárez',34),(210,'San José',34),(211,'San Gabriel',34),(212,'Cristóbal Colón',34),(213,'Chitán de Navarrete',34),(214,'Fernández Salvador',34),(215,'La Paz',34),(216,'Piartal',34),(217,'Huaca',35),(218,'Mariscal Sucre',35),(219,'Eloy Alfaro (San Felipe)',36),(220,'Ignacio Flores (Parque Flores)',36),(221,'Juan Montalvo (San Sebastián)',36),(222,'La Matriz',36),(223,'San Buenaventura',36),(224,'Latacunga',36),(225,'Alaques (Aláquez)',36),(226,'Belisario Quevedo (Guanailín)',36),(227,'Guaitacama (Guaytacama)',36),(228,'Joseguango Bajo',36),(229,'Las Pampas',36),(230,'Mulaló',36),(231,'11 de Noviembre (Ilinchisi)',36),(232,'Poaló',36),(233,'San Juan de Pastocalle',36),(234,'Sigchos',36),(235,'Tanicuchí',36),(236,'Toacaso',36),(237,'Palo Quemado',36),(238,'El Carmen',37),(239,'La Maná',37),(240,'El Triunfo',37),(241,'La Maná',37),(242,'Guasaganda (Cab.En Guasaganda',37),(243,'Pucayacu',37),(244,'El Corazón',38),(245,'Moraspungo',38),(246,'Pinllopata',38),(247,'Ramón Campaña',38),(248,'Pujilí',39),(249,'Angamarca',39),(250,'Chucchilán (Chugchilán)',39),(251,'Guangaje',39),(252,'Isinlibí (Isinliví)',39),(253,'La Victoria',39),(254,'Pilaló',39),(255,'Tingo',39),(256,'Zumbahua',39),(257,'San Miguel',40),(258,'Antonio José Holguín (Santa Lucía)',40),(259,'Cusubamba',40),(260,'Mulalillo',40),(261,'Mulliquindil (Santa Ana)',40),(262,'Pansaleo',40),(263,'Saquisilí',41),(264,'Canchagua',41),(265,'Chantilín',41),(266,'Cochapamba',41),(267,'Sigchos',42),(268,'Chugchillán',42),(269,'Isinliví',42),(270,'Las Pampas',42),(271,'Palo Quemado',42),(272,'Lizarzaburu',43),(273,'Maldonado',43),(274,'Velasco',43),(275,'Veloz',43),(276,'Yaruquíes',43),(277,'Riobamba',43),(278,'Cacha (Cab. En Machángara)',43),(279,'Calpi',43),(280,'Cubijíes',43),(281,'Flores',43),(282,'Licán',43),(283,'Licto',43),(284,'Pungalá',43),(285,'Punín',43),(286,'Quimiag',43),(287,'San Juan',43),(288,'San Luis',43),(289,'Alausí',44),(290,'Achupallas',44),(291,'Cumandá',44),(292,'Guasuntos',44),(293,'Huigra',44),(294,'Multitud',44),(295,'Pistishí (Nariz del Diablo)',44),(296,'Pumallacta',44),(297,'Sevilla',44),(298,'Sibambe',44),(299,'Tixán',44),(300,'Cajabamba',45),(301,'Sicalpa',45),(302,'Villa La Unión (Cajabamba)',45),(303,'Cañi',45),(304,'Columbe',45),(305,'Juan de Velasco (Pangor)',45),(306,'Santiago de Quito (Cab. En San Antonio de Quito)',45),(307,'Chambo',46),(308,'Chunchi',47),(309,'Capzol',47),(310,'Compud',47),(311,'Gonzol',47),(312,'Llagos',47),(313,'Guamote',48),(314,'Cebadas',48),(315,'Palmira',48),(316,'El Rosario',49),(317,'La Matriz',49),(318,'Guano',49),(319,'Guanando',49),(320,'Ilapo',49),(321,'La Providencia',49),(322,'San Andrés',49),(323,'San Gerardo de Pacaicaguán',49),(324,'San Isidro de Patulú',49),(325,'San José del Chazo',49),(326,'Santa Fé de Galán',49),(327,'Valparaíso',49),(328,'Pallatanga',50),(329,'Penipe',51),(330,'El Altar',51),(331,'Matus',51),(332,'Puela',51),(333,'San Antonio de Bayushig',51),(334,'La Candelaria',51),(335,'Bilbao (Cab.En Quilluyacu)',51),(336,'Cumandá',52),(337,'La Providencia',53),(338,'Machala',53),(339,'Puerto Bolívar',53),(340,'Nueve de Mayo',53),(341,'El Cambio',53),(342,'Machala',53),(343,'El Cambio',53),(344,'El Retiro',53),(345,'Arenillas',54),(346,'Chacras',54),(347,'La Libertad',54),(348,'Las Lajas (Cab. En La Victoria)',54),(349,'Palmales',54),(350,'Carcabón',54),(351,'Paccha',55),(352,'Ayapamba',55),(353,'Cordoncillo',55),(354,'Milagro',55),(355,'San José',55),(356,'San Juan de Cerro Azul',55),(357,'Balsas',56),(358,'Bellamaría',56),(359,'Chilla',57),(360,'El Guabo',58),(361,'Barbones (Sucre)',58),(362,'La Iberia',58),(363,'Tendales (Cab.En Puerto Tendales)',58),(364,'Río Bonito',58),(365,'Ecuador',59),(366,'El Paraíso',59),(367,'Hualtaco',59),(368,'Milton Reyes',59),(369,'Unión Lojana',59),(370,'Huaquillas',59),(371,'Marcabelí',60),(372,'El Ingenio',60),(373,'Bolívar',61),(374,'Loma de Franco',61),(375,'Ochoa León (Matriz)',61),(376,'Tres Cerritos',61),(377,'Pasaje',61),(378,'Buenavista',61),(379,'Casacay',61),(380,'La Peaña',61),(381,'Progreso',61),(382,'Uzhcurrumi',61),(383,'Cañaquemada',61),(384,'La Matriz',62),(385,'La Susaya',62),(386,'Piñas Grande',62),(387,'Piñas',62),(388,'Capiro (Cab. En La Capilla de Capiro)',62),(389,'La Bocana',62),(390,'Moromoro (Cab. En El Vado)',62),(391,'Piedras',62),(392,'San Roque (Ambrosio Maldonado)',62),(393,'Saracay',62),(394,'Portovelo',63),(395,'Curtincapa',63),(396,'Morales',63),(397,'Salatí',63),(398,'Santa Rosa',64),(399,'Puerto Jelí',64),(400,'Balneario Jambelí (Satélite)',64),(401,'Jumón (Satélite)',64),(402,'Nuevo Santa Rosa',64),(403,'Santa Rosa',64),(404,'Bellavista',64),(405,'Jambelí',64),(406,'La Avanzada',64),(407,'San Antonio',64),(408,'Torata',64),(409,'Victoria',64),(410,'Bellamaría',64),(411,'Zaruma',65),(412,'Abañín',65),(413,'Arcapamba',65),(414,'Guanazán',65),(415,'Guizhaguiña',65),(416,'Huertas',65),(417,'Malvas',65),(418,'Muluncay Grande',65),(419,'Sinsao',65),(420,'Salvias',65),(421,'La Victoria',66),(422,'Platanillos',66),(423,'Valle Hermoso',66),(424,'La Victoria',66),(425,'La Libertad',66),(426,'El Paraíso',66),(427,'San Isidro',66),(428,'Bartolomé Ruiz (César Franco Carrión)',67),(429,'5 de Agosto',67),(430,'Esmeraldas',67),(431,'Luis Tello (Las Palmas)',67),(432,'Simón Plata Torres',67),(433,'Esmeraldas',67),(434,'Atacames',67),(435,'Camarones (Cab. En San Vicente)',67),(436,'Crnel. Carlos Concha Torres (Cab.En Huele)',67),(437,'Chinca',67),(438,'Chontaduro',67),(439,'Chumundé',67),(440,'Lagarto',67),(441,'La Unión',67),(442,'Majua',67),(443,'Montalvo (Cab. En Horqueta)',67),(444,'Río Verde',67),(445,'Rocafuerte',67),(446,'San Mateo',67),(447,'Súa (Cab. En La Bocana)',67),(448,'Tabiazo',67),(449,'Tachina',67),(450,'Tonchigüe',67),(451,'Vuelta Larga',67),(452,'Valdez (Limones)',68),(453,'Anchayacu',68),(454,'Atahualpa (Cab. En Camarones)',68),(455,'Borbón',68),(456,'La Tola',68),(457,'Luis Vargas Torres (Cab. En Playa de Oro)',68),(458,'Maldonado',68),(459,'Pampanal de Bolívar',68),(460,'San Francisco de Onzole',68),(461,'Santo Domingo de Onzole',68),(462,'Selva Alegre',68),(463,'Telembí',68),(464,'Colón Eloy del María',68),(465,'San José de Cayapas',68),(466,'Timbiré',68),(467,'Muisne',69),(468,'Bolívar',69),(469,'Daule',69),(470,'Galera',69),(471,'Quingue (Olmedo Perdomo Franco)',69),(472,'Salima',69),(473,'San Francisco',69),(474,'San Gregorio',69),(475,'San José de Chamanga (Cab.En Chamanga)',69),(476,'Rosa Zárate (Quinindé)',70),(477,'Cube',70),(478,'Chura (Chancama) (Cab. En El Yerbero)',70),(479,'Malimpia',70),(480,'Viche',70),(481,'La Unión',70),(482,'San Lorenzo',71),(483,'Alto Tambo (Cab. En Guadual)',71),(484,'Ancón (Pichangal) (Cab. En Palma Real)',71),(485,'Calderón',71),(486,'Carondelet',71),(487,'5 de Junio (Cab. En Uimbi)',71),(488,'Concepción',71),(489,'Mataje (Cab. En Santander)',71),(490,'San Javier de Cachaví (Cab. En San Javier)',71),(491,'Santa Rita',71),(492,'Tambillo',71),(493,'Tululbí (Cab. En Ricaurte)',71),(494,'Urbina',71),(495,'Atacames',72),(496,'La Unión',72),(497,'Súa (Cab. En La Bocana)',72),(498,'Tonchigüe',72),(499,'Tonsupa',72),(500,'Rioverde',73),(501,'Chontaduro',73),(502,'Chumundé',73),(503,'Lagarto',73),(504,'Montalvo (Cab. En Horqueta)',73),(505,'Rocafuerte',73),(506,'La Concordia',74),(507,'Monterrey',74),(508,'La Villegas',74),(509,'Plan Piloto',74),(510,'Ayacucho',75),(511,'Bolívar (Sagrario)',75),(512,'Carbo (Concepción)',75),(513,'Febres Cordero',75),(514,'García Moreno',75),(515,'Letamendi',75),(516,'Nueve de Octubre',75),(517,'Olmedo (San Alejo)',75),(518,'Roca',75),(519,'Rocafuerte',75),(520,'Sucre',75),(521,'Tarqui',75),(522,'Urdaneta',75),(523,'Ximena',75),(524,'Pascuales',75),(525,'Guayaquil',75),(526,'Chongón',75),(527,'Juan Gómez Rendón (Progreso)',75),(528,'Morro',75),(529,'Pascuales',75),(530,'Playas (Gral. Villamil)',75),(531,'Posorja',75),(532,'Puná',75),(533,'Tenguel',75),(534,'Alfredo Baquerizo Moreno (Juján)',76),(535,'Balao',77),(536,'Balzar',78),(537,'Colimes',79),(538,'San Jacinto',79),(539,'Daule',80),(540,'La Aurora (Satélite)',80),(541,'Banife',80),(542,'Emiliano Caicedo Marcos',80),(543,'Magro',80),(544,'Padre Juan Bautista Aguirre',80),(545,'Santa Clara',80),(546,'Vicente Piedrahita',80),(547,'Daule',80),(548,'Isidro Ayora (Soledad)',80),(549,'Juan Bautista Aguirre (Los Tintos)',80),(550,'Laurel',80),(551,'Limonal',80),(552,'Lomas de Sargentillo',80),(553,'Los Lojas (Enrique Baquerizo Moreno)',80),(554,'Piedrahita (Nobol)',80),(555,'Eloy Alfaro (Durán)',81),(556,'El Recreo',81),(557,'Eloy Alfaro (Durán)',81),(558,'Velasco Ibarra (El Empalme)',82),(559,'Guayas (Pueblo Nuevo)',82),(560,'El Rosario',82),(561,'El Triunfo',83),(562,'Milagro',84),(563,'Chobo',84),(564,'General Elizalde (Bucay)',84),(565,'Mariscal Sucre (Huaques)',84),(566,'Roberto Astudillo (Cab. En Cruce de Venecia)',84),(567,'Naranjal',85),(568,'Jesús María',85),(569,'San Carlos',85),(570,'Santa Rosa de Flandes',85),(571,'Taura',85),(572,'Naranjito',86),(573,'Palestina',87),(574,'Pedro Carbo',88),(575,'Valle de La Virgen',88),(576,'Sabanilla',88),(577,'Samborondón',89),(578,'La Puntilla (Satélite)',89),(579,'Samborondón',89),(580,'Tarifa',89),(581,'Santa Lucía',90),(582,'Bocana',91),(583,'Candilejos',91),(584,'Central',91),(585,'Paraíso',91),(586,'San Mateo',91),(587,'El Salitre (Las Ramas)',91),(588,'Gral. Vernaza (Dos Esteros)',91),(589,'La Victoria (Ñauza)',91),(590,'Junquillal',91),(591,'San Jacinto de Yaguachi',92),(592,'Crnel. Lorenzo de Garaicoa (Pedregal)',92),(593,'Crnel. Marcelino Maridueña (San Carlos)',92),(594,'Gral. Pedro J. Montero (Boliche)',92),(595,'Simón Bolívar',92),(596,'Yaguachi Viejo (Cone)',92),(597,'Virgen de Fátima',92),(598,'General Villamil (Playas)',93),(599,'Simón Bolívar',94),(600,'Crnel.Lorenzo de Garaicoa (Pedregal)',94),(601,'Coronel Marcelino Maridueña (San Carlos)',95),(602,'Lomas de Sargentillo',96),(603,'Isidro Ayora (Soledad)',96),(604,'Narcisa de Jesús',97),(605,'General Antonio Elizalde (Bucay)',98),(606,'Isidro Ayora',99),(607,'Caranqui',100),(608,'Guayaquil de Alpachaca',100),(609,'Sagrario',100),(610,'San Francisco',100),(611,'La Dolorosa del Priorato',100),(612,'San Miguel de Ibarra',100),(613,'Ambuquí',100),(614,'Angochagua',100),(615,'Carolina',100),(616,'La Esperanza',100),(617,'Lita',100),(618,'Salinas',100),(619,'San Antonio',100),(620,'Andrade Marín (Lourdes)',101),(621,'Atuntaqui',101),(622,'Atuntaqui',101),(623,'Imbaya (San Luis de Cobuendo)',101),(624,'San Francisco de Natabuela',101),(625,'San José de Chaltura',101),(626,'San Roque',101),(627,'Sagrario',102),(628,'San Francisco',102),(629,'Cotacachi',102),(630,'Apuela',102),(631,'García Moreno (Llurimagua)',102),(632,'Imantag',102),(633,'Peñaherrera',102),(634,'Plaza Gutiérrez (Calvario)',102),(635,'Quiroga',102),(636,'6 de Julio de Cuellaje (Cab. En Cuellaje)',102),(637,'Vacas Galindo (El Churo) (Cab.En San Miguel Alto',102),(638,'Jordán',103),(639,'San Luis',103),(640,'Otavalo',103),(641,'Dr. Miguel Egas Cabezas (Peguche)',103),(642,'Eugenio Espejo (Calpaquí)',103),(643,'González Suárez',103),(644,'Pataquí',103),(645,'San José de Quichinche',103),(646,'San Juan de Ilumán',103),(647,'San Pablo',103),(648,'San Rafael',103),(649,'Selva Alegre (Cab.En San Miguel de Pamplona)',103),(650,'Pimampiro',104),(651,'Chugá',104),(652,'Mariano Acosta',104),(653,'San Francisco de Sigsipamba',104),(654,'Urcuquí Cabecera Cantonal',105),(655,'Cahuasquí',105),(656,'La Merced de Buenos Aires',105),(657,'Pablo Arenas',105),(658,'San Blas',105),(659,'Tumbabiro',105),(660,'El Sagrario',106),(661,'San Sebastián',106),(662,'Sucre',106),(663,'Valle',106),(664,'Loja',106),(665,'Chantaco',106),(666,'Chuquiribamba',106),(667,'El Cisne',106),(668,'Gualel',106),(669,'Jimbilla',106),(670,'Malacatos (Valladolid)',106),(671,'San Lucas',106),(672,'San Pedro de Vilcabamba',106),(673,'Santiago',106),(674,'Taquil (Miguel Riofrío)',106),(675,'Vilcabamba (Victoria)',106),(676,'Yangana (Arsenio Castillo)',106),(677,'Quinara',106),(678,'Cariamanga',107),(679,'Chile',107),(680,'San Vicente',107),(681,'Cariamanga',107),(682,'Colaisaca',107),(683,'El Lucero',107),(684,'Utuana',107),(685,'Sanguillín',107),(686,'Catamayo',108),(687,'San José',108),(688,'Catamayo (La Toma)',108),(689,'El Tambo',108),(690,'Guayquichuma',108),(691,'San Pedro de La Bendita',108),(692,'Zambi',108),(693,'Celica',109),(694,'Cruzpamba (Cab. En Carlos Bustamante)',109),(695,'Chaquinal',109),(696,'12 de Diciembre (Cab. En Achiotes)',109),(697,'Pindal (Federico Páez)',109),(698,'Pozul (San Juan de Pozul)',109),(699,'Sabanilla',109),(700,'Tnte. Maximiliano Rodríguez Loaiza',109),(701,'Chaguarpamba',110),(702,'Buenavista',110),(703,'El Rosario',110),(704,'Santa Rufina',110),(705,'Amarillos',110),(706,'Amaluza',111),(707,'Bellavista',111),(708,'Jimbura',111),(709,'Santa Teresita',111),(710,'27 de Abril (Cab. En La Naranja)',111),(711,'El Ingenio',111),(712,'El Airo',111),(713,'Gonzanamá',112),(714,'Changaimina (La Libertad)',112),(715,'Fundochamba',112),(716,'Nambacola',112),(717,'Purunuma (Eguiguren)',112),(718,'Quilanga (La Paz)',112),(719,'Sacapalca',112),(720,'San Antonio de Las Aradas (Cab. En Las Aradas)',112),(721,'General Eloy Alfaro (San Sebastián)',113),(722,'Macará (Manuel Enrique Rengel Suquilanda)',113),(723,'Macará',113),(724,'Larama',113),(725,'La Victoria',113),(726,'Sabiango (La Capilla)',113),(727,'Catacocha',114),(728,'Lourdes',114),(729,'Catacocha',114),(730,'Cangonamá',114),(731,'Guachanamá',114),(732,'La Tingue',114),(733,'Lauro Guerrero',114),(734,'Olmedo (Santa Bárbara)',114),(735,'Orianga',114),(736,'San Antonio',114),(737,'Casanga',114),(738,'Yamana',114),(739,'Alamor',115),(740,'Ciano',115),(741,'El Arenal',115),(742,'El Limo (Mariana de Jesús)',115),(743,'Mercadillo',115),(744,'Vicentino',115),(745,'Saraguro',116),(746,'El Paraíso de Celén',116),(747,'El Tablón',116),(748,'Lluzhapa',116),(749,'Manú',116),(750,'San Antonio de Qumbe (Cumbe)',116),(751,'San Pablo de Tenta',116),(752,'San Sebastián de Yúluc',116),(753,'Selva Alegre',116),(754,'Urdaneta (Paquishapa)',116),(755,'Sumaypamba',116),(756,'Sozoranga',117),(757,'Nueva Fátima',117),(758,'Tacamoros',117),(759,'Zapotillo',118),(760,'Mangahurco (Cazaderos)',118),(761,'Garzareal',118),(762,'Limones',118),(763,'Paletillas',118),(764,'Bolaspamba',118),(765,'Pindal',119),(766,'Chaquinal',119),(767,'12 de Diciembre (Cab.En Achiotes)',119),(768,'Milagros',119),(769,'Quilanga',120),(770,'Fundochamba',120),(771,'San Antonio de Las Aradas (Cab. En Las Aradas)',120),(772,'Olmedo',121),(773,'La Tingue',121),(774,'Clemente Baquerizo',122),(775,'Dr. Camilo Ponce',122),(776,'Barreiro',122),(777,'El Salto',122),(778,'Babahoyo',122),(779,'Barreiro (Santa Rita)',122),(780,'Caracol',122),(781,'Febres Cordero (Las Juntas)',122),(782,'Pimocha',122),(783,'La Unión',122),(784,'Baba',123),(785,'Guare',123),(786,'Isla de Bejucal',123),(787,'Montalvo',124),(788,'Puebloviejo',125),(789,'Puerto Pechiche',125),(790,'San Juan',125),(791,'Quevedo',126),(792,'San Camilo',126),(793,'San José',126),(794,'Guayacán',126),(795,'Nicolás Infante Díaz',126),(796,'San Cristóbal',126),(797,'Siete de Octubre',126),(798,'24 de Mayo',126),(799,'Venus del Río Quevedo',126),(800,'Viva Alfaro',126),(801,'Quevedo',126),(802,'Buena Fé',126),(803,'Mocache',126),(804,'San Carlos',126),(805,'Valencia',126),(806,'La Esperanza',126),(807,'Catarama',127),(808,'Ricaurte',127),(809,'10 de Noviembre',128),(810,'Ventanas',128),(811,'Quinsaloma',128),(812,'Zapotal',128),(813,'Chacarita',128),(814,'Los Ángeles',128),(815,'Vinces',129),(816,'Antonio Sotomayor (Cab. En Playas de Vinces)',129),(817,'Palenque',129),(818,'Palenque',130),(819,'San Jacinto de Buena Fé',131),(820,'7 de Agosto',131),(821,'11 de Octubre',131),(822,'San Jacinto de Buena Fé',131),(823,'Patricia Pilar',131),(824,'Valencia',132),(825,'Mocache',133),(826,'Quinsaloma',134),(827,'Portoviejo',135),(828,'12 de Marzo',135),(829,'Colón',135),(830,'Picoazá',135),(831,'San Pablo',135),(832,'Andrés de Vera',135),(833,'Francisco Pacheco',135),(834,'18 de Octubre',135),(835,'Simón Bolívar',135),(836,'Portoviejo',135),(837,'Abdón Calderón (San Francisco)',135),(838,'Alhajuela (Bajo Grande)',135),(839,'Crucita',135),(840,'Pueblo Nuevo',135),(841,'Riochico (Río Chico)',135),(842,'San Plácido',135),(843,'Chirijos',135),(844,'Calceta',136),(845,'Membrillo',136),(846,'Quiroga',136),(847,'Chone',137),(848,'Santa Rita',137),(849,'Chone',137),(850,'Boyacá',137),(851,'Canuto',137),(852,'Convento',137),(853,'Chibunga',137),(854,'Eloy Alfaro',137),(855,'Ricaurte',137),(856,'San Antonio',137),(857,'El Carmen',138),(858,'4 de Diciembre',138),(859,'El Carmen',138),(860,'Wilfrido Loor Moreira (Maicito)',138),(861,'San Pedro de Suma',138),(862,'Flavio Alfaro',139),(863,'San Francisco de Novillo (Cab. En',139),(864,'Zapallo',139),(865,'Dr. Miguel Morán Lucio',140),(866,'Manuel Inocencio Parrales Y Guale',140),(867,'San Lorenzo de Jipijapa',140),(868,'Jipijapa',140),(869,'América',140),(870,'El Anegado (Cab. En Eloy Alfaro)',140),(871,'Julcuy',140),(872,'La Unión',140),(873,'Machalilla',140),(874,'Membrillal',140),(875,'Pedro Pablo Gómez',140),(876,'Puerto de Cayo',140),(877,'Puerto López',140),(878,'Junín',141),(879,'Los Esteros',142),(880,'Manta',142),(881,'San Mateo',142),(882,'Tarqui',142),(883,'Eloy Alfaro',142),(884,'Manta',142),(885,'San Lorenzo',142),(886,'Santa Marianita (Boca de Pacoche)',142),(887,'Anibal San Andrés',143),(888,'Montecristi',143),(889,'El Colorado',143),(890,'General Eloy Alfaro',143),(891,'Leonidas Proaño',143),(892,'Montecristi',143),(893,'Jaramijó',143),(894,'La Pila',143),(895,'Paján',144),(896,'Campozano (La Palma de Paján)',144),(897,'Cascol',144),(898,'Guale',144),(899,'Lascano',144),(900,'Pichincha',145),(901,'Barraganete',145),(902,'San Sebastián',145),(903,'Rocafuerte',146),(904,'Santa Ana',147),(905,'Lodana',147),(906,'Santa Ana de Vuelta Larga',147),(907,'Ayacucho',147),(908,'Honorato Vásquez (Cab. En Vásquez)',147),(909,'La Unión',147),(910,'Olmedo',147),(911,'San Pablo (Cab. En Pueblo Nuevo)',147),(912,'Bahía de Caráquez',148),(913,'Leonidas Plaza Gutiérrez',148),(914,'Bahía de Caráquez',148),(915,'Canoa',148),(916,'Cojimíes',148),(917,'Charapotó',148),(918,'10 de Agosto',148),(919,'Jama',148),(920,'Pedernales',148),(921,'San Isidro',148),(922,'San Vicente',148),(923,'Tosagua',149),(924,'Bachillero',149),(925,'Angel Pedro Giler (La Estancilla)',149),(926,'Sucre',150),(927,'Bellavista',150),(928,'Noboa',150),(929,'Arq. Sixto Durán Ballén',150),(930,'Pedernales',151),(931,'Cojimíes',151),(932,'10 de Agosto',151),(933,'Atahualpa',151),(934,'Olmedo',152),(935,'Puerto López',153),(936,'Machalilla',153),(937,'Salango',153),(938,'Jama',154),(939,'Jaramijó',155),(940,'San Vicente',156),(941,'Canoa',156),(942,'Macas',157),(943,'Alshi (Cab. En 9 de Octubre)',157),(944,'Chiguaza',157),(945,'General Proaño',157),(946,'Huasaga (Cab.En Wampuik)',157),(947,'Macuma',157),(948,'San Isidro',157),(949,'Sevilla Don Bosco',157),(950,'Sinaí',157),(951,'Taisha',157),(952,'Zuña (Zúñac)',157),(953,'Tuutinentza',157),(954,'Cuchaentza',157),(955,'San José de Morona',157),(956,'Río Blanco',157),(957,'Gualaquiza',158),(958,'Mercedes Molina',158),(959,'Gualaquiza',158),(960,'Amazonas (Rosario de Cuyes)',158),(961,'Bermejos',158),(962,'Bomboiza',158),(963,'Chigüinda',158),(964,'El Rosario',158),(965,'Nueva Tarqui',158),(966,'San Miguel de Cuyes',158),(967,'El Ideal',158),(968,'General Leonidas Plaza Gutiérrez (Limón)',159),(969,'Indanza',159),(970,'Pan de Azúcar',159),(971,'San Antonio (Cab. En San Antonio Centro',159),(972,'San Carlos de Limón (San Carlos del',159),(973,'San Juan Bosco',159),(974,'San Miguel de Conchay',159),(975,'Santa Susana de Chiviaza (Cab. En Chiviaza)',159),(976,'Yunganza (Cab. En El Rosario)',159),(977,'Palora (Metzera)',160),(978,'Arapicos',160),(979,'Cumandá (Cab. En Colonia Agrícola Sevilla del Oro)',160),(980,'Huamboya',160),(981,'Sangay (Cab. En Nayamanaca)',160),(982,'Santiago de Méndez',161),(983,'Copal',161),(984,'Chupianza',161),(985,'Patuca',161),(986,'San Luis de El Acho (Cab. En El Acho)',161),(987,'Santiago',161),(988,'Tayuza',161),(989,'San Francisco de Chinimbimi',161),(990,'Sucúa',162),(991,'Asunción',162),(992,'Huambi',162),(993,'Logroño',162),(994,'Yaupi',162),(995,'Santa Marianita de Jesús',162),(996,'Huamboya',163),(997,'Chiguaza',163),(998,'Pablo Sexto',163),(999,'San Juan Bosco',164),(1000,'Pan de Azúcar',164),(1001,'San Carlos de Limón',164),(1002,'San Jacinto de Wakambeis',164),(1003,'Santiago de Pananza',164),(1004,'Taisha',165),(1005,'Huasaga (Cab. En Wampuik)',165),(1006,'Macuma',165),(1007,'Tuutinentza',165),(1008,'Pumpuentsa',165),(1009,'Logroño',166),(1010,'Yaupi',166),(1011,'Shimpis',166),(1012,'Pablo Sexto',167),(1013,'Santiago',168),(1014,'San José de Morona',168),(1015,'Tena',169),(1016,'Ahuano',169),(1017,'Carlos Julio Arosemena Tola (Zatza-Yacu)',169),(1018,'Chontapunta',169),(1019,'Pano',169),(1020,'Puerto Misahualli',169),(1021,'Puerto Napo',169),(1022,'Tálag',169),(1023,'San Juan de Muyuna',169),(1024,'Archidona',170),(1025,'Avila',170),(1026,'Cotundo',170),(1027,'Loreto',170),(1028,'San Pablo de Ushpayacu',170),(1029,'Puerto Murialdo',170),(1030,'El Chaco',171),(1031,'Gonzalo Díaz de Pineda (El Bombón)',171),(1032,'Linares',171),(1033,'Oyacachi',171),(1034,'Santa Rosa',171),(1035,'Sardinas',171),(1036,'Baeza',172),(1037,'Cosanga',172),(1038,'Cuyuja',172),(1039,'Papallacta',172),(1040,'San Francisco de Borja (Virgilio Dávila)',172),(1041,'San José del Payamino',172),(1042,'Sumaco',172),(1043,'Carlos Julio Arosemena Tola',173),(1044,'Puyo',174),(1045,'Arajuno',174),(1046,'Canelos',174),(1047,'Curaray',174),(1048,'Diez de Agosto',174),(1049,'Fátima',174),(1050,'Montalvo (Andoas)',174),(1051,'Pomona',174),(1052,'Río Corrientes',174),(1053,'Río Tigre',174),(1054,'Santa Clara',174),(1055,'Sarayacu',174),(1056,'Simón Bolívar (Cab. En Mushullacta)',174),(1057,'Tarqui',174),(1058,'Teniente Hugo Ortiz',174),(1059,'Veracruz (Indillama) (Cab. En Indillama)',174),(1060,'El Triunfo',174),(1061,'Mera',175),(1062,'Madre Tierra',175),(1063,'Shell',175),(1064,'Santa Clara',176),(1065,'San José',176),(1066,'Arajuno',177),(1067,'Curaray',177),(1068,'Belisario Quevedo',178),(1069,'Carcelén',178),(1070,'Centro Histórico',178),(1071,'Cochapamba',178),(1072,'Comité del Pueblo',178),(1073,'Cotocollao',178),(1074,'Chilibulo',178),(1075,'Chillogallo',178),(1076,'Chimbacalle',178),(1077,'El Condado',178),(1078,'Guamaní',178),(1079,'Iñaquito',178),(1080,'Itchimbía',178),(1081,'Jipijapa',178),(1082,'Kennedy',178),(1083,'La Argelia',178),(1084,'La Concepción',178),(1085,'La Ecuatoriana',178),(1086,'La Ferroviaria',178),(1087,'La Libertad',178),(1088,'La Magdalena',178),(1089,'La Mena',178),(1090,'Mariscal Sucre',178),(1091,'Ponceano',178),(1092,'Puengasí',178),(1093,'Quitumbe',178),(1094,'Rumipamba',178),(1095,'San Bartolo',178),(1096,'San Isidro del Inca',178),(1097,'San Juan',178),(1098,'Solanda',178),(1099,'Turubamba',178),(1100,'Quito Distrito Metropolitano',178),(1101,'Alangasí',178),(1102,'Amaguaña',178),(1103,'Atahualpa',178),(1104,'Calacalí',178),(1105,'Calderón',178),(1106,'Conocoto',178),(1107,'Cumbayá',178),(1108,'Chavezpamba',178),(1109,'Checa',178),(1110,'El Quinche',178),(1111,'Gualea',178),(1112,'Guangopolo',178),(1113,'Guayllabamba',178),(1114,'La Merced',178),(1115,'Llano Chico',178),(1116,'Lloa',178),(1117,'Mindo',178),(1118,'Nanegal',178),(1119,'Nanegalito',178),(1120,'Nayón',178),(1121,'Nono',178),(1122,'Pacto',178),(1123,'Pedro Vicente Maldonado',178),(1124,'Perucho',178),(1125,'Pifo',178),(1126,'Píntag',178),(1127,'Pomasqui',178),(1128,'Puéllaro',178),(1129,'Puembo',178),(1130,'San Antonio',178),(1131,'San José de Minas',178),(1132,'San Miguel de Los Bancos',178),(1133,'Tababela',178),(1134,'Tumbaco',178),(1135,'Yaruquí',178),(1136,'Zambiza',178),(1137,'Puerto Quito',178),(1138,'Ayora',179),(1139,'Cayambe',179),(1140,'Juan Montalvo',179),(1141,'Cayambe',179),(1142,'Ascázubi',179),(1143,'Cangahua',179),(1144,'Olmedo (Pesillo)',179),(1145,'Otón',179),(1146,'Santa Rosa de Cuzubamba',179),(1147,'Machachi',180),(1148,'Alóag',180),(1149,'Aloasí',180),(1150,'Cutuglahua',180),(1151,'El Chaupi',180),(1152,'Manuel Cornejo Astorga (Tandapi)',180),(1153,'Tambillo',180),(1154,'Uyumbicho',180),(1155,'Tabacundo',181),(1156,'La Esperanza',181),(1157,'Malchinguí',181),(1158,'Tocachi',181),(1159,'Tupigachi',181),(1160,'Sangolquí',182),(1161,'San Pedro de Taboada',182),(1162,'San Rafael',182),(1163,'Sangolqui',182),(1164,'Cotogchoa',182),(1165,'Rumipamba',182),(1166,'San Miguel de Los Bancos',183),(1167,'Mindo',183),(1168,'Pedro Vicente Maldonado',183),(1169,'Puerto Quito',183),(1170,'Pedro Vicente Maldonado',184),(1171,'Puerto Quito',185),(1172,'Atocha – Ficoa',186),(1173,'Celiano Monge',186),(1174,'Huachi Chico',186),(1175,'Huachi Loreto',186),(1176,'La Merced',186),(1177,'La Península',186),(1178,'Matriz',186),(1179,'Pishilata',186),(1180,'San Francisco',186),(1181,'Ambato',186),(1182,'Ambatillo',186),(1183,'Atahualpa (Chisalata)',186),(1184,'Augusto N. Martínez (Mundugleo)',186),(1185,'Constantino Fernández (Cab. En Cullitahua)',186),(1186,'Huachi Grande',186),(1187,'Izamba',186),(1188,'Juan Benigno Vela',186),(1189,'Montalvo',186),(1190,'Pasa',186),(1191,'Picaigua',186),(1192,'Pilagüín (Pilahüín)',186),(1193,'Quisapincha (Quizapincha)',186),(1194,'San Bartolomé de Pinllog',186),(1195,'San Fernando (Pasa San Fernando)',186),(1196,'Santa Rosa',186),(1197,'Totoras',186),(1198,'Cunchibamba',186),(1199,'Unamuncho',186),(1200,'Baños de Agua Santa',187),(1201,'Lligua',187),(1202,'Río Negro',187),(1203,'Río Verde',187),(1204,'Ulba',187),(1205,'Cevallos',188),(1206,'Mocha',189),(1207,'Pinguilí',189),(1208,'Patate',190),(1209,'El Triunfo',190),(1210,'Los Andes (Cab. En Poatug)',190),(1211,'Sucre (Cab. En Sucre-Patate Urcu)',190),(1212,'Quero',191),(1213,'Rumipamba',191),(1214,'Yanayacu - Mochapata (Cab. En Yanayacu)',191),(1215,'Pelileo',192),(1216,'Pelileo Grande',192),(1217,'Pelileo',192),(1218,'Benítez (Pachanlica)',192),(1219,'Bolívar',192),(1220,'Cotaló',192),(1221,'Chiquicha (Cab. En Chiquicha Grande)',192),(1222,'El Rosario (Rumichaca)',192),(1223,'García Moreno (Chumaqui)',192),(1224,'Guambaló (Huambaló)',192),(1225,'Salasaca',192),(1226,'Ciudad Nueva',193),(1227,'Píllaro',193),(1228,'Píllaro',193),(1229,'Baquerizo Moreno',193),(1230,'Emilio María Terán (Rumipamba)',193),(1231,'Marcos Espinel (Chacata)',193),(1232,'Presidente Urbina (Chagrapamba -Patzucul)',193),(1233,'San Andrés',193),(1234,'San José de Poaló',193),(1235,'San Miguelito',193),(1236,'Tisaleo',194),(1237,'Quinchicoto',194),(1238,'El Limón',195),(1239,'Zamora',195),(1240,'Zamora',195),(1241,'Cumbaratza',195),(1242,'Guadalupe',195),(1243,'Imbana (La Victoria de Imbana)',195),(1244,'Paquisha',195),(1245,'Sabanilla',195),(1246,'Timbara',195),(1247,'Zumbi',195),(1248,'San Carlos de Las Minas',195),(1249,'Zumba',196),(1250,'Chito',196),(1251,'El Chorro',196),(1252,'El Porvenir del Carmen',196),(1253,'La Chonta',196),(1254,'Palanda',196),(1255,'Pucapamba',196),(1256,'San Francisco del Vergel',196),(1257,'Valladolid',196),(1258,'San Andrés',196),(1259,'Guayzimi',197),(1260,'Zurmi',197),(1261,'Nuevo Paraíso',197),(1262,'28 de Mayo (San José de Yacuambi)',198),(1263,'La Paz',198),(1264,'Tutupali',198),(1265,'Yantzaza (Yanzatza)',199),(1266,'Chicaña',199),(1267,'El Pangui',199),(1268,'Los Encuentros',199),(1269,'El Pangui',200),(1270,'El Guisme',200),(1271,'Pachicutza',200),(1272,'Tundayme',200),(1273,'Zumbi',201),(1274,'Paquisha',201),(1275,'Triunfo-Dorado',201),(1276,'Panguintza',201),(1277,'Palanda',202),(1278,'El Porvenir del Carmen',202),(1279,'San Francisco del Vergel',202),(1280,'Valladolid',202),(1281,'La Canela',202),(1282,'Paquisha',203),(1283,'Bellavista',203),(1284,'Nuevo Quito',203),(1285,'Puerto Baquerizo Moreno',204),(1286,'El Progreso',204),(1287,'Isla Santa María (Floreana) (Cab. En Pto. Velasco Ibarra)',204),(1288,'Puerto Villamil',205),(1289,'Tomás de Berlanga (Santo Tomás)',205),(1290,'Puerto Ayora',206),(1291,'Bellavista',206),(1292,'Santa Rosa (Incluye La Isla Baltra)',206),(1293,'Nueva Loja',207),(1294,'Cuyabeno',207),(1295,'Dureno',207),(1296,'General Farfán',207),(1297,'Tarapoa',207),(1298,'El Eno',207),(1299,'Pacayacu',207),(1300,'Jambelí',207),(1301,'Santa Cecilia',207),(1302,'Aguas Negras',207),(1303,'El Dorado de Cascales',208),(1304,'El Reventador',208),(1305,'Gonzalo Pizarro',208),(1306,'Lumbaquí',208),(1307,'Puerto Libre',208),(1308,'Santa Rosa de Sucumbíos',208),(1309,'Puerto El Carmen del Putumayo',209),(1310,'Palma Roja',209),(1311,'Puerto Bolívar (Puerto Montúfar)',209),(1312,'Puerto Rodríguez',209),(1313,'Santa Elena',209),(1314,'Shushufindi',210),(1315,'Limoncocha',210),(1316,'Pañacocha',210),(1317,'San Roque (Cab. En San Vicente)',210),(1318,'San Pedro de Los Cofanes',210),(1319,'Siete de Julio',210),(1320,'La Bonita',211),(1321,'El Playón de San Francisco',211),(1322,'La Sofía',211),(1323,'Rosa Florida',211),(1324,'Santa Bárbara',211),(1325,'El Dorado de Cascales',212),(1326,'Santa Rosa de Sucumbíos',212),(1327,'Sevilla',212),(1328,'Tarapoa',213),(1329,'Cuyabeno',213),(1330,'Aguas Negras',213),(1331,'Puerto Francisco de Orellana (El Coca)',214),(1332,'Dayuma',214),(1333,'Taracoa (Nueva Esperanza: Yuca)',214),(1334,'Alejandro Labaka',214),(1335,'El Dorado',214),(1336,'El Edén',214),(1337,'García Moreno',214),(1338,'Inés Arango (Cab. En Western)',214),(1339,'La Belleza',214),(1340,'Nuevo Paraíso (Cab. En Unión',214),(1341,'San José de Guayusa',214),(1342,'San Luis de Armenia',214),(1343,'Tipitini',215),(1344,'Nuevo Rocafuerte',215),(1345,'Capitán Augusto Rivadeneyra',215),(1346,'Cononaco',215),(1347,'Santa María de Huiririma',215),(1348,'Tiputini',215),(1349,'Yasuní',215),(1350,'La Joya de Los Sachas',216),(1351,'Enokanqui',216),(1352,'Pompeya',216),(1353,'San Carlos',216),(1354,'San Sebastián del Coca',216),(1355,'Lago San Pedro',216),(1356,'Rumipamba',216),(1357,'Tres de Noviembre',216),(1358,'Unión Milagreña',216),(1359,'Loreto',217),(1360,'Avila (Cab. En Huiruno)',217),(1361,'Puerto Murialdo',217),(1362,'San José de Payamino',217),(1363,'San José de Dahuano',217),(1364,'San Vicente de Huaticocha',217),(1365,'Abraham Calazacón',218),(1366,'Bombolí',218),(1367,'Chiguilpe',218),(1368,'Río Toachi',218),(1369,'Río Verde',218),(1370,'Santo Domingo de Los Colorados',218),(1371,'Zaracay',218),(1372,'Santo Domingo de Los Colorados',218),(1373,'Alluriquín',218),(1374,'Puerto Limón',218),(1375,'Luz de América',218),(1376,'San Jacinto del Búa',218),(1377,'Valle Hermoso',218),(1378,'El Esfuerzo',218),(1379,'Santa María del Toachi',218),(1380,'Ballenita',219),(1381,'Santa Elena',219),(1382,'Santa Elena',219),(1383,'Atahualpa',219),(1384,'Colonche',219),(1385,'Chanduy',219),(1386,'Manglaralto',219),(1387,'Simón Bolívar (Julio Moreno)',219),(1388,'San José de Ancón',219),(1389,'La Libertad',220),(1390,'Carlos Espinoza Larrea',221),(1391,'Gral. Alberto Enríquez Gallo',221),(1392,'Vicente Rocafuerte',221),(1393,'Santa Rosa',221),(1394,'Salinas',221),(1395,'Anconcito',221),(1396,'José Luis Tamayo (Muey)',221),(1397,'Las Golondrinas',222),(1398,'Manga del Cura',222),(1399,'El Piedrero',222);
/*!40000 ALTER TABLE `parroquias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantesaprobados`
--

DROP TABLE IF EXISTS `participantesaprobados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantesaprobados` (
  `id_participantes_aprobados` int NOT NULL AUTO_INCREMENT,
  `codigo_senecyt` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `id_participante_matriculado` int DEFAULT NULL,
  PRIMARY KEY (`id_participantes_aprobados`),
  KEY `FKl26xjgo5n68w7ejk5r15khxm3` (`id_participante_matriculado`),
  CONSTRAINT `FKl26xjgo5n68w7ejk5r15khxm3` FOREIGN KEY (`id_participante_matriculado`) REFERENCES `partipantesmatriculados` (`id_participante_matriculado`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantesaprobados`
--

LOCK TABLES `participantesaprobados` WRITE;
/*!40000 ALTER TABLE `participantesaprobados` DISABLE KEYS */;
/*!40000 ALTER TABLE `participantesaprobados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partipantesmatriculados`
--

DROP TABLE IF EXISTS `partipantesmatriculados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partipantesmatriculados` (
  `id_participante_matriculado` int NOT NULL AUTO_INCREMENT,
  `estado_participante_activo` tinyint(1) DEFAULT NULL,
  `estado_participante_aprobacion` varchar(255) DEFAULT NULL,
  `id_inscrito` int DEFAULT NULL,
  PRIMARY KEY (`id_participante_matriculado`),
  KEY `FKb82f3ovv5wg0txs37rswwwkbm` (`id_inscrito`),
  CONSTRAINT `FKb82f3ovv5wg0txs37rswwwkbm` FOREIGN KEY (`id_inscrito`) REFERENCES `inscritos` (`id_inscrito`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partipantesmatriculados`
--

LOCK TABLES `partipantesmatriculados` WRITE;
/*!40000 ALTER TABLE `partipantesmatriculados` DISABLE KEYS */;
INSERT INTO `partipantesmatriculados` VALUES (1,1,'A',1),(2,1,'A',2);
/*!40000 ALTER TABLE `partipantesmatriculados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodos_programas`
--

DROP TABLE IF EXISTS `periodos_programas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodos_programas` (
  `id_periodo_programa` int NOT NULL AUTO_INCREMENT,
  `estado_periodo_programa` tinyint(1) DEFAULT NULL,
  `nombre_periodo_programa` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_periodo_programa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodos_programas`
--

LOCK TABLES `periodos_programas` WRITE;
/*!40000 ALTER TABLE `periodos_programas` DISABLE KEYS */;
INSERT INTO `periodos_programas` VALUES (1,1,'OCTUBRE'),(2,1,'OCTUBRE');
/*!40000 ALTER TABLE `periodos_programas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `etnia` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `nivel_instruccion` varchar(255) DEFAULT NULL,
  `nombre1` varchar(255) DEFAULT NULL,
  `nombre2` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'','','','correo','','Mestizo',NULL,'M','','Superior','','',''),(2,'JADAN','MONTERO','0969601297','diego@gmail.com','HERMANO MIGUEL Y RAFALE MARIA ','Indigena','1982-06-01','M','0103563805','Secundaria','ANDRÉS','SANTIAGO','4024869'),(3,'GALLEGOS','TIMBE','0989161999','jonnathan.gallegos.est@tecazuay.edu.ec','TARQUI','Mestizo','2002-12-23','M','0150571925','Primaria','JONNATHAN','BERNABE','072320278'),(4,NULL,NULL,NULL,'pedro.cabrera.est@tecazuay.edu.ec',NULL,NULL,NULL,NULL,'0107254831',NULL,NULL,NULL,NULL),(5,'ZHIZHIN','VILLA','0983866813','diana.zhizhin.est@tecazuay.edu.ec','PACCHA','Mestizo','2002-11-18','M','0150089159','Superior','DIANA','ISABEL','074151359');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prerequisitos_cursos`
--

DROP TABLE IF EXISTS `prerequisitos_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prerequisitos_cursos` (
  `id_prerequisito_curso` int NOT NULL AUTO_INCREMENT,
  `estado_prerequisito_curso` tinyint(1) DEFAULT NULL,
  `nombre_prerequisito_curso` varchar(1300) DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_prerequisito_curso`),
  KEY `FKatm1q02ep6xyyhfuidyw8avl6` (`id_curso`),
  CONSTRAINT `FKatm1q02ep6xyyhfuidyw8avl6` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prerequisitos_cursos`
--

LOCK TABLES `prerequisitos_cursos` WRITE;
/*!40000 ALTER TABLE `prerequisitos_cursos` DISABLE KEYS */;
INSERT INTO `prerequisitos_cursos` VALUES (1,1,'Computador',1),(2,1,'Conocimientos de Google Analytic',1),(3,1,'Sistemas operativos',2);
/*!40000 ALTER TABLE `prerequisitos_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programas`
--

DROP TABLE IF EXISTS `programas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programas` (
  `id_programa` int NOT NULL AUTO_INCREMENT,
  `descripcion_programa` varchar(1200) DEFAULT NULL,
  `estado_programa_activo` tinyint(1) DEFAULT NULL,
  `nombre_programa` varchar(500) DEFAULT NULL,
  `id_periodo_programa` int DEFAULT NULL,
  PRIMARY KEY (`id_programa`),
  KEY `FK2vsw7tye36x128u5h4oh9022f` (`id_periodo_programa`),
  CONSTRAINT `FK2vsw7tye36x128u5h4oh9022f` FOREIGN KEY (`id_periodo_programa`) REFERENCES `periodos_programas` (`id_periodo_programa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programas`
--

LOCK TABLES `programas` WRITE;
/*!40000 ALTER TABLE `programas` DISABLE KEYS */;
INSERT INTO `programas` VALUES (1,'!Nuevos cursos totalmente gratuitos!',1,'FORMACIÓN CONTINUA',1),(2,'Cursos enfocados en las tecnologías y tendencias.',1,'TICS',2);
/*!40000 ALTER TABLE `programas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincias` (
  `id_provincia` int NOT NULL AUTO_INCREMENT,
  `provincia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Azuay'),(2,'Bolívar'),(3,'Cañar'),(4,'Carchi'),(5,'Cotopaxi'),(6,'Chimborazo'),(7,'El Oro'),(8,'Esmeraldas'),(9,'Guayas'),(10,'Imbabura'),(11,'Loja'),(12,'Los Rios'),(13,'Manabí'),(14,'Morona Santiago'),(15,'Napo'),(16,'Pastaza'),(17,'Pichincha'),(18,'Tungurahua'),(19,'Zamora Chinchipe'),(20,'Galápagos'),(21,'Sucumbíos'),(22,'Orellana'),(23,'Santo Domingo de Los Tsáchilas'),(24,'Santa Elena'),(25,'Zonas No Delimitadas');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursos`
--

DROP TABLE IF EXISTS `recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recursos` (
  `idRecurso` int NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `nombreRecurso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idRecurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursos`
--

LOCK TABLES `recursos` WRITE;
/*!40000 ALTER TABLE `recursos` DISABLE KEYS */;
INSERT INTO `recursos` VALUES (1,_binary '','Equipos'),(2,_binary '','Materiales, insumos y recursos didácticos'),(3,_binary '','Recursos didácticos y de consumo'),(4,_binary '','Máquinas, equipos y herramientas ');
/*!40000 ALTER TABLE `recursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrofotograficocursos`
--

DROP TABLE IF EXISTS `registrofotograficocursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrofotograficocursos` (
  `id_registro_fotografico_curso` int NOT NULL AUTO_INCREMENT,
  `descripcion_foto` varchar(255) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `foto` varchar(300) DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_registro_fotografico_curso`),
  KEY `FKgk0pdpruracx8aqbu9sm7g26c` (`id_curso`),
  CONSTRAINT `FKgk0pdpruracx8aqbu9sm7g26c` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrofotograficocursos`
--

LOCK TABLES `registrofotograficocursos` WRITE;
/*!40000 ALTER TABLE `registrofotograficocursos` DISABLE KEYS */;
INSERT INTO `registrofotograficocursos` VALUES (1,'hola como estas espero ue estes de acuerd con o que podamos estar de la forma mas adecuada hola como estas espero ue estes de acuerd con o que podamos estar de la forma mas adecuada n/a\n\n',1,'2023-10-08','af408cc9-615b-4e77-a78f-35a408433d3e_Feel.jpg',1);
/*!40000 ALTER TABLE `registrofotograficocursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado_aprendizaje_silabo`
--

DROP TABLE IF EXISTS `resultado_aprendizaje_silabo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado_aprendizaje_silabo` (
  `id_resultado_aprendizaje_silabo` int NOT NULL AUTO_INCREMENT,
  `activades_resultado_aprendizaje` varchar(1500) DEFAULT NULL,
  `descripcion_unidad_silabo` varchar(1500) DEFAULT NULL,
  `elementos_competencia_silabo` varchar(1500) DEFAULT NULL,
  `estado_unidad_activo` tinyint(1) DEFAULT NULL,
  `forma_evidenciar` varchar(1500) DEFAULT NULL,
  `tema_unidad_silabo` varchar(1000) DEFAULT NULL,
  `id_silabo` int DEFAULT NULL,
  PRIMARY KEY (`id_resultado_aprendizaje_silabo`),
  KEY `FK8r6jubqd4sgx2mlsqxiynql69` (`id_silabo`),
  CONSTRAINT `FK8r6jubqd4sgx2mlsqxiynql69` FOREIGN KEY (`id_silabo`) REFERENCES `silabos` (`id_silabo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado_aprendizaje_silabo`
--

LOCK TABLES `resultado_aprendizaje_silabo` WRITE;
/*!40000 ALTER TABLE `resultado_aprendizaje_silabo` DISABLE KEYS */;
INSERT INTO `resultado_aprendizaje_silabo` VALUES (1,'Manejo y aplicación de google analytics',NULL,'Google',1,'Prueba técnica','Unidad 1',1),(2,'asdfa','asdfasdf','asdfasdf',1,'asdfasdf','afsdfasdf',2);
/*!40000 ALTER TABLE `resultado_aprendizaje_silabo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `estado_rol_activo` bit(1) DEFAULT NULL,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,_binary '','Administrador'),(2,_binary '','DocenteCapacitador'),(3,_binary '','Participante');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `silabos`
--

DROP TABLE IF EXISTS `silabos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `silabos` (
  `id_silabo` int NOT NULL AUTO_INCREMENT,
  `bibliografia` varchar(1800) DEFAULT NULL,
  `campo_aprovado_por` varchar(1000) DEFAULT NULL,
  `campo_formacion` varchar(1000) DEFAULT NULL,
  `campo_revisado_por` varchar(1000) DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  PRIMARY KEY (`id_silabo`),
  KEY `FK76k1gu9jnddt9trs8i1snvdfs` (`id_curso`),
  CONSTRAINT `FK76k1gu9jnddt9trs8i1snvdfs` FOREIGN KEY (`id_curso`) REFERENCES `cursos` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `silabos`
--

LOCK TABLES `silabos` WRITE;
/*!40000 ALTER TABLE `silabos` DISABLE KEYS */;
INSERT INTO `silabos` VALUES (1,'https://analytics.google.com/analytics/academy/course/6?hl=es','Ing. Yamile Rodriguez','Google Analytics','Ing. Yamile Rodriguez',1),(2,'https://www.google.com/search?q=tics&oq=tics&gs_lcrp=EgZjaHJvbWUyDwgAEEUYORiDARixAxiABDINCAEQABiDARixAxiABDIHCAIQABiABDIHCAMQABiABDIHCAQQABiABDIHCAUQABiABDIHCAYQABiABDIHCAcQABiABDIHCAgQABiABDIHCAkQABiABNIBBzc0M2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8','Lcda. Yamila Rdriguez','n/a','Lcda. Yamila Rdriguez',2);
/*!40000 ALTER TABLE `silabos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_cursos`
--

DROP TABLE IF EXISTS `tipos_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_cursos` (
  `id_tipo_curso` int NOT NULL AUTO_INCREMENT,
  `estado_tipo_curso` tinyint(1) DEFAULT NULL,
  `nombre_tipo_curso` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_cursos`
--

LOCK TABLES `tipos_cursos` WRITE;
/*!40000 ALTER TABLE `tipos_cursos` DISABLE KEYS */;
INSERT INTO `tipos_cursos` VALUES (1,1,'Administrativo'),(2,1,'Técnico');
/*!40000 ALTER TABLE `tipos_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `id_usuario` int NOT NULL,
  `id_rol` int NOT NULL,
  UNIQUE KEY `UK6efclpjh81p9rtuern8wwde2f` (`id_usuario`,`id_rol`),
  KEY `FKaulyi2lejh5cckb2y8e2mlpud` (`id_rol`),
  CONSTRAINT `FKaulyi2lejh5cckb2y8e2mlpud` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
  CONSTRAINT `FKnyxx7rovkcx58fwx645h5pfdu` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,2),(3,3),(4,3),(5,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `estado_usuario_activo` tinyint(1) DEFAULT NULL,
  `foto_perfil` varchar(300) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token_password` varchar(1800) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id_persona` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKtmank41bd4off23q2o9dx13y9` (`id_persona`),
  CONSTRAINT `FKtmank41bd4off23q2o9dx13y9` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1,'4bce1942-ba13-4569-9326-4eb87f663aed_userDefault.png','$2a$12$0nN4Yv2NxlC9SAa20Kt3fenrvDRjqCLcVt7SrOgU8CfR7A1NCpOLu','','ADMIN',1),(2,1,'a3b23b8d-2587-4358-9f6e-d56c642383cb_Feel.jpg','$2a$12$N10rV6FRxa9X.UeMk7sA2.RKH1QQN2v7QJT6VhcE2vBvlIo.izFsK',NULL,'andres',2),(3,1,'43b2dbbd-d9ff-4d9d-9bd6-ca2636626a92_cerrar-sesion.png','$2a$10$87ximqro.Es5muMcYjW90OzGRoQ699yf8QMmgfRgd0aB7P1Xau0dK',NULL,'gallegos0127',3),(4,1,NULL,'$2a$10$KN8eSUIOZg32NpaP/vNO1O/ygwXCrr/PHus2WAvMK3WbT0/GXJhcG',NULL,'pedro222',4),(5,1,NULL,'$2a$12$4cxdj58pI2gBq5bHNVT58eMVoxLxKSTnVo0QBTGJhzTe.SQDjPVwK',NULL,'diana123',5);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_cap'
--

--
-- Dumping routines for database 'bd_cap'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-17 20:18:42
