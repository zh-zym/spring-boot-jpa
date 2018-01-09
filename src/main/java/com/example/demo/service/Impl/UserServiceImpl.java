package com.example.demo.service.Impl;

import com.example.demo.commons.baseRepository.Repository;
import com.example.demo.commons.baseService.BaseService;
import com.example.demo.commons.baseService.impl.BaseServiceImpl;
import com.example.demo.mapper.UserRepository;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Macx on 2018/1/4.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Repository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User add(User user) {
        //防止更新
        user.setId(null);
        return super.add(user);
    }
}
