package com.ciklum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by olegnikitindev on 04.08.2016.
 */
@Controller
public class ViewController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
