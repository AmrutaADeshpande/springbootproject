package com.rts.auth.utility;

public class AppConstants {

	enum USER_ACTIVITY_TYPE {
		AUTHENTICATION, AUTHORIZATION, TIMELINE
	};

	public static final String chars = "1234556";

	public static final String UTF_8 = "UTF-8";

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static final String TIMESTAMP_FORMAT_IN_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	public static final String TIME_FORMAT = "HH:mm:ss";

	/**
	 * Modules names which will be used for security groups
	 */
	public static final String GROUP_USER = "USER";
	public static final String GROUP_ROLE = "GROUP";
	public static final String GROUP_APPSETTING = "APPSETTING";
	public static final String GROUP_APPLIST = "APPLIST";
	public static final String GROUP_ACTIONS = "ACTION";
	public static final String GROUP_ACCOUNTS = "ACCOUNTS";
	public static final String GROUP_COSTCENTRE = "COSTCENTRE";
	public static final String GROUP_LOCATION = "LOCATION";

	
}
