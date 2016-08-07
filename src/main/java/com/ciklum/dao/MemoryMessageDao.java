package com.ciklum.dao;

import com.ciklum.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
public class MemoryMessageDao implements ApplicationDao<Message> {

    private final AtomicLong sequence = new AtomicLong();

    private final Set<Message> messages = new ConcurrentSkipListSet<Message>();//TODO: Return clones

    @Override
    public List<Message> findAll() {
        List<Message> copy = null;
        try {
            copy = new ArrayList<Message>(messages.size());
            for (Message message : messages) {
                copy.add((Message) message.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

    @Override
    public Message find(Long id) {
        try {
            for (Message message : messages) {
                if (message.getId().equals(id)) {
                    return (Message) message.clone();
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Message message) {
        message.setId(sequence.incrementAndGet());
        messages.add(message);
    }

    @Override
    public void update(Message message) {
        for (Message oldMessage : messages) {
            if (oldMessage.getId().equals(message.getId())) {
                message.setText(message.getText());
                break;
            }
        }
    }

    @Override
    public void delete(Message message) {
        messages.remove(message);
    }
}
