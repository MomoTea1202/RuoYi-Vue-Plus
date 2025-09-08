package org.dromara.system.service.impl;

import jakarta.activation.DataSource;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mail.utils.MailUtils;
import org.dromara.system.domain.NtfEmlTpl;
import org.dromara.system.domain.bo.NtfEmlBo;
import org.dromara.system.mapper.NtfEmlTplMapper;
import org.dromara.system.service.NtfEmlTplSrv;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class NtfEmlTplSrvImp implements NtfEmlTplSrv {
    private final NtfEmlTplMapper mailMapper;
    private static SpringTemplateEngine tplEng;
    private static JavaMailSender emlSender;
    @Override
    public void getEmlTmp(NtfEmlBo ntfEmlBo, DataSource attachment) {
        if (null == ntfEmlBo) {
            return;
        }
        NtfEmlTpl ntfEmlTpl = mailMapper.selectEmlTplByEmlTplCode(ntfEmlBo.getEmlTplCode());
        if (null == ntfEmlTpl) {
            return;
        }
        String appNm ="Ezpay";
        String sndrEml = null;
        if (StringUtils.isBlank(ntfEmlBo.getFrom())) {
            sndrEml = ntfEmlTpl.getSndrEml();
        } else {
            sndrEml = ntfEmlBo.getFrom();
        }
        String tplCode = ntfEmlBo.getEmlTplCode();
        Map<String, String> map = ntfEmlBo.getMapVar();
        String to = ntfEmlBo.getTo();
        String subject = ntfEmlTpl.getEmlSbj().replace("<ApplicationName>",appNm);
        String htmlBody = ntfEmlTpl.getEmlHtmlBodySpt();
        String msg = prepareEmlMsgContent(htmlBody,map);
        MailUtils.sendEmlWithTpl(sndrEml,to,subject,msg,attachment);
    }

    public String prepareEmlMsgContent(String htmlBody, Map<String, String> properties) {

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String oriStr = "\"${" + entry.getKey() + "}\"";
            if(StringUtils.contains(htmlBody,oriStr))
            {
                htmlBody = StringUtils.replace(htmlBody,oriStr,entry.getValue());
            }

        }
        return htmlBody;

    }
}
