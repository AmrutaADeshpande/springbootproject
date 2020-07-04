/*
 * package com.rts.auth.filter;
 * 
 * import java.time.LocalDateTime; import java.time.ZoneId; import
 * java.util.Base64;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.core.env.Environment; import
 * org.springframework.stereotype.Component; import
 * org.apache.logging.log4j.LogManager; import org.apache.logging.log4j.Logger;
 * import org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 * 
 * import com.rts.auth.dal.ObjectDao; import
 * com.rts.auth.model.SecurityAuthToken;
 * 
 * @Component public class AuthenticationInterceptor extends
 * HandlerInterceptorAdapter{
 * 
 * private static Logger log = LogManager.getLogger();
 * 
 * private final ObjectDao objectDao; private final Environment environment;
 * 
 * public AuthenticationInterceptor(ObjectDao objectDao, Environment
 * environment) { this.objectDao = objectDao; this.environment = environment; }
 * 
 * @Override public void afterCompletion(HttpServletRequest request,
 * HttpServletResponse response, Object handler, Exception ex) throws Exception
 * { log.info("In afterCompletion"); super.afterCompletion(request, response,
 * handler, ex); }
 * 
 * @Override public void postHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
 * throws Exception { log.info("In postHandle"); super.postHandle(request,
 * response, handler, modelAndView); }
 * 
 * @Override public boolean preHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler) throws Exception {
 * log.info("In preHandle"); log.info("request.getRequestURI() : ",
 * request.getRequestURI());
 * response.setHeader("Access-Control-Allow-Credentials", "true");
 * response.setHeader("Access-Control-Allow-Origin",
 * environment.getRequiredProperty("allow.origins"));
 * response.setHeader("Access-Control-Allow-Methods",
 * "POST, GET, PUT, DELETE, OPTIONS");
 * response.setHeader("Access-Control-Max-Age", "3600");
 * response.setHeader("Access-Control-Allow-Headers",
 * "Origin, X-Requested-With, s_a_t, Content-Type, Accept, Authorization, timezone"
 * ); if(request.getMethod().equalsIgnoreCase("OPTIONS")){ return true; } else
 * if(request.getRequestURI().contains("/auth/authenticate") ||
 * request.getRequestURI().contains("/auth/sign-up") ||
 * request.getRequestURI().contains("/auth/sign-up-confirm") ||
 * request.getRequestURI().contains("/auth/sign-up-social") ||
 * request.getRequestURI().contains("/auth/sign-off") ||
 * request.getRequestURI().contains("/auth/forgot-password") ||
 * request.getRequestURI().contains("/auth/generate-token") ||
 * request.getRequestURI().contains("/auth/verify-otp") ||
 * request.getRequestURI().contains("/auth/change-password") ||
 * request.getRequestURI().contains("/auth/resend-otp") ||
 * request.getRequestURI().contains("/auth/login-with-otp") ||
 * request.getRequestURI().contains("/auth/verify-login-with-otp") ||
 * request.getRequestURI().contains("/getImage")){
 * log.info("request.getRequestURI() : ",request.getRequestURI()); return
 * super.preHandle(request, response, handler); } else { String
 * securityAccessToken = request.getHeader("s_a_t"); byte[] decoded =
 * Base64.getDecoder().decode(securityAccessToken); String [] satArr = new
 * String(decoded).split(":"); String accessToken = satArr[0]; String
 * userUniqueId = satArr[1]; String deviceUniqueId = satArr[2];
 * SecurityAuthToken authToken =
 * objectDao.getObjectByParam(SecurityAuthToken.class, "userDeviceId",
 * deviceUniqueId); if(authToken != null &&
 * authToken.getUserId().equals(userUniqueId) &&
 * authToken.getAccessToken().equals(accessToken)) { if(isValidToken(authToken))
 * { return super.preHandle(request, response, handler); } else {
 * response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED); return false;
 * } } else { response.setStatus(HttpServletResponse.SC_FORBIDDEN); return
 * false; } } }
 * 
 * public boolean isValidToken(SecurityAuthToken authTokenDB) throws Exception {
 * LocalDateTime now = LocalDateTime.now(); LocalDateTime updatedAt =
 * LocalDateTime.ofInstant(authTokenDB.getUpdatedAt().toInstant(),
 * ZoneId.systemDefault()); LocalDateTime expiration =
 * updatedAt.plusSeconds(authTokenDB.getExpiresIn()); if
 * (now.isAfter(expiration)) { return false; } else { return true; } }
 * 
 * }
 */