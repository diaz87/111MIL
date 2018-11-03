-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema 111MIL
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `111MIL` ;

-- -----------------------------------------------------
-- Schema 111MIL
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `111MIL` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `111MIL` ;

-- -----------------------------------------------------
-- Table `111MIL`.`Localidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Localidad` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Localidad` (
  `idLocalidad` INT NOT NULL AUTO_INCREMENT,
  `nivel` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `de` INT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idLocalidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`tipoDocumento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`tipoDocumento` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`tipoDocumento` (
  `idTipoDocumento` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idTipoDocumento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Persona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Persona` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `tipoDocumento` INT NOT NULL,
  `nroDocumento` VARCHAR(11) NOT NULL,
  `apellido` VARCHAR(25) NOT NULL,
  `nombre` VARCHAR(25) NOT NULL,
  `fechaNacimiento` DATE NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(60) NULL,
  `domicilio` VARCHAR(60) NULL,
  `localidad` INT NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPersona`),
  INDEX `localidadPersona_idx` (`localidad` ASC),
  INDEX `tipoDocumento_idx` (`tipoDocumento` ASC),
  CONSTRAINT `localidadPersona`
    FOREIGN KEY (`localidad`)
    REFERENCES `111MIL`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipoDocumento`
    FOREIGN KEY (`tipoDocumento`)
    REFERENCES `111MIL`.`tipoDocumento` (`idTipoDocumento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Alumno` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Alumno` (
  `idAlumno` INT NOT NULL AUTO_INCREMENT,
  `persona` INT NOT NULL,
  `fechaInscripcion` DATE NULL,
  `cohorte` INT NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idAlumno`),
  INDEX `personaAlumno_idx` (`persona` ASC),
  CONSTRAINT `personaAlumno`
    FOREIGN KEY (`persona`)
    REFERENCES `111MIL`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Sede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Sede` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Sede` (
  `idSede` INT NOT NULL AUTO_INCREMENT,
  `Localidad` INT NOT NULL,
  `Lugar` VARCHAR(50) NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idSede`),
  INDEX `localidad_idx` (`Localidad` ASC),
  CONSTRAINT `localidad`
    FOREIGN KEY (`Localidad`)
    REFERENCES `111MIL`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Titulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Titulo` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Titulo` (
  `idTitulo` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idTitulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Instructor` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Instructor` (
  `idInstructor` INT NOT NULL AUTO_INCREMENT,
  `persona` INT NOT NULL,
  `titulo` INT NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idInstructor`),
  INDEX `persona_idx` (`persona` ASC),
  INDEX `titulo_idx` (`titulo` ASC),
  CONSTRAINT `persona`
    FOREIGN KEY (`persona`)
    REFERENCES `111MIL`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `titulo`
    FOREIGN KEY (`titulo`)
    REFERENCES `111MIL`.`Titulo` (`idTitulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`SedeInstructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`SedeInstructor` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`SedeInstructor` (
  `idSedeInstructor` INT NOT NULL AUTO_INCREMENT,
  `sede` INT NOT NULL,
  `instructor` INT NOT NULL,
  `cohorte` INT NOT NULL,
  `desde` DATE NOT NULL,
  `hasta` DATE NOT NULL,
  PRIMARY KEY (`idSedeInstructor`),
  INDEX `sede_idx` (`sede` ASC),
  INDEX `instructor_idx` (`instructor` ASC),
  CONSTRAINT `sede`
    FOREIGN KEY (`sede`)
    REFERENCES `111MIL`.`Sede` (`idSede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `instructor`
    FOREIGN KEY (`instructor`)
    REFERENCES `111MIL`.`Instructor` (`idInstructor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Modulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Modulo` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Modulo` (
  `idModulo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idModulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`AlumnoModulo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`AlumnoModulo` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`AlumnoModulo` (
  `idAlumnoModulo` INT NOT NULL AUTO_INCREMENT,
  `alumno` INT NOT NULL,
  `modulo` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `nota` FLOAT NOT NULL,
  PRIMARY KEY (`idAlumnoModulo`),
  INDEX `alumno_idx` (`alumno` ASC),
  INDEX `modulo_idx` (`modulo` ASC),
  CONSTRAINT `alumno`
    FOREIGN KEY (`alumno`)
    REFERENCES `111MIL`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `modulo`
    FOREIGN KEY (`modulo`)
    REFERENCES `111MIL`.`Modulo` (`idModulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`Certificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`Certificacion` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`Certificacion` (
  `idCertificacion` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `sede` INT NOT NULL,
  `borrado` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idCertificacion`),
  INDEX `sedeCertificacion_idx` (`sede` ASC),
  CONSTRAINT `sedeCertificacion`
    FOREIGN KEY (`sede`)
    REFERENCES `111MIL`.`Sede` (`idSede`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `111MIL`.`AlumnoCertificacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `111MIL`.`AlumnoCertificacion` ;

CREATE TABLE IF NOT EXISTS `111MIL`.`AlumnoCertificacion` (
  `idAlumnoCertificacion` INT NOT NULL AUTO_INCREMENT,
  `alumno` INT NOT NULL,
  `certificacion` INT NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idAlumnoCertificacion`),
  INDEX `alumnoCertificacion_idx` (`alumno` ASC),
  INDEX `certificacionAlumno_idx` (`certificacion` ASC),
  CONSTRAINT `alumnoCertificacion`
    FOREIGN KEY (`alumno`)
    REFERENCES `111MIL`.`Alumno` (`idAlumno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `certificacionAlumno`
    FOREIGN KEY (`certificacion`)
    REFERENCES `111MIL`.`Certificacion` (`idCertificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
