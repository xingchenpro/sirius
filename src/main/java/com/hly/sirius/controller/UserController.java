package com.hly.sirius.controller;
import com.hly.sirius.domain.User;
import com.hly.sirius.filter.VisitorFilter;
import com.hly.sirius.service.UserService;
import com.hly.sirius.util.CryptographyUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author hly
 * @blog: https://github.com/huangliangyun
 * @github: https://github.com/huangliangyun
 * @date 2018年9月13日 下午6:22:04
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
   public ModelAndView login(@RequestParam(value="username",required=false) String username, @RequestParam(value="password",required=false)String password, HttpSession session){

		ModelAndView mView = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, CryptographyUtil.md5(password,username));
		try {
			subject.login(token);
			session.setAttribute("username",username);
			mView.setViewName("/admin/admin");
			return mView;
		} catch (AuthenticationException e) {
			System.err.println("用户名或密码错误");
			e.printStackTrace();
			mView.setViewName("/user/login");
			return mView;
		}
	}

	/**
	 * 注册
	 * @param
	 * @return
	 */
	//@RequestMapping("/register")
	public ModelAndView register(@RequestParam(value="username",required=false)String username,@RequestParam(value="password",required=false)String password){
		ModelAndView mView = new ModelAndView();
			try {
				User user = new User(username, CryptographyUtil.md5(password,username));
				System.err.println(user.toString());
				userService.insertUser(user);
				mView.setViewName("/login");
				return mView;
			} catch (Exception e) {
				mView.setViewName("/register");
				return mView;
			}
	}
	


}
