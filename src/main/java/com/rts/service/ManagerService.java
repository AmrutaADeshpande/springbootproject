
package com.rts.service;

import com.rts.bo.AuthRequest;
import com.rts.bo.AuthResponse;
import com.rts.model.Manager;

public interface ManagerService {

	public void addManeger(Manager manager) throws Exception;
	
	public AuthResponse authenticate(AuthRequest authRequest) throws Exception;
}
