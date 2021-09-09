package com.lxlib.uavplatform.service.impl;

import com.lxlib.uavplatform.repository.dao.UserDao;
import com.lxlib.uavplatform.repository.enity.User;
import com.lxlib.uavplatform.service.BaseService;
import com.lxlib.uavplatform.service.PasswordEncryptService;
import com.lxlib.uavplatform.service.dto.RegisterInfoDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.UUID;

/**
 * 基础服务实现
 *
 * @author chengmanyuan
 * @date 2021/09/10
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Resource
    UserDao userDao;

    @Resource
    PasswordEncryptService passwordEncryptService;

    @Override
    public Integer register(RegisterInfoDTO info) {
        // 参数前置校验
        if (info == null || info.getUname() == null || info.getPassword() == null) {
            throw new InvalidParameterException();
        }
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        User user = User.builder().uuid(UUID.randomUUID().toString().replaceAll("-", ""))
                .uname(info.getUname())
                .password(passwordEncryptService.encrypt(info.getPassword(), salt))
                .salt(salt)
                .email(info.getEmail())
                .state(2)
                .ctime(System.currentTimeMillis())
                .utime(System.currentTimeMillis()).build();
        return userDao.insert(user);
    }
}
