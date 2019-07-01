/****************************************************
 * 创建人：  @author zhoujinyin    
 * 创建时间: 2019/5/30/17:25
 * 项目名称：dfas-auth-center
 * 文件名称: RsaKeyHelper
 * 文件描述: @Description: rsa公密钥生成助手
 *
 * All rights Reserved, Designed By 投资交易团队
 * @Copyright:2016-2019
 *
 ********************************************************/
package com.win.dfas.common.util;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 包名称：com.win.dfas.auth.common.jwt
 * 类名称：RsaKeyHelper
 * 类描述：rsa公密钥生成助手
 * 创建人：@author zhoujinyin
 * 创建时间：2019/5/30/17:25
 */
public class RsaKeyHelper {
    /**
     * @Title: getPublicKey
     * @Description: 获取公钥
     * @param filename
     * @return java.security.PublicKey
     * @throws Exception
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:26
     */
    public PublicKey getPublicKey(String filename) throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        dis.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * @Title: getPrivateKey
     * @Description: 获取密钥
     * @param filename
     * @return java.security.PrivateKey
     * @throws Exception
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:27
     */
    public PrivateKey getPrivateKey(String filename) throws Exception {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    /**
     * @Title: getPublicKey
     * @Description: 获取公钥
     * @param publicKey
     * @return java.security.PublicKey
     * @throws Exception
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:37
     */
    public PublicKey getPublicKey(byte[] publicKey) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * @Title: getPrivateKey
     * @Description: 获取密钥
     * @param privateKey
     * @return java.security.PrivateKey
     * @throws Exception
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:38
     */
    public PrivateKey getPrivateKey(byte[] privateKey) throws Exception {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }


    /**
     * @Title: generateKey
     * @Description: 生成rsa公钥和密钥
     * @param publicKeyFilename
     * @param privateKeyFilename
     * @param password
     * @return void
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:39
     */
    public void generateKey(String publicKeyFilename, String privateKeyFilename, String password) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        FileOutputStream fos = new FileOutputStream(publicKeyFilename);
        fos.write(publicKeyBytes);
        fos.close();
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        fos = new FileOutputStream(privateKeyFilename);
        fos.write(privateKeyBytes);
        fos.close();
    }

    /**
     * @Title: generatePublicKey
     * @Description: 生成rsa公钥
     * @param password
     * @return byte[]
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:50
     */
    public static byte[] generatePublicKey(String password) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        return keyPair.getPublic().getEncoded();
    }

    /**
     * @Title: generatePrivateKey
     * @Description: 生成rsa密钥
     * @param password
     * @return byte[]
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:51
     */
    public static byte[] generatePrivateKey(String password) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        return keyPair.getPrivate().getEncoded();
    }

    /**
     * @Title: generateKey
     * @Description: 生成rsa公密钥
     * @param password
     * @return java.util.Map<java.lang.String,byte[]>
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:53
     */
    public static Map<String, byte[]> generateKey(String password) throws IOException, NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        Map<String, byte[]> map = new HashMap<String, byte[]>(16);
        map.put("pub", publicKeyBytes);
        map.put("pri", privateKeyBytes);
        return map;
    }

    /**
     * @Title: toHexString
     * @Description: base编码
     * @param b
     * @return java.lang.String
     * @throws
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:58
     */
    public static String toHexString(byte[] b) {
        return (new BASE64Encoder()).encodeBuffer(b);
    }

    /**
     * @Title: toBytes
     * @Description: base解码
     * @param s
     * @return byte[]
     * @throws
     * @author: zhoujinyin
     * @Date:  2019/5/30/17:59
     */
    public static final byte[] toBytes(String s) throws IOException {
        return (new BASE64Decoder()).decodeBuffer(s);
    }
}
