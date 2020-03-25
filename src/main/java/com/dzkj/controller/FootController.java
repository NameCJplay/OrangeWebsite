package com.dzkj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.WriteBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dzkj.mapper.FootMapper;
import com.dzkj.pojo.Foot;
import com.dzkj.pojo.users;

@Controller
@RequestMapping("person")
public class FootController {
	@Autowired
	FootMapper fmap;
	
	@RequestMapping("findfoot")
	public String findall(Model model,HttpServletRequest request) {
		//System.out.println("足迹查询来了");
		users user =  (users) request.getSession().getAttribute("user");
		List<Foot> list = fmap.Findall(user.getUserid());
		model.addAttribute("flist", list);
		return "person/foot";
	}
	
	@RequestMapping("Delfoot")
	public void findall(Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter pw = response.getWriter();
		
		if(fmap.Delfoot(id)) {
			pw.write("1");
		}else {
			pw.write("2");
		}
			
	}
	
	
	
	
}
