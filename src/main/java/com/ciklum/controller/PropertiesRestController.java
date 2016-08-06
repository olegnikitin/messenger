package com.ciklum.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by olegnikitindev on 05.08.2016.
 */
@RestController
public class PropertiesRestController {

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public void setName(HttpServletRequest request, @RequestParam("userName") String name) {
        if(name != null && StringUtils.hasText(name)) {
            request.getSession().setAttribute("userName", name);
        }
    }

}
