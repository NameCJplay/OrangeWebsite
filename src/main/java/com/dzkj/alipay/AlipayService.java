package com.dzkj.alipay;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.dzkj.service.shopcartImp;

@Service
public class AlipayService {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrderIdUtil orderIdUtil;
	
	@Autowired
	shopcartImp shopcart;
	
	public String alipay() throws Exception {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AliPayConfig.return_url);
		alipayRequest.setNotifyUrl(AliPayConfig.notify_url);
		String out_trade_no=null;
		String nums=request.getParameter("nums");
		System.out.println("订单为："+nums);
		Date date=new Date();
		String sysdate=date.getYear()+"-"+date.getMonth()+"-"+date.getDay()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		if(nums.equals("sumshop")){
		//商户订单号，商户网站订单系统中唯一订单号，必填
		out_trade_no = new String(orderIdUtil.getOrderId().getBytes(),"utf-8");
		//购物车批量生成订单
		String userid=request.getParameter("userid");
		String moneystr=request.getParameter("moneystr");
		String shuliangstr=request.getParameter("shuliangstr");
		String pidstr=request.getParameter("pid");
		String idstr=request.getParameter("idstr");
		String[] shuliangstrArray = shuliangstr.split(",");
		String[] moneystrArray = moneystr.split(",");
		String[] pidstrArray = pidstr.split(",");
		String[] idstrArray = idstr.split(",");
		for (int i = 0; i < moneystrArray.length; i++) {
//			System.out.println("用户id:"+Integer.parseInt(userid));
//			System.out.println("订单号：:"+out_trade_no);
//			System.out.println("订单时间："+new Date());
//			System.out.println("smalltypeid：:"+Integer.parseInt(idstrArray[i]));
//			System.out.println("商品数量:"+Integer.parseInt(shuliangstrArray[i]));
//			System.out.println("商品总价:"+Integer.parseInt(moneystrArray[i]));
//			System.out.println("商品id：:"+Integer.parseInt(pidstrArray[i]));
			shopcart.addorder(Integer.parseInt(userid), out_trade_no, sysdate, Integer.parseInt(idstrArray[i]), Integer.parseInt(pidstrArray[i]), Integer.parseInt(shuliangstrArray[i]), Integer.parseInt(moneystrArray[i]));
			
		}
		}else if(nums!=null&&!nums.equals("nowbuy")) {
			out_trade_no=nums;
		}else if(nums.equals("nowbuy")){
			//商户订单号，商户网站订单系统中唯一订单号，必填
			int shuliang=Integer.parseInt(request.getParameter("shuliang"));
			int total_amount=Integer.parseInt(request.getParameter("total_amount"));
			out_trade_no = new String(orderIdUtil.getOrderId().getBytes(),"utf-8");
			shopcart.addorder(Integer.parseInt(request.getParameter("userid")), out_trade_no, sysdate, 3, 1, shuliang, total_amount);
		}
		//付款金额，必填
		String total_amount = request.getParameter("total_amount");
		//订单名称，必填
		String subject = request.getParameter("subject");
		//商品描述，可空
		String body = request.getParameter("body");
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//请求
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		
		//输出
		return result;
	}
}
