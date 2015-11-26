package com.caprusit.ems.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.caprusit.ems.domain.Admin;
import com.caprusit.ems.service.ISecurityService;
import com.google.gson.Gson;

@Controller
public class SecurityController {

	@Autowired
	private ISecurityService securityService;

	private Logger logger = Logger.getLogger(SecurityController.class);

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		return "AdminLogin";
	}

	@RequestMapping(value = "/adminHome", method = RequestMethod.POST)
	public @ResponseBody Integer adminLogin(@RequestBody Admin admin, HttpServletRequest request) {

		logger.info("in admin security controller");
		logger.info("admin username: " + admin.getAdminId() + " password: " + admin.getPassword());

		int status = securityService.login(admin);
		if (status == 1)
			request.getSession().setAttribute("adminId", admin.getAdminId());

		return status;
	}

	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET)
	public ModelAndView getAdminHomePage(HttpServletRequest request) {

		logger.info("inside getAdminHomePage()");

		HttpSession session = request.getSession(false);

		logger.info("session: " + session);
		if (session != null)
			logger.info("admin id in session: " + session.getAttribute("adminId"));

		return ((session != null) && (session.getAttribute("adminId") != null)) ? new ModelAndView("AdminDashBoard")
				: new ModelAndView("AdminLogin");

	}

	@RequestMapping(value = "/adminLogout", method = RequestMethod.GET)
	public String adminLogout(HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		if (session != null) {
			logger.info("invalidating session ");
			session.invalidate();
		}

		logger.error("admin logout successfull :" + request.getSession(false));

		return "AdminLogin";

	}

	@RequestMapping(value = "/uploadEmployeeDetailsExcelFile", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody String uploadEmployeeDetailsExcelFile(MultipartHttpServletRequest request) {

		logger.info("inside uploadEmployeeDetailsExcelFile()");
		Iterator<String> itr = request.getFileNames();
		@SuppressWarnings("unused")
		MultipartFile file = request.getFile(itr.next());
		String result = new String();
		logger.info("result : " + result);
		return result;
	}

	@RequestMapping(value = "/forgotPasswordPage", method = RequestMethod.GET)
	public String getForgotPasswordPage(HttpServletRequest request) {
		logger.info("inside getForgotPasswordPage()");
		return "ForgotPassword";
	}

	@RequestMapping(value = "/forgotPasswordHome", method = RequestMethod.POST)
	public @ResponseBody Integer forgotPassword(@RequestParam("id") Integer adminId,
			@RequestParam("email") String emailId) {
		logger.info("in admin forgot password:  id: " + adminId + "    email: " + emailId);
		int status = securityService.forgotPassword(adminId, emailId);
		return status;
	}

	/*
	 * changePassword() method implementation This method takes current password
	 * and new password as parameter and after checking all the conditions it
	 * returns either a successful or an error message to the browser
	 */
	@RequestMapping(value = "/changePassword.do", method = RequestMethod.POST)
	public @ResponseBody String changePassword(HttpServletRequest request, @RequestParam("cpwd") String oldPassword,
			@RequestParam("npwd") String newPassword) {

		int adminId = (Integer) request.getAttribute("adminId");
		logger.info("In change Password:" + adminId);
		logger.info(oldPassword + "   " + newPassword);

		String targetView = "/WEB-INF/views/ChangePassword.jsp";
		String status = "";

		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(oldPassword);
		logger.info(admin);
		List<String> oldPwd = securityService.getOldPassword(admin);
		logger.info("oldPwd " + oldPwd);
		logger.info(oldPwd.get(0));

		// condition to match for old password and user given password
		if (oldPwd.get(0).equals(oldPassword)) {
			logger.info("both pwd matching");
			Admin admin1 = new Admin();
			admin1.setPassword(newPassword);
			// If both pasword matched, then will call changePassword() method
			String statusMsg = securityService.changePassword(admin1);
			logger.info(statusMsg);
			return getJsonArray(statusMsg);
		}
		/**
		 * If both pasword not matched, then it returns the corresponding
		 * response to jsp page
		 */
		else {
			status = "current-password is not matched with  old-password ";
			logger.info(status);
			ModelAndView modelAndView = new ModelAndView(targetView, "status", status);
			logger.info(" modelAndView  " + modelAndView);
			return getJsonArray(status);
		}

	}

	/**
	 * getJsonArray() used to convert Object to String, so that we will send
	 * this String to other layer
	 * 
	 * @param obj
	 * @return
	 */

	private String getJsonArray(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);

	}

	@RequestMapping(value = "/changePassword.do", method = RequestMethod.GET)
	public String getChangepasspage() {

		return "ChangePassword";
	}

}
