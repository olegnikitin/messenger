package com.ciklum.service;

import com.ciklum.dao.ApplicationDao;
import com.ciklum.domain.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Service
public class MessageService implements ApplicationService<Message> {

    private ApplicationDao<Message> applicationDao;

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
