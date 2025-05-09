package com.system.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/login.html";  // Redirect to the login page
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "hotels.html"; // Redirect to hotel list page after login
    }
}