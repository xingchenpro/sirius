package com.hly.sirius.test;

import com.hly.sirius.dao.VisitorDao;
import com.hly.sirius.domain.Visitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    @Test
    public void updateTest(){
        Visitor visitor = new Visitor();
        visitor.setVisitorId(1);
        visitor.setVisitorName("sirius");
        visitor.setVisitorTel("17865168830");
        visitorDao.save(visitor);
    }

    @Test
    public void deleteTest(){
        Visitor visitor = new Visitor();
        visitor.setVisitorId(2);
        visitorDao.delete(visitor);
    }

    @Test
    public void queryTest(){
        List<Visitor> list1 = visitorDao.findByVisitorName("%s%");
        List<Visitor> list2 = visitorDao.findByVisitorNameLike("%s%");
        System.err.println("list1:");
        for (Visitor visitor:list1)
            System.err.println(visitor);
        System.err.println("list2:");
        for (Visitor visitor:list2)
            System.err.println(list2);
    }

    @Test
    public void selectByPageTest(){

        //0代表第一页，2代表每页2条数据
        Pageable pageable = PageRequest.of (0,2);
        Page<Visitor> page = visitorDao.findByVisitorNameLike("%s%",pageable);
        System.err.println("page:");
        for(Visitor visitor:page.getContent())
            System.err.println(visitor);

    }




}
