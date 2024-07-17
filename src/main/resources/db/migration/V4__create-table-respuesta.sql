CREATE TABLE IF NOT EXISTS `respuesta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(300) NOT NULL,
  `topico` bigint(20) NOT NULL,
  `fechaCreacion` varchar(100) NOT NULL,
  `usuario` bigint(20) NOT NULL,
  `solucion` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_respuesta_topico` (`topico`),
  KEY `FK_respuesta_usuario` (`usuario`),
  CONSTRAINT `FK_respuesta_topico` FOREIGN KEY (`topico`) REFERENCES `topico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_respuesta_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)