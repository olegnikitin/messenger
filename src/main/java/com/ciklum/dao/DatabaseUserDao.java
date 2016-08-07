package com.ciklum.dao;

import com.ciklum.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
@Repository
public class DatabaseUserDao implements UserDao<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return getSession().createQuery("from User order by id").list();
    }

    @Override
    public User find(Long id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public User find(String name) {
        return (User) getSession().createQuery("from User where name = :name").setString("name", name).uniqueResult();
    }

    @Override
    public void create(User user) {
        getSession().save(user);
    }

    @Override
    public void update(User user) {
        getSession().update(user);
    }

    @Override
    public void delete(User user) {
        getSession().delete(user);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
