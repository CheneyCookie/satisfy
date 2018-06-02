package com.cheney.satisfy.service;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

    T getById(int id);

    PageInfo<T> getByPage(PageInfo<T> pagination);

    Boolean addOne(T t);

    Boolean updateOne(T t);

    boolean deleteById(int id);
}
