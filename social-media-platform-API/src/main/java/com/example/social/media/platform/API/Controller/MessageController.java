package com.example.social.media.platform.API.Controller;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        messageService.sendMessage(messageDTO);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<MessageDTO>> getMessages(@PathVariable Long userId) {
        List<MessageDTO> messages = messageService.getUserMessages(userId);
        return ResponseEntity.ok(messages);
    }
}
