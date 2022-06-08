package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean

    public RestTemplate restTemplate(ClientHttpRequestFactory cpf){
        return new RestTemplate(cpf);

    }
    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(){
        ClientHttpRequestFactory cpf=new OkHttp3ClientHttpRequestFactory();
        return cpf;
    }
}
