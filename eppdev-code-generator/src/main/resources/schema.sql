create table if not exists _eppdev_version
(
  id char(32) comment 'UUID, 唯一标识',
  version_name varchar(255) comment '版本名称',
  remark varchar(255) comment '版本说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '版本信息';

create table if not exists _eppdev_dict
(
  id char(32) comment 'UUID, 唯一标识',
  dict_type varchar(255) comment '编码类型',
  code integer comment 'code值',
  label varchar(255) comment '编码对应的标签',
  remark varchar(255) comment '说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '版本信息';

create table if not exists _eppdev_table
(
  id char(32) comment 'UUID,唯一标识',
  table_name varchar(255) comment '表名',
  table_comment varchar(255) comment '表说明',
  module_name varchar(255) comment '模块名称',
  entity_name varchar(255) comment '对应的实体名称',
  table_type integer comment '库表类型',
  version_id char(32) comment '对应的版本id',
  create_sql longtext comment '创建语句',
  origin_table_id char(32) comment 'master下的表ID',
  remark varchar(255) comment '说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '表信息';

create table if not exists _eppdev_column(
  id char(32) comment 'UUID，唯一标识',
  table_id char(32) comment '所在表的id',
  column_name varchar(255) comment '列名称',
  column_type varchar(20) comment '字段类型',
  column_length integer comment '字段长度',
  column_comment varchar(255) comment '字段说明',
  sort_index integer comment '查询序号',
  primary_key bit comment '是否主键',
  property_name varchar(255) comment '对应的Java属性名称',
  java_type varchar(50) comment '对应的Java类',
  origin_column_id char(32) comment 'master下的列id',
  remark varchar(255) comment '说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '列信息';

create table if not exists _eppdev_index(
  id char(32) comment 'UUID，唯一标识',
  table_id char(32) comment '表名',
  index_name varchar(255) comment '索引名称',
  column_names varchar(255) comment '索引所有的列',
  remark varchar(255) comment '说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '索引信息';


create table if not exists _eppdev_conf(
  id char(32) comment 'UUID, 唯一标识',
  conf_name varchar(50) comment '配置项目名称',
  conf_value  varchar(255) comment '配置内容',
  remark varchar(255) comment '说明',
  create_time datetime comment '创建时间',
  update_time datetime comment '修改时间',
  del_flag integer comment '删除标识',
  primary key(id)
) comment '创建配置信息';