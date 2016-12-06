package com.entity;

public class Employees {
	private int employee_id;
	private String employee_name;
	private String employee_login_id;
	private String employee_login_password;
	private String employee_role;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employeeId) {
		employee_id = employeeId;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employeeName) {
		employee_name = employeeName;
	}
	public String getEmployee_login_id() {
		return employee_login_id;
	}
	public void setEmployee_login_id(String employeeLoginId) {
		employee_login_id = employeeLoginId;
	}
	public String getEmployee_login_password() {
		return employee_login_password;
	}
	public void setEmployee_login_password(String employeeLoginPassword) {
		employee_login_password = employeeLoginPassword;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employeeRole) {
		employee_role = employeeRole;
	}
}
