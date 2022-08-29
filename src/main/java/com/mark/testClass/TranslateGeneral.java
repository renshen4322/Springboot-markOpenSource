package com.mark.testClass;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alimt.model.v20181012.TranslateGeneralRequest;
import com.aliyuncs.alimt.model.v20181012.TranslateGeneralResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

/**
 * Description:
 *
 * @Date:2022/8/22 16:12
 * @Author:
 */
public class TranslateGeneral {
    public static void main(String[] args) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your-access-key-id>", "<your-access-key-secret>");
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/

        IAcsClient client = new DefaultAcsClient(profile);

        TranslateGeneralRequest request = new TranslateGeneralRequest();
        request.setFormatType("text");
        request.setSourceLanguage("zh");
        request.setTargetLanguage("en");
        request.setSourceText("测试");
        request.setScene("general");

        try {
            TranslateGeneralResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());

        }
    }
}
