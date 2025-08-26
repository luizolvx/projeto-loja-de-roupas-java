-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lojaroupa
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Jaquetas e Casacos'),(2,'Meias'),(3,'Agasalhos'),(4,'Camisas'),(5,'Camisetas'),(6,'Saias'),(7,'Vestidos'),(8,'Calças'),(9,'Shorts'),(10,'Lingerie'),(11,'Moda Praia'),(12,'Acessórios de Vestuário'),(14,'Moda Íntima'),(15,'Roupas de Banho'),(16,'Moda Íntima');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telefone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `endereco` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cep` varchar(9) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Ana Paula Souza','444.444.444-44','ana.souza@email.com','(11)91234-5678','Rua D, 101','04000-000'),(2,'Carlos Lima','555.555.555-55','carlos.lima@email.com','(11)92345-6789','Av. E, 202','05000-000');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `idEstoque` int NOT NULL AUTO_INCREMENT,
  `idProduto` int DEFAULT NULL,
  `dtEntrada` date DEFAULT NULL COMMENT 'YYYY/MM/DD',
  `quantidade` int DEFAULT '0',
  `nfCompra` text COLLATE utf8mb4_unicode_ci,
  `precoCompra` decimal(15,2) DEFAULT NULL,
  `precoVenda` decimal(15,2) DEFAULT NULL,
  `qtdVendida` int DEFAULT NULL,
  PRIMARY KEY (`idEstoque`),
  KEY `idProduto` (`idProduto`),
  CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produtos` (`idProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,1,'2024-05-20',48,'NF12345',25.00,50.00,2),(2,2,'2024-05-20',29,'NF12346',80.00,150.00,1),(3,3,'2024-05-21',20,'NF12347',120.00,250.00,0),(4,4,'2024-05-21',39,'NF12348',10.00,25.00,1);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `idFuncionario` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idNivelUsuario` int NOT NULL DEFAULT '1',
  `nome` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cpf` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL,
  `endereco` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cep` varchar(9) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ativo` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N',
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `idNivelUsuario` (`idNivelUsuario`),
  CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`idNivelUsuario`) REFERENCES `nivelusuarios` (`idNivelUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'joao.silva@loja.com',5,'João Silva','111.111.111-11','Rua A, 123','01000-000','(11)98765-4321','S'),(2,'maria.oliveira@loja.com',3,'Maria Oliveira','222.222.222-22','Av. B, 456','02000-000','(11)99876-5432','S'),(3,'pedro.santos@loja.com',4,'Pedro Santos','333.333.333-33','Travessa C, 789','03000-000','(11)97654-3210','S');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemspedido`
--

DROP TABLE IF EXISTS `itemspedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemspedido` (
  `idItemPedido` int NOT NULL AUTO_INCREMENT,
  `idPedido` int DEFAULT NULL,
  `ordem` int DEFAULT NULL,
  `idEstoque` int DEFAULT NULL,
  `qtdItem` int DEFAULT NULL,
  `dtDevolucao` datetime DEFAULT NULL,
  `motivoDevolucao` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`idItemPedido`),
  KEY `idPedido` (`idPedido`),
  KEY `idEstoque` (`idEstoque`),
  CONSTRAINT `itemspedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`),
  CONSTRAINT `itemspedido_ibfk_2` FOREIGN KEY (`idEstoque`) REFERENCES `estoque` (`idEstoque`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemspedido`
--

LOCK TABLES `itemspedido` WRITE;
/*!40000 ALTER TABLE `itemspedido` DISABLE KEYS */;
INSERT INTO `itemspedido` VALUES (1,2,1,1,2,NULL,NULL),(2,2,2,4,1,NULL,NULL),(3,1,1,2,1,NULL,NULL);
/*!40000 ALTER TABLE `itemspedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logisticapedidos`
--

DROP TABLE IF EXISTS `logisticapedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logisticapedidos` (
  `idLogistica` int NOT NULL AUTO_INCREMENT,
  `idPedido` int NOT NULL,
  `dtEnvio` datetime DEFAULT NULL,
  `dtRecebimento` datetime DEFAULT NULL,
  `rastreioFrete` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idLogistica`),
  KEY `idPedido` (`idPedido`),
  CONSTRAINT `logisticapedidos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logisticapedidos`
--

