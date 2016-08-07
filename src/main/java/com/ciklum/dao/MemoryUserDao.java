package com.ciklum.dao;

import com.ciklum.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by olegnikitindev on 07.08.2016.
 */
public class MemoryUserDao implements UserDao<User> {

    private final AtomicLong sequence = new AtomicLong();

    private Set<User> users = new ConcurrentSkipListSet<User>();

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(users);
    }

    @Override
    public User find(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User find(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        user.setId(sequence.incrementAndGet());
        users.add(user);
    }

    @Override
    public void update(User user) {
        for (User oldUser : users) {
            if (oldUser.getId().equals(user.getId())) {
                oldUser.setName(user.getName());
                break;
            }
        }
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
