package com.caprusit.ems.dao;

import com.caprusit.ems.domain.Attendance;
import com.caprusit.ems.domain.User;

public interface IAttendanceDAO {
	public int inTime(Attendance attendance);

	public int outTime(User user);
}
