package com.hly.sirius.test;

import com.hly.sirius.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
        user.setUsername("hly");
       user.setPassword("123");
        mongoTemplate.save(user);
    }

    /**
     * 根据用户Id查询对象
     */
    @Test
    public void findUserByUserId(){
        //第一个是键，第二个是值
        Query query = new Query(Criteria.where("userId").is("hly"));
        User user = mongoTemplate.findOne(query,User.class);
        System.err.println(user);

    }

    /**
     * 更新对象
     */
    @Test
    public void updateUser(){
        Query query = new Query(Criteria.where("userId").is("hly"));
        Update update = new Update().set("userId","hly").set("userPassword","123");
        //更新结果集第一条
        mongoTemplate.updateFirst(query,update,User.class);
        //更新所有
        //mongoTemplate.updateMulti(query,update,User.class);
    }

    /**
     * 删除兑现
     */
    @Test
    public  void deleteUser(){
        Query query = new Query(Criteria.where("userId").is("hly"));
        mongoTemplate.remove(query,User.class);
    }

}
