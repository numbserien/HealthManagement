/*
 Navicat Premium Data Transfer

 Source Server         : 健康管理系统
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3306
 Source Schema         : Motion management system

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 24/02/2024 12:30:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Campus
-- ----------------------------
DROP TABLE IF EXISTS `Campus`;
CREATE TABLE `Campus`  (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `c_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `c_level` int NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Campus
-- ----------------------------

-- ----------------------------
-- Table structure for CampusMembership
-- ----------------------------
DROP TABLE IF EXISTS `CampusMembership`;
CREATE TABLE `CampusMembership`  (
  `cm_id` int NOT NULL AUTO_INCREMENT,
  `cm_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `cm_role` int NULL DEFAULT NULL,
  `cm_birthday` date NULL DEFAULT NULL,
  `cm_m_id` int NULL DEFAULT NULL,
  `cm_s_id` int NULL DEFAULT NULL,
  `cm_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of CampusMembership
-- ----------------------------

-- ----------------------------
-- Table structure for ChatContent
-- ----------------------------
DROP TABLE IF EXISTS `ChatContent`;
CREATE TABLE `ChatContent`  (
  `cc_id` int NOT NULL AUTO_INCREMENT,
  `cc_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `cc_u_id` int NULL DEFAULT NULL,
  `cc_cr_id` int NULL DEFAULT NULL,
  `cc_time` datetime NULL DEFAULT NULL,
  `cc_reply_id` int NULL DEFAULT NULL,
  `cc_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`cc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ChatContent
-- ----------------------------

-- ----------------------------
-- Table structure for ChatRoom
-- ----------------------------
DROP TABLE IF EXISTS `ChatRoom`;
CREATE TABLE `ChatRoom`  (
  `cr_id` int NOT NULL AUTO_INCREMENT,
  `cr_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `cr_level` int NULL DEFAULT NULL,
  `cr_create_time` datetime NULL DEFAULT NULL,
  `cr_u_id` int NULL DEFAULT NULL,
  `cr_is_password` int NULL DEFAULT NULL,
  `cr_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `cr_online` int NULL DEFAULT NULL,
  `cr_limit` int NULL DEFAULT NULL,
  `cr_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`cr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ChatRoom
-- ----------------------------

-- ----------------------------
-- Table structure for ChatTeam
-- ----------------------------
DROP TABLE IF EXISTS `ChatTeam`;
CREATE TABLE `ChatTeam`  (
  `ct_cr_id` int NOT NULL,
  `ct_u_id` int NOT NULL,
  `ct_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`ct_cr_id`, `ct_u_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ChatTeam
-- ----------------------------

-- ----------------------------
-- Table structure for CompletionDay
-- ----------------------------
DROP TABLE IF EXISTS `CompletionDay`;
CREATE TABLE `CompletionDay`  (
  `cd_is_place` int NULL DEFAULT NULL,
  `cd_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `cd_occasion` int NULL DEFAULT NULL,
  `cd_is_finish` int NULL DEFAULT NULL,
  `cd_start_time` time NULL DEFAULT NULL,
  `cd_end_time` time NULL DEFAULT NULL,
  `cd_t_id` int NULL DEFAULT NULL,
  `cd_day` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of CompletionDay
-- ----------------------------

-- ----------------------------
-- Table structure for DayPlan
-- ----------------------------
DROP TABLE IF EXISTS `DayPlan`;
CREATE TABLE `DayPlan`  (
  `dp_pi_id` int NOT NULL,
  `dp_pc_id` int NOT NULL,
  `dp_duration` time NULL DEFAULT NULL,
  `dp_start` time NULL DEFAULT NULL,
  `dp_deadline` time NULL DEFAULT NULL,
  PRIMARY KEY (`dp_pi_id`, `dp_pc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of DayPlan
-- ----------------------------

-- ----------------------------
-- Table structure for Fans
-- ----------------------------
DROP TABLE IF EXISTS `Fans`;
CREATE TABLE `Fans`  (
  `f_fan_id` int NOT NULL,
  `f_up_id` int NOT NULL,
  `f_cr_id` int NULL DEFAULT NULL,
  `f_time` datetime NULL DEFAULT NULL,
  `f_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`f_fan_id`, `f_up_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Fans
-- ----------------------------

-- ----------------------------
-- Table structure for Game
-- ----------------------------
DROP TABLE IF EXISTS `Game`;
CREATE TABLE `Game`  (
  `g_id` int NOT NULL AUTO_INCREMENT,
  `g_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `g_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `g_organizer_id` int NULL DEFAULT NULL,
  `g_face_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `g_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `g_type` int NULL DEFAULT NULL,
  `g_level` int NULL DEFAULT NULL,
  `g_start_time` datetime NULL DEFAULT NULL,
  `g_end_time` datetime NULL DEFAULT NULL,
  `g_limit_people` int NULL DEFAULT NULL,
  `g_fee` int NULL DEFAULT NULL,
  `g_all_fee` int NULL DEFAULT NULL,
  `g_is_chat` int NULL DEFAULT NULL,
  `g_cr_id` int NULL DEFAULT NULL,
  `g_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`g_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Game
-- ----------------------------

-- ----------------------------
-- Table structure for GamePlayer
-- ----------------------------
DROP TABLE IF EXISTS `GamePlayer`;
CREATE TABLE `GamePlayer`  (
  `gp_id` int NOT NULL AUTO_INCREMENT,
  `gp_u_id` int NULL DEFAULT NULL,
  `gp_g_id` int NULL DEFAULT NULL,
  `gp_role` int NULL DEFAULT NULL,
  `gp_role_tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `gp_judgment_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`gp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GamePlayer
-- ----------------------------

-- ----------------------------
-- Table structure for GameResult
-- ----------------------------
DROP TABLE IF EXISTS `GameResult`;
CREATE TABLE `GameResult`  (
  `gr_id` int NOT NULL AUTO_INCREMENT,
  `gr_time` datetime NULL DEFAULT NULL,
  `gr_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `gr_g_id` int NULL DEFAULT NULL,
  `gr_recorder_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`gr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of GameResult
-- ----------------------------

-- ----------------------------
-- Table structure for Major
-- ----------------------------
DROP TABLE IF EXISTS `Major`;
CREATE TABLE `Major`  (
  `m_id` int NOT NULL AUTO_INCREMENT,
  `m_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `m_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `m_m_id` int NULL DEFAULT NULL,
  `m_c_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Major
-- ----------------------------

-- ----------------------------
-- Table structure for Permissions
-- ----------------------------
DROP TABLE IF EXISTS `Permissions`;
CREATE TABLE `Permissions`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '权限名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '权限标识',
  `type` tinyint(1) NULL DEFAULT NULL COMMENT '类型 0-目录；1-菜单；2-按钮',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '状态: 0-有效；1-删除',
  `createtime` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Permissions
-- ----------------------------
INSERT INTO `Permissions` VALUES (1, '测试权限', '测试', '/utils/test', NULL, NULL, '1', '2024-02-16 00:14:52', '2024-02-16 00:14:55');

-- ----------------------------
-- Table structure for PersonalPlan
-- ----------------------------
DROP TABLE IF EXISTS `PersonalPlan`;
CREATE TABLE `PersonalPlan`  (
  `pp_id` int NOT NULL AUTO_INCREMENT,
  `pp_u_id` int NULL DEFAULT NULL,
  `pp_tp_id` int NULL DEFAULT NULL,
  `pp_is_collection` int NULL DEFAULT NULL,
  `pp_times` int NULL DEFAULT NULL,
  `pp_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`pp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PersonalPlan
-- ----------------------------

-- ----------------------------
-- Table structure for PlanContent
-- ----------------------------
DROP TABLE IF EXISTS `PlanContent`;
CREATE TABLE `PlanContent`  (
  `pc_id` int NOT NULL AUTO_INCREMENT,
  `pc_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `pc_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `pc_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `pc_u_id` int NULL DEFAULT NULL,
  `pc_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  PRIMARY KEY (`pc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PlanContent
-- ----------------------------

-- ----------------------------
-- Table structure for PlanItem
-- ----------------------------
DROP TABLE IF EXISTS `PlanItem`;
CREATE TABLE `PlanItem`  (
  `pi_id` int NOT NULL AUTO_INCREMENT,
  `pi_order` int NULL DEFAULT NULL,
  `pi_tp_id` int NULL DEFAULT NULL,
  `pi_combo_day` int NULL DEFAULT NULL,
  PRIMARY KEY (`pi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PlanItem
-- ----------------------------

-- ----------------------------
-- Table structure for Roles
-- ----------------------------
DROP TABLE IF EXISTS `Roles`;
CREATE TABLE `Roles`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '角色名',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '角色描述',
  `available` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '角色是否被锁定',
  `createtime` datetime NULL DEFAULT NULL COMMENT '角色创建时间',
  `updatetime` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Roles
-- ----------------------------
INSERT INTO `Roles` VALUES (1, '权限管理者', '管理权限分配的角色', '1', '2024-02-16 00:10:01', '2024-02-16 00:10:03');

-- ----------------------------
-- Table structure for RolesPermissions
-- ----------------------------
DROP TABLE IF EXISTS `RolesPermissions`;
CREATE TABLE `RolesPermissions`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `roleId` int NULL DEFAULT NULL,
  `permissionId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of RolesPermissions
-- ----------------------------
INSERT INTO `RolesPermissions` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for ScoreLog
-- ----------------------------
DROP TABLE IF EXISTS `ScoreLog`;
CREATE TABLE `ScoreLog`  (
  `sl_id` int NOT NULL AUTO_INCREMENT,
  `sl_time` datetime NULL DEFAULT NULL,
  `sl_u_id` int NULL DEFAULT NULL,
  `sl_old_scores` int NULL DEFAULT NULL,
  `sl_change_scores` int NULL DEFAULT NULL,
  `sl_new_scores` int NULL DEFAULT NULL,
  `sl_score_event` int NULL DEFAULT NULL,
  `sl_change_type` int NULL DEFAULT NULL,
  PRIMARY KEY (`sl_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ScoreLog
-- ----------------------------

-- ----------------------------
-- Table structure for Stadium
-- ----------------------------
DROP TABLE IF EXISTS `Stadium`;
CREATE TABLE `Stadium`  (
  `s_id` int NULL DEFAULT NULL,
  `s_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `s_site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `s_type` int NULL DEFAULT NULL,
  `s_status` int NULL DEFAULT NULL,
  `s_u_id` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Stadium
-- ----------------------------

-- ----------------------------
-- Table structure for Task
-- ----------------------------
DROP TABLE IF EXISTS `Task`;
CREATE TABLE `Task`  (
  `t_id` int NOT NULL AUTO_INCREMENT,
  `t_pp_id` int NULL DEFAULT NULL,
  `t_start_day` date NULL DEFAULT NULL,
  `t_deadline` date NULL DEFAULT NULL,
  `t_u_id` int NULL DEFAULT NULL,
  `t_combo_day` int NULL DEFAULT NULL,
  `t_next_job` int NULL DEFAULT NULL,
  `t_is_public` int NULL DEFAULT NULL,
  `t_status` int NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Task
-- ----------------------------

-- ----------------------------
-- Table structure for TrainingPlan
-- ----------------------------
DROP TABLE IF EXISTS `TrainingPlan`;
CREATE TABLE `TrainingPlan`  (
  `tp_id` int NOT NULL AUTO_INCREMENT,
  `tp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL,
  `tp_days` int NULL DEFAULT NULL,
  `tp_u_id` int NULL DEFAULT NULL,
  `tp_create_time` datetime NULL DEFAULT NULL,
  `tp_type` int NULL DEFAULT NULL,
  `tp_completeness` int NULL DEFAULT NULL,
  `tp_likes` int NULL DEFAULT NULL,
  `tp_status` int NULL DEFAULT NULL,
  `tp_score` int NULL DEFAULT NULL,
  PRIMARY KEY (`tp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of TrainingPlan
-- ----------------------------

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` char(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '密码-MD5加密',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `head_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '头像',
  `score` int NULL DEFAULT NULL COMMENT '得分',
  `u_cm_id` int NULL DEFAULT NULL COMMENT '绑定学校id',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '账号状态: 1-正常；0-停用',
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `c_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES (2, 'zq', '$2a$10$wsomDQDcszsKUgKjiS9fsOz/UG49V/ts5PyeWzhHkqlsZvDysKxaa', NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for UserRoles
-- ----------------------------
DROP TABLE IF EXISTS `UserRoles`;
CREATE TABLE `UserRoles`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NULL DEFAULT NULL,
  `roleId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of UserRoles
-- ----------------------------
INSERT INTO `UserRoles` VALUES (1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
