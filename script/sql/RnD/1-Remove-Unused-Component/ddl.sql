-- REMOVE UNUSED TABLE -- START --

DROP TABLE IF EXISTS `sys_tenant_package`;
DROP TABLE IF EXISTS `sys_tenant`;
DROP TABLE IF EXISTS `sys_user_post`;
DROP TABLE IF EXISTS `sys_role_dept`;
DROP TABLE IF EXISTS `sys_post`;
DROP TABLE IF EXISTS `sys_dept`;
DROP TABLE IF EXISTS `sj_workflow`;
DROP TABLE IF EXISTS `sj_workflow_node`;
DROP TABLE IF EXISTS `sj_workflow_task_batch`;

-- REMOVE UNUSED TABLE -- END --

-- REMOVE UNUSED COLUMN -- START --

ALTER TABLE sys_user
  DROP COLUMN dept_id,
  DROP COLUMN create_dept,
  DROP COLUMN tenant_id;
ALTER TABLE sys_role DROP COLUMN tenant_id;
ALTER TABLE sys_oss_config DROP COLUMN tenant_id;
ALTER TABLE sys_oss DROP COLUMN tenant_id;
ALTER TABLE sys_oper_log DROP COLUMN tenant_id;
ALTER TABLE sys_notice DROP COLUMN tenant_id;
ALTER TABLE sys_logininfor DROP COLUMN tenant_id;
ALTER TABLE sys_dict_type DROP COLUMN tenant_id;
ALTER TABLE sys_dict_data DROP COLUMN tenant_id;
ALTER TABLE sys_config DROP COLUMN tenant_id;
ALTER TABLE each_usr_perm DROP COLUMN tenant_id;

-- REMOVE UNUSED COLUMN -- END --

