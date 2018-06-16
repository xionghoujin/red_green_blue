package com.bst.red_green_blue.pojo.vo;

import lombok.Data;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.Collection;

/**
 * Created by 熊厚谨 on 2018/6/16 11:48
 *
 * @author 熊厚谨
 */
@Data
public class LoginParam implements UserDetails{

    @NotBlank(message = "username 不能为空")
    private String username;
    @NotBlank(message = "password 不能为空")
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
