package com.example.demo.annotationImpl;

import com.example.demo.annotion.UserAnnotation;
import com.example.demo.commons.type.CommonsType;
import com.example.demo.po.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Objects;

/**
 * Created by Macx on 2018/1/4.
 * 用户信息获取的注解
 */
public class UserAnnotationImpl implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return  methodParameter.hasParameterAnnotation(UserAnnotation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        User user = null;
        user = (User)nativeWebRequest.getAttribute(CommonsType.LOGIN,NativeWebRequest.SCOPE_SESSION);
        if (Objects.nonNull(user)){
            return user;
        }else{
            throw new RuntimeException("用户信息异常");
        }
    }
}
