CREATE TABLE `sys_locale` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`locale` VARCHAR(10) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`code` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`value` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
