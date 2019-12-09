/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.0.106
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 192.168.0.106:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 16/10/2019 17:06:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attr_type
-- ----------------------------
DROP TABLE IF EXISTS `attr_type`;
CREATE TABLE `attr_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 主键',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态',
  `update_id` int(11) NOT NULL COMMENT '更新人ID',
  `update_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新人名称',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attr_type
-- ----------------------------
INSERT INTO `attr_type` VALUES (1, 'device', '维修设备名称', 'NEW', 1, '啦啦啦', '2019-10-15 13:35:39');
INSERT INTO `attr_type` VALUES (2, 'major', '专业', 'NEW', 1, '啦啦啦', '2019-10-15 13:37:46');
INSERT INTO `attr_type` VALUES (3, 'maintain', '维护内容', 'NEW', 1, '啦啦啦', '2019-10-15 13:40:06');
INSERT INTO `attr_type` VALUES (4, 'maintain_time', '维护时间类型', 'NEW', 1, '啦啦啦', '2019-10-15 13:40:53');

-- ----------------------------
-- Table structure for attr_value
-- ----------------------------
DROP TABLE IF EXISTS `attr_value`;
CREATE TABLE `attr_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attr_type_id` int(11) NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `sort_id` int(11) NULL DEFAULT NULL,
  `parent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `is_deleted` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_id` int(11) NULL DEFAULT NULL,
  `update_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `audit_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核单号',
  `audit_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核类型',
  `report_id` int(11) NOT NULL DEFAULT 0 COMMENT '报修id',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核单状态',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核意见',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系电话',
  `is_first` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否优先级 1是 0否',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核人id',
  `creator_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核人名称',
  `creator_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核人单位id',
  `creator_org_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核人单位名称',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  `creator_mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核人电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit
-- ----------------------------
INSERT INTO `audit` VALUES (1, '201909299756', '', 3, '', '顺顺利利收视率', '', 1, 1000, '马云', 0, '', '2019-09-29 16:24:37', '13128746923');
INSERT INTO `audit` VALUES (2, '20191010287', 'REPORT', 13, '', '审个锤子', '13128746923', 1, 1, 'admin', 0, '', '2019-10-10 17:31:02', '13128746923');
INSERT INTO `audit` VALUES (4, '20191015966', 'REPORT', 22, '', '审核通过', '13128746926', 1, 5, '王五', 6, '东湖管理处', '2019-10-15 17:39:26', '13128746926');

-- ----------------------------
-- Table structure for audit_org
-- ----------------------------
DROP TABLE IF EXISTS `audit_org`;
CREATE TABLE `audit_org`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `audit_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核单id',
  `org_id` int(11) NOT NULL DEFAULT 0 COMMENT '施工单位id',
  `org_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '施工单位名称',
  `is_arrange` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已安排 1是 0否',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核人id',
  `creator_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '审核人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '审核人时间',
  `creator_org_id` int(11) NOT NULL COMMENT '审核人单位id',
  `creator_org_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '审核人单位名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit_org
