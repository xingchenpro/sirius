package com.hly.sirius.test;

import com.hly.sirius.dao.VisitorDao;
import com.hly.sirius.domain.Visitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/4
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class JPATest {

    @Autowired
    private VisitorDao visitorDao;

    @Test
    public void insertTest(){
        Visitor visitor = new Visitor();
        visitor.setVisitorName("hly");
        visitor.setVisitorQQ("1136513099");
        visitorDao.save(visitor);

    }






}
