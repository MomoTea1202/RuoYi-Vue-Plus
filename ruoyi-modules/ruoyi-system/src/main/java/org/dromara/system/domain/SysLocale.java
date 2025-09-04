package org.dromara.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 多语言翻译对象 sys_locale
 *
 * 对应前端 i18n 国际化多语言支持
 *
 */
@Data
@NoArgsConstructor
@TableName("sys_locale")
public class SysLocale {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String locale;

    private String code;

    private String value;

    public SysLocale(String locale, String code, String value) {
        this.locale = locale;
        this.code = code;
        this.value = value;
    }
}
