package com.dzkj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.http.HttpRequest;
import com.dzkj.mapper.usermapper;
import com.dzkj.service.orderDaoImp;
import com.dzkj.service.productDaoImp;
import com.dzkj.service.shopcartImp;
import com.dzkj.service.userDaoImp;
import com.dzkj.pojo.region;
import com.dzkj.pojo.shopcart;
import com.dzkj.pojo.users;
import com.dzkj.pojo.address;
import com.dzkj.pojo.orderss;
import com.dzkj.pojo.product;

@Controller
@RequestMapping("home")
public class IndexController {
	@Autowired
	userDaoImp userdao;
	@Autowired
	orderDaoImp orderdao;
	@Autowired
	productDaoImp productdao;
	@Autowired
	shopcartImp shopdao;

	@RequestMapping("index")
	public String index(HttpServletRequest request,Model model) {
		users use=(users)request.getSession().getAttribute("user");
		int shopcartcount=shopdao.queryshopcartcount(use.getUserid());
		model.addAttribute("count", shopcartcount);
		return "person/index";
	}

	// 个人信息跳转显示
	@RequestMapping("information")
	public String information() {
		return "person/information";
	}

	// 跳转安全设置
	@RequestMapping("safety")
	public String safety() {
		return "person/safety";
	}

	// 跳转更改密码页面
	@RequestMapping("password")
	public String password() {
		return "person/password";
	}

	// 修改密码
	@RequestMapping("updatepwd")
	@ResponseBody
	public String updatepwd(String userid, String useroldpassword, String usernewpassword) {
		users user = new users();
		user.setUserid(Integer.parseInt(userid));
		user.setPwd(useroldpassword);
		if (userdao.updatepwd(user) != null) {
			userdao.updatepassword(Integer.parseInt(userid), usernewpassword);
			return "updatesuccess";
		}
		return "erroruseroldpassword";
	}

	// 跳转支付密码页面
	@RequestMapping("setpay")
	public String setpay() {
		return "person/setpay";
	}

	// 修改支付密码验证
	String codestr = "", fristphone = "";

	@RequestMapping("tellpay")
	@ResponseBody
	public String tellpay(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		codestr = codeString;
		fristphone = phone;
		return codestr;
	}

	// 设置或修改支付密码成功
	@RequestMapping("upay")
	@ResponseBody
	public String tellphone(String userid, String code, String paypwd) {
		if (codestr.equals(code)) {
			userdao.updatepay(Integer.parseInt(userid), paypwd);
			return "success";
		}
		return "error";
	}

	// 设置密码成功跳home.html页面
	@RequestMapping("setpaysuccess")
	public String setpaysuccess() {
		return "home/home";
	}

	// 跳转bindphone.html页面
	@RequestMapping("bindphone")
	public String bindphone() {
		return "person/bindphone";
	}

	// 修改手机号码验证
	String fristtellcodestr = "";

	@RequestMapping("phoneone")
	@ResponseBody
	public String tellphone(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		fristtellcodestr = codeString;
		return fristtellcodestr;
	}

	String lasttellcodestr = "";

	@RequestMapping("phonetwo")
	@ResponseBody
	public String lastphone(String phone) {
		String codeString = SendSmsUtil.sendCheckMSM(phone);
		lasttellcodestr = codeString;
		return lasttellcodestr;
	}

	// 修改手机号码成功
	@RequestMapping("uphone")
	@ResponseBody
	public String utellphone(String userid, String code, String newcode, String newphone) {
		if (code.equals(fristtellcodestr) && newcode.equals(lasttellcodestr)) {
			userdao.updatephone(Integer.parseInt(userid), newphone);
			return "success";
		}
		return "error";
	}
	//修改个人信息
		@RequestMapping("upduser")
		public String upateuser(String userid, String uzname, String nikname,String usex, String birthday,String tellphone,String email) {
			userdao.updateusers(Integer.parseInt(userid), uzname, nikname, usex, birthday, tellphone,email);
			return "person/index";
		}
	// 收货地址管理
	@RequestMapping("address")
	public String address(String userid, Model model) {
		// 查询省份
		List<region> province = userdao.regionAll();
		model.addAttribute("province", province);
		// 查询已添加的收货地址
		List<address> address = userdao.QueryAddress(Integer.parseInt(userid));
		model.addAttribute("address", address);
		return "person/address";
	}

	// 查询市或县区
	@RequestMapping("city")
	@ResponseBody
	public List<region> city(String parent_id, Model model) {
		List<region> city = userdao.regioncityAll(Integer.parseInt(parent_id));
		return city;
	}