-- ----------------------------
INSERT INTO `audit_org` VALUES (1, 2, 1, '阿里巴巴', 1, 1, 'admin', '2019-10-10 17:31:02', 0, '');
INSERT INTO `audit_org` VALUES (2, 4, 10, '济南段维修单位1', 1, 5, '王五', '2019-10-15 17:39:26', 6, '东湖管理处');

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `banner_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `img_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '封面图',
  `sort_type` int(1) NOT NULL COMMENT 'BANNER位置(首页、商品分类、大屏)',
  `data_type` int(1) NOT NULL COMMENT '数据类型(0:商品 1:商户 2:外链)',
  `data_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '数据值',
  `plain_seq` int(8) NOT NULL DEFAULT 0 COMMENT '排列顺序',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除标识(0: 已删除 1:正常)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of banner
-- ----------------------------
INSERT INTO `banner` VALUES (1, '来个柠檬吧！', 'http://static.china-start.cn/banner1.jpg', 1, 0, '1', 3, '2019-07-19 23:24:32', 1);
INSERT INTO `banner` VALUES (2, '彩虹糖', 'http://static.china-start.cn/banner2.jpg', 1, 0, '2', 2, '2019-07-19 23:25:18', 1);
INSERT INTO `banner` VALUES (3, '牛奶来一杯', 'http://static.china-start.cn/banner3.jpg', 1, 0, '3', 1, '2019-07-19 23:26:14', 1);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dept_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `dept_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '维修部', 'repair');
INSERT INTO `dept` VALUES (2, '管理部', 'manage');

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `receive_email` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接收人邮箱(多个逗号分开)',
  `subject` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发送内容',
  `template` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模板',
  `send_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发送时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES (6, '[721680672@qq.com]', '你好', '<!doctype html>\r\n<html lang=\"zh-cmn-Hans\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <meta name=\"renderer\" content=\"webkit\" />\r\n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n    <title>Document</title>\r\n</head>\r\n<body>\r\n    <div class=\"container\"\r\n         style=\" width: 800px;\r\n         height: auto;\r\n         margin: 0 auto;\r\n         border: 1px #dddddd solid;\r\n         border-top: 4px #3498db solid;\r\n         font: 14px Microsoft Yahei;\r\n         color: #333;\">\r\n        <div class=\"main\" style=\"padding: 0 15px;\">\r\n            <div style=\"\r\n                 border: 1px #f39d12 dashed;\r\n                 background-color: #fffdf4;\r\n                 margin: 20px 0;\r\n                 border-radius: 6px;\">\r\n                <table width=\"100%\" style=\"border: none\">\r\n                    <tr>\r\n                        <td style=\"width: 20%; text-align: center; padding-top: 25px\">\r\n                            <img src=\"http://localhost:8080/springboot_mail/image/icon_email_prompt.png\" alt=\"\">\r\n                        </td>\r\n                        <td colspan=\"2\" style=\"font-size: 18px; line-height: 1.6;padding-top: 30px\">\r\n                            <div style=\"text-indent: 36px; padding-right: 24px\">\r\n                                 并不是因为我需要用到什么领域的知识而去学习，而只是单纯的我想知道，我想弄明白。搞明白之后，到底有什么价值，可以创造多少财富，这是我从来不关心的。反而这样，知识给予的回馈是最大的。\r\n                            </div>\r\n                        </td>\r\n                    </tr>\r\n                </table>\r\n            </div>\r\n        </div>\r\n        <div class=\"footer\" style=\"margin: auto;\r\n                            padding: 15px 0 15px 15px;\r\n                            background-color: #fafafa;\r\n                            border-top: 1px #ddd solid;\r\n                            color: #333;\r\n                            height: auto;\r\n                            zoom: 1;\r\n                            overflow: auto;\">\r\n            <table style=\"width: 100%\">\r\n                <tr>\r\n                    <td style=\"width: 60%\">\r\n                        <h4 style=\"font-size: 16px;\r\n                             margin: 10px 0;\">\r\n                          科帮网科技服务有限公司\r\n                        </h4>\r\n                        <p>\r\n                            公司地址：\r\n                            <b>宇宙银河系太阳系地球村88号</b>\r\n                        </p>\r\n                        <p>\r\n                            官方网站：\r\n                            <a href=\"http://www.52itstyle.com\" style=\"text-decoration: none; color: #333; font-weight: bold;\">www.52itstyle.com</a>\r\n                        </p>\r\n                        <p>\r\n                            服务热线：\r\n                            <b>\r\n                                <span style=\"display: inline-block; margin-right: 16px;\">17762018584</span>\r\n                            </b>\r\n                        </p>\r\n                    </td>\r\n                    <td style=\"text-align: right;\">\r\n                        <div style=\" display: inline-block;width: 120px ; padding-top: 10px; padding-right: 200px;\">\r\n                            <img src=\"http://localhost:8080/springboot_mail/image/service.jpg\" alt=\"\" style=\"vertical-align: top\">\r\n                        </div>\r\n                    </td>\r\n                </tr>\r\n            </table>\r\n        </div>\r\n    </div>\r\n</body>\r\n</html> ', 'welcome', '2018-05-03 10:21:32');
INSERT INTO `email` VALUES (7, '[528599514@qq.com]', '密码重置', '437519', '', '2019-10-09 15:35:17');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `repair_id` int(11) NOT NULL DEFAULT 0 COMMENT '维修单id',
  `level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价级别',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价内容',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `creator_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, 1, 'EXCELLENT', '干得不错', 1, 'admin', '2019-10-12 00:29:06');
INSERT INTO `evaluate` VALUES (2, 2, 'EXCELLENT', '完成的不错，小伙子', 4, '李四', '2019-10-15 22:22:17');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) NOT NULL DEFAULT 0 COMMENT '保修单id',
  `repair_id` int(11) NOT NULL DEFAULT 0 COMMENT '维修单id',
  `receipt_id` int(11) NOT NULL DEFAULT 0 COMMENT '派单id',
  `audit_id` int(11) NOT NULL DEFAULT 0 COMMENT '反馈审核id',
  `description` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容描述',
  `workload` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作量/人数',
  `work_hours` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作时长（小时）',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `creator_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `creator_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人单位ID',
  `creator_org_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人单位名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (3, 13, 1, 2, 2, '九死一生', 12, 43, '2019-10-11 22:41:58', 1, 'admin', 0, '');
