package com.dzkj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.address;
import com.dzkj.pojo.orderss;
import com.dzkj.pojo.region;
import com.dzkj.pojo.users;

public interface userDaoImp {
	
	//登录查询
	users login(users user);
	//判断注册手机号是否已存在
	int queryuser(users user);
	//修改确认原密码正确
	users updatepwd(users user);
	//修改原密码成功
	Integer updatepassword(int userid,String usernewpassword);
	//修改支付密码
	Integer updatepay(int userid,String paypwd);
	//修改手机号码
	Integer updatephone(int userid, String tellphone);
	//手机号注册
	Integer inserttell(String tellphone,String pwd,String time);
	//修改个人信息
		Integer updateusers( int userid, String uzname, String nikname,String usex, String birthday,String tellphone,String email);
	//查询收货地址的省
	List<region> regionAll();
	//查询收货地址的市
	List<region> regioncityAll(int parent_id);
	//地址管理,添加收货地址
	Integer insertaddress(Integer userid, String username, String userphone, String province, String city, String county,
			String userintro,int state);
	//查询登录用户的收货地址
	List<address> QueryAddress(Integer userid);
	//查询登录用户的收货地址个数
	int QueryAddressCount(int userid);
	//<!-- 默认地址状态为0 -->
	int statezero(@Param("userid") Integer userid);
	//默认地址状态为1
	int stateone(int aid);
	//订单查询
	List<orderss> QueryOrder(int userid);
}
