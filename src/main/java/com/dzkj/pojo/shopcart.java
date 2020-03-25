package com.dzkj.pojo;

public class shopcart {
	private int sid ;//序列号
	 private int userid; //用户id
	 private int  nums;   //数量
	private product product;     //商品id
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public shopcart(int sid, int userid, int nums, product product) {
		super();
		this.sid = sid;
		this.userid = userid;
		this.nums = nums;
		this.product = product;
	}
	public shopcart() {
		super();
	}
	@Override
	public String toString() {
		return "shopcart [sid=" + sid + ", userid=" + userid + ", nums=" + nums + ", product=" + product + "]";
	}
	
}