INSERT INTO `feedback` VALUES (4, 22, 2, 3, 4, '工作量预估错误', 6, 9, '2019-10-15 22:27:47', 4, '李四', 0, '');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文件名称',
  `file_path` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '组名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_role
-- ----------------------------
DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` int(11) NOT NULL DEFAULT 0 COMMENT '组id',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for group_user
-- ----------------------------
DROP TABLE IF EXISTS `group_user`;
CREATE TABLE `group_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` int(11) NOT NULL DEFAULT 0 COMMENT '组id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for maintain
-- ----------------------------
DROP TABLE IF EXISTS `maintain`;
CREATE TABLE `maintain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `maintain_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '编号',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '维修人员id',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维护计划状态',
  `major_id` int(11) NOT NULL COMMENT '专业id',
  `type_id` int(11) NOT NULL COMMENT '维护类型id',
  `time_type_id` int(11) NOT NULL DEFAULT 0 COMMENT '维护时间类型id',
  `start_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `end_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '结束时间',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
  `creator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `creator_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人单位id',
  `creator_org_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人单位名称',
  `update_id` int(11) NOT NULL COMMENT '更新人id',
  `update_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '更新人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain
-- ----------------------------
INSERT INTO `maintain` VALUES (1, '2019101485', 1, 'RELEASED', 1, 1, 1, '2019-10-14 12:05:11', '2019-10-14 12:05:11', '初始化', 'admin', 1, '2019-10-14 12:05:11', 1, '阿里巴巴', 1, 'admin', '2019-10-14 12:08:36');
INSERT INTO `maintain` VALUES (2, '2019101530', 5, 'PEND', 1, 1, 2, '2019-10-15 00:00:00', '2019-10-22 23:59:59', '初始化', '王五', 5, '2019-10-15 22:55:52', 6, '东湖管理处', 5, '王五', '2019-10-15 22:55:52');
INSERT INTO `maintain` VALUES (3, '2019101577', 5, 'PEND', 1, 1, 2, '2019-10-25 00:00:00', '2019-10-30 23:59:59', '初始化', '王五', 5, '2019-10-15 23:43:59', 6, '东湖管理处', 5, '王五', '2019-10-15 23:43:59');
INSERT INTO `maintain` VALUES (4, '2019101571', 5, 'REJECTED', 1, 1, 2, '2019-10-25 00:00:00', '2019-10-30 23:59:59', '你给我滚蛋', '王五', 5, '2019-10-15 23:51:49', 6, '东湖管理处', 5, '王五', '2019-10-16 00:16:07');
INSERT INTO `maintain` VALUES (5, '2019101520', 5, 'RELEASED', 1, 1, 2, '2019-10-25 00:00:00', '2019-10-30 23:59:59', '这个项目我王多鱼投了', '王五', 5, '2019-10-15 23:59:54', 6, '东湖管理处', 5, '王五', '2019-10-16 00:15:46');

-- ----------------------------
-- Table structure for maintain_device
-- ----------------------------
DROP TABLE IF EXISTS `maintain_device`;
CREATE TABLE `maintain_device`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `maintain_id` int(11) NOT NULL DEFAULT 0 COMMENT '维护计划id',
  `device_id` int(11) NOT NULL DEFAULT 0 COMMENT '设备id',
  `device_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain_device
