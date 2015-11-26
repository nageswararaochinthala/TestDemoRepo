package com.caprusit.ems.dao;

import java.util.List;

public interface ValidationDAO {
	public List<Object> getAllEmploeeIds();

	public List<Object> getLoggedInEmployeeIds();

	public List<Object> getLoggedOutEmoloyeeIds();

}
