package com.zt.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
**  Cookie操作封装
 */
@Component
public class CookieUtil {
    // 获取cookie内容
    public String getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie e : cookies){
                if(e.getName().equals(name)) return e.getValue();
            }
        }
        return null;
    }

    // 设置cookie
    public void setCookie(HttpServletResponse response,String name,String value){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
    }
}
