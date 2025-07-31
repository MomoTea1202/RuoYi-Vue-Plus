package org.dromara.system.service;

public interface GoogleTwoFAService {
    String enableTwoFactor(Long userId);

    boolean verifyCode(Long userId, int verificationCode,String secret);
}
