package com.hly.sirius.test;

import com.hly.sirius.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/6
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入数据
     */
    @Test
    public void saveUser(){
        User user = new User();
        user.setUserId("hly");
        user.setUserPassword("123");
        mongoTemplate.save(user);
    }


}
