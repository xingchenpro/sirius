package com.hly.sirius.controller;
import com.hly.sirius.domain.User;
import com.hly.sirius.service.UserService;
import com.hly.sirius.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author hly
 * @blog:https://blog.csdn.net/Sirius_hly
 * @github:https://github.com/SiriusHly
 * @date 2018年9月13日 下午6:22:04
 */
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;
	/**
	 * 登录
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	@RequestMapping("/login")
   public ModelAndView login(@RequestParam(value="user_id",required=false) String userId, @RequestParam(value="user_password",required=false)String userPassword, HttpSession session){

		ModelAndView mView = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userId, CryptographyUtil.md5(userPassword,userId));
		try {
			subject.login(token);
			session.setAttribute("userId",userId);
			mView.setViewName("/admin");
			return mView;
		} catch (AuthenticationException e) {
			System.err.println("用户名或密码错误");
			e.printStackTrace();
			mView.setViewName("/login");
			return mView;
		}
	}

	/**
	 * 注册
	 * @param
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam(value="user_id",required=false)String userId,@RequestParam(value="user_password",required=false)String userPassword){
		ModelAndView mView = new ModelAndView();
			try {
				User user = new User(userId, CryptographyUtil.md5(userPassword,userId));
				System.err.println(user.toString());
				userService.insertUser(user);
				mView.setViewName("/login");
				return mView;
			} catch (Exception e) {
				mView.setViewName("/register");
				return mView;
			}
	}
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/index");
		return mView;
	}

	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/admin")
	public ModelAndView admin(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin");
		return mView;
	}

	/**
	 * 初始化页面
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView preLogin(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/login");
		return mView;
	}

}
