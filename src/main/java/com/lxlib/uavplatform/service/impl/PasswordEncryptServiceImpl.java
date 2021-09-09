package com.lxlib.uavplatform.service.impl;

import com.lxlib.uavplatform.service.PasswordEncryptService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

/**
 * 密码加密服务
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
@Service
public class PasswordEncryptServiceImpl implements PasswordEncryptService {

    private static final String HASH_ALGORITHM_NAME = "MD5";
    private static final int HASH_ITERATIONS = 2;

    @Override
    public String encrypt(String plainText, String salt) {
        SimpleHash simpleHash = new SimpleHash(HASH_ALGORITHM_NAME, plainText, salt, HASH_ITERATIONS);
        return simpleHash.toString();
    }
}
