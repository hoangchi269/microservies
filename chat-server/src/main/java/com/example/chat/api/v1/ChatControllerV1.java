package com.example.chat.api.v1;

import com.example.chat.dao.entity.MessageEntity;
import com.example.chat.dao.entity.RoomEntity;
import com.example.chat.service.ChatServiceV1;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ChatControllerV1 {

  private final ChatServiceV1 chatServiceV1;

  @PostMapping("/api/v1/chat")
  @ResponseBody
  public ResponseEntity<?> chat(@RequestBody MessageEntity messageEntity) {
    return ResponseEntity.ok(chatServiceV1.chat(messageEntity));
  }

  @PostMapping("/api/v1/chat/create-room")
  @ResponseBody
  public ResponseEntity<?> createRoom(@RequestBody RoomEntity roomEntity) {
    return ResponseEntity.ok(chatServiceV1.createGroup(roomEntity));
  }

  @PostMapping("/api/v1/chat/join-room")
  @ResponseBody
  public ResponseEntity<?> joinRoom(@RequestBody RoomEntity roomEntity) {
    return ResponseEntity.ok(chatServiceV1.joinRoom(roomEntity));
  }

  @MessageMapping("/send.message")
  public void sendMessage(@Payload MessageEntity messageEntity, Principal principal,
      SimpMessageHeaderAccessor headerAccessor) {
    chatServiceV1.sendMessage(messageEntity);
  }
}
