package userdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    private ResponseEntity<Map<String, String>> response(String status, String message, int statusCode) {
        Map<String, String> response = new HashMap<>();
        response.put("status", status);       
        response.put("message", message);
        return ResponseEntity.status(statusCode).body(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        userService.addNewUser(user);
        return response("success", "User registered successfully", 201);
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> update(@RequestBody User user) {
        userService.updateUser(user);
        return response("success", "User updated successfully", 200);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User loginData) {
        User result = userService.login(loginData.getName(), loginData.getPassword());
        if (result != null) {
            return response("success", "Login successful", 200);
        } else {
            return response("error", "Invalid credentials", 401);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        userService.logOut(); 
        return response("success", "Logged out successfully", 200);
    }
}
