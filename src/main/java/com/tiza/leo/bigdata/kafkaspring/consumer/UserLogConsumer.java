package com.tiza.leo.bigdata.kafkaspring.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author leowei
 * @date 2021/6/26  - 22:18
 */
@Component
@Slf4j
public class UserLogConsumer {

    @KafkaListener(topics ={ "user-log"})
    public void consumer(ConsumerRecord<?,?> consumerRecord){
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>> record="+ kafkaMessage);
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.out.println("消费消息： "+ message);
        }
    }
}
