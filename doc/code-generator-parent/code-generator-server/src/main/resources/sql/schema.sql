-- 建表语句

CREATE TABLE t_codegen_tpl (
tpl_id BIGINT auto_increment PRIMARY KEY NOT NULL,
group_id int DEFAULT NULL,
title varchar(255) DEFAULT NULL,
content CLOB DEFAULT NULL,
suffix varchar(255) DEFAULT NULL,
create_by int DEFAULT NULL,
update_by int DEFAULT NULL,
create_time varchar DEFAULT NULL,
update_time varchar DEFAULT NULL
);

CREATE TABLE t_codegen_tpl_group (
  group_id BIGINT auto_increment PRIMARY KEY NOT NULL,
  group_name varchar(255) DEFAULT NULL,
  access varchar(255) DEFAULT NULL,
  remark varchar(255) DEFAULT NULL,
  create_by int DEFAULT NULL,
  update_by int DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL
);


CREATE TABLE t_db_source(
  id BIGINT auto_increment PRIMARY KEY NOT NULL,
  connection_name varchar(100) not null,
  db_type varchar(20) not null,
  driver_name varchar(100) not null,
  schema_name varchar(50),
  username varchar(100) not null,
  password varchar(64) not null,
  url varchar(200) not null
);