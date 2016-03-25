/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-03-25 10:09:58
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
  `createAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`gongGaoRi`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_fhsg
-- ----------------------------
INSERT INTO `sic_stocks_fhsg` VALUES ('22', '600887', '', '2015-08-29', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('23', '600887', '', '2015-04-25', '8000', '0', '10', '2015-05-27', '2015-05-28', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('24', '600887', '', '2014-08-30', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('25', '600887', '', '2014-04-30', '8000', '0', '5', '2014-07-15', '2014-07-16', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('26', '600887', '', '2013-08-31', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('27', '600887', '', '2013-04-27', '2800', '0', '0', '2013-05-30', '2013-05-31', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('28', '600887', '', '2012-08-21', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('29', '600887', '', '2012-02-29', '2500', '0', '0', '2012-04-11', '2012-04-12', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('30', '600887', '', '2011-08-06', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('31', '600887', '', '2011-04-30', '0', '0', '10', '2011-06-10', '2011-06-13', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('32', '600887', '', '2010-08-28', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('33', '600887', '', '2010-04-27', '0', '0', '0', null, null, '股东大会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('34', '600887', '', '2009-08-29', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('35', '600887', '', '2009-04-30', '0', '0', '0', null, null, '股东大会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('36', '600887', '', '2008-08-30', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('37', '600887', '', '2008-03-11', '0', '0', '2', '2008-05-21', '2008-05-22', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('38', '600887', '', '2007-08-29', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('39', '600887', '', '2007-04-30', '1000', '0', '0', '2007-07-02', '2007-07-03', '实施', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('40', '600887', '', '2006-08-30', '0', '0', '0', null, null, '董事会通过', '2016-03-25 10:08:47');
INSERT INTO `sic_stocks_fhsg` VALUES ('41', '600887', '', '2006-02-10', '2600', '0', '3', '2006-04-10', '2006-04-11', '实施', '2016-03-25 10:08:47');
