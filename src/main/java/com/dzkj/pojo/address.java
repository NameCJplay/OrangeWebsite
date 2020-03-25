package com.dzkj.pojo;

public class address {
	private Integer aid;
	private Integer userid;
	private String consignee;
	private String tel;
	private String sheng;
	private String city;
	private String county;
	private String delivery;
	private String state;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public address(Integer aid, Integer userid, String consignee, String tel, String sheng, String city, String county,
			String delivery, String state) {
		super();
		this.aid = aid;
		this.userid = userid;
		this.consignee = consignee;
		this.tel = tel;
		this.sheng = sheng;
		this.city = city;
		this.county = county;
		this.delivery = delivery;
		this.state = state;
	}
	public address() {
		super();
	}
	@Override
	public String toString() {
		return "address [aid=" + aid + ", userid=" + userid + ", consignee=" + consignee + ", tel=" + tel + ", sheng="
				+ sheng + ", city=" + city + ", county=" + county + ", delivery=" + delivery + ", state=" + state + "]";
	}
	
}
