package com.statusraja.admin.enums;

public enum SRStatusEnum {

	ACTIVE(1, "ACTIVE"), DELETE(2, "DELETE");

	private int id;
	private String name;

	private SRStatusEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	static SRStatusEnum[] values = values();

	public static SRStatusEnum getName(int id) {
		for (SRStatusEnum value : values) {
			if (value.getId() == id)
				return value;
		}
		return null;
	}
}
