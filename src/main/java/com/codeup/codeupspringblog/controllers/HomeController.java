package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
//    @GetMapping("/home/")
    @GetMapping("/home/{personName}")
//    @ResponseBody
    public String welcome(@RequestParam(name = "age") int age, @PathVariable String personName, Model model) {
//        for /home
        model.addAttribute("name", "Jeremy Wood");
        model.addAttribute("personName", personName);
        model.addAttribute("personAge", age);
        return "home/home";
    }

}
