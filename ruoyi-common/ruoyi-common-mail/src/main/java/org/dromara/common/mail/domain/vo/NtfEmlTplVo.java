package org.dromara.common.mail.domain.vo;

import lombok.Data;

@Data
public class NtfEmlTplVo {

    protected String emlTplCode;
    protected String emlHtmlBodySpt;
    protected String emlSbj;
    protected String stsCode;
    protected String sndrEml;
}
