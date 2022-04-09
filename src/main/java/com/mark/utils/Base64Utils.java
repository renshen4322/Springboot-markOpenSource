package com.mark.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Objects;


/**
 * ClassName:Base64Utils
 * Package:com.mark.springbootmarkopensource.utils
 * Description:
 *
 * @Date:2021/10/20 11:57
 * @Author: mark
 */
public class Base64Utils {

    public static void main(String[] args) {
        //image -> base64
        String base64 = ImageToBase64("src/main/resources/OIP-C3.jpg");
        System.out.println(base64);

        String baseStrBase64= "data:application/pdf;base64,"+base64;
        System.out.println(baseStrBase64);
        // base64 -> image
        Base64ToStream(base64);

    }

    public static byte[] readImage(String imgPath) {
        byte[] data = null;
        InputStream in = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    public static void saveImage(byte[] imageByte){
        InputStream input = null;

        try {
            //转化成流
            input = new ByteArrayInputStream(imageByte);
            BufferedImage bi = ImageIO.read(input);
            File file = new File("temp.jpg");
            ImageIO.write(bi, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String ImageToBase64(String imgPath) {
        byte[] data = readImage(imgPath);

        // 对字节数组Base64编码
       // BASE64Encoder encoder = new BASE64Encoder();
        Base64.Encoder encoder = Base64.getEncoder();

        // 返回Base64编码过的字节数组字符串
        return encoder.encodeToString(Objects.requireNonNull(data));
    }

    public static void Base64ToStream(String base64) {
        //BASE64Decoder decoder = new BASE64Decoder();
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] imageByte = new byte[0];

        imageByte = decoder.decode(base64);

        //图片类型
        saveImage(imageByte);
    }

}
