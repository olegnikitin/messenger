package com.ciklum.service;

import com.ciklum.domain.User;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public interface UserService<T extends User> extends ApplicationService<T> {
    T find(String name);
}
