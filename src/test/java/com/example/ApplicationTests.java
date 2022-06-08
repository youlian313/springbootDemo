package com.example;

import com.alibaba.fastjson.JSON;
import com.example.service.HttpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private HttpService httpService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisTemplate redisTemplate2;
    @Resource
    private RedisTemplate redisTemplate3;
    @Test
    void testMethod() {
        Map<String,String> map=new HashMap<>();
        map.put("company","kuxiang");
        map.put("name","嘻嘻嘻");
        map.put("id","1");
        String s = JSON.toJSONString(map);
        redisTemplate3.opsForValue().set("xc1",s);
        Object xc1 = redisTemplate3.opsForValue().get("xc1");
        System.out.println(xc1);
    }

}
