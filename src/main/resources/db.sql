CREATE DATABASE IF NOT EXISTS `fzu`;
USE `fzu`;
CREATE TABLE IF NOT EXISTS `Users` (
    `id` char(22) NOT NULL AUTO_INCREMENT,
    `qualification` boolean NOT NULL DEFAULT '0',
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `Users` (`id`)VALUES
    ('name1'), ('name2'), ('name3');