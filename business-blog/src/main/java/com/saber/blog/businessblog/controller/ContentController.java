package com.saber.blog.businessblog.controller;

import com.github.pagehelper.PageInfo;
import com.saber.blog.businessblog.service.IContentService;
import com.saber.blog.model.Vo.ContentVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("content")
public class ContentController {

    @Resource
    private IContentService contentService;

    @GetMapping("getContents/{p}")
    public PageInfo<ContentVo> contents(@PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        return contentService.getContents(p, limit);
    }

}
