package com.ciklum.service;

import com.ciklum.dao.MessageDao;
import com.ciklum.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Service
@Transactional
@Scope("session")
public class MessageService implements ApplicationService<Message> {

    @Autowired
    private MessageDao<Message> messageDao;

    @Override
    public List<Message> findAll() {
        return messageDao.findAll();
    }

    @Override
    public Message find(Long id) {
        return messageDao.find(id);
    }

    @Override
    public void create(Message message) {
        messageDao.create(message);
    }

    @Override
    public void update(Message message) {
        messageDao.update(message);
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }
}
