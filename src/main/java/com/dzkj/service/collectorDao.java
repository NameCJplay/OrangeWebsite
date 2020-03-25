package com.dzkj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dzkj.mapper.collectormapper;
import com.dzkj.pojo.collector;
import com.dzkj.pojo.product;

@Service
public class collectorDao implements collectorImp{
	@Resource
	collectormapper collectormapper;
	
	//用户商品查询
	@Override
	public List<collector> query(Integer userid) {
		// TODO Auto-generated method stub
	return collectormapper.query(userid);
	}

	@Override
	public Integer addsproduct(collector collector) {
		// TODO Auto-generated method stub
		return collectormapper.addsproduct(collector);
	}

	
	


	
	

}
