/*
 Navicat Premium Data Transfer

 Source Server         : bookstore
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 24/12/2022 21:03:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cartble
-- ----------------------------
DROP TABLE IF EXISTS `cartble`;
CREATE TABLE `cartble`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT,
  `checkok` varchar(22) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `imgURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品信息',
  `price` float(255, 2) NULL DEFAULT NULL COMMENT '单价',
  `count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数量',
  `total` float(255, 2) NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cartble
-- ----------------------------
INSERT INTO `cartble` VALUES (1, '1', 'http://img3m4.ddimg.cn/32/35/23579654-1_b_6.jpg', ' 三体：全三册 刘慈欣代表作，亚洲“雨果奖”获奖作品！', 46.00, '3', 92.00);

SET FOREIGN_KEY_CHECKS = 1;
