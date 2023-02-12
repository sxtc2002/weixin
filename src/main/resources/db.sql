CREATE TABLE IF NOT EXISTS `Users` (
    `id` char(50) NOT NULL,
    `qualification` boolean NOT NULL DEFAULT '0',
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `Users` (`id`)VALUES
    ('name1'), ('name2'), ('name3');