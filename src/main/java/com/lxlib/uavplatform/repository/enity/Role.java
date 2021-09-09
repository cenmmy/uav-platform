package com.lxlib.uavplatform.repository.enity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * 角色实体类
 *
 * @author chengmanyuan
 * @date 2021/09/08
 */
@Data
@AllArgsConstructor
public class Role {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色code
     */
    private String code;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色权限集合
     */
    private Set<Permissions> permissions;
}
