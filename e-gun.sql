-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 16 Juin 2021 à 19:16
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `e-gun`
--

-- --------------------------------------------------------

--
-- Structure de la table `arme`
--

CREATE TABLE IF NOT EXISTS `arme` (
  `idArme` int(11) NOT NULL AUTO_INCREMENT,
  `idTypeArme` int(11) DEFAULT NULL,
  `idGestionnaire` int(11) DEFAULT NULL,
  `idFournisseur` int(11) DEFAULT NULL,
  `nom` varchar(20) NOT NULL,
  `prix` double NOT NULL,
  `quantiteDepose` int(11) NOT NULL,
  `quantiteActuelle` int(11) NOT NULL,
  PRIMARY KEY (`idArme`),
  KEY `idTypeArme` (`idTypeArme`),
  KEY `idGestionnaire` (`idGestionnaire`),
  KEY `idFournisseur` (`idFournisseur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `arme`
--

INSERT INTO `arme` (`idArme`, `idTypeArme`, `idGestionnaire`, `idFournisseur`, `nom`, `prix`, `quantiteDepose`, `quantiteActuelle`) VALUES
(1, 1, 2, 1, 'Poing Americain', 15, 500, 299),
(2, 1, 2, 2, 'Nunchaku', 10, 45, 19),
(3, 1, 1, 2, 'Matraque 1', 15, 50, 40),
(4, 1, 2, 1, 'Matraque 2', 10, 60, 70),
(5, 1, 1, 2, 'Poing Electrique', 15, 50, 30),
(6, 2, 1, 2, 'Carabine', 15, 50, 32),
(7, 2, 1, 2, 'Pistolet 1', 10, 50, 35),
(8, 2, 1, 2, 'Pistolet 2', 15, 50, 25),
(9, 2, 1, 2, 'Pistolet 3', 10, 50, 38),
(10, 2, 1, 1, 'Pistolet 4', 15, 60, 40),
(11, 2, 1, 2, 'Revolver 1', 10, 55, 55),
(12, 2, 1, 2, 'Revolver 2', 15, 50, 50),
(13, 2, 2, 2, 'Sabre', 10, 55, 10),
(14, 3, 1, 2, 'Arbalette 1', 15, 40, 35),
(15, 3, 1, 2, 'Arbalette 2', 10, 45, 45),
(16, 3, 1, 2, 'Lance Pierre', 15, 50, 50);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `adresse` varchar(30) NOT NULL,
  `identifiant` varchar(30) DEFAULT NULL,
  `motDePasse` varchar(60) DEFAULT NULL,
  `photo` varchar(25) DEFAULT NULL,
  `biographie` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `prenom`, `email`, `sexe`, `telephone`, `adresse`, `identifiant`, `motDePasse`, `photo`, `biographie`) VALUES
(39, 'sabwe', 'joyce', 'joycesabwe@gmail.com', 'Masculin', '0825312001', 'kin', 'sabwejoyce', '19053d1f43416ad98dd9443425753488', 'IMG_6181.jpg', 'Poureux,d''etre,citoyen,du,monde,Heureux,d''etre,citoyen,du,monde,Heureux,d''etre,citoyen,du,mund'),
(40, 'yombo', 'pulcra', 'joycesabwe@live.fr', 'Feminin', '0823333979', 'kintambo', 'yombopulcra', 'ac043441e1aae3073f89a401362189a0', 'IMG_6216.jpg', 'bonjour. j''aime la vie et sauver celle des autres et ma passion! je suis Pulcrah'),
(42, 'kage', 'josue', 'josuekage@gmail.com', 'Masculin', '0823333978', 'mat2', 'kagejosue1', 'c4f0f080c3f5992b3a4c03d04ace51a2', 'IMG_6352.jpg', 'call me Cresus!'),
(43, 'christ', 'lionel', 'joicesabwe@gmail.com', NULL, '0825312001', 'kikonle 3', 'christlionel', '800a0e21225906fe82d141def1a9202d', NULL, NULL),
(45, 'test1', 'test', 'test1test@live.fr', NULL, '0823333979', 'Tshangu', 'test1test', 'b61a6d542f9036550ba9c401c80f00ef', NULL, NULL),
(47, 'kambaja', 'kayembe', 'vanessakambaja43@gmail.com', 'Feminin', '0817518702', 'mont ngaula', 'kambajakayembe1', '279c6a430a5f342c502bc325375a5eb1', 'IMG_6275.jpg', 'vani''lait K'),
(48, 'luzibu', 'blanche', 'blacheluz@live.fr', 'Feminin', '0986745123', 'matete', 'luzibublanche', '827ccb0eea8a706c4c34a16891f84e7b', 'IMG_6332.jpg', 'moi c''est luzibu'),
(49, 'kapinga', 'benji', 'benjiMbunz@gmail.com', NULL, '0827207412', 'Kinshasa', 'kapingabenji', 'fbb9eb1730b2c6a8524acda9e3ab483a', 'IMG_6265.jpg', 'CEO de l''ONG Mbunzu forever qui s''occupe des gens ayant un gros front.'),
(50, 'ondiyo', 'mutus', 'ondiyomutu@gmail.com', 'Masculin', '0827573331', 'lodja', 'ondiyomutu', '912e79cd13c64069d91da65d62fbb78c', 'IMG_6208.jpg', 'vilouza');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `idArme` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `dateCommande` date NOT NULL,
  `document` varchar(30) DEFAULT NULL,
  `statut` varchar(10) NOT NULL DEFAULT 'checking',
  PRIMARY KEY (`idCommande`),
  KEY `idArme` (`idArme`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=195 ;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `idArme`, `idClient`, `quantite`, `dateCommande`, `document`, `statut`) VALUES
(23, 2, 39, 25, '2021-06-02', '', 'checking'),
(24, 2, 39, 10, '2021-06-02', '', 'checking'),
(25, 1, 40, 35, '2021-06-02', '', 'checking'),
(26, 2, 40, 12, '2021-06-02', '', 'checking'),
(27, 1, 42, 20, '2021-06-02', '', 'checking'),
(28, 1, 43, 10, '2021-06-02', '', 'checking'),
(74, 1, 45, 10, '2021-06-03', 'ptx', 'Success'),
(80, 1, 45, 3, '2021-06-03', 'pdf', 'Success'),
(82, 1, 45, 2, '2021-06-03', '', 'checking'),
(83, 2, 45, 10, '2021-06-03', '', 'checking'),
(116, 2, 39, 10, '2021-06-03', '', 'checking'),
(117, 2, 39, 1, '2021-06-04', '', 'checking'),
(123, 1, 47, 8, '2021-06-05', '', 'denied'),
(186, 13, 39, 5, '2021-06-15', 'Compte Rendu.pdf', 'Success'),
(187, 13, 39, 15, '2021-06-15', 'Compte Rendu.pdf', 'Echec'),
(188, 3, 39, 10, '2021-06-16', 'Build1.pdf', 'checking'),
(189, 7, 39, 5, '2021-06-16', 'Compte Rendu.pdf', 'checking'),
(190, 6, 39, 5, '2021-06-16', '', 'checking'),
(191, 14, 48, 5, '2021-06-16', 'Compte Rendu.pdf', 'Success'),
(192, 6, 49, 23, '2021-06-16', 'Compte Rendu.pdf', 'checking'),
(193, 13, 49, 10, '2021-06-16', 'Compte Rendu.pdf', 'Success'),
(194, 8, 50, 1, '2021-06-16', 'Compte Rendu.pdf', 'Success');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `idFacture` int(11) NOT NULL AUTO_INCREMENT,
  `idCommande` int(11) DEFAULT NULL,
  `numero` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idFacture`),
  KEY `idCommande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE IF NOT EXISTS `fournisseur` (
  `idFournisseur` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  PRIMARY KEY (`idFournisseur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `fournisseur`
--

INSERT INTO `fournisseur` (`idFournisseur`, `nom`, `telephone`, `adresse`) VALUES
(1, 'chine', '006 665', 'pekin 665'),
(2, 'russie', '007 45 45', 'moscou 001');

-- --------------------------------------------------------

--
-- Structure de la table `gestionnaire`
--

CREATE TABLE IF NOT EXISTS `gestionnaire` (
  `idGestionnaire` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `identifiant` varchar(20) NOT NULL,
  `motDePasse` varchar(10) NOT NULL,
  PRIMARY KEY (`idGestionnaire`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `gestionnaire`
--

INSERT INTO `gestionnaire` (`idGestionnaire`, `nom`, `prenom`, `telephone`, `adresse`, `identifiant`, `motDePasse`) VALUES
(1, 'sabwe', 'saiz', '12345', 'kin', 'josaiz', '12345'),
(2, 'kapinga', 'benedie', '12346', 'rdc', 'kapben', '12345'),
(3, 'ondiyo', 'remy', '12347', 'lushi', 'ondrem', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `type_arme`
--

CREATE TABLE IF NOT EXISTS `type_arme` (
  `idTypeArme` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idTypeArme`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `type_arme`
--

INSERT INTO `type_arme` (`idTypeArme`, `nom`) VALUES
(1, 'Arme non Letal'),
(2, 'Arme Letal'),
(3, 'Arme de Chasse');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `arme`
--
ALTER TABLE `arme`
  ADD CONSTRAINT `arme_ibfk_1` FOREIGN KEY (`idTypeArme`) REFERENCES `type_arme` (`idTypeArme`),
  ADD CONSTRAINT `arme_ibfk_2` FOREIGN KEY (`idGestionnaire`) REFERENCES `gestionnaire` (`idGestionnaire`),
  ADD CONSTRAINT `arme_ibfk_3` FOREIGN KEY (`idFournisseur`) REFERENCES `fournisseur` (`idFournisseur`);

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idArme`) REFERENCES `arme` (`idArme`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_2` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
