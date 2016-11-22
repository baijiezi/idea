/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-11-22 09:52:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks_gudong`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_gudong`;
CREATE TABLE `sic_stocks_gudong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `gdName` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
