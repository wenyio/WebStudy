/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 127.0.0.1:3306
 Source Schema         : bookdb

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 27/05/2021 16:04:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `isMember` tinyint(2) NULL DEFAULT NULL,
  `clazz` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, 't1text', '444', '计算机科学与技术', '男', '家庭住址111', '2021-04-25', 1, '计科');
INSERT INTO `student` VALUES (4, 'admin', '123', '计算机科学与技术', '男', '家庭住址', '2021-04-25', 1, '计科');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `errCount` int(11) NULL DEFAULT NULL,
  `lockTime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user01', '123', 0, '2021-05-12 19:55:53');
INSERT INTO `user` VALUES (2, 'user02', '456', 0, '2021-04-25 00:00:00');
INSERT INTO `user` VALUES (3, 'user03', '789', 0, '2021-04-25 00:00:00');
INSERT INTO `user` VALUES (4, 'user04', '111', 0, '2021-04-25 00:00:00');
INSERT INTO `user` VALUES (5, 'user05', '123', 2, NULL);
INSERT INTO `user` VALUES (6, 'user06', '123', 0, NULL);
INSERT INTO `user` VALUES (7, 'user08', '123', 0, '2021-05-12 17:01:36');
INSERT INTO `user` VALUES (8, 'sa', '123', 0, '2021-05-12 19:50:40');
INSERT INTO `user` VALUES (9, 'zzh', '123456', 0, '2021-05-12 19:55:08');

-- ----------------------------
-- Procedure structure for getByNumberProc
-- ----------------------------
DROP PROCEDURE IF EXISTS `getByNumberProc`;
delimiter ;;
CREATE PROCEDURE `getByNumberProc`(IN `p_number` varchar(255))
BEGIN 
	IF p_number = '' or p_number is null	THEN
		select * from student;
	ELSE
		select * from student where `number` = p_number; 
	END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
