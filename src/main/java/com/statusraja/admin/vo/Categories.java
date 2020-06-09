package com.statusraja.admin.vo;

public class Categories {

	private Integer categoryid;
	private String name;
	private String type;

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Categories [categoryid=" + categoryid + ", name=" + name + ", type=" + type + "]";
	}

}
