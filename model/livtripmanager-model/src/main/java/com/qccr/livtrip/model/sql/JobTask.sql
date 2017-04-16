-- auto Generated on 2017-04-15 16:27:29 
-- DROP TABLE IF EXISTS `job_task`; 
CREATE TABLE `job_task`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `task_code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'taskCode',
    `task_type` INT (11) NOT NULL DEFAULT -1 COMMENT 'taskType',
    `task_impl_task` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'taskImplTask',
    `task_express` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'taskExpress',
    `state` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'state',
    `params` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'params',
    `remark` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'remark',
    `create_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'createPerson',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    `update_person` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'updatePerson',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'updateTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`job_task`';
