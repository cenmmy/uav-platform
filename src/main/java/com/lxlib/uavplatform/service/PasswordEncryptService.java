package com.lxlib.uavplatform.service;

import org.springframework.stereotype.Service;

/**
 * 用户密码加密服务
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
public interface PasswordEncryptService {
    /**
     * 密码加密
     *
     * @param plainText 密码明文
     * @param salt 加密盐值
     * @return 加密密文
     */
    String encrypt(String plainText, String salt);
}
