package com.statusraja.admin.vo;

public class Languages {

	private Integer langid;
	private String name;

	public Integer getLangid() {
		return langid;
	}

	public void setLangid(Integer langid) {
		this.langid = langid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Languages [langid=" + langid + ", name=" + name + "]";
	}

}
