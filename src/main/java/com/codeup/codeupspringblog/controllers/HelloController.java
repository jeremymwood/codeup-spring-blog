package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//tell spring this class is a controller
@Controller
@RequestMapping(path = "/join")
class HelloController {

//    method for url
//    @GetMapping("/hello")
//    return is a response for url
//    @ResponseBody
//    public String hello() {
//        return "Hello from Spring!";
//    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }

//@RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//@ResponseBody
//public String addOne(@PathVariable int number) {
//    return number + " + 1 = " + (number + 1) + "!";
//}
//
//    @GetMapping("/hello/{name}")
//    public String sayHello(@PathVariable String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }

    @GetMapping()
    public String showJoinForm() {
        return "join";
    }

    @PostMapping()
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

}


