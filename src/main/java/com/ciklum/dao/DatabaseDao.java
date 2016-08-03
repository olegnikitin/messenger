package com.ciklum.dao;

import com.ciklum.domain.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Repository
public class DatabaseDao implements ApplicationDao<Message> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public Message find(Long id) {
        return null;
    }

    @Override
    public Message update(Message message) {
        return null;
    }

    @Override
    public void delete(Message message) {

    }
}
