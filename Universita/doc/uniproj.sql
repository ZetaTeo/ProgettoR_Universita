-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 27, 2025 alle 15:13
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uniproj`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `dipartimento`
--

CREATE TABLE `dipartimento` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `docente`
--

CREATE TABLE `docente` (
  `id` int(11) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `dipartimento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `esame`
--

CREATE TABLE `esame` (
  `data` date NOT NULL,
  `bocciature` int(11) NOT NULL,
  `voto` int(11) NOT NULL,
  `studente_id` int(11) NOT NULL,
  `materia_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `materia`
--

CREATE TABLE `materia` (
  `id` int(11) NOT NULL,
  `anno` smallint(6) NOT NULL,
  `cfu` smallint(6) NOT NULL,
  `nome_materia` varchar(255) NOT NULL,
  `dipartimento_id` int(11) NOT NULL,
  `docente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `studente`
--

CREATE TABLE `studente` (
  `id` int(11) NOT NULL,
  `cfu_totali` int(11) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `corso_di_laurea` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `matricola` varchar(10) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `dipartimento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `dipartimento`
--
ALTER TABLE `dipartimento`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKdkcpb39icu3hibapiawkh2s2y` (`nome`);

--
-- Indici per le tabelle `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcjaekp5lnot6c6dokjntmexhj` (`email`),
  ADD KEY `FKionujxyl5gy5l7esx0760b1u5` (`dipartimento_id`);

--
-- Indici per le tabelle `esame`
--
ALTER TABLE `esame`
  ADD PRIMARY KEY (`data`,`materia_id`,`studente_id`),
  ADD KEY `FK93fwr31k65jhh6h6okrmlbovx` (`materia_id`),
  ADD KEY `FK9thaco9i1vtvblr36htjh46a3` (`studente_id`);

--
-- Indici per le tabelle `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk0bsdeodcwl13m6vkkox0v794` (`dipartimento_id`),
  ADD KEY `FKjpm7iqo7yjybgdl1ych6sqr8f` (`docente_id`);

--
-- Indici per le tabelle `studente`
--
ALTER TABLE `studente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKjvhrcboopjnmp9phipk9x9l6r` (`email`),
  ADD UNIQUE KEY `matricola` (`matricola`),
  ADD KEY `FK742ygxfxtssh1gfcr0hrusqa5` (`dipartimento_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `dipartimento`
--
ALTER TABLE `dipartimento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `docente`
--
ALTER TABLE `docente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `materia`
--
ALTER TABLE `materia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `docente`
--
ALTER TABLE `docente`
  ADD CONSTRAINT `FKionujxyl5gy5l7esx0760b1u5` FOREIGN KEY (`dipartimento_id`) REFERENCES `dipartimento` (`id`);

--
-- Limiti per la tabella `esame`
--
ALTER TABLE `esame`
  ADD CONSTRAINT `FK93fwr31k65jhh6h6okrmlbovx` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
  ADD CONSTRAINT `FK9thaco9i1vtvblr36htjh46a3` FOREIGN KEY (`studente_id`) REFERENCES `studente` (`id`);

--
-- Limiti per la tabella `materia`
--
ALTER TABLE `materia`
  ADD CONSTRAINT `FKjpm7iqo7yjybgdl1ych6sqr8f` FOREIGN KEY (`docente_id`) REFERENCES `docente` (`id`),
  ADD CONSTRAINT `FKk0bsdeodcwl13m6vkkox0v794` FOREIGN KEY (`dipartimento_id`) REFERENCES `dipartimento` (`id`);

--
-- Limiti per la tabella `studente`
--
ALTER TABLE `studente`
  ADD CONSTRAINT `FK742ygxfxtssh1gfcr0hrusqa5` FOREIGN KEY (`dipartimento_id`) REFERENCES `dipartimento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
