package com.zt.service;

import com.zt.common.Result;
import com.zt.domain.User;

import java.util.List;

/*
**  用户信息管理逻辑
 */
public interface UserService {
    // 根据id查询用户信息
    Result<User> findUserById(String id);
    // 查询所有用户信息
    Result<List<User>> findAllUser();
    // 存储用户信息
    Result<User> saveUser(User user);
    // 移除用户信息
    Result<User> removeUser(String id);
    // 修改用户信息
    Result<User> updateUser(User user);
}
