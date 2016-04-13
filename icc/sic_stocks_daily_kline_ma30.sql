/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-04-13 23:23:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks_daily_kline_ma30`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_daily_kline_ma30`;
CREATE TABLE `sic_stocks_daily_kline_ma30` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(16) NOT NULL,
  `name` varchar(32) NOT NULL,
  `date` date NOT NULL,
  `shouPan` int(11) NOT NULL,
  `junJia` int(11) DEFAULT NULL,
  `zhangFu` int(11) DEFAULT NULL,
  `zhangDie` int(11) DEFAULT NULL,
  `chengJiaoLiang` bigint(20) DEFAULT NULL,
  `ChengJiaoE` bigint(20) DEFAULT NULL,
  `huanShou` int(11) DEFAULT NULL,
  `liangBi` int(11) DEFAULT NULL,
  `zuiGao` int(11) DEFAULT NULL,
  `zuiDi` int(11) DEFAULT NULL,
  `zhenFu` int(11) DEFAULT NULL,
  `waiPan` int(11) DEFAULT NULL,
  `neiPan` int(11) DEFAULT NULL,
  `panCha` int(11) DEFAULT NULL,
  `panBi` int(11) DEFAULT NULL,
  `weiBi` int(11) DEFAULT NULL,
  `weiCha` int(11) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_daily_kline_ma30
-- ----------------------------
