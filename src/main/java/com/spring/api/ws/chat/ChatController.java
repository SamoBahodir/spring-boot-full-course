package com.spring.api.ws.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatMessageRepository repository;

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor accessor ) throws InterruptedException {
        accessor.getSessionAttributes().put("username", chatMessage.getSender());
        repository.save(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        repository.save(chatMessage);
        return chatMessage;
    }
//    private void getCaptcha(ChatMessage user) {
//        Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
//        user.setSender(captcha.getAnswer());
//
//    }
}