package com.example.demo.service;

import com.example.demo.dto.CollaborationEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CollaborationService {
    private final RedisTemplate<String,Object> redis;
    public void publishEvent(CollaborationEventDto e){
        redis.convertAndSend("workspace:"+e.workspaceId,e);
    }
}
