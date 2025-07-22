package org.dromara.system.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface SysLocaleService {

  void getAllLocaleValues();

    String getLocaleMessage(String locale, String code);

    Map<String, Object> getLocaleMessage(String locale);

    ResponseEntity<Map<String, Object>> getLocaleJson(String locale);

}
