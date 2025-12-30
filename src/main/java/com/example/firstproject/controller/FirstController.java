package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "개발자");
        return "greetings";
    }

    @GetMapping("/bye/{id}")
    public String seeYouNext(@PathVariable("id") String id, Model model){
        model.addAttribute("username", id);
        return "goodbye";
    }
}
