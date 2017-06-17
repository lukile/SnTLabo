-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 17 Juin 2017 à 18:18
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sntlabo`
--

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `numeroIdentification` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `codeProjet` int(11) DEFAULT NULL,
  `dateEmbauche` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `collaborateur`
--

INSERT INTO `collaborateur` (`numeroIdentification`, `nom`, `prenom`, `email`, `telephone`, `codeProjet`, `dateEmbauche`, `ville`) VALUES
(72, 'COTTIN', 'Jean paul', 'jep@gm.com', '2020020202', 1, '25/03/2012', 'cottinet'),
(73, 'POUETOU', 'Jean Louis', 'jl@pouetou.com', '20020202', 2, '24/03/2012', 'POUETOU CHARENTE'),
(74, 'POUICOU', 'Jean Luc', 'jl@pouicou.com', '020202020', 3, '23/09/2300', 'POUICOU SUR LOIRE'),
(75, 'COCO LE CONNARD', 'Stipe', 'cocostipé@g.com', '3333333', 4, '21/09/3210', 'COCOUNET'),
(76, 'ee', 'ee', 'ee', 'ee', 1, 'EE', 'EE'),
(77, 'a', 'a', 'a', 'a', 1, 'A', 'a'),
(78, 'pouet', 'pouet', 'pouet', 'é', 3, 'e', 'e'),
(79, 'd', 'd', 'd', 'd', 2, 'd', 'd'),
(80, 'p', 'p', 'p', 'p', 1, 'p', 'p'),
(81, 'a', 'a', 'a', 'a', 1, 'A', 'A'),
(82, 'a', 'a', 'a', 'a', 1, 'a', '1'),
(83, 'A', 'a', 'a', '1', 1, '1', '1');

-- --------------------------------------------------------

--
-- Structure de la table `commercial`
--

CREATE TABLE `commercial` (
  `nIdentification` int(11) NOT NULL,
  `salaire` double DEFAULT NULL,
  `noteDeFrais` double DEFAULT NULL,
  `remboursement` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commercial`
--

INSERT INTO `commercial` (`nIdentification`, `salaire`, `noteDeFrais`, `remboursement`) VALUES
(75, 4000, 211, 1);

-- --------------------------------------------------------

--
-- Structure de la table `congres`
--

CREATE TABLE `congres` (
  `idEvenement` int(11) NOT NULL,
  `dateDebutCongres` date DEFAULT NULL,
  `dateFinCongres` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `moleculeTestee` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `nIdentification` int(11) NOT NULL,
  `salaire` double DEFAULT NULL,
  `prime` double DEFAULT NULL,
  `essaiClinique` tinyint(1) DEFAULT NULL,
  `debutEssaiClinique` varchar(255) DEFAULT NULL,
  `finEssaiClinique` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`nIdentification`, `salaire`, `prime`, `essaiClinique`, `debutEssaiClinique`, `finEssaiClinique`) VALUES
(72, 2500, 250, 1, '12/12/2012', '12/01/2013');

-- --------------------------------------------------------

--
-- Structure de la table `medecin_evenement`
--

