package com.caprusit.ems.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caprusit.ems.dao.IAttendanceDAO;
import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.LoginTest;
import com.caprusit.ems.domain.User;

@Service
public class AttendanceServiceImpl implements IAttendanceService {
	@Autowired
	private IAttendanceDAO attendanceDAO;
	private Logger logger=Logger.getLogger(AttendanceServiceImpl.class);
	
	public int logInOrLogOut(LoginTest test) {
		User user = new User();
		user.setEid(test.getId());

		if (test.getType().equalsIgnoreCase("login")) {

			logger.info("login executing ");

			Attendance att = new Attendance();
			Date date = new Date();

			att.setAttendanceDate(date);
			att.setAttendanceId(34);
			att.setDayIndicator(1);
			att.setStartTime(date);
			att.setWorkingHours(0);
			att.setEmployeeId(user.getEid());
			return attendanceDAO.inTime(att);
		} else
			return attendanceDAO.outTime(user);
	}

}
