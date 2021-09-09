package com.lxlib.uavplatform.service;

import com.lxlib.uavplatform.service.dto.RegisterInfoDTO;

/**
 * 基础服务，登录，注册等
 *
 * @author chengmanyuan
 * @date 2021/09/10
 */
public interface BaseService {
    /**
     * 注册用户
     * @param info 注册信息
     */
    void register(RegisterInfoDTO info);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 登录是否成功
     */
    Boolean login(String username, String password);
}
