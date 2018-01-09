package com.example.demo.commons.baseService.impl;

import com.example.demo.commons.baseRepository.Repository;
import com.example.demo.commons.baseService.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macx on 2018/1/4.
 * 抽象业务统一实现
 * T bean 类  ID 主键类型
 */
@Transactional
public abstract class BaseServiceImpl<T ,ID extends Serializable> implements BaseService<T,ID> {


    public abstract Repository<T,ID> getRepository();


    @Override
    public T add(T t) {
        return getRepository().saveAndFlush(t);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(ID id) {
        getRepository().delete(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    /**
     * 更新
     * @param t
     */
    @Override
    public void update(T t) {
        getRepository().save(t);
    }

    /**
     * 查找所有
     */
    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    protected Predicate toPredicate(T t, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        return cb.and(predicates.toArray(new Predicate[predicates.size()]));

    }

    /**
     * 分页实现
     * @param t 查找的对象
     * @param pageable 分页条件
     * @return
     */
    @Override
    public Page<T> findByPage(final T t, Pageable pageable) {
        return getRepository().findAll(new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return BaseServiceImpl.this.toPredicate(t,root,criteriaQuery,criteriaBuilder);
            }
        }, pageable);
    }
}
