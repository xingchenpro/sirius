package com.hly.sirius.dao;

import com.hly.sirius.domain.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/4
 */
//JpaRepository<对象,主键类型>
public interface VisitorDao extends JpaRepository<Visitor,Integer> {

    //@Query(value = "select v from visitor v where v.visitorName like ?1")
    List<Visitor> findByVisitorName(String name);

    //模糊查询
    List<Visitor> findByVisitorNameLike(String name);

    //分页查询加模糊查询
    Page<Visitor> findByVisitorNameLike(String name, Pageable pageable);

}
