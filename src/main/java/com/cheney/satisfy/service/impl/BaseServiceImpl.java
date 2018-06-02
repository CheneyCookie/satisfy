package com.cheney.satisfy.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cheney.satisfy.dao.BaseDao;
import com.cheney.satisfy.dao.PaperDao;
import com.cheney.satisfy.dao.QuestionDao;
import com.cheney.satisfy.dao.UserDao;
import com.cheney.satisfy.service.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {

    private final String DAO = "Dao";
    private final String BASE_DAO = "baseDao";

    protected BaseDao baseDao;

    @Autowired
    protected UserDao userDao;
    @Autowired
    protected QuestionDao questionDao;
    @Autowired
    protected PaperDao paperDao;

    private Class clazz;

    public BaseServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }

    @PostConstruct
    public void init() {
        String className = clazz.getSimpleName();
        String classDao = className.substring(0, 1).toLowerCase() + className.substring(1) + DAO;
        try {
            Field currentDaoField = this.getClass().getSuperclass().getDeclaredField(classDao);
            Field baseDaoField = this.getClass().getSuperclass().getDeclaredField(BASE_DAO);
            baseDaoField.set(this, currentDaoField.get(this));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getById(int id) {
        return (T) baseDao.getById(id);
    }

    @Override
    public PageInfo<T> getByPage(PageInfo<T> pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        Page page = baseDao.getByPage();
        pageInfo = new PageInfo<T>(page);
        return pageInfo;
    }

    @Override
    public Boolean addOne(T t) {
        int id = baseDao.addOne(t);
        if (id == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean updateOne(T t) {
        return baseDao.updateOne(t);
    }

    @Override
    public boolean deleteById(int id) {
        return baseDao.deleteById(id);
    }
}
