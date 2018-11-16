package com.hly.sirius.dao;

import com.hly.sirius.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author hly
 * @blog: https://blog.csdn.net/Sirius_hly
 * @github: https://github.com/huangliangyun
 * @date 2018年9月12日 下午7:21:50
 */
@Repository
public interface UserDao {
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user);
	/**
	 * 根据Id查询用户
	 * @param username
	 * @return
	 */
	public User selectUserById(String username);
}

