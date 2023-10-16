-- Active: 1690187501150@@127.0.0.1@3306@goldenticket
DELIMITER //
CREATE TRIGGER aggiungi_data_acquisto
BEFORE INSERT ON acquisti
FOR EACH ROW
BEGIN
    SET NEW.data_acquisto = CURDATE();
END;
//
DELIMITER ;