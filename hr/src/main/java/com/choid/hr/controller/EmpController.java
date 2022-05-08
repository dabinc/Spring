package com.choid.hr.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choid.hr.model.EmpDetailVO;
import com.choid.hr.model.EmpVO;
import com.choid.hr.service.IEmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private IEmpService empService;
	
	@GetMapping("/count")
	public String getEmpCount(Model model) {
		int empCount = empService.getEmpCount();
		model.addAttribute("empCount", empCount);
		return "empCount";
	}
	
	@GetMapping("/list")
	public String getEmpList(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "empList";
		//empList.jsp�� ����
	}

	@GetMapping("/info")
	public String getEmpInfo(Model model, int empId) {
		EmpDetailVO emp = (EmpDetailVO) empService.getEmpInfo(empId);
		model.addAttribute("emp", emp);
		return "empInfo";
		//empInfo.jsp 
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		model.addAttribute("jobList", empService.getAllJobList());
		model.addAttribute("manList", empService.getAllManagerList());
		model.addAttribute("deptList", empService.getAllDeptList());
		return "empInsert";
	}
	
	@PostMapping("/insert")
	public String insertEmp(EmpVO emp) {
		// spring�� request�� parameter(empvo)�� ��ü����, �˾Ƽ� �������ش�.
		empService.insertEmp(emp);
		// inseert update delete�� ���ΰ�ħ�ÿ� ������Ǵ°���
		// �����ϱ����� redirect�� controller�� �������Ͽ� ó���Ѵ�.
		return "redirect:/emp/list";
	}
	
	@GetMapping("/delete/{empId}")
	public String deleteEmp(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		model.addAttribute("deptCount", empService.getDeptCount(empId));
		model.addAttribute("mgrCount", empService.getManagerCount(empId));
		return "empDelete";
	}
	
	@PostMapping("/delete")
	public String deleteEmp(int empId) {
		empService.deleteEmp(empId);
		return "redirect:/emp/list";
	}
	
	// update insert ���� jsp���� ����, ���̸� �ֱ����� emp�� �ϳ� �� ����
	@GetMapping("/update/{empId}")
	public String updateEmp(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		model.addAttribute("jobList", empService.getAllJobList());
		model.addAttribute("manList", empService.getAllManagerList());
		model.addAttribute("deptList", empService.getAllDeptList());
		return "empInsert";
	}
	
	@PostMapping("/update")
	public String updateEmp(EmpVO emp) {
		empService.updateEmp(emp);
		return "redirect:/emp/info?empId="+emp.getEmployeeId();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeException(HttpServletRequest request, Exception e, Model model) {
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("exception", e);
		return "error/runtime";
	}
	
	@GetMapping("/ajaxtest")
	public String ajaxTest() {
		return "ajaxtest";
	}
	@PostMapping("/ajaxtest")
	@ResponseBody
	// 이 어노테이션은 페이지를 찾는게 아니라 모든 타입의 리턴값이 String 값으로 ajax.jsp에 들어간다.
	public String ajaxTest(String id) {
		return "id : " + id + "이름: 최다빈";
	}
	@PostMapping("/idCheck")
	@ResponseBody 
	// boolean true/false값 그대로 ajax로 리턴한다 
	public boolean idCheck(int empId) {
		System.out.println("hello");
		return empService.checkEmpId(empId);
	}
}
