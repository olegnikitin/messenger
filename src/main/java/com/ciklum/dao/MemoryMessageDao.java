package com.ciklum.dao;

import com.ciklum.domain.Message;
import com.ciklum.domain.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
public class MemoryMessageDao implements ApplicationDao<Message> {

    private final AtomicLong sequence = new AtomicLong();

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
    public void create(Message message) {
        message.setId(sequence.incrementAndGet());
        //TODO: Add
    }

    @Override
    public void update(Message message) {

    }

    @Override
    public void delete(Message message) {

    }
}
