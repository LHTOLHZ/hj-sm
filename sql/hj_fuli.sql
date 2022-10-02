/*
 Navicat MySQL Data Transfer

 Source Server         : local-
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : hj_fuli

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 14/09/2022 23:48:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hj_account
-- ----------------------------

-- ----------------------------
-- Records of hj_account
-- ----------------------------

-- ----------------------------
-- Table structure for hj_comment
-- ----------------------------
DROP TABLE IF EXISTS `hj_comment`;
CREATE TABLE `hj_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `opus_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作品名称',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `display` int(1) NULL DEFAULT 0 COMMENT '0：不显示  1：显示',
  `create_date` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hj_comment
-- ----------------------------

-- ----------------------------
-- Table structure for hj_material
-- ----------------------------
DROP TABLE IF EXISTS `hj_material`;
CREATE TABLE `hj_material`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `main` int(1) NULL DEFAULT NULL COMMENT '否是主图 1：是 0:否',
  `type` int(1) NULL DEFAULT NULL COMMENT '0:图片 1：视频',
  `opus_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作品编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '素材' ROW_FORMAT = Dynamic;
DROP TABLE IF EXISTS `hj_account`;
CREATE TABLE `hj_account` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                              `birthday` varchar(20) DEFAULT NULL COMMENT '生日',
                              `province` varchar(30) DEFAULT NULL COMMENT '省份',
                              `city` varchar(30) DEFAULT NULL COMMENT '城市',
                              `occupation` varchar(50) DEFAULT NULL COMMENT '职业',
                              `autograph` varchar(50) DEFAULT NULL COMMENT '签名',
                              `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
                              `source` varchar(20) DEFAULT NULL COMMENT '来源',
                              `fl_Currency` int(8) DEFAULT '0' COMMENT '富力币',
                              `growth_value` int(8) DEFAULT '0' COMMENT '成长值',
                              `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                              `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                              `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                              `remark` varchar(500) DEFAULT NULL COMMENT '备注',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='会员';

-- ----------------------------
-- Table structure for hj_opus
-- ----------------------------
DROP TABLE IF EXISTS `hj_opus`;
CREATE TABLE `hj_opus` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `code` varchar(50) DEFAULT NULL COMMENT '作品编号 20220901121212 +纳秒',
                           `name` varchar(50) DEFAULT NULL COMMENT '作品名称',
                           `price` varchar(20) DEFAULT NULL COMMENT '价格',
                           `author` varchar(50) DEFAULT NULL COMMENT '作者',
                           `qq` varchar(20) DEFAULT NULL,
                           `wechat` varchar(20) DEFAULT NULL COMMENT '微信',
                           `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
                           `keyword` varchar(100) DEFAULT NULL COMMENT '关键字',
                           `remark` longtext COMMENT '介绍',
                           `network_url` varchar(500) DEFAULT NULL COMMENT '网盘地址',
                           `network_code` varchar(10) DEFAULT NULL COMMENT '网盘编码',
                           `zip_code` varchar(10) DEFAULT NULL COMMENT '解压码',
                           `state` int(1) DEFAULT '1' COMMENT '审核状态 1：待审核 ；2：审核中；3-审核未通过；4-审核已通过',
                           `superior` int(1) DEFAULT NULL COMMENT '0：下架  1：上架',
                           `selected` int(1) DEFAULT NULL COMMENT '0：非精选 1:精选',
                           `browse_num` int(8) DEFAULT NULL COMMENT '浏览数',
                           `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='作品';
-- ----------------------------
-- Records of hj_material
-- ----------------------------

-- ----------------------------
-- Table structure for hj_opus
-- ----------------------------

-- ----------------------------
-- Records of hj_opus
-- ----------------------------

-- ----------------------------
-- Table structure for hj_order
-- ----------------------------
DROP TABLE IF EXISTS `hj_order`;
CREATE TABLE `hj_order`  (
  `id` bigint(20) NOT NULL,
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号20220901121212 +纳秒',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单金额',
  `payment_method` int(1) NULL DEFAULT NULL COMMENT '支付方式 0：支付宝',
  `source` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单来源',
  `state` int(2) NULL DEFAULT NULL COMMENT '0：待付款  3：支付完成  5：平台确认订单  8:订单完成',
  `create_date` datetime NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hj_order
-- ----------------------------

-- ----------------------------
-- Table structure for hj_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `hj_order_detail`;
CREATE TABLE `hj_order_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `opus_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作品编号',
  `opus_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作品名称',
  `keyword` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作品关键字',
  `price` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '价格',
  `num` int(8) NULL DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hj_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `hj_opus_collection`;
CREATE TABLE `hj_opus_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `opus_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `create_date` datetime NULL DEFAULT NULL,
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作品收藏' ROW_FORMAT = Dynamic;
SET FOREIGN_KEY_CHECKS = 1;
