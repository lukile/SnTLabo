-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 20 Juin 2017 à 22:11
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
(104, 'nouveaunom', 'nouveaunom', 'nouveaunom', 'nouveaunom', 34, 'nouveaunom', 'Strasbourg'),
(105, 'nom', 'nom', 'nom', 'nom', 12, '03-02-2009', 'Grenoble'),
(106, 'pouet', 'pouet', 'pouet', 'pouet', 5, '03-04-2013', 'Marseille'),
(107, 'Pouet', 'pouet', 'pouet', 'pouet', 3, '05-05-2015', 'Bordeaux'),
(108, 'Jean Louis', 'Jean charles', 'jc@g.com', '200202020', 12, '12-02-2012', 'Strasbourg'),
(109, 'Luc', 'Jean', 'jl@g.com', '0202020202', 4, '30-06-2012', 'Rennes'),
(110, 'Jean Louis', 'Jean charles', 'jc@g.com', '200202020', 12, '12-02-2012', 'Strasbourg'),
(111, 'Luc', 'Jean', 'jl@g.com', '0202020202', 4, '30-06-2012', 'Rennes');

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
(106, 3150, 9, 0);

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
(106, 10);

-- --------------------------------------------------------

--
-- Structure de la table `congres`
--

CREATE TABLE `congres` (
  `idEvenement` int(11) NOT NULL,
  `dateDebutCongres` varchar(255) DEFAULT NULL,
  `dateFinCongres` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `congres`
--

INSERT INTO `congres` (`idEvenement`, `dateDebutCongres`, `dateFinCongres`) VALUES
(9, '12/12/1222', '12/12/1223');

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
(9, '7 rue de la picolere', 'ether'),
(10, '3 rue de la boustifaille', 'polyglycerine');

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
(104, 12000, 233, 1, 'nouveaunom', 'nouveaunom'),
(110, 4600, 543, 0, '0', '0'),
(111, 45000, 60, 1, '23-06-2012', '23-07-2034');

-- --------------------------------------------------------

--
-- Structure de la table `medecin_evenement`
--

CREATE TABLE `medecin_evenement` (
  `idMedecin` int(11) NOT NULL,
  `idEvenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin_evenement`
--

INSERT INTO `medecin_evenement` (`idMedecin`, `idEvenement`) VALUES
(104, 9);

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
(105, 10000, 2333, 1),
(107, 4500, 9, 0);

-- --------------------------------------------------------

--
-- Structure de la table `scientifique_unite`
--

CREATE TABLE `scientifique_unite` (
  `idScientifique` int(11) NOT NULL,
  `idUnite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `scientifique_unite`
--

INSERT INTO `scientifique_unite` (`idScientifique`, `idUnite`) VALUES
(105, 10);

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
(10, '12/12/3000', '12:00:00', '15:00:00');

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
  `dateResponsabilite` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `unite`
--

INSERT INTO `unite` (`id`, `nomUnite`, `numeroRue`, `nomRue`, `codePostal`, `villeUnite`, `dateResponsabilite`) VALUES
(10, 'Unity', '3', 'Pouettou', 22122, 'POUETTOU', '12/12/1221');

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
-- Index pour la table `scientifique_unite`
--
ALTER TABLE `scientifique_unite`
  ADD PRIMARY KEY (`idScientifique`,`idUnite`),
  ADD KEY `idUnite` (`idUnite`);

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
  MODIFY `numeroIdentification` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `unite`
--
ALTER TABLE `unite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
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
-- Contraintes pour la table `scientifique_unite`
--
ALTER TABLE `scientifique_unite`
  ADD CONSTRAINT `scientifique_unite_ibfk_1` FOREIGN KEY (`idUnite`) REFERENCES `unite` (`id`),
  ADD CONSTRAINT `scientifique_unite_ibfk_2` FOREIGN KEY (`idScientifique`) REFERENCES `scientifique` (`nIdentification`);

--
-- Contraintes pour la table `soiree`
--
ALTER TABLE `soiree`
  ADD CONSTRAINT `soiree_ibfk_1` FOREIGN KEY (`idEvenement`) REFERENCES `evenement` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
