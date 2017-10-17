delete from _eppdev_dict;
insert into _eppdev_dict(id,dict_type, code, label, remark, create_time, update_time, del_flag)
  values('c32691cd205f4475bff6fefdb5e88ceb', 'table_type', 0, 'EPPDEV元数据表', '开发过程中请勿删除，发布时无需保存', now(), now(), 0);
insert into _eppdev_dict(id,dict_type, code, label, remark, create_time, update_time, del_flag)
  values('e9e751db66464cc486510ad1ebeeeb5d', 'table_type', 200, '用户表', '开发时需要发布', now(), now(), 0);

insert into _eppdev_version(id, version_name, remark, create_time, update_time, del_flag)
  values('00000000000000000000000000000000', 'master', '主分支', now(), now(), 0);