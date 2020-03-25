package com.dzkj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.collector;
import com.dzkj.pojo.product;

import tk.mybatis.mapper.common.Mapper;

public interface collectormapper{
	//用户添加商品到收藏夹
	Integer addsproduct(collector collector);
	//根据用户id查询该用户收藏的商品
	List<collector> query(@Param("userid") Integer userid) ;


}
 