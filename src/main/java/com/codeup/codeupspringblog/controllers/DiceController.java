package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String getDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@RequestParam(name = "n") int n, Model model) {
        model.addAttribute("n", n);
        int diceRoll = (int) (Math.random() * 6) +1;
        return "diceRoll/" + n;
    }

}
