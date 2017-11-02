delete from _eppdev_dict;
insert into _eppdev_dict(id,dict_type, code, label, remark, create_time, update_time, del_flag)
  values('c32691cd205f4475bff6fefdb5e88ceb', 'table_type', 0, 'EPPDEV元数据表', '开发过程中请勿删除，发布时无需保存', now(), now(), 0);
insert into _eppdev_dict(id,dict_type, code, label, remark, create_time, update_time, del_flag)
  values('e9e751db66464cc486510ad1ebeeeb5d', 'table_type', 200, '用户表', '开发时需要发布', now(), now(), 0);

insert into _eppdev_version(id, version_name, remark, create_time, update_time, del_flag)
  values('00000000000000000000000000000000', 'master', '主分支', now(), now(), 0);

insert into _eppdev_conf(id, conf_name, conf_value, remark, create_time, update_time, del_flag)
  values('0c827bc2b87343c3a09046862b5ff565', 'PACKAGE_NAME', 'cn.eppdev.test', '包名', now(), now(), 0);

insert into _eppdev_conf(id, conf_name, conf_value, remark, create_time, update_time, del_flag)
  values('37a102229071496eb83398e79f9acb83', 'WORK_SPACE_DIR', '/home/fan.hao', '开发工作目录地址', now(), now(), 0);

insert into _eppdev_conf(id, conf_name, conf_value, remark, create_time, update_time, del_flag)
  values('7d9f3beb9d414440ab148624d63c7824', 'PROJECT_NAME', 'test', '项目名称', now(), now(), 0);

insert into _eppdev_conf(id, conf_name, conf_value, remark, create_time, update_time, del_flag)
  values('a1e76c1791b446ca8acbbc55e7f9121f', 'AUTHOR_NAME', 'fan.hao', '用户名称，用于显示在注释中', now(), now(), 0);

insert into _eppdev_conf(id, conf_name, conf_value, remark, create_time, update_time, del_flag)
  values('4a9b7721506f4b34a0ab1e7620fc1b34', 'AUTHOR_EMAIL', 'fan.hao@eppdev.cn', '用户邮箱，用于显示在注释中', now(), now(), 0);