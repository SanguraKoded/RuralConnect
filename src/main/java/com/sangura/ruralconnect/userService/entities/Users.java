package com.sangura.ruralconnect.userService.entities;

import com.sangura.ruralconnect.orderService.entities.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String Username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer phoneNumber;

    @Column(nullable = false)
    private List<Long> orderedItems;
}
