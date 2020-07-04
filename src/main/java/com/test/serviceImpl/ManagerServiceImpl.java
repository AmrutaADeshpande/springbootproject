
package com.test.serviceImpl;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rts.auth.dal.ObjectDao;
import com.rts.auth.exceptions.AuthenticationException;

import com.rts.auth.utility.AppConstants;
import com.rts.auth.utility.ErrorConstants;

import com.rts.bo.AuthRequest;
import com.rts.bo.AuthResponse;
import com.rts.model.Manager;
import com.rts.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ObjectDao objectDao;
	
	
	// insert manager details.
	@Override
	public void addManeger(Manager manager) throws Exception {
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");			
			if(null != manager && null != manager.getDob())
				manager.setDobstr(sdf.format(manager.getDob()));		
		     objectDao.saveObject(manager);	
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
	}


	@Override
	public AuthResponse authenticate(AuthRequest authRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
