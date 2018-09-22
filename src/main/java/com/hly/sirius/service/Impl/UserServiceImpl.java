package com.hly.sirius.service.Impl;

import com.hly.sirius.dao.UserDao;
import com.hly.sirius.domain.User;
import com.hly.sirius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author hly
 * @blog:https://blog.csdn.net/Sirius_hly
 * @github:https://github.com/SiriusHly
 * @date 2018年9月13日 下午6:25:46
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
	@Override
	public User selectUserById(String userId) {
		return userDao.selectUserById(userId);
	}

	@Override
	//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
	public boolean insertUser(User user) {
		
		return userDao.insertUser(user);
	}
	
	

	

}

