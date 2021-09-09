package com.lxlib.uavplatform.controller;

import com.lxlib.uavplatform.exception.BusinessException;
import com.lxlib.uavplatform.exception.SystemException;
import com.lxlib.uavplatform.repository.dao.UserDao;
import com.lxlib.uavplatform.service.BaseService;
import com.lxlib.uavplatform.service.dto.RegisterInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.InvalidParameterException;

/**
 * @author chengmanyuan
 * @date 2021/09/07
 */
@RestController
@Slf4j
public class BaseController {

    @Resource
    BaseService baseService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterInfoDTO info) {
        try {
            baseService.register(info);
            return "注册成功！";
        } catch (SystemException e) {
            log.error("系统异常: ex: ", e);
            return e.getMessage();
        } catch (BusinessException e) {
            log.error("业务异常: ex: ", e);
            return e.getMessage();
        } catch (Exception e) {
            log.error("未知异常！error: ", e);
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        try {
            Boolean hasLogin = baseService.login(username, password);
            if (hasLogin) {
                return "登录成功！";
            } else {
                return "账号或密码名错误";
            }
        }  catch (SystemException e) {
            log.error("系统异常: ex: ", e);
            return e.getMessage();
        } catch (BusinessException e) {
            log.error("业务异常: ex: ", e);
            return e.getMessage();
        } catch (Exception e) {
            log.error("未知异常！error: ", e);
            return e.getMessage();
        }
    }
}
