package com.dzkj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dzkj.pojo.Foot;
import com.dzkj.pojo.business;

import tk.mybatis.mapper.common.Mapper;

public interface FootMapper{

	List<Foot> Findall(Integer userid);
	
	boolean addfoot(Foot foot);
	
	boolean Delfoot(Integer id);
	
}
