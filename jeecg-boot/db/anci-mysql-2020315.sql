-- ----------------------------
-- Table structure for 公司表
-- ----------------------------
DROP TABLE IF EXISTS `anci_company`;
CREATE TABLE `anci_company` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `zh_name` varchar(50) default NULL COMMENT '中文名',
  `en_name` varchar(50) default NULL COMMENT '英文名',
  `address` varchar(255) default NULL COMMENT '地址',
  `telephone` varchar(50) default NULL COMMENT '联系电话',
  `email` varchar(50) default NULL COMMENT '公司邮箱',
  `content` varchar(1000) default NULL COMMENT '公司简介',
  `industry` varchar(1000) default NULL COMMENT '行业',
  `stock_code` varchar(64) default NULL COMMENT '公司股票代码',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_company
-- ----------------------------
INSERT INTO `anci_company` VALUES ('08375a2dff80e821d5a158dd98302b21', '安磁检测', 'anci', '广东省东莞市松山湖总部二路1号', '12345678901', 'test@anci.com', '灯具、电源、电池检测', '检测机构', null, '0','jeecg-boot', '2020-3-15 10:20:07', null, null);
INSERT INTO `anci_company` VALUES ('08375a2dff80e821d5abc8dd98302b21', '中兴', 'ZTE', '深圳市科技园', '12345678901', 'test@anci.com', '通讯设备研发生产', '设备厂家', null, '0','jeecg-boot', '2020-3-15 10:20:15', null, null);


-- ----------------------------
-- Table structure for 人员表
-- ----------------------------
DROP TABLE IF EXISTS `anci_person`;
CREATE TABLE `anci_person` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(50) default NULL COMMENT '姓名',
  `address` varchar(255) default NULL COMMENT '地址',
  `telephone` varchar(50) default NULL COMMENT '联系电话',
  `email` varchar(50) default NULL COMMENT '邮箱',
  `company_id` varchar(50) default NULL COMMENT '公司ID',
  `position` varchar(20) default NULL COMMENT '职位',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_person
-- ----------------------------
INSERT INTO `anci_person` VALUES ('08375a2dff80e821d5a158dd98302b22', '邓中春', '广东省东莞市松山湖总部二路1号', '12345678901', 'test@anci.com', '08375a2dff80e821d5a158dd98302b21','总经理','0','jeecg-boot', '2019-04-10 11:42:57', null, null);



