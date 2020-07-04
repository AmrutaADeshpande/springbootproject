
package com.rts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rts.auth.exceptions.AuthenticationException;
import com.rts.auth.utility.ErrorConstants;
import com.rts.bo.PaginationBo;
import com.rts.bo.Response;
import com.rts.dao.EmployeeDao;
import com.rts.model.Employee;
import com.rts.service.EmployeeService;


@RestController
@RequestMapping(value = "/v1/employee")
public class EmployeeController {
	
	private static final Logger log = LogManager.getLogger(EmployeeController.class);
	private final EmployeeService employeeService;
     private final EmployeeDao employeeDao;
	
	public EmployeeController(EmployeeService employeeService, EmployeeDao employeeDao) {
		super();
		this.employeeService = employeeService;
		this.employeeDao = employeeDao;
	}


	@CrossOrigin
	@PostMapping(value = "/addemployee")
	public Response addEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		try {
			employeeService.addEmployee(employee);
			response.setStatus(ErrorConstants.SUCCESS);
			response.setMessage("Employee added successfully");
			response.setResult(employee);
			return response;
		} catch (Exception e) {
			log.error("ERROR IN addEmployee(): ", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.SERVER_ERROR_MSG);
			return response;
		}
	}
	

	@CrossOrigin
	@GetMapping("/details/{empId}")
	public Response employeeDetails(@PathVariable("empId") Long empId) {
		Response response = new Response();
		try {
			
			response.setStatus(ErrorConstants.SUCCESS);
			response.setMessage("Employee details");
			response.setResult(employeeService.getemployeedetails(empId));
			return response;
		} catch (Exception e) {
			log.error("Error In : ", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.SERVER_ERROR_MSG);
			return response;
		}
	}

	@CrossOrigin
	@PutMapping("/editemployee")
	public Response editEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		try {
			employeeService.updateEmployee(employee);
			response.setStatus(ErrorConstants.SUCCESS);
			response.setMessage("Employee updated successfully");
			return response;
		} catch (AuthenticationException ae) {
			response.setStatus(ae.getErrorCode());
			response.setMessage(ae.getMessage());
			return response;
		} catch (Exception e) {
			log.error("ERROR IN editEmployee(): ", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.SERVER_ERROR_MSG);
			return response;
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/{empId}")
	public Response deleteEmployee(@PathVariable("empId") Long empId) throws Exception {
		Response response = new Response();
		try {
			employeeService.deleteEmployee(empId);
			response.setMessage("Employee deleted Successfully");
			response.setStatus(ErrorConstants.SUCCESS);
			return response;

		} catch (Exception e) {
			log.error("ERROR IN deleteEmployee(): ", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			return response;
		}

	}

	@CrossOrigin
	@PostMapping("/list")
	public Response listEmployee(@RequestBody PaginationBo paginationBo) {
		Response response = new Response();
		try {
			response.setStatus(ErrorConstants.SUCCESS);
			response.setMessage("listEmployee");
			response.setResult(employeeDao.listEmployee(paginationBo));
			return response;
		} catch (Exception e) {
			log.error("ERROR IN listEmployee() : ", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.SERVER_ERROR_MSG);
			response.setResult(e.getMessage());
			return response;
		}
	}
	
	
	

	
	
	

}
