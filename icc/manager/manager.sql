/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : manager

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-09-30 14:49:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jxc_goods`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_goods`;
CREATE TABLE `jxc_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `classes` varchar(32) DEFAULT NULL,
  `buyPrice` int(11) DEFAULT NULL,
  `salePrice` int(11) DEFAULT NULL,
  `buyCount` int(11) DEFAULT NULL,
  `saledCount` int(11) DEFAULT NULL,
  `stockCount` int(11) DEFAULT NULL,
  `status` int(8) NOT NULL DEFAULT '0' COMMENT '0正常,1无货,2下架',
  `createTime` datetime NOT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_goods
-- ----------------------------
INSERT INTO `jxc_goods` VALUES ('16', '111111111', 'name', null, null, null, null, null, null, '0', '2016-09-21 16:25:53', null);
INSERT INTO `jxc_goods` VALUES ('18', '1111111112221', 'name', null, null, null, null, null, null, '0', '2016-09-21 16:28:14', null);
INSERT INTO `jxc_goods` VALUES ('19', 'a', '', '', null, null, null, null, null, '0', '2016-09-30 12:55:05', '');
INSERT INTO `jxc_goods` VALUES ('20', '', '', '', null, null, null, null, null, '0', '2016-09-30 12:57:40', '');

-- ----------------------------
-- Table structure for `jxc_goods_buy`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_goods_buy`;
CREATE TABLE `jxc_goods_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `classes` varchar(32) DEFAULT NULL,
  `buySource` varchar(64) NOT NULL,
  `buyPrice` int(11) DEFAULT NULL,
  `buyCount` int(11) DEFAULT NULL,
  `stockCount` int(11) DEFAULT NULL,
  `status` int(8) NOT NULL DEFAULT '0' COMMENT '0正常,1',
  `buyTime` datetime NOT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_goods_buy
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_goods_classes`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_goods_classes`;
CREATE TABLE `jxc_goods_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(64) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_goods_classes
-- ----------------------------

-- ----------------------------
-- Table structure for `jxc_goods_sale`
-- ----------------------------
DROP TABLE IF EXISTS `jxc_goods_sale`;
CREATE TABLE `jxc_goods_sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `classes` varchar(32) DEFAULT NULL,
  `saleTo` varchar(64) DEFAULT NULL,
  `salePrice` int(11) DEFAULT NULL,
  `saleCount` int(11) DEFAULT NULL,
  `stockCount` int(11) DEFAULT NULL,
  `status` int(8) NOT NULL DEFAULT '0' COMMENT '0正常,1',
  `createTime` datetime NOT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jxc_goods_sale
-- ----------------------------
INSERT INTO `jxc_goods_sale` VALUES ('1', '1111111112221', 'name', '', null, '12', null, null, '0', '2016-09-30 14:32:54', '喂喂');
INSERT INTO `jxc_goods_sale` VALUES ('3', '1111111112221', 'name', '', null, '130', null, null, '0', '2016-09-30 14:48:44', '我');
