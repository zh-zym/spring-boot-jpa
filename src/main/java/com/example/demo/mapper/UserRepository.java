package com.example.demo.mapper;

import com.example.demo.commons.baseRepository.Repository;
import com.example.demo.po.User;
import org.springframework.stereotype.Component;

/**
 * Created by Macx on 2018/1/4.
 */
@Component
public interface UserRepository extends Repository<User,Long>{

}
