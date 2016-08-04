package com.ciklum.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Entity
@Table
public class Message implements Serializable {

    private static final long serialVersionUID = 6293512124184L;

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne(optional = false)
    private User sender;

    @ManyToOne(optional = false)
    private User recipient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!id.equals(message.id)) return false;
        if (!text.equals(message.text)) return false;
        if (!sender.equals(message.sender)) return false;
        return recipient.equals(message.recipient);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + sender.hashCode();
        result = 31 * result + recipient.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
