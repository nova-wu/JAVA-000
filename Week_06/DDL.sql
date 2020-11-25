DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `mobile` varchar(11) NOT NULL COMMENT '手机号',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '商品名称',
  `price` int NOT NULL DEFAULT '0' COMMENT '商品价格：分',
  `count` int NOT NULL DEFAULT '0' COMMENT '库存数量',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='商品表';

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `order_id` varchar(40) NOT NULL COMMENT '订单ID',
  `user_id` int NOT NULL COMMENT '用户id',
  `good_id` int NOT NULL COMMENT '商品id',
  `good_price` int NOT NULL COMMENT '商品价格：分',
  `count` int NOT NULL COMMENT '商品数量',
  `amount` int NOT NULL DEFAULT '0' COMMENT '订单金额：分',
  `status` int NOT NULL DEFAULT '0' COMMENT '订单状态：0 待支付 1 已支付',
  `create_time` int NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';


--插入用户数据
insert into user(`nickname`,`mobile`,`create_time`) VALUES('陈陈','19916728223',1606182652);
insert into user(`nickname`,`mobile`,`create_time`) VALUES('吴吴','19916728253',1606182669);
insert into user(`nickname`,`mobile`,`create_time`) VALUES('马马','18918012345',1606182678);
insert into user(`nickname`,`mobile`,`create_time`) VALUES('汤汤','17334566732',1606182684);
insert into user(`nickname`,`mobile`,`create_time`) VALUES('天天','15156785467',1606182692);

--插入商品数据
insert into goods(`name`,`price`,`count`,`create_time`) VALUES('罗技M590鼠标',9000,100,1606184020);
insert into goods(`name`,`price`,`count`,`create_time`) VALUES('罗技茶轴100键盘',12000,100,1606184064);
insert into goods(`name`,`price`,`count`,`create_time`) VALUES('华为蓝牙耳机',16000,100,1606184099);

--插入订单数据
insert into `order`(`order_id`,`user_id`,`good_id`,`good_price`,`count`,`amount`,`status`,`create_time`)
VALUES('6b4e39b4-3377-4021-8c8f-ba9f89f74bda',1,1,9000,1,9000,1,1606184315);
insert into `order`(`order_id`,`user_id`,`good_id`,`good_price`,`count`,`amount`,`status`,`create_time`)
VALUES('1677c142-150c-4207-ba01-9180d81e9cc0',2,1,9000,1,9000,1,1606184403);
insert into `order`(`order_id`,`user_id`,`good_id`,`good_price`,`count`,`amount`,`status`,`create_time`)
VALUES('9bd5f62e-c213-4407-9d8f-4c8013b27625',3,1,9000,1,9000,1,1606184408);

-- 更新user表id=5 的用昵称
update `user` set username='坦坦' where id=5;

-- 删除user表id=5 的用户
delete from user where id=5;
