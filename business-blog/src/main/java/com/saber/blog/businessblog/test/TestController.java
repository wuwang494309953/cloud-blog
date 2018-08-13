package com.saber.blog.businessblog.test;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test1")
    public String test1() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("data","saber");
        return jsonObject.toString();
    }
}
