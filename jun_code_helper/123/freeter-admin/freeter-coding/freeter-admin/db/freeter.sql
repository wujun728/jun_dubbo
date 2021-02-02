/*
Navicat MySQL Data Transfer

Source Server         : 47.106.39.83_3306
Source Server Version : 50720
Source Host           : 47.106.39.83:3306
Source Database       : freeter

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-08-06 14:35:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cn_address
-- ----------------------------
DROP TABLE IF EXISTS `cn_address`;
CREATE TABLE `cn_address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `detailed_address` varchar(200) NOT NULL COMMENT '详细地址',
  `postcode` varchar(20) NOT NULL DEFAULT '0' COMMENT '邮编',
  `person_name` varchar(20) NOT NULL COMMENT '收货人姓名',
  `person_tel` varchar(50) NOT NULL COMMENT '收货人电话',
  `city` varchar(20) NOT NULL COMMENT '市',
  `area` varchar(20) NOT NULL DEFAULT '' COMMENT '区',
  `is_default` varchar(10) NOT NULL DEFAULT '0' COMMENT '是否默认地址 0：否 1：是',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

-- ----------------------------
-- Records of cn_address
-- ----------------------------
INSERT INTO `cn_address` VALUES ('1', '111', '千岭乡向阳街', '246521', '刘齐', '13033087652', '安庆市', '宿松县', '0', '安徽');
INSERT INTO `cn_address` VALUES ('23', '8', '西二环', '2300001', '哈哥', '13000001111', '武汉', '蜀山', '0', '湖北');
INSERT INTO `cn_address` VALUES ('24', '8', '西二环', '2300001', '哈哥', '13000001111', '武汉', '蜀山', '0', '湖北');
INSERT INTO `cn_address` VALUES ('38', '9', '上海市人民政府办公厅组织', '147852', '李五', '17698522148', '上海市', '卢湾区', '0', '上海市');
INSERT INTO `cn_address` VALUES ('39', '10', '明发商业广场13楼', '000000', '广品汇', '18888888888', '合肥市', '包河区', '0', '安徽省');
INSERT INTO `cn_address` VALUES ('40', '10', '不知反思就是那句话大喊大叫', '000000', '哈哈哈', '123456789', '蚌埠市', '蚌山区', '1', '安徽省');
INSERT INTO `cn_address` VALUES ('45', '11', '四里河路明发商业广场', '340000', '宋许超', '17682153207', '合肥市', '庐阳区', '0', '安徽省');

-- ----------------------------
-- Table structure for cn_admart
-- ----------------------------
DROP TABLE IF EXISTS `cn_admart`;
CREATE TABLE `cn_admart` (
  `mart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `keyword` varchar(255) DEFAULT NULL COMMENT '店铺关键字',
  `log` varchar(255) DEFAULT '' COMMENT '品牌log',
  `mart_name` varchar(255) DEFAULT '' COMMENT '店铺名称',
  `self` tinyint(1) DEFAULT NULL COMMENT '是否自营 0：否 1：自营',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '商户类型 1:个人商户 2：个体户，企业用户',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 0:审核中 1:审核通过 2:审核拒绝',
  `real_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `id_card_img` varchar(255) DEFAULT '' COMMENT '身份证照片',
  `license_no` varchar(100) DEFAULT NULL COMMENT '营业执照号',
  `license_img` varchar(255) DEFAULT NULL COMMENT '营业执照图片',
  `contact` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系方式',
  `total_assets` decimal(11,2) DEFAULT '0.00' COMMENT '总资产',
  PRIMARY KEY (`mart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='商户表';

-- ----------------------------
-- Records of cn_admart
-- ----------------------------
INSERT INTO `cn_admart` VALUES ('1', '广品会', '', '广品会', '1', '2018-05-25 10:25:39', '超级管理员', null, null, null, null, '2', null, null, null, null, null, '1799.00');
INSERT INTO `cn_admart` VALUES ('2', null, '', '杂货店', '0', '2018-06-29 15:36:02', null, null, null, '23', '1', '1', '刘齐', '', null, null, null, '0.00');
INSERT INTO `cn_admart` VALUES ('7', null, '', '哈哈哈', '0', '2018-06-30 11:16:28', null, 'admin', '2018-06-30 11:35:32', '10', '2', '2', null, '', '897558555', 'http://img.cnadmart.com//STORE/certification/011833820180630111616.jpeg', null, '0.00');
INSERT INTO `cn_admart` VALUES ('18', null, '', null, '0', '2018-07-02 14:06:53', null, null, null, '9', '1', '2', 'Jack', '200820180702140634.png', null, null, null, '0.00');

-- ----------------------------
-- Table structure for cn_admart_assets_detail
-- ----------------------------
DROP TABLE IF EXISTS `cn_admart_assets_detail`;
CREATE TABLE `cn_admart_assets_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admart_id` int(11) DEFAULT NULL COMMENT '商户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型 1：支出2：收入',
  `trading_time` datetime DEFAULT NULL COMMENT '交易时间',
  `trading_matter` varchar(250) DEFAULT NULL COMMENT '交易事项',
  `trading_amount` decimal(11,2) DEFAULT NULL COMMENT '交易金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商户资产明细表';

-- ----------------------------
-- Records of cn_admart_assets_detail
-- ----------------------------
INSERT INTO `cn_admart_assets_detail` VALUES ('1', '1', '2', '2018-07-04 14:55:10', '商品id:213,规格价格id:807，购买数量:1', '554.00');

-- ----------------------------
-- Table structure for cn_admart_audit_log
-- ----------------------------
DROP TABLE IF EXISTS `cn_admart_audit_log`;
CREATE TABLE `cn_admart_audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admart_id` int(11) DEFAULT NULL COMMENT '商户id',
  `mart_name` varchar(255) DEFAULT NULL COMMENT '商户名称',
  `status` int(1) DEFAULT NULL COMMENT '审核状态 1：审核通过 2：审核拒绝',
  `note` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='商户审核记录';

-- ----------------------------
-- Records of cn_admart_audit_log
-- ----------------------------
INSERT INTO `cn_admart_audit_log` VALUES ('1', '7', null, '1', '资料不完整', '2018-06-30 11:36:22', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('2', '1', null, null, null, '2018-06-30 15:42:18', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('3', '1', null, null, null, '2018-06-30 15:43:05', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('4', '1', null, null, null, '2018-06-30 15:45:48', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('5', '1', null, null, null, '2018-06-30 15:46:35', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('6', '1', null, '1', null, '2018-06-30 15:49:05', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('7', '1', null, '1', null, '2018-06-30 15:49:51', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('8', '1', null, '2', null, '2018-06-30 15:53:43', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('9', '9', null, '2', '上传图片不清晰', '2018-06-30 15:54:20', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('10', '1', null, '2', 'fdg', '2018-06-30 15:58:11', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('11', '1', null, '1', 'sdf', '2018-06-30 16:00:12', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('12', '1', null, '2', 'sdf', '2018-06-30 16:00:26', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('13', '2', null, '1', 'wrwt wt rt', '2018-06-30 16:55:07', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('14', '10', null, '2', 'fsdfljkslkjsdlkjjjjjjjjjjkkfjjjjjjjjjjjjjjjjjjjjjjjjjjjjj', '2018-07-02 08:36:47', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('15', '12', null, '1', null, '2018-07-02 08:45:44', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('16', '13', null, '1', null, '2018-07-02 08:46:10', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('17', '14', null, '1', null, '2018-07-02 09:04:10', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('18', '15', null, '1', 'qwe', '2018-07-02 09:04:48', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('19', '16', null, '2', '图片不符合', '2018-07-02 09:17:02', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('20', '17', null, '2', '46456654645654', '2018-07-02 09:32:51', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('21', '17', null, '2', '快乐快乐加扣扣快捷键\n', '2018-07-02 13:52:48', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('22', '17', null, '1', null, '2018-07-02 13:55:24', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('23', '16', null, '1', null, '2018-07-02 14:04:32', 'admin');
INSERT INTO `cn_admart_audit_log` VALUES ('24', '18', null, '2', null, '2018-07-02 14:07:20', 'admin');

-- ----------------------------
-- Table structure for cn_adverts
-- ----------------------------
DROP TABLE IF EXISTS `cn_adverts`;
CREATE TABLE `cn_adverts` (
  `adverts_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '广告位ID',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `template` text COMMENT '模版内容',
  `defult_number` int(11) DEFAULT '0' COMMENT '默认显示个数',
  `number` int(11) DEFAULT '0' COMMENT '广告数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  `status` tinyint(1) DEFAULT '0' COMMENT '启用状态(0:开启，1：关闭)',
  PRIMARY KEY (`adverts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='广告位表';

-- ----------------------------
-- Records of cn_adverts
-- ----------------------------
INSERT INTO `cn_adverts` VALUES ('1', '首页-轮播广告', '1226', '460', '电子商城首页轮播广告位', '', '6', '7', null, '', '2018-07-09 16:39:45', 'admin', '0');
INSERT INTO `cn_adverts` VALUES ('2', '首页-热点广告', '315', '170', '电子商城首页热点广告位', '', '3', '6', null, '', '2018-07-11 17:36:13', 'admin', '0');
INSERT INTO `cn_adverts` VALUES ('3', '首页-分类广告', '234', '300', '电子商城首页分类广告位', null, '2', '6', null, '', '2018-07-28 14:25:16', 'admin', '0');
INSERT INTO `cn_adverts` VALUES ('4', '专题', null, null, null, null, '0', '0', '2018-07-28 14:56:43', 'admin', null, null, '0');

-- ----------------------------
-- Table structure for cn_adverts_detail
-- ----------------------------
DROP TABLE IF EXISTS `cn_adverts_detail`;
CREATE TABLE `cn_adverts_detail` (
  `adverts_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '广告详情ID',
  `name` varchar(255) DEFAULT NULL COMMENT '广告位置',
  `adverts_id` bigint(20) DEFAULT NULL COMMENT '广告位ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '链接地址',
  `type` tinyint(2) DEFAULT NULL COMMENT '类型(0:图文，1：图片，2：视频）',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 0=显示/1=隐藏',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  `remarks` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注信息',
  `begin_time` datetime DEFAULT NULL COMMENT '广告起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '广告结束时间',
  `content` varchar(255) DEFAULT NULL COMMENT '广告内容',
  PRIMARY KEY (`adverts_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='广告位详情';

-- ----------------------------
-- Records of cn_adverts_detail
-- ----------------------------
INSERT INTO `cn_adverts_detail` VALUES ('22', '首页-轮播广告', '1', 'qwewq', '1', null, '1', '0', 'http://img.cnadmart.com/20180801/f029977a0c6e4a7f89814fcddaf277d7.png', '2018-07-10 17:39:37', 'admin', '2018-08-01 17:34:28', 'admin', 'w', '2018-07-19 00:00:00', '2018-08-23 00:00:00', 'qwe');
INSERT INTO `cn_adverts_detail` VALUES ('23', '首页-轮播广告', '1', 'wqeqw', '1', null, '1', '0', 'http://img.cnadmart.com/20180801/45f30a8ef9944b0ba97cc49d1cdda219.png', '2018-07-10 17:39:53', 'admin', '2018-08-01 17:29:48', 'admin', 'qwe', '2018-07-11 00:00:00', '2018-08-09 00:00:00', '');
INSERT INTO `cn_adverts_detail` VALUES ('24', '首页-轮播广告', '1', '2', '1', null, '1', '0', 'http://img.cnadmart.com/20180801/ebb28004dc3b4f1da66998c47161561d.png', '2018-07-10 17:40:58', 'admin', '2018-08-01 17:31:19', 'admin', '23', '2018-07-20 00:00:00', '2018-08-24 00:00:00', '');

-- ----------------------------
-- Table structure for cn_cart
-- ----------------------------
DROP TABLE IF EXISTS `cn_cart`;
CREATE TABLE `cn_cart` (
  `cart_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `good_spec_price_id` int(11) unsigned DEFAULT NULL COMMENT '商品规格价格id',
  `user_id` int(11) unsigned DEFAULT NULL COMMENT '用户ID',
  `buy_number` int(11) DEFAULT '1' COMMENT '购买数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `check_status` tinyint(2) DEFAULT '1' COMMENT '购物车状态：0,未选中；1,选中',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of cn_cart
-- ----------------------------
INSERT INTO `cn_cart` VALUES ('19', '179', '10', '3', '2018-06-20 17:05:45', null, '1');
INSERT INTO `cn_cart` VALUES ('20', '185', '10', '6', '2018-06-20 17:06:00', null, '1');
INSERT INTO `cn_cart` VALUES ('21', '185', '10', '1', '2018-06-20 17:14:37', null, '1');
INSERT INTO `cn_cart` VALUES ('22', '179', '10', '1', '2018-06-20 17:15:00', null, '1');
INSERT INTO `cn_cart` VALUES ('23', '179', '10', '1', '2018-06-20 17:45:16', null, '1');
INSERT INTO `cn_cart` VALUES ('24', '179', '10', '1', '2018-06-20 17:45:22', null, '1');
INSERT INTO `cn_cart` VALUES ('25', '176', '10', '1', '2018-06-20 17:45:24', null, '1');
INSERT INTO `cn_cart` VALUES ('26', '176', '10', '1', '2018-06-20 17:49:05', null, '1');
INSERT INTO `cn_cart` VALUES ('28', '196', '9', '2', '2018-06-21 15:39:54', '2018-06-21 19:51:56', '1');

-- ----------------------------
-- Table structure for cn_category
-- ----------------------------
DROP TABLE IF EXISTS `cn_category`;
CREATE TABLE `cn_category` (
  `category_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父分类ID',
  `name` varchar(64) DEFAULT NULL COMMENT '分类名称',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `type` tinyint(2) DEFAULT NULL COMMENT '目录类型 2=二级目录/1=一级目录/0=总目录',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 1=显示/0=隐藏',
  `show_in_commend` tinyint(2) DEFAULT '0' COMMENT '是否推荐（0：不推荐 1：推荐）',
  `show_in_nav` tinyint(2) DEFAULT '0' COMMENT '是否导航栏 1=显示/0=隐藏',
  `show_in_top` tinyint(2) DEFAULT '0' COMMENT '是否置顶 1=置顶/0=默认',
  `show_in_hot` tinyint(2) DEFAULT '0' COMMENT '是否热门 1=热门/0=默认',
  `icon` varchar(255) DEFAULT NULL COMMENT '分类小图标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  `page_title` varchar(64) DEFAULT NULL COMMENT '页面标题',
  `page_description` varchar(64) DEFAULT NULL COMMENT '页面描述',
  `page_keyword` varchar(64) DEFAULT NULL COMMENT '页面关键词',
  `remarks` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注信息',
  `channel_id` varchar(255) DEFAULT NULL COMMENT '频道id',
  PRIMARY KEY (`category_id`),
  KEY `sort_index` (`sort`) USING BTREE,
  KEY `nav_index` (`show_in_nav`) USING BTREE,
  KEY `hot_index` (`show_in_hot`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of cn_category
-- ----------------------------
INSERT INTO `cn_category` VALUES ('2', '0', '喷绘耗材', null, '1', '1', '1', '1', '1', '1', null, '2017-02-25 21:44:43', '猫宁', '2018-07-11 16:15:01', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('3', '0', '写真耗材', null, '1', '1', null, '1', '1', null, null, '2018-05-21 11:24:34', '', '2018-07-11 16:15:10', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('4', '0', '标牌展示', null, '1', '1', null, '1', '1', null, null, '2018-05-21 11:28:30', '', '2018-07-11 16:15:23', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('5', '0', '板材型材', null, '1', '1', null, '1', '1', null, null, '2018-05-21 11:28:28', '', '2018-07-11 16:15:34', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('6', '0', '光电产品', null, '1', '1', null, '1', '1', null, null, '2018-05-21 11:28:24', '', '2018-07-10 21:54:27', 'admin', null, null, null, null, '18');
INSERT INTO `cn_category` VALUES ('7', '0', '机器配件', null, '1', '1', null, '1', '1', null, null, '2018-05-21 11:28:19', '', '2018-07-10 21:54:36', 'admin', null, null, null, null, '18');
INSERT INTO `cn_category` VALUES ('57', '2', '黑白布', '1', '2', '1', '0', '1', '0', '0', null, '2018-05-29 16:51:48', 'admin', '2018-07-11 16:15:54', 'admin', '', '', '', '', '37');
INSERT INTO `cn_category` VALUES ('58', '2', '旗帜布', '7', '2', '1', '0', '1', '0', '0', null, '2018-05-29 17:05:34', 'admin', '2018-07-11 16:16:04', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('71', '2', '户外条幅布', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:00:28', 'admin', '2018-07-11 16:16:16', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('72', '2', '网格布', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:01:51', 'admin', '2018-07-11 16:16:37', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('73', '2', '车身贴', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:02:14', 'admin', '2018-07-05 14:44:45', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('74', '2', '单面透', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:02:56', 'admin', '2018-06-12 10:34:36', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('75', '2', '弱溶剂油画布', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:06:19', 'admin', '2018-06-12 10:34:43', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('76', '2', '弱溶剂PVC片', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:06:41', 'admin', '2018-06-12 10:34:49', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('77', '2', '弱溶剂背胶', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:07:03', 'admin', '2018-07-06 15:13:10', 'admin', null, null, null, null, '18');
INSERT INTO `cn_category` VALUES ('78', '2', '弱溶剂PP', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:07:19', 'admin', '2018-06-12 10:35:00', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('79', '2', '弱溶剂相纸', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:10:48', 'admin', '2018-06-12 10:35:06', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('80', '2', '玻璃贴', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:11:05', 'admin', '2018-06-12 10:35:12', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('81', '2', '墨水', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:11:28', 'admin', '2018-06-12 10:35:18', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('82', '3', '背胶', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:13:31', 'admin', '2018-07-07 17:29:19', 'admin', null, null, null, null, '8');
INSERT INTO `cn_category` VALUES ('83', '3', '冷裱膜', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:13:52', 'admin', '2018-07-11 16:17:03', 'admin', null, null, null, null, '37');
INSERT INTO `cn_category` VALUES ('84', '3', '合成纸', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:30:34', 'admin', '2018-06-12 10:35:37', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('85', '3', '相纸', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:42:35', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('86', '3', 'PVC硬片', null, '2', '1', '0', '1', '0', '0', 'http://img.cnadmart.com/20180621/cefe5f15f0f8437d9f5031297bd3849c.jpg', '2018-06-12 10:42:57', 'admin', '2018-06-21 14:34:47', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('87', '3', '写真布', null, '2', '1', '0', '1', '0', '0', 'http://img.cnadmart.com/20180621/a56ef80d8afc46c3bacfbbadb94de3e6.jpg', '2018-06-12 10:55:34', 'admin', '2018-06-21 14:38:47', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('88', '3', '油画布', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:55:56', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('89', '3', '灯片', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:57:04', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('90', '3', '地板膜', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:57:24', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('91', '3', '反光膜', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:57:47', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('92', '3', '即时贴', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:58:22', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('93', '3', '转移膜', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 10:58:56', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('94', '4', '标牌', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:12:45', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('95', '4', '易拉宝', null, '2', '1', '0', '1', '0', '0', 'http://img.cnadmart.com/20180621/574ebe22c1dc406cbe3caf6db994092e.jpg', '2018-06-12 11:13:04', 'admin', '2018-06-21 14:37:54', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('96', '4', 'X展架', null, '2', '1', '0', '1', '0', '0', 'http://img.cnadmart.com/20180621/bdfb722a206f45f2b6dcf1864e1dd512.jpg', '2018-06-12 11:13:21', 'admin', '2018-06-21 14:36:15', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('97', '4', '挂画架', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:13:37', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('98', '4', '注水旗杆', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:13:53', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('99', '4', '立人展架', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:14:08', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('100', '4', '海报架', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:14:23', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('101', '4', '栏杆座', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:14:39', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('102', '4', '告示指示牌', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:14:56', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('103', '4', '促销类', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:15:15', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('104', '5', '亚力克板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:15:33', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('105', '5', '双色板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:15:47', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('106', '5', 'KT板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:16:04', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('108', '5', 'PVC发泡板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:16:43', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('109', '6', '灯带', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:17:07', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('110', '6', 'LED贴片模组', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:27:49', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('111', '6', 'LED开关电源', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:28:07', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('112', '6', 'LED显示屏单元板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 11:28:34', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('113', '6', '灯箱', null, '2', '1', '0', '1', '0', '0', 'http://img.cnadmart.com/20180621/b74371b65eb646e6baa20d1135710420.jpg', '2018-06-12 11:28:56', 'admin', '2018-06-21 14:36:38', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('114', '7', '打扣机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 12:01:01', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('115', '7', '刻字机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 12:01:23', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('116', '7', '打印机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:28:09', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('117', '7', '喷绘机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:29:07', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('118', '7', '写真机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:32:20', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('119', '7', '覆膜机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:32:48', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('120', '7', '条幅机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:35:12', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('121', '7', '旗帜机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:35:32', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('122', '7', '印花机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:35:54', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('123', '7', '雕刻机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:36:13', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('124', '7', '弯字机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:36:37', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('125', '7', '围字机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:36:52', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('126', '7', '切割机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:37:08', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('127', '7', '焊字机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:37:51', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('128', '7', '打标机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:38:09', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('129', '7', '吸塑机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:38:31', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('130', '7', '多功能一体机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:38:52', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('131', '7', '电话机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:39:07', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('132', '7', '碎纸机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:39:29', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('133', '7', '点钞机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:39:45', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('134', '7', '装订机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:40:01', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('135', '7', '过塑机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:40:22', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('136', '7', '订书机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:40:42', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('137', '7', '书壳机', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:41:00', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('138', '7', '棉胶类', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:41:18', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('139', '7', '扣眼', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:41:35', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('140', '7', '刮板', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:41:51', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('141', '7', '五金工具 ', null, '2', '1', '0', '1', '0', '0', null, '2018-06-12 13:42:06', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('142', '3', '双面胶', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-15 13:53:17', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('143', '3', '单孔透', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-15 14:01:34', 'admin', '2018-06-15 15:07:25', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('144', '3', '胶片', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-15 14:06:59', 'admin', '2018-06-15 15:07:35', 'admin', null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('145', '3', '艺术布', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-15 15:30:32', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('147', '6', '穿孔灯', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-19 12:00:15', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('148', '6', '贴片灯', '0', '2', '1', '0', '1', '1', '0', null, '2018-06-19 13:48:57', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('149', '6', '数码管', '0', '2', '1', '0', '1', '1', '0', null, '2018-06-19 14:07:17', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('151', '4', '抽奖箱', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-21 11:32:10', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('152', '4', '意见箱', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-21 14:07:16', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('153', '4', '酒水牌', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-21 15:11:06', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('154', '4', '营业执照框', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-21 15:15:48', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('155', '4', '电梯广告框', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-21 16:37:54', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('156', '4', '木托奖牌', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-22 09:06:53', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('157', '4', '胸卡', '0', '2', '1', '0', '1', '0', '0', null, '2018-06-22 09:52:43', 'admin', null, null, null, null, null, null, '1');
INSERT INTO `cn_category` VALUES ('161', '2', null, '0', '2', '1', '0', '0', '0', '0', null, '2018-07-06 15:10:53', 'admin', null, null, 'test', 'test', 'test', 'test', '18');
INSERT INTO `cn_category` VALUES ('162', '7', 'test', '0', '2', '1', '0', '0', '0', '0', null, '2018-07-06 15:12:51', 'admin', null, null, 'ee', 'ee', 'ee', 'ee', '2');
INSERT INTO `cn_category` VALUES ('163', '0', '1', '0', '1', '1', '1', '0', '1', '1', null, '2018-07-17 10:08:25', 'admin', null, null, null, null, null, null, '38');
INSERT INTO `cn_category` VALUES ('164', '0', 'bb', '0', '1', '1', '0', '0', '0', '0', null, '2018-07-25 14:31:22', 'admin', null, null, null, null, null, null, '40');
INSERT INTO `cn_category` VALUES ('165', '163', '2', '0', '2', '1', '0', '0', '0', '0', null, '2018-07-25 14:31:50', 'admin', null, null, null, null, null, null, '40');
INSERT INTO `cn_category` VALUES ('166', '164', 'cc', '0', '2', '1', '0', '0', '0', '0', null, '2018-07-25 14:32:40', 'admin', null, null, null, null, null, null, null);
INSERT INTO `cn_category` VALUES ('167', '164', 'cc', '0', '2', '1', '0', '0', '0', '0', null, '2018-07-25 14:33:04', 'admin', null, null, null, null, null, null, null);
INSERT INTO `cn_category` VALUES ('168', '0', '服装', '0', '1', '1', '1', '0', '1', '1', null, '2018-07-25 14:33:24', 'admin', null, null, null, null, null, null, '39');
INSERT INTO `cn_category` VALUES ('169', '0', 'ceshi', '0', '1', '1', '1', '0', '1', '1', null, '2018-08-04 06:27:17', 'admin', null, null, 'dddd', 'dddd', 'dddd', 'dddd', '1');
INSERT INTO `cn_category` VALUES ('170', '169', 'dfdfdfd', '0', '2', '1', '1', '1', '1', '1', null, '2018-08-04 06:28:47', 'admin', null, null, 'sdfsdfs', 'dfsdfsd', 'fsdfsdf', 'sdfsdfsdf', null);

-- ----------------------------
-- Table structure for cn_category_advert
-- ----------------------------
DROP TABLE IF EXISTS `cn_category_advert`;
CREATE TABLE `cn_category_advert` (
  `category_advert_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '类目广告ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '类目ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 1=显示/0=隐藏',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  `begin_time` datetime DEFAULT NULL COMMENT '广告起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '广告结束时间',
  `remarks` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`category_advert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='类目广告表';

-- ----------------------------
-- Records of cn_category_advert
-- ----------------------------
INSERT INTO `cn_category_advert` VALUES ('1', '2', '测试产品广告4', '3', 'detail/1472581220748', '1', 'images/advert/20170228/1471798587971.jpg', null, '', null, null, '2017-04-05 18:09:16', '2017-06-30 14:39:50', '地方');
INSERT INTO `cn_category_advert` VALUES ('2', '2', '测试产品广告2', '2', 'detail/1472581220748', '1', 'images/advert/20170228/1471798587971.jpg', null, '', null, null, '2017-04-05 18:09:16', '2017-06-30 14:39:50', '地方');
INSERT INTO `cn_category_advert` VALUES ('3', '2', '测试产品广告1', '1', 'detail/1472581220748', '1', 'images/advert/20170228/1471798587971.jpg', null, '', null, null, '2017-04-05 18:09:16', '2017-06-30 14:39:50', '地方');
INSERT INTO `cn_category_advert` VALUES ('4', '3', '测试产品广告5', '1', 'detail/1472581220748', '1', 'images/advert/20170228/1471798587971.jpg', null, '', null, null, '2017-04-05 18:09:16', '2017-06-30 14:39:50', '地方');

-- ----------------------------
-- Table structure for cn_category_good
-- ----------------------------
DROP TABLE IF EXISTS `cn_category_good`;
CREATE TABLE `cn_category_good` (
  `category_good_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_id` bigint(20) NOT NULL,
  `category_name` varchar(100) NOT NULL DEFAULT '',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) DEFAULT '' COMMENT '创建者',
  PRIMARY KEY (`category_good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of cn_category_good
-- ----------------------------
INSERT INTO `cn_category_good` VALUES ('108', '82', '背胶', '116', '2018-06-15 14:09:31', 'admin');
INSERT INTO `cn_category_good` VALUES ('110', '87', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片', '118', '2018-06-15 15:17:42', 'admin');
INSERT INTO `cn_category_good` VALUES ('111', '88', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片', '119', '2018-06-15 15:26:56', 'admin');
INSERT INTO `cn_category_good` VALUES ('112', '145', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '120', '2018-06-15 15:31:09', 'admin');
INSERT INTO `cn_category_good` VALUES ('113', '88', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '121', '2018-06-15 15:34:20', 'admin');
INSERT INTO `cn_category_good` VALUES ('114', '83', '冷裱膜', '122', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_category_good` VALUES ('115', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '123', '2018-06-19 08:54:10', 'admin');
INSERT INTO `cn_category_good` VALUES ('116', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '128', '2018-06-19 09:06:19', 'admin');
INSERT INTO `cn_category_good` VALUES ('117', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '129', '2018-06-19 09:13:03', 'admin');
INSERT INTO `cn_category_good` VALUES ('118', '113', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '130', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_category_good` VALUES ('119', '113', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '131', '2018-06-19 09:36:54', 'admin');
INSERT INTO `cn_category_good` VALUES ('120', '113', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '132', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_category_good` VALUES ('121', '113', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '133', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_category_good` VALUES ('122', '111', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '134', '2018-06-19 11:23:12', 'admin');
INSERT INTO `cn_category_good` VALUES ('123', '111', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '135', '2018-06-19 11:49:17', 'admin');
INSERT INTO `cn_category_good` VALUES ('124', '111', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱', '136', '2018-06-19 11:54:26', 'admin');
INSERT INTO `cn_category_good` VALUES ('125', '111', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱穿孔灯', '137', '2018-06-19 13:47:07', 'admin');
INSERT INTO `cn_category_good` VALUES ('128', '148', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱穿孔灯贴片灯', '140', '2018-06-19 13:55:10', 'admin');
INSERT INTO `cn_category_good` VALUES ('129', '148', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱穿孔灯贴片灯', '141', '2018-06-19 13:56:42', 'admin');
INSERT INTO `cn_category_good` VALUES ('130', '147', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱穿孔灯贴片灯', '142', '2018-06-19 13:59:45', 'admin');
INSERT INTO `cn_category_good` VALUES ('131', '149', '灯带LED贴片模组LED开关电源LED显示屏单元板灯箱穿孔灯贴片灯数码管', '143', '2018-06-19 14:07:38', 'admin');
INSERT INTO `cn_category_good` VALUES ('133', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '145', '2018-06-19 14:12:19', 'admin');
INSERT INTO `cn_category_good` VALUES ('134', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '146', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_category_good` VALUES ('135', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '147', '2018-06-19 14:18:40', 'admin');
INSERT INTO `cn_category_good` VALUES ('136', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '148', '2018-06-19 14:24:03', 'admin');
INSERT INTO `cn_category_good` VALUES ('137', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '149', '2018-06-19 14:26:42', 'admin');
INSERT INTO `cn_category_good` VALUES ('138', '106', '亚力克板双色板KT板PS有机板PVC发泡板', '150', '2018-06-19 14:27:40', 'admin');
INSERT INTO `cn_category_good` VALUES ('139', '104', '亚力克板双色板KT板PS有机板PVC发泡板', '151', '2018-06-20 08:43:11', 'admin');
INSERT INTO `cn_category_good` VALUES ('140', '104', '亚力克板双色板KT板PS有机板PVC发泡板', '152', '2018-06-20 08:48:30', 'admin');
INSERT INTO `cn_category_good` VALUES ('141', '104', '亚力克板双色板KT板PS有机板PVC发泡板', '153', '2018-06-20 09:33:13', 'admin');
INSERT INTO `cn_category_good` VALUES ('142', '107', '亚力克板双色板KT板PS有机板PVC发泡板', '154', '2018-06-20 09:44:35', 'admin');
INSERT INTO `cn_category_good` VALUES ('143', '108', '亚力克板双色板KT板PS有机板PVC发泡板', '155', '2018-06-20 09:49:52', 'admin');
INSERT INTO `cn_category_good` VALUES ('144', '103', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '156', '2018-06-20 14:35:52', 'admin');
INSERT INTO `cn_category_good` VALUES ('146', '97', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '158', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_category_good` VALUES ('148', '103', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '160', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_category_good` VALUES ('149', '95', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '161', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_category_good` VALUES ('150', '99', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '162', '2018-06-20 16:59:01', 'admin');
INSERT INTO `cn_category_good` VALUES ('151', '97', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '163', '2018-06-21 09:33:29', 'admin');
INSERT INTO `cn_category_good` VALUES ('152', '97', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '164', '2018-06-21 09:36:46', 'admin');
INSERT INTO `cn_category_good` VALUES ('154', '97', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '166', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_category_good` VALUES ('155', '97', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '167', '2018-06-21 09:48:06', 'admin');
INSERT INTO `cn_category_good` VALUES ('156', '98', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '168', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_category_good` VALUES ('158', '103', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '170', '2018-06-21 10:34:36', 'admin');
INSERT INTO `cn_category_good` VALUES ('159', '103', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '171', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_category_good` VALUES ('160', '96', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '172', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_category_good` VALUES ('161', '96', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '173', '2018-06-21 11:24:36', 'admin');
INSERT INTO `cn_category_good` VALUES ('162', '96', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类', '174', '2018-06-21 11:25:32', 'admin');
INSERT INTO `cn_category_good` VALUES ('164', '151', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱', '176', '2018-06-21 11:34:22', 'admin');
INSERT INTO `cn_category_good` VALUES ('165', '152', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱', '177', '2018-06-21 14:08:36', 'admin');
INSERT INTO `cn_category_good` VALUES ('166', '153', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌', '178', '2018-06-21 15:12:00', 'admin');
INSERT INTO `cn_category_good` VALUES ('167', '154', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框', '179', '2018-06-21 16:07:17', 'admin');
INSERT INTO `cn_category_good` VALUES ('168', '155', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框', '180', '2018-06-21 16:39:36', 'admin');
INSERT INTO `cn_category_good` VALUES ('169', '155', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框', '181', '2018-06-21 16:42:08', 'admin');
INSERT INTO `cn_category_good` VALUES ('170', '156', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框木托奖牌', '182', '2018-06-22 09:07:47', 'admin');
INSERT INTO `cn_category_good` VALUES ('171', '157', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框木托奖牌胸卡', '183', '2018-06-22 09:57:18', 'admin');
INSERT INTO `cn_category_good` VALUES ('172', '157', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框木托奖牌胸卡', '184', '2018-06-22 10:26:16', 'admin');
INSERT INTO `cn_category_good` VALUES ('173', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '185', '2018-06-24 17:47:12', 'admin');
INSERT INTO `cn_category_good` VALUES ('174', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '186', '2018-06-25 09:01:56', 'admin');
INSERT INTO `cn_category_good` VALUES ('175', '83', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '187', '2018-06-25 21:51:57', 'admin');
INSERT INTO `cn_category_good` VALUES ('176', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '188', '2018-06-25 22:49:18', 'admin');
INSERT INTO `cn_category_good` VALUES ('177', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '189', '2018-06-26 10:23:58', 'admin');
INSERT INTO `cn_category_good` VALUES ('178', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '190', '2018-06-26 14:27:57', 'admin');
INSERT INTO `cn_category_good` VALUES ('179', '85', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '191', '2018-06-26 18:13:02', 'admin');
INSERT INTO `cn_category_good` VALUES ('180', '73', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '192', '2018-06-26 18:22:28', 'admin');
INSERT INTO `cn_category_good` VALUES ('181', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '193', '2018-06-26 19:06:24', 'admin');
INSERT INTO `cn_category_good` VALUES ('182', '73', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '194', '2018-06-26 21:39:38', 'admin');
INSERT INTO `cn_category_good` VALUES ('183', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '195', '2018-06-26 21:46:07', 'admin');
INSERT INTO `cn_category_good` VALUES ('184', '86', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '196', '2018-06-26 22:32:14', 'admin');
INSERT INTO `cn_category_good` VALUES ('185', '87', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '197', '2018-06-27 09:13:33', 'admin');
INSERT INTO `cn_category_good` VALUES ('186', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '198', '2018-06-27 09:14:36', 'admin');
INSERT INTO `cn_category_good` VALUES ('187', '82', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '199', '2018-06-27 09:15:35', 'admin');
INSERT INTO `cn_category_good` VALUES ('188', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '200', '2018-06-27 09:57:33', 'admin');
INSERT INTO `cn_category_good` VALUES ('189', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '201', '2018-06-27 13:44:07', 'admin');
INSERT INTO `cn_category_good` VALUES ('190', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '202', '2018-06-27 15:54:39', 'admin');
INSERT INTO `cn_category_good` VALUES ('191', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '203', '2018-06-27 16:42:49', 'admin');
INSERT INTO `cn_category_good` VALUES ('192', '98', '标牌易拉宝X展架挂画架注水旗杆立人展架海报架栏杆座告示指示牌促销类抽奖箱意见箱酒水牌营业执照框电梯广告框木托奖牌胸卡', '204', '2018-06-28 16:56:17', 'admin');
INSERT INTO `cn_category_good` VALUES ('193', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '205', '2018-06-28 16:58:00', 'admin');
INSERT INTO `cn_category_good` VALUES ('196', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '208', '2018-07-02 08:30:38', 'admin');
INSERT INTO `cn_category_good` VALUES ('197', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '209', '2018-07-02 10:45:31', 'admin');
INSERT INTO `cn_category_good` VALUES ('199', '73', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水天花软膜喷绘布黑白布旗帜布', '213', '2018-07-04 14:54:19', 'admin');
INSERT INTO `cn_category_good` VALUES ('201', '86', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '216', '2018-07-05 17:37:25', 'admin');
INSERT INTO `cn_category_good` VALUES ('202', '83', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '217', '2018-07-05 18:50:20', 'admin');
INSERT INTO `cn_category_good` VALUES ('203', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水黑白布旗帜布', '219', '2018-07-05 22:19:43', 'admin');
INSERT INTO `cn_category_good` VALUES ('204', '86', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '220', '2018-07-05 23:40:19', 'admin');
INSERT INTO `cn_category_good` VALUES ('205', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水黑白布旗帜布', '221', '2018-07-06 03:02:08', 'admin');
INSERT INTO `cn_category_good` VALUES ('206', '159', 'test', '222', '2018-07-06 10:37:09', 'admin');
INSERT INTO `cn_category_good` VALUES ('208', '83', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '238', '2018-07-08 23:59:24', 'admin');
INSERT INTO `cn_category_good` VALUES ('209', '82', '背胶冷裱膜合成纸相纸PVC硬片写真布油画布灯片地板膜反光膜即时贴转移膜双面胶单孔透胶片艺术布', '240', '2018-07-09 15:28:26', 'admin');
INSERT INTO `cn_category_good` VALUES ('211', '106', '亚力克板双色板KT板PVC发泡板', '242', '2018-07-09 15:44:24', 'admin');
INSERT INTO `cn_category_good` VALUES ('212', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水null黑白布旗帜布', '244', '2018-07-11 11:10:58', 'admin');
INSERT INTO `cn_category_good` VALUES ('213', '72', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水null黑白布旗帜布', '248', '2018-07-11 21:26:35', 'admin');
INSERT INTO `cn_category_good` VALUES ('214', '71', '户外条幅布网格布车身贴单面透弱溶剂油画布弱溶剂PVC片弱溶剂背胶弱溶剂PP弱溶剂相纸玻璃贴墨水null黑白布旗帜布', '249', '2018-07-12 15:13:42', 'admin');
INSERT INTO `cn_category_good` VALUES ('215', '166', 'cc', '256', '2018-07-25 14:32:52', 'admin');
INSERT INTO `cn_category_good` VALUES ('216', '170', 'dfdfdfd', '270', '2018-08-04 06:30:20', 'admin');

-- ----------------------------
-- Table structure for cn_category_spec
-- ----------------------------
DROP TABLE IF EXISTS `cn_category_spec`;
CREATE TABLE `cn_category_spec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL COMMENT '商品分类id（商品规格和商品分类关联）',
  `spec_name` varchar(50) NOT NULL DEFAULT '' COMMENT '规格名称',
  `sort` varchar(50) NOT NULL DEFAULT '' COMMENT '规格排序',
  `is_show` varchar(10) NOT NULL COMMENT '是否可见 1 可见 0不可见',
  `is_mobile_show` tinyint(1) DEFAULT NULL COMMENT '手机端是否可见 1可见 0不可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='分类规格表';

-- ----------------------------
-- Records of cn_category_spec
-- ----------------------------
INSERT INTO `cn_category_spec` VALUES ('24', '168', '款式', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('25', '164', '规格', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('26', '3', '款式', '0', '0', '1');
INSERT INTO `cn_category_spec` VALUES ('27', '3', '规格', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('28', '5', '款式', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('29', '6', '款式', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('30', '7', '款式', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('31', '4', '规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('32', '5', '规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('33', '6', '规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('34', '7', '规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('35', '4', '款式', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('36', null, 'guige', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('37', null, 'test', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('38', '2', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('39', '3', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('40', '4', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('41', '5', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('42', '6', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('43', '7', 'aaaa', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('44', '2', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('45', '3', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('46', '4', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('47', '5', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('48', '6', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('49', '7', '第二规格', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('50', '2', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('51', '3', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('52', '4', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('53', '5', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('54', '6', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('55', '7', '111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('56', '2', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('57', '3', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('58', '4', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('59', '5', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('60', '6', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('61', '7', '11111', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('62', '5', 'demo', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('63', '2', '123', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('64', '3', '123', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('65', '2', '1', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('66', '3', '1', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('67', '4', '1', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('68', '6', '1', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('69', null, 'weq', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('70', '2', '321321', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('71', '3', '321321', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('72', '4', '321321', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('73', '5', '321321', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('74', '7', '321321', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('76', '2', '12', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('77', '158', '123123', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('78', null, '1221', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('79', '3', '颜色', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('80', '6', '颜色', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('81', '2', '23', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('82', '3', '23', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('83', '4', '23', '0', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('84', '2', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('85', '3', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('86', '4', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('87', '5', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('88', '6', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('89', '7', 'test', '1', '1', '1');
INSERT INTO `cn_category_spec` VALUES ('90', '163', '热热热', '0', '1', '1');

-- ----------------------------
-- Table structure for cn_channel
-- ----------------------------
DROP TABLE IF EXISTS `cn_channel`;
CREATE TABLE `cn_channel` (
  `channel_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '频道名称',
  `sort` int(3) DEFAULT NULL,
  `is_show` tinyint(1) DEFAULT '0' COMMENT '是否展示（0展示，1不展示）',
  `model` tinyint(1) DEFAULT NULL COMMENT '模式 1:商城 2：服务',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_channel
-- ----------------------------
INSERT INTO `cn_channel` VALUES ('1', '广告器材', '1', '0', null);
INSERT INTO `cn_channel` VALUES ('2', '素材/模板', '5', '0', null);
INSERT INTO `cn_channel` VALUES ('7', '广告礼品', '6', '0', null);
INSERT INTO `cn_channel` VALUES ('8', '广告制作', '3', '0', null);
INSERT INTO `cn_channel` VALUES ('9', '广告发布', '4', '0', null);
INSERT INTO `cn_channel` VALUES ('11', '广告金融', '11', '0', null);
INSERT INTO `cn_channel` VALUES ('12', '商学院', '12', '0', null);
INSERT INTO `cn_channel` VALUES ('13', '广告设计', '2', '0', null);
INSERT INTO `cn_channel` VALUES ('14', '企业服务', '9', '0', null);
INSERT INTO `cn_channel` VALUES ('15', '技术开发', '7', '0', null);
INSERT INTO `cn_channel` VALUES ('16', '自助视频', '8', '0', null);
INSERT INTO `cn_channel` VALUES ('17', '行业信息', '10', '0', null);

-- ----------------------------
-- Table structure for cn_express_company
-- ----------------------------
DROP TABLE IF EXISTS `cn_express_company`;
CREATE TABLE `cn_express_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_number` varchar(255) DEFAULT NULL COMMENT '快递公司编号',
  `company_name` varchar(255) DEFAULT NULL COMMENT '快递公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_express_company
-- ----------------------------
INSERT INTO `cn_express_company` VALUES ('1', 'YTO', '圆通速递');
INSERT INTO `cn_express_company` VALUES ('2', 'YZPY', '邮政平邮/小包');
INSERT INTO `cn_express_company` VALUES ('3', 'STO', '申通快递');
INSERT INTO `cn_express_company` VALUES ('4', 'BTWL', '百世快运');
INSERT INTO `cn_express_company` VALUES ('5', 'EMS', 'EMS');
INSERT INTO `cn_express_company` VALUES ('6', 'FAST', '快捷速递');
INSERT INTO `cn_express_company` VALUES ('7', 'HHTT', '天天快递');
INSERT INTO `cn_express_company` VALUES ('8', 'QFKD', '全峰快递');
INSERT INTO `cn_express_company` VALUES ('9', 'SF', '顺丰快递');
INSERT INTO `cn_express_company` VALUES ('10', 'YD', '韵达快递');

-- ----------------------------
-- Table structure for cn_good
-- ----------------------------
DROP TABLE IF EXISTS `cn_good`;
CREATE TABLE `cn_good` (
  `good_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `good_name` varchar(50) NOT NULL DEFAULT '' COMMENT '商品名称',
  `good_number` varchar(70) DEFAULT NULL COMMENT '商品编号',
  `max_price` decimal(10,2) DEFAULT '0.00' COMMENT '最大价格',
  `min_price` decimal(10,2) DEFAULT '0.00' COMMENT '最小价格',
  `introduce` varchar(255) DEFAULT '' COMMENT '商品简介',
  `pic_img` varchar(255) DEFAULT '' COMMENT '展示图片',
  `show_in_top` tinyint(1) DEFAULT '0' COMMENT '是否置顶 1=置顶/0=默认',
  `show_in_nav` tinyint(1) DEFAULT '0' COMMENT '是否导航栏 1=显示/0=隐藏',
  `show_in_like` tinyint(1) DEFAULT '0' COMMENT '猜你喜欢 1=显示/0=隐藏',
  `show_in_hot` tinyint(1) DEFAULT '0' COMMENT '是否热门 1=热门/0=默认',
  `show_in_shelve` tinyint(1) DEFAULT '0' COMMENT '是否上架：1=上架/0=下架',
  `search_key` varchar(255) DEFAULT '' COMMENT '搜索的关键词',
  `units` varchar(10) DEFAULT NULL COMMENT '单位',
  `activate` tinyint(1) DEFAULT '0' COMMENT '激活状态(0:未激活 1：激活)',
  `page_title` varchar(255) DEFAULT NULL COMMENT '页面标题',
  `page_description` varchar(255) DEFAULT '' COMMENT '页面的描述',
  `page_keyword` varchar(255) DEFAULT '' COMMENT '页面的关键词',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `shelve_time` datetime DEFAULT NULL COMMENT '上架时间',
  `shelve_by` varchar(64) DEFAULT '' COMMENT '上架人',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `mart_id` bigint(20) DEFAULT NULL COMMENT '商户id',
  `del_flag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of cn_good
-- ----------------------------
INSERT INTO `cn_good` VALUES ('116', 'X展架专用胶片', null, '6.50', '6.50', '', 'http://img.cnadmart.com/20180615/84704c2c79744e4d88d59e25e2f5a9c7.png', '0', '0', '0', '0', '0', '', null, '1', null, '', '', '', '2018-06-15 14:09:31', 'admin', null, '', 'admin', '2018-07-23 21:24:53', '1', null);
INSERT INTO `cn_good` VALUES ('118', '防水写真布', null, '3.00', '3.00', '', 'http://img.cnadmart.com/20180615/37ee00c5e58c4a4e9fe9a8ef5f4bc115.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-15 15:17:42', 'admin', null, '', 'admin', '2018-07-27 15:06:43', '1', null);
INSERT INTO `cn_good` VALUES ('119', '油画布', null, '7.00', '13.00', '', 'http://img.cnadmart.com/20180615/638f7d0642f84f2da1f4f5d7c91727d3.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-15 15:26:56', 'admin', null, '', 'admin', '2018-07-24 17:12:32', '1', null);
INSERT INTO `cn_good` VALUES ('120', '防水艺术布', null, '5.00', '5.00', '', 'http://img.cnadmart.com/20180615/4d721bdacc6840728cc715d58d89a839.png', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-15 15:31:09', 'admin', null, '', 'admin', '2018-06-15 15:31:53', '1', null);
INSERT INTO `cn_good` VALUES ('121', '防水棉质油画布', null, '15.00', '15.00', '', 'http://img.cnadmart.com/20180615/c4c17fd4aa9d40d29f4908a0d8f0673b.png', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-15 15:34:20', 'admin', null, '', 'admin', '2018-07-17 18:23:27', '1', null);
INSERT INTO `cn_good` VALUES ('122', '天花软膜', null, '3.30', '3.30', '', 'http://img.cnadmart.com/20180615/3076feafdd74414e8116fb139553368c.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-15 15:38:29', 'admin', null, '', 'admin', '2018-06-19 08:57:46', '1', null);
INSERT INTO `cn_good` VALUES ('123', 'KT板 普通板（20张/包）', null, '0.00', '0.00', '', 'http://img.cnadmart.com/20180619/7560ad1f14c543309bc839f3232cc3e0.png', '0', '0', '0', '0', '1', '', '张', '0', null, '', '', '', '2018-06-19 08:54:10', 'admin', null, '', 'admin', '2018-06-19 08:57:41', '1', null);
INSERT INTO `cn_good` VALUES ('128', 'KT板 布纹板（20张/包）', null, '9.00', '10.00', '', 'http://img.cnadmart.com/20180619/ae9f30d642754b25abc4338719395799.png', '0', '0', '0', '0', '0', '', '张', '1', null, '', '', '', '2018-06-19 09:06:19', 'admin', null, '', 'admin', '2018-06-19 09:06:47', '1', null);
INSERT INTO `cn_good` VALUES ('129', 'KT板 单晶板（10张/包）', null, '9.00', '10.50', '', 'http://img.cnadmart.com/20180619/3609c18bc5234610abd2cd7e1efa3530.jpg', '0', '0', '0', '0', '0', '', '张', '1', null, '', '', '', '2018-06-19 09:13:03', 'admin', null, '', 'admin', '2018-06-19 09:13:36', '1', null);
INSERT INTO `cn_good` VALUES ('130', '广告灯箱 超薄灯箱', null, '180.00', '180.00', '', 'http://img.cnadmart.com/20180619/d6c969ff69c043dcb860026de8f3df1d.jpg', '0', '0', '0', '0', '1', '', '平方', '0', null, '', '', '', '2018-06-19 09:25:34', 'admin', null, '', 'admin', '2018-07-16 11:31:31', '1', null);
INSERT INTO `cn_good` VALUES ('131', '广告灯箱 卡布灯箱', null, '260.00', '300.00', '', 'http://img.cnadmart.com/20180619/eac2f65a808f45609ba1aedd8cad974d.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-19 09:36:54', 'admin', null, '', 'admin', '2018-06-19 09:37:44', '1', null);
INSERT INTO `cn_good` VALUES ('132', '广告灯箱 吸塑灯箱', null, '60.00', '110.00', '', 'http://img.cnadmart.com/20180619/22485e6da50747cc8a0d3c28c0cec798.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-19 10:52:47', 'admin', null, '', 'admin', '2018-06-19 10:54:22', '1', null);
INSERT INTO `cn_good` VALUES ('133', '广告灯箱 点餐灯箱', null, '80.00', '80.00', '', 'http://img.cnadmart.com/20180619/8d0549a14769409c838b3f7d0f193d97.jpg', '0', '0', '0', '0', '1', '', '平方', '1', null, '', '', '', '2018-06-19 10:55:21', 'admin', null, '', 'admin', '2018-06-19 11:45:01', '1', null);
INSERT INTO `cn_good` VALUES ('134', '铁壳防雨电源', null, '30.00', '48.00', '', '', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 11:23:12', 'admin', null, '', 'admin', '2018-06-19 11:44:58', '1', null);
INSERT INTO `cn_good` VALUES ('135', '铝壳防雨电源', null, '30.00', '48.00', '', 'http://img.cnadmart.com/20180619/bbe33674f45a42b4b1cffbad9f33b780.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 11:49:17', 'admin', null, '', 'admin', '2018-06-19 14:16:38', '1', null);
INSERT INTO `cn_good` VALUES ('136', '卡布灯箱电源', null, '53.00', '60.00', '', '', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 11:54:26', 'admin', null, '', 'admin', '2018-06-19 14:16:34', '1', null);
INSERT INTO `cn_good` VALUES ('137', '超薄灯箱电源', null, '15.00', '30.00', '', 'http://img.cnadmart.com/20180619/8f0946480ef548f8bef32d2ced65de4d.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 13:47:07', 'admin', null, '', 'admin', '2018-06-19 14:16:31', '1', null);
INSERT INTO `cn_good` VALUES ('140', '贴片灯5730', null, '0.20', '0.24', '', 'http://img.cnadmart.com/20180619/05c1d120dc85442ca0dda9e6f55fd312.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 13:55:10', 'admin', null, '', 'admin', '2018-06-19 14:16:28', '1', null);
INSERT INTO `cn_good` VALUES ('141', '贴片灯5054', null, '0.26', '0.29', '', 'http://img.cnadmart.com/20180619/2ebd50486b0e476791753706e04c069c.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 13:56:42', 'admin', null, '', 'admin', '2018-06-19 14:16:25', '1', null);
INSERT INTO `cn_good` VALUES ('142', '穿孔灯', null, '0.10', '0.13', '', 'http://img.cnadmart.com/20180619/06d45b4e702047d8ace4b9993d6f38cc.jpg', '0', '0', '0', '0', '0', '', '个', '1', null, '', '', '', '2018-06-19 13:59:45', 'admin', null, '', 'admin', '2018-07-25 11:05:07', '1', null);
INSERT INTO `cn_good` VALUES ('143', '数码管', null, '12.00', '13.00', '', 'http://img.cnadmart.com/20180619/b9aa3acb9fec4a069ad8d475d78295a9.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-19 14:07:38', 'admin', null, '', 'admin', '2018-07-16 11:32:32', '1', null);
INSERT INTO `cn_good` VALUES ('145', 'KT板 布纹板（20张/包）', null, '9.00', '10.00', '', 'http://img.cnadmart.com/20180619/2a6f30734f1a4d7a88475bf32dd7e889.png', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:12:19', 'admin', null, '', 'admin', '2018-06-19 14:13:13', '1', null);
INSERT INTO `cn_good` VALUES ('146', 'KT板 单晶板（10张/包）', null, '9.00', '10.50', '', 'http://img.cnadmart.com/20180619/2206563a4ea446ac8f5e80db754a42b9.jpg', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:15:35', 'admin', null, '', 'admin', '2018-06-19 14:16:11', '1', null);
INSERT INTO `cn_good` VALUES ('147', 'KT板 双晶板（10张/包）', null, '9.50', '11.50', '', '', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:18:40', 'admin', null, '', 'admin', '2018-06-19 14:28:02', '1', null);
INSERT INTO `cn_good` VALUES ('148', 'KT板 龙卡板（10张/包）', null, '14.50', '16.50', '', 'http://img.cnadmart.com/20180619/ecf44c92d0d544369a2108039e8375ed.jpg', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:24:03', 'admin', null, '', 'admin', '2018-06-19 14:28:05', '1', null);
INSERT INTO `cn_good` VALUES ('149', 'KT板 涂塑板（10张/包）', null, '11.00', '13.00', '', 'http://img.cnadmart.com/20180619/a7fdee1564574517ba25842eb2610062.png', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:26:42', 'admin', null, '', 'admin', '2018-06-19 14:28:09', '1', null);
INSERT INTO `cn_good` VALUES ('150', 'KT板 1cm雕刻龙鑫板（10张/包）', null, '26.00', '26.00', '', '', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-19 14:27:40', 'admin', null, '', 'admin', '2018-06-19 14:28:12', '1', null);
INSERT INTO `cn_good` VALUES ('151', '亚克力吸塑板', null, '165.00', '225.00', '', 'http://img.cnadmart.com/20180620/740ed082d6d8489c96eb9a5fd872c7f8.jpg', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-20 08:43:11', 'admin', null, '', 'admin', '2018-06-20 08:49:47', '1', null);
INSERT INTO `cn_good` VALUES ('152', '亚克力吸塑板', null, '165.00', '165.00', '', null, '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-20 08:48:30', 'admin', null, '', 'admin', '2018-06-21 11:39:00', '1', null);
INSERT INTO `cn_good` VALUES ('153', '亚克力透明板', null, '155.00', '1350.00', '', 'http://img.cnadmart.com/20180620/1eaad80d8696405884db02541431da28.png', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-20 09:33:12', 'admin', null, '', 'admin', '2018-06-20 09:48:08', '1', null);
INSERT INTO `cn_good` VALUES ('154', 'PS有机板', null, '43.00', '200.00', '', 'http://img.cnadmart.com/20180620/94b10eaff05d48909ce839f92154e1c8.jpg', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-20 09:44:35', 'admin', null, '', 'admin', '2018-06-20 09:48:05', '1', null);
INSERT INTO `cn_good` VALUES ('155', 'PVC自由发泡板', null, '21.00', '128.00', '', 'http://img.cnadmart.com/20180620/34ff465670764fe58e0ad3f43aa8eb68.jpg', '0', '0', '0', '0', '1', '', '张', '1', null, '', '', '', '2018-06-20 09:49:52', 'admin', null, '', 'admin', '2018-06-20 10:44:55', '1', null);
INSERT INTO `cn_good` VALUES ('156', '抽奖转盘', null, '65.00', '85.00', '', 'http://img.cnadmart.com/20180620/073c56787f1b4a73a434a0b4958d291b.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-20 14:35:52', 'admin', null, '', 'admin', '2018-06-20 17:05:47', '1', null);
INSERT INTO `cn_good` VALUES ('158', '木质挂画架', null, '35.00', '40.00', '', 'http://img.cnadmart.com/20180620/7eea711d611542f59b3f2602666b619b.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-20 14:45:54', 'admin', null, '', 'admin', '2018-06-20 17:05:50', '1', null);
INSERT INTO `cn_good` VALUES ('160', '手举牌', null, '7.00', '10.00', '', 'http://img.cnadmart.com/20180620/3443219f3fa648f6ad1a6d3179a89904.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-20 15:00:32', 'admin', null, '', 'admin', '2018-06-20 17:05:56', '1', null);
INSERT INTO `cn_good` VALUES ('161', '易拉宝', null, '16.00', '22.00', '', 'http://img.cnadmart.com/20180620/13c3c81d8ed049dfac79e9fc2eeb23f3.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-20 15:30:00', 'admin', null, '', 'admin', '2018-06-20 17:06:02', '1', null);
INSERT INTO `cn_good` VALUES ('162', '模特支架', null, '16.00', '18.00', '', 'http://img.cnadmart.com/20180620/d11d13093a4042dc83117de637ff1424.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-20 16:59:01', 'admin', null, '', 'admin', '2018-06-20 17:06:58', '1', null);
INSERT INTO `cn_good` VALUES ('163', 'KT板挂画架 H型伸缩', null, '45.00', '50.00', '', '', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 09:33:29', 'admin', null, '', 'admin', '2018-06-21 09:49:39', '1', null);
INSERT INTO `cn_good` VALUES ('164', 'KT板挂画架 倾斜可伸缩', null, '45.00', '50.00', '', 'http://img.cnadmart.com/20180621/49a395961aaa4e51a71ce9f512f49bc4.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 09:36:46', 'admin', null, '', 'admin', '2018-06-21 09:49:36', '1', null);
INSERT INTO `cn_good` VALUES ('166', 'KT板挂画架 三角架款（双面）', null, '18.00', '18.00', '', 'http://img.cnadmart.com/20180621/ad28d41b362947b3b9c0e2a3249bde94.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 09:46:14', 'admin', null, '', 'admin', '2018-06-21 09:49:31', '1', null);
INSERT INTO `cn_good` VALUES ('167', 'KT板挂画架 POP三角挂画架', null, '23.00', '23.00', '', '', '0', null, null, '0', '1', null, '个', '1', null, null, null, null, '2018-06-21 09:48:06', 'admin', null, null, 'admin', '2018-06-21 09:49:28', '1', null);
INSERT INTO `cn_good` VALUES ('168', '注水旗杆', null, '20.00', '135.00', '', 'http://img.cnadmart.com/20180621/6415b202e22f4b868c493a2dc35b7dc6.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 09:58:31', 'admin', null, '', 'admin', '2018-06-21 10:58:10', '1', null);
INSERT INTO `cn_good` VALUES ('170', '门型展架 铁质实用型底座', null, '25.00', '28.00', '', 'http://img.cnadmart.com/20180621/c90cf28ff34148efbcbf17b15530e55c.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 10:34:36', 'admin', null, '', 'admin', '2018-06-21 10:58:07', '1', null);
INSERT INTO `cn_good` VALUES ('171', '门型展架', null, '28.00', '50.00', '', 'http://img.cnadmart.com/20180621/fc6eba1cfe4b4c90b515f91034b12d13.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 10:37:39', 'admin', null, '', 'admin', '2018-06-21 10:58:03', '1', null);
INSERT INTO `cn_good` VALUES ('172', 'X展架 韩式', null, '4.50', '12.00', '', 'http://img.cnadmart.com/20180621/f722603cf8ef45b2bd732bad598c590f.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 11:19:25', 'admin', null, '', 'admin', '2018-06-21 11:21:13', '1', null);
INSERT INTO `cn_good` VALUES ('173', '普通可调式 X展架', null, '8.00', '8.00', '', 'http://img.cnadmart.com/20180621/6550fd18799e4593994ee2265e3feef6.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 11:24:35', 'admin', null, '', 'admin', '2018-06-21 14:06:24', '1', null);
INSERT INTO `cn_good` VALUES ('174', '美式可调式 X展架', null, '18.00', '18.00', '', 'http://img.cnadmart.com/20180621/9af4ee1f09ff4ac1bdf78f67b79a9d40.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 11:25:32', 'admin', null, '', 'admin', '2018-06-21 14:06:27', '1', null);
INSERT INTO `cn_good` VALUES ('176', '抽奖箱', null, '35.00', '40.00', '', 'http://img.cnadmart.com/20180621/97bdc2e84e4043269320ddd915cee2e0.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 11:34:22', 'admin', null, '', 'admin', '2018-06-21 14:06:32', '1', null);
INSERT INTO `cn_good` VALUES ('177', '意见箱', null, '25.00', '35.00', '', 'http://img.cnadmart.com/20180621/678ff504eece4b05b1297c3581322dcb.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 14:08:36', 'admin', null, '', 'admin', '2018-06-21 15:08:23', '1', null);
INSERT INTO `cn_good` VALUES ('178', '旋转酒水牌', null, '20.00', '20.00', '', 'http://img.cnadmart.com/20180621/05205fe500a6411f8cddb7d92572d8f5.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 15:12:00', 'admin', null, '', 'admin', '2018-06-21 16:32:44', '1', null);
INSERT INTO `cn_good` VALUES ('179', '营业执照框', null, '12.00', '12.00', '', '', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 16:07:17', 'admin', null, '', 'admin', '2018-06-21 16:32:40', '1', null);
INSERT INTO `cn_good` VALUES ('180', '电梯广告框', null, '13.00', '20.00', '', '', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 16:39:36', 'admin', null, '', 'admin', '2018-06-22 09:58:04', '1', null);
INSERT INTO `cn_good` VALUES ('181', '电梯广告框 仿大理石', null, '35.00', '55.00', '', 'http://img.cnadmart.com/20180621/7f2c9fe482f84cdaa349b6f5083664b9.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-21 16:42:08', 'admin', null, '', 'admin', '2018-06-22 09:58:08', '1', null);
INSERT INTO `cn_good` VALUES ('182', '木托奖牌', null, '6.00', '12.00', '', 'http://img.cnadmart.com/20180622/8e877cae39f142d095ed1cdf52f68ab4.png', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-22 09:07:47', 'admin', null, '', 'admin', '2018-06-22 09:58:17', '1', null);
INSERT INTO `cn_good` VALUES ('183', '胸卡吊牌 胸卡硬卡 横款', null, '0.30', '0.40', '', 'http://img.cnadmart.com/20180622/cb3cf6c3333c48cc8a3c645201d61e8f.jpg', '0', '0', '0', '0', '1', '', '个', '1', null, '', '', '', '2018-06-22 09:57:18', 'admin', null, '', 'admin', '2018-06-22 09:58:32', '1', null);
INSERT INTO `cn_good` VALUES ('184', '胸卡吊牌 胸卡硬卡 竖款', null, '0.30', '0.50', '', 'http://img.cnadmart.com/20180622/703514daded74bd397dbcdf7d5f153b5.jpg', '0', '0', '0', '0', '0', '', '个', '1', null, '', '', '', '2018-06-22 10:26:16', 'admin', null, '', 'admin', '2018-06-22 10:27:22', '1', null);
INSERT INTO `cn_good` VALUES ('185', 'tst', null, '0.00', '0.00', 'wste', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-24 17:47:12', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('186', 'sdfgdfg ', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-25 09:01:56', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('187', '22', null, '0.00', '0.00', '22', '', '0', '0', '0', '0', '1', '', null, '1', null, '', '', '', '2018-06-25 21:51:57', 'admin', null, '', 'admin', '2018-06-25 21:53:05', '1', null);
INSERT INTO `cn_good` VALUES ('188', 'df ', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-25 22:49:18', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('189', '德辅道', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-26 10:23:58', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('190', '嗲是打发', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-26 14:27:57', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('191', 'admin', null, '0.00', '0.00', 'admin', '', '1', '0', '0', '1', '0', '', '1111', '1', 'admin', 'admin', 'admin', 'admin', '2018-06-26 18:13:02', 'admin', null, '', 'admin', '2018-07-15 00:17:29', '1', null);
INSERT INTO `cn_good` VALUES ('192', 'dsafdsf', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-26 18:22:28', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('193', 'aaa', null, '0.00', '0.00', 'aaaa', '', '0', '0', '0', '1', '0', '', '1', '0', null, '', '', '', '2018-06-26 19:06:24', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('194', 'test', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-26 21:39:38', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('195', 'test', null, '44.00', '44.00', '', '', '0', '0', '0', '0', '0', '', null, '1', null, '', '', '', '2018-06-26 21:46:07', 'admin', null, '', 'admin', '2018-06-26 21:47:19', '1', null);
INSERT INTO `cn_good` VALUES ('196', 'cs', null, '0.00', '0.00', 'cs', '', '0', '0', '0', '0', '0', '', '1', '0', 'cs', 'cs', 'cs', 'cs', '2018-06-26 22:32:14', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('197', '11', null, '0.00', '0.00', '11', '', '0', '0', '0', '0', '0', '', '11', '0', '11', '11', '11', '11', '2018-06-27 09:13:33', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('198', '11', null, '0.00', '0.00', '11', '', '0', '0', '0', '0', '0', '', '11', '1', '11', '11', '11', '11', '2018-06-27 09:14:36', 'admin', null, '', 'admin', '2018-06-27 09:15:40', '1', null);
INSERT INTO `cn_good` VALUES ('199', 'fdgdg', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-27 09:15:35', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('200', 'SSS测试', null, '0.00', '0.00', 'SSS测试', '', '0', '0', '0', '0', '1', '', 'SSS测试', '0', 'SSS测试', 'SSS测试', 'SSS测试', 'SSS测试', '2018-06-27 09:57:33', 'admin', null, '', 'admin', '2018-06-27 09:57:54', '1', null);
INSERT INTO `cn_good` VALUES ('201', 'asdf', null, '111.00', '232.00', 'sadfasdfsd', '', '0', '0', '0', '0', '0', '', 'k', '1', null, '', '', '', '2018-06-27 13:44:07', 'admin', null, '', 'admin', '2018-06-27 13:45:37', '1', null);
INSERT INTO `cn_good` VALUES ('202', '123', null, '0.00', '2.00', '', '', '0', '0', '0', '0', '0', '', null, '1', null, '', '', '', '2018-06-27 15:54:39', 'admin', null, '', 'admin', '2018-06-27 15:55:43', '1', null);
INSERT INTO `cn_good` VALUES ('203', '1', null, '0.00', '0.00', '1', '', '0', '0', '0', '0', '0', '', '1', '0', '1', '1', '1', '1', '2018-06-27 16:42:49', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('204', 'ssss', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-06-28 16:56:17', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('205', 'cfds', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '1', null, '', '', '', '2018-06-28 16:58:00', 'admin', null, '', 'admin', '2018-06-28 16:59:04', '1', null);
INSERT INTO `cn_good` VALUES ('208', 'rer', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-02 08:30:38', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('209', 'dsfdsf', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-02 10:45:31', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('210', '1q', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-02 13:01:16', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('211', '1q', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-02 13:01:19', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('213', '13123123112312312', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', '123123', '0', null, '', '', '', '2018-07-04 14:54:19', 'admin', null, '', 'admin', '2018-07-05 16:03:24', '1', null);
INSERT INTO `cn_good` VALUES ('215', '234234', null, '0.00', '0.00', '234234', '', '0', '0', '0', '0', '0', '', '234234', '0', null, '', '', '', '2018-07-05 16:52:46', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('216', '皮皮测试', null, '0.00', '0.00', '皮皮测试皮皮测试皮皮测试皮皮测试皮皮测试皮皮测试皮皮测试皮皮测试皮皮测试', '', '0', '0', '0', '0', '0', '', '问问', '0', '撒打算的', '为', '反反复复反反复复反反复复', '问问', '2018-07-05 17:37:25', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('217', 'jjjjjjjjjj', null, '0.00', '0.00', 'gggggggggggggggggggggg', '', '0', '0', '0', '0', '0', '', 'g', '0', '2222222222222222', '11111111111111', '11111111111111111', '222222222222222', '2018-07-05 18:50:20', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('218', '56454', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-05 22:19:32', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('219', '56454', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-05 22:19:43', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('220', '11', null, '0.00', '0.00', '11', '', '1', '0', '0', '1', '0', '', '11', '0', '11', '11', '11', '11', '2018-07-05 23:40:19', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('221', '测试', null, '0.00', '0.00', '测试', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-06 03:02:08', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('222', 'test', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-06 10:37:09', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('223', '222', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-06 10:49:54', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('224', '131231', null, '0.00', '0.00', '131321', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-06 13:48:24', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('225', '辣酱一瓶', null, '0.00', '0.00', '辣酱一瓶', '', '1', '0', '0', '1', '0', '', null, '0', null, '辣酱一瓶辣酱一瓶', '辣酱一瓶', '辣酱一瓶', '2018-07-06 13:55:43', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('226', '辣酱一瓶', null, '0.00', '0.00', '辣酱一瓶', '', '1', '0', '0', '1', '0', '', null, '0', null, '辣酱一瓶辣酱一瓶', '辣酱一瓶', '辣酱一瓶', '2018-07-06 13:55:55', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('227', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', null, '0', 'test', '', '', '', '2018-07-06 14:49:16', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('228', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', null, '0', 'test', '', '', '', '2018-07-06 15:04:30', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('229', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-06 15:04:47', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('230', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-06 15:04:53', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('231', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-06 15:07:25', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('232', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-06 15:07:26', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('233', 'test', null, '0.00', '0.00', 'test', '', '1', '0', '0', '1', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-06 15:07:26', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('234', 'qwe', null, '0.00', '0.00', 'qwe', '', '1', '0', '0', '1', '0', '', 'qwe', '0', 'qwe', 'qwe', 'qwe', 'qwe', '2018-07-06 15:13:43', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('235', 'qwe', null, '0.00', '0.00', 'qwe', '', '1', '0', '0', '1', '0', '', 'qwe', '0', 'qwe', 'qwe', 'qwe', 'qwe', '2018-07-06 15:13:51', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('236', '111', null, '0.00', '0.00', '111', '', '0', '0', '0', '0', '1', '', '111', '0', '11', '11', '111', '11111', '2018-07-06 17:44:29', 'admin', null, '', 'admin', '2018-07-26 10:04:39', '1', null);
INSERT INTO `cn_good` VALUES ('238', '测试', null, '10.00', '10.00', '111', '', '0', '0', '0', '0', '0', '', '1', '1', '测试11111111', '测试', '测试', '测试', '2018-07-08 23:59:24', 'admin', null, '', 'admin', '2018-07-31 11:25:46', '1', null);
INSERT INTO `cn_good` VALUES ('239', '123', null, '0.00', '0.00', '123123', '', '0', '0', '0', '0', '0', '', '123213', '0', '123', '123', '123', '123', '2018-07-09 15:16:02', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('240', '22', null, '0.00', '0.00', '222', '', '0', '0', '0', '0', '0', '', '2', '0', '233333333', '3432', '3243', '2432', '2018-07-09 15:28:25', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('242', 'hahahaa', null, '0.00', '0.00', 'hahahaa', '', '1', '0', '0', '0', '0', '', 'hahahaa', '0', 'hahahaa', 'hahahaa', 'hahahaa', 'hahahaa', '2018-07-09 15:44:24', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('243', '13', null, '0.00', '0.00', '123', '', '0', '0', '0', '0', '0', '', null, '0', null, '', '', '', '2018-07-10 17:29:10', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('244', '111', null, '1.00', '1.00', '111', '', '0', '0', '0', '0', '1', '', '11', '1', '11', '11', '11', '11', '2018-07-11 11:10:58', 'admin', null, '', 'admin', '2018-08-01 11:01:38', '1', null);
INSERT INTO `cn_good` VALUES ('245', '测试', null, '0.00', '0.00', '咑大', '', '0', '0', '0', '0', '0', '', '盒', '0', '方法', '方法', '方法', '烦烦烦', '2018-07-11 16:32:40', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('246', '测试', null, '0.00', '0.00', '咑大', '', '0', '0', '0', '0', '0', '', '盒', '0', '方法', '方法', '方法', '烦烦烦', '2018-07-11 16:33:08', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('247', '测试', null, '0.00', '0.00', '咑大', '', '0', '0', '0', '0', '0', '', '盒', '0', '方法', '方法', '方法', '烦烦烦', '2018-07-11 16:33:18', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('248', 'aaaa', null, '50.00', '50.00', 'aaaq', '', '0', '0', '0', '0', '0', '', '个', '1', '啊啊', '啊啊啊', '啊啊', '啊啊啊', '2018-07-11 21:26:34', 'admin', null, '', 'admin', '2018-07-17 13:35:15', '1', null);
INSERT INTO `cn_good` VALUES ('249', 'aaaaaaaaaaaaaaaa', null, '0.00', '0.00', 'aaaaa', '', '0', '0', '0', '0', '0', '', 'a', '0', 'a', 'a', 'a', 'a', '2018-07-12 15:13:41', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('250', '111', null, '0.00', '0.00', '1122', '', '0', '0', '0', '0', '0', '', null, '0', '222', '111', '11', '', '2018-07-15 17:23:38', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('251', 'adas', null, '0.00', '0.00', 'da', '', '1', '0', '0', '1', '0', '', '个', '0', '发送到对方是', '发送到啊asdf', '电风扇啊ga', '第三方啊', '2018-07-17 18:22:19', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('252', 'qe ', null, '0.00', '0.00', 'qweq', '', '0', '0', '0', '0', '0', '', 'qwe', '0', 'wqe', 'qwe', 'qwe', 'qwe', '2018-07-18 15:12:19', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('253', '啦啦', null, '0.00', '0.00', '啦啦啦啦啦啦啦啦啦啦啦啦', '', '1', '0', '0', '1', '0', '', '个', '0', '啦啦啦', '啦啦啦啦啦啦', '啦啦啦啦啦啦', '啦啦啦啦啦啦', '2018-07-18 16:58:55', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('254', '啦啦', null, '0.00', '0.00', '啦啦啦啦啦啦啦啦啦啦啦啦', '', '1', '0', '0', '1', '0', '', '个', '0', '啦啦啦', '啦啦啦啦啦啦', '啦啦啦啦啦啦', '啦啦啦啦啦啦', '2018-07-18 16:59:09', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('255', '2', null, '0.00', '0.00', '3', '', '0', '0', '0', '0', '0', '', '4', '0', '5', '6', '7', '8', '2018-07-25 14:30:46', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('256', '2', null, '2.00', '2.00', '3', '', '0', '0', '0', '0', '0', '', '4', '1', '5', '6', '7', '8', '2018-07-25 14:32:52', 'admin', null, '', 'admin', '2018-07-25 14:33:33', '1', null);
INSERT INTO `cn_good` VALUES ('257', 'hello', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:11:52', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('258', 'hello', null, '0.00', '0.00', '', '', '0', '0', '0', '0', '0', '', null, '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:11:59', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('259', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:07', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('260', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:32', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('261', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:32', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('262', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:35', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('263', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:42', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('264', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:52', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('265', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:12:59', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('266', 'hello', null, '0.00', '0.00', '333', '', '0', '0', '0', '0', '0', '', '1', '0', 'test', 'test', '222`wqwe', '3233', '2018-07-26 14:13:17', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('267', '1', null, '0.00', '0.00', '1', '', '0', '0', '0', '0', '0', '', null, '0', '1', '1', '1', '1', '2018-07-27 18:46:34', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('268', 'test', null, '0.00', '0.00', 'test', '', '0', '0', '0', '0', '0', '', 'test', '0', 'test', 'test', 'test', 'test', '2018-07-29 17:35:26', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('269', '23423', null, '0.00', '0.00', '2342', '', '0', '0', '0', '0', '0', '', '234', '0', '23423', '2342', '3423', '4234', '2018-07-29 20:33:59', 'admin', null, '', '', null, '1', null);
INSERT INTO `cn_good` VALUES ('270', 'dsfsdfs', null, '0.00', '0.00', 'dfsdfsdfsd', '', '1', '0', '0', '1', '0', '', 'sdfsdf', '0', 'sdfsdf', 'sdfsdfsd', 'fsdfsdfsdf', 'sdfsdfsdf', '2018-08-04 06:30:20', 'admin', null, '', '', null, '1', null);

-- ----------------------------
-- Table structure for cn_good_attribute
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_attribute`;
CREATE TABLE `cn_good_attribute` (
  `attribute_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `stock` bigint(20) DEFAULT '0' COMMENT '总库存',
  `sales_volume` bigint(20) DEFAULT '0' COMMENT '销售量',
  `page_views` bigint(20) DEFAULT '0' COMMENT '总访问量',
  `comment_number` bigint(20) DEFAULT '0' COMMENT '评论数量',
  `comment_total` bigint(20) DEFAULT '0' COMMENT '累计评价',
  `comment_average` decimal(10,2) DEFAULT '0.00' COMMENT '平均评价',
  `favorite_number` bigint(20) DEFAULT '0' COMMENT '收藏数',
  `question_number` bigint(20) DEFAULT '0' COMMENT '提问数',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='商品属性表';

-- ----------------------------
-- Records of cn_good_attribute
-- ----------------------------
INSERT INTO `cn_good_attribute` VALUES ('1', '1', '19887', '500', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('36', '96', '55', '144', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('37', '206', '2', '2', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('38', '97', '0', '0', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('39', '99', '451499', '0', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('40', '207', '0', '0', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('41', '212', '10', '0', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('43', '214', '492', '2481', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('54', '95', '7', '7', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('55', '237', '0', '0', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('56', '238', '20', '2', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('57', '241', '400', '4', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('58', '244', '1', '1', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('59', '248', '1', '50', '0', '0', '0', '0.00', '0', '0');
INSERT INTO `cn_good_attribute` VALUES ('60', '256', '1', '3', '0', '0', '0', '0.00', '0', '0');

-- ----------------------------
-- Table structure for cn_good_detail
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_detail`;
CREATE TABLE `cn_good_detail` (
  `good_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品描述ID',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `description` text COMMENT '商品描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`good_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品描述表';

-- ----------------------------
-- Records of cn_good_detail
-- ----------------------------

-- ----------------------------
-- Table structure for cn_good_image
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_image`;
CREATE TABLE `cn_good_image` (
  `pic_img_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品图片ID',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `sort` tinyint(2) DEFAULT NULL COMMENT '排序',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`pic_img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=347 DEFAULT CHARSET=utf8 COMMENT='商品图片表';

-- ----------------------------
-- Records of cn_good_image
-- ----------------------------
INSERT INTO `cn_good_image` VALUES ('128', '120', 'http://img.cnadmart.com/20180615/325d943071594572acc00f80eae68367.png', null, '1', '2018-06-15 15:31:09', 'admin');
INSERT INTO `cn_good_image` VALUES ('129', '121', 'http://img.cnadmart.com/20180615/06dcb0dbe1374c2bb47e02d8730ca820.png', null, '1', '2018-06-15 15:34:20', 'admin');
INSERT INTO `cn_good_image` VALUES ('130', '122', 'http://img.cnadmart.com/20180615/19cef6286cbc4e2eb39c1a47f80d4a12.jpg', null, '1', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('131', '122', 'http://img.cnadmart.com/20180615/a6949074b2fe4339a4ce662f4527e74b.png', null, '1', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('132', '122', 'http://img.cnadmart.com/20180615/e56414aabda444f4a7139fa0d9c3a504.jpg', null, '1', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('133', '122', 'http://img.cnadmart.com/20180615/84beb8a6b98647809737140008baaeeb.jpg', null, '1', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('134', '122', 'http://img.cnadmart.com/20180615/90a3c9c141b54c3a9cafd1f71587023c.jpg', null, '1', '2018-06-15 15:38:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('135', '123', 'http://img.cnadmart.com/20180619/efd9fd3a3aad4eaf99a4db6490746cdf.jpg', null, '1', '2018-06-19 08:54:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('136', '123', 'http://img.cnadmart.com/20180619/b96166b7bb334b068fd3b77afda30153.jpg', null, '1', '2018-06-19 08:54:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('137', '123', 'http://img.cnadmart.com/20180619/97306539728c4906a9833df216cb467d.jpg', null, '1', '2018-06-19 08:54:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('138', '123', 'http://img.cnadmart.com/20180619/a8fad7a0b12c43e1a434c7a06113903b.png', null, '1', '2018-06-19 08:54:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('139', '128', 'http://img.cnadmart.com/20180619/778e8d9bc92b4e2ea31d55b2ec777ec8.png', null, '1', '2018-06-19 09:06:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('140', '128', 'http://img.cnadmart.com/20180619/ffb6c6f5f6e2443d971376cbfea6d274.png', null, '1', '2018-06-19 09:06:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('141', '128', 'http://img.cnadmart.com/20180619/58981824fa0c44939d4e3d2ac79d0600.png', null, '1', '2018-06-19 09:06:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('143', '129', 'http://img.cnadmart.com/20180619/d702a0f6b4dd485d88d9e78b4c9eb8db.jpg', null, '1', '2018-06-19 09:13:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('144', '129', 'http://img.cnadmart.com/20180619/08fee5f3d8504a258eab16f303b106f8.jpg', null, '1', '2018-06-19 09:13:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('145', '129', 'http://img.cnadmart.com/20180619/7a5b7e47a0ab432dbfd02fe4f1721853.jpg', null, '1', '2018-06-19 09:13:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('146', '129', 'http://img.cnadmart.com/20180619/198723bcdcce432f8d29d0f8725d6093.jpg', null, '1', '2018-06-19 09:13:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('147', '130', 'http://img.cnadmart.com/20180619/4462d36cde03491886f4ae132478e443.jpg', null, '1', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_good_image` VALUES ('148', '130', 'http://img.cnadmart.com/20180619/a5e37a9fbd2c4742a8a969a52bb637f4.jpg', null, '1', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_good_image` VALUES ('149', '130', 'http://img.cnadmart.com/20180619/8e5b3c3c9d03488fb2bf4b966cc6906e.jpg', null, '1', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_good_image` VALUES ('150', '130', 'http://img.cnadmart.com/20180619/ee2c1c6348ff4070aefa8b3eb82432cc.jpg', null, '1', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_good_image` VALUES ('151', '130', 'http://img.cnadmart.com/20180619/6790d3f41e074f14b3a7e221ad382c10.jpg', null, '1', '2018-06-19 09:25:34', 'admin');
INSERT INTO `cn_good_image` VALUES ('152', '131', 'http://img.cnadmart.com/20180619/44a71e6459cb404bb618c60b0d29052b.jpg', null, '1', '2018-06-19 09:36:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('153', '131', 'http://img.cnadmart.com/20180619/5f412d0450484631bb88531e975fc5cc.jpg', null, '1', '2018-06-19 09:36:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('154', '131', 'http://img.cnadmart.com/20180619/3aa0989583e04314ad830b307f2f4835.jpg', null, '1', '2018-06-19 09:36:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('155', '131', 'http://img.cnadmart.com/20180619/35d09f2d5c6949369017aeb71aa5a453.jpg', null, '1', '2018-06-19 09:36:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('157', '132', 'http://img.cnadmart.com/20180619/6a8aa55c15f649b6bce0b5f780bf899c.jpg', null, '1', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('158', '132', 'http://img.cnadmart.com/20180619/647cec32ab0b4f5fa29bfdd066476c85.jpg', null, '1', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('159', '132', 'http://img.cnadmart.com/20180619/bbb306c74e0e4911bc92fa422ff72007.jpg', null, '1', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('160', '132', 'http://img.cnadmart.com/20180619/65b49cc3f9ac4c7d8aa5c3850f929c5d.jpg', null, '1', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('161', '132', 'http://img.cnadmart.com/20180619/9be15186dfcb4fe9bfa4372dc9c14944.jpg', null, '1', '2018-06-19 10:52:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('162', '133', 'http://img.cnadmart.com/20180619/15f798346c3d43db88248cc31e6db53d.jpg', null, '1', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_good_image` VALUES ('163', '133', 'http://img.cnadmart.com/20180619/41ab319736b94a718d13e49347df862f.jpg', null, '1', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_good_image` VALUES ('164', '133', 'http://img.cnadmart.com/20180619/182191f61163493da83bbfcec5d713a2.jpg', null, '1', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_good_image` VALUES ('165', '133', 'http://img.cnadmart.com/20180619/46d883eff74b4f4f808a9fa70dbfd615.jpg', null, '1', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_good_image` VALUES ('166', '133', 'http://img.cnadmart.com/20180619/1be8633155314e1395ca3bafef2ae76c.jpg', null, '1', '2018-06-19 10:55:21', 'admin');
INSERT INTO `cn_good_image` VALUES ('167', '135', 'http://img.cnadmart.com/20180619/b59a5b522379495f83a7bbabbef66e27.png', null, '1', '2018-06-19 11:49:17', 'admin');
INSERT INTO `cn_good_image` VALUES ('168', '137', 'http://img.cnadmart.com/20180619/63449fc25d554287b34905404cf860d0.jpg', null, '1', '2018-06-19 13:47:07', 'admin');
INSERT INTO `cn_good_image` VALUES ('169', '137', 'http://img.cnadmart.com/20180619/f4555cead2514f0db334a45c8e2996eb.png', null, '1', '2018-06-19 13:47:07', 'admin');
INSERT INTO `cn_good_image` VALUES ('174', '140', 'http://img.cnadmart.com/20180619/801a032ce82547879fdf7a492e5a3675.jpg', null, '1', '2018-06-19 13:55:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('175', '140', 'http://img.cnadmart.com/20180619/4a79d7055eff483da4d18d7c30198a53.jpg', null, '1', '2018-06-19 13:55:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('176', '140', 'http://img.cnadmart.com/20180619/caf3c9f2a1bc4c50944da6fb305dfc7d.jpg', null, '1', '2018-06-19 13:55:10', 'admin');
INSERT INTO `cn_good_image` VALUES ('177', '141', 'http://img.cnadmart.com/20180619/938071a98cb04f3ebc6d77ba4279994b.jpg', null, '1', '2018-06-19 13:56:42', 'admin');
INSERT INTO `cn_good_image` VALUES ('178', '142', 'http://img.cnadmart.com/20180619/244eb408cc9a4b26a7ee2c48ac1945fd.jpg', null, '1', '2018-06-19 13:59:45', 'admin');
INSERT INTO `cn_good_image` VALUES ('179', '142', 'http://img.cnadmart.com/20180619/0c024130a7ce4ce7b60dff3de01eed08.jpg', null, '1', '2018-06-19 13:59:45', 'admin');
INSERT INTO `cn_good_image` VALUES ('180', '142', 'http://img.cnadmart.com/20180619/2356789fec73434fb7ea9c0a1edcca7c.jpg', null, '1', '2018-06-19 13:59:45', 'admin');
INSERT INTO `cn_good_image` VALUES ('181', '142', 'http://img.cnadmart.com/20180619/9efeb04c122049edb5dcfe23cf575ec4.jpg', null, '1', '2018-06-19 13:59:45', 'admin');
INSERT INTO `cn_good_image` VALUES ('182', '143', 'http://img.cnadmart.com/20180619/26d80045ec7749aeb2a51d28dd3f7246.jpg', null, '1', '2018-06-19 14:07:38', 'admin');
INSERT INTO `cn_good_image` VALUES ('186', '145', 'http://img.cnadmart.com/20180619/78fb9ab063254ad79256c4a16c24599a.png', null, '1', '2018-06-19 14:12:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('187', '145', 'http://img.cnadmart.com/20180619/9a6693f9ea60493e972f69c8ee5ff078.png', null, '1', '2018-06-19 14:12:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('188', '145', 'http://img.cnadmart.com/20180619/4d9f42c4fcfa4626a5b2a3bfd411035c.png', null, '1', '2018-06-19 14:12:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('189', '146', 'http://img.cnadmart.com/20180619/4cc7dbfeb003432898752e395722092c.jpg', null, '1', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_good_image` VALUES ('190', '146', 'http://img.cnadmart.com/20180619/12aa49471f15478fb66e457d59a04600.jpg', null, '1', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_good_image` VALUES ('191', '146', 'http://img.cnadmart.com/20180619/8a668b311bc64750b4e3a815ac4ebb22.jpg', null, '1', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_good_image` VALUES ('192', '146', 'http://img.cnadmart.com/20180619/7aa50a3d7cf644b6973701373c15cb0f.jpg', null, '1', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_good_image` VALUES ('193', '146', 'http://img.cnadmart.com/20180619/b3b51066e098412e84b7527b3504532f.png', null, '1', '2018-06-19 14:15:35', 'admin');
INSERT INTO `cn_good_image` VALUES ('194', '148', 'http://img.cnadmart.com/20180619/dc15e575cb9e437dabde060954c1239f.jpg', null, '1', '2018-06-19 14:24:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('195', '148', 'http://img.cnadmart.com/20180619/9e7b6067269847a0b0c0e7e7be0fd178.png', null, '1', '2018-06-19 14:24:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('196', '148', 'http://img.cnadmart.com/20180619/2fe6cb7863bc4445b050ca8ad1f361ae.png', null, '1', '2018-06-19 14:24:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('197', '149', 'http://img.cnadmart.com/20180619/fcc7cd0e1a1f4b85b2ef9eea0c16d4d2.jpg', null, '1', '2018-06-19 14:26:42', 'admin');
INSERT INTO `cn_good_image` VALUES ('198', '149', 'http://img.cnadmart.com/20180619/7ca51255e1654c12b69e19ef98dece3a.jpg', null, '1', '2018-06-19 14:26:42', 'admin');
INSERT INTO `cn_good_image` VALUES ('199', '149', 'http://img.cnadmart.com/20180619/0c4f6cbe7fda4efb83778f6c1d9e484b.jpg', null, '1', '2018-06-19 14:26:42', 'admin');
INSERT INTO `cn_good_image` VALUES ('200', '149', 'http://img.cnadmart.com/20180619/b271e066e1f945559861fbaa714d6fc6.png', null, '1', '2018-06-19 14:26:42', 'admin');
INSERT INTO `cn_good_image` VALUES ('206', '151', 'http://img.cnadmart.com/20180620/6285bef6720346e1a4c45a640f58093a.jpg', null, null, '2018-06-20 08:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('207', '151', 'http://img.cnadmart.com/20180620/c7eeee9bf50248dfad4faea3eabf179f.jpg', null, null, '2018-06-20 08:46:15', 'admin');
INSERT INTO `cn_good_image` VALUES ('208', '151', 'http://img.cnadmart.com/20180620/26b39907b8514ccb8f9d5b80b333caef.jpg', null, null, '2018-06-20 08:46:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('209', '151', 'http://img.cnadmart.com/20180620/44d5a59ca8f44341a391c91f7974a125.jpg', null, null, '2018-06-20 08:46:17', 'admin');
INSERT INTO `cn_good_image` VALUES ('215', '153', 'http://img.cnadmart.com/20180620/0605430737c947b39f714c4bde436891.png', null, '1', '2018-06-20 09:33:13', 'admin');
INSERT INTO `cn_good_image` VALUES ('216', '153', 'http://img.cnadmart.com/20180620/1fccdb2f641847f6a533a9769fac2aeb.png', null, '1', '2018-06-20 09:33:13', 'admin');
INSERT INTO `cn_good_image` VALUES ('228', '156', 'http://img.cnadmart.com/20180620/ce421d3db0d0485cad711681bf300cfb.jpg', null, '1', '2018-06-20 14:35:52', 'admin');
INSERT INTO `cn_good_image` VALUES ('229', '156', 'http://img.cnadmart.com/20180620/1491baaa11d94137bc489ad4d71cffe5.jpg', null, '1', '2018-06-20 14:35:52', 'admin');
INSERT INTO `cn_good_image` VALUES ('230', '156', 'http://img.cnadmart.com/20180620/8c0604280291400ba2d40022e9b65c61.jpg', null, '1', '2018-06-20 14:35:52', 'admin');
INSERT INTO `cn_good_image` VALUES ('231', '156', 'http://img.cnadmart.com/20180620/a507265d76a84650858f38f95d4ae1a5.jpg', null, '1', '2018-06-20 14:35:52', 'admin');
INSERT INTO `cn_good_image` VALUES ('237', '158', 'http://img.cnadmart.com/20180620/6526cdfc80ab42afaea6dd867b3298a0.png', null, '1', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('238', '158', 'http://img.cnadmart.com/20180620/bdd8ffc651834f19826928cfec72ba63.jpg', null, '1', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('239', '158', 'http://img.cnadmart.com/20180620/9444c038e16e47369963fa1d23f33cb4.jpg', null, '1', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('240', '158', 'http://img.cnadmart.com/20180620/0de0370bfa9b49aba73d2d55ca218d3b.jpg', null, '1', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('241', '158', 'http://img.cnadmart.com/20180620/710da9d8961e410b8f4af0dde598fc77.jpg', null, '1', '2018-06-20 14:45:54', 'admin');
INSERT INTO `cn_good_image` VALUES ('247', '160', 'http://img.cnadmart.com/20180620/1dd41d156c6143da83331a9e456440f7.jpg', null, '1', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('248', '160', 'http://img.cnadmart.com/20180620/116053af60004c97be91578546c46700.jpg', null, '1', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('249', '160', 'http://img.cnadmart.com/20180620/98c952bdd43949d1ab3ff88786b36535.png', null, '1', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('250', '160', 'http://img.cnadmart.com/20180620/acebc2160c084a5b95f36d57dd4d431d.png', null, '1', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('251', '160', 'http://img.cnadmart.com/20180620/398ea92d2378457784aa393fc1d8423c.jpg', null, '1', '2018-06-20 15:00:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('252', '161', 'http://img.cnadmart.com/20180620/0d63b57ae9b140fa9f618c03a30c62a3.jpg', null, '1', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('253', '161', 'http://img.cnadmart.com/20180620/a1b2f67855624e89971a6dee1f311e3b.jpg', null, '1', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('254', '161', 'http://img.cnadmart.com/20180620/0e1bf45a8ac446b0901b4aa478dcc3aa.jpg', null, '1', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('255', '161', 'http://img.cnadmart.com/20180620/0543378a4ac949189078c0c5a7ce1269.jpg', null, '1', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('256', '161', 'http://img.cnadmart.com/20180620/3d96eff870f94a869b699a07d9efcfc5.jpg', null, '1', '2018-06-20 15:30:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('257', '162', 'http://img.cnadmart.com/20180620/802886618b9447628b13561c227ad42b.jpg', null, '1', '2018-06-20 16:59:01', 'admin');
INSERT INTO `cn_good_image` VALUES ('258', '162', 'http://img.cnadmart.com/20180620/8bf7b59e9af44fc39406cb061933dc89.jpg', null, '1', '2018-06-20 16:59:01', 'admin');
INSERT INTO `cn_good_image` VALUES ('259', '162', 'http://img.cnadmart.com/20180620/73e14e475d4c424793e39ab556afbcf7.jpg', null, '1', '2018-06-20 16:59:01', 'admin');
INSERT INTO `cn_good_image` VALUES ('260', '162', 'http://img.cnadmart.com/20180620/d7905ed1e23441018b4024509187682e.jpg', null, '1', '2018-06-20 16:59:01', 'admin');
INSERT INTO `cn_good_image` VALUES ('261', '163', 'http://img.cnadmart.com/20180621/78df7cef996b4e3cbea7ff0bb83b9be3.jpg', null, null, '2018-06-21 09:34:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('262', '163', 'http://img.cnadmart.com/20180621/c329237fc36145cdaa1d868ee87bb780.jpg', null, null, '2018-06-21 09:34:17', 'admin');
INSERT INTO `cn_good_image` VALUES ('263', '163', 'http://img.cnadmart.com/20180621/bba11be0cd324634b3fb97fcd130dd9c.jpg', null, null, '2018-06-21 09:34:18', 'admin');
INSERT INTO `cn_good_image` VALUES ('264', '163', 'http://img.cnadmart.com/20180621/4b970ca72a6a46518c0be22187f18bf5.jpg', null, null, '2018-06-21 09:34:19', 'admin');
INSERT INTO `cn_good_image` VALUES ('265', '164', 'http://img.cnadmart.com/20180621/d31567efa2654795a57c058a29836b94.png', null, '1', '2018-06-21 09:36:46', 'admin');
INSERT INTO `cn_good_image` VALUES ('271', '166', 'http://img.cnadmart.com/20180621/06506053056b4954b276fc596aa9739e.jpg', null, '1', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('272', '166', 'http://img.cnadmart.com/20180621/c9b5a86aff904223966dab00de5d097d.png', null, '1', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('273', '166', 'http://img.cnadmart.com/20180621/0dabae1261e4487eafd0e0123a61a951.jpg', null, '1', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('274', '166', 'http://img.cnadmart.com/20180621/b40fd2668924431ca3091a43d0790d57.jpg', null, '1', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('275', '166', 'http://img.cnadmart.com/20180621/6e210167740048d3b96fe4969b35c16c.jpg', null, '1', '2018-06-21 09:46:14', 'admin');
INSERT INTO `cn_good_image` VALUES ('276', '168', 'http://img.cnadmart.com/20180621/17fe22748ec64ac98a5ae96fe15fddcc.png', null, '1', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_good_image` VALUES ('277', '168', 'http://img.cnadmart.com/20180621/fa4fc5fe071846588e4f9a594c786b5c.jpg', null, '1', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_good_image` VALUES ('278', '168', 'http://img.cnadmart.com/20180621/e20d39f4e66c42aca0f7e867807af8c4.jpg', null, '1', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_good_image` VALUES ('279', '168', 'http://img.cnadmart.com/20180621/9ffe65073e7c42888022524cb37192d6.jpg', null, '1', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_good_image` VALUES ('280', '168', 'http://img.cnadmart.com/20180621/e98deee902c1407ab62a02b5c4e13f84.jpg', null, '1', '2018-06-21 09:58:31', 'admin');
INSERT INTO `cn_good_image` VALUES ('286', '170', 'http://img.cnadmart.com/20180621/e2351850dc7a429083fa577b30c01ccd.png', null, '1', '2018-06-21 10:34:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('287', '171', 'http://img.cnadmart.com/20180621/6be85375e45f4eea8b75e222dad9b8a8.jpg', null, '1', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_good_image` VALUES ('288', '171', 'http://img.cnadmart.com/20180621/ac1704a3be7544478a8b731ee5de7924.jpg', null, '1', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_good_image` VALUES ('289', '171', 'http://img.cnadmart.com/20180621/c6a2073a62484b6781abc2e5abfc608d.jpg', null, '1', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_good_image` VALUES ('290', '171', 'http://img.cnadmart.com/20180621/7bcec5d2b870494caaaf3a4e1a40b8fe.jpg', null, '1', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_good_image` VALUES ('291', '171', 'http://img.cnadmart.com/20180621/7bcc7a0333034892a148e9688944b4b4.jpg', null, '1', '2018-06-21 10:37:39', 'admin');
INSERT INTO `cn_good_image` VALUES ('292', '172', 'http://img.cnadmart.com/20180621/479bb09929944bcc8b3ec4fb0aedba05.png', null, '1', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('293', '172', 'http://img.cnadmart.com/20180621/0ccb7b843c4647399665c132b09b118d.jpg', null, '1', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('294', '172', 'http://img.cnadmart.com/20180621/8d19e6a0bcfb4eac9ecd417901e1a242.jpg', null, '1', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('295', '172', 'http://img.cnadmart.com/20180621/31368537458f42c092f5ec8af069f895.jpg', null, '1', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('296', '172', 'http://img.cnadmart.com/20180621/3b44933476004bc4b83c259b23d036d6.jpg', null, '1', '2018-06-21 11:19:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('297', '173', 'http://img.cnadmart.com/20180621/551d0619af6a4d49aa9751cec7428f19.jpg', null, '1', '2018-06-21 11:24:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('298', '174', 'http://img.cnadmart.com/20180621/cb3642f47c544eeca13cd4e277211111.png', null, '1', '2018-06-21 11:25:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('302', '176', 'http://img.cnadmart.com/20180621/860b4991571f4cf3937117c38fcd8d5c.jpg', null, '1', '2018-06-21 11:34:22', 'admin');
INSERT INTO `cn_good_image` VALUES ('303', '176', 'http://img.cnadmart.com/20180621/fc1da91d2f7f421689f3569a87172713.jpg', null, '1', '2018-06-21 11:34:22', 'admin');
INSERT INTO `cn_good_image` VALUES ('304', '176', 'http://img.cnadmart.com/20180621/8998e675a2504fddba252c759247ac42.png', null, '1', '2018-06-21 11:34:22', 'admin');
INSERT INTO `cn_good_image` VALUES ('305', '152', 'http://img.cnadmart.com/20180621/9174aa12b3654a60a5b78e7a483c0cb0.jpg', null, null, '2018-06-21 11:39:24', 'admin');
INSERT INTO `cn_good_image` VALUES ('306', '152', 'http://img.cnadmart.com/20180621/ece6a1cc7fd84ebbae21acbd3b75a27f.jpg', null, null, '2018-06-21 11:39:25', 'admin');
INSERT INTO `cn_good_image` VALUES ('307', '152', 'http://img.cnadmart.com/20180621/e07ac0af94ee4887aa1881aa748299f3.jpg', null, null, '2018-06-21 11:39:26', 'admin');
INSERT INTO `cn_good_image` VALUES ('308', '152', 'http://img.cnadmart.com/20180621/6a60e829af114007b6ff0d890580fc7a.jpg', null, null, '2018-06-21 11:39:29', 'admin');
INSERT INTO `cn_good_image` VALUES ('309', '152', 'http://img.cnadmart.com/20180621/31c796ae9a2e430288213a36cbb41817.png', null, null, '2018-06-21 11:39:32', 'admin');
INSERT INTO `cn_good_image` VALUES ('310', '177', 'http://img.cnadmart.com/20180621/a3563e30c71f4eba86852f1b71a34b8c.jpg', null, '1', '2018-06-21 14:08:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('311', '177', 'http://img.cnadmart.com/20180621/17594c5d284a49e5a1c33635ba87047d.jpg', null, '1', '2018-06-21 14:08:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('312', '177', 'http://img.cnadmart.com/20180621/b654e26e648b47a59b5979bcb291b6b7.jpg', null, '1', '2018-06-21 14:08:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('313', '177', 'http://img.cnadmart.com/20180621/505bf1dd7d4b4a1c9eade8897c4a65c1.jpg', null, '1', '2018-06-21 14:08:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('314', '153', 'http://img.cnadmart.com/20180621/a2211027ce9f4ae9ab42ef4f836d212b.png', null, null, '2018-06-21 14:22:01', 'admin');
INSERT INTO `cn_good_image` VALUES ('315', '155', 'http://img.cnadmart.com/20180621/185b0884a3bd4b1caec468e9cc1be5d1.jpg', null, null, '2018-06-21 14:27:58', 'admin');
INSERT INTO `cn_good_image` VALUES ('316', '155', 'http://img.cnadmart.com/20180621/6b7f32932e7243e2a8df465db64fc97c.jpg', null, null, '2018-06-21 14:27:58', 'admin');
INSERT INTO `cn_good_image` VALUES ('317', '155', 'http://img.cnadmart.com/20180621/6a2d24fa80d94d26b0d9811ec5f2dfe9.jpg', null, null, '2018-06-21 14:28:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('318', '155', 'http://img.cnadmart.com/20180621/08c3b9973b00406d8655ac06aa07526b.jpg', null, null, '2018-06-21 14:28:02', 'admin');
INSERT INTO `cn_good_image` VALUES ('319', '155', 'http://img.cnadmart.com/20180621/a12eda3e51da4390873a127ac322a57d.jpg', null, null, '2018-06-21 14:28:02', 'admin');
INSERT INTO `cn_good_image` VALUES ('320', '154', 'http://img.cnadmart.com/20180621/2bf8702f5cc345359605b00070c49ba9.jpg', null, null, '2018-06-21 14:41:03', 'admin');
INSERT INTO `cn_good_image` VALUES ('321', '154', 'http://img.cnadmart.com/20180621/c9ccb386b39840ae9d4d1a2169b79b50.jpg', null, null, '2018-06-21 14:41:04', 'admin');
INSERT INTO `cn_good_image` VALUES ('322', '154', 'http://img.cnadmart.com/20180621/4f73130ae4524964b4f43f14d78e8ae7.jpg', null, null, '2018-06-21 14:41:05', 'admin');
INSERT INTO `cn_good_image` VALUES ('323', '154', 'http://img.cnadmart.com/20180621/6dc6783973794fa3b6853900b0f59595.jpg', null, null, '2018-06-21 14:41:06', 'admin');
INSERT INTO `cn_good_image` VALUES ('324', '154', 'http://img.cnadmart.com/20180621/4aabdacb60cf492a9c0d2a7a252c7d95.jpg', null, null, '2018-06-21 14:41:11', 'admin');
INSERT INTO `cn_good_image` VALUES ('325', '154', 'http://img.cnadmart.com/20180621/d62913992f484ce3b72d75cf0967d6ce.jpg', null, null, '2018-06-21 14:41:13', 'admin');
INSERT INTO `cn_good_image` VALUES ('326', '178', 'http://img.cnadmart.com/20180621/23f96fc742a34ef2ae7c9e3f4510a018.jpg', null, '1', '2018-06-21 15:12:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('327', '178', 'http://img.cnadmart.com/20180621/2900c82dc10c48a1bc75b4e6309e9f90.jpg', null, '1', '2018-06-21 15:12:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('328', '178', 'http://img.cnadmart.com/20180621/e2674e10387b448e9adeed3a394630cf.jpg', null, '1', '2018-06-21 15:12:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('329', '178', 'http://img.cnadmart.com/20180621/2f68dfe9ff5549d2b5da4778a89d8461.png', null, '1', '2018-06-21 15:12:00', 'admin');
INSERT INTO `cn_good_image` VALUES ('330', '179', 'http://img.cnadmart.com/20180621/b06390ceb4bf429cbf1d5164e49e19ca.png', null, '1', '2018-06-21 16:07:17', 'admin');
INSERT INTO `cn_good_image` VALUES ('334', '180', 'http://img.cnadmart.com/20180621/7568a42260cb4e11a5f15fb828690b01.png', null, '1', '2018-06-21 16:39:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('335', '180', 'http://img.cnadmart.com/20180621/abd4c4ee747d4834b367c9ce789c894a.png', null, '1', '2018-06-21 16:39:36', 'admin');
INSERT INTO `cn_good_image` VALUES ('336', '181', 'http://img.cnadmart.com/20180621/b55d2df52bce4422b82f33389b53e654.jpg', null, '1', '2018-06-21 16:42:08', 'admin');
INSERT INTO `cn_good_image` VALUES ('337', '181', 'http://img.cnadmart.com/20180621/ac30f1f004db43829fe81debfe6ebf87.jpg', null, '1', '2018-06-21 16:42:08', 'admin');
INSERT INTO `cn_good_image` VALUES ('338', '181', 'http://img.cnadmart.com/20180621/28fb6bb652ee4ae48d01f6d6ed0dc1cf.jpg', null, '1', '2018-06-21 16:42:08', 'admin');
INSERT INTO `cn_good_image` VALUES ('339', '182', 'http://img.cnadmart.com/20180622/bb00f3f750624407b06e42dc8bc4781b.png', null, '1', '2018-06-22 09:07:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('340', '182', 'http://img.cnadmart.com/20180622/e7fa05c6347a49148a2e18a69e8edcf7.jpg', null, '1', '2018-06-22 09:07:47', 'admin');
INSERT INTO `cn_good_image` VALUES ('341', '183', 'http://img.cnadmart.com/20180622/dba980d1ab664f3c9ca1d0fa0e95c43e.jpg', null, '1', '2018-06-22 09:57:18', 'admin');
INSERT INTO `cn_good_image` VALUES ('342', '184', 'http://img.cnadmart.com/20180622/716a4822a1194b60be779935637c47c4.jpg', null, '1', '2018-06-22 10:26:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('343', '184', 'http://img.cnadmart.com/20180622/0f333a064d6645cd97b7fecb82235743.jpg', null, '1', '2018-06-22 10:26:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('344', '184', 'http://img.cnadmart.com/20180622/84cb0de06bc341afbff3a756a6c1dac8.jpg', null, '1', '2018-06-22 10:26:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('345', '184', 'http://img.cnadmart.com/20180622/cdf234b955724090b90ea4247e218136.jpg', null, '1', '2018-06-22 10:26:16', 'admin');
INSERT INTO `cn_good_image` VALUES ('346', '184', 'http://img.cnadmart.com/20180622/79c938f282a34f9e98b58d19a570d840.jpg', null, '1', '2018-06-22 10:26:16', 'admin');

-- ----------------------------
-- Table structure for cn_good_parameter
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_parameter`;
CREATE TABLE `cn_good_parameter` (
  `good_parameter_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `good_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `name` varchar(64) DEFAULT NULL COMMENT '参数名',
  `value` varchar(64) DEFAULT NULL COMMENT '参数值',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态：1.显示；0.隐藏',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`good_parameter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品参数表';

-- ----------------------------
-- Records of cn_good_parameter
-- ----------------------------
INSERT INTO `cn_good_parameter` VALUES ('1', '238', 'asfd', '1', null, null, '2018-07-10 15:26:29', 'admin', null, null);
INSERT INTO `cn_good_parameter` VALUES ('2', '238', 'asdf', 'sdf', null, null, '2018-07-10 15:26:29', 'admin', null, null);
INSERT INTO `cn_good_parameter` VALUES ('3', '116', '这些', '阿萨德', null, null, '2018-07-25 15:55:18', 'admin', null, null);
INSERT INTO `cn_good_parameter` VALUES ('4', '116', '撒', 'as', null, null, '2018-07-25 15:55:18', 'admin', null, null);

-- ----------------------------
-- Table structure for cn_good_spec_price
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_spec_price`;
CREATE TABLE `cn_good_spec_price` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品规格价格表id 主键',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `spec_name` varchar(500) DEFAULT '',
  `spec` varchar(100) DEFAULT '' COMMENT '规格 以，相隔  内容为规格值表的id',
  `price` decimal(11,2) DEFAULT '0.00' COMMENT '价格',
  `stock` int(11) DEFAULT '0' COMMENT '库存',
  `default_status` varchar(50) DEFAULT '' COMMENT '是否默认',
  `sales_volume` varchar(50) DEFAULT '0' COMMENT '销售量',
  `status` varchar(50) DEFAULT '' COMMENT '状态 0无库存 1 上架 2 下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='规格价格表';

-- ----------------------------
-- Records of cn_good_spec_price
-- ----------------------------
INSERT INTO `cn_good_spec_price` VALUES ('1', '256', '大小,怎么', '1,2', '2.00', '1', '', '03', '');

-- ----------------------------
-- Table structure for cn_good_spec_value
-- ----------------------------
DROP TABLE IF EXISTS `cn_good_spec_value`;
CREATE TABLE `cn_good_spec_value` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品规格值表主键id',
  `good_id` int(11) NOT NULL COMMENT '商品id',
  `category_spec_id` int(11) NOT NULL COMMENT '分类规格id',
  `spec_value` varchar(50) NOT NULL COMMENT '商品规格值',
  `status` tinyint(1) DEFAULT '1' COMMENT '使用状态（0使用 1未使用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品规格值表';

-- ----------------------------
-- Records of cn_good_spec_value
-- ----------------------------
INSERT INTO `cn_good_spec_value` VALUES ('1', '256', '36', '大小', '1');
INSERT INTO `cn_good_spec_value` VALUES ('2', '256', '37', '怎么', '1');

-- ----------------------------
-- Table structure for cn_news
-- ----------------------------
DROP TABLE IF EXISTS `cn_news`;
CREATE TABLE `cn_news` (
  `id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `summary` varchar(255) DEFAULT '' COMMENT '摘要',
  `content` varchar(255) DEFAULT '' COMMENT '内容',
  `pub_time` datetime DEFAULT NULL COMMENT '发布时间',
  `create_by` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_news
-- ----------------------------

-- ----------------------------
-- Table structure for cn_order
-- ----------------------------
DROP TABLE IF EXISTS `cn_order`;
CREATE TABLE `cn_order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(50) NOT NULL COMMENT '订单编号',
  `parent_order_no` varchar(255) NOT NULL DEFAULT '0' COMMENT '父订单编号',
  `total_money` decimal(16,2) NOT NULL DEFAULT '0.00' COMMENT '订单总额',
  `order_status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单',
  `user_id` int(11) NOT NULL DEFAULT '1' COMMENT '用户id',
  `created_time` datetime NOT NULL COMMENT '订单提交时间',
  `pay_time` datetime DEFAULT NULL COMMENT '订单支付时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `receiving_time` datetime DEFAULT NULL COMMENT '收货时间',
  `refund_period` datetime DEFAULT NULL COMMENT '申请退款时间',
  `refund_complete_period` datetime DEFAULT NULL COMMENT '退款完成时间',
  `detailed_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `area` varchar(20) DEFAULT NULL COMMENT '区',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `consignee` varchar(10) NOT NULL COMMENT '收货人',
  `postcode` varchar(20) DEFAULT '0' COMMENT '邮编',
  `tel` varchar(20) NOT NULL COMMENT '收货人手机号',
  `express_number` varchar(100) DEFAULT '0' COMMENT '快递单号',
  `express_company_no` varchar(20) DEFAULT '' COMMENT '快递公司编号',
  `express_company_name` varchar(255) DEFAULT NULL COMMENT '快递公司名称',
  `express_type` tinyint(10) DEFAULT NULL COMMENT '快递类型 0：自主发货 1：快递发货',
  `delivery_person_tel` varchar(255) DEFAULT NULL COMMENT '配送人电话号码',
  `note` varchar(1000) DEFAULT NULL COMMENT '备注',
  `freight` decimal(10,0) DEFAULT NULL COMMENT '运费',
  `vir_del` int(10) DEFAULT '0' COMMENT '虚拟删除 0：未删除 1：删除',
  `consignor_id` int(11) DEFAULT NULL COMMENT '发货代理商id',
  `payment_method` tinyint(1) DEFAULT '0' COMMENT '付款方式 0：微信支付 1：支付宝支付',
  `real_collection` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '实收款',
  `modify_reason` varchar(200) DEFAULT '' COMMENT '修改价格原因',
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`) USING BTREE,
  KEY `parent_order_no` (`parent_order_no`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8 COMMENT='订单主表';

-- ----------------------------
-- Records of cn_order
-- ----------------------------
INSERT INTO `cn_order` VALUES ('132', '20180627103520f6ahi', '0', '702.00', '1', '9', '2018-06-27 10:35:21', null, null, '2018-07-19 14:26:22', null, null, '上海市人民政府办公厅组织', '卢湾区', '上海市', '上海市', '李五', '147852', '17698522148', '0', '', null, null, null, null, '0', '1', null, null, '702.00', null);
INSERT INTO `cn_order` VALUES ('133', '20180627020101tzmlz', '0', '75.00', '4', '10', '2018-06-27 14:01:02', null, '2018-07-06 16:29:16', null, null, null, '明发商业广场13楼', '包河区', '合肥市', '安徽省', '广品汇', '000000', '18888888888', '84546', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '75.00', null);
INSERT INTO `cn_order` VALUES ('134', '20180627020213mgp3o', '0', '328.00', '1', '22', '2018-06-27 14:02:13', null, null, null, null, null, '龙与虎', '延庆县', '县', '北京市', '嘛事', '653458', '15635856874', '0', '', null, null, null, null, '0', '1', null, null, '328.00', null);
INSERT INTO `cn_order` VALUES ('135', '20180627022041ubw3k', '0', '1745.00', '2', '22', '2018-06-27 14:20:42', '2018-06-27 14:20:52', null, null, null, null, '今生今世看手机', '卢湾区', '上海市', '上海市', '卡夹', '805234', '18856582519', '0', '', null, null, null, null, '0', '1', null, null, '1745.00', null);
INSERT INTO `cn_order` VALUES ('136', '20180628090035eznfs', '0', '1300.00', '4', '9', '2018-06-28 09:00:35', '2018-07-02 15:11:24', '2018-07-02 15:17:33', null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, '0', '17682153207', '测试', '0', '0', '1', null, '1300.00', null);
INSERT INTO `cn_order` VALUES ('137', '20180628100445qvfaf', '0', '584.00', '1', '9', '2018-06-28 10:04:58', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '20', '0', null, null, '584.00', null);
INSERT INTO `cn_order` VALUES ('138', '20180628043653r0oca', '0', '2541.00', '3', '10', '2018-06-28 16:36:53', '2018-06-29 15:57:37', '2018-07-19 17:37:52', null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '3101612437986', 'YD', '韵达快递', '1', null, null, '0', '0', '1', null, '2541.00', null);
INSERT INTO `cn_order` VALUES ('139', '20180628044439nj8d1', '0', '2112.00', '0', '13', '2018-06-28 16:44:40', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '2112.00', null);
INSERT INTO `cn_order` VALUES ('140', '20180629025711udagv', '0', '134.00', '2', '22', '2018-06-29 14:57:12', '2018-06-29 16:24:06', null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '134.00', null);
INSERT INTO `cn_order` VALUES ('141', '201806290257541e2f7', '0', '114.00', '3', '22', '2018-06-29 14:57:55', '2018-06-29 16:30:30', '2018-06-29 16:32:30', null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, '0', '123456', null, '0', '0', '1', null, '114.00', null);
INSERT INTO `cn_order` VALUES ('142', '20180629025902qzzcw', '0', '75.00', '2', '22', '2018-06-29 14:59:02', '2018-06-29 16:29:35', null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '75.00', null);
INSERT INTO `cn_order` VALUES ('143', '20180629025920puvly', '0', '75.00', '0', '22', '2018-06-29 14:59:20', null, null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '75.00', null);
INSERT INTO `cn_order` VALUES ('144', '20180629030145ka340', '0', '130.00', '4', '22', '2018-06-29 15:01:46', '2018-06-29 15:02:59', '2018-06-29 15:03:47', null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, '0', '123456', null, '0', '0', '1', null, '130.00', null);
INSERT INTO `cn_order` VALUES ('145', '20180629041308lmyr8', '0', '234.00', '3', '10', '2018-06-29 16:13:09', '2018-06-29 16:24:19', '2018-07-19 17:38:30', null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '7701180832430', 'STO', '申通快递', '1', null, null, '0', '0', '1', null, '234.00', null);
INSERT INTO `cn_order` VALUES ('146', '20180629041736i12e0', '0', '405.00', '0', '22', '2018-06-29 16:17:37', null, null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '405.00', null);
INSERT INTO `cn_order` VALUES ('147', '20180629042435crv43', '0', '468.00', '2', '10', '2018-06-29 16:24:35', '2018-07-02 17:03:11', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '468.00', null);
INSERT INTO `cn_order` VALUES ('148', '20180629042557xb43b', '0', '75.00', '0', '22', '2018-06-29 16:25:58', null, null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '75.00', null);
INSERT INTO `cn_order` VALUES ('149', '20180629090829ciyzz', '0', '912.00', '2', '10', '2018-06-29 21:08:29', '2018-07-02 17:07:24', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '912.00', null);
INSERT INTO `cn_order` VALUES ('150', '20180630111829h7j0o', '0', '234.00', '2', '22', '2018-06-30 11:18:30', '2018-06-30 11:18:36', null, null, null, null, '静默', '大观区', '安庆市', '安徽省', '一周\nSOHO', '6582588', '18564804168', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('151', '20180630034929c13zj', '0', '234.00', '2', '10', '2018-06-30 15:49:29', '2018-07-02 17:30:33', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('152', '20180630040351hn6lh', '0', '468.00', '2', '10', '2018-06-30 16:03:52', '2018-07-02 17:33:55', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '468.00', null);
INSERT INTO `cn_order` VALUES ('153', '20180630040439ftqwn', '0', '468.00', '2', '10', '2018-06-30 16:04:39', '2018-07-02 17:35:39', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '468.00', null);
INSERT INTO `cn_order` VALUES ('154', '201806300406019wa73', '0', '234.00', '2', '10', '2018-06-30 16:06:01', '2018-07-02 17:46:04', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('155', '20180630044300f879q', '0', '468.00', '2', '10', '2018-06-30 16:43:00', '2018-07-02 17:46:26', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '468.00', null);
INSERT INTO `cn_order` VALUES ('156', '201806300447260w8tu', '0', '234.00', '2', '10', '2018-06-30 16:47:26', '2018-07-02 17:46:47', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('157', '20180630045005xr62t', '0', '1714.00', '2', '10', '2018-06-30 16:50:06', '2018-07-06 11:49:13', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '1714.00', null);
INSERT INTO `cn_order` VALUES ('158', '20180701105232wbf9s', '0', '176.00', '1', '9', '2018-07-01 22:52:32', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '176.00', null);
INSERT INTO `cn_order` VALUES ('159', '20180702094152wnwzc', '0', '257.00', '4', '19', '2018-07-02 09:41:53', '2018-07-02 09:42:01', '2018-07-03 09:21:04', null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '6364554545343', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '257.00', null);
INSERT INTO `cn_order` VALUES ('160', '20180702094340s3wji', '0', '234.00', '1', '19', '2018-07-02 09:43:40', null, null, null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, null, null, null, '0', '1', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('161', '201807020149012lr8g', '0', '96.00', '4', '19', '2018-07-02 13:49:02', '2018-07-02 13:49:54', '2018-07-05 13:57:10', null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '898999', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '96.00', null);
INSERT INTO `cn_order` VALUES ('162', '20180703085829xvf45', '0', '234.00', '4', '19', '2018-07-03 08:58:30', '2018-07-03 08:58:36', '2018-07-05 14:00:44', null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '898999', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '234.00', null);
INSERT INTO `cn_order` VALUES ('163', '20180703090753f7r70', '0', '234.00', '4', '19', '2018-07-03 09:07:53', '2018-07-03 09:08:05', '2018-07-06 10:05:38', null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, '0', '13256487598', null, '0', '0', '1', null, '234.00', null);
INSERT INTO `cn_order` VALUES ('164', '20180703090831mfk3w', '0', '234.00', '1', '19', '2018-07-03 09:08:32', null, null, null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, null, null, null, '0', '1', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('165', '20180703090836wfodz', '0', '234.00', '1', '19', '2018-07-03 09:08:36', null, null, null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('166', '20180703090931a5up2', '0', '234.00', '1', '19', '2018-07-03 09:09:32', null, null, null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('167', '20180703091020vpnlo', '0', '234.00', '1', '19', '2018-07-03 09:10:20', null, null, null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('168', '201807030912492rhao', '0', '234.00', '1', '9', '2018-07-03 09:12:49', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('169', '20180703102345j5wxq', '0', '234.00', '1', '9', '2018-07-03 10:23:45', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('170', '20180703102520tauhm', '0', '234.00', '1', '9', '2018-07-03 10:25:20', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('171', '201807031026087ivdp', '0', '234.00', '1', '9', '2018-07-03 10:26:09', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('172', '20180703102609u29jz', '0', '234.00', '1', '9', '2018-07-03 10:26:09', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('173', '201807031026453eg48', '0', '234.00', '1', '9', '2018-07-03 10:26:46', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('174', '20180703102744lyi1k', '0', '234.00', '1', '9', '2018-07-03 10:27:45', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('175', '20180703024716ew7zr', '0', '170.00', '1', '9', '2018-07-03 14:47:26', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '170.00', null);
INSERT INTO `cn_order` VALUES ('176', '201807030541534wub8', '0', '257.00', '2', '11', '2018-07-03 17:41:53', '2018-07-03 17:42:08', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '257.00', null);
INSERT INTO `cn_order` VALUES ('177', '201807040854557dcca', '0', '257.00', '2', '11', '2018-07-04 08:54:55', '2018-07-04 08:55:07', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '257.00', null);
INSERT INTO `cn_order` VALUES ('178', '201807041025297dtbk', '0', '257.00', '2', '11', '2018-07-04 10:25:29', '2018-07-04 10:25:49', null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '257.00', null);
INSERT INTO `cn_order` VALUES ('179', '20180704110653va5qi', '0', '257.00', '2', '11', '2018-07-04 11:06:53', '2018-07-04 11:07:10', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '257.00', null);
INSERT INTO `cn_order` VALUES ('180', '20180704022044c3oht', '0', '554.00', '2', '11', '2018-07-04 14:20:44', '2018-07-04 14:21:02', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '554.00', null);
INSERT INTO `cn_order` VALUES ('181', '20180705092515msv59', '0', '234.00', '1', '9', '2018-07-05 09:25:19', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('182', '2018070509441966psl', '0', '679.00', '1', '9', '2018-07-05 09:44:37', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '679.00', null);
INSERT INTO `cn_order` VALUES ('183', '20180705094947offf5', '0', '177.00', '1', '9', '2018-07-05 09:49:50', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '177.00', null);
INSERT INTO `cn_order` VALUES ('184', '201807050954549whpu', '0', '177.00', '1', '9', '2018-07-05 09:55:20', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '177.00', null);
INSERT INTO `cn_order` VALUES ('185', '20180705095619j52n8', '201807050954549whpu', '12.00', '1', '9', '2018-07-05 09:56:23', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '12.00', null);
INSERT INTO `cn_order` VALUES ('186', '201807050956364kty7', '201807050954549whpu', '165.00', '1', '9', '2018-07-05 09:56:37', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '订单提交测试', '24', '0', null, null, '165.00', null);
INSERT INTO `cn_order` VALUES ('187', '20180705032439slgzx', '0', '885.00', '4', '10', '2018-07-05 15:24:50', '2018-07-05 16:26:14', '2018-07-05 16:29:08', null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '455454', 'YTO', '圆通速递', '1', null, '32144', '0', '0', '1', null, '885.00', null);
INSERT INTO `cn_order` VALUES ('188', '20180705033542vixhu', '0', '169.00', '2', '11', '2018-07-05 15:35:43', '2018-07-05 15:35:56', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('189', '201807050351097m5t5', '0', '169.00', '2', '11', '2018-07-05 15:51:09', '2018-07-05 15:51:24', null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('190', '20180705045418akwxc', '0', '130.00', '4', '19', '2018-07-05 16:54:19', '2018-07-05 16:55:14', '2018-07-05 16:56:56', null, null, null, '那看看', '黄浦区', '上海市', '上海市', '马思宇', '135896', '18734804160', '01321', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '130.00', null);
INSERT INTO `cn_order` VALUES ('191', '20180705045831kn8eq', '0', '130.00', '1', '9', '2018-07-05 16:58:31', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('192', '20180705050503tkpnr', '0', '130.00', '1', '9', '2018-07-05 17:05:03', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('193', '20180705052045z2ax9', '0', '399.00', '1', '9', '2018-07-05 17:20:46', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '399.00', null);
INSERT INTO `cn_order` VALUES ('194', '20180705052045139bn', '20180705052045z2ax9', '234.00', '1', '9', '2018-07-05 17:20:46', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('195', '20180705052045ngjsg', '20180705052045z2ax9', '165.00', '1', '9', '2018-07-05 17:20:46', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '165.00', null);
INSERT INTO `cn_order` VALUES ('196', '20180705052835ojhqq', '0', '902.00', '1', '9', '2018-07-05 17:28:36', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '902.00', null);
INSERT INTO `cn_order` VALUES ('197', '201807050528354adgw', '20180705052835ojhqq', '737.00', '1', '9', '2018-07-05 17:28:36', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('198', '20180705052835pkuyt', '20180705052835ojhqq', '165.00', '1', '9', '2018-07-05 17:28:36', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, '34253425', '0', '0', null, null, '165.00', null);
INSERT INTO `cn_order` VALUES ('199', '201807050556431zpzp', '0', '3443.00', '0', '11', '2018-07-05 17:56:43', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '3443.00', null);
INSERT INTO `cn_order` VALUES ('200', '20180705072327dhqzk', '20180705072251rja6b', '130.00', '0', '10', '2018-07-05 19:23:29', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '20170705', '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('201', '20180705072338kgrp2', '20180705072251rja6b', '165.00', '0', '10', '2018-07-05 19:23:39', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, '20170705', '0', '0', null, null, '165.00', null);
INSERT INTO `cn_order` VALUES ('202', '20180706104944jke7z', '20180706104944ywpd5', '144.00', '0', '19', '2018-07-06 10:49:44', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '144.00', null);
INSERT INTO `cn_order` VALUES ('203', '20180706104944nzd0p', '20180706104944ywpd5', '826.00', '0', '19', '2018-07-06 10:49:44', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '826.00', null);
INSERT INTO `cn_order` VALUES ('204', '2018070610532007p34', '0', '130.00', '4', '19', '2018-07-06 10:53:21', '2018-07-06 10:53:28', '2018-07-06 13:41:43', null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '01', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '130.00', null);
INSERT INTO `cn_order` VALUES ('205', '20180706105819opjb6', '0', '538.00', '4', '9', '2018-07-06 10:58:20', '2018-07-06 10:59:00', '2018-07-07 09:05:45', null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, '0', '17682153207', null, '0', '0', '1', null, '538.00', null);
INSERT INTO `cn_order` VALUES ('206', '20180706110058clg07', '201807061100586002r', '169.00', '0', '19', '2018-07-06 11:00:59', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('207', '20180706110058ol902', '201807061100586002r', '826.00', '0', '19', '2018-07-06 11:00:59', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '826.00', null);
INSERT INTO `cn_order` VALUES ('208', '201807061105290gdym', '0', '130.00', '0', '19', '2018-07-06 11:05:30', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('209', '20180706110534khr9j', '0', '130.00', '0', '19', '2018-07-06 11:05:35', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('210', '201807060437187cr46', '0', '574.00', '2', '11', '2018-07-06 16:37:18', '2018-07-06 16:37:35', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '574.00', null);
INSERT INTO `cn_order` VALUES ('211', '20180706044030av9pt', '0', '974.00', '2', '11', '2018-07-06 16:40:31', '2018-07-06 16:40:54', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '974.00', null);
INSERT INTO `cn_order` VALUES ('212', '20180706044959aw8zs', '20180706044959yimv0', '234.00', '0', '11', '2018-07-06 16:49:59', null, null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('213', '20180706044959ou95g', '20180706044959yimv0', '740.00', '0', '11', '2018-07-06 16:49:59', null, null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '740.00', null);
INSERT INTO `cn_order` VALUES ('214', '201807060517265ux9e', '2018070605172622qog', '257.00', '0', '11', '2018-07-06 17:17:27', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '257.00', null);
INSERT INTO `cn_order` VALUES ('215', '20180706051727xqoyf', '2018070605172622qog', '651.00', '0', '11', '2018-07-06 17:17:27', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('216', '201807060530275xa80', '20180706053026i0ybp', '234.00', '2', '11', '2018-07-06 17:30:27', '2018-07-06 17:30:39', null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('217', '20180706053027o25iy', '20180706053026i0ybp', '651.00', '2', '11', '2018-07-06 17:30:27', '2018-07-06 17:30:39', null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('218', '20180707103846n6982', '0', '292.00', '0', '13', '2018-07-07 10:38:46', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '292.00', null);
INSERT INTO `cn_order` VALUES ('219', '20180707104005sl554', '0', '169.00', '0', '13', '2018-07-07 10:40:06', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('220', '20180707104016u48i5', '0', '169.00', '0', '13', '2018-07-07 10:40:17', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('221', '201807071040239tvgd', '0', '246.00', '0', '13', '2018-07-07 10:40:24', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '246.00', null);
INSERT INTO `cn_order` VALUES ('222', '20180707104045vgci0', '0', '234.00', '0', '8', '2018-07-07 10:40:45', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '2300001', '13000001111', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('223', '201807071040584r1x2', '0', '210.00', '0', '13', '2018-07-07 10:40:59', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '210.00', null);
INSERT INTO `cn_order` VALUES ('224', '20180707104135wfx1d', '0', '651.00', '0', '13', '2018-07-07 10:41:35', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('225', '201807071042024b50t', '0', '829.00', '0', '13', '2018-07-07 10:42:02', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '829.00', null);
INSERT INTO `cn_order` VALUES ('226', '20180707104301j0et2', '0', '651.00', '0', '8', '2018-07-07 10:43:02', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '2300001', '13000001111', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('227', '20180707104326m890w', '0', '169.00', '0', '13', '2018-07-07 10:43:27', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('228', '20180707104350a7ylq', '0', '651.00', '0', '8', '2018-07-07 10:43:51', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '2300001', '13000001111', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('229', '20180707104708mvcme', '0', '740.00', '0', '13', '2018-07-07 10:47:09', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '740.00', null);
INSERT INTO `cn_order` VALUES ('230', '20180707105134ph54o', '0', '16.00', '3', '19', '2018-07-07 10:51:35', '2018-07-07 10:51:45', '2018-07-19 15:30:37', null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '123000', '130000000', '12233336', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', null, '16.00', null);
INSERT INTO `cn_order` VALUES ('231', '20180707105202c0jq2', '0', '320.00', '0', '8', '2018-07-07 10:52:03', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '2300001', '13000001111', '0', '', null, null, null, null, '0', '0', null, null, '320.00', null);
INSERT INTO `cn_order` VALUES ('232', '20180707110032p2gjt', '0', '234.00', '0', '12', '2018-07-07 11:00:32', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('233', '20180707111142uhi99', '0', '130.00', '0', '10', '2018-07-07 11:11:43', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('234', '201807071112110qxc7', '0', '702.00', '0', '12', '2018-07-07 11:12:12', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '702.00', null);
INSERT INTO `cn_order` VALUES ('235', '20180707111639tmgyu', '0', '16.00', '0', '10', '2018-07-07 11:16:40', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '16.00', null);
INSERT INTO `cn_order` VALUES ('236', '20180707112129riou8', '0', '130.00', '0', '10', '2018-07-07 11:21:30', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('237', '20180707113750q4bae', '0', '737.00', '0', '10', '2018-07-07 11:37:51', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('238', '20180707114353y1sgi', '0', '737.00', '0', '10', '2018-07-07 11:43:53', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('239', '20180707114850d0m22', '0', '737.00', '0', '10', '2018-07-07 11:48:50', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('240', '20180707115524hsnnb', '0', '130.00', '0', '10', '2018-07-07 11:55:25', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('241', '201807071159279976g', '0', '169.00', '0', '13', '2018-07-07 11:59:27', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('242', '20180707115952kf030', '0', '169.00', '0', '13', '2018-07-07 11:59:53', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('243', '201807071200178pt5q', '0', '169.00', '0', '13', '2018-07-07 12:00:17', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('244', '20180707120018l2yon', '0', '737.00', '0', '10', '2018-07-07 12:00:18', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('245', '20180707120210vgum8', '0', '169.00', '0', '13', '2018-07-07 12:02:10', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('246', '20180707120838qc1mz', '0', '292.00', '0', '13', '2018-07-07 12:08:38', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '292.00', null);
INSERT INTO `cn_order` VALUES ('247', '20180707121203805hl', '0', '130.00', '0', '10', '2018-07-07 12:12:04', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('248', '201807071219131qeog', '0', '737.00', '0', '10', '2018-07-07 12:19:13', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('249', '20180707121937h7rrw', '0', '737.00', '0', '10', '2018-07-07 12:19:37', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('250', '201807070143442f96p', '0', '130.00', '0', '10', '2018-07-07 13:43:44', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('251', '20180707015157bl7ou', '0', '737.00', '0', '13', '2018-07-07 13:51:57', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '737.00', null);
INSERT INTO `cn_order` VALUES ('252', '2018070701534644683', '0', '169.00', '0', '13', '2018-07-07 13:53:47', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('253', '2018070701535879na4', '0', '178.00', '0', '10', '2018-07-07 13:53:59', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '178.00', null);
INSERT INTO `cn_order` VALUES ('254', '201807070154124ag0s', '0', '234.00', '0', '12', '2018-07-07 13:54:12', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('255', '2018070701543022xrt', '0', '154.00', '0', '13', '2018-07-07 13:54:31', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '154.00', null);
INSERT INTO `cn_order` VALUES ('256', '201807070154394lnjc', '0', '154.00', '0', '13', '2018-07-07 13:54:40', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '154.00', null);
INSERT INTO `cn_order` VALUES ('257', '20180707015645birfc', '0', '234.00', '2', '12', '2018-07-07 13:56:46', '2018-07-07 13:56:55', null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('258', '20180707020120b0mgv', '0', '169.00', '0', '13', '2018-07-07 14:01:21', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('259', '201807070202284xlme', '0', '130.00', '1', '13', '2018-07-07 14:02:28', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('260', '20180707020229i57rj', '0', '234.00', '0', '10', '2018-07-07 14:02:29', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('261', '2018070702025085io5', '0', '234.00', '0', '10', '2018-07-07 14:02:50', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('262', '20180707020456v4gtm', '0', '187.00', '1', '13', '2018-07-07 14:04:56', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '187.00', null);
INSERT INTO `cn_order` VALUES ('263', '201807070205145v516', '0', '22.00', '1', '13', '2018-07-07 14:05:14', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '22.00', null);
INSERT INTO `cn_order` VALUES ('264', '2018070702060259wto', '0', '169.00', '1', '13', '2018-07-07 14:06:02', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('265', '201807070206239gzgx', '0', '169.00', '1', '13', '2018-07-07 14:06:23', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('266', '201807090850277imkp', '0', '480.00', '0', '10', '2018-07-09 08:50:28', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '000000', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '480.00', null);
INSERT INTO `cn_order` VALUES ('267', '20180709085239fogxp', '0', '160.00', '0', '11', '2018-07-09 08:52:40', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '222222', '17755152862', '0', '', null, null, null, null, '0', '0', null, null, '160.00', null);
INSERT INTO `cn_order` VALUES ('268', '201807091044192iyq3', '0', '2960.00', '0', '12', '2018-07-09 10:44:19', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '2960.00', null);
INSERT INTO `cn_order` VALUES ('269', '20180709104640rarru', '0', '1280.00', '0', '12', '2018-07-09 10:46:40', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '1280.00', null);
INSERT INTO `cn_order` VALUES ('270', '20180709104723sp9y9', '0', '169.00', '1', '13', '2018-07-09 10:47:23', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('271', '2018070911412030b4j', '0', '4706.00', '1', '9', '2018-07-09 11:41:20', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '340000', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '4706.00', null);
INSERT INTO `cn_order` VALUES ('272', '20180709115412idqfs', '0', '1480.00', '0', '12', '2018-07-09 11:54:12', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '1480.00', null);
INSERT INTO `cn_order` VALUES ('273', '20180710101550qo54a', '0', '169.00', '1', '13', '2018-07-10 10:15:51', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('274', '20180710101603v8irl', '0', '169.00', '1', '13', '2018-07-10 10:16:03', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '12358', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('275', '20180710024019g5uiv', '0', '651.00', '0', '12', '2018-07-10 14:40:19', null, null, null, null, null, '紫桐新村', '大观区', '安庆市', '安徽省', '原子弹', '331600', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '651.00', null);
INSERT INTO `cn_order` VALUES ('276', '201807111037238edjc', '0', '160.00', '0', '19', '2018-07-11 10:37:23', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '160.00', null);
INSERT INTO `cn_order` VALUES ('277', '20180711103750hqw75', '0', '160.00', '0', '19', '2018-07-11 10:37:50', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '160.00', null);
INSERT INTO `cn_order` VALUES ('278', '20180711103808swxhi', '0', '160.00', '0', '19', '2018-07-11 10:38:09', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '160.00', null);
INSERT INTO `cn_order` VALUES ('279', '20180711104159dahu3', '0', '85.00', '0', '19', '2018-07-11 10:42:00', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '85.00', null);
INSERT INTO `cn_order` VALUES ('280', '201807110148205ulww', '0', '304.00', '0', '19', '2018-07-11 13:48:20', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '304.00', null);
INSERT INTO `cn_order` VALUES ('281', '20180711015301unuj6', '0', '297.00', '0', '19', '2018-07-11 13:53:01', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '297.00', null);
INSERT INTO `cn_order` VALUES ('282', '201807110153385nouz', '0', '297.00', '0', '19', '2018-07-11 13:53:39', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, null, '297.00', null);
INSERT INTO `cn_order` VALUES ('283', '20180711021613plqnb', '0', '16.00', '0', '12', '2018-07-11 14:16:14', null, null, null, null, null, '请选择请选择', '庐阳区', '合肥市', '安徽省', '嘻嘻', '0', 'qsqsqqs', '0', '', null, null, null, null, '0', '0', null, null, '16.00', null);
INSERT INTO `cn_order` VALUES ('284', '20180711023143z3mvg', '0', '130.00', '0', '10', '2018-07-11 14:31:44', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('285', '20180711023210cbmem', '0', '152.00', '4', '10', '2018-07-11 14:32:10', '2018-07-11 14:32:19', '2018-07-19 16:26:49', '2018-07-27 17:11:23', null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '15605655945', 'STO', '申通快递', '1', null, null, '0', '0', '1', null, '152.00', null);
INSERT INTO `cn_order` VALUES ('286', '20180711023323t9gd5', '0', '152.00', '2', '9', '2018-07-11 14:33:23', '2018-07-11 14:33:32', null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '152.00', null);
INSERT INTO `cn_order` VALUES ('287', '20180711041305wr0jl', '0', '234.00', '2', '17', '2018-07-11 16:13:05', '2018-07-11 16:14:11', null, null, null, null, '明发广场一号楼', '庐阳区', '合肥市', '安徽省', '刘昌霖', '8888888', '13093381314', '0', '', null, null, null, null, '0', '0', null, null, '234.00', null);
INSERT INTO `cn_order` VALUES ('288', '20180711043811qrd5i', '0', '169.00', '0', '10', '2018-07-11 16:38:11', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('289', '20180711043833w7vpx', '0', '169.00', '0', '10', '2018-07-11 16:38:34', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '169.00', null);
INSERT INTO `cn_order` VALUES ('290', '2018071104385197ghp', '0', '210.00', '0', '10', '2018-07-11 16:38:52', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, null, '210.00', null);
INSERT INTO `cn_order` VALUES ('291', '20180711043910lnzob', '0', '44.00', '2', '10', '2018-07-11 16:39:10', '2018-07-21 10:46:21', null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '44.00', null);
INSERT INTO `cn_order` VALUES ('292', '20180711045442w9z5y', '0', '2056.00', '0', '8', '2018-07-11 16:54:42', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '8888888', '13000001111', '0', '', null, null, null, null, '0', '0', null, null, '2056.00', null);
INSERT INTO `cn_order` VALUES ('293', '20180711052108l6jop', '0', '0.02', '0', '11', '2018-07-11 17:21:09', null, null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '0.02', null);
INSERT INTO `cn_order` VALUES ('294', '201807110521496se2p', '0', '0.02', '0', '11', '2018-07-11 17:21:50', null, null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '0.02', null);
INSERT INTO `cn_order` VALUES ('295', '20180711053608isfhx', '0', '0.02', '1', '11', '2018-07-11 17:36:09', '2018-07-11 17:36:39', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '0.02', null);
INSERT INTO `cn_order` VALUES ('296', '201807110540101xuem', '0', '6.00', '2', '11', '2018-07-11 17:40:10', '2018-07-11 17:40:24', null, null, null, null, '四里河路明发商业广场', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, null, '6.00', null);
INSERT INTO `cn_order` VALUES ('298', '20180712110321ilfy8', '0', '130.00', '0', '9', '2018-07-12 11:03:21', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, '事务测试', '0', '0', null, null, '130.00', null);
INSERT INTO `cn_order` VALUES ('299', '20180713104701at8uf', '0', '0.02', '4', '8', '2018-07-13 10:47:02', '2018-07-19 15:19:33', '2018-07-19 15:40:14', '2018-07-20 09:17:32', null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '8888888', '13000001111', '15605655945', 'YTO', '圆通速递', '1', null, null, '0', '0', '1', '0', '0.02', null);
INSERT INTO `cn_order` VALUES ('300', '20180713104817hy0iv', '0', '825.00', '1', '8', '2018-07-13 10:48:18', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '8888888', '13000001111', '0', '', null, null, null, null, '0', '1', null, null, '825.00', null);
INSERT INTO `cn_order` VALUES ('301', '2018071304593064fy7', '0', '0.11', '0', '12', '2018-07-13 16:59:30', null, null, null, null, null, '东京', '旺泉街道', '顺义区', '北京', '嘻嘻嘻', '15458464', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '0.11', null);
INSERT INTO `cn_order` VALUES ('302', '20180713055301h9okl', '201807130553012tv1w', '0.11', '0', '12', '2018-07-13 17:53:02', null, null, null, null, null, '东京', '旺泉街道', '顺义区', '北京', '嘻嘻嘻', '15458464', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '0.11', null);
INSERT INTO `cn_order` VALUES ('303', '20180713055301xg48e', '201807130553012tv1w', '740.00', '0', '12', '2018-07-13 17:53:02', null, null, null, null, null, '东京', '旺泉街道', '顺义区', '北京', '嘻嘻嘻', '15458464', '15256036352', '0', '', null, null, null, null, '0', '0', null, null, '740.00', null);
INSERT INTO `cn_order` VALUES ('304', '201807151231082dyu5', '201807151231078ptyq', '480.00', '1', '28', '2018-07-15 12:31:08', null, null, null, null, null, 'vghk', '河东区', '天津市', '天津市', 'vggq', '552886', '13866652805', '0', '', null, null, null, null, '0', '1', null, null, '480.00', null);
INSERT INTO `cn_order` VALUES ('305', '201807151231081dbid', '201807151231078ptyq', '3375.00', '1', '28', '2018-07-15 12:31:08', null, null, null, null, null, 'vghk', '河东区', '天津市', '天津市', 'vggq', '552886', '13866652805', '0', '', null, null, null, null, '0', '1', null, null, '3375.00', null);
INSERT INTO `cn_order` VALUES ('306', '20180716101900lbj17', '0', '246.00', '1', '13', '2018-07-16 10:19:01', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '8888888', '1300000000', '0', '', null, null, null, null, '0', '0', null, null, '246.00', null);
INSERT INTO `cn_order` VALUES ('307', '2018071705294527v8c', '0', '0.10', '2', '12', '2018-07-17 17:29:45', '2018-07-17 17:29:57', null, null, null, null, '东京', '旺泉街道', '顺义区', '北京', '嘻嘻嘻', '15458464', '15256036352', '0', '', null, null, null, null, '0', '0', null, '0', '0.10', null);
INSERT INTO `cn_order` VALUES ('308', '20180718033949kqi13', '0', '6124.00', '0', '8', '2018-07-18 15:39:49', null, null, null, null, null, '2222222222', '2222222', '222222222', '2222222222', '2222222222', '88888', '2222222222', '0', '', null, null, null, null, '0', '0', null, '0', '6124.00', null);
INSERT INTO `cn_order` VALUES ('309', '20180719085350lc4t3', '0', '1466.00', '0', '12', '2018-07-19 08:53:51', null, null, null, null, null, '明发广场', '庐阳区大杨镇', '合肥市', '安徽', '原子弹', '231605', '15256036352', '0', '', null, null, null, null, '0', '0', null, '0', '1466.00', null);
INSERT INTO `cn_order` VALUES ('310', '20180719025712e5o0m', '0', '234.00', '0', '17', '2018-07-19 14:57:12', null, null, null, null, null, '明发广场一号楼', '庐阳区', '合肥市', '安徽省', '刘昌霖', '8888888', '13093381314', '0', '', null, null, null, null, '0', '0', null, '0', '234.00', null);
INSERT INTO `cn_order` VALUES ('311', '20180720091630xlo1a', '0', '428.00', '0', '12', '2018-07-20 09:16:31', null, null, null, null, null, '明发广场', '庐阳区大杨镇', '合肥市', '安徽', '原子弹', '231605', '15256036352', '0', '', null, null, null, null, '0', '0', null, '0', '428.00', null);
INSERT INTO `cn_order` VALUES ('312', '20180720092837uclad', '0', '0.13', '3', '8', '2018-07-20 09:28:38', '2018-07-20 09:33:36', '2018-07-20 10:08:35', null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '222222', '13000001111', '7701180832430', 'STO', '申通快递', '1', null, null, '0', '0', '1', '0', '0.13', null);
INSERT INTO `cn_order` VALUES ('313', '20180721042139nhn3j', '0', '130.00', '0', '19', '2018-07-21 16:21:39', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, '0', '130.00', '');
INSERT INTO `cn_order` VALUES ('314', '20180721043528bkwzq', '0', '88.00', '0', '19', '2018-07-21 16:35:28', null, null, null, null, null, '哈哈', '旺泉街道', '顺义区', '北京', '哈哈', '8888888', '130000000', '0', '', null, null, null, null, '0', '0', null, '0', '88.00', '');
INSERT INTO `cn_order` VALUES ('315', '20180722091034e3x1u', '0', '1.40', '2', '31', '2018-07-22 09:10:35', '2018-07-22 09:10:53', null, null, null, null, '曹集北路(亿通广告)', '阜南县', '阜阳市', '安徽省', '刘光', '236300', '13865840008', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('316', '201807220921295hb7m', '0', '33.00', '0', '33', '2018-07-22 09:21:30', null, null, null, null, null, '京九办事处城建祥和', '颍州区城区', '阜阳市', '安徽', '王子峰', '2363000', '18269996288', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('317', '201807271031487lzl4', '0', '608.00', '0', '11', '2018-07-27 10:31:48', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '8888888', '17755152862', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('318', '20180727103207oalmu', '0', '88.00', '0', '11', '2018-07-27 10:32:08', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '8888888', '17755152862', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('319', '20180727041247mcndy', '0', '181.00', '0', '9', '2018-07-27 16:12:48', null, null, null, null, null, '四里河路明发商业广场13楼1325室', '庐阳区', '合肥市', '安徽省', '宋许超', '8888888', '17682153207', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('320', '20180727042226rm9za', '20180727042226otf4y', '281.00', '0', '10', '2018-07-27 16:22:27', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('321', '20180727042226yonm8', '20180727042226otf4y', '608.00', '0', '10', '2018-07-27 16:22:27', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('322', '20180727044552452cj', '0', '260.00', '0', '10', '2018-07-27 16:45:53', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('323', '20180728103951yfazk', '0', '88.00', '1', '11', '2018-07-28 10:39:51', null, null, null, null, null, '明发', '庐阳区', '合肥市', '安徽省', '李', '8888888', '17755152862', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('324', '20180801023018cwini', '0', '187.00', '0', '8', '2018-08-01 14:30:18', null, null, null, null, null, '西二环', '蜀山', '武汉', '湖北', '哈哥', '222222', '13000001111', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('325', '20180801030158i53aj', '0', '234.00', '0', '10', '2018-08-01 15:01:59', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('326', '20180801031542p1hgx', '0', '234.00', '0', '10', '2018-08-01 15:15:42', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('327', '20180801045101vehk0', '0', '10.00', '0', '39', '2018-08-01 16:51:01', null, null, null, null, null, '淮河路商之都1806', '庐阳区', '合肥市', '安徽省', '张龙', '230031', '13866191585', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('328', '20180801060246acx2i', '2018080106024664x6n', '234.00', '0', '10', '2018-08-01 18:02:46', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('329', '20180801060246o6t7l', '2018080106024664x6n', '3005.00', '0', '10', '2018-08-01 18:02:46', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('330', '20180801060246ymtea', '2018080106024664x6n', '304.00', '0', '10', '2018-08-01 18:02:46', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('331', '20180802091809prd9s', '0', '234.00', '0', '10', '2018-08-02 09:18:09', null, null, null, null, null, '歌手是谁世界上那你', '大观区', '安庆市', '安徽省', '哈哈哈', '8888888', '15605655945', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');
INSERT INTO `cn_order` VALUES ('332', '20180802030514j5sm6', '0', '22.00', '1', '13', '2018-08-02 15:05:15', null, null, null, null, null, '哈哈', '大观区', '安庆市', '安徽省', '哈哈', '8888888', '1300000000', '0', '', null, null, null, null, '0', '0', null, '0', '0.00', '');

-- ----------------------------
-- Table structure for cn_order_good
-- ----------------------------
DROP TABLE IF EXISTS `cn_order_good`;
CREATE TABLE `cn_order_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(50) NOT NULL COMMENT '订单id',
  `good_id` int(11) NOT NULL,
  `good_spec_price_id` int(11) NOT NULL COMMENT '商品规格价格id',
  `amount` int(10) NOT NULL COMMENT '商品购买数量',
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=395 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_order_good
-- ----------------------------
INSERT INTO `cn_order_good` VALUES ('169', '20180627103520f6ahi', '213', '757', '3');
INSERT INTO `cn_order_good` VALUES ('170', '20180627020101tzmlz', '214', '889', '1');
INSERT INTO `cn_order_good` VALUES ('171', '20180627020213mgp3o', '213', '761', '1');
INSERT INTO `cn_order_good` VALUES ('172', '20180627022041ubw3k', '213', '758', '4');
INSERT INTO `cn_order_good` VALUES ('173', '20180627022041ubw3k', '99', '233', '3');
INSERT INTO `cn_order_good` VALUES ('174', '20180628090035eznfs', '99', '226', '10');
INSERT INTO `cn_order_good` VALUES ('175', '20180628092339etiw7', '107', '270', '1');
INSERT INTO `cn_order_good` VALUES ('176', '20180628093548w89yw', '111', '289', '1');
INSERT INTO `cn_order_good` VALUES ('177', '20180628100445qvfaf', '99', '236', '2');
INSERT INTO `cn_order_good` VALUES ('178', '20180628043653r0oca', '111', '289', '5');
INSERT INTO `cn_order_good` VALUES ('179', '20180628043653r0oca', '213', '757', '9');
INSERT INTO `cn_order_good` VALUES ('180', '20180628044439nj8d1', '122', '348', '2');
INSERT INTO `cn_order_good` VALUES ('181', '20180629025711udagv', '214', '894', '1');
INSERT INTO `cn_order_good` VALUES ('182', '201806290257541e2f7', '214', '893', '1');
INSERT INTO `cn_order_good` VALUES ('183', '20180629025902qzzcw', '214', '889', '1');
INSERT INTO `cn_order_good` VALUES ('184', '20180629025920puvly', '214', '889', '1');
INSERT INTO `cn_order_good` VALUES ('185', '20180629030145ka340', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('186', '20180629041308lmyr8', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('187', '20180629041736i12e0', '213', '848', '1');
INSERT INTO `cn_order_good` VALUES ('188', '20180629042435crv43', '213', '757', '2');
INSERT INTO `cn_order_good` VALUES ('189', '20180629042557xb43b', '214', '889', '1');
INSERT INTO `cn_order_good` VALUES ('190', '20180629090829ciyzz', '213', '760', '3');
INSERT INTO `cn_order_good` VALUES ('191', '20180630111829h7j0o', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('192', '20180630034929c13zj', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('193', '20180630040351hn6lh', '213', '757', '2');
INSERT INTO `cn_order_good` VALUES ('194', '20180630040439ftqwn', '213', '757', '2');
INSERT INTO `cn_order_good` VALUES ('195', '201806300406019wa73', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('196', '20180630044300f879q', '213', '757', '2');
INSERT INTO `cn_order_good` VALUES ('197', '201806300447260w8tu', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('198', '20180630045005xr62t', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('199', '20180630045005xr62t', '211', '622', '2');
INSERT INTO `cn_order_good` VALUES ('200', '20180701105232wbf9s', '214', '890', '2');
INSERT INTO `cn_order_good` VALUES ('201', '20180702094152wnwzc', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('202', '20180702094340s3wji', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('203', '201807020149012lr8g', '236', '2201', '8');
INSERT INTO `cn_order_good` VALUES ('204', '20180703085829xvf45', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('205', '20180703090753f7r70', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('206', '20180703090831mfk3w', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('207', '20180703090836wfodz', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('208', '20180703090931a5up2', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('209', '20180703091020vpnlo', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('210', '201807030912492rhao', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('211', '20180703102345j5wxq', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('212', '20180703102520tauhm', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('213', '201807031026087ivdp', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('214', '20180703102609u29jz', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('215', '201807031026453eg48', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('216', '20180703102744lyi1k', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('217', '20180703024716ew7zr', '215', '897', '2');
INSERT INTO `cn_order_good` VALUES ('218', '201807030541534wub8', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('219', '201807040854557dcca', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('220', '201807041025297dtbk', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('221', '20180704110653va5qi', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('222', '20180704022044c3oht', '213', '807', '1');
INSERT INTO `cn_order_good` VALUES ('223', '20180705092515msv59', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('224', '2018070509441966psl', '213', '758', '2');
INSERT INTO `cn_order_good` VALUES ('225', '2018070509441966psl', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('226', '20180705094523vw2eg', '213', '758', '2');
INSERT INTO `cn_order_good` VALUES ('227', '20180705094537fetlw', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('228', '20180705094947offf5', '179', '507', '1');
INSERT INTO `cn_order_good` VALUES ('229', '20180705094947offf5', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('230', '20180705094959bzfrp', '179', '507', '1');
INSERT INTO `cn_order_good` VALUES ('231', '20180705095003iie7z', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('232', '201807050954549whpu', '179', '507', '1');
INSERT INTO `cn_order_good` VALUES ('233', '201807050954549whpu', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('234', '20180705095619j52n8', '179', '507', '1');
INSERT INTO `cn_order_good` VALUES ('235', '201807050956364kty7', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('236', '20180705032439slgzx', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('237', '20180705032439slgzx', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('238', '20180705033542vixhu', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('239', '201807050351097m5t5', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('240', '20180705045418akwxc', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('241', '20180705045831kn8eq', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('242', '20180705050503tkpnr', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('243', '20180705052045z2ax9', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('244', '20180705052045z2ax9', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('245', '20180705052045139bn', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('246', '20180705052045ngjsg', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('247', '20180705052835ojhqq', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('248', '20180705052835ojhqq', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('249', '201807050528354adgw', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('250', '20180705052835pkuyt', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('251', '201807050556431zpzp', '99', '236', '5');
INSERT INTO `cn_order_good` VALUES ('252', '201807050556431zpzp', '99', '235', '6');
INSERT INTO `cn_order_good` VALUES ('253', '201807050556431zpzp', '99', '231', '3');
INSERT INTO `cn_order_good` VALUES ('254', '20180705072327dhqzk', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('255', '20180705072338kgrp2', '225', '1137', '1');
INSERT INTO `cn_order_good` VALUES ('256', '20180706104944jke7z', '99', '230', '1');
INSERT INTO `cn_order_good` VALUES ('257', '20180706104944nzd0p', '117', '314', '2');
INSERT INTO `cn_order_good` VALUES ('258', '2018070610532007p34', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('259', '20180706105819opjb6', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('260', '20180706105819opjb6', '216', '941', '1');
INSERT INTO `cn_order_good` VALUES ('261', '20180706110058clg07', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('262', '20180706110058ol902', '117', '314', '2');
INSERT INTO `cn_order_good` VALUES ('263', '201807061105290gdym', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('264', '20180706110534khr9j', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('265', '201807060437187cr46', '213', '808', '1');
INSERT INTO `cn_order_good` VALUES ('266', '20180706044030av9pt', '211', '622', '1');
INSERT INTO `cn_order_good` VALUES ('267', '20180706044030av9pt', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('268', '20180706044959aw8zs', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('269', '20180706044959ou95g', '211', '622', '1');
INSERT INTO `cn_order_good` VALUES ('270', '201807060517265ux9e', '213', '758', '1');
INSERT INTO `cn_order_good` VALUES ('271', '20180706051727xqoyf', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('272', '201807060530275xa80', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('273', '20180706053027o25iy', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('274', '20180707103846n6982', '99', '236', '1');
INSERT INTO `cn_order_good` VALUES ('275', '20180707104005sl554', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('276', '20180707104016u48i5', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('277', '201807071040239tvgd', '99', '235', '1');
INSERT INTO `cn_order_good` VALUES ('278', '20180707104045vgci0', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('279', '201807071040584r1x2', '99', '234', '1');
INSERT INTO `cn_order_good` VALUES ('280', '20180707104135wfx1d', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('281', '201807071042024b50t', '211', '623', '1');
INSERT INTO `cn_order_good` VALUES ('282', '20180707104301j0et2', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('283', '20180707104326m890w', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('284', '20180707104350a7ylq', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('285', '20180707104708mvcme', '211', '622', '1');
INSERT INTO `cn_order_good` VALUES ('286', '20180707105134ph54o', '161', '468', '1');
INSERT INTO `cn_order_good` VALUES ('287', '20180707105202c0jq2', '161', '468', '1');
INSERT INTO `cn_order_good` VALUES ('288', '20180707105202c0jq2', '99', '227', '2');
INSERT INTO `cn_order_good` VALUES ('289', '20180707110032p2gjt', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('290', '20180707111142uhi99', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('291', '201807071112110qxc7', '213', '757', '3');
INSERT INTO `cn_order_good` VALUES ('292', '20180707111639tmgyu', '161', '468', '1');
INSERT INTO `cn_order_good` VALUES ('293', '20180707112129riou8', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('294', '20180707113750q4bae', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('295', '20180707114353y1sgi', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('296', '20180707114850d0m22', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('297', '20180707115524hsnnb', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('298', '201807071159279976g', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('299', '20180707115952kf030', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('300', '201807071200178pt5q', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('301', '20180707120018l2yon', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('302', '20180707120210vgum8', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('303', '20180707120838qc1mz', '99', '236', '1');
INSERT INTO `cn_order_good` VALUES ('304', '20180707121203805hl', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('305', '201807071219131qeog', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('306', '20180707121937h7rrw', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('307', '201807070143442f96p', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('308', '20180707015157bl7ou', '101', '246', '1');
INSERT INTO `cn_order_good` VALUES ('309', '2018070701534644683', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('310', '2018070701535879na4', '99', '238', '1');
INSERT INTO `cn_order_good` VALUES ('311', '201807070154124ag0s', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('312', '2018070701543022xrt', '161', '469', '7');
INSERT INTO `cn_order_good` VALUES ('313', '201807070154394lnjc', '161', '469', '7');
INSERT INTO `cn_order_good` VALUES ('314', '20180707015645birfc', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('315', '20180707020120b0mgv', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('316', '201807070202284xlme', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('317', '20180707020229i57rj', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('318', '2018070702025085io5', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('319', '20180707020456v4gtm', '107', '271', '1');
INSERT INTO `cn_order_good` VALUES ('320', '201807070205145v516', '161', '469', '1');
INSERT INTO `cn_order_good` VALUES ('321', '2018070702060259wto', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('322', '201807070206239gzgx', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('323', '201807090850277imkp', '107', '270', '3');
INSERT INTO `cn_order_good` VALUES ('324', '20180709085239fogxp', '215', '911', '1');
INSERT INTO `cn_order_good` VALUES ('325', '201807091044192iyq3', '211', '622', '4');
INSERT INTO `cn_order_good` VALUES ('326', '20180709104640rarru', '107', '270', '8');
INSERT INTO `cn_order_good` VALUES ('327', '20180709104723sp9y9', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('328', '2018070911412030b4j', '99', '226', '2');
INSERT INTO `cn_order_good` VALUES ('329', '2018070911412030b4j', '213', '757', '19');
INSERT INTO `cn_order_good` VALUES ('330', '20180709115412idqfs', '211', '622', '2');
INSERT INTO `cn_order_good` VALUES ('331', '20180710101550qo54a', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('332', '20180710101603v8irl', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('333', '20180710024019g5uiv', '211', '621', '1');
INSERT INTO `cn_order_good` VALUES ('334', '201807111037238edjc', '107', '270', '1');
INSERT INTO `cn_order_good` VALUES ('335', '20180711103750hqw75', '107', '270', '1');
INSERT INTO `cn_order_good` VALUES ('336', '20180711103808swxhi', '107', '270', '1');
INSERT INTO `cn_order_good` VALUES ('337', '20180711104159dahu3', '215', '897', '1');
INSERT INTO `cn_order_good` VALUES ('338', '201807110148205ulww', '216', '941', '1');
INSERT INTO `cn_order_good` VALUES ('339', '20180711015301unuj6', '117', '312', '1');
INSERT INTO `cn_order_good` VALUES ('340', '201807110153385nouz', '117', '312', '1');
INSERT INTO `cn_order_good` VALUES ('341', '20180711021613plqnb', '161', '468', '1');
INSERT INTO `cn_order_good` VALUES ('342', '20180711023143z3mvg', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('343', '20180711023210cbmem', '99', '227', '1');
INSERT INTO `cn_order_good` VALUES ('344', '20180711023323t9gd5', '99', '227', '1');
INSERT INTO `cn_order_good` VALUES ('345', '20180711041305wr0jl', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('346', '20180711043811qrd5i', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('347', '20180711043833w7vpx', '99', '231', '1');
INSERT INTO `cn_order_good` VALUES ('348', '2018071104385197ghp', '99', '234', '1');
INSERT INTO `cn_order_good` VALUES ('349', '20180711043910lnzob', '161', '469', '2');
INSERT INTO `cn_order_good` VALUES ('350', '20180711045442w9z5y', '213', '758', '8');
INSERT INTO `cn_order_good` VALUES ('351', '20180711052108l6jop', '229', '1221', '1');
INSERT INTO `cn_order_good` VALUES ('352', '201807110521496se2p', '229', '1221', '1');
INSERT INTO `cn_order_good` VALUES ('353', '20180711053608isfhx', '168', '479', '1');
INSERT INTO `cn_order_good` VALUES ('354', '201807110540101xuem', '234', '1820', '1');
INSERT INTO `cn_order_good` VALUES ('355', '20180712110321ilfy8', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('356', '20180713104701at8uf', '229', '1221', '1');
INSERT INTO `cn_order_good` VALUES ('357', '20180713104817hy0iv', '122', '346', '1');
INSERT INTO `cn_order_good` VALUES ('358', '2018071304593064fy7', '142', '393', '1');
INSERT INTO `cn_order_good` VALUES ('359', '20180713055301h9okl', '142', '393', '1');
INSERT INTO `cn_order_good` VALUES ('360', '20180713055301xg48e', '211', '622', '1');
INSERT INTO `cn_order_good` VALUES ('361', '201807151231082dyu5', '220', '1001', '4');
INSERT INTO `cn_order_good` VALUES ('362', '201807151231081dbid', '117', '317', '9');
INSERT INTO `cn_order_good` VALUES ('363', '20180716101900lbj17', '99', '235', '1');
INSERT INTO `cn_order_good` VALUES ('364', '2018071705294527v8c', '142', '398', '1');
INSERT INTO `cn_order_good` VALUES ('365', '20180718033949kqi13', '213', '758', '5');
INSERT INTO `cn_order_good` VALUES ('366', '20180718033949kqi13', '213', '757', '17');
INSERT INTO `cn_order_good` VALUES ('367', '20180718033949kqi13', '99', '226', '2');
INSERT INTO `cn_order_good` VALUES ('368', '20180718033949kqi13', '122', '344', '1');
INSERT INTO `cn_order_good` VALUES ('369', '20180719085350lc4t3', '214', '890', '14');
INSERT INTO `cn_order_good` VALUES ('370', '20180719085350lc4t3', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('371', '20180719025712e5o0m', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('372', '20180720091630xlo1a', '214', '894', '2');
INSERT INTO `cn_order_good` VALUES ('373', '20180720091630xlo1a', '214', '892', '1');
INSERT INTO `cn_order_good` VALUES ('374', '20180720092837uclad', '142', '396', '1');
INSERT INTO `cn_order_good` VALUES ('375', '20180721042139nhn3j', '99', '226', '1');
INSERT INTO `cn_order_good` VALUES ('376', '20180721043528bkwzq', '290', '2341', '1');
INSERT INTO `cn_order_good` VALUES ('377', '20180722091034e3x1u', '252', '2222', '1');
INSERT INTO `cn_order_good` VALUES ('378', '201807220921295hb7m', '227', '1177', '1');
INSERT INTO `cn_order_good` VALUES ('379', '201807271031487lzl4', '213', '840', '1');
INSERT INTO `cn_order_good` VALUES ('380', '20180727103207oalmu', '290', '2341', '1');
INSERT INTO `cn_order_good` VALUES ('381', '20180727041247mcndy', '99', '228', '1');
INSERT INTO `cn_order_good` VALUES ('382', '20180727042226rm9za', '213', '759', '1');
INSERT INTO `cn_order_good` VALUES ('383', '20180727042226yonm8', '216', '941', '2');
INSERT INTO `cn_order_good` VALUES ('384', '20180727044552452cj', '99', '226', '2');
INSERT INTO `cn_order_good` VALUES ('385', '20180728103951yfazk', '290', '2341', '1');
INSERT INTO `cn_order_good` VALUES ('386', '20180801023018cwini', '107', '271', '1');
INSERT INTO `cn_order_good` VALUES ('387', '20180801030158i53aj', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('388', '20180801031542p1hgx', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('389', '20180801045101vehk0', '289', '2339', '1');
INSERT INTO `cn_order_good` VALUES ('390', '20180801060246acx2i', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('391', '20180801060246o6t7l', '122', '344', '5');
INSERT INTO `cn_order_good` VALUES ('392', '20180801060246ymtea', '216', '941', '1');
INSERT INTO `cn_order_good` VALUES ('393', '20180802091809prd9s', '213', '757', '1');
INSERT INTO `cn_order_good` VALUES ('394', '20180802030514j5sm6', '161', '469', '1');

-- ----------------------------
-- Table structure for cn_user
-- ----------------------------
DROP TABLE IF EXISTS `cn_user`;
CREATE TABLE `cn_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `id_card` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `user_number` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `phone` varchar(12) NOT NULL DEFAULT '' COMMENT '手机号',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `real_name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `pic_img` varchar(255) DEFAULT '' COMMENT '用户头像',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态 0=冻结/1=正常',
  `amount` varchar(255) DEFAULT NULL COMMENT '总金额',
  `user_type` varchar(2) DEFAULT '0' COMMENT '用户类型',
  `regeist_time` datetime DEFAULT NULL COMMENT '注册时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '修改人',
  `idcard_front_img` varchar(200) DEFAULT NULL COMMENT '身份证正面照',
  `idcard_back_img` varchar(200) DEFAULT NULL COMMENT '身份证反面照',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of cn_user
-- ----------------------------
INSERT INTO `cn_user` VALUES ('9', null, null, '17682153208', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, 'Jack ', null, null, null, null, 'http://img.cnadmart.com/FqiRJH3fOPGLvTN-5xtXR5Eia87D.jpeg', null, null, '0', '2018-06-11 17:13:42', null, '2018-08-05 11:01:22', 'admin', null, null);
INSERT INTO `cn_user` VALUES ('10', null, null, '18155122471', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', null, '王老板', null, null, null, null, 'http://img.cnadmart.com/STORE/certification/015856820180702155819.jpeg', '1', null, '0', '2018-06-11 18:27:41', null, '2018-07-25 18:36:06', 'admin', null, null);
INSERT INTO `cn_user` VALUES ('11', null, null, '17755152862', '', null, '17755152862', null, null, null, null, '', null, null, '0', '2018-06-22 11:00:07', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('12', null, null, '15256036352', '', null, '原子弹', null, null, null, null, '', null, null, '0', '2018-06-25 11:28:38', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('13', null, null, '18356087258', '', null, '18356087258', null, null, null, null, '', null, null, '0', '2018-06-25 11:38:47', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('14', null, null, '18133637706', '', null, '18133637706', null, null, null, null, '', null, null, '0', '2018-06-25 14:28:44', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('15', null, null, '18856001958', '', null, '18856001958', null, null, null, null, '', null, null, '0', '2018-06-25 14:41:13', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('16', null, null, '13956976379', '', null, '13956976379', null, null, null, null, '', null, null, '0', '2018-06-25 14:41:29', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('17', null, null, '13093381314', '', null, '13093381314', null, null, null, null, '', null, null, '0', '2018-06-25 14:41:35', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('18', null, null, '18956466130', '', null, '18956466130', null, null, null, null, '', null, null, '0', '2018-06-25 14:41:43', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('19', null, null, '18856980642', '15e2b0d3c33891ebb0f1ef609ec419420c20e320ce94c65fbc8c3312448eb225', null, '', null, null, null, null, '', null, null, '0', '2018-06-25 14:43:00', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('20', null, null, '18214832895', '', null, '18214832895', null, null, null, null, '', null, null, '0', '2018-06-25 14:43:32', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('21', null, null, '15609685001', '', null, '15609685001', null, null, null, null, '', '0', null, '0', '2018-06-27 09:42:19', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('22', null, null, '18734804160', '', null, null, null, null, null, null, '', '0', null, '0', '2018-06-27 11:03:52', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('23', null, null, '13033087652', '', null, '13033087652', null, null, null, null, '', '0', null, '0', '2018-06-29 15:34:03', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('24', null, null, '18867532860', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, '18867532860', null, null, null, null, '', '0', null, '0', '2018-07-17 11:11:47', null, null, null, null, null);
INSERT INTO `cn_user` VALUES ('25', null, null, 'string', '473287f8298dba7163a897908958f7c0eae733e25d2e027992ea2edc9bed2fa8', null, 'string', null, null, null, null, '', '0', null, '0', '2018-07-24 15:05:25', null, null, null, null, null);

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('FreeterScheduler', 'TASK_7', 'DEFAULT', '0 0 12 * * ?', 'Asia/Shanghai');
INSERT INTO `qrtz_cron_triggers` VALUES ('FreeterScheduler', 'TASK_8', 'DEFAULT', '0 0/30 * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`) USING BTREE,
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`) USING BTREE,
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('FreeterScheduler', 'TASK_7', 'DEFAULT', null, 'com.freeter.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E667265657465722E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001650D513C407874000C302030203132202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000007740004746573747070737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);
INSERT INTO `qrtz_job_details` VALUES ('FreeterScheduler', 'TASK_8', 'DEFAULT', null, 'com.freeter.modules.job.utils.ScheduleJob', '0', '0', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E667265657465722E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001650D51DBC87874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000000000000000874000574657374327400076672656574657270737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('FreeterScheduler', 'STATE_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('FreeterScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------
INSERT INTO `qrtz_scheduler_state` VALUES ('FreeterScheduler', 'Wl-081533536350015', '1533537356458', '15000');
INSERT INTO `qrtz_scheduler_state` VALUES ('RenrenScheduler', 'iZez0h0eg9m3spZ1533353876511', '1533537361772', '15000');

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`) USING BTREE,
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`) USING BTREE,
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`) USING BTREE,
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('FreeterScheduler', 'TASK_7', 'DEFAULT', 'TASK_7', 'DEFAULT', null, '1533614400000', '-1', '5', 'PAUSED', 'CRON', '1533526752000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E667265657465722E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001650D513B007874000C302030203132202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000007740004746573747400076672656574657270737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000017800);
INSERT INTO `qrtz_triggers` VALUES ('FreeterScheduler', 'TASK_8', 'DEFAULT', 'TASK_8', 'DEFAULT', null, '1533537000000', '1533535200000', '5', 'PAUSED', 'CRON', '1533526793000', '0', null, '2', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000D4A4F425F504152414D5F4B455973720030636F6D2E667265657465722E6D6F64756C65732E6A6F622E656E746974792E5363686564756C654A6F62456E7469747900000000000000010200084C00086265616E4E616D657400124C6A6176612F6C616E672F537472696E673B4C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C000E63726F6E45787072657373696F6E71007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C000A6D6574686F644E616D6571007E00094C0006706172616D7371007E00094C000672656D61726B71007E00094C00067374617475737400134C6A6176612F6C616E672F496E74656765723B7870740008746573745461736B7372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001650D51DB287874000E3020302F3330202A202A202A203F7372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000008740005746573743274000070737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C75657871007E0013000000007800);

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------
INSERT INTO `schedule_job` VALUES ('7', 'testTask', 'test', 'freeter', '0 0 12 * * ?', '1', null, '2018-08-06 11:39:12');
INSERT INTO `schedule_job` VALUES ('8', 'testTask', 'test2', '', '0 0/30 * * * ?', '1', null, '2018-08-06 11:39:53');

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------
INSERT INTO `schedule_job_log` VALUES ('37', '7', 'testTask', 'test', null, '1', 'java.lang.NoSuchMethodException: com.freeter.modules.job.task.TestTask.test()', '1', '2018-08-06 12:28:41');
INSERT INTO `schedule_job_log` VALUES ('38', '8', 'testTask', 'test2', null, '0', null, '3', '2018-08-06 12:28:41');
INSERT INTO `schedule_job_log` VALUES ('39', '7', 'testTask', 'test', null, '1', 'java.lang.NoSuchMethodException: com.freeter.modules.job.task.TestTask.test()', '1', '2018-08-06 12:28:41');
INSERT INTO `schedule_job_log` VALUES ('40', '8', 'testTask', 'test2', null, '0', null, '1', '2018-08-06 12:28:41');
INSERT INTO `schedule_job_log` VALUES ('41', '8', 'testTask', 'test2', null, '0', null, '3', '2018-08-06 12:30:15');
INSERT INTO `schedule_job_log` VALUES ('42', '8', 'testTask', 'test2', null, '0', null, '1', '2018-08-06 12:31:06');
INSERT INTO `schedule_job_log` VALUES ('43', '7', 'testTask', 'test', 'freeter', '0', null, '1121', '2018-08-06 12:31:06');
INSERT INTO `schedule_job_log` VALUES ('44', '8', 'testTask', 'test2', null, '0', null, '15', '2018-08-06 13:00:07');
INSERT INTO `schedule_job_log` VALUES ('45', '8', 'testTask', 'test2', null, '0', null, '3', '2018-08-06 14:00:00');
INSERT INTO `schedule_job_log` VALUES ('46', '8', 'testTask', 'test2', null, '0', null, '1', '2018-08-06 14:00:59');
INSERT INTO `schedule_job_log` VALUES ('47', '7', 'testTask', 'test', 'freeter', '0', null, '1099', '2018-08-06 14:01:00');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_key` varchar(50) DEFAULT NULL COMMENT 'key',
  `param_value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `param_key` (`param_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"type\":1,\"qiniuDomain\":\"http://img.test.com\",\"qiniuPrefix\":\"\",\"qiniuAccessKey\":\"test\",\"qiniuSecretKey\":\"bAE7MROdaMlz1qZZD3dlzEtj4SIiGYez66h8diMj\",\"qiniuBucketName\":\"img-cnadmart-com\",\"aliyunDomain\":\"\",\"aliyunPrefix\":\"\",\"aliyunEndPoint\":\"\",\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qcloudBucketName\":\"\"}', '0', '云存储配置信息');
INSERT INTO `sys_config` VALUES ('2', '3', '3', '1', '3');
INSERT INTO `sys_config` VALUES ('3', '手动阀', '大师傅', '1', '阿发');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '寝室长', '1', '0');
INSERT INTO `sys_dept` VALUES ('2', '1', '628二哥', '1', '0');
INSERT INTO `sys_dept` VALUES ('3', '15', '628小四', '2', '0');
INSERT INTO `sys_dept` VALUES ('4', '3', '技术部', '0', '0');
INSERT INTO `sys_dept` VALUES ('5', '3', '销售部', '1', '0');
INSERT INTO `sys_dept` VALUES ('6', '0', null, '0', '-1');
INSERT INTO `sys_dept` VALUES ('7', '0', '444', '44', '-1');
INSERT INTO `sys_dept` VALUES ('8', '0', '628老大', '0', '0');
INSERT INTO `sys_dept` VALUES ('9', '8', '628老五', '0', '0');
INSERT INTO `sys_dept` VALUES ('10', '0', null, '0', '-1');
INSERT INTO `sys_dept` VALUES ('11', '0', 'alert(\"xss\");', '0', '-1');
INSERT INTO `sys_dept` VALUES ('12', '0', null, '0', '-1');
INSERT INTO `sys_dept` VALUES ('13', '0', null, '0', '-1');
INSERT INTO `sys_dept` VALUES ('14', '0', null, '0', '-1');
INSERT INTO `sys_dept` VALUES ('15', '0', '区管理员', '0', '0');
INSERT INTO `sys_dept` VALUES ('16', '15', '街道管理员', '0', '0');
INSERT INTO `sys_dept` VALUES ('17', '0', '13111111111', '0', '0');
INSERT INTO `sys_dept` VALUES ('18', '17', '234324', '0', '0');
INSERT INTO `sys_dept` VALUES ('19', '0', '1', '2', '-1');
INSERT INTO `sys_dept` VALUES ('20', '0', '1', '2', '-1');
INSERT INTO `sys_dept` VALUES ('21', '0', '22', '0', '0');
INSERT INTO `sys_dept` VALUES ('22', '0', '22', '0', '0');
INSERT INTO `sys_dept` VALUES ('23', '0', '22', '0', '0');
INSERT INTO `sys_dept` VALUES ('24', '0', '22', '0', '0');
INSERT INTO `sys_dept` VALUES ('25', '1', '测试部门', '0', '0');
INSERT INTO `sys_dept` VALUES ('26', '0', null, '0', '0');
INSERT INTO `sys_dept` VALUES ('27', '18', null, '0', '0');
INSERT INTO `sys_dept` VALUES ('28', '0', null, '0', '0');
INSERT INTO `sys_dept` VALUES ('29', '0', null, '0', '0');
INSERT INTO `sys_dept` VALUES ('30', '15', 'dfgdfgdfgdf', '0', '0');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '字典名称',
  `type` varchar(100) NOT NULL COMMENT '字典类型',
  `code` varchar(100) NOT NULL COMMENT '字典码',
  `value` varchar(1000) NOT NULL COMMENT '字典值',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '性别', 'sex', '0', '男', '0', null, '-1');
INSERT INTO `sys_dict` VALUES ('2', '性别', 'sex', '1', '男', '1', null, '-1');
INSERT INTO `sys_dict` VALUES ('3', '性别', 'sex', '2', '未知', '3', null, '-1');
INSERT INTO `sys_dict` VALUES ('4', '性别	', 'sex', '4', '人妖', '4', null, '-1');
INSERT INTO `sys_dict` VALUES ('5', '大大大', '2', '1', '1', '1', '1', '-1');
INSERT INTO `sys_dict` VALUES ('6', 'ads', 'ppppp', '12312312', '31111', '1', null, '0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=321 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"手机管理\",\"url\":\"modules/generator/tmobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '46', '127.0.0.1', '2018-04-23 11:27:48');
INSERT INTO `sys_log` VALUES ('2', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":41,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"手机管理\",\"url\":\"modules/generator/mobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '35', '127.0.0.1', '2018-04-23 11:33:54');
INSERT INTO `sys_log` VALUES ('3', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '41', '8', '127.0.0.1', '2018-04-23 13:28:27');
INSERT INTO `sys_log` VALUES ('4', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '45', '65', '127.0.0.1', '2018-04-23 13:28:38');
INSERT INTO `sys_log` VALUES ('5', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '43', '39', '127.0.0.1', '2018-04-23 13:28:47');
INSERT INTO `sys_log` VALUES ('6', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '44', '44', '127.0.0.1', '2018-04-23 13:28:55');
INSERT INTO `sys_log` VALUES ('7', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '42', '29', '127.0.0.1', '2018-04-23 13:29:02');
INSERT INTO `sys_log` VALUES ('8', 'admin', '删除菜单', 'io.renren.modules.sys.controller.SysMenuController.delete()', '41', '12', '127.0.0.1', '2018-04-23 13:29:20');
INSERT INTO `sys_log` VALUES ('9', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"手机管理\",\"url\":\"modules/sys/mobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '25', '127.0.0.1', '2018-04-23 13:30:00');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"手机管理\",\"url\":\"modules/sys/mobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '11', '127.0.0.1', '2018-04-23 13:30:47');
INSERT INTO `sys_log` VALUES ('11', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"手机管理\",\"url\":\"modules/sys/mobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '13', '127.0.0.1', '2018-04-23 13:31:31');
INSERT INTO `sys_log` VALUES ('12', 'admin', '保存菜单', 'io.renren.modules.sys.controller.SysMenuController.save()', '{\"menuId\":51,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"手机管理\",\"type\":0,\"orderNum\":0}', '22', '127.0.0.1', '2018-04-23 13:32:56');
INSERT INTO `sys_log` VALUES ('13', 'admin', '修改菜单', 'io.renren.modules.sys.controller.SysMenuController.update()', '{\"menuId\":46,\"parentId\":51,\"parentName\":\"手机管理\",\"name\":\"手机管理\",\"url\":\"modules/sys/mobile.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '11', '127.0.0.1', '2018-04-23 13:33:29');
INSERT INTO `sys_log` VALUES ('14', 'admin', '保存配置', 'io.renren.modules.sys.controller.SysConfigController.save()', '{\"id\":2,\"paramKey\":\"3\",\"paramValue\":\"3\",\"remark\":\"3\"}', '94', '127.0.0.1', '2018-04-25 11:40:44');
INSERT INTO `sys_log` VALUES ('15', 'admin', '保存角色', 'io.renren.modules.sys.controller.SysRoleController.save()', '{\"roleId\":1,\"roleName\":\"管理员角色\",\"deptId\":2,\"deptName\":\"长沙分公司\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26],\"deptIdList\":[],\"createTime\":\"May 14, 2018 4:33:20 PM\"}', '289', '0:0:0:0:0:0:0:1', '2018-05-14 16:33:20');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"人人开源集团\"}', '131', '0:0:0:0:0:0:0:1', '2018-05-14 16:33:35');
INSERT INTO `sys_log` VALUES ('17', 'admin', '修改用户', 'io.renren.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"人人开源集团\"}', '53', '0:0:0:0:0:0:0:1', '2018-05-14 16:47:14');
INSERT INTO `sys_log` VALUES ('18', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '51', '3', '0:0:0:0:0:0:0:1', '2018-05-26 09:21:16');
INSERT INTO `sys_log` VALUES ('19', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '46', '2', '0:0:0:0:0:0:0:1', '2018-05-26 09:21:28');
INSERT INTO `sys_log` VALUES ('20', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '51', '3', '0:0:0:0:0:0:0:1', '2018-05-26 09:21:35');
INSERT INTO `sys_log` VALUES ('21', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '46', '4', '0:0:0:0:0:0:0:1', '2018-05-26 09:21:42');
INSERT INTO `sys_log` VALUES ('22', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '46', '2', '0:0:0:0:0:0:0:1', '2018-05-26 09:21:55');
INSERT INTO `sys_log` VALUES ('23', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '50', '62', '0:0:0:0:0:0:0:1', '2018-05-26 09:22:06');
INSERT INTO `sys_log` VALUES ('24', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '47', '10', '0:0:0:0:0:0:0:1', '2018-05-26 09:22:20');
INSERT INTO `sys_log` VALUES ('25', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '48', '18', '0:0:0:0:0:0:0:1', '2018-05-26 09:22:28');
INSERT INTO `sys_log` VALUES ('26', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '49', '10', '0:0:0:0:0:0:0:1', '2018-05-26 09:22:59');
INSERT INTO `sys_log` VALUES ('27', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '46', '8', '0:0:0:0:0:0:0:1', '2018-05-26 09:23:04');
INSERT INTO `sys_log` VALUES ('28', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '51', '8', '0:0:0:0:0:0:0:1', '2018-05-26 09:23:09');
INSERT INTO `sys_log` VALUES ('29', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":62,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"商品管理\",\"type\":0,\"orderNum\":0}', '103', '127.0.0.1', '2018-05-29 08:59:09');
INSERT INTO `sys_log` VALUES ('30', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":57,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"频道管理\",\"url\":\"modules/good/channel.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":1}', '109', '127.0.0.1', '2018-05-29 08:59:41');
INSERT INTO `sys_log` VALUES ('31', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":52,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"分类管理\",\"url\":\"modules/good/category.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":2}', '98', '127.0.0.1', '2018-05-29 09:00:20');
INSERT INTO `sys_log` VALUES ('32', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":63,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"商品发布\",\"url\":\"modules/good/good.html\",\"type\":1,\"orderNum\":0}', '168', '127.0.0.1', '2018-05-31 11:27:20');
INSERT INTO `sys_log` VALUES ('33', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":63,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"商品发布\",\"url\":\"modules/good/good.html\",\"perms\":\"good:good:list\",\"type\":1,\"orderNum\":0}', '129', '127.0.0.1', '2018-05-31 11:28:46');
INSERT INTO `sys_log` VALUES ('34', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":63,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"商品发布\",\"url\":\"modules/good/good.html\",\"perms\":\"good:good:list,good:good:info,good:good:save,good:good:update,good:good:delete\",\"type\":1,\"orderNum\":0}', '118', '127.0.0.1', '2018-05-31 11:35:19');
INSERT INTO `sys_log` VALUES ('35', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":64,\"parentId\":62,\"parentName\":\"商品管理\",\"name\":\"商品规格\",\"url\":\"modules/good/categoryspec.html\",\"perms\":\"good:categoryspec:list,good:categoryspec:info,good:categoryspec:save,good:categoryspec:update,good:categoryspec:delete\",\"type\":1,\"orderNum\":0}', '120', '127.0.0.1', '2018-05-31 18:37:32');
INSERT INTO `sys_log` VALUES ('36', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":65,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"test\",\"url\":\"test\",\"type\":1,\"orderNum\":0}', '111', '0:0:0:0:0:0:0:1', '2018-06-01 18:09:00');
INSERT INTO `sys_log` VALUES ('37', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":66,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"test2\",\"url\":\"test\",\"type\":1,\"orderNum\":0}', '103', '0:0:0:0:0:0:0:1', '2018-06-01 18:19:48');
INSERT INTO `sys_log` VALUES ('38', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":67,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"订单管理\",\"url\":\"/order\",\"type\":1,\"orderNum\":0}', '93', '0:0:0:0:0:0:0:1', '2018-06-01 18:22:13');
INSERT INTO `sys_log` VALUES ('39', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '65', '149', '0:0:0:0:0:0:0:1', '2018-06-01 18:22:22');
INSERT INTO `sys_log` VALUES ('40', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '66', '132', '0:0:0:0:0:0:0:1', '2018-06-01 18:22:27');
INSERT INTO `sys_log` VALUES ('41', 'admin', '修改角色', 'com.cnadmart.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"管理员角色\",\"deptId\":2,\"deptName\":\"长沙分公司\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,67],\"deptIdList\":[],\"createTime\":\"May 14, 2018 4:33:20 PM\"}', '527', '0:0:0:0:0:0:0:1', '2018-06-01 18:23:01');
INSERT INTO `sys_log` VALUES ('42', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '67', '146', '0:0:0:0:0:0:0:1', '2018-06-01 18:23:40');
INSERT INTO `sys_log` VALUES ('43', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":68,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"订单管理\",\"type\":0,\"orderNum\":0}', '94', '0:0:0:0:0:0:0:1', '2018-06-01 18:23:57');
INSERT INTO `sys_log` VALUES ('44', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '68', '143', '0:0:0:0:0:0:0:1', '2018-06-01 18:24:20');
INSERT INTO `sys_log` VALUES ('45', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":69,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"订单管理\",\"url\":\"modules/order/order.html\",\"type\":1,\"orderNum\":0}', '95', '0:0:0:0:0:0:0:1', '2018-06-01 18:26:32');
INSERT INTO `sys_log` VALUES ('46', 'admin', '修改角色', 'com.cnadmart.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"管理员角色\",\"deptId\":1,\"deptName\":\"人人开源集团\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,69],\"deptIdList\":[],\"createTime\":\"May 14, 2018 4:33:20 PM\"}', '411', '0:0:0:0:0:0:0:1', '2018-06-01 18:29:01');
INSERT INTO `sys_log` VALUES ('47', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '69', '137', '0:0:0:0:0:0:0:1', '2018-06-01 18:29:49');
INSERT INTO `sys_log` VALUES ('48', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":70,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"订单管理\",\"type\":0,\"orderNum\":3}', '90', '0:0:0:0:0:0:0:1', '2018-06-01 18:30:12');
INSERT INTO `sys_log` VALUES ('49', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":71,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"订单列表\",\"url\":\"modules/order/orderList.html\",\"type\":1,\"orderNum\":0}', '114', '0:0:0:0:0:0:0:1', '2018-06-01 18:45:17');
INSERT INTO `sys_log` VALUES ('50', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":72,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"订单查询\",\"url\":\"modules/order/orderSelect.html\",\"type\":1,\"orderNum\":0}', '107', '0:0:0:0:0:0:0:1', '2018-06-05 17:08:08');
INSERT INTO `sys_log` VALUES ('51', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":73,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"我的订单\",\"url\":\"modules/order/myOrder.html\",\"type\":1,\"orderNum\":0}', '329', '0:0:0:0:0:0:0:1', '2018-06-05 17:14:05');
INSERT INTO `sys_log` VALUES ('52', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":73,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"我的订单\",\"url\":\"modules/order/myOrderList.html\",\"type\":1,\"orderNum\":0}', '121', '0:0:0:0:0:0:0:1', '2018-06-06 11:26:01');
INSERT INTO `sys_log` VALUES ('53', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":73,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"我的订单\",\"url\":\"modules/order/myOrderList.html\",\"type\":1,\"orderNum\":0}', '113', '0:0:0:0:0:0:0:1', '2018-06-06 11:26:01');
INSERT INTO `sys_log` VALUES ('54', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":72,\"parentId\":70,\"parentName\":\"订单管理\",\"name\":\"订单发货\",\"url\":\"modules/order/orderSelect.html\",\"type\":1,\"orderNum\":0}', '124', '0:0:0:0:0:0:0:1', '2018-06-06 11:28:06');
INSERT INTO `sys_log` VALUES ('55', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":74,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司管理\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":1,\"orderNum\":0}', '111', '0:0:0:0:0:0:0:1', '2018-06-06 13:13:48');
INSERT INTO `sys_log` VALUES ('56', 'admin', '修改角色', 'com.cnadmart.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"管理员角色\",\"deptId\":1,\"deptName\":\"人人开源集团\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,70,71,72,73,74],\"deptIdList\":[],\"createTime\":\"May 14, 2018 4:33:20 PM\"}', '611', '0:0:0:0:0:0:0:1', '2018-06-06 13:15:39');
INSERT INTO `sys_log` VALUES ('57', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":74,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司管理\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":0,\"orderNum\":0}', '91', '0:0:0:0:0:0:0:1', '2018-06-06 13:18:14');
INSERT INTO `sys_log` VALUES ('58', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":74,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司管理\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":0,\"orderNum\":0}', '87', '0:0:0:0:0:0:0:1', '2018-06-06 13:18:14');
INSERT INTO `sys_log` VALUES ('59', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":74,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司管理\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":0,\"orderNum\":4}', '84', '0:0:0:0:0:0:0:1', '2018-06-06 13:19:07');
INSERT INTO `sys_log` VALUES ('60', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":75,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司列表\",\"url\":\"modules/expressCompany/expresscompany\",\"type\":1,\"orderNum\":0}', '88', '0:0:0:0:0:0:0:1', '2018-06-06 13:20:11');
INSERT INTO `sys_log` VALUES ('61', 'admin', '删除菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.delete()', '75', '137', '0:0:0:0:0:0:0:1', '2018-06-06 13:20:21');
INSERT INTO `sys_log` VALUES ('62', 'admin', '保存菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.save()', '{\"menuId\":76,\"parentId\":74,\"parentName\":\"快递公司管理\",\"name\":\"快递公司列表\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":1,\"orderNum\":0}', '102', '0:0:0:0:0:0:0:1', '2018-06-06 13:21:05');
INSERT INTO `sys_log` VALUES ('63', 'admin', '修改菜单', 'com.cnadmart.modules.sys.controller.SysMenuController.update()', '{\"menuId\":76,\"parentId\":74,\"parentName\":\"快递公司管理\",\"name\":\"快递公司列表\",\"url\":\"modules/expressCompany/expresscompany.html\",\"perms\":\"expressCompany:expresscompany:save,expressCompany:expresscompany:update,expressCompany:expresscompany:delete,expressCompany:expresscompany:list\",\"type\":1,\"orderNum\":0}', '113', '0:0:0:0:0:0:0:1', '2018-06-06 13:26:37');
INSERT INTO `sys_log` VALUES ('64', 'admin', '保存角色', 'com.cnadmart.modules.sys.controller.SysRoleController.save()', '{\"roleId\":2,\"roleName\":\"加盟商\",\"deptId\":8,\"deptName\":\"加盟商\",\"menuIdList\":[70,72,73],\"deptIdList\":[],\"createTime\":\"Jun 7, 2018 4:29:40 PM\"}', '260', '192.168.1.196', '2018-06-07 16:29:41');
INSERT INTO `sys_log` VALUES ('65', 'admin', '保存用户', 'com.cnadmart.modules.sys.controller.SysUserController.save()', '{\"userId\":2,\"username\":\"fuyang\",\"password\":\"2ba789379d577b4c649e8419393acd85124ab8da1ff8163e76848f34b37f7c48\",\"salt\":\"mTN50NIevjz53gIMUuf7\",\"email\":\"111@111.com\",\"mobile\":\"1300001\",\"status\":1,\"roleIdList\":[2],\"createTime\":\"Jun 7, 2018 4:31:26 PM\",\"deptId\":9,\"deptName\":\"阜阳加盟商\"}', '324', '192.168.1.196', '2018-06-07 16:31:27');
INSERT INTO `sys_log` VALUES ('66', 'admin', '修改用户', 'com.cnadmart.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"广品会集团\"}', '218', '192.168.1.196', '2018-06-07 16:31:54');
INSERT INTO `sys_log` VALUES ('67', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@freeter.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '960', '127.0.0.1', '2018-06-22 22:04:14');
INSERT INTO `sys_log` VALUES ('68', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@freeter.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":5,\"deptName\":\"销售部\"}', '126', '119.123.204.210', '2018-06-27 02:56:22');
INSERT INTO `sys_log` VALUES ('69', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@freeter.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":5,\"deptName\":\"销售部\"}', '77', '117.136.81.191', '2018-06-27 09:11:13');
INSERT INTO `sys_log` VALUES ('70', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"menuId\":77,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试\",\"type\":0,\"orderNum\":0}', '308', '0:0:0:0:0:0:0:1', '2018-06-28 15:59:00');
INSERT INTO `sys_log` VALUES ('71', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '156', '127.0.0.1', '2018-06-29 11:29:38');
INSERT INTO `sys_log` VALUES ('72', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '2', '127.0.0.1', '2018-06-29 11:30:08');
INSERT INTO `sys_log` VALUES ('73', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '1', '127.0.0.1', '2018-06-29 11:31:12');
INSERT INTO `sys_log` VALUES ('74', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '2', '127.0.0.1', '2018-06-29 11:34:49');
INSERT INTO `sys_log` VALUES ('75', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":5,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"SQL监控\",\"url\":\"druid/sql.html\",\"type\":1,\"icon\":\"fa fa-bug\",\"orderNum\":4}', '2', '127.0.0.1', '2018-06-29 11:35:46');
INSERT INTO `sys_log` VALUES ('76', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":78,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"用户管理\",\"url\":\"modules/user/user.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '275', '127.0.0.1', '2018-06-30 13:49:31');
INSERT INTO `sys_log` VALUES ('77', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"menuId\":83,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"会员管理\",\"type\":0,\"orderNum\":0}', '199', '127.0.0.1', '2018-06-30 13:49:43');
INSERT INTO `sys_log` VALUES ('78', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":78,\"parentId\":83,\"parentName\":\"会员管理\",\"name\":\"用户管理\",\"url\":\"modules/user/user.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '216', '127.0.0.1', '2018-06-30 13:50:08');
INSERT INTO `sys_log` VALUES ('79', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":3,\"username\":\"aaa\",\"password\":\"802e9ec3eff8d4d2cc7d0ea810e67105d6bef0b67cf667cccf8a7b78aa564a42\",\"salt\":\"OrAy275H8yGALsHJwjwV\",\"email\":\"123456789@qq.com\",\"mobile\":\"18539978699\",\"status\":1,\"roleIdList\":[2],\"createTime\":\"Jul 3, 2018 5:04:16 PM\",\"deptId\":2,\"deptName\":\"628二哥\"}', '610', '0:0:0:0:0:0:0:1', '2018-07-03 17:04:17');
INSERT INTO `sys_log` VALUES ('80', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[3]', '424', '0:0:0:0:0:0:0:1', '2018-07-03 17:05:41');
INSERT INTO `sys_log` VALUES ('81', 'admin', '修改配置', 'com.freeter.modules.sys.controller.SysConfigController.update()', '{\"id\":2,\"paramKey\":\"3\",\"paramValue\":\"3\",\"remark\":\"3\"}', '58', '1.85.5.75', '2018-07-04 19:04:26');
INSERT INTO `sys_log` VALUES ('82', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"password\":\"c72dc7260d7829cb72221fddfb5a75c4cf1475979e2efb781409ef11a49afdb7\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@freeter.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":5,\"deptName\":\"销售部\"}', '117', '110.185.11.30', '2018-07-05 12:17:47');
INSERT INTO `sys_log` VALUES ('83', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '33', '222.249.170.85', '2018-07-05 14:45:50');
INSERT INTO `sys_log` VALUES ('84', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '1', '14.221.165.92', '2018-07-05 15:40:50');
INSERT INTO `sys_log` VALUES ('85', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '1', '14.221.165.92', '2018-07-05 15:40:51');
INSERT INTO `sys_log` VALUES ('86', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:40:52');
INSERT INTO `sys_log` VALUES ('87', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:40:52');
INSERT INTO `sys_log` VALUES ('88', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:40:52');
INSERT INTO `sys_log` VALUES ('89', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:05');
INSERT INTO `sys_log` VALUES ('90', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:06');
INSERT INTO `sys_log` VALUES ('91', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:06');
INSERT INTO `sys_log` VALUES ('92', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:06');
INSERT INTO `sys_log` VALUES ('93', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:06');
INSERT INTO `sys_log` VALUES ('94', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '14.221.165.92', '2018-07-05 15:41:06');
INSERT INTO `sys_log` VALUES ('95', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '22', '123.116.246.68', '2018-07-05 15:43:08');
INSERT INTO `sys_log` VALUES ('96', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '7', '61.157.91.111', '2018-07-05 19:43:05');
INSERT INTO `sys_log` VALUES ('97', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '0', '61.157.91.111', '2018-07-05 19:43:06');
INSERT INTO `sys_log` VALUES ('98', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"系统管理\",\"type\":0,\"icon\":\"fa fa-cog\",\"orderNum\":0}', '3', '119.96.131.4', '2018-07-06 10:04:26');
INSERT INTO `sys_log` VALUES ('99', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '119.96.131.4', '2018-07-06 10:04:34');
INSERT INTO `sys_log` VALUES ('100', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '119.96.131.4', '2018-07-06 10:04:35');
INSERT INTO `sys_log` VALUES ('101', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '0', '119.96.131.4', '2018-07-06 10:04:36');
INSERT INTO `sys_log` VALUES ('102', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '41', '1.28.208.91', '2018-07-06 10:12:00');
INSERT INTO `sys_log` VALUES ('103', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '25', '1.28.208.91', '2018-07-06 10:12:00');
INSERT INTO `sys_log` VALUES ('104', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '17', '1.28.208.91', '2018-07-06 10:12:00');
INSERT INTO `sys_log` VALUES ('105', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '17', '1.28.208.91', '2018-07-06 10:12:01');
INSERT INTO `sys_log` VALUES ('106', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":3,\"username\":\"1234\",\"password\":\"d8fa115dcd2b0fd01e45000a1f7e3169ef4bbaf3ab1d1bbaeee3b1fc0afe09b3\",\"salt\":\"RWO7ai3RWuWrcXM0g8bW\",\"email\":\"123123@123.com\",\"mobile\":\"1122222222\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Jul 6, 2018 1:16:30 PM\",\"deptId\":4,\"deptName\":\"技术部\"}', '131', '61.161.250.218', '2018-07-06 13:16:31');
INSERT INTO `sys_log` VALUES ('107', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[3]', '370', '0:0:0:0:0:0:0:1', '2018-07-06 13:54:07');
INSERT INTO `sys_log` VALUES ('108', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '28', '183.14.28.120', '2018-07-06 14:19:43');
INSERT INTO `sys_log` VALUES ('109', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin123\"', '33', '183.14.28.120', '2018-07-06 14:20:17');
INSERT INTO `sys_log` VALUES ('110', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":4,\"username\":\"lyp\",\"password\":\"e13bbabc60e5f658896ce9bd921af55e589d4202053712bd0ccb77618d8e2689\",\"salt\":\"zCu0dxRQA9rpsSQVPxTk\",\"email\":\"123@qq.com\",\"mobile\":\"18675582025\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Jul 6, 2018 5:52:21 PM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '263', '0:0:0:0:0:0:0:1', '2018-07-06 17:52:22');
INSERT INTO `sys_log` VALUES ('111', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '193', '219.136.95.205', '2018-07-06 18:54:09');
INSERT INTO `sys_log` VALUES ('112', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"\"}', '67', '219.136.95.205', '2018-07-06 18:54:18');
INSERT INTO `sys_log` VALUES ('113', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[1]', '8', '112.117.164.116', '2018-07-06 20:33:23');
INSERT INTO `sys_log` VALUES ('114', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[4]', '39', '112.117.164.116', '2018-07-06 20:33:28');
INSERT INTO `sys_log` VALUES ('115', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":5,\"username\":\"11\",\"password\":\"83c0bc390c9fa3c3caf0b9c0a96ce2d7c9ad55256ff8b7d4f7d19a67cfe08483\",\"salt\":\"20Fy7bRKF0MPQw2viSv3\",\"email\":\"393253@aa.com\",\"mobile\":\"1598\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Jul 6, 2018 11:09:29 PM\",\"deptId\":8,\"deptName\":\"628老大\"}', '78', '119.123.66.49', '2018-07-06 23:09:30');
INSERT INTO `sys_log` VALUES ('116', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":0,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '81', '222.129.186.14', '2018-07-06 23:47:19');
INSERT INTO `sys_log` VALUES ('117', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":77,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试\",\"type\":0,\"icon\":\"fa-bath\",\"orderNum\":0}', '369', '0:0:0:0:0:0:0:1', '2018-07-07 17:55:06');
INSERT INTO `sys_log` VALUES ('118', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":77,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试\",\"type\":0,\"icon\":\"\",\"orderNum\":0}', '333', '0:0:0:0:0:0:0:1', '2018-07-07 17:57:52');
INSERT INTO `sys_log` VALUES ('119', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":77,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试\",\"type\":0,\"icon\":\"fa fa-bath\",\"orderNum\":0}', '346', '0:0:0:0:0:0:0:1', '2018-07-07 17:59:40');
INSERT INTO `sys_log` VALUES ('120', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"商品管理\",\"type\":0,\"icon\":\"fa fa-shopping-basket\",\"orderNum\":0}', '340', '0:0:0:0:0:0:0:1', '2018-07-07 18:00:41');
INSERT INTO `sys_log` VALUES ('121', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[2]', '55', '14.23.9.60', '2018-07-07 20:27:14');
INSERT INTO `sys_log` VALUES ('122', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[5]', '41', '14.23.9.60', '2018-07-07 20:27:19');
INSERT INTO `sys_log` VALUES ('123', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[1]', '0', '14.23.9.60', '2018-07-07 20:27:22');
INSERT INTO `sys_log` VALUES ('124', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"password\":\"6ae43fdda4413c365ce5974da2bf25daf2c5110ed13dfbe02cc2e6d9299ce70c\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '77', '14.23.9.60', '2018-07-07 20:27:39');
INSERT INTO `sys_log` VALUES ('125', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"password\":\"e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '90', '14.23.9.60', '2018-07-07 20:28:25');
INSERT INTO `sys_log` VALUES ('126', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":2,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"管理员管理\",\"url\":\"modules/sys/user.html\",\"type\":1,\"icon\":\"fa fa-user\",\"orderNum\":2}', '262', '0:0:0:0:0:0:0:1', '2018-07-08 00:00:04');
INSERT INTO `sys_log` VALUES ('127', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '19', '122.97.174.162', '2018-07-08 08:49:12');
INSERT INTO `sys_log` VALUES ('128', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":7,\"username\":\"cc\",\"password\":\"03344a56bd04d08b06369cb88785b34551ac918b21c2d680b4b3a2e257759a13\",\"salt\":\"4n4LK6qDliE561Eaprt7\",\"email\":\"cc@163.com\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Jul 8, 2018 9:06:08 PM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '68', '183.192.13.237', '2018-07-08 21:06:09');
INSERT INTO `sys_log` VALUES ('129', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":8,\"username\":\"test001\",\"password\":\"d6330029b3bccb83308424875155ffd3ebb6a4d95c43357dd7c0bd65332c2da9\",\"salt\":\"q2R4eOg7cPrO50JKwYI6\",\"email\":\"111225544@qq.com\",\"mobile\":\"15770900555\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Jul 8, 2018 9:42:15 PM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '71', '220.112.121.154', '2018-07-08 21:42:16');
INSERT INTO `sys_log` VALUES ('130', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '19', '1.192.214.168', '2018-07-09 08:44:20');
INSERT INTO `sys_log` VALUES ('131', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '1', '119.97.224.2', '2018-07-09 08:49:30');
INSERT INTO `sys_log` VALUES ('132', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '0', '119.97.224.2', '2018-07-09 08:49:31');
INSERT INTO `sys_log` VALUES ('133', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '0', '119.97.224.2', '2018-07-09 08:49:32');
INSERT INTO `sys_log` VALUES ('134', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '0', '119.97.224.2', '2018-07-09 08:49:32');
INSERT INTO `sys_log` VALUES ('135', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '0', '119.97.224.2', '2018-07-09 08:49:33');
INSERT INTO `sys_log` VALUES ('136', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":15,\"parentId\":2,\"parentName\":\"管理员管理\",\"name\":\"查看\",\"perms\":\"sys:user:list,sys:user:info\",\"type\":0,\"orderNum\":0}', '0', '119.97.224.2', '2018-07-09 08:49:33');
INSERT INTO `sys_log` VALUES ('137', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"2\"', '54', '36.7.67.84', '2018-07-09 14:28:45');
INSERT INTO `sys_log` VALUES ('138', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:00');
INSERT INTO `sys_log` VALUES ('139', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:09');
INSERT INTO `sys_log` VALUES ('140', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:10');
INSERT INTO `sys_log` VALUES ('141', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:40');
INSERT INTO `sys_log` VALUES ('142', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:41');
INSERT INTO `sys_log` VALUES ('143', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:41');
INSERT INTO `sys_log` VALUES ('144', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:42');
INSERT INTO `sys_log` VALUES ('145', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:42');
INSERT INTO `sys_log` VALUES ('146', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:42');
INSERT INTO `sys_log` VALUES ('147', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:42');
INSERT INTO `sys_log` VALUES ('148', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:53');
INSERT INTO `sys_log` VALUES ('149', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('150', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('151', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('152', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('153', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '1', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('154', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:54');
INSERT INTO `sys_log` VALUES ('155', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:55');
INSERT INTO `sys_log` VALUES ('156', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:55');
INSERT INTO `sys_log` VALUES ('157', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:55');
INSERT INTO `sys_log` VALUES ('158', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":0,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:39:58');
INSERT INTO `sys_log` VALUES ('159', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":0,\"icon\":\"1231\",\"orderNum\":0}', '1', '183.226.132.38', '2018-07-09 23:40:10');
INSERT INTO `sys_log` VALUES ('160', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":0,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:11');
INSERT INTO `sys_log` VALUES ('161', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":0,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:11');
INSERT INTO `sys_log` VALUES ('162', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":0,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:11');
INSERT INTO `sys_log` VALUES ('163', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:13');
INSERT INTO `sys_log` VALUES ('164', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:13');
INSERT INTO `sys_log` VALUES ('165', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:13');
INSERT INTO `sys_log` VALUES ('166', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"2级菜单\",\"url\":\"123\",\"perms\":\"123\",\"type\":1,\"icon\":\"1231\",\"orderNum\":0}', '0', '183.226.132.38', '2018-07-09 23:40:13');
INSERT INTO `sys_log` VALUES ('167', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":1,\"roleName\":\"管理员角色\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,70,71,72,73,74],\"deptIdList\":[1,2,4,5,14,16,18,19,20],\"createTime\":\"May 14, 2018 4:33:20 PM\"}', '291', '183.226.132.38', '2018-07-09 23:41:15');
INSERT INTO `sys_log` VALUES ('168', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":9,\"username\":\"111\",\"password\":\"78fca66af83bd69548c2180c92f5655b70a2bc0adc4712904c67319b46f0bab8\",\"salt\":\"Vsi274BsRCLp38Ya9K73\",\"email\":\"123@123.com\",\"mobile\":\"123123123123\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Jul 10, 2018 8:48:02 AM\",\"deptId\":15,\"deptName\":\"区管理员\"}', '86', '175.10.25.181', '2018-07-10 08:48:03');
INSERT INTO `sys_log` VALUES ('169', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试一下而已\",\"url\":\"a\",\"type\":1,\"orderNum\":0}', '0', '118.112.73.140', '2018-07-10 10:50:39');
INSERT INTO `sys_log` VALUES ('170', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试一下而已\",\"url\":\"a\",\"type\":1,\"orderNum\":0}', '0', '118.112.73.140', '2018-07-10 10:50:42');
INSERT INTO `sys_log` VALUES ('171', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试一下而已\",\"url\":\"a\",\"type\":1,\"orderNum\":0}', '0', '118.112.73.140', '2018-07-10 10:50:45');
INSERT INTO `sys_log` VALUES ('172', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试一下而已\",\"url\":\"a\",\"type\":1,\"orderNum\":0}', '0', '118.112.73.140', '2018-07-10 10:50:46');
INSERT INTO `sys_log` VALUES ('173', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"测试一下而已\",\"url\":\"a\",\"type\":1,\"orderNum\":0}', '0', '118.112.73.140', '2018-07-10 10:50:46');
INSERT INTO `sys_log` VALUES ('174', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:02');
INSERT INTO `sys_log` VALUES ('175', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:03');
INSERT INTO `sys_log` VALUES ('176', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:03');
INSERT INTO `sys_log` VALUES ('177', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:04');
INSERT INTO `sys_log` VALUES ('178', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:04');
INSERT INTO `sys_log` VALUES ('179', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '29', '0', '118.112.73.140', '2018-07-10 10:51:04');
INSERT INTO `sys_log` VALUES ('180', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '55', '0', '118.112.73.140', '2018-07-10 11:11:15');
INSERT INTO `sys_log` VALUES ('181', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '55', '0', '118.112.73.140', '2018-07-10 11:11:16');
INSERT INTO `sys_log` VALUES ('182', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '55', '0', '118.112.73.140', '2018-07-10 11:11:16');
INSERT INTO `sys_log` VALUES ('183', 'admin', '保存角色', 'com.freeter.modules.sys.controller.SysRoleController.save()', '{\"roleId\":3,\"roleName\":\"数据权限测试\",\"remark\":\"22\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[],\"deptIdList\":[2],\"createTime\":\"Jul 10, 2018 5:49:53 PM\"}', '91', '113.240.250.185', '2018-07-10 17:49:54');
INSERT INTO `sys_log` VALUES ('184', 'admin', '保存角色', 'com.freeter.modules.sys.controller.SysRoleController.save()', '{\"roleId\":4,\"roleName\":\"数据权限测试\",\"remark\":\"22\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[],\"deptIdList\":[2],\"createTime\":\"Jul 10, 2018 5:50:12 PM\"}', '65', '113.240.250.185', '2018-07-10 17:50:13');
INSERT INTO `sys_log` VALUES ('185', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":2,\"roleName\":\"加盟商\",\"deptId\":8,\"deptName\":\"628老大\",\"menuIdList\":[1,2,15,16,18,6,8,9,12,70,72,73],\"deptIdList\":[20,22],\"createTime\":\"Jun 7, 2018 4:29:40 PM\"}', '140', '121.234.7.65', '2018-07-11 11:40:01');
INSERT INTO `sys_log` VALUES ('186', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"menuId\":84,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"广告位管理\",\"type\":0,\"orderNum\":0}', '200', '127.0.0.1', '2018-07-11 16:57:49');
INSERT INTO `sys_log` VALUES ('187', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":85,\"parentId\":84,\"parentName\":\"广告位管理\",\"name\":\"广告位管理\",\"url\":\"modules/adverts/adverts.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '353', '127.0.0.1', '2018-07-11 16:59:33');
INSERT INTO `sys_log` VALUES ('188', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '90', '33', '127.0.0.1', '2018-07-11 17:01:26');
INSERT INTO `sys_log` VALUES ('189', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '92', '321', '127.0.0.1', '2018-07-11 17:01:36');
INSERT INTO `sys_log` VALUES ('190', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '92', '304', '127.0.0.1', '2018-07-11 17:01:36');
INSERT INTO `sys_log` VALUES ('191', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '91', '285', '127.0.0.1', '2018-07-11 17:01:53');
INSERT INTO `sys_log` VALUES ('192', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '93', '765', '127.0.0.1', '2018-07-11 17:02:17');
INSERT INTO `sys_log` VALUES ('193', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '93', '252', '127.0.0.1', '2018-07-11 17:02:17');
INSERT INTO `sys_log` VALUES ('194', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '94', '446', '127.0.0.1', '2018-07-11 17:02:32');
INSERT INTO `sys_log` VALUES ('195', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '90', '329', '127.0.0.1', '2018-07-11 17:02:44');
INSERT INTO `sys_log` VALUES ('196', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":95,\"parentId\":84,\"parentName\":\"广告位管理\",\"name\":\"广告位详情\",\"url\":\"modules/adverts/advertsdetail.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '345', '127.0.0.1', '2018-07-11 17:03:08');
INSERT INTO `sys_log` VALUES ('197', 'admin', '保存角色', 'com.freeter.modules.sys.controller.SysRoleController.save()', '{\"roleId\":5,\"roleName\":\"admin\",\"remark\":\"admin\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[1,4,23,24,25,26],\"deptIdList\":[],\"createTime\":\"Jul 11, 2018 9:55:58 PM\"}', '222', '49.221.62.112', '2018-07-11 21:55:59');
INSERT INTO `sys_log` VALUES ('198', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":5,\"roleName\":\"admin\",\"remark\":\"admin\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[1,3,19,20,21,22,4,23,24,25,26],\"deptIdList\":[],\"createTime\":\"Jul 11, 2018 9:55:58 PM\"}', '142', '49.221.62.215', '2018-07-11 21:56:20');
INSERT INTO `sys_log` VALUES ('199', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":10,\"username\":\"test123\",\"password\":\"bc65eef5f18219958fe00f0c811b222a89f3d08257be072536c32cfbc10c520d\",\"salt\":\"CJdy9dSFZenBYkCXcW0k\",\"email\":\"1212@11.com\",\"status\":1,\"roleIdList\":[5],\"createTime\":\"Jul 11, 2018 9:56:57 PM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '127', '49.221.62.112', '2018-07-11 21:56:57');
INSERT INTO `sys_log` VALUES ('200', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '4', '119.139.199.192', '2018-07-12 14:30:36');
INSERT INTO `sys_log` VALUES ('201', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '1', '119.139.199.192', '2018-07-12 14:30:37');
INSERT INTO `sys_log` VALUES ('202', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '0', '119.139.199.192', '2018-07-12 14:30:37');
INSERT INTO `sys_log` VALUES ('203', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '0', '119.139.199.192', '2018-07-12 14:30:37');
INSERT INTO `sys_log` VALUES ('204', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '0', '119.139.199.192', '2018-07-12 14:30:37');
INSERT INTO `sys_log` VALUES ('205', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '1', '0', '119.139.199.192', '2018-07-12 14:30:37');
INSERT INTO `sys_log` VALUES ('206', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '62', '0', '119.139.199.192', '2018-07-12 14:30:40');
INSERT INTO `sys_log` VALUES ('207', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '62', '0', '119.139.199.192', '2018-07-12 14:30:40');
INSERT INTO `sys_log` VALUES ('208', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '62', '0', '119.139.199.192', '2018-07-12 14:30:41');
INSERT INTO `sys_log` VALUES ('209', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '17', '0', '119.139.199.192', '2018-07-12 14:30:49');
INSERT INTO `sys_log` VALUES ('210', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '17', '0', '119.139.199.192', '2018-07-12 14:30:49');
INSERT INTO `sys_log` VALUES ('211', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '17', '0', '119.139.199.192', '2018-07-12 14:30:49');
INSERT INTO `sys_log` VALUES ('212', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '17', '0', '119.139.199.192', '2018-07-12 14:30:49');
INSERT INTO `sys_log` VALUES ('213', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[1,6,7,8,9,10]', '7', '221.215.31.50', '2018-07-12 14:31:49');
INSERT INTO `sys_log` VALUES ('214', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":2,\"roleName\":\"加盟商\",\"deptId\":8,\"menuIdList\":[1,2,15,16,17,18,3,20,21,6,8,9,12,70,72,73],\"deptIdList\":[],\"createTime\":\"Jun 7, 2018 4:29:40 PM\"}', '326', '111.17.208.72', '2018-07-12 14:52:34');
INSERT INTO `sys_log` VALUES ('215', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":0,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '224', '58.221.146.34', '2018-07-12 15:55:27');
INSERT INTO `sys_log` VALUES ('216', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000000\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '70', '58.221.146.34', '2018-07-12 15:55:38');
INSERT INTO `sys_log` VALUES ('217', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"212\"', '27', '183.14.28.195', '2018-07-12 16:30:10');
INSERT INTO `sys_log` VALUES ('218', 'admin', '删除角色', 'com.freeter.modules.sys.controller.SysRoleController.delete()', '[1]', '90', '61.141.254.187', '2018-07-12 20:37:29');
INSERT INTO `sys_log` VALUES ('219', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":76,\"parentName\":\"快递公司列表\",\"name\":\"快递下级\",\"url\":\"test\",\"type\":1,\"orderNum\":0}', '0', '223.98.173.151', '2018-07-13 09:25:06');
INSERT INTO `sys_log` VALUES ('220', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":76,\"parentName\":\"快递公司列表\",\"name\":\"快递下级\",\"url\":\"test\",\"type\":1,\"orderNum\":0}', '0', '223.98.173.151', '2018-07-13 09:25:09');
INSERT INTO `sys_log` VALUES ('221', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":77,\"parentName\":\"测试\",\"name\":\"test\",\"url\":\"test\",\"type\":1,\"orderNum\":0}', '0', '223.98.173.151', '2018-07-13 09:26:01');
INSERT INTO `sys_log` VALUES ('222', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":77,\"parentName\":\"测试\",\"name\":\"test\",\"url\":\"test\",\"type\":0,\"orderNum\":0}', '0', '223.98.173.151', '2018-07-13 09:26:07');
INSERT INTO `sys_log` VALUES ('223', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":77,\"parentName\":\"测试\",\"name\":\"test\",\"url\":\"test\",\"type\":2,\"orderNum\":0}', '0', '223.98.173.151', '2018-07-13 09:26:10');
INSERT INTO `sys_log` VALUES ('224', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '51', '117.181.33.170', '2018-07-14 13:51:54');
INSERT INTO `sys_log` VALUES ('225', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@cnadmart.com\",\"mobile\":\"136000001\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '140', '122.238.71.8', '2018-07-15 15:19:55');
INSERT INTO `sys_log` VALUES ('226', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":6,\"username\":\"test\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"6666@163.com\",\"mobile\":\"\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Jul 8, 2018 6:56:22 PM\",\"deptId\":1,\"deptName\":\"寝室长\"}', '48', '122.238.71.8', '2018-07-15 15:21:19');
INSERT INTO `sys_log` VALUES ('227', 'admin', '保存配置', 'com.freeter.modules.sys.controller.SysConfigController.save()', '{\"id\":3,\"paramKey\":\"手动阀\",\"paramValue\":\"大师傅\",\"remark\":\"阿发\"}', '225', '113.122.114.198', '2018-07-17 16:46:31');
INSERT INTO `sys_log` VALUES ('228', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '1', '36.7.84.213', '2018-07-18 09:15:57');
INSERT INTO `sys_log` VALUES ('229', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:01');
INSERT INTO `sys_log` VALUES ('230', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:07');
INSERT INTO `sys_log` VALUES ('231', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:07');
INSERT INTO `sys_log` VALUES ('232', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '1', '36.7.84.213', '2018-07-18 09:16:07');
INSERT INTO `sys_log` VALUES ('233', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:07');
INSERT INTO `sys_log` VALUES ('234', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:08');
INSERT INTO `sys_log` VALUES ('235', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:08');
INSERT INTO `sys_log` VALUES ('236', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:08');
INSERT INTO `sys_log` VALUES ('237', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:08');
INSERT INTO `sys_log` VALUES ('238', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:09');
INSERT INTO `sys_log` VALUES ('239', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '1', '36.7.84.213', '2018-07-18 09:16:09');
INSERT INTO `sys_log` VALUES ('240', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:09');
INSERT INTO `sys_log` VALUES ('241', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:09');
INSERT INTO `sys_log` VALUES ('242', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:09');
INSERT INTO `sys_log` VALUES ('243', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:10');
INSERT INTO `sys_log` VALUES ('244', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:10');
INSERT INTO `sys_log` VALUES ('245', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:10');
INSERT INTO `sys_log` VALUES ('246', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:10');
INSERT INTO `sys_log` VALUES ('247', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:10');
INSERT INTO `sys_log` VALUES ('248', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:11');
INSERT INTO `sys_log` VALUES ('249', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"文件上传\",\"url\":\"modules/pc/11111.html\",\"perms\":\"sss\",\"type\":1,\"icon\":\"http://www.fontawesome.com.cn/faicons/\",\"orderNum\":0}', '0', '36.7.84.213', '2018-07-18 09:16:11');
INSERT INTO `sys_log` VALUES ('250', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":2,\"roleName\":\"加盟商\",\"deptId\":16,\"deptName\":\"街道管理员\",\"menuIdList\":[1,2,15,16,17,18,3,20,21,6,8,9,12,70,72,73],\"deptIdList\":[],\"createTime\":\"Jun 7, 2018 4:29:40 PM\"}', '188', '119.62.105.157', '2018-07-18 10:41:20');
INSERT INTO `sys_log` VALUES ('251', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '77', '367', '127.0.0.1', '2018-07-19 21:29:02');
INSERT INTO `sys_log` VALUES ('252', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '85', '32', '127.0.0.1', '2018-07-19 21:29:12');
INSERT INTO `sys_log` VALUES ('253', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '88', '276', '127.0.0.1', '2018-07-19 21:29:19');
INSERT INTO `sys_log` VALUES ('254', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '86', '276', '127.0.0.1', '2018-07-19 21:29:30');
INSERT INTO `sys_log` VALUES ('255', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '96', '275', '127.0.0.1', '2018-07-19 21:29:40');
INSERT INTO `sys_log` VALUES ('256', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '97', '273', '127.0.0.1', '2018-07-19 21:29:54');
INSERT INTO `sys_log` VALUES ('257', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '99', '278', '127.0.0.1', '2018-07-19 21:30:07');
INSERT INTO `sys_log` VALUES ('258', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"menuId\":99,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"超级代码生成器\",\"url\":\"modules/sys/generator.html\",\"type\":1,\"orderNum\":0}', '266', '127.0.0.1', '2018-07-24 10:45:40');
INSERT INTO `sys_log` VALUES ('259', 'admin', '删除用户', 'com.freeter.modules.sys.controller.SysUserController.delete()', '[7]', '43', '110.53.179.135', '2018-07-24 11:40:28');
INSERT INTO `sys_log` VALUES ('260', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":9,\"username\":\"111111\",\"password\":\"57059743cd9f7da534707879fde5ce16691d25b646fa252829275a2e0ec88937\",\"salt\":\"Vsi274BsRCLp38Ya9K73\",\"email\":\"123@123.com\",\"mobile\":\"123123123123\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Jul 10, 2018 8:48:03 AM\",\"deptId\":15,\"deptName\":\"区管理员\"}', '152', '110.53.179.135', '2018-07-24 11:40:38');
INSERT INTO `sys_log` VALUES ('261', 'admin', '保存用户', 'com.freeter.modules.sys.controller.SysUserController.save()', '{\"userId\":11,\"username\":\"laox\",\"password\":\"18ce5d55331cbaa4fef3a4f8cc991cd544e03ddab0f54e76f1b93c4d83e0915f\",\"salt\":\"dMxkzLTW53yMQXuOZp7L\",\"email\":\"111111@qq.com\",\"mobile\":\"15114112231\",\"status\":1,\"roleIdList\":[2],\"createTime\":\"Jul 24, 2018 11:41:21 AM\",\"deptId\":4,\"deptName\":\"技术部\"}', '86', '110.53.179.135', '2018-07-24 11:41:22');
INSERT INTO `sys_log` VALUES ('262', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '34', '183.238.79.11', '2018-07-24 19:51:29');
INSERT INTO `sys_log` VALUES ('263', 'admin', '修改用户', 'com.freeter.modules.sys.controller.SysUserController.update()', '{\"userId\":6,\"username\":\"test\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"6666@163.com\",\"status\":0,\"roleIdList\":[],\"createTime\":\"Jul 8, 2018 6:56:22 PM\",\"deptId\":15,\"deptName\":\"区管理员\"}', '75', '27.19.46.43', '2018-07-25 13:56:41');
INSERT INTO `sys_log` VALUES ('264', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":3,\"parentName\":\"角色管理\",\"name\":\"dsfa\",\"type\":0,\"orderNum\":0}', '1', '124.78.87.223', '2018-07-25 18:12:59');
INSERT INTO `sys_log` VALUES ('265', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"parentId\":3,\"parentName\":\"角色管理\",\"name\":\"dsfa\",\"type\":0,\"orderNum\":0}', '0', '124.78.87.223', '2018-07-25 18:13:00');
INSERT INTO `sys_log` VALUES ('266', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":2,\"roleName\":\"加盟商\",\"deptId\":16,\"deptName\":\"街道管理员\",\"menuIdList\":[1,2,15,16,17,18,3,20,21,6,8,9,12,70,72,73],\"deptIdList\":[4,5],\"createTime\":\"Jun 7, 2018 4:29:40 PM\"}', '412', '117.101.207.129', '2018-07-26 12:11:50');
INSERT INTO `sys_log` VALUES ('267', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":78,\"parentName\":\"用户管理\",\"name\":\"商品管理\",\"type\":0,\"icon\":\"fa fa-shopping-basket\",\"orderNum\":0}', '0', '117.101.207.129', '2018-07-26 12:12:10');
INSERT INTO `sys_log` VALUES ('268', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":62,\"parentId\":78,\"parentName\":\"用户管理\",\"name\":\"商品管理\",\"type\":0,\"icon\":\"fa fa-shopping-basket\",\"orderNum\":0}', '0', '117.101.207.129', '2018-07-26 12:12:12');
INSERT INTO `sys_log` VALUES ('269', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"admin\"', '21', '49.77.233.52', '2018-07-27 15:59:07');
INSERT INTO `sys_log` VALUES ('270', 'admin', '修改密码', 'com.freeter.modules.sys.controller.SysUserController.password()', '\"123456\"', '16', '49.77.233.52', '2018-07-27 15:59:59');
INSERT INTO `sys_log` VALUES ('271', 'admin', '修改角色', 'com.freeter.modules.sys.controller.SysRoleController.update()', '{\"roleId\":3,\"roleName\":\"数据权限测试\",\"remark\":\"22\",\"deptId\":1,\"deptName\":\"寝室长\",\"menuIdList\":[1,2,15,16,17,18],\"deptIdList\":[2],\"createTime\":\"Jul 10, 2018 5:49:54 PM\"}', '151', '183.156.76.155', '2018-07-27 23:44:06');
INSERT INTO `sys_log` VALUES ('272', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":3,\"parentId\":1,\"parentName\":\"系统管理\",\"name\":\"角色管理\",\"url\":\"modules/sys/role.html\",\"type\":1,\"icon\":\"fa fa-user-secret\",\"orderNum\":2}', '0', '113.208.136.18', '2018-08-01 10:48:09');
INSERT INTO `sys_log` VALUES ('273', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":70,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"订单管理\",\"type\":0,\"icon\":\"fa fa-bars\",\"orderNum\":3}', '106', '0:0:0:0:0:0:0:1', '2018-08-05 10:21:40');
INSERT INTO `sys_log` VALUES ('274', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":83,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"会员管理\",\"type\":0,\"icon\":\"fa fa-user-o\",\"orderNum\":0}', '75', '0:0:0:0:0:0:0:1', '2018-08-05 10:22:22');
INSERT INTO `sys_log` VALUES ('275', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":74,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"快递公司管理\",\"url\":\"modules/expressCompany/expresscompany.html\",\"type\":0,\"icon\":\"fa fa-wpexplorer\",\"orderNum\":4}', '72', '0:0:0:0:0:0:0:1', '2018-08-05 10:22:46');
INSERT INTO `sys_log` VALUES ('276', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":84,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"广告位管理\",\"type\":0,\"icon\":\"fa fa-superpowers\",\"orderNum\":0}', '82', '0:0:0:0:0:0:0:1', '2018-08-05 10:23:23');
INSERT INTO `sys_log` VALUES ('277', 'admin', '暂停定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.pause()', '[3]', '358', '127.0.0.1', '2018-08-06 11:25:55');
INSERT INTO `sys_log` VALUES ('278', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[3,4]', '594', '127.0.0.1', '2018-08-06 11:26:03');
INSERT INTO `sys_log` VALUES ('279', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[3,4]', '591', '127.0.0.1', '2018-08-06 11:30:31');
INSERT INTO `sys_log` VALUES ('280', 'admin', '暂停定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.pause()', '[3,4]', '821', '127.0.0.1', '2018-08-06 11:30:56');
INSERT INTO `sys_log` VALUES ('281', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[3,4]', '487', '127.0.0.1', '2018-08-06 11:31:04');
INSERT INTO `sys_log` VALUES ('282', 'admin', '保存定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.save()', '{\"jobId\":7,\"beanName\":\"testTask\",\"methodName\":\"test\",\"cronExpression\":\"0 0 12 * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:12 AM\"}', '584', '127.0.0.1', '2018-08-06 11:39:13');
INSERT INTO `sys_log` VALUES ('283', 'admin', '删除定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.delete()', '[4,3]', '2518', '127.0.0.1', '2018-08-06 11:39:35');
INSERT INTO `sys_log` VALUES ('284', 'admin', '保存定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.save()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"freeter\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '492', '127.0.0.1', '2018-08-06 11:39:54');
INSERT INTO `sys_log` VALUES ('285', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '431', '127.0.0.1', '2018-08-06 11:40:04');
INSERT INTO `sys_log` VALUES ('286', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '2007', '127.0.0.1', '2018-08-06 11:40:25');
INSERT INTO `sys_log` VALUES ('287', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '558', '127.0.0.1', '2018-08-06 11:42:34');
INSERT INTO `sys_log` VALUES ('288', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '513', '127.0.0.1', '2018-08-06 11:51:02');
INSERT INTO `sys_log` VALUES ('289', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '1639', '127.0.0.1', '2018-08-06 11:53:27');
INSERT INTO `sys_log` VALUES ('290', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '871', '127.0.0.1', '2018-08-06 11:54:19');
INSERT INTO `sys_log` VALUES ('291', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '464', '127.0.0.1', '2018-08-06 11:54:30');
INSERT INTO `sys_log` VALUES ('292', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '804', '127.0.0.1', '2018-08-06 11:54:50');
INSERT INTO `sys_log` VALUES ('293', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '1334', '127.0.0.1', '2018-08-06 11:55:16');
INSERT INTO `sys_log` VALUES ('294', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '16176', '127.0.0.1', '2018-08-06 11:57:57');
INSERT INTO `sys_log` VALUES ('295', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '3256', '127.0.0.1', '2018-08-06 11:59:40');
INSERT INTO `sys_log` VALUES ('296', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '391', '127.0.0.1', '2018-08-06 11:59:48');
INSERT INTO `sys_log` VALUES ('297', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '394', '127.0.0.1', '2018-08-06 12:01:18');
INSERT INTO `sys_log` VALUES ('298', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '400', '127.0.0.1', '2018-08-06 12:04:43');
INSERT INTO `sys_log` VALUES ('299', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":8,\"beanName\":\"testTask\",\"methodName\":\"test2\",\"params\":\"\",\"cronExpression\":\"0 0/30 * * * ?\",\"status\":0,\"createTime\":\"Aug 6, 2018 11:39:53 AM\"}', '5282', '127.0.0.1', '2018-08-06 12:05:11');
INSERT INTO `sys_log` VALUES ('300', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '417', '127.0.0.1', '2018-08-06 12:05:21');
INSERT INTO `sys_log` VALUES ('301', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '449', '127.0.0.1', '2018-08-06 12:06:00');
INSERT INTO `sys_log` VALUES ('302', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '968', '127.0.0.1', '2018-08-06 12:07:00');
INSERT INTO `sys_log` VALUES ('303', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '434', '127.0.0.1', '2018-08-06 12:24:25');
INSERT INTO `sys_log` VALUES ('304', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[8]', '394', '127.0.0.1', '2018-08-06 12:25:54');
INSERT INTO `sys_log` VALUES ('305', 'admin', '暂停定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.pause()', '[7,8]', '670', '127.0.0.1', '2018-08-06 12:28:07');
INSERT INTO `sys_log` VALUES ('306', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[7,8]', '774', '127.0.0.1', '2018-08-06 12:28:28');
INSERT INTO `sys_log` VALUES ('307', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[7,8]', '754', '127.0.0.1', '2018-08-06 12:28:39');
INSERT INTO `sys_log` VALUES ('308', 'admin', '修改定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.update()', '{\"jobId\":7,\"beanName\":\"testTask\",\"methodName\":\"test\",\"params\":\"freeter\",\"cronExpression\":\"0 0 12 * * ?\",\"status\":1,\"createTime\":\"Aug 6, 2018 11:39:12 AM\"}', '3764', '127.0.0.1', '2018-08-06 12:29:02');
INSERT INTO `sys_log` VALUES ('309', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[7,8]', '873', '127.0.0.1', '2018-08-06 12:29:17');
INSERT INTO `sys_log` VALUES ('310', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[7,8]', '1024', '127.0.0.1', '2018-08-06 12:29:54');
INSERT INTO `sys_log` VALUES ('311', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[7,8]', '690', '127.0.0.1', '2018-08-06 12:30:44');
INSERT INTO `sys_log` VALUES ('312', 'admin', '暂停定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.pause()', '[7,8]', '732', '127.0.0.1', '2018-08-06 14:00:39');
INSERT INTO `sys_log` VALUES ('313', 'admin', '立即执行任务', 'com.freeter.modules.job.controller.ScheduleJobController.run()', '[7,8]', '788', '127.0.0.1', '2018-08-06 14:00:58');
INSERT INTO `sys_log` VALUES ('314', 'admin', '恢复定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.resume()', '[8]', '520', '127.0.0.1', '2018-08-06 14:14:45');
INSERT INTO `sys_log` VALUES ('315', 'admin', '暂停定时任务', 'com.freeter.modules.job.controller.ScheduleJobController.pause()', '[8]', '507', '127.0.0.1', '2018-08-06 14:14:49');
INSERT INTO `sys_log` VALUES ('316', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '105', '39', '127.0.0.1', '2018-08-06 14:26:30');
INSERT INTO `sys_log` VALUES ('317', 'admin', '删除菜单', 'com.freeter.modules.sys.controller.SysMenuController.delete()', '106', '303', '127.0.0.1', '2018-08-06 14:26:35');
INSERT INTO `sys_log` VALUES ('318', 'admin', '保存菜单', 'com.freeter.modules.sys.controller.SysMenuController.save()', '{\"menuId\":115,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"广告位管理\",\"type\":0,\"orderNum\":4}', '940', '127.0.0.1', '2018-08-06 14:29:13');
INSERT INTO `sys_log` VALUES ('319', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":100,\"parentId\":115,\"parentName\":\"广告位管理\",\"name\":\"广告位表\",\"url\":\"modules/adverts/adverts.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '212', '127.0.0.1', '2018-08-06 14:29:41');
INSERT INTO `sys_log` VALUES ('320', 'admin', '修改菜单', 'com.freeter.modules.sys.controller.SysMenuController.update()', '{\"menuId\":110,\"parentId\":115,\"parentName\":\"广告位管理\",\"name\":\"广告位详情\",\"url\":\"modules/adverts/advertsdetail.html\",\"type\":1,\"icon\":\"fa fa-file-code-o\",\"orderNum\":6}', '212', '127.0.0.1', '2018-08-06 14:29:52');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'fa fa-cog', '0');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员管理', 'modules/sys/user.html', null, '1', 'fa fa-user', '2');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'modules/sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'modules/sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'modules/job/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'modules/sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'modules/sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'modules/oss/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('31', '1', '部门管理', 'modules/sys/dept.html', null, '1', 'fa fa-file-code-o', '1');
INSERT INTO `sys_menu` VALUES ('32', '31', '查看', null, 'sys:dept:list,sys:dept:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('33', '31', '新增', null, 'sys:dept:save,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('34', '31', '修改', null, 'sys:dept:update,sys:dept:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('35', '31', '删除', null, 'sys:dept:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('36', '1', '字典管理', 'modules/sys/dict.html', null, '1', 'fa fa-bookmark-o', '6');
INSERT INTO `sys_menu` VALUES ('37', '36', '查看', null, 'sys:dict:list,sys:dict:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('38', '36', '新增', null, 'sys:dict:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('39', '36', '修改', null, 'sys:dict:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('40', '36', '删除', null, 'sys:dict:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('52', '62', '分类管理', 'modules/good/category.html', null, '1', 'fa fa-file-code-o', '2');
INSERT INTO `sys_menu` VALUES ('53', '52', '查看', null, 'good:category:list,good:category:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('54', '52', '新增', null, 'good:category:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('55', '52', '修改', null, 'good:category:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('56', '52', '删除', null, 'good:category:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('57', '62', '频道管理', 'modules/good/channel.html', null, '1', 'fa fa-file-code-o', '1');
INSERT INTO `sys_menu` VALUES ('58', '57', '查看', null, 'good:channel:list,good:channel:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('59', '57', '新增', null, 'good:channel:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('60', '57', '修改', null, 'good:channel:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('61', '57', '删除', null, 'good:channel:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('62', '0', '商品管理', null, null, '0', 'fa fa-shopping-basket', '0');
INSERT INTO `sys_menu` VALUES ('63', '62', '商品发布', 'modules/good/good.html', 'good:good:list,good:good:info,good:good:save,good:good:update,good:good:delete', '1', null, '0');
INSERT INTO `sys_menu` VALUES ('64', '62', '商品规格', 'modules/good/categoryspec.html', 'good:categoryspec:list,good:categoryspec:info,good:categoryspec:save,good:categoryspec:update,good:categoryspec:delete', '1', null, '0');
INSERT INTO `sys_menu` VALUES ('70', '0', '订单管理', null, null, '0', 'fa fa-bars', '3');
INSERT INTO `sys_menu` VALUES ('71', '70', '订单列表', 'modules/order/orderList.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('72', '70', '订单发货', 'modules/order/orderSelect.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('73', '70', '我的订单', 'modules/order/myOrderList.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('74', '0', '快递公司管理', 'modules/expressCompany/expresscompany.html', null, '0', 'fa fa-wpexplorer', '4');
INSERT INTO `sys_menu` VALUES ('76', '74', '快递公司列表', 'modules/expressCompany/expresscompany.html', 'expressCompany:expresscompany:save,expressCompany:expresscompany:update,expressCompany:expresscompany:delete,expressCompany:expresscompany:list', '1', null, '0');
INSERT INTO `sys_menu` VALUES ('78', '83', '用户管理', 'modules/user/user.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('79', '78', '查看', null, 'user:user:list,user:user:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('80', '78', '新增', null, 'user:user:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('81', '78', '修改', null, 'user:user:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('82', '78', '删除', null, 'user:user:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('83', '0', '会员管理', null, null, '0', 'fa fa-user-o', '0');
INSERT INTO `sys_menu` VALUES ('99', '1', '超级代码生成器', 'modules/sys/generator.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('100', '115', '广告位表', 'modules/adverts/adverts.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('101', '100', '查看', null, 'adverts:adverts:list,adverts:adverts:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('102', '100', '新增', null, 'adverts:adverts:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('103', '100', '修改', null, 'adverts:adverts:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('104', '100', '删除', null, 'adverts:adverts:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('110', '115', '广告位详情', 'modules/adverts/advertsdetail.html', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `sys_menu` VALUES ('111', '110', '查看', null, 'adverts:advertsdetail:list,test:advertsdetail:info', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('112', '110', '新增', null, 'adverts:advertsdetail:save', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('113', '110', '修改', null, 'adverts:advertsdetail:update', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('114', '110', '删除', null, 'adverts:advertsdetail:delete', '2', null, '6');
INSERT INTO `sys_menu` VALUES ('115', '0', '广告位管理', null, null, '0', null, '4');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2', '加盟商', null, '16', '2018-06-07 16:29:40');
INSERT INTO `sys_role` VALUES ('3', '数据权限测试', '22', '1', '2018-07-10 17:49:54');
INSERT INTO `sys_role` VALUES ('4', '数据权限测试', '22', '1', '2018-07-10 17:50:13');
INSERT INTO `sys_role` VALUES ('5', 'admin', 'admin', '1', '2018-07-11 21:55:58');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('11', '4', '2');
INSERT INTO `sys_role_dept` VALUES ('12', '2', '4');
INSERT INTO `sys_role_dept` VALUES ('13', '2', '5');
INSERT INTO `sys_role_dept` VALUES ('14', '3', '2');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('114', '5', '1');
INSERT INTO `sys_role_menu` VALUES ('115', '5', '3');
INSERT INTO `sys_role_menu` VALUES ('116', '5', '19');
INSERT INTO `sys_role_menu` VALUES ('117', '5', '20');
INSERT INTO `sys_role_menu` VALUES ('118', '5', '21');
INSERT INTO `sys_role_menu` VALUES ('119', '5', '22');
INSERT INTO `sys_role_menu` VALUES ('120', '5', '4');
INSERT INTO `sys_role_menu` VALUES ('121', '5', '23');
INSERT INTO `sys_role_menu` VALUES ('122', '5', '24');
INSERT INTO `sys_role_menu` VALUES ('123', '5', '25');
INSERT INTO `sys_role_menu` VALUES ('124', '5', '26');
INSERT INTO `sys_role_menu` VALUES ('157', '2', '1');
INSERT INTO `sys_role_menu` VALUES ('158', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('159', '2', '15');
INSERT INTO `sys_role_menu` VALUES ('160', '2', '16');
INSERT INTO `sys_role_menu` VALUES ('161', '2', '17');
INSERT INTO `sys_role_menu` VALUES ('162', '2', '18');
INSERT INTO `sys_role_menu` VALUES ('163', '2', '3');
INSERT INTO `sys_role_menu` VALUES ('164', '2', '20');
INSERT INTO `sys_role_menu` VALUES ('165', '2', '21');
INSERT INTO `sys_role_menu` VALUES ('166', '2', '6');
INSERT INTO `sys_role_menu` VALUES ('167', '2', '8');
INSERT INTO `sys_role_menu` VALUES ('168', '2', '9');
INSERT INTO `sys_role_menu` VALUES ('169', '2', '12');
INSERT INTO `sys_role_menu` VALUES ('170', '2', '70');
INSERT INTO `sys_role_menu` VALUES ('171', '2', '72');
INSERT INTO `sys_role_menu` VALUES ('172', '2', '73');
INSERT INTO `sys_role_menu` VALUES ('173', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('174', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('175', '3', '15');
INSERT INTO `sys_role_menu` VALUES ('176', '3', '16');
INSERT INTO `sys_role_menu` VALUES ('177', '3', '17');
INSERT INTO `sys_role_menu` VALUES ('178', '3', '18');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', 'root@cnadmart.com', '136000001', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('6', 'test', 'e1153123d7d180ceeb820d577ff119876678732a68eef4e6ffc0b1f06a01f91b', 'YzcmCZNvbXocrsz9dm8e', '6666@163.com', null, '0', '15', '2018-07-08 18:56:22');
INSERT INTO `sys_user` VALUES ('8', 'test001', 'd6330029b3bccb83308424875155ffd3ebb6a4d95c43357dd7c0bd65332c2da9', 'q2R4eOg7cPrO50JKwYI6', '111225544@qq.com', '15770900555', '1', '1', '2018-07-08 21:42:16');
INSERT INTO `sys_user` VALUES ('9', '111111', '57059743cd9f7da534707879fde5ce16691d25b646fa252829275a2e0ec88937', 'Vsi274BsRCLp38Ya9K73', '123@123.com', '123123123123', '1', '15', '2018-07-10 08:48:03');
INSERT INTO `sys_user` VALUES ('10', 'test123', 'bc65eef5f18219958fe00f0c811b222a89f3d08257be072536c32cfbc10c520d', 'CJdy9dSFZenBYkCXcW0k', '1212@11.com', null, '1', '1', '2018-07-11 21:56:57');
INSERT INTO `sys_user` VALUES ('11', 'laox', '18ce5d55331cbaa4fef3a4f8cc991cd544e03ddab0f54e76f1b93c4d83e0915f', 'dMxkzLTW53yMQXuOZp7L', '111111@qq.com', '15114112231', '1', '4', '2018-07-24 11:41:22');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('3', '2', '2');
INSERT INTO `sys_user_role` VALUES ('20', '10', '5');
INSERT INTO `sys_user_role` VALUES ('21', '11', '2');
