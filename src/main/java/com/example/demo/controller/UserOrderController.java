package com.example.demo.controller;

import com.example.demo.commons.baseController.BaseController;
import com.example.demo.commons.baseService.BaseService;
import com.example.demo.po.UserOrder;
import com.example.demo.service.UserOrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Macx on 2018/1/5.
 */
@Api("")
@Controller
@RequestMapping("/api/userOrder")
public class UserOrderController extends BaseController<UserOrder,String> {

    @Autowired
    private UserOrderService userOrderService;


    @Override
    public BaseService<UserOrder, String> getService() {
        return userOrderService;
    }


}
