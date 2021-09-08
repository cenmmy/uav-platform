package com.lxlib.uavplatform.repository.enity;

import lombok.Data;

/**
 * User vo
 *
 * @author chengmanyuan
 * @date 2021/09/07
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户住址
     */
    private String address;
    /**
     * 用户手机号
     */
    private String phone;
}
