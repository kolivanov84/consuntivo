CREATE DATABASE `consuntivo` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `user` (
  `id_utente` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `permission` enum('USER','ADMIN') NOT NULL,
  PRIMARY KEY (`id_utente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
