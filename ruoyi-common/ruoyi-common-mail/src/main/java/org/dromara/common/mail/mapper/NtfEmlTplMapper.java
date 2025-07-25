package org.dromara.common.mail.mapper;

import org.apache.ibatis.annotations.Param;
import org.dromara.common.mail.domain.NtfEmlTpl;
import org.dromara.common.mail.domain.vo.NtfEmlTplVo;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

public interface NtfEmlTplMapper extends BaseMapperPlus<NtfEmlTpl, NtfEmlTplVo> {
        NtfEmlTpl selectEmlTplByEmlTplCode (@Param("emlTplCode")String emlTplCode);
}
