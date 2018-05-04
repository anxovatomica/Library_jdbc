-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 20-04-2018 a les 20:18:07
-- Versió del servidor: 10.1.30-MariaDB
-- Versió de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `Biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `Libros`
--

CREATE TABLE `Book` (
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `release_date` datetime NOT NULL,
  `isbn` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de la taula `Loans`
--

CREATE TABLE `Loans` (
  `retirement_date` datetime NOT NULL,
  `deliver_date` datetime NOT NULL,
  `isbn` varchar(50) NOT NULL,
  `id_loan` int(10) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de la taula `Partners`
--

CREATE TABLE `Partners` (
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexos per taules bolcades
--

--
-- Index de la taula `Libros`
--
ALTER TABLE `Book`
  ADD PRIMARY KEY (`isbn`);

--
-- Index de la taula `Loans`
--
ALTER TABLE `Loans`
  ADD PRIMARY KEY (`id_loan`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `isbn` (`isbn`),
  ADD KEY `id_loan` (`id_loan`);

--
-- Index de la taula `Partners`
--
ALTER TABLE `Partners`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `Loans`
--
ALTER TABLE `Loans`
  MODIFY `id_loan` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
