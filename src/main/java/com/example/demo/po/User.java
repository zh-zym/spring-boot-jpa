package com.example.demo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.lang.annotation.ElementType;
import java.util.List;

/**
 * Created by Macx on 2018/1/4.
 */
@Entity
@Table
@ApiModel("用户")
public class User {

    @Id
    @ApiModelProperty("主键")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自动增长  相当于auto_increment
    private Long id;

    @ApiModelProperty("用户名")
    @Column(name = "user_name",length = 18,unique = true)//改字段类型为text  字段唯一
    private String userName;

    @ApiModelProperty("密码")
    @Column(length = 128)
    private String password;

    @ApiModelProperty("年龄")
    private int age;

    @ApiModelProperty("手机号码")
    @Column(length = 11)
    private String phone;


//    @ApiModelProperty("用户订单")
//    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)     //设置lazy加载  设置关联字段
//    private List<UserOrder> orders;
//
//    public List<UserOrder> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<UserOrder> orders) {
//        this.orders = orders;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
