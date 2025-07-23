
create table sub_acc_usr_perm
(
    id                 bigint           not null        ,
    user_name          varchar(30)      not null        ,
    menu_id            varchar(255)
    PRIMARY KEY (id)
) engine=innodb;

ALTER TABLE sys_user
ADD COLUMN parent_id VARCHAR(50);


CREATE TABLE IF NOT EXISTS `each_usr_perm` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `menu_id` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `perm_list` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tenant_id` varchar(20) DEFAULT '000000' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
