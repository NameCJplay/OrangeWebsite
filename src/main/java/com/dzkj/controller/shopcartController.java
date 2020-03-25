package com.dzkj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.shopcart;
import com.dzkj.pojo.users;
import com.dzkj.service.shopcartImp;
import com.dzkj.service.userDaoImp;


@Controller
@RequestMapping("/home")
public class shopcartController {
	@Autowired
	shopcartImp shopcartdao;
	@Autowired
	userDaoImp userdao;
	 @Autowired
	    shopcartImp shopdao;
	

	@RequestMapping("/addshopcar")
	public String addshopcar(HttpServletRequest request,String nums) {
			users use=(users)request.getSession().getAttribute("user");
			int userid=use.getUserid();
			List<shopcart> shopcart=shopcartdao.findshopcart(userid);
			request.setAttribute("shopcart", shopcart);
			return "home/shopcart";
	}
	//加入购物车时查询商品是否存在
	@RequestMapping("addshopcart")
	@ResponseBody
	public String addshopcart(String userid,String pid,HttpServletRequest request) {
		shopcart shopcart=shopcartdao.queryshopcart(Integer.parseInt(userid), Integer.parseInt(pid));
		if(shopcart!=null) {
			shopcartdao.addshopcartnums(Integer.parseInt(userid),shopcart.getNums()+1 ,Integer.parseInt(pid));
			return "chongfu";
		}else {
			shopcartdao.addshopcart(Integer.parseInt(userid),1 ,Integer.parseInt(pid));
			users use=(users)request.getSession().getAttribute("user");
			int uid=use.getUserid();
			int shopcartcount=shopdao.queryshopcartcount(uid);
			request.getSession().setAttribute("count", shopcartcount);
			return "zengjia";
		}
	}
	
}