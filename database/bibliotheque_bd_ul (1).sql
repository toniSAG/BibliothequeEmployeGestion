-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 02 juin 2023 à 00:58
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bibliotheque_bd_ul`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonne_bibliotheque`
--

CREATE TABLE `abonne_bibliotheque` (
  `id_abonne_bibliotheque` int(11) NOT NULL,
  `nom_abonne_bibliotheque` varchar(100) NOT NULL,
  `prenom_abonne_bibliotheque` varchar(100) NOT NULL,
  `mail_abonne_bibliotheque` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `abonne_bibliotheque`
--

INSERT INTO `abonne_bibliotheque` (`id_abonne_bibliotheque`, `nom_abonne_bibliotheque`, `prenom_abonne_bibliotheque`, `mail_abonne_bibliotheque`) VALUES
(2, 'Assif', 'Zidane', 'assif.zidane@outlook.fr'),
(4, 'Magellan', 'Jean', 'jean.magellan@gmail.com'),
(5, 'Dupont', 'Albert', 'albert.dupont@gmail.com'),
(7, 'Lévy', 'Jean-Marc', 'jm.levy@outlook.fr'),
(52, 'Rochefort', 'Jean', 'j.rochefort@gmail.com'),
(54, 'zamzam', 'mamar', 'zam.mam@gmail.com'),
(55, 'momo', 'toto', 'to.mo@gmail.com'),
(58, 'sam', 'tam', 'tam.sam@gmail.com'),
(61, 'vava', 'baba', 'vava.baba@outlook.fr');

-- --------------------------------------------------------

--
-- Structure de la table `createur_bibliotheque`
--

CREATE TABLE `createur_bibliotheque` (
  `id_createur_bibliotheque` int(11) NOT NULL,
  `nom_createur_bibliotheque` varchar(100) NOT NULL,
  `prenom_createur_bibliotheque` varchar(100) NOT NULL,
  `id_type_createur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `createur_bibliotheque`
--

INSERT INTO `createur_bibliotheque` (`id_createur_bibliotheque`, `nom_createur_bibliotheque`, `prenom_createur_bibliotheque`, `id_type_createur`) VALUES
(1, 'King', 'Stephen', 1),
(2, 'Arleston', 'Christophe', 1),
(3, 'Floch', 'Adrien', 2),
(4, 'Pérez-Reverte', 'Arturo', 1),
(5, 'Mourlevat', 'Jean-Claude', 1),
(25, 'Westerfeld', 'Scott', 1),
(26, 'Senabre', 'Eric', 1),
(28, 'Grevet', 'Yves', 1),
(29, 'Enard', 'Mathias', 1),
(30, 'Jourde', 'Pierre', 1),
(31, 'Holman', 'Félice', 1),
(34, 'Galéa', 'Claudine', 1),
(38, 'Nielsen', 'Susie', 1),
(39, 'Rowling', 'Joanne Katleen', 1),
(40, 'Sapkowsky', 'Andrzej', 1),
(41, 'Rowling', 'Joanne Katleen', 1),
(42, 'Jaworsky', 'Jean-Philippe', 1),
(56, 'Jaworsky', 'Jean-Philippe', 1),
(97, 'Gosciny', 'René', 1),
(98, 'Uderzo', 'Albert', 2),
(99, 'Cortegianni', 'François', 1),
(100, 'Blanc-Dumont', 'Michel', 2),
(101, 'Masbou', 'Jean-Luc', 1),
(102, 'Ayroles', 'Alain', 2),
(103, 'Shirai', 'Kaiu', 1),
(104, 'Demizu', 'Posuka', 2),
(107, 'sasara', 'tarata', 1),
(108, 'Gary', 'Romain', 1),
(109, 'Doe', 'John', 2),
(111, 'Mourrier', 'Jean-Louis', 2);

-- --------------------------------------------------------

--
-- Structure de la table `createur_document_bibliotheque`
--

CREATE TABLE `createur_document_bibliotheque` (
  `ISBN_document` bigint(11) NOT NULL,
  `id_createur_bibliotheque_auteur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `createur_document_bibliotheque`
--

INSERT INTO `createur_document_bibliotheque` (`ISBN_document`, `id_createur_bibliotheque_auteur`) VALUES
(9782020408066, 4),
(9782070574827, 5),
(9782266159241, 25),
(9782278059232, 26),
(9782748505245, 28),
(9782330165338, 29),
(9782072967733, 30),
(9782203004719, 31),
(9782841568192, 34),
(9782330120566, 38),
(9782070541270, 39),
(9782811205065, 40),
(9782361830892, 42),
(9782012101333, 97),
(9782205067781, 99),
(9782756021324, 101),
(9782820332233, 103),
(9782253151418, 1),
(9782849460542, 2);

-- --------------------------------------------------------

--
-- Structure de la table `dessinateur_document_bibliotheque`
--

CREATE TABLE `dessinateur_document_bibliotheque` (
  `ISBN_document` bigint(20) NOT NULL,
  `id_createur_bibliotheque_dessinateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `dessinateur_document_bibliotheque`
--

INSERT INTO `dessinateur_document_bibliotheque` (`ISBN_document`, `id_createur_bibliotheque_dessinateur`) VALUES
(9782012101333, 98),
(9782205067781, 100),
(9782756021324, 102),
(9782820332233, 104),
(9782849460542, 111);

-- --------------------------------------------------------

--
-- Structure de la table `document_bibliotheque`
--

CREATE TABLE `document_bibliotheque` (
  `ISBN_document` bigint(13) NOT NULL,
  `titre_document` varchar(100) NOT NULL,
  `date_parrution_document` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_type_document` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `document_bibliotheque`
--

INSERT INTO `document_bibliotheque` (`ISBN_document`, `titre_document`, `date_parrution_document`, `id_type_document`) VALUES
(9782004526741, 'trucmachin', '2023-05-01 22:00:00', 1),
(9782012101333, 'Astérix le gaulois', '0000-00-00 00:00:00', 2),
(9782020408066, 'Les bûchers de Bocanegra', '2000-03-31 22:00:00', 1),
(9782054789378, 'Bazaar', '2023-05-03 22:00:00', 1),
(9782070541270, 'Harry potter à l\'école des sorciers', '1997-06-25 22:00:00', 1),
(9782070574827, 'Le combat d\'hiver', '2006-09-20 22:00:00', 1),
(9782072967733, 'Pays perdu', '2022-01-19 23:00:00', 1),
(9782203004719, 'Le Robinson du métro', '2007-03-13 23:00:00', 1),
(9782205067781, 'La jeunesse de Blueberry tome 21', '2015-12-03 23:00:00', 2),
(9782253151418, 'Le fléau', '2003-06-03 22:00:00', 1),
(9782266159241, 'Uglies', '2007-05-02 22:00:00', 1),
(9782278059232, 'Sublutetia', '2011-10-18 22:00:00', 1),
(9782330120566, 'Partis sans laisser d\'adresse', '2019-04-02 22:00:00', 1),
(9782330165338, 'Le banquet annuel de la confrérie des fossoyeurs', '2022-05-03 22:00:00', 1),
(9782361830892, 'Gagner la guerre', '2009-03-04 23:00:00', 1),
(9782748505245, 'C\'était mon oncle', '2006-10-18 22:00:00', 1),
(9782756021324, 'De capes et de crocs: tome 1', '2009-11-17 23:00:00', 2),
(9782811205065, 'Le sorceleur, Tome 1:  Le dernier Voeu', '2011-04-20 22:00:00', 1),
(9782820332233, 'The promised neverland : tome 1', '2018-04-24 22:00:00', 2),
(9782841568192, 'Rouge métro', '2007-03-13 23:00:00', 1),
(9782849460542, 'Trolls de Troy, Tome 8 : Rock\'n troll attitude', '2005-06-21 22:00:00', 2);

-- --------------------------------------------------------

--
-- Structure de la table `employes_salaires`
--

CREATE TABLE `employes_salaires` (
  `id_salaire` int(11) NOT NULL,
  `id_employe_bibliotheque` int(11) NOT NULL,
  `salaire` double NOT NULL,
  `date_paiement` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employes_salaires`
--

INSERT INTO `employes_salaires` (`id_salaire`, `id_employe_bibliotheque`, `salaire`, `date_paiement`) VALUES
(1, 2, 1700, '2023-05-10 11:13:43'),
(2, 4, 1800, '2023-05-15 11:43:47'),
(3, 1, 1700, '2023-05-27 21:13:55'),
(4, 1, 2500, '2023-05-27 21:15:11');

-- --------------------------------------------------------

--
-- Structure de la table `employe_bibliotheque`
--

CREATE TABLE `employe_bibliotheque` (
  `id_employe_bibliotheque` int(11) NOT NULL,
  `nom_employe_bibliotheque` varchar(100) NOT NULL,
  `prenom_employe_bibliotheque` varchar(100) NOT NULL,
  `id_fonction_employe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `employe_bibliotheque`
--

INSERT INTO `employe_bibliotheque` (`id_employe_bibliotheque`, `nom_employe_bibliotheque`, `prenom_employe_bibliotheque`, `id_fonction_employe`) VALUES
(1, 'Durand', 'Gérard', 1),
(2, 'Cohen', 'Marla', 3),
(3, 'Bougdil', 'Samir', 3),
(4, 'Pasqua', 'Charles', 3),
(10, 'Kruger', 'Diane', 3),
(12, 'Delacour', 'Agathe', 4),
(13, 'Bergé', 'Aurore', 3),
(17, 'Caffre', 'Bérangère', 2),
(20, 'Barbon', 'Fabrice', 2),
(23, 'Leclerc', 'Philippe', 4);

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `id_emprunt` int(11) NOT NULL,
  `date_emprunt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `date_retour` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_abonne_bibliotheque` int(11) NOT NULL,
  `id_employe_bibliotheque` int(11) NOT NULL,
  `ISBN_document` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id_emprunt`, `date_emprunt`, `date_retour`, `id_abonne_bibliotheque`, `id_employe_bibliotheque`, `ISBN_document`) VALUES
(1, '2023-05-30 12:15:59', '2023-05-08 22:00:00', 4, 2, 9782020408066),
(32, '2023-06-01 22:00:00', '2023-06-07 22:00:00', 2, 2, 9782004526741),
(33, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 7, 3, 9782748505245),
(34, '2023-06-01 22:00:00', '2023-06-05 22:00:00', 52, 2, 9782330120566);

-- --------------------------------------------------------

--
-- Structure de la table `fonction_employe_bibliotheque`
--

CREATE TABLE `fonction_employe_bibliotheque` (
  `id_fonction_employe` int(11) NOT NULL,
  `libelle_fonction_employe` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fonction_employe_bibliotheque`
--

INSERT INTO `fonction_employe_bibliotheque` (`id_fonction_employe`, `libelle_fonction_employe`) VALUES
(1, 'Directeur'),
(2, 'Responsable d\'équipe'),
(3, 'Bibliothécaire'),
(4, 'Documentaliste');

-- --------------------------------------------------------

--
-- Structure de la table `type_createur`
--

CREATE TABLE `type_createur` (
  `id_type_createur` int(11) NOT NULL,
  `libelle_type_createur` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_createur`
--

INSERT INTO `type_createur` (`id_type_createur`, `libelle_type_createur`) VALUES
(1, 'auteur'),
(2, 'dessinateur'),
(3, 'scénariste');

-- --------------------------------------------------------

--
-- Structure de la table `type_document_bibliotheque`
--

CREATE TABLE `type_document_bibliotheque` (
  `id_type_document` int(11) NOT NULL,
  `libelle_type_document` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_document_bibliotheque`
--

INSERT INTO `type_document_bibliotheque` (`id_type_document`, `libelle_type_document`) VALUES
(1, 'Livre'),
(2, 'Bande dessinée');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `abonne_bibliotheque`
--
ALTER TABLE `abonne_bibliotheque`
  ADD PRIMARY KEY (`id_abonne_bibliotheque`);

--
-- Index pour la table `createur_bibliotheque`
--
ALTER TABLE `createur_bibliotheque`
  ADD PRIMARY KEY (`id_createur_bibliotheque`),
  ADD KEY `id_type_createur` (`id_type_createur`);

--
-- Index pour la table `createur_document_bibliotheque`
--
ALTER TABLE `createur_document_bibliotheque`
  ADD KEY `id_createur_bibliotheque` (`id_createur_bibliotheque_auteur`),
  ADD KEY `ISBN_document` (`ISBN_document`);

--
-- Index pour la table `dessinateur_document_bibliotheque`
--
ALTER TABLE `dessinateur_document_bibliotheque`
  ADD KEY `ISBN_document` (`ISBN_document`),
  ADD KEY `id_createur_bibliotheque_dessinateur` (`id_createur_bibliotheque_dessinateur`);

--
-- Index pour la table `document_bibliotheque`
--
ALTER TABLE `document_bibliotheque`
  ADD PRIMARY KEY (`ISBN_document`),
  ADD KEY `id_type_document` (`id_type_document`);

--
-- Index pour la table `employes_salaires`
--
ALTER TABLE `employes_salaires`
  ADD PRIMARY KEY (`id_salaire`),
  ADD KEY `id_employe_bibliotheque` (`id_employe_bibliotheque`);

--
-- Index pour la table `employe_bibliotheque`
--
ALTER TABLE `employe_bibliotheque`
  ADD PRIMARY KEY (`id_employe_bibliotheque`),
  ADD KEY `id_fonction_employe` (`id_fonction_employe`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id_emprunt`),
  ADD KEY `id_employe_emprunt` (`id_employe_bibliotheque`),
  ADD KEY `ISBN_emprunt` (`ISBN_document`),
  ADD KEY `id_abonne_emprunt` (`id_abonne_bibliotheque`);

--
-- Index pour la table `fonction_employe_bibliotheque`
--
ALTER TABLE `fonction_employe_bibliotheque`
  ADD PRIMARY KEY (`id_fonction_employe`);

--
-- Index pour la table `type_createur`
--
ALTER TABLE `type_createur`
  ADD PRIMARY KEY (`id_type_createur`);

--
-- Index pour la table `type_document_bibliotheque`
--
ALTER TABLE `type_document_bibliotheque`
  ADD PRIMARY KEY (`id_type_document`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `abonne_bibliotheque`
--
ALTER TABLE `abonne_bibliotheque`
  MODIFY `id_abonne_bibliotheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT pour la table `createur_bibliotheque`
--
ALTER TABLE `createur_bibliotheque`
  MODIFY `id_createur_bibliotheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT pour la table `employes_salaires`
--
ALTER TABLE `employes_salaires`
  MODIFY `id_salaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `employe_bibliotheque`
--
ALTER TABLE `employe_bibliotheque`
  MODIFY `id_employe_bibliotheque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `id_emprunt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT pour la table `fonction_employe_bibliotheque`
--
ALTER TABLE `fonction_employe_bibliotheque`
  MODIFY `id_fonction_employe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `createur_bibliotheque`
--
ALTER TABLE `createur_bibliotheque`
  ADD CONSTRAINT `createur_bibliotheque_ibfk_1` FOREIGN KEY (`id_type_createur`) REFERENCES `type_createur` (`id_type_createur`);

--
-- Contraintes pour la table `createur_document_bibliotheque`
--
ALTER TABLE `createur_document_bibliotheque`
  ADD CONSTRAINT `createur_document_bibliotheque_ibfk_1` FOREIGN KEY (`id_createur_bibliotheque_auteur`) REFERENCES `createur_bibliotheque` (`id_createur_bibliotheque`),
  ADD CONSTRAINT `createur_document_bibliotheque_ibfk_2` FOREIGN KEY (`ISBN_document`) REFERENCES `document_bibliotheque` (`ISBN_document`);

--
-- Contraintes pour la table `dessinateur_document_bibliotheque`
--
ALTER TABLE `dessinateur_document_bibliotheque`
  ADD CONSTRAINT `dessinateur_document_bibliotheque_ibfk_1` FOREIGN KEY (`ISBN_document`) REFERENCES `document_bibliotheque` (`ISBN_document`),
  ADD CONSTRAINT `dessinateur_document_bibliotheque_ibfk_2` FOREIGN KEY (`id_createur_bibliotheque_dessinateur`) REFERENCES `createur_bibliotheque` (`id_createur_bibliotheque`);

--
-- Contraintes pour la table `document_bibliotheque`
--
ALTER TABLE `document_bibliotheque`
  ADD CONSTRAINT `document_bibliotheque_ibfk_1` FOREIGN KEY (`id_type_document`) REFERENCES `type_document_bibliotheque` (`id_type_document`);

--
-- Contraintes pour la table `employes_salaires`
--
ALTER TABLE `employes_salaires`
  ADD CONSTRAINT `employes_salaires_ibfk_1` FOREIGN KEY (`id_employe_bibliotheque`) REFERENCES `employe_bibliotheque` (`id_employe_bibliotheque`);

--
-- Contraintes pour la table `employe_bibliotheque`
--
ALTER TABLE `employe_bibliotheque`
  ADD CONSTRAINT `employe_bibliotheque_ibfk_1` FOREIGN KEY (`id_fonction_employe`) REFERENCES `fonction_employe_bibliotheque` (`id_fonction_employe`);

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`id_abonne_bibliotheque`) REFERENCES `abonne_bibliotheque` (`id_abonne_bibliotheque`),
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`id_employe_bibliotheque`) REFERENCES `employe_bibliotheque` (`id_employe_bibliotheque`),
  ADD CONSTRAINT `emprunt_ibfk_3` FOREIGN KEY (`ISBN_document`) REFERENCES `document_bibliotheque` (`ISBN_document`),
  ADD CONSTRAINT `emprunt_ibfk_4` FOREIGN KEY (`id_abonne_bibliotheque`) REFERENCES `abonne_bibliotheque` (`id_abonne_bibliotheque`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
