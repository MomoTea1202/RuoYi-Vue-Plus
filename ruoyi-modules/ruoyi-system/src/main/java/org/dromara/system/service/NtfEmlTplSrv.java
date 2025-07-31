package org.dromara.system.service;

import jakarta.activation.DataSource;
import org.dromara.system.domain.bo.NtfEmlBo;

public interface NtfEmlTplSrv {


    void getEmlTmp(NtfEmlBo ntfEmlBo, DataSource attachment);
}
