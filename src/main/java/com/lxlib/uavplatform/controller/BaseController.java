package com.lxlib.uavplatform.controller;

import com.lxlib.uavplatform.repository.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chengmanyuan
 * @date 2021/09/07
 */
@RestController
@RequestMapping(path = "/base")
@Slf4j
public class BaseController {
    @Autowired
    private UserDao userDao;
    /**
     * 返回网站首页
     *
     * @return 首页html
     */
    @GetMapping("/home")
    public String home() {
        log.info("get request home!");
        return "home";
    }
}
