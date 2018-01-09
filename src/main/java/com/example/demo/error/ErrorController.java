package com.example.demo.error;

import com.example.demo.commons.result.Result;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Macx on 2018/1/4.
 */
@ControllerAdvice
@ResponseStatus
public class ErrorController {

    /**
     * 用户主键唯一异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result commonsException(ConstraintViolationException ex){
        ex.printStackTrace();
        //
        if ("UK_lqjrcobrh9jc8wpcar64q1bfh".equals(ex.getConstraintName())){
            return Result.fail("用户名唯一",400);
        }
        return Result.fail(ex.getMessage(),400);
    }

    /**
     * 运行时异常统一处理
     * @param rex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result runtimeException(RuntimeException rex){
        rex.printStackTrace();
        return Result.fail(rex.getMessage(),100000);
    }



    /**
     * 页面统一异常处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
        return "error";
    }


}
