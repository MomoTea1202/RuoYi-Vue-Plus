package org.dromara.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dromara.system.domain.NtfEmlTpl;
import org.dromara.system.domain.vo.NtfEmlTplVo;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

@Mapper
public interface NtfEmlTplMapper extends BaseMapperPlus<NtfEmlTpl, NtfEmlTplVo> {
        NtfEmlTpl selectEmlTplByEmlTplCode (@Param("emlTplCode")String emlTplCode);
}
