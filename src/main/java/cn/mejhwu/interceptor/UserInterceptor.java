package cn.mejhwu.interceptor;

import cn.mejhwu.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-9
 * Time: 上午12:21.
 */
public class UserInterceptor implements HandlerInterceptor {
	
	private final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle--------------------------------------------");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			Cookie[] cookies = request.getCookies();
			String userName = null;
			String password = null;
			if (cookies != null) {
				for (Cookie cookie :cookies) {
					if ("userName".equals(cookie.getName())) {
						userName = cookie.getValue();
					}
					if ("password".equals(cookie.getName())) {
						password = cookie.getValue();
					}
				}
				if (userName != null && password != null) {
					logger.info("userName: " + userName);
					logger.info("password: " + password);
					request.setAttribute("userName" ,userName);
					request.setAttribute("password", password);
					request.getRequestDispatcher("/back/login/login").forward(request,response);
				} else {
					response.sendRedirect("/back/login/loginPage");
				}
			} else {
				response.sendRedirect("/back/login/loginPage");
			}
		}
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
