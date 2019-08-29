package com.haijiao.service;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

public interface SmsService {
    SendSmsResponse sendSms(String phoneNumbers, String templateParam, String templateCode);
    QuerySendDetailsResponse querySendDetails(String bizId, String phoneNumber, Long pageSize, Long currentPage);
}
