package com.sangura.ruralconnect.userService.services;

import com.sangura.ruralconnect.userService.dto.UsersDto;
import com.sangura.ruralconnect.userService.entities.Users;
import java.util.List;


public interface UserService {

    Users createUsers(UsersDto usersDto);

    Users updateUsers(Long id, UsersDto usersDto);

    Users findUsersById(Long id);

    List<Users> getAllUsers();

    String deleteUsers(Long id);


}
