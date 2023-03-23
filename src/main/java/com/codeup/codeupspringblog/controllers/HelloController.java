package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//tell spring this class is a controller
@Controller
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

@RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
@ResponseBody
public String addOne(@PathVariable int number) {
    return number + " + 1 = " + (number + 1) + "!";
}



}
