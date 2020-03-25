package com.dzkj.pojo;
//我的收藏夹
public class collector {
	private int cid;
	private users users;
	private product product;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public users getUsers() {
		return users;
	}
	public void setUsers(users users) {
		this.users = users;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public collector(int cid, com.dzkj.pojo.users users, com.dzkj.pojo.product product) {
		super();
		this.cid = cid;
		this.users = users;
		this.product = product;
	}
	public collector() {
		super();
	}
	@Override
	public String toString() {
		return "collector [cid=" + cid + ", users=" + users + ", product=" + product + "]";
	}
	

}
