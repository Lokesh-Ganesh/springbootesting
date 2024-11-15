package SpringBootProjectTest.SpringBootTest.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import SpringBootProjectTest.SpringBootTest.model.Employee;
import SpringBootProjectTest.SpringBootTest.model.EntityClass;
import SpringBootProjectTest.SpringBootTest.model.InternationalCurrency;
import SpringBootProjectTest.SpringBootTest.service.EmployeeService;
import SpringBootProjectTest.SpringBootTest.service.FileService;


@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*")
public class HomeController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/uploadCSVFile")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws IOException
	{
		return new ResponseEntity<String>(fileService.uploadFile(file),HttpStatus.CREATED);
	}
	
	@PostMapping("/createData")
	public String createMultipleData(@RequestBody EntityClass entity) throws IOException{
		return fileService.createNewData(entity);
	}
	
	@GetMapping("/GetData")
	public List<EntityClass> getData()
	{
		return fileService.getAllData();
	}
	
	@GetMapping("/GetData/{Id}")
	public EntityClass getDataById(@PathVariable int Id)
	{
		return fileService.getDataById(Id);
	}
	
	@PutMapping("/UpdateData/{Id}")
	public EntityClass updateData(@PathVariable int Id,@RequestBody EntityClass entity){
		
		return fileService.updateData(Id,entity);
	}

//---------------------------------------------------------------------------
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmployeeDetails")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails()
	{
		return new ResponseEntity<List<Employee>>(employeeService.getEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeById/{empId}")
	public ResponseEntity<Employee> getEmployeeDetail(@PathVariable int empId)
	{
		Employee employee=employeeService.getEmployeeById(empId).orElse(null);
		
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/currency")
	public ResponseEntity<List<InternationalCurrency>> getInternationaCurrency(){
		return new ResponseEntity<List<InternationalCurrency>>(employeeService.getAllCurrency(),HttpStatus.OK);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<List<Employee>> createEmployee(@RequestBody List<Employee> employee)
	{
		return new ResponseEntity<>(employeeService.createNewEmployee(employee),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployeeById/{empId}")
	public ResponseEntity<Employee> updateEmployeeDetail(@PathVariable int empId,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeData(empId,employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployeeById/{empId}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int empId)
	{
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
