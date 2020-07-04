package com.rts.auth.dal;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;




public class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DataSource dataSource;
	
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	public <T> T getObjectById(Class<T> entity, Serializable id) {
		return (T) getSession().get(entity, id);
	}

	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}
	
	protected DataSource getDataSource(){
		return dataSource;
		/*String tenantId = null;
		try {
			InputStream iStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
			Properties conf = null;
			if(iStream != null) {
				conf = new Properties();
				conf.load(iStream);
			}
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("application-"+conf.getProperty("spring.profiles.active")+".properties");
			if(is != null) {
				Properties config = new Properties();
				config.load(is);
				String isProduction = config.getProperty("runningon.production");
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				String domain = request.getHeader("Host");
				
				if(null == domain)
					domain = request.getHeader("Referer");
				if(null != domain){
					String[] domainParts = null;
					if(isProduction.equals("true")) {
						domainParts = domain.split("\\.");
					} else {
						domainParts = domain.split(":");
					}
					if(domainParts.length > 0){
						if(domainParts[0].equalsIgnoreCase("www"))
							tenantId = domainParts[1];
						else
							tenantId = domainParts[0];
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenImpl.selectDataSource(tenantId);*/
	}

}
