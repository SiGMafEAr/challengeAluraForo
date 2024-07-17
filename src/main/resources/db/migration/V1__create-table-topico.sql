CREATE TABLE IF NOT EXISTS `topico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `mensaje` varchar(300) NOT NULL,
  `fechaCreacion` varchar(100) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `usuario` bigint(20) NOT NULL,
  `curso` bigint(20) NOT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_topico_usuario` (`usuario`),
  KEY `FK_topico_curso` (`curso`),
  CONSTRAINT `FK_topico_curso` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)