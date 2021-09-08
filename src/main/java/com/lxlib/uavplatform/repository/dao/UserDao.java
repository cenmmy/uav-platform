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
     * 获取全部用户信息
     *
     * @return 用户数据
     */
    List<User> getAllUser();
}
