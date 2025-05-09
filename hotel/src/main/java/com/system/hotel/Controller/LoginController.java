package com.system.hotel.Controller;

import com.system.hotel.model.User;
import com.system.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional; // Import Optional

@RestController
@RequestMapping("/auth")
// *** IMPORTANT: Make sure this origin matches where your login.html is served from! ***
// *** If login.html is at localhost:8081, change this to 8081 ***
@CrossOrigin(origins = "http://localhost:8081")
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    // Registration Endpoint
    @PostMapping("/register")
    public Map<String, Object> registerUser(@RequestBody User user) { // Expects JSON from frontend
        Map<String, Object> response = new HashMap<>();

        // --- Improved Check using Optional ---
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            // --- ---
            response.put("success", false);
            response.put("message", "Username already exists!");
            // Consider returning ResponseEntity here too for better status code control (e.g., 409 Conflict)
        } else {
            // Basic validation could be added here (check for blank username/password)
            userRepository.save(user); // Saves plain text password
            response.put("success", true);
            response.put("message", "User registered successfully!");
            // Consider returning ResponseEntity status 201 Created
        }

        return response; // Returns status 200 OK by default
    }

    // Login Endpoint - UPDATED
    @PostMapping("/perform_login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestParam String username, @RequestParam String password) { // Expects form-urlencoded data
        Map<String, Object> response = new HashMap<>();

        Optional<User> userOptional = userRepository.findByUsername(username); // Use Optional

        // Check if user exists first
        if (userOptional.isEmpty()) {
            response.put("success", false);
            response.put("message", "Invalid username or password!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // User exists, get it
        User user = userOptional.get();

        // Plain text password comparison
        if (!user.getPassword().equals(password)) {
            response.put("success", false);
            response.put("message", "Invalid username or password!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        } else {
            // --- SUCCESS ---
            response.put("success", true);
            response.put("message", "Login successful!");

            // *** ADD THIS LINE ***
            response.put("userId", user.getId()); // Add the user's ID to the response
            // *******************

            return ResponseEntity.ok(response); // Return 200 OK with the response body
        }
    }
}