package com.example.demo.annotion;

import java.lang.annotation.*;

/**
 * Created by Macx on 2018/1/4.
 * 登陆注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME) //运行时
@Target(ElementType.METHOD)  //用在方法上
public @interface LoginRequire {
    String value() default "";
}
