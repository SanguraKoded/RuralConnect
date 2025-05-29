package com.sangura.ruralconnect.agentService.mappers;

import com.sangura.ruralconnect.agentService.dto.AgentDto;
import com.sangura.ruralconnect.agentService.entities.Agent;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface AgentMapper {

    Agent toEntity(AgentDto agent);
    AgentDto toDTO(AgentDto agentDto);
}
