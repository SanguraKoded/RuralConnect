package com.sangura.ruralconnect.agentService.dto;

import com.sangura.ruralconnect.agentService.enums.Region;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public class AgentDto {

    private String email;

    private String firstName;

    private String LastName;

    private int phoneNumber;

    private String location;

    private List<Long> orders;

    @Enumerated(EnumType.STRING)
    private Region region;
}
