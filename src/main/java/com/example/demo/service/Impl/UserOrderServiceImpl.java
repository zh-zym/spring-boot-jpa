package com.example.demo.service.Impl;

import com.example.demo.commons.baseRepository.Repository;
import com.example.demo.commons.baseService.BaseService;
import com.example.demo.commons.baseService.impl.BaseServiceImpl;
import com.example.demo.mapper.UserOrderRepository;
import com.example.demo.po.UserOrder;
import com.example.demo.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by Macx on 2018/1/5.
 */
@Service
public class UserOrderServiceImpl extends BaseServiceImpl<UserOrder,String> implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public Repository<UserOrder, String> getRepository() {
        return userOrderRepository;
    }

    @Override
    public void update(UserOrder userOrder) {
        if (Objects.isNull(userOrder.getUser())){
            throw new RuntimeException("用户信息不能为空");
        }
        super.update(userOrder);
    }
}
