package com.dzkj.pojo;

import java.util.Vector;

import javax.persistence.Id;

public class orderss {
	@Id
	private Integer oid;
	private Integer userid;
	private String nums;
	private String time;
	private Integer id;
	private Integer statu;
	private product product;
	private Integer shuliang;
	private Integer money;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public Integer getShuliang() {
		return shuliang;
	}
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public orderss(Integer oid, Integer userid, String nums, String time, Integer id, Integer statu,
			com.dzkj.pojo.product product, Integer shuliang, Integer money) {
		super();
		this.oid = oid;
		this.userid = userid;
		this.nums = nums;
		this.time = time;
		this.id = id;
		this.statu = statu;
		this.product = product;
		this.shuliang = shuliang;
		this.money = money;
	}
	public orderss() {
		super();
	}
	@Override
	public String toString() {
		return "orderss [oid=" + oid + ", userid=" + userid + ", nums=" + nums + ", time=" + time + ", id=" + id
				+ ", statu=" + statu + ", product=" + product + ", shuliang=" + shuliang + ", money=" + money + "]";
	}
	

}