-- ----------------------------
INSERT INTO `maintain_device` VALUES (1, 1, 1, '');
INSERT INTO `maintain_device` VALUES (2, 2, 1, '');
INSERT INTO `maintain_device` VALUES (3, 3, 1, '');
INSERT INTO `maintain_device` VALUES (4, 4, 1, '');
INSERT INTO `maintain_device` VALUES (5, 5, 1, '');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `menu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `menu_url` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单路径',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `creator_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 1 COMMENT '删除标识(0: 已删除 1:正常)',
  `sort` tinyint(3) NOT NULL DEFAULT 1 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '袁隆平共和国勋章', '袁隆平共和国勋章袁隆平共和国勋章袁隆平共和国勋章袁隆平共和国勋章袁隆平共和国勋章', 1000, '唐山大兄', '2019-09-29 13:51:53', 1, 1);
INSERT INTO `notice` VALUES (2, '这是公告的标题', '这个公告的内容', 5, '管理处', '2019-10-16 14:41:52', 1, 1);
INSERT INTO `notice` VALUES (3, '这是公告的标题', '这个公告的内容', 5, '管理处', '2019-10-16 15:49:17', 1, 1);

-- ----------------------------
-- Table structure for operation
-- ----------------------------
DROP TABLE IF EXISTS `operation`;
CREATE TABLE `operation`  (
  `id` int(11) NOT NULL,
  `operation_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `operation_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `ljurlqz` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `id` int(11) NOT NULL,
  `operation_type_id` int(11) NULL DEFAULT NULL,
  `operation_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `operation_user_id` int(11) NULL DEFAULT NULL,
  `operation_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号 主键',
  `org_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '单位名称',
  `priority` int(8) NOT NULL DEFAULT 0 COMMENT '显示顺序',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父编号',
  `parent_ids` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '父编号列表',
  `available` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用 1 是 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES (1, '干线公司', 0, 0, '', 1);
INSERT INTO `org` VALUES (2, '济南局', 1, 1, '1', 1);
INSERT INTO `org` VALUES (3, '枣庄局', 2, 1, '1', 1);
INSERT INTO `org` VALUES (4, '德州局', 3, 1, '1', 1);
INSERT INTO `org` VALUES (5, '济宁局', 4, 1, '1', 1);
INSERT INTO `org` VALUES (6, '东湖管理处', 1, 2, '1,2', 1);
INSERT INTO `org` VALUES (7, '平阴渠道管理处', 2, 3, '1,3', 1);
INSERT INTO `org` VALUES (8, '长清渠道管理处', 3, 4, '1,4', 1);
INSERT INTO `org` VALUES (9, '激动渠道管理处', 4, 5, '1,5', 1);
INSERT INTO `org` VALUES (10, '济南段维修单位1', 1, 6, '1,2,6', 1);
INSERT INTO `org` VALUES (11, '济南段维修单位2', 2, 7, '1,3,7', 1);
INSERT INTO `org` VALUES (12, '济南段维修单位3', 3, 8, '1,4,8', 1);
INSERT INTO `org` VALUES (13, '济南段维修单位4', 4, 9, '1,5,9', 1);

-- ----------------------------
-- Table structure for page_element
-- ----------------------------
DROP TABLE IF EXISTS `page_element`;
CREATE TABLE `page_element`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面',
  `element_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '元素名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `position_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '职位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '机电维修工程师');
INSERT INTO `position` VALUES (2, '维修部主管');
INSERT INTO `position` VALUES (3, '管理处主任');
INSERT INTO `position` VALUES (4, '局长秘书');
INSERT INTO `position` VALUES (5, '负责人');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `power_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '权限类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power_file
-- ----------------------------
DROP TABLE IF EXISTS `power_file`;
CREATE TABLE `power_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `power_id` int(11) NOT NULL DEFAULT 0 COMMENT '权限id',
  `file_id` int(11) NOT NULL DEFAULT 0 COMMENT '文件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power_menu
