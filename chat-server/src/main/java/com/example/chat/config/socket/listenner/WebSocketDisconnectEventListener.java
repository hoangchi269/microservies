package com.example.chat.config.socket.listenner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketDisconnectEventListener implements
    ApplicationListener<SessionDisconnectEvent> {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void onApplicationEvent(SessionDisconnectEvent event) {

    logger.info("Socket Disconnect");
  }
}
