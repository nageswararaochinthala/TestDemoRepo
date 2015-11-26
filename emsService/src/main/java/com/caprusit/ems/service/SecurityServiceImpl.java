package com.caprusit.ems.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.ISecurityDAO;
import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.utility.EmailUtility;
import com.caprusit.ems.utility.UploadExcelFileUtility;

@Service
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	private ISecurityDAO securityDAO;
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	private UploadExcelFileUtility excelFileUtility;

	private Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	public int login(Admin admin) {

		String adminPass = securityDAO.login(admin);

		int status = (adminPass.equals("notValid")) ? -1 : 0;

		status = (adminPass.equals(admin.getPassword())) ? 1 : status;

		logger.info("login status for admin: " + status);

		return status;

	}

	public int forgotPassword(int adminId, String emailId) {
		String message = securityDAO.forgotPassword(adminId, emailId);

		if (message != null && message.trim().length() > 0) {
			emailUtility.sendMail(emailId, message);
			return 1;
		} else if (message != null && message.equals("Invalid")) {
			return -1;
		}
		return 0;
	}


	public String changePassword(Admin admin) {
		String msg=securityDAO.changePassword(admin);
		return msg;
	}


	public  List<String> getOldPassword(Admin admin) {
		 List<String> oldPwd=securityDAO.getOldPassword(admin);
		return oldPwd;
	}


	public String uploadEmployeeDetailsExcelFile(InputStream excelInputStream,String fileName) {
		  
		  logger.info("in upload file(service)");
		  Workbook workbook=null;
		  String [] extensionArray=fileName.split("[.]");
		  logger.info("arrays isze: "+extensionArray.length);
		  
		  try {
		   
		      if(extensionArray[1].equals("xls")){       
		       workbook=new HSSFWorkbook(excelInputStream);    
		       logger.info("2003 file");
		      }
		      else{       
		       logger.info("2007 file");
		       workbook=new XSSFWorkbook(excelInputStream);       
		    }            

		  } 
		  catch (IOException e) {
		   
		   e.printStackTrace();
		  }
		  
		   return excelFileUtility.saveExcelFileData(workbook);
		  

		 }

}



