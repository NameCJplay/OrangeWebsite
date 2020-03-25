package com.dzkj.service;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.orderss;
import com.dzkj.pojo.product;

public interface orderDaoImp {
		//删除该商品订单
		Integer delorder(int oid);
		//订单商品确认收货
		Integer affirm(int oid);
		//通过id查询未付款的商品
		orderss unpaid(int oid);
		//支付成功通过订单id修改状态为支付状态
		Integer orderpay(int oid);
		//订单商品数量增加金额改变
		Integer ordermoney(int money,int oid,int shuliang);
}
