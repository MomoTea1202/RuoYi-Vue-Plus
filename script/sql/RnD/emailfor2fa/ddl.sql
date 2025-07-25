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
