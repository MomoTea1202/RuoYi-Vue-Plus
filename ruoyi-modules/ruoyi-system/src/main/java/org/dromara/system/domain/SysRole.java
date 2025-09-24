package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 角色表 sys_role
 *
 * @author Lion Li
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class SysRole extends BaseEntity {

    /**
     * 角色权限
     */
    @TableId(value = "role_key")
    private String roleKey;

    /**
     * 角色名称
     */
    private String roleName;



    /**
     * 角色排序
     */
    private Integer roleSort;



    /**
     * 角色状态（0正常 1停用）
     */
    private String status;


    public SysRole(String roleKey) {
        this.roleKey = roleKey;
    }

}
