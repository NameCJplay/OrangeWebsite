package com.dzkj.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.Session;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dzkj.mapper.ProductMapper;
import com.dzkj.mapper.businessMapper;
import com.dzkj.mapper.smalltypeMapper;
import com.dzkj.pojo.business;
import com.dzkj.pojo.smalltype;
import com.dzkj.pojo.users;
import com.dzkj.service.shopcartImp;
import com.dzkj.service.userDaoImp;

@Controller
@RequestMapping("home")
public class Acontroller {
//登录
	@Autowired
	userDaoImp userdao;
	@Autowired
	smalltypeMapper smallMapper;
	@Autowired
	ProductMapper pmap;
	@Autowired
	businessMapper bmap;

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        factory.setMaxFileSize(1024L * 1024L);
//        return factory.createMultipartConfig();
//    }
    @Autowired
    shopcartImp shopdao;
    
	@RequestMapping("loginservlet")
	public String login(String name, String pwd, HttpServletRequest request,Model model) {
		String email = null, tellphone = null, uname = null;
		// 手机号判断
		String regtell = "^1[3|4|5|7|8][0-9]\\d{8}$";
		// 邮箱判断
		String regemail = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
		if (name.matches(regtell)) {
			tellphone = name;
		} else if (name.matches(regemail)) {
			email = name;
		} else {
			uname = name;
		}
		users u = new users();
		u.setUname(uname);
		u.setEmail(email);
		u.setTellphone(tellphone);
		u.setPwd(pwd);
		users user = userdao.login(u);
		HttpSession session = request.getSession();
		if (user != null) {
			session.setAttribute("user", user);
			int shopcartcount=shopdao.queryshopcartcount(user.getUserid());
			request.getSession().setAttribute("count", shopcartcount);

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
		return "redirect:login.html";
	}

	String codestr = "", fristphone = "";

//手机号码验证码注册
	@RequestMapping("tell")
	@ResponseBody
	public String phone(String phone) {
		users user=new users();
		user.setTellphone(phone);
		if(userdao.queryuser(user)>0) {
			return "exist";
		}else {
		fristphone = phone;
		String codeString = SendSmsUtil.sendCheckMSM(fristphone);
		codestr = codeString;
		return codestr;
		}
	}

	@RequestMapping("tellphone")
	@ResponseBody
	public String tellphone(String code, String phone,String password) {
		if (codestr.equals(code) && fristphone.equals(phone)) {
			Date date=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			userdao.inserttell(phone, password,sf.format(date));
			return "success";
		}
		return "error";
	}
	
	// 头像上传
	@RequestMapping("/fileupload")
	public String uploading(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		// 获取文件名
		String filename = file.getOriginalFilename();
		if (!filename.isEmpty()) {
			// 获取项目路径
			String realfile = request.getServletContext().getRealPath("upload");
			// 根据资源创建文件
			File save_file = new File(realfile, filename);

			// 保存文件
			file.transferTo(save_file);
		}
		return "home/home";
	}

	@RequestMapping("/upload")
	public String upload(Model model) {
		model.addAttribute("load", "../images/getAvatar.do.jpg");
		return "../person/information";
	}

	@RequestMapping("/uploadsuccess")
	public String uploadjpg(@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String filename = file.getOriginalFilename();
		if (!filename.isEmpty()) {
			String realfile = request.getServletContext().getRealPath("images");
			File save_file = new File(realfile, "../images/getAvatar.do.jpg");
			file.transferTo(save_file);
			System.out.println(save_file);
		}
		return "home/home";
	}
}
