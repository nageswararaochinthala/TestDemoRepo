package com.caprusit.ems.domain;

import java.io.Serializable;

public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	private int rollId;
	private String rollType;
	
	public int getRollId() {
		return rollId;
	}
	public void setRollId(int rollId) {
		this.rollId = rollId;
	}
	public String getRollType() {
		return rollType;
	}
	public void setRollType(String rollType) {
		this.rollType = rollType;
	}
	@Override
	public String toString() {
		return "Role [rollId=" + rollId + ", rollType=" + rollType + "]";
	}
}
