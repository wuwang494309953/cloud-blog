package com.saber.blog.test;

import com.saber.blog.feignservice.IContentService;
import com.saber.blog.test.feignservice.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestService testService;

    @Autowired
    private IContentService contentService;

    @GetMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/test1", String.class);

        System.out.println(callServiceResult);
        return callServiceResult;
    }

    @GetMapping("/call1")
    public String call1() {
        String pageInfo =  contentService.getContents(1, 10);
        System.out.println(pageInfo);
        return testService.test();
    }

}
