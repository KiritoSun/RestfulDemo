package com.zt.service.Impl;

import com.zt.common.Result;
import com.zt.dao.UserDao;
import com.zt.domain.User;
import com.zt.service.UserService;
import com.zt.util.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.rmi.CORBA.Util;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao dao;
    @Resource
    private ResultUtil resultUtil;

    @Override
    public Result<User> findUserById(String id) {
        User user = null;
        try{
            user = dao.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return resultUtil.ERROR("后台操作出现异常！",null);
        }finally {}
        if(exist(id)) return resultUtil.SUCCESS("成功！",user);
        else return resultUtil.ERROR("用户信息不存在！",null);
    }

    @Override
    public Result<List<User>> findAllUser() {
        List<User> list = null;
        try{
            list = dao.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            return resultUtil.ERROR("后台操作出现异常！",null);
        }finally {}
        return resultUtil.SUCCESS("成功！",list);
    }

    @Override
    public Result<User> saveUser(User user) {
        if(exist(user.getU_id())) return resultUtil.ERROR("用户信息已存在！",null);
        try{
            dao.insertInfo(user);
        }catch (Exception e){
            e.printStackTrace();
            return resultUtil.ERROR("后台操作出现异常！",null);
        }
        return resultUtil.SUCCESS("成功！",null);
    }

    @Override
    public Result<User> removeUser(String id) {
        if(!exist(id)) return resultUtil.ERROR("用户id不存在！",null);
        try{
            dao.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return resultUtil.ERROR("后台操作出现异常！",null);
        }
        return resultUtil.SUCCESS("成功！",null);
    }

    @Override
    public Result<User> updateUser(User user) {
        if(!exist(user.getU_id())) return resultUtil.ERROR("用户id不存在！",null);
        try{
            dao.updateInfo(user);
        }catch (Exception e){
            e.printStackTrace();
            return resultUtil.ERROR("后台操作出现异常！",null);
        }
        return resultUtil.SUCCESS("成功！",null);
    }

    public boolean exist(String id){
        if(dao.selectById(id)!=null) return true;
        else return false;
    }
}
