/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50149
Source Host           : localhost:3306
Source Database       : lifetime

Target Server Type    : MYSQL
Target Server Version : 50149
File Encoding         : 65001

Date: 2016-10-25 13:36:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for axis
-- ----------------------------
DROP TABLE IF EXISTS `axis`;
CREATE TABLE `axis` (
  `axis_id` int(9) NOT NULL AUTO_INCREMENT,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `from_user_name` varchar(255) DEFAULT NULL,
  `label` varchar(4000) DEFAULT NULL,
  `lontitude` decimal(10,7) DEFAULT NULL,
  `latitude` decimal(10,7) DEFAULT NULL,
  `scale` int(3) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`axis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for event
-- ----------------------------
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `event_id` int(9) NOT NULL AUTO_INCREMENT,
  `axis_id` int(9) NOT NULL,
  `text` varchar(4000) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `axis_event` (`axis_id`),
  CONSTRAINT `axis_event` FOREIGN KEY (`axis_id`) REFERENCES `axis` (`axis_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(9) NOT NULL AUTO_INCREMENT,
  `axis_id` int(9) NOT NULL,
  `name` varchar(4000) DEFAULT NULL COMMENT '照片名',
  `description` varchar(4000) DEFAULT NULL COMMENT '照片描述',
  `path` varchar(4000) DEFAULT NULL COMMENT '存放路径',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`image_id`),
  KEY `axis_photo` (`axis_id`) USING BTREE,
  CONSTRAINT `axis_image` FOREIGN KEY (`axis_id`) REFERENCES `axis` (`axis_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `from_user_name` varchar(255) NOT NULL,
  `subscribe_time` timestamp NULL DEFAULT NULL,
  `unsubscribe_time` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
