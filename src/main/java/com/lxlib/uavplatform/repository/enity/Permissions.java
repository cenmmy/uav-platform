package com.lxlib.uavplatform.repository.enity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 权限实体类
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
@Data
@AllArgsConstructor
public class Permissions {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 权限code
     */
    private String code;
    /**
     * 权限名称
     */
    private String permissionsName;
}
