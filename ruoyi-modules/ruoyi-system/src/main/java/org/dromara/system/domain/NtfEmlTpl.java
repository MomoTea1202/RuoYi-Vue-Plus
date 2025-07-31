package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.OwnBaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
public class NtfEmlTpl extends OwnBaseEntity {
    @TableId(value = "eml_tpl_code")
    protected String emlTplCode;
    protected String emlHtmlBodySpt;
    protected String emlSbj;
    protected String stsCode;
    protected String sndrEml;
    public NtfEmlTpl() {
        super();
    }
}
