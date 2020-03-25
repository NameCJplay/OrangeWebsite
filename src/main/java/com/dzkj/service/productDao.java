package com.dzkj.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzkj.mapper.ProductMapper;
import com.dzkj.pojo.product;
@Service
public class productDao implements productDaoImp{
	@Resource
	ProductMapper productmapper;
	//通过id查询未付款的商品
	@Override
	public product Unpaidgoods(int pid) {
		return productmapper.selectByPrimaryKey(pid);
	}
	@Override
	public List<product> Findbyid(Integer id) {
		
		return productmapper.Findbyid(id);
	}
}
