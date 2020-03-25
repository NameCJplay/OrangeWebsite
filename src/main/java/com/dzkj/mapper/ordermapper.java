package com.dzkj.mapper;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.orderss;
import com.dzkj.pojo.users;

import tk.mybatis.mapper.common.Mapper;

public interface ordermapper extends Mapper<orderss>{
	//删除该商品订单
	Integer delorder(@Param("oid") int oid);
	//订单商品确认收货
	Integer affirm(@Param("oid") int oid);
	//支付成功通过订单id修改状态为支付状态
	Integer orderpay(@Param("oid") int oid);
	//订单商品数量增加金额改变
	Integer ordermoney(@Param("money") int money,@Param("oid") int oid,@Param("shuliang") int shuliang);
}
