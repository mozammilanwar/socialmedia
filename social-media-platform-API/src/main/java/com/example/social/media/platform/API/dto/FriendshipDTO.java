package com.example.social.media.platform.API.dto;

public class FriendshipDTO {

    private Long userId; // the user sending or accepting the friend request
    private Long friendId;

    // getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}

