package com.lxlib.uavplatform.repository.enity;

import lombok.Builder;
import lombok.Data;

/**
 * User vo
 *
 * @author chengmanyuan
 * @date 2021/09/07
 */
@Data
@Builder
public class User {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private String uuid;
    /**
     * 用户姓名
     */
    private String uname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 更新时间
     */
    private Long utime;
}
