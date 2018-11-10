package com.hly.sirius.service;


import com.hly.sirius.domain.User;

/**
 * @author hly
 * @blog:https://blog.csdn.net/Sirius_hly
 * @github: https://github.com/huangliangyun
 * @date 2018年9月13日 下午6:22:04
 */
public interface UserService {
	
	/**
	 * 查询用户
	 * @param userId
	 * @return
	 */
	public User selectUserById(String userId);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user);

}

