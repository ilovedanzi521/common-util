/****************************************************
 * 创建人：  @author wangkai    
 * 创建时间: 2017-11-8/18:40:14
 * 项目名称: dfas-common-util
 * 文件名称: MD5Utils.java
 * 文件描述: @Description MD5加密工具类
 *
 * All rights Reserved, Designed By
 * @Copyright:2016-2017
 * 
 ********************************************************/

package com.dfas.common.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * 
 * 包名称： com.dfas.common.util
 * 类名称：MD5Util
 * 类描述：MD5加密工具类
 * 创建人：@author wangkai 
 * 创建时间：2017年11月8日/下午6:40:34
 *
 */
public class Md5Util {
    private final static Logger logger = LoggerFactory.getLogger(Md5Util.class);
    
    static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ne) {
            logger.error("NoSuchAlgorithmException: md5", ne);
        }
    }

    /**
     * 对一个文件求他的md5值
     * 
     * @param f
     *            要求md5值的文件
     * @return md5串
     */
    public static String md5(File f) {
        try (FileInputStream fis = new FileInputStream(f)) {
            // 100KB each time
            byte[] buffer = new byte[102400];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(md.digest()));
        } catch (FileNotFoundException e) {
            logger.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        } catch (IOException e) {
            logger.error("md5 file " + f.getAbsolutePath() + " failed:" + e.getMessage());
            return null;
        }
    }

    /**
     * 求一个字符串的md5值
     * 
     * @param target
     *            字符串
     * @return md5 value
     */
    public static String md5(String target) {
        return DigestUtils.md5Hex(target);
    }

    public static String uniqueId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static void main(String[] args) {
    	System.out.println(MD5Utils.md5("123456"));
	}
    
}
