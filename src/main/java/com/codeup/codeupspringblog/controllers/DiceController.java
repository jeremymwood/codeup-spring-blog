package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String getDice() {return "roll-dice";}

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        int diceRoll = (int) (Math.random() * 6) +1;
        model.addAttribute("n", "Your guess was: " + n + ". \n The answer was: " + diceRoll);
//        return "roll-dice/" + n;
        return "roll-dice";
    }

}
