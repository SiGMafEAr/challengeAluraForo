CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correoElectronico` varchar(300) NOT NULL,
  `contrasena` varchar(300) NOT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  UNIQUE KEY `correoElectronico` (`correoElectronico`)
)