-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mexotictours
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mexotictours
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mexotictours` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `mexotictours` ;

-- -----------------------------------------------------
-- Table `mexotictours`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `telefono` CHAR(10) NOT NULL,
  `contrasena` VARCHAR(50) NOT NULL,
  `admin` TINYINT NOT NULL,
  `imgUsuario` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Tour` (
  `idTour` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `estado` ENUM('CDMX', 'EDOMEX', 'Jalisco', 'Queretaro') NOT NULL,
  `ciudad` VARCHAR(45) NOT NULL,
  `imgPortada` VARCHAR(150) NOT NULL,
  `img` VARCHAR(150) NOT NULL,
  `descripcion` VARCHAR(600) NOT NULL,
  `duracion` VARCHAR(45) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `precioExclusivo` DOUBLE NOT NULL,
  `incluye` VARCHAR(800) NOT NULL,
  `categoria` ENUM('Fiesta', 'Cultura', 'Arte', 'Gastronomia') NOT NULL,
  PRIMARY KEY (`idTour`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`InformacionTour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`InformacionTour` (
  `idInformacionTour` INT NOT NULL AUTO_INCREMENT,
  `salida` VARCHAR(45) NOT NULL,
  `regresoAprox` VARCHAR(45) NOT NULL,
  `frecuencia` VARCHAR(500) NOT NULL,
  `grupos` VARCHAR(500) NOT NULL,
  `fk_idTour` INT NOT NULL,
  PRIMARY KEY (`idInformacionTour`),
  INDEX `fk_InformacionTour_Tours1_idx` (`fk_idTour` ASC) VISIBLE,
  CONSTRAINT `fk_InformacionTour_Tour1`
    FOREIGN KEY (`fk_idTour`)
    REFERENCES `mexotictours`.`Tour` (`idTour`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `fk_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Reserva_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexotictours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `monto` DOUBLE NOT NULL,
  `fechaPago` DATETIME NOT NULL,
  `metodoPago` ENUM('Tarjeta Credito', 'Comisionista', 'Transferencia') NOT NULL,
  `fk_idReserva` INT NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_Pago_Reserva1_idx` (`fk_idReserva` ASC) VISIBLE,
  CONSTRAINT `fk_Pago_Reserva1`
    FOREIGN KEY (`fk_idReserva`)
    REFERENCES `mexotictours`.`Reserva` (`idReserva`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Experiencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Experiencia` (
  `idExperiencia` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(500) NOT NULL,
  `calificacion` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `fk_idTour` INT NOT NULL,
  `fk_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idExperiencia`),
  INDEX `fk_Experiencia_Tours1_idx` (`fk_idTour` ASC) VISIBLE,
  INDEX `fk_Experiencia_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Experiencia_Tour1`
    FOREIGN KEY (`fk_idTour`)
    REFERENCES `mexotictours`.`Tour` (`idTour`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Experiencia_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexotictours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Usuario_has_Tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Usuario_has_Tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fk_idUsuario` INT NOT NULL,
  `fk_idTour` INT NOT NULL,
  INDEX `fk_Usuario_has_Tours_Tours1_idx` (`fk_idTour` ASC) VISIBLE,
  INDEX `fk_Usuario_has_Tours_Usuario1_idx` (`fk_idUsuario` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Usuario_has_Tour_Usuario1`
    FOREIGN KEY (`fk_idUsuario`)
    REFERENCES `mexotictours`.`Usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Usuario_has_Tour_Tour1`
    FOREIGN KEY (`fk_idTour`)
    REFERENCES `mexotictours`.`Tour` (`idTour`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mexotictours`.`Reserva_has_Tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mexotictours`.`Reserva_has_Tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `fk_idReserva` INT NOT NULL,
  `fk_idTour` INT NOT NULL,
  INDEX `fk_Reserva_has_Tours_Tours1_idx` (`fk_idTour` ASC) VISIBLE,
  INDEX `fk_Reserva_has_Tours_Reserva1_idx` (`fk_idReserva` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Reserva_has_Tour_Reserva1`
    FOREIGN KEY (`fk_idReserva`)
    REFERENCES `mexotictours`.`Reserva` (`idReserva`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Reserva_has_Tour_Tour1`
    FOREIGN KEY (`fk_idTour`)
    REFERENCES `mexotictours`.`Tour` (`idTour`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
