package com.rts.auth.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rts.auth.dal.AbstractDao;


@Transactional
@Repository("userDAO")
public class UserDAOImpl {

	private static Logger log = LogManager.getLogger();
	
	
}