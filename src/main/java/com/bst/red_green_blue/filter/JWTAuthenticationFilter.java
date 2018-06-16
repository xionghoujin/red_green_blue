//package com.bst.red_green_blue.filter;
//
//import com.bst.red_green_blue.common.Constant;
//import com.bst.red_green_blue.util.JwtUtil;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// * @author 熊厚谨
// * @version 1.0.0
// */
//public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader(Constant.AUTH_KEY);
//        if (header == null || !header.startsWith(JwtUtil.getAuthorizationHeaderPrefix())) {
//            chain.doFilter(request, response);
//            return;
//        }
//        UsernamePasswordAuthenticationToken authenticationToken = getUsernamePasswordAuthenticationToken(header);
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request, response);
//    }
//
//    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
//        String user = Jwts.parser()
//                .setSigningKey(Constant.SECRET)
//                .parseClaimsJws(token.replace(JwtUtil.getAuthorizationHeaderPrefix(), ""))
//                .getBody()
//                .getSubject();
//        if (null != user) {
//            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//        }
//        return null;
//    }
//}
