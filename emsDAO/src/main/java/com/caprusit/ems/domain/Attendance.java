package com.caprusit.ems.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "attendance_table")
public class Attendance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="increment" , strategy="increment")
	@GeneratedValue(generator="increment")
	private int attendanceId;
	
	private int employeeId;

	@Temporal(TemporalType.DATE)
	private Date attendanceDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	private double workingHours;

	private int dayIndicator;

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(long workingHours) {
		this.workingHours = workingHours;
	}

	public int getDayIndicator() {
		return dayIndicator;
	}

	public void setDayIndicator(int dayIndicator) {
		this.dayIndicator = dayIndicator;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceId=" + attendanceId + ", employeeId=" + employeeId + ", attendanceDate="
				+ attendanceDate + ", startTime=" + startTime + ", endTime=" + endTime + ", workingHours="
				+ workingHours + ", dayIndicator=" + dayIndicator + "]";
	}

}
