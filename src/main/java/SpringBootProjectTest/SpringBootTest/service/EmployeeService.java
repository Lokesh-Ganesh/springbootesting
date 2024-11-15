package SpringBootProjectTest.SpringBootTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProjectTest.SpringBootTest.model.Employee;
import SpringBootProjectTest.SpringBootTest.model.InternationalCurrency;
import SpringBootProjectTest.SpringBootTest.repository.CurrencyRepo;
import SpringBootProjectTest.SpringBootTest.repository.Employeerepo;

@Service
public class EmployeeService {
	
	@Autowired
	private Employeerepo employeeRepo;
	
	@Autowired
	private CurrencyRepo currencyRepo;

	public List<Employee> getEmployees() {
		
		return employeeRepo.findAll();
	}

	public Optional<Employee> getEmployeeById(int empId) {
		
		return employeeRepo.findById(empId);
	}

	public List<Employee> createNewEmployee(List<Employee> employee) {
		
		return employeeRepo.saveAll(employee);
	}

	public Employee updateEmployeeData(int empId, Employee employee) {
		Employee employeeDetails=getEmployeeById(empId).orElse(null);
		employeeDetails.setEmpName(employee.getEmpName());
		employeeDetails.setJobRole(employee.getJobRole());
		employeeDetails.setSalary(employee.getSalary());
		return employeeRepo.save(employeeDetails);
	}

	public void deleteEmployee(int empId) {
		
		employeeRepo.deleteById(empId);
	}

	public List<InternationalCurrency> getAllCurrency() {
		// TODO Auto-generated method stub
		return currencyRepo.findAll();
	}
  
}
