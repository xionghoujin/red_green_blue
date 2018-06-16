package com.bst.red_green_blue.security;


import com.bst.red_green_blue.dao.UserMapper;
import com.bst.red_green_blue.pojo.User;
import com.bst.red_green_blue.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 熊厚谨 on 2018/6/5 16:50
 *
 * @author 熊厚谨
 * 自定义登录成功的返回处理
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserMapper userMapper;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

            logger.info("登录成功");
            //判断是什么返回的方式
            response.setContentType("application/json;charset=UTF-8");
            //将authentication转换成json格式的字符串，再写进response中
            response.getWriter().write(objectMapper.writeValueAsString(authentication));

        String username = request.getParameter("username");
        User user = userMapper.selectByUsername(username);

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        String token = JwtUtil.createJWT(userJson);

        System.out.println(token);

        response.getWriter().write(objectMapper.writeValueAsString(authentication));
        response.getWriter().write(token);
            //默认的（跳转）
//            super.onAuthenticationSuccess(request,response,authentication);
        }



    }

