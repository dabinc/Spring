package com.choid.hr.dao;

import java.util.List;

import com.choid.hr.model.DeptVO;
import com.choid.hr.model.EmpVO;
import com.choid.hr.model.JobVO;

public interface IEmpRepository {

		int getEmpCount();
		List<EmpVO> getEmpList();
		EmpVO getEmpInfo(int empId);
		void insertEmp(EmpVO emp);
		void updateEmp(EmpVO emp);
		void deleteEmp(int empId);
		void deleteJobHistory(int empId);
		
		List<JobVO> getAllJobList();
		List<EmpVO> getAllManagerList();
		List<DeptVO> getAllDeptList();
		int getManagerCount(int empId);
		int getDeptCount(int empId);
		void nullify1(int empId);
		void nullify2(int empId);
		int checkEmpId(int empId);
		
}
