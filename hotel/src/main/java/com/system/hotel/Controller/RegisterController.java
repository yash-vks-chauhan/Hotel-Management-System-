package com.system.hotel.Controller;

import com.system.hotel.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Tag(name = "User Registration", description = "Handles user registration in the hotel management system")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register a new user", description = "Registers a new user with a username and password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "Redirects to login page after successful registration"),
            @ApiResponse(responseCode = "400", description = "Username already exists or other registration error")
    })
    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        System.out.println("Register request received: " + username);

        try {
            userService.registerUser(username, password);
            System.out.println("User registered: " + username);
            model.addAttribute("message", "User registered successfully. Please log in.");
        } catch (Exception e) {
            System.out.println("Error while registering user: " + e.getMessage());
            model.addAttribute("message", "Username already exists.");
        }

        return "redirect:/login.html"; // Redirects to login page
    }
}