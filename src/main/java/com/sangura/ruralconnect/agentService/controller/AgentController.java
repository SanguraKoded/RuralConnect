package com.sangura.ruralconnect.agentService.controller;

import com.sangura.ruralconnect.agentService.dto.AgentDto;
import com.sangura.ruralconnect.agentService.entities.Agent;
import com.sangura.ruralconnect.agentService.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rural-connect")
@RestController
@RequiredArgsConstructor
public class AgentController {
    private final AgentService agentService;

    @GetMapping("/admin/agents")
    public ResponseEntity<List<Agent>> getAllAgents(){
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    @PostMapping("/signup/agent")
    public ResponseEntity<Agent> createAgent(@RequestBody AgentDto agentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(agentService.createAgent(agentDto));
    }

    @PutMapping("/admin/update/agent")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody AgentDto agentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(agentService.updateAgent(id, agentDto));
    }

    @DeleteMapping("/profile/delete")
    public ResponseEntity<String> deleteAgentAccount(@PathVariable Long id){
        return ResponseEntity.ok(agentService.deleteAgent(id));
    }

    
}
