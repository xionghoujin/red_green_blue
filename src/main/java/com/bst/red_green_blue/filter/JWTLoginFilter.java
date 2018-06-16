//package com.bst.red_green_blue.filter;
//
//import com.alibaba.fastjson.JSONObject;
//import com.bst.red_green_blue.common.Constant;
//import com.bst.red_green_blue.common.ServerResponse;
//import com.bst.red_green_blue.pojo.vo.LoginParam;
//import com.bst.red_green_blue.pojo.vo.UserVo;
//import com.bst.red_green_blue.service.IUserService;
//import com.bst.red_green_blue.util.JwtUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//
///**
// * @author 熊厚谨
// * @version 1.0.0
// */
//
//public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
//    @Autowired
//    private IUserService userService;
//    private AuthenticationManager authenticationManager;
//
//    public JWTLoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    // 接收并解析用户凭证
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse res) throws AuthenticationException {
//        try {
//            LoginParam user = new ObjectMapper()
//                    .readValue(req.getInputStream(), LoginParam.class);
////            String captcha = user.getCaptcha();
////            //将验证码加入到session中
////            String session_captcha = (String) req.getSession().getAttribute(Consts.IMAGE_CODE);
////            if(StringUtils.isEmpty(captcha)){
////                throw new YcException(RespCode.PARAM_ERROR, "验证码为空");
////            }else if(!captcha.toLowerCase().equals(session_captcha.toLowerCase())){
////                throw new YcException(RespCode.PARAM_ERROR, "验证码错误");
////            }
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            user.getUsername(),
//                            user.getPassword(),
//                            new ArrayList<>())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        LoginParam user = new ObjectMapper()
//                .readValue(request.getInputStream(), LoginParam.class);
//
//        Gson gson = new Gson();
//        String userJson = gson.toJson(user);
//        String token = JwtUtil.createJWT(userJson);
//        response.addHeader(Constant.AUTH_KEY, JwtUtil.getTokenHeader(token));
//
//        ServerResponse<UserVo> login = userService.login(user.getUsername(), user.getPassword());
//        String result = JSONObject.toJSONString(login);
//        PrintWriter writer = response.getWriter();
//        writer.write(result);
//    }
//}
