-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mexoticTours
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mexoticTours
-- -----------------------------------------------------
CREATE DATABASE `mexoticTours` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `mexoticTours` ;

-- -----------------------------------------------------
-- Table `mexoticTours`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `telefono` CHAR(10) NOT NULL,
  `contrasena` VARCHAR(50) NOT NULL,
  `checkTyC` TINYINT NOT NULL,
  `admin` TINYINT NOT NULL,
  `imgUsuario` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Tours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Tours` (
  `idTours` INT NOT NULL AUTO_INCREMENT,
  `ciudad` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `img_portada` VARCHAR(150) NOT NULL,
  `img` VARCHAR(150) NOT NULL,
  `descripcion` VARCHAR(600) NOT NULL,
  `duracion` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `precioExclusivo` VARCHAR(45) NOT NULL,
  `incluye` TEXT NOT NULL,
  `categoria` ENUM('Fiesta', 'Cultura', 'Arte', 'Gastronomia') NOT NULL,
  `estado` ENUM('CDMX', 'EDOMEX', 'Jalisco', 'Queretaro') NOT NULL,
  PRIMARY KEY (`idTours`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`InformacionTour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`InformacionTour` (
  `idInformacionTour` INT NOT NULL AUTO_INCREMENT,
  `salida` VARCHAR(45) NOT NULL,
  `regresoAprox` VARCHAR(45) NOT NULL,
  `frecuencia` VARCHAR(500) NOT NULL,
  `grupos` VARCHAR(500) NOT NULL,
  `fk_idTours` INT NOT NULL,
  PRIMARY KEY (`idInformacionTour`),
  INDEX `fk_InformacionTour_Tours1_idx` (`fk_idTours` ASC) VISIBLE,
  CONSTRAINT `fk_InformacionTour_Tours1`
    FOREIGN KEY (`fk_idTours`)
    REFERENCES `mexoticTours`.`Tours` (`idTours`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `monto` INT NOT NULL,
  `fechaPago` DATETIME NOT NULL,
  `metodoPago` ENUM('Tarjeta Credito', 'Comisionista', 'Transferencia') NOT NULL,
  PRIMARY KEY (`idPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Experiencia` (
  `idExperiencia` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(500) NOT NULL,
  `calificacion` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `fk_idTours` INT NOT NULL,
  `fk_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idExperiencia`),
  INDEX `fk_Experiencia_Tours1_idx` (`fk_idTours` ASC) VISIBLE,
  INDEX `fk_Experiencia_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Tours1`
    FOREIGN KEY (`fk_idTours`)
    REFERENCES `mexoticTours`.`Tours` (`idTours`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Experiencia_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexoticTours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `fk_idPago` INT NOT NULL,
  `fk_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Pago1_idx` (`fk_idPago` ASC) VISIBLE,
  INDEX `fk_Reserva_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Pago1`
    FOREIGN KEY (`fk_idPago`)
    REFERENCES `mexoticTours`.`Pago` (`idPago`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexoticTours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Usuario_has_Tours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Usuario_has_Tours` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_idUsuario` INT NOT NULL,
  `fk_idTours` INT NOT NULL,
  INDEX `fk_Usuario_has_Tours_Tours1_idx` (`fk_idTours` ASC) VISIBLE,
  INDEX `fk_Usuario_has_Tours_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Usuario_has_Tours_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexoticTours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Usuario_has_Tours_Tours1`
    FOREIGN KEY (`fk_idTours`)
    REFERENCES `mexoticTours`.`Tours` (`idTours`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexoticTours`.`Reserva_has_Tours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexoticTours`.`Reserva_has_Tours` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `fk_idReserva` INT NOT NULL,
  `fk_idTours` INT NOT NULL,
  INDEX `fk_Reserva_has_Tours_Tours1_idx` (`fk_idTours` ASC) VISIBLE,
  INDEX `fk_Reserva_has_Tours_Reserva1_idx` (`fk_idReserva` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Reserva_has_Tours_Reserva1`
    FOREIGN KEY (`fk_idReserva`)
    REFERENCES `mexoticTours`.`Reserva` (`idReserva`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_has_Tours_Tours1`
    FOREIGN KEY (`fk_idTours`)
    REFERENCES `mexoticTours`.`Tours` (`idTours`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
