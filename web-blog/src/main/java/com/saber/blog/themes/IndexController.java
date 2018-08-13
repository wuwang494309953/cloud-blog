package com.saber.blog.themes;

import com.saber.blog.base.abst.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController extends BaseController {

    @GetMapping(value = "page/{p}")
    public String index(@PathVariable int p, @RequestParam(value = "limit", defaultValue = "12") int limit, Model model) {

        return render("index");
    }

}
