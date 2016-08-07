package com.ciklum.controller;

import com.ciklum.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by olegnikitindev on 05.08.2016.
 */
@RestController
public class PropertiesRestController {

    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setName(HttpServletRequest request, @RequestBody UserDto dto) {
        if(StringUtils.hasText(dto.getName())) {
            request.getSession().setAttribute("userName", dto.getName());
            request.getSession().setAttribute("storageType", dto.getType());
        }
    }

}
