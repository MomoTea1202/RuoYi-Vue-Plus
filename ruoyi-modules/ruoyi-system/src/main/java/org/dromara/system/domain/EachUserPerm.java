package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("each_usr_perm")
public class EachUserPerm {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String menuId;
    private String permList;

}
