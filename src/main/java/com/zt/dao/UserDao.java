package com.zt.dao;

import com.zt.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
**  User表映射
 */
public interface UserDao {
    // 查询指定id的记录
    User selectById(@Param("id") String id);
    // 查询所有的记录
    List<User> selectAll();
    // 存储给定记录
    void insertInfo(User user);
    // 删除指定记录
    void deleteById(@Param("id") String id);
    // 修改指定记录
    void updateInfo(User user);
}
