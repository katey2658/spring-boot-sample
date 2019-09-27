# -- crm
CREATE TABLE IF NOT EXISTS `crm_customer`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name`           VARCHAR(16) NOT NULL COMMENT '名称',
  `name_en`        VARCHAR(32) NULL COMMENT '英文名称',
  `type`           INT(4)      NOT NULL DEFAULT 1 COMMENT '类型：1：客户 2：代理商 3：内广 4：其他',
  `source_type`    INT(4)      NOT NULL DEFAULT 1 COMMENT '来源：1：自建',
  `org_id`         BIGINT(20)  NOT NULL COMMENT '部门Id',
  `own_user_id`    BIGINT(20)  NOT NULL COMMENT '所属用户ID',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_crm_customer_nd` (`name`, `del_flag`),
  INDEX `idx_crm_customer_oid` (`org_id` ASC),
  INDEX `idx_crm_customer_t` (`type` ASC),
  INDEX `idx_crm_customer_st` (`source_type` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;


#  -- res
# res_platform
CREATE TABLE IF NOT EXISTS `res_platform`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name`           VARCHAR(16) NOT NULL COMMENT '名称',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_platform_nd` (`name`, `del_flag`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_page
CREATE TABLE IF NOT EXISTS `res_page`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name`           VARCHAR(16) NOT NULL COMMENT '名称',
  `platform_id`    BIGINT(20)  NOT NULL COMMENT '平台ID(关联res_platform）',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_page_npd` (`name`, `platform_id`, `del_flag`),
  INDEX `idx_res_page_pid` (`platform_id` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_position
CREATE TABLE IF NOT EXISTS `res_position`
(
  `id`             BIGINT(20)  NOT NULL COMMENT 'id',
  `name`           VARCHAR(16) NOT NULL COMMENT '名称',
  `platform_id`    BIGINT(20)  NOT NULL COMMENT '平台ID(关联res_platform）',
  `page_id`        BIGINT(20)  NULL COMMENT '页面ID(关联res_page）',
  `frame_num`      INT(4)      NOT NULL DEFAULT 1 COMMENT '帧数',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `status`         INT(2)      NOT NULL DEFAULT 1 COMMENT '状态 1：已上线 2：已下线',
  `level`          INT(4)      NOT NULL DEFAULT 1 COMMENT '资源等级：1：核心 2：普通 3： 尾部',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_position_npd` (`name`, `platform_id`, `del_flag`),
  INDEX `idx_res_position_pid` (`platform_id` ASC),
  INDEX `idx_res_position_s` (`status` ASC)
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF-8;

# res_panel
CREATE TABLE IF NOT EXISTS `res_panel`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `width`          INT(11)     NOT NULL COMMENT '宽：px',
  `height`         INT(11)     NOT NULL COMMENT '高: px',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_panel_wh` (`width`, `height`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_dict
CREATE TABLE IF NOT EXISTS `res_dict`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type`           INT(4)      NOT NULL COMMENT '类型： 1： 模板类型 2：广告标签 3：视频类型  4：音频类型  5: 图片类型',
  `data_id`        INT(11)     NOT NULL COMMENT 'id ',
  `data_name`      VARCHAR(32) NOT NULL COMMENT '名称',
  `remark`         VARCHAR(32) NULL COMMENT '备注',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_dict_tdd` (`type`, `data_id`, `del_flag`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_template
CREATE TABLE IF NOT EXISTS `res_template`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name`           VARCHAR(16) NOT NULL COMMENT '模板名称',
  `platform_id`    BIGINT(20)  NOT NULL COMMENT '平台ID(关联res_platform）',
  `status`         INT(2)      NOT NULL DEFAULT 1 COMMENT '状态 1：已上线 2：已下线',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_template_npd` (`name`, `platform_id`, `del_flag`),
  INDEX `idx_res_template_pid` (`platform_id` ASC),
  INDEX `idx_res_template_s` (`status` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;


# res_template_item
CREATE TABLE IF NOT EXISTS `res_template_item`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `template_id`    BIGINT(20)  NOT NULL COMMENT '平台ID(关联res_template）',
  `parent_id`      BIGINT(20)  NOT NULL DEFAULT 0 COMMENT '父级项ID 一级别为0',
  `item_key`       VARCHAR(32) NOT NULL COMMENT '配置项key',
  `item_name`      VARCHAR(32) NOT NULL COMMENT '配置项名称',
  `item_title`     VARCHAR(32) NOT NULL COMMENT '配置项标题',
  `item_type`      INT(4)      NOT NULL COMMENT '配置类型 1：picture  2：url 3:string 4: video 5: audio 6: obj 7:group 8:constant 9: enum',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `idx_res_template_pid` (`platform_id` ASC),
  INDEX `idx_res_template_s` (`status` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_template_item_rule
CREATE TABLE IF NOT EXISTS `res_template_item_rule`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `template_id`    BIGINT(20)  NOT NULL COMMENT '平台ID(关联res_template）',
  `item_key`       BIGINT(20)  NOT NULL COMMENT '配置项key',
  `rule_type`      INT(4)      NOT NULL COMMENT '规则类型： 1 图片尺寸 2：视频类型 3：音频类型  4： 文件大小 5： 文本长度',
  `rule_value`     VARCHAR(32) NOT NULL COMMENT '规则值',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `idx_res_template_item_rule_tid` (`template_id` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_production
CREATE TABLE IF NOT EXISTS `res_production`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name`           VARCHAR(32) NOT NULL COMMENT '产品名称',
  `position_id`    BIGINT(20)  NOT NULL COMMENT '产品ID',
  `unit_type`      INT(4)      NOT NULL DEFAULT 1 COMMENT '售卖单元 1：天/请求 2：千次/请求 2：千次/曝光 3：千次/点击',
  `type`           INT(4)      NOT NULL DEFAULT 1 COMMENT '预定类型：1：售卖 ；2: 补量；4：配送 （相加数为多选）',
  `price`          INT(11)     NOT NULL COMMENT '价格：元',
  `status`         INT(4)      NOT NULL DEFAULT 1 COMMENT '状态 1： 正常 2：已下线',
  `del_flag`       INT(2)      NOT NULL DEFAULT 1 COMMENT '是否删除 1：正常 -1: 已删除',
  `update_user_id` BIGINT(20)  NOT NULL COMMENT '更新者用户Id',
  `update_time`    BIGINT(13)  NOT NULL COMMENT '更新时间',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `idx_res_production_pid` (`platform_id` ASC),
  INDEX `idx_res_production_ut` (`unit_type` ASC),
  INDEX `idx_res_production_t` (`type` ASC),
  INDEX `idx_res_production_s` (`status` ASC)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# res_production_template
CREATE TABLE IF NOT EXISTS `res_production_template`
(
  `id`             BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT 'id',
  `production_id`    BIGINT(20)  NOT NULL COMMENT '产品ID',
  `template_id`      INT(4)      NOT NULL DEFAULT 1 COMMENT '售卖单元 1：天/请求 2：千次/请求 2：千次/曝光 3：千次/点击',
  `create_user_id` BIGINT(20)  NOT NULL COMMENT '创建者用户Id',
  `create_time`    BIGINT(13)  NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE `idx_un_res_production_template_pt` (`production_id`, `template_id` )
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = UTF-8;

# -- po 要有一个执行度 订单追加 为追加订单

# -- cpd 询位 占位 清位
plan_cpd
plan_date
plan_rule_area
plan_rule_app
plan_rule_tag

material
material_item



# -- stat
stat_plan
stat_report











