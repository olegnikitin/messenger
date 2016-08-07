package com.ciklum.service;

import com.ciklum.dao.UserDao;
import com.ciklum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
@Service
@Transactional
@Scope("session")
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserDao<User> userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User find(Long id) {
        return userDao.find(id);
    }

    public User find(String name) {
        return userDao.find(name);
    }

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
