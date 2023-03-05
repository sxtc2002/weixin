CREATE TABLE if not exists Users
(
    `id` char(50) NOT NULL,
    `hit` int NOT NULL DEFAULT '0',
    `nick` char(50),
    `tel` char(50),
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE if not exists Administrators
(
    `id` char(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;