package com.project1.project1.aop;

import com.project1.project1.dto.UserDTO;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface OauthCheck {
    String value() default "";
    String test() default "";
    public static enum UserType{
        USER,ADMIN
    }
    UserType type() default UserType.USER;
}