-- ----------------------------
DROP TABLE IF EXISTS `power_menu`;
CREATE TABLE `power_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `power_id` int(11) NOT NULL DEFAULT 0 COMMENT '权限id',
  `menu_id` int(11) NOT NULL DEFAULT 0 COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power_operation
-- ----------------------------
DROP TABLE IF EXISTS `power_operation`;
CREATE TABLE `power_operation`  (
  `id` int(11) NOT NULL,
  `power_id` int(11) NULL DEFAULT NULL,
  `operation_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for power_page
-- ----------------------------
DROP TABLE IF EXISTS `power_page`;
CREATE TABLE `power_page`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `power_id` int(11) NOT NULL DEFAULT 0 COMMENT '权限id',
  `page_id` int(11) NOT NULL DEFAULT 0 COMMENT '页面id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for receipt
-- ----------------------------
DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) NOT NULL DEFAULT 0 COMMENT '报修单id',
  `audit_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核单id',
  `audit_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '施工单位关联审核单id',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '工作描述 ',
  `workload` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作量/人数',
  `work_time` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作时长（小时）',
  `repair_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '维修人id',
  `repair_user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维修人',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '派单人id',
  `creator_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '派单人姓名',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_id` int(11) NOT NULL DEFAULT 0 COMMENT '更新人id',
  `update_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receipt
-- ----------------------------
INSERT INTO `receipt` VALUES (2, 13, 2, 1, '你大爷的', 3, 8, 1, '马云', 1, 'admin', '2019-10-11 16:31:22', 0, '', '2019-10-11 16:31:51');
INSERT INTO `receipt` VALUES (3, 22, 4, 2, '这是工作描述', 3, 8, 3, '张三', 4, '李四', '2019-10-15 20:14:56', 0, '', '2019-10-15 20:14:56');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) NOT NULL DEFAULT 0 COMMENT '报修单id',
  `receipt_id` int(11) NOT NULL DEFAULT 0 COMMENT '派单id',
  `audit_id` int(11) NOT NULL DEFAULT 0 COMMENT '审核单id',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维修状态',
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维修小结',
  `is_first` tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否优先 1是 0否',
  `repair_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '维修人员id',
  `repair_user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '维修人',
  `repair_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '施工单位id',
  `repair_og_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '施工单位名称',
  `workload` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作量/人数',
  `work_hours` tinyint(3) NOT NULL DEFAULT 0 COMMENT '工作时长',
  `actual_workload` tinyint(3) NOT NULL DEFAULT 0 COMMENT '实际工作量/人数',
  `actual_work_hours` tinyint(3) NOT NULL DEFAULT 0 COMMENT '实际工作时长',
  `creator_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `creator_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_id` int(11) NOT NULL DEFAULT 0 COMMENT '更新人id',
  `update_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (1, 13, 2, 2, 'WAIT', '上海的繁华', 1, 1, '马云', 13, '阿里巴巴', 3, 8, 5, 4, 1, 'admin', '2019-10-11 16:49:56', 1, 'admin', '2019-10-11 22:42:33');
INSERT INTO `repair` VALUES (2, 22, 3, 4, 'COMPLETE', '工作圆满完成', 1, 3, '张三', 10, '济南段维修单位1', 3, 8, 0, 0, 4, '李四', '2019-10-15 20:48:33', 4, '李四', '2019-10-15 21:56:12');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_no` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '故障号',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '状态',
  `province_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '省份编号',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '省份',
  `city_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '城市编号',
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '城市',
  `area_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '区县编号',
  `area` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '区/县',
  `address` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '地点',
  `device_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '设备详情',
  `failure_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '故障描述',
  `img` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '图片描述',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_org` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '报修人机构名称',
  `create_org_id` int(8) NOT NULL DEFAULT 0 COMMENT '报修人机构id',
  `create_id` int(8) NOT NULL DEFAULT 0 COMMENT '报修人id',
  `create_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '报修人',
  `contact_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '联系时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系电话',
  `report_org` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '报送机构',
  `report_org_id` int(11) NOT NULL DEFAULT 0 COMMENT '报送机构id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '报修单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES (13, '2019101010197', '长江长江，我是黄河黄河', 'AUDIT', '', '', '', '', '', '', '广州', '设备描述', '故障描述', '[\"[]\"]', '审个锤子', '阿里巴巴', 1, 1, 'admin', '2019-10-10 16:33:49', '2019-10-10 00:00:01', '13128746923', '阿里巴巴', 1);
