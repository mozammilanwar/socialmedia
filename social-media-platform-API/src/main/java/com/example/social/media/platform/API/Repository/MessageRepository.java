package com.example.social.media.platform.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // Find messages by sender
    List<Message> findBySender(User sender);

    // Find messages by recipient
    List<Message> findByRecipient(User recipient);

    // Find messages by sender and recipient
    List<Message> findBySenderAndRecipient(User sender, User recipient);

    // Find unread messages for a recipient
    List<Message> findByRecipientAndReadStatus(User recipient, boolean readStatus);

    // Find messages by sender and ordered by timestamp
    List<Message> findBySenderOrderByTimestampDesc(User sender);


}

