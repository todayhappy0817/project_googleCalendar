package com.project1.project1.aop;

import com.project1.project1.utils.restResponse.RestResponseUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.util.Arrays;
import java.util.MissingResourceException;

@Aspect
@Component
public class OauthCheckAspect {
    @Around("@annotation(com.project1.project1.aop.OauthCheck) && @annotation(loginCheck)")
    public Object test(ProceedingJoinPoint joinPoint, OauthCheck loginCheck) throws Throwable {
        //예외를 일으키는 방식으로 채택가능
        //        if(true) throw new MissingServletRequestParameterException("loginCheck", "String");
        String value = loginCheck.value();
        String test = loginCheck.test();
        System.out.println("LoginCheck value: " + value);
        System.out.println("LoginCheck test: " + test);
        System.out.println("LoginCheck type: " + loginCheck.type());
        //@loginCheck에서 받은 데이터

        System.out.println("Method execution param: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("Method execution start: " + joinPoint.getSignature().toShortString());
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Exception in method: " + joinPoint.getSignature().toShortString());
            throw e;
        }
        System.out.println("Method execution end: " + joinPoint.getSignature().toShortString());
        return result;
    }
}