INSERT INTO `report` VALUES (14, '201910158301', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:01', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (15, '2019101510694', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:01', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (16, '201910157040', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:01', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (17, '201910154820', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位1', 10, 4, '李四', '2019-10-15 00:00:00', '2019-10-15 00:00:00', '13128746925', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (18, '201910155422', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:00', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (19, '201910151927', '这是标题', 'PEND', '', '湖北省', '', '武汉市', '', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:00', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (20, '2019101510683', '这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是地址', '这是设备想去', '故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:01', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (21, '201910158028', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 00:00:00', '13128746924', '济南段维修单位2', 11);
INSERT INTO `report` VALUES (22, '2019101510609', '广告公司这是标题', 'AUDIT', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '审核通过', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:26:24', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (23, '201910153526', '广告公司这是标题', 'IGNORE', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '小问题，请忽略', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:31', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (24, '201910153993', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:33', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (25, '201910152058', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:35', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (26, '201910156177', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:37', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (27, '201910152585', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:38', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (28, '201910159708', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:40', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (29, '2019101510920', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:42', '13128746924', '济南段维修单位1', 10);
INSERT INTO `report` VALUES (30, '201910152533', '广告公司这是标题', 'PEND', '1', '湖北省', '2', '武汉市', '3', '洪山区', '这是是是是地址', '这是设备详情', '这是故障描述', '[\"[\\\"\\\"]\"]', '', '济南段维修单位2', 11, 3, '张三', '2019-10-15 00:00:00', '2019-10-15 17:41:44', '13128746924', '济南段维修单位1', 10);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色描述',
  `resource_ids` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '授权的资源',
  `available` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用 1是 0否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '维修人员', '', '', 1);
INSERT INTO `role` VALUES (2, '维修公司', '', '', 1);
INSERT INTO `role` VALUES (3, '管理处', '', '', 1);
INSERT INTO `role` VALUES (4, '管理局', '', '', 1);
INSERT INTO `role` VALUES (5, '干线公司', '', '', 1);

-- ----------------------------
-- Table structure for role_power
-- ----------------------------
DROP TABLE IF EXISTS `role_power`;
CREATE TABLE `role_power`  (
  `id` int(11) NOT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `power_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `pwd` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
  `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '编号',
  `national_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '国家编号',
  `salt` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '123456' COMMENT '密码颜值',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '电话号码',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别 男male  女female',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '头像',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  `last_login_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后一次登录时间',
  `delete_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标识(0: 已删除/禁用 1:正常)',
  `locked` tinyint(1) NOT NULL DEFAULT 1 COMMENT '账户是否锁定 1正常 0锁定',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员', 'ea48576f30be1669971699c09ad05c94', 'admin', 'CN', '123456', '', '13128746921', 'female', '528599514@qq.com', 'http://', '第一次登陆', '2019-10-14 10:58:35', '2019-10-14 10:58:35', '2019-10-12 09:22:13', 1, 1);
INSERT INTO `user` VALUES (2, '小吴哥', 'ea48576f30be1669971699c09ad05c94', 'xiaowuge', 'CN', '123456', '', '13871434586', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-15 21:56:08', '2019-10-15 21:56:08', '2019-10-15 21:56:09', 1, 1);
INSERT INTO `user` VALUES (3, '维修人员', 'ea48576f30be1669971699c09ad05c94', 'wxry', 'CN', '123456', '', '13128746924', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-16 09:26:13', '2019-10-16 09:26:13', '2019-10-14 11:37:57', 1, 1);
INSERT INTO `user` VALUES (4, '维修公司', 'ea48576f30be1669971699c09ad05c94', 'wxgs', 'CN', '123456', '', '13128746925', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-16 09:26:18', '2019-10-16 09:26:18', '2019-10-14 11:38:03', 1, 1);
INSERT INTO `user` VALUES (5, '管理处', 'ea48576f30be1669971699c09ad05c94', 'glc', 'CN', '123456', '', '13128746926', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-16 09:26:23', '2019-10-16 09:26:23', '2019-10-14 11:38:10', 1, 1);
INSERT INTO `user` VALUES (6, '管理局', 'ea48576f30be1669971699c09ad05c94', 'glj', 'CN', '123456', '', '13128746927', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-16 09:26:26', '2019-10-16 09:26:26', '2019-10-14 11:38:14', 1, 1);
INSERT INTO `user` VALUES (7, '干线公司', 'ea48576f30be1669971699c09ad05c94', 'gxgs', 'CN', '123456', '', '13128746928', 'male', '528441592@qq.com', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL81dwvXKH1vhFoxeia422twKSRocLuGdZ1bRQcTsTnveS0So8RfXTVxHp5ggfRlcTIvejMcTUnpnw/132', '初始化', '2019-10-16 09:26:32', '2019-10-16 09:26:32', '2019-10-14 11:38:22', 1, 1);

-- ----------------------------
-- Table structure for user_dept
-- ----------------------------
DROP TABLE IF EXISTS `user_dept`;
CREATE TABLE `user_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `dept_id` int(11) NOT NULL DEFAULT 0 COMMENT '部门id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_dept
-- ----------------------------
INSERT INTO `user_dept` VALUES (1, 1, 1);
INSERT INTO `user_dept` VALUES (2, 2, 1);
INSERT INTO `user_dept` VALUES (3, 3, 1);
INSERT INTO `user_dept` VALUES (4, 4, 2);
INSERT INTO `user_dept` VALUES (5, 5, 2);
INSERT INTO `user_dept` VALUES (6, 6, 2);
INSERT INTO `user_dept` VALUES (7, 7, 2);

-- ----------------------------
-- Table structure for user_org
-- ----------------------------
DROP TABLE IF EXISTS `user_org`;
CREATE TABLE `user_org`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `org_id` int(11) NOT NULL DEFAULT 0 COMMENT '机构id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_org
-- ----------------------------
INSERT INTO `user_org` VALUES (1, 1, 1);
INSERT INTO `user_org` VALUES (2, 2, 2);
INSERT INTO `user_org` VALUES (3, 3, 11);
INSERT INTO `user_org` VALUES (4, 4, 10);
INSERT INTO `user_org` VALUES (5, 5, 6);
INSERT INTO `user_org` VALUES (6, 6, 2);
INSERT INTO `user_org` VALUES (7, 7, 1);

-- ----------------------------
-- Table structure for user_position
-- ----------------------------
DROP TABLE IF EXISTS `user_position`;
CREATE TABLE `user_position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `position_id` int(11) NOT NULL DEFAULT 0 COMMENT '职位id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_position
-- ----------------------------
INSERT INTO `user_position` VALUES (1, 1, 1);
INSERT INTO `user_position` VALUES (2, 2, 1);
INSERT INTO `user_position` VALUES (3, 3, 1);
INSERT INTO `user_position` VALUES (4, 4, 2);
INSERT INTO `user_position` VALUES (5, 5, 3);
INSERT INTO `user_position` VALUES (6, 6, 4);
INSERT INTO `user_position` VALUES (7, 7, 5);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `role_id` int(11) NOT NULL DEFAULT 0 COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 2, 1);
INSERT INTO `user_role` VALUES (3, 3, 1);
INSERT INTO `user_role` VALUES (4, 4, 2);
INSERT INTO `user_role` VALUES (5, 5, 3);
INSERT INTO `user_role` VALUES (6, 6, 4);
INSERT INTO `user_role` VALUES (7, 7, 5);

SET FOREIGN_KEY_CHECKS = 1;
