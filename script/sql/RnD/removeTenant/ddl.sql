ALTER TABLE sys_user DROP COLUMN tenant_id;
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

DROP TABLE IF EXISTS `sys_tenant_package`;
DROP TABLE IF EXISTS `sys_tenant`;
