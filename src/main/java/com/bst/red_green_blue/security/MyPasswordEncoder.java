package com.bst.red_green_blue.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by 熊厚谨 on 2018/6/15 13:31
 *
 * @author 熊厚谨
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();

    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());

    }
}