-- ----------------------------
-- Table structure for 产品类型表
-- ----------------------------
DROP TABLE IF EXISTS `anci_product_type`;
CREATE TABLE `anci_product_type` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `product_type` varchar(50) default NULL COMMENT '产品类别',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_product_type
-- ----------------------------
INSERT INTO `anci_product_type` VALUES ('08375a2dff80e821d5a158dd98302c35', '电池','0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- ----------------------------
-- Table structure for 产品表
-- ----------------------------
DROP TABLE IF EXISTS `anci_product`;
CREATE TABLE `anci_product` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(50) default NULL COMMENT '中文名称',
  `en_name` varchar(50) default NULL COMMENT '英文名称',
  `address` varchar(255) default NULL COMMENT '产地',
  `content` varchar(255) default NULL COMMENT '产品描述',
  `producttion_date` datetime default NULL COMMENT '生产日期',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_product
-- ----------------------------
INSERT INTO `anci_product` VALUES ('08375a2dff80e821d5a158dd98302c22', '手机电池', 'phone battery', '深圳', '智能手机不可拆卸电池','2019-04-10 11:42:57','0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- ----------------------------
-- Table structure for 产品型号表
-- ----------------------------
DROP TABLE IF EXISTS `anci_product_model`;
CREATE TABLE `anci_product_model` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `model_name` varchar(50) default NULL COMMENT '产品型号名',
  `model` varchar(50) default NULL COMMENT '产品型号',
  `product_type_id` varchar(50) default NULL COMMENT '产品类别ID',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_product_model
-- ----------------------------
INSERT INTO `anci_product_model` VALUES ('08375a2dff80e821d5a158dd98302c35', '08375a2dff80e821d5a158dd98302c22',  '030','08375a2dff80e821d5a158dd98302c35', '锂电池','0','jeecg-boot', '2019-04-10 11:42:57', null, null);

-- Table structure for 产品、型号关系表
-- ----------------------------
DROP TABLE IF EXISTS `anci_product_and_type`;
CREATE TABLE `anci_product_and_type` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `product_id` varchar(50) NOT NULL COMMENT '产品ID',
  `product_number_id` varchar(50) NOT NULL COMMENT '产品型号ID',
  PRIMARY KEY  (`id`,`product_id`, `product_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_product_and_type
-- ----------------------------
INSERT INTO `anci_product_and_type` VALUES ('08375a2dff80e821d5a158dd98302c35', '08375a2dff80e821d5a158dd98302c22', '08375a2dff80e821d5a158dd98302c35');


-- ----------------------------
-- Table structure for 测试类别表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_type`;
CREATE TABLE `anci_test_type` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(50) default NULL COMMENT '认证类别',
  `country` varchar(50) default NULL COMMENT '国家',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_type
-- ----------------------------
INSERT INTO `anci_test_type` VALUES ('08375a2dff80e821d5a158dd98302c35', 'EU', '欧盟', '欧洲认证', '0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- ----------------------------
-- Table structure for 检测项目表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_item`;
CREATE TABLE `anci_test_item` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(50) default NULL COMMENT '检测项目',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_item
-- ----------------------------
INSERT INTO `anci_test_item` VALUES ('08375a2dff80e821d5a158dd98302c35', '电磁认证', '电磁辐射强度检测', '0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- Table structure for 认证类别、测试项目关系表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_type_item`;
CREATE TABLE `anci_test_type_item` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `certification_type_id` varchar(50) NOT NULL COMMENT '产品ID',
  `test_item_id` varchar(50) NOT NULL COMMENT '产品型号ID',
  PRIMARY KEY  (`id`,`certification_type_id`,`test_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of anci_test_type_item
-- ----------------------------
INSERT INTO `anci_test_type_item` VALUES ('08375a2dff80e821d5a158dd98302c35', '08375a2dff80e821d5a158dd98302c22', '08375a2dff80e821d5a158dd98302c35');



-- ----------------------------
-- Table structure for 测试标准表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_standard`;
CREATE TABLE `anci_test_standard` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `standard_code` varchar(50) default NULL COMMENT '标准编号',
  `name` varchar(50) default NULL COMMENT '标准名称',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_standard
-- ----------------------------
INSERT INTO `anci_test_standard` VALUES ('08375a2dff80e821d5a158dd98302c35', 'GB19212.1-2003',  '电源、电抗器产品安全', '电磁辐射强度检测', '0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- ----------------------------
-- Table structure for 标准条款表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_clause`;
CREATE TABLE `anci_test_clause` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `standard_code` varchar(50) default NULL COMMENT '标准编号',
  `parent_clause` varchar(50) default NULL COMMENT '父条款号',
  `clause` varchar(50) default NULL COMMENT '条款号',
  `name` varchar(50) default NULL COMMENT '条款名称',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_clause
-- ----------------------------
INSERT INTO `anci_test_clause` VALUES ('08375a2dff80e821d5a158dd98302c35', 'GB19212.1-2003', '4.4.4',  '电源、电抗器产品安全', '电磁辐射强度检测', '电磁辐射强度检测', '0','jeecg-boot', '2019-04-10 11:42:57', null, null);

-- ----------------------------
-- Table structure for 条款检测结论记录表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_result`;
CREATE TABLE `anci_test_result` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `standard_code` varchar(50) default NULL COMMENT '标准编号',
  `clause` varchar(50) default NULL COMMENT '条款号',
  `name` varchar(50) default NULL COMMENT '条款名称',
  `case_id` varchar(50) NOT NULL COMMENT '案件ID',
  `requirement` varchar(1000) default NULL COMMENT '要求',
  `result_remark` varchar(1000) default NULL COMMENT '现象记录',
  `Verdict` varchar(5) default 'P' COMMENT '结论',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`,`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_result
-- ----------------------------
INSERT INTO `anci_test_result` VALUES ('08375a2dff80e821d5a258dd98302c35', 'GB19212.1-2003', '4.4.4',  '电源、电抗器产品安全', '08375a2dff80e821d5a158dd98302c11', '小于0.01', '0.001', 'P', '0','jeecg-boot', '2019-04-10 11:42:57', null, null);


-- ----------------------------
-- Table structure for 案件表
-- ----------------------------
DROP TABLE IF EXISTS `anci_test_project`;
CREATE TABLE `anci_test_project` (
  `id` varchar(50) NOT NULL COMMENT '主键ID',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `report_reference_no` varchar(50) NOT NULL COMMENT '报告编号',
  `company_id` varchar(50) NOT NULL COMMENT '被检测公司ID',
  `company_name` varchar(50) NOT NULL COMMENT '被检测公司名称',
  `laboratory_id` varchar(50) NOT NULL COMMENT '实验室ID',
  `laboratory_name` varchar(50) NOT NULL COMMENT '实验室名称',
  `product_id` varchar(50) NOT NULL COMMENT '产品ID',
  `model_id` varchar(50) NOT NULL COMMENT '型号ID',
  `certification_id` varchar(50) NOT NULL COMMENT '认证ID',
  `standard_id` varchar(50) NOT NULL COMMENT '标准ID',
  `clause_result_id` varchar(50) default NULL COMMENT '条款结论ID',
  `content` varchar(1000) default NULL COMMENT '描述',
  `del_flag` varchar(1) default '0' COMMENT '删除状态（0，正常，1已删除）',
  `create_by` varchar(32) default NULL COMMENT '创建人',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_by` varchar(32) default NULL COMMENT '修改人',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ----------------------------
-- Records of anci_test_project
-- ----------------------------
INSERT INTO `anci_test_project` VALUES ('08375a2dff80e821d5a158dd98302c11', 'EU电磁检测','08375a2dff80e821d5abc8dd98302b21', '中兴',  '08375a2dff80e821d5a158dd98302b21', '安磁检测', '08375a2dff80e821d5a158dd98302c22','08375a2dff80e821d5a158dd98302c35','08375a2dff80e821d5a158dd98302c35','08375a2dff80e821d5a158dd98302c35','08375a2dff80e821d5a258dd98302c35', '通过','0','jeecg-boot', '2019-04-10 11:42:57', null, null);
