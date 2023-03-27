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
        int answer = (int) (Math.random() * 6) +1;
        model.addAttribute("n", n);
        model.addAttribute("answer", answer);
        return "guess";
    }

}
