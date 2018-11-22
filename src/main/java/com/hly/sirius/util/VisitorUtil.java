package com.hly.sirius.util;

import com.hly.sirius.dao.VisitorDao;
import com.hly.sirius.domain.Visitor;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/22
 */
public class VisitorUtil {

    public static void saveVisitor(VisitorDao visitorDao, HttpServletRequest request){
        String visitorIP = request.getRemoteAddr();
        String visitorLastTime = DateUtil.getCurrentDateString();
        Visitor visitor = null;
        if(visitorDao.getVisitorByVisitorIP(request.getRemoteAddr())==null){
            visitor = new Visitor();
            visitor.setVisitorIP(visitorIP);
            visitor.setVisitorLastTime(visitorLastTime);
            visitorDao.addVisitor(visitor);
        }else{
            Map<String,Object> map = new HashMap<>();
            map.put("visitorIP",visitorIP);
            map.put("visitorLastTime",visitorLastTime);
            visitorDao.updateViewNum(map);
        }
    }
}
