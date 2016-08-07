package com.ciklum.dao;

import com.ciklum.domain.User;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public interface UserDao<T extends User> extends ApplicationDao<T> {
    T find(String name);
}
