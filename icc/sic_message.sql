/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50618
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2016-03-22 16:58:17
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
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_message
-- ----------------------------
INSERT INTO `sic_message` VALUES ('1', null, null, null, null, '18825187648', null, 'test', '2016-03-22', '0', '发送成功: 消息编号<31766497868304400> 总数<1> 余额<3006>');
