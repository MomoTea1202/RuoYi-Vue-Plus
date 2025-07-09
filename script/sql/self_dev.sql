
create table sub_acc_usr_perm
(
    id                 bigint           not null        ,
    user_name          varchar(30)      not null        ,
    menu_id            varchar(255)
    PRIMARY KEY (id)
) engine=innodb;

ALTER TABLE sys_user
ADD COLUMN parent_id VARCHAR(50);
