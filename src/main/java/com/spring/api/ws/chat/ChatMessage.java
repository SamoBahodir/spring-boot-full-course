package com.spring.api.ws.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_message")
public class ChatMessage {
    @Id
    @SequenceGenerator(
            name = "chat_id_sequence",
            sequenceName = "chat_id_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "chat_id_sequence")
    private Long id;

    private String content;

    private String sender;

    @Enumerated(EnumType.STRING)
    private MessageType type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}