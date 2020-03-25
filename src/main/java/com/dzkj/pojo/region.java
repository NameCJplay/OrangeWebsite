package com.dzkj.pojo;

public class region {
	private Integer region_id;
	private String region_code;
	private String region_name;
	private Integer parent_id;
	private Integer region_level;
	private Integer region_order;
	private String region_name_en;
	private String region_shortname_en;
	public Integer getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getRegion_level() {
		return region_level;
	}
	public void setRegion_level(Integer region_level) {
		this.region_level = region_level;
	}
	public Integer getRegion_order() {
		return region_order;
	}
	public void setRegion_order(Integer region_order) {
		this.region_order = region_order;
	}
	public String getRegion_name_en() {
		return region_name_en;
	}
	public void setRegion_name_en(String region_name_en) {
		this.region_name_en = region_name_en;
	}
	public String getRegion_shortname_en() {
		return region_shortname_en;
	}
	public void setRegion_shortname_en(String region_shortname_en) {
		this.region_shortname_en = region_shortname_en;
	}
	public region(Integer region_id, String region_code, String region_name, Integer parent_id, Integer region_level,
			Integer region_order, String region_name_en, String region_shortname_en) {
		super();
		this.region_id = region_id;
		this.region_code = region_code;
		this.region_name = region_name;
		this.parent_id = parent_id;
		this.region_level = region_level;
		this.region_order = region_order;
		this.region_name_en = region_name_en;
		this.region_shortname_en = region_shortname_en;
	}
	public region() {
		super();
	}
	@Override
	public String toString() {
		return "region [region_id=" + region_id + ", region_code=" + region_code + ", region_name=" + region_name
				+ ", parent_id=" + parent_id + ", region_level=" + region_level + ", region_order=" + region_order
				+ ", region_name_en=" + region_name_en + ", region_shortname_en=" + region_shortname_en + "]";
	}
	
}
