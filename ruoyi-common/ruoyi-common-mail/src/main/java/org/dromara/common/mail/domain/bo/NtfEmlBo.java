package org.dromara.common.mail.domain.bo;


import lombok.Data;

import java.util.Map;

@Data
public class NtfEmlBo {
    private String to;
    private String from;
    private String sbj;
    private String emlTplCode;
    private Map<String, Object> mapVar;
    private String appNm;
    public NtfEmlBo() {
        super();
    }
}
