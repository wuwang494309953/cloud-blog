package com.saber.blog.test.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-producer")
public interface TestService {

    @GetMapping("/test1")
    String test();

}
