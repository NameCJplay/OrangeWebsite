package com.dzkj.pojo;

//店铺表
public class business {
	private Integer b_id;
	private String b_name;
	private Integer b_typeid;
	private String storetype;
	private String b_desc;
	public Integer getB_id() {
		return b_id;
	}
	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public Integer getB_typeid() {
		return b_typeid;
	}
	public void setB_typeid(Integer b_typeid) {
		this.b_typeid = b_typeid;
	}
	public String getStoretype() {
		return storetype;
	}
	public void setStoretype(String storetype) {
		this.storetype = storetype;
	}
	public String getB_desc() {
		return b_desc;
	}
	public void setB_desc(String b_desc) {
		this.b_desc = b_desc;
	}
	public business() {
		super();
	}
	@Override
	public String toString() {
		return "business [b_id=" + b_id + ", b_name=" + b_name + ", b_typeid=" + b_typeid + ", storetype=" + storetype
				+ ", b_desc=" + b_desc + "]";
	}
	
	
	
}
