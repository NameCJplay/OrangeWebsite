package com.dzkj.pojo;

import java.util.List;

import javax.persistence.Id;

public class product {
	@Id
	private Integer pid;
	private String pname;
	private Integer price;
	private String imgurl;
	private Integer inventory;
	private Integer smalltype_id;
	private String chuchandi;
	private smalltype st;
	private List<Pramater> pralist;
	private Proparameter parame;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getSmalltype_id() {
		return smalltype_id;
	}
	public void setSmalltype_id(Integer smalltype_id) {
		this.smalltype_id = smalltype_id;
	}
	public String getChuchandi() {
		return chuchandi;
	}
	public void setChuchandi(String chuchandi) {
		this.chuchandi = chuchandi;
	}
	
	public smalltype getSt() {
		return st;
	}
	public void setSt(smalltype st) {
		this.st = st;
	}
	public List<Pramater> getPralist() {
		return pralist;
	}
	public void setPralist(List<Pramater> pralist) {
		this.pralist = pralist;
	}
	public Proparameter getParame() {
		return parame;
	}
	public void setParame(Proparameter parame) {
		this.parame = parame;
	}

	public product(Integer pid, String pname, Integer price, String imgurl, Integer inventory, Integer smalltype_id,
			String chuchandi, smalltype st, List<Pramater> pralist, Proparameter parame) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.imgurl = imgurl;
		this.inventory = inventory;
		this.smalltype_id = smalltype_id;
		this.chuchandi = chuchandi;
		this.st = st;
		this.pralist = pralist;
		this.parame = parame;
	}
	public product() {
		super();
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", imgurl=" + imgurl + ", inventory="
				+ inventory + ", smalltype_id=" + smalltype_id + ", chuchandi=" + chuchandi + ", st=" + st
				+ ", pralist=" + pralist + ", parame=" + parame + "]";
	}

	
	
}
