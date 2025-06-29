package com.zwh.yyzx.handler;

import com.zwh.yyzx.utils.ResultVo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobleExeptionhandler {
    //异常处理
    //signatureExceptiontoken的非法操作
    @ExceptionHandler(SignatureException.class)
    @ResponseBody
    public ResultVo SignatureExceptionHandler(SignatureException e) {
        return ResultVo.fail("token的非法操作", "token_error");
    }

    //MalformedJwtException token解析异常
    @ExceptionHandler(MalformedJwtException.class)
    @ResponseBody
    public ResultVo SignatureExceptionHandler(MalformedJwtException e) {
        return ResultVo.fail("token解析异常", "token_error");
    }

    //ExpiredJwtException过时
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    public ResultVo SignatureExceptionHandler(ExpiredJwtException e) {
        return ResultVo.fail("登录超时，请重新登录", "token_.error");
    }
    //jdk异常api提供的异常可以统一个Exception处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo ExceptionHandler(Exception e) {
        if (e.getMessage().contains("token")){
            return ResultVo.fail(e.getMessage(), "token_error");
        }
        return ResultVo.fail(e.getMessage());
    }

}