LOCK TABLES `logisticapedidos` WRITE;
/*!40000 ALTER TABLE `logisticapedidos` DISABLE KEYS */;
INSERT INTO `logisticapedidos` VALUES (1,2,'2025-05-28 12:46:59',NULL,'BR123456789XX');
/*!40000 ALTER TABLE `logisticapedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacaoestoque`
--

DROP TABLE IF EXISTS `movimentacaoestoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacaoestoque` (
  `idMovimentacao` int NOT NULL AUTO_INCREMENT,
  `idEstoque` int DEFAULT NULL,
  `tipoMovimentacao` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '{"Entrada", "Saída", "Devolução", "Ajuste"}',
  `quantidade` int DEFAULT NULL,
  `dataMovimentacao` datetime DEFAULT CURRENT_TIMESTAMP,
  `observacao` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`idMovimentacao`),
  KEY `idEstoque` (`idEstoque`),
  CONSTRAINT `movimentacaoestoque_ibfk_1` FOREIGN KEY (`idEstoque`) REFERENCES `estoque` (`idEstoque`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacaoestoque`
--

LOCK TABLES `movimentacaoestoque` WRITE;
/*!40000 ALTER TABLE `movimentacaoestoque` DISABLE KEYS */;
INSERT INTO `movimentacaoestoque` VALUES (1,1,'Saída',2,'2025-05-28 12:47:09','Venda - Pedido 1'),(2,4,'Saída',1,'2025-05-28 12:47:17','Venda - Pedido 1'),(3,2,'Saída',1,'2025-05-28 12:47:25','Venda - Pedido 2');
/*!40000 ALTER TABLE `movimentacaoestoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivelusuarios`
--

DROP TABLE IF EXISTS `nivelusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nivelusuarios` (
  `idNivelUsuario` int NOT NULL AUTO_INCREMENT,
  `nivel` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '{"Cliente", "Caixa", "Vendedor", "Estoquista", "Gerente", "Fornecedor"}',
  PRIMARY KEY (`idNivelUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivelusuarios`
--

LOCK TABLES `nivelusuarios` WRITE;
/*!40000 ALTER TABLE `nivelusuarios` DISABLE KEYS */;
INSERT INTO `nivelusuarios` VALUES (1,'Cliente'),(2,'Caixa'),(3,'Vendedor'),(4,'Estoquista'),(5,'Gerente'),(6,'Fornecedor');
/*!40000 ALTER TABLE `nivelusuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamentos` (
  `idPagamento` int NOT NULL AUTO_INCREMENT,
  `idPedido` int NOT NULL,
  `metodoPagamento` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `statusPagamento` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `valorPago` decimal(12,2) DEFAULT NULL,
  `dtPagamento` datetime DEFAULT NULL,
  `notaFiscal` text COLLATE utf8mb4_unicode_ci,
  `dtNotaFiscal` datetime DEFAULT NULL,
  PRIMARY KEY (`idPagamento`),
  KEY `idPedido` (`idPedido`),
  CONSTRAINT `pagamentos_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `pedidos` (`idPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamentos`
--

LOCK TABLES `pagamentos` WRITE;
/*!40000 ALTER TABLE `pagamentos` DISABLE KEYS */;
INSERT INTO `pagamentos` VALUES (1,2,'Cartão de Crédito','Aprovado',125.00,'2025-05-28 12:46:54',NULL,NULL),(2,1,'Pix','Aprovado',150.00,'2025-05-28 12:46:54',NULL,NULL);
/*!40000 ALTER TABLE `pagamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idPedido` int NOT NULL AUTO_INCREMENT,
  `idFuncionario` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  `idVendedor` int DEFAULT NULL,
  `dtPedido` datetime DEFAULT NULL,
  `tipoFrete` int DEFAULT '0' COMMENT '{ 0=Retirada, 1=PAC, 2=SEDEX, 3=MOTOBOY, 4=TRANSPORTADORA }',
  `entregaEndereco` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `entregaCEP` varchar(9) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `entregaTelefone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dtDevolucao` datetime DEFAULT NULL,
  `motivoDevolucao` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`idPedido`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idCliente` (`idCliente`),
  KEY `idVendedor` (`idVendedor`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionarios` (`idFuncionario`),
  CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  CONSTRAINT `pedidos_ibfk_3` FOREIGN KEY (`idVendedor`) REFERENCES `funcionarios` (`idFuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,NULL,1,2,'2025-05-28 12:46:45',1,'Rua D, 101','04000-000','(11)91234-5678',NULL,NULL),(2,NULL,2,2,'2025-05-28 12:46:45',0,'Av. E, 202','05000-000','(11)92345-6789',NULL,NULL);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `idProduto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `marca` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modelo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idCategoria` int DEFAULT NULL,
  `descricao` text COLLATE utf8mb4_unicode_ci,
  `unidadeMedida` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cor` varchar(7) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estoqueMinimo` int DEFAULT '0',
  PRIMARY KEY (`idProduto`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `produtos_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Camiseta Básica Masculina','Loja X','Gola Redonda',5,'Camiseta 100% algodão, diversas cores','unidade','#FFFFFF',10),(2,'Calça Jeans Slim Feminina','FashionJeans','Cintura Alta',8,'Calça jeans com elastano para conforto','unidade','#0000FF',5),(3,'Tênis Esportivo Unisex','SportFeet','Runner Pro',1,'Tênis ideal para corrida e caminhada','par','#000000',8),(4,'Meia Cano Curto (Pack 3)','ConfortPé','Invisível',2,'Pack com 3 pares de meias de algodão','pack','#AAAAAA',15);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-28 15:09:06
