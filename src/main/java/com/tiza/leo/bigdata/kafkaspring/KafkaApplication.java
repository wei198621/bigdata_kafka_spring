package com.tiza.leo.bigdata.kafkaspring;

import com.tiza.leo.bigdata.kafkaspring.producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author leowei
 * @date 2021/6/26  - 22:19
 */
@SpringBootApplication
public class KafkaApplication {

    @Autowired
    private UserLogProducer kafkaSender;

    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            kafkaSender.sendLog(String.valueOf(i));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }

}
