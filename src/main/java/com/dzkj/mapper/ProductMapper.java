package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.product;
import com.dzkj.pojo.product;

import tk.mybatis.mapper.common.Mapper;

public interface ProductMapper extends Mapper<product> {
	List<product> Findbyid(Integer id);
}
