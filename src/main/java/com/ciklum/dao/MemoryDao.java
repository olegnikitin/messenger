package com.ciklum.dao;

import com.ciklum.domain.Message;
import com.ciklum.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Repository
public class MemoryDao implements ApplicationDao<Message> {

    private Map<User, List<Message>> storage = new ConcurrentHashMap<User, List<Message>>();

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
