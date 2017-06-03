package cn.mejhwu.controller.back;

import cn.mejhwu.beans.User;
import cn.mejhwu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-8
 * Time: 下午10:42.
 */

@Controller
@RequestMapping("/back/")
public class LoginController {
	
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("loginPage")
	public String goLoginPage() {
		return "back/login";
	}
	
	/**
	 * 等你操作
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		
		String userName = (String)request.getAttribute("userName");
		String password = (String)request.getAttribute("password");
		
		if (userName == null || password == null) {
			userName = request.getParameter("userName");
			password = request.getParameter("password");
		}
		
		user.setUserName(userName);
		user.setPassword(password);
		user = userService.queryUser(user);
		
		if (user == null) {
			//用户不存在,转发到登陆页面
			request.setAttribute("message", "用户名或密码错误!");
			return "forward:/back/login/goLoginPage";
		} else {
			//登陆成功,写入Session和Cookie
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			Cookie userNameCookie = new Cookie("userName", user.getUserName());
			userNameCookie.setPath("/back");
			Cookie passwordCookie = new Cookie("password", user.getPassword());
			passwordCookie.setPath("/back");
			response.addCookie(userNameCookie);
			response.addCookie(passwordCookie);
			return "redirect:/back/article/list";
		}
	}
}
