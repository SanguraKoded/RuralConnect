package com.sangura.ruralconnect.agentService.services;

import com.sangura.ruralconnect.agentService.dto.AgentDto;
import com.sangura.ruralconnect.agentService.entities.Agent;
import com.sangura.ruralconnect.agentService.enums.Region;
import com.sangura.ruralconnect.agentService.mappers.AgentMapper;
import com.sangura.ruralconnect.agentService.repo.AgentRepo;
import com.sangura.ruralconnect.orderService.entities.Order;
import com.sangura.ruralconnect.orderService.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final AgentRepo agentRepo;

    private final AgentMapper agentMapper;

    @Override
    @Transactional
    public Agent createAgent(AgentDto agentDto){
        Agent agent = agentMapper.toEntity(agentDto);
        return agentRepo.save(agent);
    }

    @Override
    @Transactional
    public Agent updateAgent(Long id, AgentDto agentDto){
        Agent agent = agentRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Agent ID"));
        Agent agent1=agentMapper.toEntity(agentDto);
        agent.setEmail(agent1.getEmail());
        agent.setLocation(agent1.getLocation());
        agent.setRegion(agent1.getRegion());
        agent.setFirstName(agent1.getFirstName());
        agent.setPhoneNumber(agent1.getPhoneNumber());
        return agentRepo.save(agent);
    }

    @Override
    @Transactional
    public String deleteAgent(Long id) {
        agentRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Agent ID"));
        agentRepo.deleteById(id);
        return ("Successfully Deleted");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Agent> findAgentByRegion(Region region) {
        try {
            List<Agent> agents = agentRepo.findAgentByRegion(region).stream().sorted(Comparator.comparing(Agent::getFirstName)).collect(Collectors.toList());
            if(agents==null || agents.isEmpty()){
                throw new RuntimeException("No registered Agent in the Region");
            }
            return agents;
        }catch(Exception e){
            throw new RuntimeException("Unexpected Error Occurred"+e.getMessage());
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Agent findAgentById(Long id) {
        return agentRepo.findById(id).orElseThrow(()-> new RuntimeException("Please Enter Correct Agent ID"));
    }

    @Override
    @Transactional
    public List<Agent> getAllAgents() {
        return agentRepo.findAll();
    }


}
