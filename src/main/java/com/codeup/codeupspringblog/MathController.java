package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return "The sum of " + num1 + " and " + num2 + " equals: " + (num1 + num2);
    }

    @GetMapping("subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2){
        return "If you subtract " + num2 + " from " + num1 + " it equals to: " + (num1 - num2);
    }

    @GetMapping("multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2){
        return "When " + num1 + " and " + num2 + " are multiplied the sum is: " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return "When you divide " + num1 + " by " + num2 + " it equals to: " + (num1 / num2);
    }

}
