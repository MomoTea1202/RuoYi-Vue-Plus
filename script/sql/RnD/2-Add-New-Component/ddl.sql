-- ADD NEW COLUMN -- START --

ALTER TABLE sys_user
  ADD COLUMN upline_id BIGINT NULL DEFAULT NULL,
  ADD COLUMN sba_id    BIGINT NULL DEFAULT NULL,
  ADD COLUMN cpy_id    BIGINT NULL DEFAULT NULL,
  ADD COLUMN is_sub TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'is sub account'
  ADD COLUMN `google_secret` VARCHAR(32) NULL DEFAULT NULL COMMENT '用户TOTP密钥' COLLATE utf8mb4_0900_ai_ci,
  ADD COLUMN is_sfa TINYINT(1) NOT NULL DEFAULT 1 COMMENT '2FA enabled';

-- ADD NEW COLUMN -- END --

-- ADD NEW TABLE -- START --

CREATE TABLE IF NOT EXISTS `each_usr_perm` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `menu_id` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `perm_list` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tenant_id` varchar(20) DEFAULT '000000' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `ntf_eml_tpl` (
  `eml_tpl_code` varchar(50) NOT NULL COMMENT 'Email Template Code',
  `eml_html_body_spt` mediumtext NOT NULL COMMENT 'Email Html Body Script',
  `eml_sbj` varchar(100) NOT NULL COMMENT 'Email Subject',
  `sts_code` varchar(50) DEFAULT NULL COMMENT 'Status Code',
  `create_by` varchar(50) DEFAULT NULL COMMENT 'Create By',
  `create_time` datetime DEFAULT NULL COMMENT 'Create Date',
  `update_by` varchar(50) DEFAULT NULL COMMENT 'Update By',
  `update_time` datetime DEFAULT NULL COMMENT 'Update Date',
  `sndr_eml` varchar(100) DEFAULT NULL COMMENT 'Sender Email',
  PRIMARY KEY (`eml_tpl_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='Notification Email Template';

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

-- ADD NEW TABLE -- END --
