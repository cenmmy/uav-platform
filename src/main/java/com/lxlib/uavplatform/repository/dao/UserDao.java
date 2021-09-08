package com.lxlib.uavplatform.repository.dao;

import com.lxlib.uavplatform.repository.enity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表dao
 *
 * @author chengmanyuan
 * @date 2021/09/07
 */
@Repository
public interface UserDao {
    /**
     * 插入一条用户信息
     *
     * @param user 用户
     * @return 修改成功的记录数
     */
    int insert(User user);

    /**
     * 通过用户名查询用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    User getUserByName(String name);
}
