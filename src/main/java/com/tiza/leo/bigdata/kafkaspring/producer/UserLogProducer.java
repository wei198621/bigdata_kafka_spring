package com.tiza.leo.bigdata.kafkaspring.producer;

import com.alibaba.fastjson.JSON;
import com.tiza.leo.bigdata.kafkaspring.bean.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author leowei
 * @date 2021/6/26  - 22:19
 */
@Component
public class UserLogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送数据
     * @param userid
     */
    public void sendLog(String userid){
        UserLog userLog = new UserLog();
        userLog.setUsername("lili").setUserid(userid).setState("0");
        System.out.println("发送用户日志数据:"+ userLog);
        kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
    }

}
