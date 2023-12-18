package com.example.social.media.platform.API.Controller;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        userService.registerUser(registrationDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        UserProfileDTO userProfileDTO = // Convert user entity to DTO
        return ResponseEntity.ok(userProfileDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUserProfile(@RequestBody UserProfileDTO profileDTO) {
        userService.updateUserProfile(profileDTO);
        return ResponseEntity.ok("User profile updated successfully");
    }
}

