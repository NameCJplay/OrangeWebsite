package com.dzkj.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.dzkj.mapper.usermapper;
import com.dzkj.pojo.address;
import com.dzkj.pojo.orderss;
import com.dzkj.pojo.region;
import com.dzkj.pojo.users;

import tk.mybatis.mapper.common.Mapper;

@Service
public class userDao implements userDaoImp{
	@Resource
	usermapper usermapper;
	//手机号注册
	@Override
	public Integer inserttell(String tellphone, String pwd,String time) {
		return usermapper.inserttell(tellphone, pwd,time);
	}
	//判断注册手机号是否已存在
	@Override
	public int queryuser(users user) {
		return usermapper.selectCount(user);
	}
	
	//登录的实现
	@Override
	public users login(users user) {
		return usermapper.selectOne(user);
	}
	//修改确认原密码正确
	@Override
	public users updatepwd(users user) {
		return usermapper.selectOne(user);
	}
	//修改原密码成功
	@Override
	public Integer updatepassword(int userid, String usernewpassword) {
		return usermapper.updatepassword(userid, usernewpassword);
	}
	//修改支付密码
	@Override
	public Integer updatepay(int userid, String paypwd) {
		return usermapper.updatepay(userid, paypwd);
	}
	//修改手机号码
	@Override
	public Integer updatephone(int userid, String tellphone) {
		return usermapper.updatephone(userid, tellphone);
	}
	//查询收货地址的省份
	@Override
	public List<region> regionAll() {
		return usermapper.regionAll();
	}
	//查询收货地址的市
	@Override
	public List<region> regioncityAll(int parent_id) {
		return usermapper.regioncityAll(parent_id);
	}
	//地址管理,添加收货地址
	@Override
	public Integer insertaddress(Integer userid, String username, String userphone, String province, String city,
			String county, String userintro,int state) {
		return usermapper.insertaddress(userid, username, userphone, province, city, county, userintro,state);
	}
	//查询登录用户的收货地址
	@Override
	public List<address> QueryAddress(Integer userid) {
		return usermapper.QueryAddress(userid);
	}
	//查询登录用户的收货地址个数
	@Override
	public int QueryAddressCount(int userid) {
		return usermapper.QueryAddressCount(userid);
	}
	//<!-- 默认地址状态为0 -->
	@Override
	public int statezero(Integer userid) {
		return usermapper.statezero(userid);
	}
	@Override
	public int stateone(int aid) {
		return usermapper.stateone(aid);
	}
	@Override
	//修改个人信息
	public Integer updateusers(int userid, String uzname, String nikname, String usex, String birthday,
			String tellphone,String email) {
		return usermapper.updateusers(userid, uzname, nikname, usex, birthday, tellphone,email);
	}
	//订单查询
	@Override
	public List<orderss> QueryOrder(int userid) {
		return usermapper.QueryOrder(userid);
	}

}
