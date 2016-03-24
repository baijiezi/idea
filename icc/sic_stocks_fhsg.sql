/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-03-24 19:25:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks_fhsg`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_fhsg`;
CREATE TABLE `sic_stocks_fhsg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `gongGaoRi` date NOT NULL,
  `fenHong` int(11) DEFAULT NULL,
  `songGu` int(11) DEFAULT NULL,
  `zhuanZeng` int(11) DEFAULT NULL,
  `dengJiRi` date DEFAULT NULL,
  `chuQuanRi` date DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `createAt` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`gongGaoRi`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_fhsg
-- ----------------------------
INSERT INTO `sic_stocks_fhsg` VALUES ('1', '111', '222', '2016-03-24', null, null, null, null, null, null, '2016-03-24');
