package com.example.social.media.platform.API.Controller;

@RestController
@RequestMapping("/api/friendships")
public class FriendshipController {

    @Autowired
    private FriendshipService friendshipService;

    @PostMapping("/send-request")
    public ResponseEntity<String> sendFriendRequest(@RequestBody FriendshipDTO friendshipDTO) {
        friendshipService.sendFriendRequest(friendshipDTO);
        return ResponseEntity.ok("Friend request sent successfully");
    }

    @PostMapping("/accept-request")
    public ResponseEntity<String> acceptFriendRequest(@RequestBody FriendshipDTO friendshipDTO) {
        friendshipService.acceptFriendRequest(friendshipDTO);
        return ResponseEntity.ok("Friend request accepted successfully");
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<FriendshipDTO>> getFriends(@PathVariable Long userId) {
        List<FriendshipDTO> friends = friendshipService.getUserFriends(userId);
        return ResponseEntity.ok(friends);
    }
}
