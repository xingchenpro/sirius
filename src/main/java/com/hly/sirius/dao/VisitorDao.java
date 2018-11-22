package com.hly.sirius.dao;

import com.hly.sirius.domain.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/4
 */
//JpaRepository<对象,主键类型>
//extends JpaRepository<Visitor,Integer>
@Repository
public interface VisitorDao {

    //@Query(value = "select v from visitor v where v.visitorName like ?1")
    //List<Visitor> findByVisitorName(String name);

    //模糊查询
    //List<Visitor> findByVisitorNameLike(String name);

    //分页查询加模糊查询
    //Page<Visitor> findByVisitorNameLike(String name, Pageable pageable);

    /**
     * 通过IP查看访问者
     * @param visitorIP
     * @return
     */
    public Visitor getVisitorByVisitorIP(String visitorIP);

    /**
     * 更新访问次数
     */

    public int updateViewNum(Map<String,Object> map);

    /**
     * 插入
     * @param visitor
     * @return
     */
    public int addVisitor(Visitor visitor);


}
