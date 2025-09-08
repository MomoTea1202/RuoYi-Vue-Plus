package org.dromara.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;
import org.dromara.system.domain.SysUsrPerm;
import org.dromara.system.domain.vo.SysUserVo;
import org.dromara.system.domain.vo.SysUsrPermVo;

public interface SysUsrPermMapper  extends BaseMapperPlus<SysUsrPerm, SysUserVo> {
    Page<SysUsrPermVo> selectUsrPermList(@Param("page") Page<SysUsrPerm> page,@Param(Constants.WRAPPER) Wrapper<SysUsrPerm> queryWrapper);
}
