package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceController {

    public int diceRoll(){
        return (int) (Math.random() * 6) +1;
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping ("/roll-dice/{n}")
    public String diceResults(@PathVariable int n, Model model){
        int randomNum = diceRoll();
        String message;

        if(n == randomNum){
            message = "You are lucky!";
        }else{
            message = "Better luck next time!";
        }
        model.addAttribute("n", n);
        model.addAttribute("diceRoll", randomNum);
        model.addAttribute("message", message);


        return "roll-results";
    }
}