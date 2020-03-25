package com.dzkj.pojo;
//商品详情表
public class Pramater {
	private Integer id;
	private String country;
	private String imgurl;
	private product pro;
	public Pramater() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public product getPro() {
		return pro;
	}
	public void setPro(product pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "Pramater [id=" + id + ", country=" + country + ", imgurl=" + imgurl + ", pro=" + pro + "]";
	}
	
	
	
	
	
}
