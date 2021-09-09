package com.lxlib.uavplatform.service.impl;

import com.lxlib.uavplatform.exception.BusinessException;
import com.lxlib.uavplatform.repository.dao.UserDao;
import com.lxlib.uavplatform.repository.enity.User;
import com.lxlib.uavplatform.service.BaseService;
import com.lxlib.uavplatform.service.PasswordEncryptService;
import com.lxlib.uavplatform.service.dto.RegisterInfoDTO;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

/**
 * 基础服务实现
 *
 * @author chengmanyuan
 * @date 2021/09/10
 */
@Service
public class BaseServiceImpl implements BaseService {

    private static final SecureRandomNumberGenerator GENERATOR = new SecureRandomNumberGenerator();

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
        // 判断用户是否已经存在
        if (userDao.getUserByName(info.getUname()) != null) {
            throw new BusinessException("用户名已存在！");
        }

        // 生成盐值
        String salt = GENERATOR.nextBytes().toHex();
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
