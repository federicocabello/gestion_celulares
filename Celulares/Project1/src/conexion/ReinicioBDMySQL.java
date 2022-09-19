package conexion;


import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

public class ReinicioBDMySQL {
    public ReinicioBDMySQL() {
            super();
            }
            private String ultimoMensajeMySQL="";

            public String reinicioBD(String msgsql) {
            try {
            Statement st = Conexion.getConexion().createStatement();
            st.executeUpdate("SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;");
            st.executeUpdate("SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;");
            st.executeUpdate("SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';");
                st.executeUpdate("CREATE SCHEMA IF NOT EXISTS `celulares` DEFAULT CHARACTER SET utf8 ;");            
                st.executeUpdate("DROP DATABASE `celulares`;");
                st.executeUpdate("CREATE SCHEMA IF NOT EXISTS `celulares` DEFAULT CHARACTER SET utf8 ;");            
                st.executeUpdate("USE `celulares` ;");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS `celulares`.`cliente` (  `dni` INT(8) UNSIGNED ZEROFILL NOT NULL,  `nombre_cliente` VARCHAR(30) NULL DEFAULT NULL,  `apellido_cliente` VARCHAR(30) NOT NULL,  `domicilio_cliente` VARCHAR(45) NULL DEFAULT NULL,  `email_cliente` VARCHAR(45) NULL DEFAULT NULL,  `telefono_cliente` INT UNSIGNED NULL DEFAULT NULL,  PRIMARY KEY (`dni`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;");            
                st.executeUpdate("CREATE TABLE IF NOT EXISTS `celulares`.`estado` (  `idestado` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,  `descripcion` VARCHAR(45) NOT NULL,  PRIMARY KEY (`idestado`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;");
                st.executeUpdate("INSERT INTO `celulares`.`estado` (`idestado`,`descripcion`) VALUES (0,'CLIENTE BORRADO');");
                st.executeUpdate("UPDATE `celulares`.`estado` SET `idestado`=0 WHERE `idestado`=1;");            
                st.executeUpdate("ALTER TABLE `celulares`.`estado` AUTO_INCREMENT=1;");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS `celulares`.`tecnico` (  `idtecnico` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,  `nombre_tecnico` VARCHAR(45) NOT NULL,  `apellido_tecnico` VARCHAR(45) NOT NULL,  `email_tecnico` VARCHAR(45) NOT NULL,  `telefono_tecnico` INT UNSIGNED NOT NULL,  PRIMARY KEY (`idtecnico`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;");            
                st.executeUpdate("CREATE TABLE IF NOT EXISTS `celulares`.`celulares` (`registro` TINYINT NOT NULL AUTO_INCREMENT,  `marca` VARCHAR(30) NOT NULL,  `modelo` VARCHAR(30) NOT NULL,  `problema` VARCHAR(64) NOT NULL,  `fechaingreso` DATE NOT NULL,  `dni_cliente` INT UNSIGNED NOT NULL,  `idtecnico` TINYINT UNSIGNED NOT NULL,  `estado` TINYINT UNSIGNED NOT NULL,  `monto` DECIMAL(7,2) UNSIGNED NULL DEFAULT NULL,  `fechaentrega` DATE NOT NULL,  PRIMARY KEY (`registro`),  CONSTRAINT `fk_cliente`    FOREIGN KEY (`dni_cliente`)    REFERENCES `celulares`.`cliente` (`dni`),  CONSTRAINT `fk_estado`    FOREIGN KEY (`estado`)    REFERENCES `celulares`.`estado` (`idestado`),  CONSTRAINT `fk_tecnico`    FOREIGN KEY (`idtecnico`)    REFERENCES `celulares`.`tecnico` (`idtecnico`)) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb3;");
                st.executeUpdate("CREATE INDEX `fk_cliente` ON `celulares`.`celulares` (`dni_cliente` ASC) VISIBLE;");
                st.executeUpdate("CREATE INDEX `fk_tecnico` ON `celulares`.`celulares` (`idtecnico` ASC) VISIBLE;");            
                st.executeUpdate("CREATE INDEX `fk_estado` ON `celulares`.`celulares` (`estado` ASC) VISIBLE;");
                st.executeUpdate("SET SQL_MODE=@OLD_SQL_MODE;");            
                st.executeUpdate("SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;");
                st.executeUpdate("SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;");
            ultimoMensajeMySQL="Reinicio del sistema exitoso!.\nEl sistema se apagará.";
                JOptionPane.showMessageDialog(null, ultimoMensajeMySQL);
                System.exit(0);
            } catch (SQLException e) {
            ultimoMensajeMySQL="Error: " + e.getMessage();
                JOptionPane.showMessageDialog(null, ultimoMensajeMySQL);
            }
            return ultimoMensajeMySQL;
            }
            }
