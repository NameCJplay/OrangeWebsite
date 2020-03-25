package com.dzkj.alipay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzkj.pojo.orderss;
import com.dzkj.service.orderDaoImp;
import com.dzkj.service.shopcartImp;

@Controller
@RequestMapping("home")
public class AliPayController {
	@Autowired
	AlipayService alipay_service;
	@Autowired
	HttpServletRequest request;
	@Autowired
	orderDaoImp orderdao;
	@Autowired
	shopcartImp shopdao;
	
	int oid=0,sid=0;
	String sidstrArray="";
	@RequestMapping(value = "sandboxpay",params = {"total_amount","subject","userid","nums","oid","shuliang"})
	@ResponseBody
	public String alipay() throws Exception {
		oid=Integer.parseInt(request.getParameter("oid"));
		return alipay_service.alipay();
	}
	
	@RequestMapping(value = "shopcartpay",params = {"userid","sid","nums","total_amount","pid","idstr","subject","shuliangstr","moneystr"})
	@ResponseBody
	public String shopcartpay() throws Exception {
		String siddstr=request.getParameter("sid");
		if(!siddstr.equals("0")) {
			sidstrArray=siddstr;
		}
		return alipay_service.alipay();
	}
	
	@RequestMapping("return_url")
	public String returnurl(Model model) {
		// 支付成功后可得到订单信息，然后自己往数据库写入数据 接着进入成功页面
		if(oid!=0) {
		orderdao.orderpay(oid);
		}
		if(!sidstrArray.equals("")) {
			String[] sidstr = sidstrArray.split(",");
			for (int i = 0; i < sidstr.length; i++) {
				shopdao.delsid(Integer.parseInt(sidstr[i]));
			}
			}
		
		if(!request.getParameter("out_trade_no").equals("null")) {
			shopdao.shopcartsuccess(request.getParameter("out_trade_no"));
		}
		System.out.println("订单号:"+request.getParameter("out_trade_no"));
		System.out.println("付款金额:"+request.getParameter("total_amount"));
		System.out.println("支付宝交易号:"+request.getParameter("trade_no"));
		model.addAttribute("out_trade_no", request.getParameter("out_trade_no"));
		model.addAttribute("total_amount", request.getParameter("total_amount"));
		model.addAttribute("out_trade_no", request.getParameter("out_trade_no"));
		return "home/success";
	}
}
