package com.dzkj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dzkj.mapper.FootMapper;
import com.dzkj.mapper.ProductMapper;
import com.dzkj.mapper.businessMapper;
import com.dzkj.mapper.smalltypeMapper;
import com.dzkj.pojo.product;
import com.dzkj.pojo.Foot;
import com.dzkj.pojo.business;
import com.dzkj.pojo.smalltype;
import com.dzkj.pojo.users;
import com.dzkj.service.productDao;
import com.dzkj.service.userDaoImp;

@Controller
@RequestMapping("home")
public class ProductCon {

	@Autowired
	userDaoImp userdao;
	@Autowired
	smalltypeMapper smallMapper;
	@Autowired
	ProductMapper pmap;
	@Autowired
	businessMapper bmap;
	@Autowired
	FootMapper fmap;
	
	//商城首页分类
	@RequestMapping("/findall")
	public String Find(Model model) {
		
		List<smalltype> One = smallMapper.Findall();
		for (smalltype s1 : One) {
			List<smalltype> Two = smallMapper.FindTwo(s1.getId());
			List<business> blist = bmap.findbyid(s1.getId());
			s1.setBuslist(blist);
			s1.setSlist(Two);
			for (smalltype s2 : Two) {
				List<smalltype> Three =smallMapper.FindTwo(s2.getId());
				s2.setSlist(Three);
			}
		}
		
		model.addAttribute("slist", One);
		return "home/home";
	}
	
	//商品详情
	@RequestMapping("/profindbyid")
	public String proby(Model model,@RequestParam("id") Integer id,HttpServletRequest request) {
		//获取用户
		//users user = (users) request.getSession().getAttribute("user");
		//int userid = user.getUserid();
		
		List<product> list = pmap.Findbyid(id);	
		String[] par1 = list.get(0).getParame().getPar1().split("-");
		String[] par2 = list.get(0).getParame().getPar2().split("-");
		List<Foot> flist = fmap.Findall(9);
		model.addAttribute("flist", flist);
		model.addAttribute("plist", list);
		model.addAttribute("parlist1", par1);
		model.addAttribute("parlist2", par2);
		return "home/introduction";
	}

}
