package com.mark.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.util.Arrays;

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

    /**
     *
     * @date 2020/12/9 11:40
     * 用于管理和生成用户邀请码
     */
    public static class PubUserYaoQingCodeQueues
    {
        /**
         * 随机字符串
         */
        private static final char[] CHARS = new char[] {'F', 'L', 'G', 'W', '5', 'V', 'E', '3',
                '9', 'Z', 'M', '6', '7', 'R', 'Y', 'T', '2', 'H', 'S', '8', 'D', 'X', 'C', 'J', '4', 'K',
                'Q', 'P', 'A', 'U', 'N', 'B'};

        private final static int CHARS_LENGTH = 32;

        /**
         * 邀请码长度
         */
        private final static int CODE_LENGTH = 6;

        /**
         * 随机数据
         */
        private final static long SLAT = 1234561L;

        /**
         * PRIME1 与 CHARS 的长度 L互质，可保证 ( id * PRIME1) % L 在 [0,L)上均匀分布
         */
        private final static int PRIME1 = 3;

        /**
         * PRIME2 与 CODE_LENGTH 互质，可保证 ( index * PRIME2) % CODE_LENGTH  在 [0，CODE_LENGTH）上均匀分布
         */
        private final static int PRIME2 = 11;

        /**
         * 生成邀请码
         *
         * @param id 唯一的id主键
         * @return code
         */
        public static String CreateUserYaoQingCode(Long id) throws NormalException
        {
            try
            {
                //补位
                id = id * PRIME1 + SLAT;
                //将 id 转换成32进制的值
                long[] b = new long[CODE_LENGTH];
                //32进制数
                b[0] = id;
                for (int i = 0; i < CODE_LENGTH - 1; i++) {
                    b[i + 1] = b[i] / CHARS_LENGTH;
                    //按位扩散
                    b[i] = (b[i] + i * b[0]) % CHARS_LENGTH;
                }
                b[5] = (b[0] + b[1] + b[2] + b[3] + b[4]) * PRIME1 % CHARS_LENGTH;

                //进行混淆
                long[] codeIndexArray = new long[CODE_LENGTH];
                for (int i = 0; i < CODE_LENGTH; i++) {
                    codeIndexArray[i] = b[i * PRIME2 % CODE_LENGTH];
                }

                StringBuilder buffer = new StringBuilder();
                Arrays.stream(codeIndexArray).boxed().map(Long::intValue).map(t -> CHARS[t]).forEach(buffer::append);
                return buffer.toString();
            }
            catch (Exception ex)
            {
                throw new NormalException(ex.getMessage());
            }
        }

        /**
         * 将邀请码解密成原来的id
         *
         * @param code 邀请码
         * @return id
         */
        public static Long DecodeUserYaoQingCode(String code)  throws NormalException
        {
            try
            {
                if (code.length() != CODE_LENGTH) {
                    return null;
                }
                //将字符还原成对应数字
                long[] a = new long[CODE_LENGTH];
                for (int i = 0; i < CODE_LENGTH; i++) {
                    char c = code.charAt(i);
                    int index = findIndex(c);
                    if (index == -1) {
                        //异常字符串
                        return null;
                    }
                    a[i * PRIME2 % CODE_LENGTH] = index;
                }

                long[] b = new long[CODE_LENGTH];
                for (int i = CODE_LENGTH - 2; i >= 0; i--) {
                    b[i] = (a[i] - a[0]*i + CHARS_LENGTH * i) % CHARS_LENGTH;
                }

                long res = 0;
                for (int i = CODE_LENGTH - 2; i >= 0; i--) {
                    res += b[i];
                    res *= (i > 0 ? CHARS_LENGTH : 1);
                }
                return (res - SLAT) / PRIME1;

            }
            catch (Exception ex)
            {
                throw new NormalException(ex.getMessage());
            }
        }

        /**
         * 查找对应字符的index
         *
         * @param c 字符
         * @return index
         */
        private static int findIndex(char c) {
            for (int i = 0; i < CHARS_LENGTH; i++) {
                if (CHARS[i] == c) {
                    return i;
                }
            }
            return -1;
        }


        public static void main(String[] args)
        {
            try
            {
                String strUserId = "1951364703847806";

                String strYaoQingCode = CreateUserYaoQingCode(Long.valueOf(strUserId));

                System.out.println("生成掌朋邀请码code:" + strYaoQingCode);

                Long lUserid = DecodeUserYaoQingCode(strYaoQingCode);

                System.out.println("生成用户ID为:" + lUserid);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
