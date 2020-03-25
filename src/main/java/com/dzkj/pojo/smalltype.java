package com.dzkj.pojo;

import java.util.List;
//分类表
public class smalltype {
	private Integer id;
	private String type;
	private Integer tag;
	private List<smalltype> slist;
	private List<product> plist;
	private List<business> buslist;
	public List<business> getBuslist() {
		return buslist;
	}
	public void setBuslist(List<business> buslist) {
		this.buslist = buslist;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	public List<smalltype> getSlist() {
		return slist;
	}
	public void setSlist(List<smalltype> slist) {
		this.slist = slist;
	}
	public List<product> getPlist() {
		return plist;
	}
	public void setPlist(List<product> plist) {
		this.plist = plist;
	}
	public smalltype(Integer id, String type, Integer tag, List<smalltype> slist, List<product> plist) {
		super();
		this.id = id;
		this.type = type;
		this.tag = tag;
		this.slist = slist;
		this.plist = plist;
	}
	
	@Override
	public String toString() {
		return "smalltype [id=" + id + ", type=" + type + ", tag=" + tag + ", slist=" + slist + ", plist=" + plist
				+ ", buslist=" + buslist + "]";
	}
	public smalltype() {
		super();
	}
	
	
	
	
}
