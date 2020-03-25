package com.dzkj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.dzkj.mapper.ordermapper;
import com.dzkj.pojo.orderss;
import com.dzkj.pojo.product;

@Service
public class orderDao implements orderDaoImp {
	@Resource
	ordermapper ordermapper;
	//删除该商品订单
	@Override
	public Integer delorder(int oid) {
		return ordermapper.delorder(oid);
	}
	//订单商品确认收货
	@Override
	public Integer affirm(int oid) {
		return ordermapper.affirm(oid);
	}
	//通过id查询未付款的商品
	public orderss unpaid(int oid) {
		return ordermapper.selectByPrimaryKey(oid);
	}
	//支付成功通过订单id修改状态为支付状态
	@Override
	public Integer orderpay(int oid) {
		return ordermapper.orderpay(oid);
	}
	//订单商品数量增加金额改变
	@Override
	public Integer ordermoney(int money, int oid,int shuliang) {
		return ordermapper.ordermoney(money, oid,shuliang);
	}
}
