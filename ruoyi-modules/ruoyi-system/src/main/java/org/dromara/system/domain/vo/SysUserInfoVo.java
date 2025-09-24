package org.dromara.system.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * 用户信息
 *
 * @author Michelle.Chung
 */
@Data
public class SysUserInfoVo {

    /**
     * 用户信息
     */
    private SysUserVo user;

    /**
     * 角色ID列表
     */
    private String roleKey;

    /**
     * 角色列表
     */
    private SysRoleVo roles;



}
