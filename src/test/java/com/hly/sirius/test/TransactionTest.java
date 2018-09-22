package com.hly.sirius.test;

import com.hly.sirius.domain.User;
import com.hly.sirius.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/21
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionTest {

    @Autowired
    UserService userService;

    @Test
    public  void testSelectTransaction(){
        User user = userService.selectUserById("hly");
        System.err.println(user.toString());
    }

    @Test
    public  void testInsertTransaction(){
        User user = new User("001","111");
        userService.insertUser(user);
    }

}
