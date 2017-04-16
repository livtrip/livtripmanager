-- auto Generated on 2017-04-09 16:47:05 
-- DROP TABLE IF EXISTS `liv_city_location`; 
CREATE TABLE `liv_city_location`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `location` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'location',
    `destination_code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'destinationCode',
    `destination_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'destinationId',
    `type` INT (11) NOT NULL DEFAULT -1 COMMENT 'type',
    `city_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'cityId',
    `city_destination_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'cityDestinationId',
    `city` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'city',
    `status` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'status',
    `provider` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'provider',
    `create_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createPerson',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updatePerson',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`liv_city_location`';
