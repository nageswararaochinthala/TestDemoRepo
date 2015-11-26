package com.caprusit.ems.service;

import java.io.InputStream;
import java.util.List;

import com.caprusit.ems.domain.Admin;

public interface ISecurityService {
	public int login(Admin admin);
	public int forgotPassword(int adminId,String emailId);
	public String changePassword(Admin admin);
	public  List<String> getOldPassword(Admin admin);
	public String  uploadEmployeeDetailsExcelFile(InputStream excelInputStream, String fileName);
}
