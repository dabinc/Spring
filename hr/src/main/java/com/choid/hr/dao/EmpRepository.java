package com.choid.hr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.choid.hr.model.DeptVO;
import com.choid.hr.model.EmpDetailVO;
import com.choid.hr.model.EmpVO;
import com.choid.hr.model.JobVO;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private class EmpMapper implements RowMapper<EmpVO> {

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString(5));
			
			emp.setHireDate(rs.getDate(6));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble(8));
			emp.setComissionPct(rs.getDouble(9));
			emp.setManagerId(rs.getInt(10));
			emp.setDepartmentId(rs.getInt(11));
			
			return emp;
		}
		
	}
	
	@Override
	public int getEmpCount() {
		String sql = "select count(*) from employees";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<EmpVO> getEmpList() {
		String sql = "select * from employees order by employee_id";
		return jdbcTemplate.query(sql, new EmpMapper());
	}
	
	
	
	
	@Override
	public EmpVO getEmpInfo(int empId) {
		String sql = "select employee_id, first_name, last_name, email, "
				+ "phone_number, hire_date, e.job_id, salary, commission_pct, e.manager_id,"
				+ " e.department_id, manager_name, department_name, job_title from employees e"
				+ " left join (select employee_id as manager_id, first_name||' '||last_name"
				+ " as manager_name from employees where employee_id in (select distinct"
				+ " manager_id from employees)) m on e.manager_id = m.manager_id"
				+ " left join departments d on e.department_id = d.department_id"
				+ " left join jobs j on e.job_id = j.job_id"
				+ " where employee_id=?";
				
		return jdbcTemplate.queryForObject(sql, new RowMapper<EmpDetailVO>() {

			@Override
			public EmpDetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpDetailVO emp = new EmpDetailVO();// TODO Auto-generated method stub
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString(5));
				
				emp.setHireDate(rs.getDate(6));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble(8));
				emp.setComissionPct(rs.getDouble(9));
				emp.setManagerId(rs.getInt(10));
				emp.setDepartmentId(rs.getInt(11));
				emp.setManagerName(rs.getString("manager_name"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setjobTitle(rs.getString("job_title"));
				
				return emp;
			}
			
		}, empId);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, emp.getEmployeeId(), emp.getFirstName(), 
				emp.getLastName(),emp.getEmail(), emp.getPhoneNumber(),
				emp.getHireDate(), emp.getJobId(), emp.getSalary(), 
				emp.getComissionPct(), emp.getManagerId(), emp.getDepartmentId());
	}

	@Override
	public void updateEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmp(int empId) {
		// transaction ���� ó���ؾ���. delete�Ҷ� fk�� dependency������
		String sql = "delete from employees where employee_id=?";
		jdbcTemplate.update(sql, empId);
	}

	@Override
	public void deleteJobHistory(int empId) {
		String sql = "delete from job_history where employee_id=?";
		jdbcTemplate.update(sql, empId);
	}

	@Override
	public List<JobVO> getAllJobList() {
		List<JobVO> jobs = null;
		String sql = "select job_id, job_title from jobs";
		return jdbcTemplate.query(sql, new RowMapper<JobVO>() {

			@Override
			public JobVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobVO jobs = new JobVO();
				jobs.setJobId(rs.getString("job_id"));
				jobs.setJobTitle(rs.getString("job_title"));
				return jobs;
			}
			
		});
		
	}

	@Override
	public List<EmpVO> getAllManagerList() {
		String sql = "select employee_id, first_name||' '||last_name as manager_name "
				+ "from employees where employee_id in "
				+ "(select distinct manager_id from employees)";
		return jdbcTemplate.query(sql, new RowMapper<EmpVO> () {

			@Override
			public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("manager_name"));
				return emp;
			}	
		});
	}

	@Override
	public List<DeptVO> getAllDeptList() {
		String sql = "select department_id, department_name from departments";
		return jdbcTemplate.query(sql, new RowMapper<DeptVO>() {

			@Override
			public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				DeptVO dept = new DeptVO();
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setDepartmentId(rs.getInt("department_id"));
				return dept;
			}
			
		});
		
	}
	
	@Override
	public int getManagerCount(int empId) {
		String sql = "select count(*) from employees where manager_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, empId);
	}
	
	@Override
	public int getDeptCount(int empId) {
		String sql = "select count(*) from departments where manager_id=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, empId);
	}
	
	

	@Override
	public void nullify1(int empId) {
		String sql1 = "update departments set manager_id = NULL where manager_id =?";
		jdbcTemplate.update(sql1, empId);	
	}
	
	@Override
	public void nullify2(int empId) {
		String sql2 = "update employees set manager_id = NULL where manager_id =?";
		jdbcTemplate.update(sql2, empId);	
	}

	@Override
	public int checkEmpId(int empId) {
		// TODO Auto-generated method stub
		return 1;
	}
}
