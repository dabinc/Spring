package com.choid.hr.model;

public class EmpDetailVO extends EmpVO{
//empVO에서 상속받아서 left join 이후 필요한 두가지 필드만 생성하면 됨
	private String managerName;
	private String departmentName;
	private String jobTitle;
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getjobTitle() {
		return jobTitle;
		// TODO Auto-generated method stub
	}
	
}
