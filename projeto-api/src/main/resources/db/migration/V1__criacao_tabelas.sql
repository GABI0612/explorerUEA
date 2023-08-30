-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando estrutura para tabela sa.atividade
CREATE TABLE IF NOT EXISTS `atividade` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `codigo_categoria` bigint(20) NOT NULL,
  `codigo_publicacao` bigint(20) DEFAULT NULL,
  `codigo_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKprnrubvtcxh8yqxmpxbaxf3oi` (`codigo_categoria`),
  KEY `FKa9bo7ck60bdjgfkd3ptvvxa8f` (`codigo_publicacao`),
  KEY `FKq3q2xhnksn6mq0im256lst68u` (`codigo_usuario`),
  CONSTRAINT `FKa9bo7ck60bdjgfkd3ptvvxa8f` FOREIGN KEY (`codigo_publicacao`) REFERENCES `publicacao` (`codigo`),
  CONSTRAINT `FKprnrubvtcxh8yqxmpxbaxf3oi` FOREIGN KEY (`codigo_categoria`) REFERENCES `categoria` (`codigo`),
  CONSTRAINT `FKq3q2xhnksn6mq0im256lst68u` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.colagem_tematica
CREATE TABLE IF NOT EXISTS `colagem_tematica` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ordemft` bigint(20) DEFAULT NULL,
  `codigo_foto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKaf7fj3ydkgbt9grqs9x5pe5yt` (`codigo_foto`),
  CONSTRAINT `FKaf7fj3ydkgbt9grqs9x5pe5yt` FOREIGN KEY (`codigo_foto`) REFERENCES `foto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `codigo_atividade` bigint(20) DEFAULT NULL,
  `codigo_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKt7ggix9srb1j1rqsinltc3aeo` (`codigo_atividade`),
  KEY `FKjge4xhdmml20j8qiia5wb2p59` (`codigo_usuario`),
  CONSTRAINT `FKjge4xhdmml20j8qiia5wb2p59` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`),
  CONSTRAINT `FKt7ggix9srb1j1rqsinltc3aeo` FOREIGN KEY (`codigo_atividade`) REFERENCES `atividade` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.foto
CREATE TABLE IF NOT EXISTS `foto` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.permissao
CREATE TABLE IF NOT EXISTS `permissao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.publicacao
CREATE TABLE IF NOT EXISTS `publicacao` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `codigo_foto` bigint(20) DEFAULT NULL,
  `codigo_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKt597ffcflrq4to3rt8pghrbu8` (`codigo_foto`),
  KEY `FKekivk4b8o3srrvqyo9piwn9da` (`codigo_usuario`),
  CONSTRAINT `FKekivk4b8o3srrvqyo9piwn9da` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`),
  CONSTRAINT `FKt597ffcflrq4to3rt8pghrbu8` FOREIGN KEY (`codigo_foto`) REFERENCES `foto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `matricula` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sa.usuario_permissao
CREATE TABLE IF NOT EXISTS `usuario_permissao` (
  `codigo_usuario` bigint(20) NOT NULL,
  `codigo_permissao` int(11) NOT NULL,
  PRIMARY KEY (`codigo_usuario`,`codigo_permissao`),
  KEY `FK5tjrvuwlx1yp72mrf8t8vj93e` (`codigo_permissao`),
  CONSTRAINT `FK5tjrvuwlx1yp72mrf8t8vj93e` FOREIGN KEY (`codigo_permissao`) REFERENCES `permissao` (`codigo`),
  CONSTRAINT `FKeogfr4akeqn19xr3wmyx0n8bo` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
