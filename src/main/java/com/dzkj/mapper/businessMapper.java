package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.business;

import tk.mybatis.mapper.common.Mapper;

public interface businessMapper extends Mapper<business>{

	List<business> findbyid(Integer id);
	
	
}
