/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-03-21 15:55:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks_fenhong`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_fenhong`;
CREATE TABLE `sic_stocks_fenhong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `date` date NOT NULL,
  `fenHongFangAn` varchar(64) NOT NULL,
  `paiXianJinE` bigint(20) NOT NULL,
  `meiGuShouYi` int(11) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL,
  `createAt` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_fenhong
-- ----------------------------
INSERT INTO `sic_stocks_fenhong` VALUES ('1', '22', 'aaa', '2016-03-21', 'fwef', '23', null, null, '2016-03-21');

-- ----------------------------
-- Table structure for `sic_stocks_gqdjr`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_gqdjr`;
CREATE TABLE `sic_stocks_gqdjr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `date` date NOT NULL,
  `createAt` date NOT NULL,
  `fenHongFangAn` varchar(255) DEFAULT NULL,
  `meiGuShouYi` int(11) DEFAULT NULL,
  `paiXianJinE` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_gqdjr
-- ----------------------------
INSERT INTO `sic_stocks_gqdjr` VALUES ('1', '222222', 'a', '2016-03-21', '2016-03-21', null, null, null, null);
