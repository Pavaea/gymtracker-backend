package com.gymtracker.backend.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String adminIndex(){
        return "admin-index";
    }
}
