package com.dzkj.interceptor;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dzkj.mapper.FootMapper;
import com.dzkj.pojo.Foot;
import com.dzkj.pojo.product;
import com.dzkj.pojo.users;

//添加足迹-拦截器
@Component
@Transactional
public class FootInterceptor implements HandlerInterceptor{

	@Autowired
	FootMapper fmap;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	//运行后拦截
	//进入商品详情界面后拦截并加入我的足迹
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sdf.format(date);
		//获取数据
		users user =  (users) request.getSession().getAttribute("user");
		Integer pid = new Integer(request.getParameter("id"));
		product prd = new product();
		prd.setPid(pid);
		Foot fo = new Foot(null, user.getUserid(), prd, datestr);	
		//添加足迹
		if(fmap.addfoot(fo)) {
			//System.out.println("足迹添加成功");
		}
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
	
	
	
	
	
}
