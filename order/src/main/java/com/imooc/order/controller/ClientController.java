package com.imooc.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //RestTemplate restTemplate = new RestTemplate();
        //第一种方式直接使用RestTemplate url写死
        //String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);


        //第二种方式，通过loadbalancerclient获取url
        //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        //String response = restTemplate.getForObject(url, String.class);

        //第三种方式
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response={}", response);
        return response;
    }
}
