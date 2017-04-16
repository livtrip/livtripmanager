-- auto Generated on 2017-04-16 15:03:09 
-- DROP TABLE IF EXISTS `job_task_log`; 
CREATE TABLE `job_task_log`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `task_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'taskId',
    `state` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'state',
    `remark` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'remark',
    `create_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createPerson',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updatePerson',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`job_task_log`';
