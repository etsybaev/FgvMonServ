package com.fgvmonserv.controller;

import com.fgvmonserv.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class RootDomainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
}
