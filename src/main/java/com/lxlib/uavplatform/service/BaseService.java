package com.lxlib.uavplatform.service;

import com.lxlib.uavplatform.service.dto.RegisterInfoDTO;
import org.springframework.stereotype.Service;

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
     * @return 注册是否成功
     */
    Integer register(RegisterInfoDTO info);
}
