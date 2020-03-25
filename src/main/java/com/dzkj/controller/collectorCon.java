package com.dzkj.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.collector;
import com.dzkj.pojo.product;
import com.dzkj.pojo.users;
import com.dzkj.service.collectorDao;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@RequestMapping("/home")
public class collectorCon {
	@Autowired
	collectorDao collectordao;
	
	@RequestMapping("addcollector")
	public String addcollector(HttpServletRequest request,@RequestParam("id") Integer id) {
		users user = (users) request.getSession().getAttribute("user");
		product pro = new product();
		pro.setPid(id);
		collector collector = new collector(0, user, pro);
		collectordao.addsproduct(collector);
		return "redirect:query";
	}
	
	//查询该用户的添加的商品
	@RequestMapping("query")
	public String query(HttpServletRequest request,Model model) {
		users user = (users) request.getSession().getAttribute("user");	
	List<collector> list = collectordao.query(user.getUserid());
	model.addAttribute("clist", list);
		return "person/collection";
	}
	
	
	
}
