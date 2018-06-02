package com.cheney.satisfy.dao;

import com.github.pagehelper.Page;

public interface BaseDao<T> {

    T getById(int id);

    Page<T> getByPage();

    int addOne(T t);

    boolean updateOne(T t);

    boolean deleteById(int id);
}
