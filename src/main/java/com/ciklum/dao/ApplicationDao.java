package com.ciklum.dao;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
public interface ApplicationDao<T> {
    List<T> findAll();
    T find(Long id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
