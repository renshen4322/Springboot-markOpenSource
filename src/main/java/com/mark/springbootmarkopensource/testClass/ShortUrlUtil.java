package com.mark.springbootmarkopensource.testClass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: 胡东辉
 * @Description:
 * @Date: 2019/11/13 16:41
 * @Version: 1.0
 */
public class ShortUrlUtil {
    public static int TIMEOUT = 30 * 1000;
    public static String ENCODING = "UTF-8";

    public static void main(String[] args) {
        System.out.println(genShortUrl_WangYi(
                "http://mectest.yto.net.cn/#/"));
    }

    /**
     * 网易接口
     * @param longUrl
     * @return
     */
    private static String USER_KEY = "asdfasdfasdfasdfasdfasffaf";
    public static String genShortUrl_WangYi(String longUrl) {
        String shortUrl = "";
        try{
            URL url = new URL("http://126.am/api!shorten.action?");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //POST Request Define:
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestMethod("POST");

            // POST params
            StringBuilder sbd = new StringBuilder();
            sbd.append("longUrl=").append(longUrl);
            sbd.append("&key=").append(USER_KEY);

            connection.getOutputStream().write(sbd.toString().getBytes());
            connection.connect();

            // response string
            String responseStr = getResponseStr(connection);

            // process response
            shortUrl = "http://" + getValueByKey_JSON(responseStr, "url");

        }catch(IOException e){
            e.printStackTrace();
        }
        return shortUrl;
    }


    /**
     * JSON
     * get value by key
     * @param replyText
     * @param key
     * @return
     */
    private static String getValueByKey_JSON(String replyText, String key){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode edd;
        String tinyUrl = null;
        try {
            edd = mapper.readTree(replyText);
            tinyUrl = edd.get(key).asText();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return tinyUrl;
    }


    /**
     * 通过HttpConnection 获取返回的字符串
     * @param connection
     * @return
     * @throws IOException
     */
    private static String getResponseStr(HttpURLConnection connection)
            throws IOException {
        StringBuffer responseStr = new StringBuffer();
        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in, ENCODING));
            String inputLine = "";
            while ((inputLine = reader.readLine()) != null) {
                responseStr.append(inputLine);
            }
        }
        System.out.println(responseStr);
        return String.valueOf(responseStr);
    }

}
