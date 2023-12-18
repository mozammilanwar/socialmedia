package com.example.social.media.platform.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    // Find friendships by user
    List<Friendship> findByUser(User user);

    // Find friendships by friend
    List<Friendship> findByFriend(User friend);

    // Find friendships by user and friend
    Optional<Friendship> findByUserAndFriend(User user, User friend);

    // Find pending friendships for a user
    List<Friendship> findByUserAndStatus(User user, FriendshipStatus status);

    // Find accepted friendships for a user
    List<Friendship> findByUserAndStatusOrderByTimestampDesc(User user, FriendshipStatus status);


}


