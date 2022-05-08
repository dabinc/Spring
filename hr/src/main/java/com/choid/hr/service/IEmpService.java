package com.choid.hr.service;

import java.util.List;

import com.choid.hr.model.DeptVO;
import com.choid.hr.model.EmpVO;
import com.choid.hr.model.JobVO;

public interface IEmpService {

	
	int getEmpCount();
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empId);
	void insertEmp(EmpVO emp);
	void updateEmp(EmpVO emp);
	void deleteEmp(int empId);

	List<JobVO> getAllJobList();
	List<EmpVO> getAllManagerList();
	List<DeptVO> getAllDeptList();
	int getManagerCount(int empId);
	int getDeptCount(int managerId);
	boolean checkEmpId(int empId);
}
