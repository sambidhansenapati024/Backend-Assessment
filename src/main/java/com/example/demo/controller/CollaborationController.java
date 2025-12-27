package com.example.demo.controller;

import com.example.demo.dto.CollaborationEventDto;
import com.example.demo.service.CollaborationService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CollaborationController {

    private final CollaborationService service;

    public CollaborationController(CollaborationService service) {
        this.service = service;
    }

    @MessageMapping("/collab/event")
    @SendTo("/topic/workspace")
    public CollaborationEventDto handle(CollaborationEventDto event) {
        service.publishEvent(event);
        return event;
    }
}
