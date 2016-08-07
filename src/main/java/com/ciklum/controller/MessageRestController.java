package com.ciklum.controller;

import com.ciklum.domain.Message;
import com.ciklum.domain.User;
import com.ciklum.dto.UpdateMessageDto;
import com.ciklum.service.ApplicationService;
import com.ciklum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@RestController
@Scope("session")
public class MessageRestController {

    @Resource(name = "messageService")
    private ApplicationService<Message> messageService;

    @Autowired
    private UserService<User> userService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) {
        Message message = messageService.find(id);
        if (message != null) {
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity<?> create(HttpServletRequest request, @RequestParam String text) {
        if (StringUtils.hasText(text)) {
            User currentUser = getUser(request);
            Message message = new Message(text, currentUser);
            messageService.create(message);
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UpdateMessageDto dto) {
        if (StringUtils.hasText(dto.getText())) {
            Message message = messageService.find(id);
            if (message != null) {
                message.setText(dto.getText());
                messageService.update(message);
                return ResponseEntity.ok(message);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Message message = messageService.find(id);
        if (message != null) {
            messageService.delete(message);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private User getUser(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        User user = userService.find(userName);
        if (user == null) {
            user = new User(userName);
            userService.create(user);
        }
        return user;
    }
}
