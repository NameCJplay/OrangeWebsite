package com.dzkj.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.shopcart;

public interface shopcartImp {
	//查询购物车数量
	int queryshopcartcount(int userid);
	boolean addshopcar(int userid,int nums,int pid);
	//查询购物车商品 
	List<shopcart> findshopcart(int userid);
	//购物车支付失败添加微支付订单
	Integer addorder(int userid,String nums,String time,int id,int pid,int shuliang,int money);
	//支付成功修改状态
	Integer shopcartsuccess(String nums);
	//加入购物车时查询商品是否存在
	shopcart queryshopcart(int userid,int pid);
	//加入购物车时商品存在数量加一
	int addshopcartnums(int userid,int nums,int pid);
	//加入购物车时商品不存在增加商品到购物车 
	int addshopcart(int userid,int nums,int pid);
	//购买成功购物车订单删除
	int delsid(int sid);
}
