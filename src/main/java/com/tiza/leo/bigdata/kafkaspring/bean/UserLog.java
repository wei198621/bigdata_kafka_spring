package com.tiza.leo.bigdata.kafkaspring.bean;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author leowei
 * @date 2021/6/26  - 22:18
 */
@Data
@Accessors(chain = true)
public class UserLog {
        private String userid;
        private String username;
        private String state;
}
