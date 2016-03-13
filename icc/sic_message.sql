/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-13 22:12:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_message`
-- ----------------------------
DROP TABLE IF EXISTS `sic_message`;
CREATE TABLE `sic_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplier` varchar(64) DEFAULT NULL,
  `account` varchar(64) DEFAULT NULL,
  `authkey` varchar(64) DEFAULT NULL,
  `cgid` varchar(64) DEFAULT NULL,
  `mobile` varchar(64) NOT NULL,
  `type` varchar(64) DEFAULT NULL,
  `content` varchar(256) NOT NULL,
  `sendTime` date DEFAULT NULL,
  `status` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_message
-- ----------------------------
