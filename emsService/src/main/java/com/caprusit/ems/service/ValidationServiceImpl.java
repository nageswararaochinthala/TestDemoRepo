package com.caprusit.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.ValidationDAO;
import com.caprusit.ems.domain.EmployeeData;
import com.caprusit.ems.utility.JsonUtility;

@Service
public class ValidationServiceImpl implements ValidationService {
	@Autowired
	private ValidationDAO validationDAO;
	private Logger logger = Logger.getLogger(ValidationServiceImpl.class);

	public String getAllEmployeeIds() {
		logger.info("inside ValidationServiceImpl getAllEmployeeIds()");
		List<Object> allEmpData = validationDAO.getAllEmploeeIds();
		List<EmployeeData> listOfAllEmpIds = new ArrayList<EmployeeData>();
		for (Object data : allEmpData) {

			Object[] array = (Object[]) data;
			EmployeeData emp = new EmployeeData();
			emp.setEmpId((Integer) array[0]);
			emp.setEmpName((String) array[1] + " " + (String) array[2]);
			listOfAllEmpIds.add(emp);
		}
		return JsonUtility.convertToJson(listOfAllEmpIds);
	}

	public String getLoggedInEmoloyeeIds() {

		logger.info("inside ValidationServiceImpl getLoggedInEmoloyeeIds()");

		List<Object> loggedInList = validationDAO.getLoggedInEmployeeIds();
		logger.info("list size loggedinemp" + loggedInList.size());

		return JsonUtility.convertToJson(loggedInList);
	}

	public String getLoggedOutEmployeeIds() {
		logger.info("inside ValidationServiceImpl getLoggedOutEmployeeIds()");
		List<Object> loggedOutList = validationDAO.getLoggedOutEmoloyeeIds();
		logger.info("list size logged out emp" + loggedOutList.size());
		return JsonUtility.convertToJson(loggedOutList);
	}

	
}
