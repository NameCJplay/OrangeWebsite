package com.dzkj.mapper;

import java.util.List;

import com.dzkj.pojo.smalltype;

public interface smalltypeMapper {
	List<smalltype> FindOne();
	List<smalltype> FindTwo(Integer tago);
	List<smalltype> Findall();
	List<smalltype> Search(String text);
	
}
