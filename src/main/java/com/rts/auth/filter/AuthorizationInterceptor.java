/*
 * package com.rts.auth.filter;
 * 
 * import java.lang.reflect.Method; import java.util.Base64; import
 * java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.Around; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.reflect.MethodSignature; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.context.request.RequestContextHolder; import
 * org.springframework.web.context.request.ServletRequestAttributes;
 * 
 * import com.rts.auth.dal.ObjectDao; import
 * com.rts.auth.exceptions.AuthenticationException; import
 * com.rts.auth.model.SecurityGroupAction; import
 * com.rts.auth.model.SecurityUser; import com.rts.auth.model.SecurityUserGroup;
 * import com.rts.auth.utility.ErrorConstants;
 * 
 * @Aspect
 * 
 * @Component public class AuthorizationInterceptor {
 * 
 * private final ObjectDao objectDao;
 * 
 * public AuthorizationInterceptor(ObjectDao objectDao) { this.objectDao =
 * objectDao; }
 * 
 * @Around("@annotation(com.rts.auth.filter.Authorized)") public Object
 * authorized(ProceedingJoinPoint joinPoint) throws Throwable {
 * HttpServletRequest request = ((ServletRequestAttributes)
 * RequestContextHolder.currentRequestAttributes()).getRequest();
 * MethodSignature signature = (MethodSignature) joinPoint.getSignature();
 * Method method = signature.getMethod(); String actionName =
 * method.getAnnotation(Authorized.class).value();
 * System.out.println("Action Name : "+actionName);
 * if(authorizeCurrentUser(request, actionName)) { return joinPoint.proceed(); }
 * else { throw new AuthenticationException(ErrorConstants.UNAUTHORIZED,
 * "User is not authorized to access this resource"); } }
 * 
 * 
 * @SuppressWarnings("unchecked") private boolean
 * authorizeCurrentUser(HttpServletRequest request, String actionName) { String
 * module = actionName.substring(0, actionName.indexOf("_")); String action =
 * actionName.substring(actionName.indexOf("_")+1, actionName.length()); String
 * securityAccessToken = request.getHeader("s_a_t"); byte[] decoded =
 * Base64.getDecoder().decode(securityAccessToken); String [] satArr = new
 * String(decoded).split(":"); String userUniqueId = satArr[1]; SecurityUser
 * securityUser = objectDao.getObjectByParam(SecurityUser.class, "userUid",
 * userUniqueId); if(securityUser != null) { List<SecurityUserGroup> userGroups
 * = (List<SecurityUserGroup>)
 * objectDao.listObjectByParam(SecurityUserGroup.class, "securityUser",
 * "userGroupId", securityUser); if(userGroups != null && userGroups.size() > 0)
 * { for(SecurityUserGroup sug : userGroups) { for(SecurityGroupAction
 * securityGroupAction : sug.getSecurityGroup().getSecurityGroupActions()) {
 * if(securityGroupAction.getSecurityAction().getActionName().equals(action) &&
 * securityGroupAction.getSecurityAction().getModule().equals(module)) { return
 * true; } } } return false; } else { return false; } } else { return false; } }
 * 
 * }
 */