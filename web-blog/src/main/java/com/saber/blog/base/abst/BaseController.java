package com.saber.blog.base.abst;

public abstract class BaseController {

    public static String THEME = "themes/default";

    /**
     * 主页的页面主题
     * @param viewName
     * @return
     */
    public String render(String viewName) {
        return THEME + "/" + viewName;
    }
}
