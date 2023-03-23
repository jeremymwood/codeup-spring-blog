package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/dice")
    @ResponseBody
    public String rollDice() {
        int diceRoll = (int) (Math.random() * 6) +1;
        return "rol dice: " + diceRoll;
    }

//    /add/3/and/4	7
@GetMapping("/add/{x}/and/{y}")
@ResponseBody
public String add(@PathVariable int x,@PathVariable int y) {
    int sum = x + y;
    return x + " + " + y + " = " + sum;
}

//    /subtract/3/from/10	7
@GetMapping("/subtract/{x}/from/{y}")
@ResponseBody
public String subtract(@PathVariable int x,@PathVariable int y) {
    int difference = y - x;
    return y + " - " + x + " = " + difference;
}

//    /multiply/4/and/5	20
@GetMapping("/multiply/{x}/and/{y}")
@ResponseBody
public String multiply(@PathVariable int x,@PathVariable int y) {
    int product = x * y;
    return x + " X" + y + " = " + product;
}

//    /divide/6/by/3	2
@GetMapping("/divide/{x}/and/{y}")
@ResponseBody
public String divide(@PathVariable int x,@PathVariable int y) {
    int quotient = x / y;
    return x + " / " + y + " = " + quotient;
}


}
