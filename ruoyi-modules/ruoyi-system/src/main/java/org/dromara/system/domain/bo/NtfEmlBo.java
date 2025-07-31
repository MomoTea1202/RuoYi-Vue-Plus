package org.dromara.system.domain.bo;


import lombok.Data;

import java.util.Map;

@Data
public class NtfEmlBo {
    private String to;
    private String from;
    private String sbj;
    private String emlTplCode;
    private Map<String, String> mapVar;
    private String appNm;
    public NtfEmlBo() {
        super();
    }
}
