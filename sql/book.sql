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

 Date: 24/12/2022 21:03:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `a` int(0) NOT NULL AUTO_INCREMENT,
  `book_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `book_press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_time` date NULL DEFAULT NULL,
  `book_price` double(10, 0) NULL DEFAULT NULL,
  `book_writer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_detailed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_deimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`a`) USING BTREE,
  INDEX `idb`(`book_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '1001', ' 三体：全三册 刘慈欣代表作，亚洲“雨果奖”获奖作品！', '重庆出版社', '2022-11-17', 46, '刘慈欣', '《三体》第73届世界科幻雨果奖获奖作品，银河奖特别奖，《三体3》轨迹奖长篇科幻小说！2017年世界雨果奖提名作品。', 'http://img3m4.ddimg.cn/32/35/23579654-1_b_6.jpg', 'http://img59.ddimg.cn/99999990138288929.jpg');
INSERT INTO `book` VALUES (2, '1002', ' 哈利波特20周年纪念版 哈利·波特与魔法石Ⅰ（第1卷）', '人民文学出版社', '2022-04-28', 15, 'J.K.罗琳', '我们将七个故事拆分为二十本书， 邀请知名插画家李旻绘制原创封面， 并且再一次从头至尾修订了译文， 这是一套更容易购买、更容易阅读的“哈利·波特”系列图书。', 'http://img3m7.ddimg.cn/40/20/27902497-1_w_3.jpg', 'http://img54.ddimg.cn/99999990427075644.jpg');

SET FOREIGN_KEY_CHECKS = 1;
