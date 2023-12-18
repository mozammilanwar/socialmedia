package com.example.social.media.platform.API.Service;

import com.example.social.media.platform.API.Repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Sends a friend request from one user to another.
     *
     * @param friendshipDTO The FriendshipDTO containing information about the friend request
     */
    public void sendFriendRequest(FriendshipDTO friendshipDTO) {
        // Find users involved in the friendship
        User user = userRepository.findById(friendshipDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        User friend = userRepository.findById(friendshipDTO.getFriendId())
                .orElseThrow(() -> new IllegalArgumentException("Friend not found"));

        // Create a new Friendship entity with PENDING status
        Friendship friendship = new Friendship(user, friend, FriendshipStatus.PENDING);

        // Save the friendship in the repository
        friendshipRepository.save(friendship);
    }

    /**
     * Accepts a friend request.
     *
     * @param friendshipDTO The FriendshipDTO containing information about the friend request
     */
    public void acceptFriendRequest(FriendshipDTO friendshipDTO) {
        // Find the friendship to accept
        Friendship friendship = friendshipRepository.findById(friendshipDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Friendship not found"));

        // Update the status to ACCEPTED
        friendship.setStatus(FriendshipStatus.ACCEPTED);

        // Save the updated friendship in the repository
        friendshipRepository.save(friendship);
    }

    /**
     * Gets a list of friends for a specific user.
     *
     * @param userId The ID of the user for whom to retrieve friends
     * @return List of FriendshipDTOs representing the user's friends
     */
    public List<FriendshipDTO> getUserFriends(Long userId) {
        // Find all accepted friendships for the user
        List<Friendship> friendships = friendshipRepository.findByUserAndStatus(userId, FriendshipStatus.ACCEPTED);

        // Convert friendships to FriendshipDTOs
        return friendships.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert Friendship entity to FriendshipDTO
    private FriendshipDTO convertToDTO(Friendship friendship) {
        FriendshipDTO friendshipDTO = new FriendshipDTO();
        friendshipDTO.setId(friendship.getId());
        friendshipDTO.setUserId(friendship.getUser().getId());
        friendshipDTO.setFriendId(friendship.getFriend().getId());
        friendshipDTO.setStatus(friendship.getStatus());
        return friendshipDTO;
    }

    // Other friendship-related methods can be added as needed
}



