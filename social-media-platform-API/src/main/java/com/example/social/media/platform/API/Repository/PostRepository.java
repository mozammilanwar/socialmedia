package com.example.social.media.platform.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Find posts by user
    List<Post> findByUser(User user);

    // Find posts containing a specific keyword in content
    List<Post> findByContentContainingIgnoreCase(String keyword);

    // Find posts by privacy settings
    List<Post> findByPrivacySettings(String privacySettings);

    // Find posts ordered by timestamp in descending order
    List<Post> findByOrderByTimestampDesc();

    // Find posts by user and ordered by timestamp
    List<Post> findByUserOrderByTimestampDesc(User user);

    // Other query methods
}


