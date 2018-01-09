package com.example.demo.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Macx on 2018/1/5.
 */
@Entity
@Table
@ApiModel("订单表")
public class UserOrder {
    @Id
    @ApiModelProperty("订单Id,主键")
    @GeneratedValue(generator = "user-uuid")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)    //标示为主键
    @GenericGenerator(name = "user-uuid",strategy = "uuid") //使用hibernate uuid主键生成策略
//    @Column(name = "id",columnDefinition = "varchar",length = 128,unique = true)  //指定参数类型
    private String id;

    @ApiModelProperty("订单标题")
    private String title;

    @ApiModelProperty("描述")
    @Column(columnDefinition = "TEXT")
    private String description;


    @ApiModelProperty("订单用户")
    @ManyToOne                  //注意这个不要懒加载
    @NotNull
    private User user;
//
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
