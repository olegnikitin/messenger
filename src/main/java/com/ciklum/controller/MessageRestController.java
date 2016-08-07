package com.ciklum.controller;

import com.ciklum.domain.Message;
import com.ciklum.domain.User;
import com.ciklum.service.ApplicationService;
import com.ciklum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@RestController
public class MessageRestController {

    @Autowired
    private ApplicationService<Message> messageService;

    @Autowired
    private UserService userService;

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
    public ResponseEntity<?> create(HttpServletRequest request, @RequestParam String text) {
        if(StringUtils.hasText(text)) {
            Message message = new Message(text, getUser(request));
            messageService.create(message);
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestParam String text) {
        if(StringUtils.hasText(text)) {
            Message message = messageService.find(id);
            if(message != null) {
                message.setText(text);
                messageService.update(message);
                return ResponseEntity.ok(message);
            }
        }
        return ResponseEntity.badRequest().build();
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

    private User getUser(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        User user = userService.find(userName);
        if(user == null) {
            user = new User(userName);
            userService.create(user);
        }
        return user;
    }
}
