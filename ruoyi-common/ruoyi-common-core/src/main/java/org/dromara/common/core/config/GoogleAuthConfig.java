package org.dromara.common.core.config;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleAuthConfig {

    @Bean
    public GoogleAuthenticator googleAuthenticator() {
        // 可根据需要自定义时间窗口、误差大小等：
        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder()
            .setTimeStepSizeInMillis(30_000)   // 30秒一窗
            .setWindowSize(3)                  // 向前/向后各3步可接受
            .build();
        return new GoogleAuthenticator(config);
    }
}
