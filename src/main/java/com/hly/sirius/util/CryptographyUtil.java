package com.hly.sirius.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/8/30
 */
public class CryptographyUtil {

    public static String md5(String str,String salt){
        System.err.println("加盐MD5:"+new Md5Hash(str,salt).toString());
        return new Md5Hash(str,salt).toString();
    }

    public static void main(String[] args) {
        System.out.println(CryptographyUtil.md5("123","hly"));
    }

}
