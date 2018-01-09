package com.example.demo.commons.baseController;

import com.example.demo.commons.baseService.BaseService;
import com.example.demo.commons.baseService.impl.BaseServiceImpl;
import com.example.demo.commons.result.Result;
import com.sun.xml.internal.bind.v2.model.core.ID;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Macx on 2018/1/4.
 */

public abstract class BaseController<T,ID extends Serializable> {
    /**
     * 抽象业务类  T 实体对象   ID为
     * @return
     */
    public abstract  BaseService<T,ID> getService();




    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
    @ApiOperation("单个查找")
    @ResponseBody
    public Result findOne(ID id){
        return Result.success(getService().findOne(id));
    }

    @ApiOperation("单个添加")
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(T t) {
        getService().add(t);
        return Result.success(null);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    @ApiOperation("根据Id删除")
    @ResponseBody
    public Result delete(ID id) {
        getService().delete(id);
        return Result.success(null);
    }



    /**
     * 更新
     * @param t
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation("更新")
    @ResponseBody
    public Result update(T t) {
        getService().update(t);
        return  Result.success(null);
    }

    /**
     * 查找所有
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ApiOperation("查询所有")
    @ResponseBody
    public Result findAll() {
         return Result.success(getService().findAll());
    }


//    protected Predicate toPredicate(T t, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//        List<Predicate> predicates = new ArrayList<>();
//        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
//
//    }
//
//    /**
//     * 分页实现
//     * @param t 查找的对象
//     * @param pageable 分页条件
//     * @return
//     */
//    @Override
//    public Page<T> findByPage(final T t, Pageable pageable) {
//        return getRepository().findAll(new Specification<T>() {
//            @Override
//            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return BaseServiceImpl.this.toPredicate(t,root,criteriaQuery,criteriaBuilder);
//            }
//        }, pageable);
//    }


}
