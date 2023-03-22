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

 Date: 24/12/2022 21:03:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_ctime` datetime(0) NULL DEFAULT NULL,
  `user_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '1001', 'wx800000', '非常重磅的一套书，孩子、大人都喜欢。', '2022-12-30 17:24:53', '10');
INSERT INTO `comment` VALUES (2, '1001', 'wx751360', '包装再结实点就好了', '2022-12-12 17:25:19', '10');
INSERT INTO `comment` VALUES (3, '1002', 'wx755035', '很不错的书籍', '2022-11-16 17:25:47', '10');
INSERT INTO `comment` VALUES (4, '1002', 'wx854136', '自己比孩子更喜欢', '2022-09-22 17:25:53', '10');
INSERT INTO `comment` VALUES (5, '1002', 'wx7813541', '给孩子买的哈利波特，比原来的版好携带，孩子非常喜欢', '2022-12-20 17:26:18', '10');

SET FOREIGN_KEY_CHECKS = 1;
