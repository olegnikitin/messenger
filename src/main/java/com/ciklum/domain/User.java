package com.ciklum.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Entity
@Table
public class User implements Serializable, Cloneable, Comparable<User> {

    private static final long serialVersionUID = 6293184L;

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Transient
    private Set<Message> messages = new TreeSet<Message>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        User copy = new User();
        copy.setName(String.valueOf(name));
        copy.setId(Long.valueOf(id));
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User other) {
        int comparableId = id.compareTo(other.getId());
        return comparableId != 0 ? comparableId : getName().compareTo(other.getName());
    }
}
