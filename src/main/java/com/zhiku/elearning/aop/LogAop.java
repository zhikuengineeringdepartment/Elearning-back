package com.zhiku.elearning.aop;


import com.zhiku.elearning.entity.User;
import com.zhiku.elearning.entity.mysql.LogEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

//TODO 目前记录了所有的请求，不过对于不含token的请求，即使是已经登录也无法知道具体用户，这个需要配合前端，让前端每个请求都带上token

/**
 * 用户日志行为的切面
 */
@Component
@Aspect
public class LogAop {
    //使用log4j2.xml中配置的名为log的日志对象
    private final Logger logger = LoggerFactory.getLogger(LogAop.class);

    //切面面向controller包下的所有请求，在请求完成之后嵌入
    @After(value = "execution(* com.zhiku.elearning.controller.*.*(*)))")
    public void after(JoinPoint pjp) {
        //获得request对象
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        //创建日志记录对象
        LogEntity logEntity = new LogEntity();
        //记录本次请求者的ip
        logEntity.setIp(request.getRemoteAddr());
        Object[] args = pjp.getArgs();
        //如果切面的参数个数大于0，检查是否有User类型的参数，有则记录本次请求的用户
        if (args.length > 0) {
            if (args[0] instanceof User) {
                logEntity.setUser((User) args[0]);
            }
            //记录剩余参数的参数名和参数值
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            String[] argNames = methodSignature.getParameterNames();
            for (int i = 0; i < argNames.length; i++) {
                logEntity.addItemToArgs(argNames[i], args[i]);
            }
        }
        //记录本次请求的url
        logEntity.setRequestName(pjp.getSignature().getName());
        //打印日志
        logger.info("{}", logEntity);
    }
}
