package com.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class HttpService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;


    public void method(){

        System.out.println("method....");
     //  String s= restTemplate.getForObject("http://api2.lfwin.com/payapi/pay/qrcode",String.class);

        Map map=new HashMap<>();
        map.put("service","alipay.comm.qrcode");
        map.put("apikey","00014005");
        map.put("nonce_str","00014005");
        map.put("money","1");
        map.put("sign","1");
        String o = JSON.toJSONString(map);
        System.out.println(o);
        String url="http://api2.lfwin.com/payapi/pay/qrcode?test=yl18305999248&npwd=1";

        String s=restTemplate.postForObject(url,map,String.class);

        System.out.println(restTemplate);


        Map objects = JSON.parseObject(s);
        System.out.println(objects);


    }


    public void rest(){
        redisTemplate.opsForValue().set("xc1",123);

    }
}
