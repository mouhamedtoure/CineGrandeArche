-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 29 Novembre 2016 à 21:00
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cinegrandearche`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `reference` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prixHT` double NOT NULL,
  `nom` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `format` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `url` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `delaiLivraison` double NOT NULL,
  `etat` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `article`
--

INSERT INTO `article` (`reference`, `prixHT`, `nom`, `description`, `image`, `format`, `url`, `stock`, `delaiLivraison`, `etat`, `type`) VALUES
('123456', 10, 'L\'etranger', 'Bon livre', 'Letranger.jpeg', 'poche', 'null', 10, 2, 'TRES_BON_ETAT', 'Livre'),
('234567', 15.99, 'Madame Bovary', 'très bon livre. A recommander', 'Bovary.jpg', 'pdf', 'url', 0, 10, 'TRES_BON_ETAT', 'Livre'),
('345678', 20, 'Jurassic Park', 'recommande', 'Jurassicpark.jpg', 'papier', 'url', 50, 10, 'TRES_BON_ETAT', 'livre'),
('456789', 50, 'Retour vers le futur', 'Retour vers le futur est une trilogie cinématographique', 'Futur.jpg', 'DVD', 'null', 50, 5, 'TRES_BON_ETAT', 'demat');

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `reference` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `isbn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `titre` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `format` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateParution` date NOT NULL,
  `auteur` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `editeur` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `genre` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `livre`
--

INSERT INTO `livre` (`reference`, `isbn`, `titre`, `format`, `dateParution`, `auteur`, `editeur`, `genre`) VALUES
('123456', 'monisbn', 'Unlivre', 'pdf', '2016-11-01', 'Camus', 'Hachette', 'roman'),
('234567', 'qsjkdfb', 'MonLivre', 'papier', '2016-11-16', 'Flaubert', 'Hachette', 'roman');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`reference`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`reference`);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `fk_livre_article` FOREIGN KEY (`reference`) REFERENCES `article` (`reference`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
