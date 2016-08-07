package com.ciklum.service;

import com.ciklum.dao.UserDao;
import com.ciklum.domain.User;
import com.ciklum.enums.StorageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
@Service
@Transactional
@Scope("session")
public class UserServiceImpl implements UserService<User> {

    private UserDao<User> userDao;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void init() {
        StorageType storageType = (StorageType) httpServletRequest.getSession().getAttribute("storageType");
        if (storageType == StorageType.DATABASE) {
            userDao = (UserDao<User>) applicationContext.getBean("databaseUserDao");
        } else if (storageType == StorageType.MEMORY) {
            userDao = (UserDao<User>) applicationContext.getBean("memoryUserDao");
        }
    }

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
