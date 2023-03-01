CREATE TABLE if not exists User
(
    `id` char(50) NOT NULL,
    `join` boolean NOT NULL DEFAULT '0',
    `hit` int NOT NULL DEFAULT '0',
    `nick` char(50),
    `tel` char(50),
    `createdAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE if not exists Administrator
(
    `id` char(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;