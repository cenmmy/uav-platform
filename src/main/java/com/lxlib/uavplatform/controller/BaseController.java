package com.lxlib.uavplatform.controller;

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
            Integer res = baseService.register(info);
            return "" + res;
        } catch (InvalidParameterException e) {
            log.error("参数不合法！error: ", e);
        } catch (Exception e) {
            log.error("系统异常！error: ", e);
        }
        return "error!";
    }
}
