package com.zdj.encode;

import org.springframework.util.Assert;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author zhangdj
 * @date 2020/11/04
 * 非对称加密工具类
 */
public class MyEncoder {

    /**
     * 加密算法
     */
    public static final String RSA_ALGORITHM = "RSA";

    private final PublicKey publicKey;

    private final PrivateKey privateKey;

    /**
     * 静态内部类保证单例
     */
    static class InnerClass {
        private static final MyEncoder ENCODER = new MyEncoder();
    }

    /**
     * 获取实例
     *
     * @return MyEncoder实例
     */
    public static MyEncoder getInstance() {
        return InnerClass.ENCODER;
    }

    private MyEncoder() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Assert.notNull(keyPairGenerator, "keyPairGenerator is null");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥对象
        this.publicKey = keyPair.getPublic();
        // 私钥对象
        this.privateKey = keyPair.getPrivate();
    }

    /**
     * 获取公钥对应的字符串
     *
     * @return 公钥对应的字符串
     */
    public String getPublicKeyString() {
        return Base64.getEncoder().encodeToString(this.publicKey.getEncoded());
    }

    /**
     * 公钥加密
     *
     * @param data 要加密的数据
     * @return 加密后的字节数组
     */
    public byte[] encryptByPublicKey(byte[] data) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PublicKey key = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * 私钥解密
     *
     * @param encryptData 加密的字节数组
     * @return 原数据字节数组
     * @throws Exception
     */
    public byte[] decryptByPrivateKey(byte[] encryptData) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        KeyFactory factory = KeyFactory.getInstance(RSA_ALGORITHM);
        PrivateKey key1 = factory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher1 = Cipher.getInstance(factory.getAlgorithm());
        cipher1.init(Cipher.DECRYPT_MODE, key1);
        return cipher1.doFinal(encryptData);
    }

    public static void main(String[] args) throws Exception {
        String data = "qwe123";
        MyEncoder encoder = MyEncoder.getInstance();
        // 加密
        byte[] bytes = encoder.encryptByPublicKey(data.getBytes());
        // 解密
        byte[] decrypt = encoder.decryptByPrivateKey(bytes);
        System.out.println(new String(decrypt));
    }

}
