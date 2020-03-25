package com.dzkj.alipay;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class OrderIdUtil {
	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
	//随机生成订单号
	public String getOrderId() {
		String date = sdf.format(new Date());
		return date+(int)((Math.random()*9+1)*1000);
	}
}
