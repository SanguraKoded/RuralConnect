package com.sangura.ruralconnect.agentService.entities;

import com.sangura.ruralconnect.agentService.enums.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agentId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private int phoneNumber;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private List<Long> orders;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Region region;
}
