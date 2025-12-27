package com.example.demo.controller;

import com.example.demo.dto.CollaborationEventDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CollaborationController {
    private final CollaborationService service;

    @MessageMapping("/collab/event")
    @SendTo("/topic/workspace")
    public CollaborationEventDto handle(CollaborationEventDto e) {
        service.publishEvent(e);
        return e;
    }
}

