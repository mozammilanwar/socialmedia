package com.example.social.media.platform.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Autowire other dependencies as needed

    /**
     * Registers a new user based on the provided UserRegistrationDTO.
     *
     * @param registrationDTO The UserRegistrationDTO containing information about the user registration
     */
    public void registerUser(UserRegistrationDTO registrationDTO) {
        // Implementation to register a new user
        // Note: Additional logic to handle user registration, password hashing, saving to the repository, etc.

        // Create a new User entity
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        // Add other attributes as needed

        // Save the user to the repository
        userRepository.save(user);
    }

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user to retrieve
     * @return The User object representing the retrieved user
     */
    public User getUserByUsername(String username) {
        // Implementation to retrieve a user by username

        // Find the user by username
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    /**
     * Updates the user profile based on the provided UserProfileDTO.
     *
     * @param profileDTO The UserProfileDTO containing information about the user profile update
     */
    public void updateUserProfile(UserProfileDTO profileDTO) {
        // Implementation to update user profile
        // Note: Additional logic to handle user profile update, saving to the repository, etc.

        // Find the user by ID
        User user = userRepository.findById(profileDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Update user profile attributes
        user.setBio(profileDTO.getBio());
        // Add other attributes as needed

        // Save the updated user to the repository
        userRepository.save(user);
    }

    // Other user-related methods can be added as needed
}

