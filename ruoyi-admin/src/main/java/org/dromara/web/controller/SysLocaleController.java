package org.dromara.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dromara.common.redis.utils.RedisUtils;
import org.dromara.system.service.SysLocaleService;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/sys/api/locale")
public class SysLocaleController {

    @Autowired
    private SysLocaleService sysLocaleService;

    @GetMapping("/refreshLocale")
    public void refreshLocale() {
       sysLocaleService.getAllLocaleValues();
    }

   @GetMapping("/getLocaleMessage")
    public String getLocaleMessage(@RequestParam String locale, @RequestParam String code) {
        return sysLocaleService.getLocaleMessage(locale,code);
    }


    @GetMapping("/getLocaleMessages")
    public Map<String, Object>  getLocaleMessages(@RequestParam String locale) {
        return sysLocaleService.getLocaleMessage(locale);
    }


    @GetMapping("/getLocaleJson/{locale}")
    public ResponseEntity<Map<String, Object>> getLocaleJson(@PathVariable String locale) {
        return sysLocaleService.getLocaleJson(locale);
    }


}
