package com.example.social.media.platform.API.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Sends a message based on the provided MessageDTO.
     *
     * @param messageDTO The MessageDTO containing information about the message
     */
    public void sendMessage(MessageDTO messageDTO) {
        // Implementation to send a message
        // Note: Additional logic to handle sending a message, saving it to the repository, etc.
    }

    /**
     * Gets a list of messages for a specific user.
     *
     * @param userId The ID of the user for whom to retrieve messages
     * @return List of MessageDTOs representing the user's messages
     */
    public List<MessageDTO> getUserMessages(Long userId) {
        // Implementation to get a list of user's messages
        List<Message> messages = messageRepository.findByRecipient(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));

        // Convert messages to MessageDTOs
        return messages.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert Message entity to MessageDTO
    private MessageDTO convertToDTO(Message message) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setSender(message.getSender().getId());
        messageDTO.setRecipient(message.getRecipient().getId());
        messageDTO.setContent(message.getContent());

        return messageDTO;
    }


}


