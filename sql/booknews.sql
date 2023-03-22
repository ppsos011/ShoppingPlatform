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

 Date: 24/12/2022 21:03:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for booknews
-- ----------------------------
DROP TABLE IF EXISTS `booknews`;
CREATE TABLE `booknews`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '图书id',
  `imgUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '封面地址',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原价',
  `discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '折扣价',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booknews
-- ----------------------------
INSERT INTO `booknews` VALUES (1001, 'http://img3m4.ddimg.cn/32/35/23579654-1_b_6.jpg', ' 三体：全三册 刘慈欣代表作，亚洲“雨果奖”获奖作品！', NULL, '￥46.00', '刘慈欣');
INSERT INTO `booknews` VALUES (1002, 'http://img3m7.ddimg.cn/40/20/27902497-1_w_3.jpg', ' 哈利波特20周年纪念版 哈利·波特与魔法石Ⅰ（第1卷）', '￥45.00', '￥15.00', 'J.K.罗琳');
INSERT INTO `booknews` VALUES (1003, '//img3m9.ddimg.cn/97/9/29483089-1_l_26.jpg', '春光好', '￥59.80', '￥58.60', '黄佟佟');
INSERT INTO `booknews` VALUES (1004, '//img3m8.ddimg.cn/85/35/29476048-1_l_14.jpg', '中国味道：刻在胃里的思念', '￥59.80', '￥29.80', '丘濂、黑麦等');
INSERT INTO `booknews` VALUES (1005, '//img3m9.ddimg.cn/84/2/29473869-1_l_19.jpg', 'bibi动物园：等你好久啦（当当专享超萌签章版+番外漫画集+精美贴纸，“治愈系天花板”随手一翻，嘴角一弯！）', '￥49.00', '￥35.20', 'bibi园长  著 ， 新经典  出品');
INSERT INTO `booknews` VALUES (1006, '//img3m3.ddimg.cn/91/10/29474173-1_l_9.jpg', '《真希望你也喜欢自己》', '￥49.80', '￥37.30', '房琪kiki');
INSERT INTO `booknews` VALUES (1007, '//img3m4.ddimg.cn/36/2/1901240784-1_l_4.jpg', '不得往生(赵丽颖、欧豪主演电视剧《风吹半夏》原著小说,电视剧定档11.27!)', '￥19.99', '￥19.99', '阿耐');
INSERT INTO `booknews` VALUES (1008, '//img3m5.ddimg.cn/45/8/29487195-1_l_7.jpg', '世界杯来了！（全2册 这就是足球+奇迹体育场）', '¥116.00', '￥98.00', '颜强 张健 等著 杜仁杰 王万丛 绘');
INSERT INTO `booknews` VALUES (1009, '//img3m5.ddimg.cn/88/31/29477635-1_l_17.jpg', '日本古典女性日记', '¥228.00', '¥114.00', '[日] 紫式部/菅原孝标');
INSERT INTO `booknews` VALUES (1010, '//img3m6.ddimg.cn/80/33/29491586-1_l_5.jpg', '正义回响', '¥49.80', '¥34.00', '陈碧，果麦文化 出');
INSERT INTO `booknews` VALUES (1011, '//img3m8.ddimg.cn/18/1/29493108-1_l_4.jpg', '画给儿童的分类成语', '¥360.00', '¥176.40', '百鹤文化/编著 刘鹤');
INSERT INTO `booknews` VALUES (1012, '//img3m2.ddimg.cn/11/33/29490032-1_l_10.jpg', '小王子（图像小说）', '¥79.00\r\n\r\n', '¥49.00', '[法] 安托万·德·圣埃');
INSERT INTO `booknews` VALUES (1013, '//img3m4.ddimg.cn/88/30/1901314294-1_l_1.jpg', '回家', '', '¥41.86', '孙悦');

SET FOREIGN_KEY_CHECKS = 1;