	// 添加收货地址
	@RequestMapping("insertaddress")
	@ResponseBody
	public List<region> insertaddress(String userid, String username, String userphone, String province, String city,
			String county, String userintro) {
		int addresscount = userdao.QueryAddressCount(Integer.parseInt(userid));
		if (addresscount >= 1) {
			List<region> prov = insertaddressfunction(userid, username, userphone, province, city, county, userintro,0);
			return prov;
		} else {
			List<region> prov = insertaddressfunction(userid, username, userphone, province, city, county, userintro,1);
			return prov;
		}
	}
	//此方法用于insertaddress调用
	public List<region> insertaddressfunction(String userid, String username, String userphone, String province,
			String city, String county, String userintro, int state) {
		userdao.insertaddress(Integer.parseInt(userid), username, userphone, province, city, county, userintro, state);
		List<region> prov = userdao.regionAll();
		return prov;
	}
	//点击设置默认地址
	@RequestMapping("defaultaddress")
	@ResponseBody
	public String defaultaddress(String userid,String aid) {
		if(userdao.statezero(Integer.parseInt(userid))>0&&userdao.stateone(Integer.parseInt(aid))>0) {
		return "success";
		}
		return "error";
	}
	//后台订单管理跳转
	@RequestMapping("order")
	public String order(String userid,Model model) {
		List<orderss> orders=userdao.QueryOrder(Integer.parseInt(userid));
		model.addAttribute("orders", orders);
		return "person/order";
	}
	//订单商品删除
	@RequestMapping("delorder")
	@ResponseBody
	public String delorder(String oid) {
		orderdao.delorder(Integer.parseInt(oid));
		return "success";
	}
	//订单商品确认收货
	@RequestMapping("affirmorder")
	@ResponseBody
	public String affirm(String oid) {
		orderdao.affirm(Integer.parseInt(oid));
		return "success";
	}
	//订单详情
	@RequestMapping("orderinfo")
	public String orderinfo() {
		return "person/orderinfo";
	}
	//一键支付跳转
	@RequestMapping("pay")
	public String pay(String userid,String oid,Model model) {
		Queryorder(userid, oid, model);
		return "home/pay";
	}
	//一键支付设置默认地址
	@RequestMapping("paydefaultaddress")
	public String paydefaultaddress(String userid,String aid,String oid,Model model) {
	userdao.statezero(Integer.parseInt(userid));
	userdao.stateone(Integer.parseInt(aid));
	if(!oid.equals("null")) {
	Queryorder(userid,oid,model);
	}
	return "home/pay";
	}
	//订单商品数量增加或减少金额改变
	@RequestMapping("ordermoney")
	@ResponseBody
	public String ordermoney(String oid,String money,String shuliang) {
		if(orderdao.ordermoney(Integer.parseInt(money), Integer.parseInt(oid),Integer.parseInt(shuliang))>0) {
		return "success";
		}
		return "error";
	}
	//查询订单所选中的商品信息
	public void Queryorder(String userid,String oid,Model model) {
		List<address> address = userdao.QueryAddress(Integer.parseInt(userid));
		List<orderss> orders=userdao.QueryOrder(Integer.parseInt(userid));
		for (orderss orderss : orders) {
			if(orderss.getOid()==Integer.parseInt(oid)) {
				product product=productdao.Unpaidgoods(orderss.getProduct().getPid());
				model.addAttribute("order", orderss);
				model.addAttribute("product", product);
			}
		}
		model.addAttribute("address", address);
	}
	//单独删除购物车商品
	@RequestMapping("shopcartdel")
	@ResponseBody
	public String shopcartdel(String sid) {
		System.out.println(sid);
		shopdao.delsid(Integer.parseInt(sid));
		return "success";
	}
	//立即购买
	@RequestMapping("nowbuy")
	public String nowbuy(String userid,String imgurl,String pname,String price,String num,Model model) {
		product product = new product();
		orderss order=new orderss();
		product.setImgurl(imgurl.substring(8, imgurl.length()));
		product.setPname(pname);
		product.setPrice(Integer.parseInt(price));
		order.setShuliang(Integer.parseInt(num));
		order.setNums("");
		order.setMoney(Integer.parseInt(num)*Integer.parseInt(price));
		List<address> address = userdao.QueryAddress(Integer.parseInt(userid));
		model.addAttribute("address", address);
		model.addAttribute("product", product);
		model.addAttribute("order", order);
		return "home/pay";
	}
	//查看物流
		@RequestMapping("logistics")
		public String logistics() {
			return "person/logistics";
		}
		//我的积分跳转
		@RequestMapping("points")
		public String points() {
			return "person/points";
		}
}
