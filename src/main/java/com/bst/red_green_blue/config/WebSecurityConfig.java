package com.bst.red_green_blue.config;


import com.bst.red_green_blue.security.CustomUserService;
import com.bst.red_green_blue.security.MyAuthenticationSuccessHandler;
import com.bst.red_green_blue.security.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security的注解

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Bean
    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
        return new CustomUserService();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService())//user Details Service验证
                .passwordEncoder(new MyPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf() //跨站
                .disable() //关闭跨站检测
                .authorizeRequests() //验证策略
                .anyRequest()       //所有请求
                .authenticated()    //必须验证
                .and()
                .formLogin()
                .loginPage("/login")//自定义登录页
                .failureUrl("/login?error")//自定义登录失败的页面
                .successHandler(myAuthenticationSuccessHandler)//设置登录成功的处理器
                .permitAll()//登录成功后允许所有的请求
//                .defaultSuccessUrl("/welcome",true) //登录成功后跳转页
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error/myerror");//无权访问


    }



}
