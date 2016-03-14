/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : icc

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-03-14 22:41:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sic_stocks_zjlx_hx`
-- ----------------------------
DROP TABLE IF EXISTS `sic_stocks_zjlx_hx`;
CREATE TABLE `sic_stocks_zjlx_hx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `date` date NOT NULL,
  `heJiChengJiao` bigint(20) DEFAULT NULL,
  `jingLiuRu` bigint(20) DEFAULT NULL,
  `jingLiuRuLv` int(11) DEFAULT NULL,
  `chaoDaDanLiuRu` bigint(20) DEFAULT NULL,
  `chaoDaDanLiuRuZhanBi` int(11) DEFAULT NULL,
  `chaoDaDanLiuRuZengZhangLv` int(11) DEFAULT NULL,
  `chaoDaDanLiuChu` bigint(20) DEFAULT NULL,
  `chaoDaDanLiuChuZhanBi` int(11) DEFAULT NULL,
  `chaoDaDanLiuChuZengZhangLv` int(11) DEFAULT NULL,
  `daDanLiuRu` bigint(20) DEFAULT NULL,
  `daDanLiuRuZhanBi` int(11) DEFAULT NULL,
  `daDanLiuRuZengZhangLv` int(11) DEFAULT NULL,
  `daDanLiuChu` bigint(20) DEFAULT NULL,
  `daDanLiuChuZhanBi` int(11) DEFAULT NULL,
  `daDanLiuChuZengZhangLv` int(11) DEFAULT NULL,
  `xiaoDanLiuRu` bigint(20) DEFAULT NULL,
  `xiaoDanLiuRuZhanBi` int(11) DEFAULT NULL,
  `xiaoDanLiuRuZengZhangLv` int(11) DEFAULT NULL,
  `xiaoDanLiuChu` bigint(20) DEFAULT NULL,
  `xiaoDanLiuChuZhanBi` int(11) DEFAULT NULL,
  `xiaoDanLiuChuZengZhangLv` int(11) DEFAULT NULL,
  `sanDanLiuRu` bigint(20) DEFAULT NULL,
  `sanDanLiuRuZhanBi` int(11) DEFAULT NULL,
  `sanDanLiuRuZengZhangLv` int(11) DEFAULT NULL,
  `sanDanLiuChu` bigint(20) DEFAULT NULL,
  `sanDanLiuChuZhanBi` int(11) DEFAULT NULL,
  `sanDanLiuChuZengZhangLv` int(11) DEFAULT NULL,
  `qiTaChengJiaoJinE` bigint(20) DEFAULT NULL,
  `qiTaZhanBi` int(11) DEFAULT NULL,
  `qiTaZengZhanLv` int(11) DEFAULT NULL,
  `createAt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sic_stocks_zjlx_hx
-- ----------------------------
