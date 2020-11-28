/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50155
 Source Host           : localhost:3306
 Source Schema         : weibo

 Target Server Type    : MySQL
 Target Server Version : 50155
 File Encoding         : 65001

 Date: 28/11/2020 14:42:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hot_comments
-- ----------------------------
DROP TABLE IF EXISTS `hot_comments`;
CREATE TABLE `hot_comments`  (
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论的内容',
  `commentator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人',
  `comment_time` datetime NULL DEFAULT NULL COMMENT '评论的时间',
  `is_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效',
  `hot_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热点编号',
  `comments_id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '物理主键',
  PRIMARY KEY (`comments_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hot_comments
-- ----------------------------
INSERT INTO `hot_comments` VALUES ('第四次发表', 'admin', '2020-11-28 12:52:29', '1', '473c7105-5ba8-4a34-a78f-94aa22f56d94', '227e7cf3-abb4-4a0d-b732-60ebe11a84aa');
INSERT INTO `hot_comments` VALUES ('第三次发表', NULL, '2020-11-28 12:47:14', '1', '473c7105-5ba8-4a34-a78f-94aa22f56d94', '2e31c366-cd38-40f1-a2c9-a1d954755ad9');
INSERT INTO `hot_comments` VALUES ('第二次发表', NULL, '2020-11-28 12:45:13', '1', '473c7105-5ba8-4a34-a78f-94aa22f56d94', '7950fc4f-ce08-48ee-8358-cbfe9927f6a8');
INSERT INTO `hot_comments` VALUES ('第一次发表', NULL, '2020-11-28 12:42:26', '1', '473c7105-5ba8-4a34-a78f-94aa22f56d94', 'a719ab2f-4ca3-4027-a643-42938eb7c0cd');

-- ----------------------------
-- Table structure for hot_content
-- ----------------------------
DROP TABLE IF EXISTS `hot_content`;
CREATE TABLE `hot_content`  (
  `id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键ID',
  `hot_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热搜链接',
  `hot_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热搜内容',
  `hot_tital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热手标题',
  `is_flag` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否有效',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `is_admin` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是管理员权限',
  `comments_id` int(4) NULL DEFAULT NULL COMMENT '评论的id',
  `user_id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人id',
  `label_id` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hot_content
-- ----------------------------
INSERT INTO `hot_content` VALUES ('95b228ea-3eba-4cab-b0ff-025d028f7ca4', '473c7105-5ba8-4a34-a78f-94aa22f56d94', '阿三大苏打', '好好学习天天向上', '1', '2020-11-27 21:39:43', NULL, NULL, NULL, 'admin', '045eb085-7019-45a4-8f00-29d257b486a0');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `labelname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建账号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('045eb085-7019-45a4-8f00-29d257b486a0', '123', '2020-11-27 17:15:35', 'admin');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `noticeContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `noticeDate` datetime NULL DEFAULT NULL COMMENT '公告时间',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告人',
  `is_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '1', '2020-11-27 19:51:23', 'admin', '1');
INSERT INTO `notice` VALUES ('70af6aba-b397-48b3-9312-4b948ee3320f', '第二次发公告', '2020-11-27 20:36:27', 'admin', '1');
INSERT INTO `notice` VALUES ('a9e5092a-a4ad-4d91-b4f7-23de67141fd7', '第一次发公告', '2020-11-27 20:35:39', 'admin', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL COMMENT '主键id',
  `loginname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `createdate` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `updatedate` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `permissions` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '1111', '2020-11-26 10:45:49', '1', 1, '2020-11-27 11:50:16', '1');
INSERT INTO `user` VALUES (2, 'user1', '普通用户1', '1111', '2020-11-26 10:45:49', '1', 1, '2020-11-27 11:50:16', '0');
INSERT INTO `user` VALUES (3, 'user2', '普通用户2', '1111', '2020-11-26 10:45:49', '1', 1, '2020-11-27 11:50:16', '0');

SET FOREIGN_KEY_CHECKS = 1;
