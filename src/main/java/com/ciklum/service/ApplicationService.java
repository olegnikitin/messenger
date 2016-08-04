package com.ciklum.service;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
public interface ApplicationService<T> {
    List<T> findAll();
    T find(Long id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
