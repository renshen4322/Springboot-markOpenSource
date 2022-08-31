package com.mark.utils;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *
 * @date 2020/12/9 11:40
 * 用于管理和生成用户邀请码
 */
public class PubUserYaoQingCodeQueues
{
    /**
     * 随机字符串
     */

    private static char[] CHARS = {'M', 'w', 'W', 'J', 's', 'c', 'B', 'A', 'Q', 'T', 'D', 'r', 'u', 'X', 'n',
            't', 'R', 'p', 'y', 'i', 'd', 'f', 'b', '7', 'g', 'Z', 'N', 'j', '2', 'H', 'a', 'x', 'v', 'e', 'h', '6',
            'E', 'G', 'Y', '5', '3', 'k', 'z', '8', '4', 'm'};
    /*private static final char[] CHARS = new char[] {'F', 'L', 'G', 'W', '5', 'V', 'E', '3',
            '9', 'Z', 'M', '6', '7', 'R', 'Y', 'T', '2', 'H', 'S', '8', 'D', 'X', 'C', 'J', '4', 'K',
            'Q', 'P', 'A', 'U', 'N', 'B'};*/

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
            String strUserId = "1951364703847807";

            String strYaoQingCode = CreateUserYaoQingCode(Long.valueOf(strUserId));

            System.out.println("生成掌朋邀请码code:" + strYaoQingCode);

            Long lUserid = DecodeUserYaoQingCode(strYaoQingCode);

            System.out.println("生成用户ID为:" + lUserid);

            String userId = CreateUserIdPrefix();
            System.out.println("userid====="+userId);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 用于生成用户ID的前缀
     * ID格式为10位  前两位 年 + 三位 年的第几天 + 五位随机数
     * @return
     */
    public static String CreateUserIdPrefix() throws NormalException
    {
        StringBuffer strUserId = new StringBuffer();

        try
        {
            LocalDateTime nowDate = LocalDateTime.now();

            //获取两位年份
            int nowYear = nowDate.getYear();

            nowYear = nowYear - 2010;

            strUserId.append(nowYear);

            //获取当年第几天
            int nowDays = nowDate.getDayOfYear();

            if(nowDays >= 0 && nowDays <= 9)
            {
                strUserId.append("0");
                strUserId.append("0");
                strUserId.append(nowDays);
            }
            else if(nowDays >= 10 && nowDays <= 99)
            {
                strUserId.append("0");
                strUserId.append(nowDays);
            }
            else
            {
                strUserId.append(nowDays);
            }

            return strUserId.toString();
        }
        catch (Exception e)
        {
            throw new NormalException(e);
        }
    }
}
