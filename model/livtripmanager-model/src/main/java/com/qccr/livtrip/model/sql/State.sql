-- auto Generated on 2017-04-03 16:07:59 
-- DROP TABLE IF EXISTS `state`; 
CREATE TABLE `state`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `type` INT (11) NOT NULL DEFAULT -1 COMMENT 'type',
    `status` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'status',
    `destination_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'destinationId',
    `provider` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'provider',
    `state_short` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'stateShort',
    `create_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createPerson',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updatePerson',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`state`';
