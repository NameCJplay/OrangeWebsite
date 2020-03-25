package com.dzkj.pojo;
//足迹表
public class Foot {
	private Integer id;
	private Integer userid;
	private product prd;
	private String  foottime ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public product getPrd() {
		return prd;
	}
	public void setPrd(product prd) {
		this.prd = prd;
	}
	public String getFoottime() {
		return foottime;
	}
	public void setFoottime(String foottime) {
		this.foottime = foottime;
	}
	public Foot() {
		super();
	}
	
	public Foot(Integer id, Integer userid, product prd, String foottime) {
		super();
		this.id = id;
		this.userid = userid;
		this.prd = prd;
		this.foottime = foottime;
	}
	@Override
	public String toString() {
		return "Foot [id=" + id + ", userid=" + userid + ", prd=" + prd + ", foottime=" + foottime + "]";
	}

			
	
}
