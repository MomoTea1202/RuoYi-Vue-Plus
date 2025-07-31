package org.dromara.system.service.impl;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import lombok.RequiredArgsConstructor;
import org.dromara.system.service.GoogleTwoFAService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoogleTwoFAServiceImpl implements GoogleTwoFAService {
    private final GoogleAuthenticator gAuth;


    @Override
    public String enableTwoFactor(Long userId) {
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        String secret = key.getKey();
        return secret;
    }

    @Override
    public boolean verifyCode(Long userId, int verificationCode,String secret) {

        if (secret == null) {
            return false;
        }
        return gAuth.authorize(secret, verificationCode);
    }
}
