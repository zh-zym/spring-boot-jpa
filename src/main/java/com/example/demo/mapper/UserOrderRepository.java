package com.example.demo.mapper;

import com.example.demo.commons.baseRepository.Repository;
import com.example.demo.po.User;
import com.example.demo.po.UserOrder;
import org.springframework.stereotype.Component;

/**
 * Created by Macx on 2018/1/5.
 */
@Component
public interface UserOrderRepository  extends Repository<UserOrder,String> {

}
