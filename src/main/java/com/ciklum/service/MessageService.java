package com.ciklum.service;

import com.ciklum.dao.ApplicationDao;
import com.ciklum.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Service
public class MessageService implements ApplicationService<Message> {

    @Autowired
    private ApplicationDao<Message> applicationDao;

    @Override
    public List<Message> findAll() {
        return applicationDao.findAll();
    }

    @Override
    public Message find(Long id) {
        return applicationDao.find(id);
    }

    @Override
    public void create(Message message) {
        applicationDao.create(message);
    }

    @Override
    public void update(Message message) {
        applicationDao.update(message);
    }

    @Override
    public void delete(Message message) {
        applicationDao.delete(message);
    }
}
