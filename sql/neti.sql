/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : neti

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 29/07/2019 17:27:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_acl
-- ----------------------------
DROP TABLE IF EXISTS `t_acl`;
CREATE TABLE `t_acl`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `code` int(11) NULL DEFAULT NULL COMMENT '权限码',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限名称',
  `acl_module_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '权限所在的权限模块id',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求的url, 可以填正则表达式',
  `type` int(11) NOT NULL DEFAULT 3 COMMENT '类型，1：菜单，2：按钮，3：其他',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：正常，0：冻结',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '权限在当前模块下的顺序，由小到大',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acl_data
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_data`;
CREATE TABLE `t_acl_data`  (
  `id` bigint(20) NOT NULL,
  `acl_id` bigint(20) NOT NULL COMMENT '对应权限表主键',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态，1：可用，0：不可用',
  `param` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数',
  `operation` int(11) NOT NULL DEFAULT 0 COMMENT '操作类型，0；等于，1：大于，2：小于，3：大于等于，4：小于等于，5：包含，6：介于之间，。。。',
  `value1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `value2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `next_param_op` int(11) NOT NULL DEFAULT 0 COMMENT '后续有参数时连接的关系，0:没有其他参数控制，1：与&&，2：或||',
  `sort` tinyint(4) NOT NULL DEFAULT 0 COMMENT '顺序',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_acl_id`(`acl_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_acl_module
-- ----------------------------
DROP TABLE IF EXISTS `t_acl_module`;
CREATE TABLE `t_acl_module`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限模块id',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限模块名称',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '上级权限模块id',
  `level` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限模块层级',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '权限模块在当前层级下的顺序，由小到大',
  `status` int(11) NOT NULL DEFAULT 1 COMMENT '状态，1：正常，0：冻结',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_backstock
-- ----------------------------
DROP TABLE IF EXISTS `t_backstock`;
CREATE TABLE `t_backstock`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(10) UNSIGNED NOT NULL COMMENT '订单ID',
  `sku` json NOT NULL COMMENT '退货商品',
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '退货原因',
  `qa_id` bigint(10) UNSIGNED NOT NULL COMMENT '质检员ID',
  `payment` decimal(10, 2) UNSIGNED NOT NULL COMMENT '退款金额',
  `payment_type` tinyint(3) UNSIGNED NOT NULL COMMENT '退款方式：1借记卡，2信用卡，3微信，4支付宝，5现金',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态：1退货成功,2无法退货',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx_qa_id`(`qa_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1155729453645570050 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退货表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `images` json NULL COMMENT '图片网址',
  `letter` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品牌首字母',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_name`(`name`) USING BTREE,
  INDEX `idx_letter`(`letter`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品牌表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `parent_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '上级分类ID',
  `sort` int(10) UNSIGNED NOT NULL COMMENT '排名指数',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE,
  INDEX `idx_sort`(`sort`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_category_brand`;
CREATE TABLE `t_category_brand`  (
  `category_id` bigint(10) UNSIGNED NOT NULL COMMENT '分类ID',
  `brand_id` bigint(10) UNSIGNED NOT NULL COMMENT '品牌ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`category_id`, `brand_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类与品牌关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '城市',
  `province_id` int(10) UNSIGNED NOT NULL COMMENT '省份ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码（AES加密）',
  `wechat` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `level_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '会员等级',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `last_update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_username`(`username`) USING BTREE,
  INDEX `idx_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_customer_address
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_address`;
CREATE TABLE `t_customer_address`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customer_id` bigint(10) UNSIGNED NOT NULL COMMENT '客户ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `prime` tinyint(1) NOT NULL COMMENT '默认地址',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_customer_id`(`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '?????' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_delivery
-- ----------------------------
DROP TABLE IF EXISTS `t_delivery`;
CREATE TABLE `t_delivery`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_id` bigint(10) UNSIGNED NOT NULL COMMENT '订单ID',
  `sku` json NOT NULL COMMENT '商品',
  `qa_id` bigint(10) UNSIGNED NOT NULL COMMENT '质检员ID',
  `de_id` bigint(10) UNSIGNED NOT NULL COMMENT '发货员ID',
  `postid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '快递单号',
  `price` decimal(10, 0) UNSIGNED NOT NULL COMMENT '快递费',
  `ecp` tinyint(3) UNSIGNED NOT NULL COMMENT '快递公司编号',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `warehouse_id` bigint(10) UNSIGNED NOT NULL COMMENT '仓库ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx_qa_id`(`qa_id`) USING BTREE,
  INDEX `idx_de_id`(`de_id`) USING BTREE,
  INDEX `idx_postid`(`postid`) USING BTREE,
  INDEX `idx_warehouse_id`(`warehouse_id`) USING BTREE,
  INDEX `idx_address_id`(`address`) USING BTREE,
  INDEX `idx_ecp`(`ecp`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '快递表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `alias` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门缩写',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_dname`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `married` tinyint(1) DEFAULT '0' COMMENT '婚否',
  `education` tinyint(4) NOT NULL COMMENT '学历：1大专,2本科,3研究生,4博士,5其他',
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `job_id` bigint(10) UNSIGNED NOT NULL COMMENT '职务ID',
  `dept_id` bigint(10) UNSIGNED NOT NULL COMMENT '部门ID',
  `mgr_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '上司ID',
  `hiredate` date NOT NULL COMMENT '入职日期',
  `termdate` date NULL DEFAULT NULL COMMENT '离职日期',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态：1在职,2休假,3离职,4死亡',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_wid`(`wid`) USING BTREE,
  INDEX `idx_job_id`(`job_id`) USING BTREE,
  INDEX `idx_dept_id`(`dept_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_mgr_id`(`mgr_id`) USING BTREE,
  INDEX `idx_wid`(`wid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职位名称',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_job`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_level
-- ----------------------------
DROP TABLE IF EXISTS `t_level`;
CREATE TABLE `t_level`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `level` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级',
  `discount` decimal(10, 2) UNSIGNED NOT NULL COMMENT '折扣',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '流水号',
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '订单类型：1实体销售,2网络销售',
  `shop_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '零售店ID',
  `customer_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '会员ID',
  `amount` decimal(10, 2) UNSIGNED NOT NULL COMMENT '总金额',
  `payment_type` tinyint(3) UNSIGNED NOT NULL COMMENT '支付方式：1借记卡,2信用卡,3微信,4支付宝,5现金',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态：1未付款,2已付款,3已发货,4已签收',
  `postage` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '邮费',
  `weight` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '重量（克）',
  `voucher_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '购物券ID',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_code`(`code`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE,
  INDEX `idx_customer_id`(`customer_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE,
  INDEX `idx_type`(`type`) USING BTREE,
  INDEX `idx_shop_id`(`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
  `order_id` bigint(10) UNSIGNED NOT NULL COMMENT '订单ID',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '原价格',
  `actual_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '实际购买价',
  `num` int(10) UNSIGNED NOT NULL COMMENT '购买数量',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`order_id`, `sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_productin
-- ----------------------------
DROP TABLE IF EXISTS `t_productin`;
CREATE TABLE `t_productin`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `storekeeper_id` bigint(10) UNSIGNED NOT NULL COMMENT '保管员ID',
  `amount` decimal(15, 2) UNSIGNED NOT NULL COMMENT '总金额',
  `supplier_id` bigint(10) UNSIGNED NOT NULL COMMENT '供应商ID',
  `payment` decimal(15, 2) UNSIGNED NOT NULL COMMENT '实付金额',
  `payment_type` tinyint(3) UNSIGNED NOT NULL COMMENT '支付方式',
  `invoice` tinyint(1) NOT NULL COMMENT '是否开票',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_storekeeper_id`(`storekeeper_id`) USING BTREE,
  INDEX `idx_supplier_id`(`supplier_id`) USING BTREE,
  INDEX `idx_payment_type`(`payment_type`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_productin_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_productin_purchase`;
CREATE TABLE `t_productin_purchase`  (
  `productin_id` bigint(10) UNSIGNED NOT NULL COMMENT '入库ID',
  `purchase_id` bigint(10) UNSIGNED NOT NULL COMMENT '采购ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`productin_id`, `purchase_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase`;
CREATE TABLE `t_purchase`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `num` int(10) UNSIGNED NOT NULL COMMENT '数量',
  `warehouse_id` bigint(10) UNSIGNED NOT NULL COMMENT '仓库ID',
  `in_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '采购价格',
  `out_price` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '建议零售价',
  `buyer_id` bigint(10) UNSIGNED NOT NULL COMMENT '采购员ID',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态：1未完成,2已完成',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sku_id`(`sku_id`) USING BTREE,
  INDEX `idx_warehouse_id`(`warehouse_id`) USING BTREE,
  INDEX `idx_buyer_id`(`buyer_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采购表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_rating
-- ----------------------------
DROP TABLE IF EXISTS `t_rating`;
CREATE TABLE `t_rating`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `order_id` bigint(10) UNSIGNED NOT NULL COMMENT '订单ID',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `images` json NULL COMMENT '买家晒图',
  `rating` tinyint(3) UNSIGNED NOT NULL COMMENT '评分',
  `comment` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx_sku_id`(`sku_id`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_role`(`role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_acl
-- ----------------------------
DROP TABLE IF EXISTS `t_role_acl`;
CREATE TABLE `t_role_acl`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `acl_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shop
-- ----------------------------
DROP TABLE IF EXISTS `t_shop`;
CREATE TABLE `t_shop`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_id` int(10) UNSIGNED NOT NULL COMMENT '城市ID',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_city_id`(`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '零售店表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_shop_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_shop_sku`;
CREATE TABLE `t_shop_sku`  (
  `shop_id` bigint(10) UNSIGNED NOT NULL COMMENT '零售店ID',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `num` int(10) UNSIGNED NOT NULL COMMENT '库存数量',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库存单位',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`shop_id`, `sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '零售店商品库存表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_sku`;
CREATE TABLE `t_sku`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spu_id` bigint(10) UNSIGNED NOT NULL COMMENT '产品ID',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品标题',
  `images` json NULL COMMENT '商品图片',
  `price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '价格',
  `param` json NOT NULL COMMENT '参数',
  `saleable` tinyint(1) NOT NULL COMMENT '是否上架',
  `valid` tinyint(1) NOT NULL COMMENT '是否有效',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `last_update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_spu_id`(`spu_id`) USING BTREE,
  INDEX `idx_saleable`(`saleable`) USING BTREE,
  INDEX `idx_valid`(`valid`) USING BTREE,
  FULLTEXT INDEX `title`(`title`)
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_spec_group
-- ----------------------------
DROP TABLE IF EXISTS `t_spec_group`;
CREATE TABLE `t_spec_group`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spg_id` bigint(10) UNSIGNED NOT NULL COMMENT '品类编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '品类名称',
  `is_delted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_spg_id`(`spg_id`) USING BTREE,
  UNIQUE INDEX `unq_name`(`name`) USING BTREE,
  INDEX `idx_spg_id`(`spg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '品类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_spec_param
-- ----------------------------
DROP TABLE IF EXISTS `t_spec_param`;
CREATE TABLE `t_spec_param`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spg_id` bigint(10) UNSIGNED NOT NULL COMMENT '品类编号',
  `spp_id` bigint(10) UNSIGNED NOT NULL COMMENT '参数编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参数名称',
  `numeric` tinyint(1) NOT NULL COMMENT '是否为数字参数',
  `unit` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位(量词)',
  `generic` tinyint(1) NOT NULL COMMENT '是否为通用参数',
  `searching` tinyint(1) NOT NULL COMMENT '是否用于通用搜索',
  `segements` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数值',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_spg_id`(`spg_id`) USING BTREE,
  INDEX `idx_spp_id`(`spp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '参数表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_spu
-- ----------------------------
DROP TABLE IF EXISTS `t_spu`;
CREATE TABLE `t_spu`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `sub_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `category_id` bigint(10) UNSIGNED NOT NULL COMMENT '分类ID',
  `brand_id` bigint(10) UNSIGNED NULL DEFAULT NULL COMMENT '品牌ID',
  `spg_id` bigint(10) UNSIGNED NOT NULL COMMENT '品类ID',
  `saleable` tinyint(1) NOT NULL COMMENT '是否上架',
  `valid` tinyint(1) NOT NULL COMMENT '是否有效',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `last_update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_brand_id`(`brand_id`) USING BTREE,
  INDEX `idx_category_id`(`category_id`) USING BTREE,
  INDEX `idx_spg_id`(`spg_id`) USING BTREE,
  INDEX `idx_saleable`(`saleable`) USING BTREE,
  INDEX `idx_valid`(`valid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供货商编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供货商名称',
  `type` tinyint(3) UNSIGNED NOT NULL COMMENT '类型：1厂家,2代理商,3个人',
  `link_man` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系地址',
  `bank_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行名称',
  `bank_account` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行账号',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态:1可用,2不可用',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_code`(`code`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE,
  INDEX `idx_type`(`type`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供货商表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_supplier_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier_sku`;
CREATE TABLE `t_supplier_sku`  (
  `supplier_id` bigint(10) UNSIGNED NOT NULL COMMENT '供货商ID',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`supplier_id`, `sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供货商关联商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码（AES加密）',
  `emp_id` bigint(10) UNSIGNED NOT NULL COMMENT '员工ID',
  `role_id` bigint(10) UNSIGNED NOT NULL COMMENT '角色ID',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '状态：1可用,2禁用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `last_update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_username`(`username`) USING BTREE,
  INDEX `idx_username`(`username`) USING BTREE,
  INDEX `idx_emp_id`(`emp_id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_voucher
-- ----------------------------
DROP TABLE IF EXISTS `t_voucher`;
CREATE TABLE `t_voucher`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deno` decimal(10, 2) UNSIGNED NOT NULL COMMENT '面值',
  `condition` decimal(10, 2) UNSIGNED NOT NULL COMMENT '订单满多少钱可以使用',
  `start_date` date NULL DEFAULT NULL COMMENT '起始日期',
  `end_date` date NULL DEFAULT NULL COMMENT '截止日期',
  `max_num` int(11) NULL DEFAULT NULL COMMENT '代金券发放最大数量',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物券表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_voucher_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_voucher_customer`;
CREATE TABLE `t_voucher_customer`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `voucher_id` bigint(10) UNSIGNED NOT NULL COMMENT '购物券ID',
  `customer_id` bigint(10) UNSIGNED NOT NULL COMMENT '客户ID',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户关联购物券数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse`  (
  `id` bigint(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `city_id` int(10) UNSIGNED NOT NULL COMMENT '城市ID',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `lng` decimal(15, 10) NULL DEFAULT NULL COMMENT '纬度',
  `lat` decimal(15, 10) NULL DEFAULT NULL COMMENT '经度',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_city_id`(`city_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_warehouse_sku
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse_sku`;
CREATE TABLE `t_warehouse_sku`  (
  `warehouse_id` bigint(10) UNSIGNED NOT NULL COMMENT '仓库ID',
  `sku_id` bigint(10) UNSIGNED NOT NULL COMMENT '商品ID',
  `num` int(10) UNSIGNED NOT NULL COMMENT '库存数量',
  `unit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '库存单位',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`warehouse_id`, `sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库商品库存表' ROW_FORMAT = Dynamic;


