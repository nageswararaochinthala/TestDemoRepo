package com.caprusit.ems.dao;

import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.User;

@Repository
public class AttendanceDAOImpl implements IAttendanceDAO {
	@Autowired
	private SessionFactory factory;
	private Logger logger= Logger.getLogger(AttendanceDAOImpl .class);
	
	public int inTime(Attendance attendance) {
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		session.save(attendance);
		ts.commit();
		session.close();
		return 1;
	}
	public int outTime(User user) {
		Session session = factory.openSession();
		Query updateEndTime = session.createQuery(
				"update Attendance set endTime = :endtime where attendanceDate = :attendancedate and employeeId = :empId");
		updateEndTime.setParameter("endtime", new Date());
		updateEndTime.setParameter("attendancedate", getTodayDate());
		updateEndTime.setParameter("empId", user.getEid());

		Query updateWorkingHours = session.createQuery(
				"update Attendance a set a.workingHours=(select (b.endTime - b.startTime)*24 from Attendance b where b.attendanceDate = ? and b.employeeId = ?) where a.attendanceDate = ? and a.employeeId = ?");
		updateWorkingHours.setParameter(0, getTodayDate());
		updateWorkingHours.setParameter(1, user.getEid());
		updateWorkingHours.setParameter(2, getTodayDate());
		updateWorkingHours.setParameter(3, user.getEid());

		Transaction ts = session.beginTransaction();

		int res = updateEndTime.executeUpdate();
		int res2 = updateWorkingHours.executeUpdate();
		ts.commit();
		session.close();
		logger.info("operation upate end time: " + res);
		logger.info("hors worked: " + res2);
		return res + res2;
	}

	private Date getTodayDate() {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();

	}

}
