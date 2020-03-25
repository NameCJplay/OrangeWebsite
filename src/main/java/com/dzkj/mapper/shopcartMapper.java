package com.dzkj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.orderss;
import com.dzkj.pojo.shopcart;

public interface shopcartMapper{
	//查询购物车数量
	int queryshopcartcount(@Param("userid")int userid);
	boolean addshopcar(@Param("userid")int userid,@Param("nums")int nums,@Param("pid")int pid);
	//查询购物车商品 
	List<shopcart> findshopcart(@Param("userid") int userid);
	//购物车支付失败添加微支付订单
	Integer addorder(@Param("userid") int userid,@Param("nums") String nums,@Param("time") String time,@Param("id") int id,@Param("pid") int pid,@Param("shuliang") int shuliang,@Param("money") int money);
	//支付成功修改状态
	Integer shopcartsuccess(@Param("nums") String nums);
	//加入购物车时查询商品是否存在
	shopcart queryshopcart(@Param("userid") int userid,@Param("pid") int pid);
	//加入购物车时商品存在数量加一
	int addshopcartnums(@Param("userid") int userid,@Param("nums") int nums,@Param("pid") int pid);
	//加入购物车时商品不存在增加商品到购物车 
	int addshopcart (@Param("userid") int userid,@Param("nums") int nums,@Param("pid") int pid);
	//购买成功购物车订单删除
	int delsid(@Param("sid") int sid);
}
