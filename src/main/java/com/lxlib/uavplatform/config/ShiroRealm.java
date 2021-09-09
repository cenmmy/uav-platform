package com.lxlib.uavplatform.config;

import com.lxlib.uavplatform.repository.dao.UserDao;
import com.lxlib.uavplatform.repository.enity.Permissions;
import com.lxlib.uavplatform.repository.enity.Role;
import com.lxlib.uavplatform.repository.enity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义ShiroRealm类
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    UserDao userDao;

    /**
     * 权限配置
     *
     * @param principalCollection 重要信息
     * @return 返回权限配置的结果
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 进行身份认证，判断用户名和密码是否正确
     *
     * @param authenticationToken 用户提交的认证token
     * @return 是否认证成功
     * @throws AuthenticationException 认证失败异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        String username = (String) authenticationToken.getPrincipal();
        if (username == null || username.length() == 0) {
            return null;
        }

        // 根据用户名获取用户信息
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException();
        }

        // 判断账号是否被锁定， 状态: (0: 禁用， 1: 锁定，2: 启用)
        if (user.getState() == 0) {
            throw new DisabledAccountException();
        }

        if (user.getState() == 1) {
            throw new LockedAccountException();
        }

        // 验证用户密码正确性, shiro会自动帮助我们进行密码校验，即token中的用户信息和我们传递的用户信息对比
        return new SimpleAuthenticationInfo(
                user.getUname(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
    }
}
