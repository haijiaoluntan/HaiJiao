package com.haijiao.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.haijiao.config.AliyunSMSConfig;
import com.haijiao.pojo.Sms;
import com.haijiao.pojo.SmsQuery;
import com.haijiao.service.SmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private AliyunSMSConfig smsConfig;

    @Override
    public SendSmsResponse sendSms(String phoneNumbers, String templateParam, String templateCode) {
        // 封装短信发送对象
        Sms sms = new Sms();
        sms.setPhoneNumbers(phoneNumbers);
        sms.setTemplateParam(templateParam);
        sms.setTemplateCode(templateCode);

        // 获取短信发送服务机
        IAcsClient acsClient = getClient();

        //获取短信请求
        SendSmsRequest request = getSmsRequest(sms);
        SendSmsResponse sendSmsResponse = new SendSmsResponse();

        try {
            sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
//            log.error("发送短信发生错误。错误代码是 [{}]，错误消息是 [{}]，错误请求ID是 [{}]，错误Msg是 [{}]，错误类型是 [{}]",
//                    e.getErrCode(),
//                    e.getMessage(),
//                    e.getRequestId(),
//                    e.getErrMsg(),
//                    e.getErrorType());
            System.out.println("发生错误");
        }
        return sendSmsResponse;
    }

    @Override
    public QuerySendDetailsResponse querySendDetails(String bizId, String phoneNumber, Long pageSize, Long currentPage) {
        // 查询实体封装
        SmsQuery smsQuery = new SmsQuery();
        smsQuery.setBizId(bizId);
        smsQuery.setPhoneNumber(phoneNumber);
        smsQuery.setCurrentPage(currentPage);
        smsQuery.setPageSize(pageSize);
        smsQuery.setSendDate(new Date());

        // 获取短信发送服务机
        IAcsClient acsClient = getClient();
        QuerySendDetailsRequest request = getSmsQueryRequest(smsQuery);
        QuerySendDetailsResponse querySendDetailsResponse = null;
        try {
            querySendDetailsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
//            log.error("查询发送短信发生错误。错误代码是 [{}]，错误消息是 [{}]，错误请求ID是 [{}]，错误Msg是 [{}]，错误类型是 [{}]",
//                    e.getErrCode(),
//                    e.getMessage(),
//                    e.getRequestId(),
//                    e.getErrMsg(),
//                    e.getErrorType());
            System.out.println("发生错误");
        }
        return querySendDetailsResponse;
    }
    private QuerySendDetailsRequest getSmsQueryRequest(SmsQuery smsQuery) {
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber(smsQuery.getPhoneNumber());
        request.setBizId(smsQuery.getBizId());
        SimpleDateFormat ft = new SimpleDateFormat(smsConfig.getDateFormat());
        request.setSendDate(ft.format(smsQuery.getSendDate()));
        request.setPageSize(smsQuery.getPageSize());
        request.setCurrentPage(smsQuery.getCurrentPage());
        return request;
    }

    private SendSmsRequest getSmsRequest(Sms sms) {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(sms.getPhoneNumbers());
        request.setSignName(smsConfig.getSignName());
        request.setTemplateCode(sms.getTemplateCode());
        request.setTemplateParam(sms.getTemplateParam());
        request.setOutId(sms.getOutId());
        return request;
    }
    private IAcsClient getClient() {

        IClientProfile profile = DefaultProfile.getProfile(smsConfig.getRegionId(),
                smsConfig.getAccessKeyId(),
                smsConfig.getAccessKeySecret());

        try {
            DefaultProfile.addEndpoint(smsConfig.getEndpointName(),
                    smsConfig.getRegionId(),
                    smsConfig.getProduct(),
                    smsConfig.getDomain());
        } catch (ClientException e) {
//            log.error("获取短信发送服务机发生错误。错误代码是 [{}]，错误消息是 [{}]，错误请求ID是 [{}]，错误Msg是 [{}]，错误类型是 [{}]",
//                    e.getErrCode(),
//                    e.getMessage(),
//                    e.getRequestId(),
//                    e.getErrMsg(),
//                    e.getErrorType());
            System.out.println("发生错误");
        }
        return new DefaultAcsClient(profile);
    }
}
