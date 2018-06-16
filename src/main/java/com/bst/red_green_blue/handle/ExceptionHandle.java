package com.bst.red_green_blue.handle;

import com.bst.red_green_blue.common.ResponseCode;
import com.bst.red_green_blue.common.ServerResponse;
import com.sun.activation.registries.MailcapParseException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author XHJ
 * 2018/4/10 23:40
 * 统一异常处理类(未完成 待续..)
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ServerResponse handle(Exception e) {
        System.out.println(e.getClass());
//        if(e instanceof CustomException){
//            CustomException exception = (CustomException) e;
//            return ServerResponse.createByErrorCodeMessage(Integer.parseInt(exception.getCode()),exception.getMessage());
//        }
        return ServerResponse.createByErrorCodeMessage(Integer.parseInt(ResponseCode.UNKNOWN_EXCEPTION.getCode())
                ,ResponseCode.UNKNOWN_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = MailcapParseException.class)
    public ServerResponse handle(MailcapParseException e) {
        System.out.println(e.getClass());
        System.out.println("TOKEN_EXCEPTION");
        return ServerResponse.createByErrorCodeMessage(Integer.parseInt(ResponseCode.TOKEN_EXCEPTION.getCode())
                    ,ResponseCode.TOKEN_EXCEPTION.getMessage());

    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ServerResponse handle(AccessDeniedException e) {
        System.out.println(e.getClass());
        System.out.println("ROLE_EXCEPTION");
        return ServerResponse.createByErrorCodeMessage(Integer.parseInt(ResponseCode.ROLE_EXCEPTION.getCode())
                ,ResponseCode.ROLE_EXCEPTION.getMessage());

    }

}
