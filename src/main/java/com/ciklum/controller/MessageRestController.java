package com.ciklum.controller;

import com.ciklum.domain.Message;
import com.ciklum.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@RestController
public class MessageRestController {

    @Autowired
    private ApplicationService<Message> messageService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        Message message = messageService.find(id);
        if(message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity<?> create() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Message message = messageService.find(id);
        if(message != null) {
            messageService.delete(message);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
