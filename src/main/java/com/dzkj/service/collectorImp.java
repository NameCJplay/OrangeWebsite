package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.collector;
import com.dzkj.pojo.product;

public interface collectorImp {
	//用户商品查询
	List<collector> query(Integer userid);
	//添加商品到收藏夹
	Integer addsproduct(collector collector);

}
