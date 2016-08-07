package com.ciklum.service;

import com.ciklum.dao.MessageDao;
import com.ciklum.domain.Message;
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
 * Created by olegnikitindev on 04.08.2016.
 */
@Service
@Transactional
@Scope("session")
public class MessageService implements ApplicationService<Message> {

    private MessageDao<Message> messageDao;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostConstruct
    @SuppressWarnings("unchecked")
    private void init() {
        StorageType storageType = (StorageType) httpServletRequest.getSession().getAttribute("storageType");
        if (storageType == StorageType.DATABASE) {
            messageDao = (MessageDao<Message>) applicationContext.getBean("databaseMessageDao");
        } else if (storageType == StorageType.MEMORY) {
            messageDao = (MessageDao<Message>) applicationContext.getBean("memoryMessageDao");
        }
    }

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
