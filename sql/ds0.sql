CREATE DATABASE `ds0` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

use `ds0`;
CREATE TABLE `t_config` (
  `id` varchar(255) NOT NULL,
  `key` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='配置表';

CREATE TABLE `t_order0` (
  `order_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单分库表0';

CREATE TABLE `t_order1` (
  `order_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单分库表1';

CREATE TABLE `t_order_item0` (
  `order_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

CREATE TABLE `t_order_item1` (
  `order_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单详情表';

CREATE TABLE `t_user` (
  `id` varchar(255) NOT NULL,
  `mobile` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `t_user_login_log` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录';

CREATE TABLE `t_user_login_log_0` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录';

CREATE TABLE `t_user_login_log_1` (
  `id` varchar(255) NOT NULL,
  `user_id` varchar(16) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户登录1';

