package org.dromara.system.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dromara.common.redis.utils.RedisUtils;
import org.dromara.system.domain.SysLocale;
import org.dromara.system.mapper.SysLocaleMapper;
import org.dromara.system.service.SysLocaleService;
import org.redisson.api.RBucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysLocaleServiceImpl implements SysLocaleService {

    @Autowired
    private SysLocaleMapper sysLocaleMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String SYS_LOCALE_JSON = "SYS_LOCALE_JSON:";

    @Override
    public void getAllLocaleValues() {
        List<SysLocale> sysLocales = sysLocaleMapper.selectList(null);

        Map<String, Map<String, String>> localeMap = new HashMap<>();
        for (SysLocale sysLocale : sysLocales) {
            localeMap
                .computeIfAbsent(sysLocale.getLocale(), k -> new HashMap<>())
                .put(sysLocale.getCode(), sysLocale.getValue());
        }

        for (Map.Entry<String, Map<String, String>> entry : localeMap.entrySet()) {
            String locale = entry.getKey();
            Map<String, String> map = entry.getValue();
            try {
                String json = objectMapper.writeValueAsString(map); // Convert Map to JSON string
                RedisUtils.getClient().getBucket(SYS_LOCALE_JSON + locale).set(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getLocaleMessage(String locale, String code) {
        RBucket<String> bucket = RedisUtils.getClient().getBucket(SYS_LOCALE_JSON + locale);
        String json = bucket.get();
        if (json == null) {
            return null;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> flatMap = mapper.readValue(json, new TypeReference<>() {});
            return flatMap.get(code);
        } catch (IOException e) {
            // You may want to log this
            return null;
        }
    }



    @Override
    public Map<String, Object> getLocaleMessage(String locale) {
        RBucket<String> bucket = RedisUtils.getClient().getBucket(SYS_LOCALE_JSON + locale);
        String json = bucket.get();
        if (json == null) {
            return Collections.emptyMap();
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> flatMap = mapper.readValue(json, new TypeReference<>() {});
            return convertToNestedMap(flatMap);
        } catch (IOException e) {
            // You may want to log this
            return Collections.emptyMap();
        }
    }


    @Override
    public ResponseEntity<Map<String, Object>> getLocaleJson( String locale) {
        RBucket<String> bucket = RedisUtils.getClient().getBucket(SYS_LOCALE_JSON + locale);
        String json = bucket.get();
        if (json == null) return ResponseEntity.notFound().build();

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> map = mapper.readValue(json, new TypeReference<>() {});
            return ResponseEntity.ok(map);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public static Map<String, Object> convertToNestedMap(Map<String, String> flatMap) {
        Map<String, Object> result = new HashMap<>();

        for (Map.Entry<String, String> entry : flatMap.entrySet()) {
            String[] keys = entry.getKey().split("\\.");
            Map<String, Object> current = result;

            for (int i = 0; i < keys.length - 1; i++) {
                String key = keys[i];
                Object value = current.get(key);

                // Safely cast using helper method
                Map<String, Object> nestedMap = asMap(value);
                if (nestedMap == null) {
                    nestedMap = new HashMap<>();
                    current.put(key, nestedMap);
                }

                current = nestedMap;
            }

            current.put(keys[keys.length - 1], entry.getValue());
        }

        return result;
    }

    private static Map<String, Object> asMap(Object obj) {
        if (!(obj instanceof Map<?, ?> rawMap)) {
            return null;
        }

        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<?, ?> entry : rawMap.entrySet()) {
            Object key = entry.getKey();
            if (!(key instanceof String)) {
                return null; // Non-string key found, abort
            }
            result.put((String) key, entry.getValue());
        }

        return result;
    }



}
