package com.caprusit.ems.domain;

import java.io.Serializable;

public class EmployeeData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int empId;
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
