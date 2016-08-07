package com.ciklum.dao;

import com.ciklum.domain.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Repository
public class DatabaseMessageDao implements MessageDao<Message> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> findAll() {
        return (List<Message>) getSession().createQuery("from Message m order by m.sender.name, id").list();
    }

    @Override
    public Message find(Long id) {
        return (Message) getSession().get(Message.class, id);
    }

    @Override
    public void create(Message message) {
        getSession().save(message);
    }

    @Override
    public void update(Message message) {
        getSession().update(message);
    }

    @Override
    public void delete(Message message) {
        getSession().delete(message);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
