/* ====================================================== */
/* Schema                                                 */
/* ====================================================== */
DROP SCHEMA IF EXISTS connectocean;
DROP USER IF EXISTS 'connectocean'@'localhost';
CREATE USER IF NOT EXISTS 'connectocean'@'localhost' Identified By 'welcome';
CREATE DATABASE connectocean;
GRANT USAGE on connectocean.* TO 'connectocean'@'localhost';
GRANT ALL PRIVILEGES ON connectocean.* TO 'connectocean'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

/* ====================================================== */
/* Tables                                                 */
/* ====================================================== */
USE connectocean;
CREATE TABLE Books (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL
);

/* ====================================================== */
/* Data Load                                              */
/* ====================================================== */
INSERT INTO Books (Title, Author) VALUES ('The Great Gatsby','F. Scott Fitzgerald');
INSERT INTO Books (Title, Author) VALUES ('To Kill a Mockingbird','Harper Lee');
INSERT INTO Books (Title, Author) VALUES ('Pride and Prejudice','Jane Austen');
INSERT INTO Books (Title, Author) VALUES ('Gitanjali','Rabindranath Tagore');