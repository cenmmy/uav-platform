package com.lxlib.uavplatform.service.dto;

import lombok.Builder;
import lombok.Data;

/**
 * User信息DTO
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
@Data
@Builder
public class RegisterInfoDTO {
    private String uname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
}
