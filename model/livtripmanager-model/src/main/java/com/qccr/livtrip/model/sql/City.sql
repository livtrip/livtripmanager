-- auto Generated on 2017-04-04 12:34:49 
-- DROP TABLE IF EXISTS `liv_city`; 
CREATE TABLE `liv_city`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `type` INT (11) NOT NULL DEFAULT -1 COMMENT 'type',
    `state_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'stateId',
    `provider` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'provider',
    `destination_code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'destinationCode',
    `latitude` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'latitude',
    `longitude` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'longitude',
    `create_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createPerson',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updatePerson',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`liv_city`';
