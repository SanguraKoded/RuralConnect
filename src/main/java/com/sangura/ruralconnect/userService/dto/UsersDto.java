package com.sangura.ruralconnect.userService.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UsersDto {
    private String email;

    private String Username;

    private String password;

    private Integer phoneNumber;

    private List<Long> orderedItems;

}
