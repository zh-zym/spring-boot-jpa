package com.example.demo.controller;

import com.example.demo.commons.baseController.BaseController;
import com.example.demo.commons.baseService.BaseService;
import com.example.demo.po.User;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Macx on 2018/1/4.
 */
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController<User,Long> {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 默认业务
     * @return
     */
    @Override
    public BaseService<User, Long> getService() {
        return userService;
    }


}
