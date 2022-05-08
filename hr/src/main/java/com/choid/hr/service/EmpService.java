package com.choid.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choid.hr.dao.IEmpRepository;
import com.choid.hr.model.DeptVO;
import com.choid.hr.model.EmpVO;
import com.choid.hr.model.JobVO;

@Service
public class EmpService implements IEmpService {

	
	@Autowired
	@Qualifier("IEmpRepository")
	private IEmpRepository empRepository;
	
	@Override
	public int getEmpCount() {
		// repository�� method�� ȣ����� �������ִ� ���°� �ɰ���
		return empRepository.getEmpCount();
	}

	@Override
	public List<EmpVO> getEmpList() {
		return empRepository.getEmpList();
	}

	@Override
	public EmpVO getEmpInfo(int empId) {	
		return empRepository.getEmpInfo(empId);
	}
	
	@Override
	public int getManagerCount(int empId) {	
		return empRepository.getManagerCount(empId);
	}
	
	@Override
	public int getDeptCount(int managerId) {	
		return empRepository.getDeptCount(managerId);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		empRepository.insertEmp(emp);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		empRepository.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int empId) {
		empRepository.nullify1(empId);
		empRepository.nullify2(empId);
		empRepository.deleteJobHistory(empId) ;
		empRepository.deleteEmp(empId);
	}

	@Override
	public List<JobVO> getAllJobList() {
		return empRepository.getAllJobList();
	}

	@Override
	public List<EmpVO> getAllManagerList() {
		return empRepository.getAllManagerList();
	}

	@Override
	public List<DeptVO> getAllDeptList() {
		return empRepository.getAllDeptList();
	}

	@Override
	public boolean checkEmpId(int empId) {
		// TODO Auto-generated method stub
		return empRepository.checkEmpId(empId) == 0;
		// 중복이 없다는 뜻
	}

}
