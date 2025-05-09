package com.example.lab4_gtics_20251_20211602.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "index";  // Carga index.html desde templates
    }
}
