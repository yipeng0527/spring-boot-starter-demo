package com.yp.controller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yipeng
 * @Date 2021/3/17 11:11
 * @Version 1.0
 * @Desc
 */
@RestController
public class HelloController {

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/say")
    public String sayHello() {
        RBucket<String> name = redissonClient.getBucket("name");
        if (null == name.get()) {
            name.set("i love yp");
        }
        return name.get().toString();
    }
}
