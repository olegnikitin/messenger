package com.ciklum.dao;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
public interface ApplicationDao<T> {
    List<T> findAll();
    T find(Long id);
    T update(T t);
    void delete(T t);
}
