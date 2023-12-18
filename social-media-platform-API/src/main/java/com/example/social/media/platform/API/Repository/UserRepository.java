package com.example.social.media.platform.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> findByUsernameIgnoreCase(String username);

    List<User> findByBioContainingIgnoreCase(String keyword);

    List<User> findByUsernameIn(List<String> usernames);

    List<User> findByOrderByUsernameAsc();

    List<User> findByOrderByTimestampDesc();

    // Find users whose email is verified
    List<User> findByEmailVerifiedTrue();

    // Find users whose bio is not null
    List<User> findByBioIsNotNull();

    // Find users by a range of timestamps
    List<User> findByTimestampBetween(long startTimestamp, long endTimestamp);

    // Find users by a specific role
    List<User> findByRolesContaining(String role);

    // Find users by a combination of conditions
    List<User> findByUsernameIgnoreCaseAndRolesContaining(String username, String role);

    // Find users by a combination of conditions with OR
    List<User> findByUsernameIgnoreCaseOrRolesContaining(String username, String role);

    // Other query methods
}



