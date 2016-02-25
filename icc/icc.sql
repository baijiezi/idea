/*
Navficat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-02-23 19:29:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks`;
CREATE TABLE `sic_stocks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `code` varchar(64) NOT NULL,
  `belongTo` varchar(64) DEFAULT NULL,
  `type` varchar(64) DEFAULT NULL,
  `subType` varchar(64) DEFAULT NULL,
  `detailUrl` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks
-- ----------------------------
