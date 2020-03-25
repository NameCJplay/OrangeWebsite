package com.dzkj.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.mapper.smalltypeMapper;
import com.dzkj.pojo.smalltype;

@Controller
public class SeachController {

	@Autowired
	smalltypeMapper smallMapper;

	@RequestMapping("/Seach")
	public String Seach( @RequestParam(value="text",required = false) String text,Model model) {
		List<smalltype> list = smallMapper.Search(text);
		model.addAttribute("list",list);
		model.addAttribute("text", text);
		return "home/search";
	}
	
	
	
	
}
