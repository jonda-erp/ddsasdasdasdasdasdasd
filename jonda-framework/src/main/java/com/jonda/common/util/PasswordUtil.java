package com.jonda.common.util;

import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

/**
 * Created by rejoady on 2014/7/18.
 */
public class PasswordUtil {

    // 加密盐的长度
    public static final Integer PASSWORD_SALT_LENGTH = 8;

    //加密Hash处理次数
    public static final Integer HASH_INTERACTIONS = 1024;

    /**
     * 密码加密
     *
     * @param planPassword
     * @param salt
     * @return
     */
    public static String encryptPassword(String planPassword, String salt) {
        byte[] byteSalt = salt.getBytes();
        byte[] hashPassword = Digests.sha1(planPassword.getBytes(), byteSalt, HASH_INTERACTIONS);
        return Encodes.encodeHex(hashPassword);
    }

    /**
     * 获取密码加密用的盐
     *
     * @return
     */
    public static String getPasswordSalt() {
        byte[] salt = Digests.generateSalt(PASSWORD_SALT_LENGTH);
        return Encodes.encodeHex(salt);
    }

}