CREATE TABLE `medecin_evenement` (
  `idMedecin` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `scientifique`
--

CREATE TABLE `scientifique` (
  `nIdentification` int(11) NOT NULL,
  `salaire` double DEFAULT NULL,
  `prime` double DEFAULT NULL,
  `responsable` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `scientifique`
--

INSERT INTO `scientifique` (`nIdentification`, `salaire`, `prime`, `responsable`) VALUES
(73, 3000, 250, 1),
(74, 3000, 210, 0),
(76, 12, 12, 1),
(77, 1, 1, 1),
(78, 1, 1, 1),
(79, 1, 1, 1),
(80, 1, 1, 1),
(81, 1, 1, 0),
(82, 1, 1, 0),
(83, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `soiree`
--

CREATE TABLE `soiree` (
  `idEvenement` int(11) NOT NULL,
  `heureDebutSoiree` time DEFAULT NULL,
  `heureFinSoiree` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `unite`
--

CREATE TABLE `unite` (
  `id` int(11) NOT NULL,
  `nomUnite` varchar(255) DEFAULT NULL,
  `numeroRue` varchar(255) DEFAULT NULL,
  `nomRue` varchar(255) DEFAULT NULL,
  `codePostal` int(11) DEFAULT NULL,
  `villeUnite` varchar(255) DEFAULT NULL,
  `dateResponsabilite` varchar(255) NOT NULL,
  `nIdentificationSC` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `unite`
--

INSERT INTO `unite` (`id`, `nomUnite`, `numeroRue`, `nomRue`, `codePostal`, `villeUnite`, `dateResponsabilite`, `nIdentificationSC`) VALUES
(1, 'Unite centrale', '3bis', 'rue de la Girouette', 74321, 'Rouen', '12/07/2012', NULL),
(2, 'Unite centrale', '3bis', 'rue de la Girouette', 74321, 'Rouen', '12/07/2012', NULL),
(3, 'Unite centrale', '3bis', 'rue de la Girouette', 74321, 'Rouen', '12/07/2012', 80),
(4, 'pouet', '1', 'pouet', 12221, '', '0', 82),
(5, 'pouet', '12', '12', 12222, '12', '12/12/2012', 83);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`numeroIdentification`);

--
-- Index pour la table `commercial`
--
ALTER TABLE `commercial`
  ADD PRIMARY KEY (`nIdentification`),
  ADD KEY `nIdentification` (`nIdentification`);

--
-- Index pour la table `congres`
--
ALTER TABLE `congres`
  ADD PRIMARY KEY (`idEvenement`),
  ADD KEY `idEvenement` (`idEvenement`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`nIdentification`),
  ADD KEY `nIdentification` (`nIdentification`);

--
-- Index pour la table `medecin_evenement`
--
ALTER TABLE `medecin_evenement`
  ADD KEY `idMedecin` (`idMedecin`),
  ADD KEY `idEvenement` (`idEvenement`);

--
-- Index pour la table `scientifique`
--
ALTER TABLE `scientifique`
  ADD PRIMARY KEY (`nIdentification`),
  ADD KEY `nIdentification` (`nIdentification`);

--
-- Index pour la table `soiree`
--
ALTER TABLE `soiree`
  ADD PRIMARY KEY (`idEvenement`),
  ADD KEY `idEvenement` (`idEvenement`);

--
-- Index pour la table `unite`
--
ALTER TABLE `unite`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  MODIFY `numeroIdentification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `unite`
--
ALTER TABLE `unite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commercial`
--
ALTER TABLE `commercial`
  ADD CONSTRAINT `commercial_ibfk_1` FOREIGN KEY (`nIdentification`) REFERENCES `collaborateur` (`numeroIdentification`);

--
-- Contraintes pour la table `congres`
--
ALTER TABLE `congres`
  ADD CONSTRAINT `congres_ibfk_1` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`id`);

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `medecin_ibfk_1` FOREIGN KEY (`nIdentification`) REFERENCES `collaborateur` (`numeroIdentification`);

--
-- Contraintes pour la table `medecin_evenement`
--
ALTER TABLE `medecin_evenement`
  ADD CONSTRAINT `medecin_evenement_ibfk_1` FOREIGN KEY (`idMedecin`) REFERENCES `medecin` (`nIdentification`),
  ADD CONSTRAINT `medecin_evenement_ibfk_2` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`id`);

--
-- Contraintes pour la table `scientifique`
--
ALTER TABLE `scientifique`
  ADD CONSTRAINT `scientifique_ibfk_1` FOREIGN KEY (`nIdentification`) REFERENCES `collaborateur` (`numeroIdentification`);

--
-- Contraintes pour la table `soiree`
--
ALTER TABLE `soiree`
  ADD CONSTRAINT `soiree_ibfk_1` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
