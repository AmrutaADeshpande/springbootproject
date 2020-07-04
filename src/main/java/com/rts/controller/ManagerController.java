
package com.rts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rts.auth.exceptions.AuthenticationException;
import com.rts.auth.filter.Logged;

import com.rts.auth.utility.ErrorConstants;
import com.rts.bo.AuthRequest;
import com.rts.bo.AuthResponse;
import com.rts.bo.Response;
import com.rts.service.ManagerService;

@RestController
@RequestMapping(value = "/v1/auth")
public class ManagerController {
	
private static final Logger log = LogManager.getLogger(ManagerController.class);
	
	private final ManagerService managerService;
	
	public ManagerController(ManagerService managerService) {
		super();
		this.managerService = managerService;
	}

	@CrossOrigin
	@PostMapping(value = "/authenticate")
	public Response authenticate(@RequestBody AuthRequest authRequest) {
		Response response = new Response();
		try {
			AuthResponse authResponse = managerService.authenticate(authRequest);
			response.setStatus(ErrorConstants.SUCCESS);
			response.setResult(authResponse);
			return response;
		} catch (AuthenticationException e) {
			response.setStatus(e.getErrorCode());
			response.setMessage(e.getMessage());
			return response;
		} catch (Exception e) {
			log.error("Error In : authenticate()", e);
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.SERVER_ERROR_MSG);
			return response;
		}
	}

}
