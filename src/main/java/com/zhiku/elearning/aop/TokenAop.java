package com.zhiku.elearning.aop;

import com.zhiku.elearning.entity.User;
import com.zhiku.elearning.exception.TokenVerifyErrorException;
import com.zhiku.elearning.exception.UserNotFoundException;
import com.zhiku.elearning.service.UserService;
import com.zhiku.elearning.util.JWTUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 用户身份验证的切面
 */
@Component
@Aspect
public class TokenAop {
    @Autowired
    UserService userService;

    /**
     * 用户登录检测的切面
     * 该切面面向controller下所有第一个参数为User的请求，在进入请求前嵌入
     *
     * @param pjp 切点
     * @throws UserNotFoundException     未找到用户异常
     * @throws TokenVerifyErrorException token验证失败异常
     */
    @Before(value = "execution(* com.zhiku.elearning.controller.*.*(com.zhiku.elearning.entity.User,..))" +
            "||execution(* com.zhiku.elearning.controller.*.*.*(com.zhiku.elearning.entity.User,..))")
    //对于controller下的任意带有User user参数的请求进行拦截，带user的请求都是需要需要验证token的
    public void before(JoinPoint pjp) throws UserNotFoundException, TokenVerifyErrorException {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = getCookieByName(request.getCookies());
        User user = ((User) (pjp.getArgs()[0]));     //获取切面的第一个参数对象user
        //依据token解析的结果重新给切面的user对象赋值
        user.setUid(JWTUtil.getUid(token));
        user.setUserUsername(JWTUtil.getUserName(token));
    }

    /**
     * 管理员登录认证的切面
     * 该切面面向AdminController下的所有请求，在进入请求前嵌入
     *
     * @param pjp 切点
     * @throws UserNotFoundException     未找到用户异常
     * @throws TokenVerifyErrorException token验证失败异常
     */
    @Before(value = "execution(* com.zhiku.elearning.controller.admin.*.*(..))")
    public void adminBefore(JoinPoint pjp) throws UserNotFoundException, TokenVerifyErrorException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取uri
        String requestURI = request.getRequestURI();
        String token = getCookieByName(request.getCookies());
        User user = userService.getUserByUsername(JWTUtil.getUserName(token));
        //检查该用户是否是admin用户，即它的权限值为a（admin），普通的用户权限值为u（user）
        if (!userService.checkAuthority(user, requestURI)) {
            throw new TokenVerifyErrorException("抱歉，您没有该权限！");
        }
    }


    /**
     * 从request的Cookies中提取出相应的cookie的值
     *
     * @param cookies request的cookies列表
     * @return 对应name的cookie值
     */
    private String getCookieByName(Cookie[] cookies) {
        String value = "";
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                value = cookie.getValue();
            }
        }
        return value;
    }

}
