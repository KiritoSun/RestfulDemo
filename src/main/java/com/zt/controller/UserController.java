package com.zt.controller;

import com.zt.common.Result;
import com.zt.domain.User;
import com.zt.service.UserService;
import com.zt.util.CookieUtil;
import org.springframework.web.bind.annotation.*;
import sun.dc.pr.PRError;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
**  用户信息controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;
    @Resource
    private CookieUtil cookieUtil;

    //  根据id获取用户实体
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public Result<User> findUserById(@PathVariable("id") String id){
        return service.findUserById(id);
    }

    //  获取所有用户信息
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public Result<List<User>> findUser(){
        return service.findAllUser();
    }

    //  存储用户信息
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result<User> saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

    //  修改用户信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result<User> update(@RequestBody User user){
        return service.updateUser(user);
    }

    //  根据id删除用户信息
    @RequestMapping(value = "/remove/{id}",method = RequestMethod.POST)
    public Result<User> removeUser(@PathVariable("id") String id){
        return service.removeUser(id);
    }

    //  信息存入cookie
    @RequestMapping(value = "/set",method = RequestMethod.POST)
    public void setCookie(@RequestParam("name") String name,
                           @RequestParam("value") String value, HttpServletResponse response){
        cookieUtil.setCookie(response,name,value);
    }

    //  cookie信息取出
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getCookie(@RequestParam("name") String name, HttpServletRequest request){
        return cookieUtil.getCookie(request,name);
    }
}
