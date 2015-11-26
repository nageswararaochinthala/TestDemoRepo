package com.caprusit.ems.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caprusit.ems.service.ValidationService;

@Controller
public class ValidationController {

	@Autowired
	private ValidationService validationservice;
	private Logger logger = Logger.getLogger(ValidationController.class);

	@RequestMapping(value = "/getAllEmpIds", method = RequestMethod.POST)
	public @ResponseBody String getAllEmployeeIds() {

		logger.info("inside validationController getAllEmpIds()");
		return validationservice.getAllEmployeeIds();

	}

	@RequestMapping(value = "/getLoggedInEmpIds", method = RequestMethod.POST)
	public @ResponseBody String getLoggedInEmployeeIds() {

		logger.info("inside validationController getLoggedInEmployeeIds()");
		return validationservice.getLoggedInEmoloyeeIds();

	}

	@RequestMapping(value = "/getLoggedOutEmpIds", method = RequestMethod.POST)
	public @ResponseBody String getLoggedOutEmployeeIds() {

		logger.info("inside validationController getLoggedOutEmployeeIds()");
		return validationservice.getLoggedOutEmployeeIds();

	}

}
