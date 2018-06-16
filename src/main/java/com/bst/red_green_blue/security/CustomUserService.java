package com.bst.red_green_blue.security;

import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.util.RoleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊厚谨 on 2018/6/14 23:08
 *
 * @author 熊厚谨
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;



    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        logger.info("登录用户名：" + username);

        User user = userMapper.selectByUsername(username);
        if(user == null){
            logger.info("用户名不存在：" + username);
            throw new UsernameNotFoundException("用户名不存在");
        }
        String role = RoleUtil.RoleValidate(user.getMark());

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
        authorities.add(new SimpleGrantedAuthority(role));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
