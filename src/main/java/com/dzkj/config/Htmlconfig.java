package com.dzkj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dzkj.interceptor.FootInterceptor;
import com.dzkj.interceptor.LoginInterceptor;


//excludePathPatterns( ) 白名单
@Configuration
public class Htmlconfig implements WebMvcConfigurer{
	
	//申明足迹拦截器对象
	@Bean
	public FootInterceptor footinter() {
		return new FootInterceptor();
	}
	@Bean
	public LoginInterceptor Logininter() {
		return new LoginInterceptor();
	}
	
	//添加配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//足迹拦截器添加
		registry.addInterceptor(footinter()).addPathPatterns("/home/profindbyid*");
		//登录拦截器添加
		registry.addInterceptor(Logininter()).excludePathPatterns("/home/register.html","/home/tell","/home/tellphone","/home/loginservlet","/home/login.html","/home/findall","/home/home.html"
				,"/AmazeUI-2.4.2/**","/css/**","/basic/**","/js/**","/images/**");

		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
