-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Sam 17 Juin 2017 à 21:48
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
(95, 'COCO', 'jean charles', 'jc@g.com', '220220', 3, '12/02/2012', 'Pari'),
(96, 'POUET', 'POUET', 'pouet', '12200202', 3, 'kkeke', 'ekkee');

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
(95, 12000, 1493, 1),
(96, 12, 14, 0);

-- --------------------------------------------------------

--
-- Structure de la table `commercial_evenement`
--

CREATE TABLE `commercial_evenement` (
  `idCommercial` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `commercial_evenement`
--

INSERT INTO `commercial_evenement` (`idCommercial`, `idEvenement`) VALUES
(95, 6),
(96, 7);

-- --------------------------------------------------------

--
-- Structure de la table `congres`
--

CREATE TABLE `congres` (
  `idEvenement` int(11) NOT NULL,
  `dateDebutCongres` varchar(255) DEFAULT NULL,
  `dateFinCongres` varchar(255) DEFAULT NULL
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

--
-- Contenu de la table `evenement`
--

INSERT INTO `evenement` (`id`, `adresse`, `moleculeTestee`) VALUES
(6, '3 rue de la bigotiere', 'chavroux'),
(7, 'ZEEEO', 'ekek');

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

-- --------------------------------------------------------

--
-- Structure de la table `soiree`
--

CREATE TABLE `soiree` (
  `idEvenement` int(11) NOT NULL,
  `dateSoiree` varchar(255) NOT NULL,
  `heureDebutSoiree` time DEFAULT NULL,
  `heureFinSoiree` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `soiree`
--

INSERT INTO `soiree` (`idEvenement`, `dateSoiree`, `heureDebutSoiree`, `heureFinSoiree`) VALUES
(7, '12/02/2122', '12:00:00', '23:00:00');

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
-- Index pour la table `commercial_evenement`
--
ALTER TABLE `commercial_evenement`
  ADD PRIMARY KEY (`idCommercial`,`idEvenement`),
  ADD KEY `idEvenement` (`idEvenement`);

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
  ADD PRIMARY KEY (`idMedecin`,`idEvenement`),
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
  MODIFY `numeroIdentification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
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
-- Contraintes pour la table `commercial_evenement`
--
ALTER TABLE `commercial_evenement`
  ADD CONSTRAINT `commercial_evenement_ibfk_1` FOREIGN KEY (`idCommercial`) REFERENCES `commercial` (`nIdentification`),
  ADD CONSTRAINT `commercial_evenement_ibfk_2` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`id`),
  ADD CONSTRAINT `commercial_evenement_ibfk_3` FOREIGN KEY (`idCommercial`) REFERENCES `commercial` (`nIdentification`);

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
