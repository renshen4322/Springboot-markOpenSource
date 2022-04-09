package com.mark.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

public class DESUtil {
    public static final String KEY_ALGORITHM = "DESede";
    public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";
    public static final String DEFUALT_CHARSET = "UTF-8";

    public DESUtil() {
    }

    public static String generateKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DESede");
        kg.init(168);
        SecretKey secretKey = kg.generateKey();
        return Base64.encodeBase64String(secretKey.getEncoded());
    }

    private static Key toKey(byte[] key) throws Exception {
        DESedeKeySpec dks = new DESedeKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }

    public static String encrypt(String content, String appKey) throws Exception {
        byte[] data = content.getBytes("UTF-8");
        byte[] key = appKey.getBytes("UTF-8");
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, k);
        return Base64.encodeBase64String(cipher.doFinal(data));
    }

    public static String decrypt(String content, String appKey) throws Exception {
        byte[] data = Base64.decodeBase64(content);
        byte[] key = appKey.getBytes("UTF-8");
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(2, k);
        return new String(cipher.doFinal(data), "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        String str = "{code:\"210034\"}";
        System.out.println("原文：\t" + str);
        String key = generateKey();
        System.out.println("密钥：\t" + key);
        String data = encrypt(str, key);
        System.out.println("加密后：\t" + data);
        data = decrypt(data, key);
        System.out.println("解密后：\t" + data);
    }
}
