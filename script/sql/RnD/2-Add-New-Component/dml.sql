-- ADD NEW DATA -- START --

/* EMAIL TEMPLATE */
INSERT INTO `ntf_eml_tpl` (`eml_tpl_code`, `eml_html_body_spt`, `eml_sbj`, `sts_code`, `create_by`, `create_time`, `update_by`, `update_time`,  `sndr_eml`) VALUES
	('NTF_USR_ADD_EML', '<!DOCTYPE html>\r\n<html xmlns:th="http://www.thymeleaf.org">\r\n    <head>\r\n        <title th:remove="all">Template for HTML email</title>\r\n        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>\r\n    </head>\r\n    <body>\r\n	<div color:#1e1e1e;font-family:\'Open Sans\',Verdana,Arial,sans-serif;min-width:auto!important;font-size:16px;line-height:26px;text-align:center>\r\n                <p>\r\n			Hi <span th:text="${name}"></span>\r\n		</p>\r\n		<p>\r\n			Your login details are as follows :\r\n		</p>\r\n		<p>\r\n			Username : <strong><span th:text="${name}"></span></strong>\r\n		</p>\r\n		<p>\r\n			Password : <strong><span th:text="${password}"></span></strong>\r\n		</p>\r\n		<p>\r\n			Find your 2 Factor Authentication QRCode in attachment.\r\n		</p>               \r\n                <p style="color:red;">\r\n                        <strong>Confidential information, do not share with others. </strong>\r\n                </p>\r\n	</div>\r\n    </body>\r\n</html>', 'Welcome to <ApplicationName>', 'A', 'SYS', NULL, NULL, NULL, 'demo@development.atoz-software.tech')


-- ADD NEW DATA -- END --

-- ADD ROLE MENU -- START --
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`, `dept_check_strictly`, `status`, `del_flag`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2, 'company', 'company', 1, '1', 1, 1, '0', '0', NULL, 1, '2025-08-26 16:44:45', 1, '2025-09-04 15:14:13', '');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`, `dept_check_strictly`, `status`, `del_flag`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (3, 'merchant', 'merchant', 2, '1', 1, 1, '0', '0', NULL, 1, '2025-08-19 09:43:21', 1, '2025-08-26 16:45:11', '');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`, `dept_check_strictly`, `status`, `del_flag`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (4, 'leader', 'leader', 2, '1', 1, 1, '0', '0', NULL, 1, '2025-08-19 09:43:09', 1, '2025-09-04 16:37:17', '');
INSERT INTO `sys_role` (`role_id`, `role_name`, `role_key`, `role_sort`, `data_scope`, `menu_check_strictly`, `dept_check_strictly`, `status`, `del_flag`, `create_dept`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (999, 'subAcc', 'subAcc', 6, '1', 1, 1, '0', '0', 103, 1, '2025-07-17 09:28:38', 1, '2025-08-26 16:44:58', '');
-- ADD ROLE MENU -- END --

