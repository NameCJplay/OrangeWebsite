package com.dzkj.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dzkj.mapper.shopcartMapper;
import com.dzkj.pojo.shopcart;

@Service
public class shopcartDao implements shopcartImp{
	@Resource
shopcartMapper shopcartMapper ;
//购物车的添加
@Override
public boolean addshopcar(int userid, int nums, int pid) {

	return shopcartMapper.addshopcar(userid, nums, pid);
}
//查询购物车商品 
@Override
public List<shopcart> findshopcart(int userid) {
	return shopcartMapper.findshopcart(userid);
}
//购物车支付失败添加微支付订单
@Override
public Integer addorder(int userid, String nums, String time, int id, int pid, int shuliang, int money) {
	return shopcartMapper.addorder(userid, nums, time, id, pid, shuliang, money);
}
//支付成功修改状态
@Override
public Integer shopcartsuccess(String nums) {
	return shopcartMapper.shopcartsuccess(nums);
}
//加入购物车时查询商品是否存在
@Override
public shopcart queryshopcart(int userid, int pid) {
	return shopcartMapper.queryshopcart(userid, pid);
}
//加入购物车时商品存在数量加一
@Override
public int addshopcartnums(int userid, int nums, int pid) {
	return shopcartMapper.addshopcartnums(userid, nums, pid);
}
//加入购物车时商品不存在增加商品到购物车 
@Override
public int addshopcart(int userid, int nums, int pid) {
	return shopcartMapper.addshopcart(userid, nums, pid);
}
//查询购物车数量
@Override
public int queryshopcartcount(int userid) {
	return shopcartMapper.queryshopcartcount(userid);
}
//购买成功购物车订单删除
@Override
public int delsid(int sid) {
	return shopcartMapper.delsid(sid);
}
}