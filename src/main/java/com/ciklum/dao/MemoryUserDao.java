package com.ciklum.dao;

import com.ciklum.domain.User;

import java.util.List;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public class MemoryUserDao implements UserDao<User> {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public User find(String name) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
