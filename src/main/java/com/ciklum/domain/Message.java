package com.ciklum.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Entity
@Table
public class Message implements Serializable, Cloneable, Comparable<Message> {

    private static final long serialVersionUID = 6293512124184L;

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private User sender;

    public Message() {
    }

    public Message(String text, User sender) {
        this.text = text;
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        synchronized (this) {
            return text;
        }
    }

    public void setText(String text) {
        synchronized (this) {
            this.text = text;
        }
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Message copy = new Message(String.valueOf(text), sender);
        copy.setId(Long.valueOf(id));
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!id.equals(message.id)) return false;
        return text.equals(message.text);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public int compareTo(Message other) {
        int comparableId = id.compareTo(other.getId());
        return comparableId != 0 ? comparableId : getText().compareTo(other.getText());
    }
}
