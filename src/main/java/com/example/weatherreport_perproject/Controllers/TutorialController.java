package com.example.weatherreport_perproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TutorialController {
    @GetMapping("/tutorial")
    public String tutorial(Model model){
        model.addAttribute("int", "Сперма");
        return "tutorial";
    }
}
