package com.choid.hr.model;

public class EmpDetailVO extends EmpVO{
//empVO���� ��ӹ޾Ƽ� left join ���� �ʿ��� �ΰ��� �ʵ常 �����ϸ� ��
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
