package com.dzkj.service;

import java.util.List;

import com.dzkj.pojo.product;
import com.dzkj.pojo.product;

public interface productDaoImp {
	//通过id查询未付款的商品
	product Unpaidgoods(int pid);
	List<product> Findbyid(Integer id);
}
