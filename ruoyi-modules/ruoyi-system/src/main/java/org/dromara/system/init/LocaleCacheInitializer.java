package org.dromara.system.init;

import lombok.extern.slf4j.Slf4j;
import org.dromara.system.mapper.SysLocaleMapper;
import org.dromara.system.service.SysLocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Slf4j
@Component
public class LocaleCacheInitializer {

    @Autowired
    private SysLocaleMapper sysLocaleMapper;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private SysLocaleService sysLocaleService;

    @EventListener(ApplicationReadyEvent.class)
    public void preloadLocales() {
        log.info("🌐 Preloading locale data into cache...");
        sysLocaleService.getAllLocaleValues();
        log.info("✅ All locales cached successfully.");
    }
}
