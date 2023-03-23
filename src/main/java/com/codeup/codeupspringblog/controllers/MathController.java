package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
//    /subtract/3/from/10	7
//    /multiply/4/and/5	20
//    /divide/6/by/3	2



}
