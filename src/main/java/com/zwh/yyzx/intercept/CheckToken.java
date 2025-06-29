package com.zwh.yyzx.intercept;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckToken implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        放行预检
        if (request.getMethod().equalsIgnoreCase("options")) {
            return true;
        }
        //静态图片访问
        if (request.getRequestURL().toString().contains("/images")) {
            return true;
        }
        //token校验
        String token = request.getHeader("token");
        if (token == null) {
            throw new Exception("token is null,please log in");
        } else {
            //校验token的有效性(正确性，时效性)
            JwtParser parser = Jwts.parser();
//解析token的SigningKey.必须和生成token时的密码一致
            parser.setSigningKey("hzw123456");
//如果tokn正确，则正常执行，否则抛出异常
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        }
        return true;
    }
}
