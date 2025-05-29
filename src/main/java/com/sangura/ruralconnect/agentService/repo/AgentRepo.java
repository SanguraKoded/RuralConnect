package com.sangura.ruralconnect.agentService.repo;

import com.sangura.ruralconnect.agentService.entities.Agent;
import com.sangura.ruralconnect.agentService.enums.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentRepo extends JpaRepository<Agent, Long> {
    List<Agent> findAgentByRegion(Region region);
}
