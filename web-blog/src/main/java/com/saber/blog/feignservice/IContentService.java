package com.saber.blog.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-producer")
public interface IContentService {

    /**
     *查询文章返回多条数据
     * @param p 当前页
     * @param limit 每页条数
     * @return ContentVo
     */
    @GetMapping("/content/getContents/{p}")
    String getContents(@PathVariable("p") Integer p, @RequestParam(value = "limit", defaultValue = "12")Integer limit);

}
