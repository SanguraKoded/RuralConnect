package com.sangura.ruralconnect.agentService.services;

import com.sangura.ruralconnect.agentService.dto.AgentDto;
import com.sangura.ruralconnect.agentService.entities.Agent;
import com.sangura.ruralconnect.agentService.enums.Region;
import com.sangura.ruralconnect.orderService.entities.Order;

import java.util.List;

public interface AgentService {

    Agent createAgent(AgentDto agentDto);
    Agent updateAgent(Long id, AgentDto agentDto);

    String deleteAgent(Long id);
    List<Agent> findAgentByRegion(Region region);
    Agent findAgentById(Long id);

    List<Agent> getAllAgents();
}
